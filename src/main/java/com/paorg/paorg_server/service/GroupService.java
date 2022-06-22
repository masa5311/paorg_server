package com.paorg.paorg_server.service;

import com.paorg.paorg_server.bean.NominationBean;
import com.paorg.paorg_server.bean.OwnerBean;
import com.paorg.paorg_server.bean.RaceResultBean;
import com.paorg.paorg_server.common.PropertyName;
import com.paorg.paorg_server.domain.GroupDomain;
import com.paorg.paorg_server.domain.NominationDomain;
import com.paorg.paorg_server.domain.OwnerDomain;
import com.paorg.paorg_server.valueobject.Point;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * グループサービス
 */
@Service
@Transactional
@RequiredArgsConstructor
public class GroupService {

  private final GroupDomain groupDomain;
  private final OwnerDomain ownerDomain;
  private final NominationDomain nominationDomain;

  /**
   * グループ内オーナー別ポイント取得
   * ■条件
   * ・グループID
   * ・年度
   *
   * ■内容
   * １．オーナー別ポイント取得
   * ２．ランキング判定
   * １．取得したオーナーリストを先頭から判定
   * 　１．1件目
   * ・順位：1位
   * ・ランキング保持
   * ・ポイント保持
   * 　２．2件目以降
   * 　　１．保持しているポイントと同じ場合
   * ・順位：保持していたポイントの順位
   * ２．保持しているポイントと異なる場合
   * ・順位：ループのインデックス + 1
   * ・保持ランキング更新：ループのインデックス + 1
   * ・保持ポイント更新
   *
   * @param input Json：検索条件
   * @return グループ内オーナー別ポイントJson文字列
   */
  @SneakyThrows
  public String findOwnerListWithPoint(String input) {

    Integer groupId = PropertyName.GROUP_ID.getValueFromJson(input);
    Integer year = PropertyName.YEAR.getValueFromJson(input);

    // １．オーナー別ポイント取得
    List<OwnerBean> ownerBeanList = ownerDomain.findByGroupIdWithPoint(
      groupId, year);

    // ２．ランキング判定
    OwnerBean ownerBean = null;
    Integer previousRanking = 0;
    Point previousPoint = null;
    Point point = null;
    for (int i = 0; i < ownerBeanList.size(); i++) {
      ownerBean = ownerBeanList.get(i);
      if (previousPoint != null) {
        point = ownerBean.getPoint();
        if (previousPoint.equals(point)) {
          ownerBean.setRanking(previousRanking);
        } else {
          ownerBean.setRanking(i + 1);
          previousRanking = i + 1;
          previousPoint = point;
        }
      } else {
        ownerBean.setRanking(1);
        previousRanking = 1;
        previousPoint = ownerBean.getPoint();
      }
    }

    return ownerBeanList.toString();
  }

  /**
   * グループ内オーナー別指名馬リスト取得
   * ■条件
   * ・グループID
   * ・年度
   *
   * ■内容
   * ・グループIDと年度を元に指名馬リストを取得
   * ・取得した指名馬ごとに下記取得
   * ・レース出走回数
   * ・ポイント合計
   * ・レース結果
   *
   * @param input Json：検索条件
   * @return グループ内オーナー別指名馬一覧Json文字列
   */
  @SneakyThrows
  public String findOwnerListWithNomination(String input) {

    Integer groupId = PropertyName.GROUP_ID.getValueFromJson(input);
    Integer year = PropertyName.YEAR.getValueFromJson(input);
    List<OwnerBean> ownerBeanList = ownerDomain.findOwnerListWithNomination(
      groupId, year);

    // オーナーごとに処理
    ownerBeanList.forEach(ownerBean -> {
      // 指名馬ごとにレース出走回数とポイントを取得
      ownerBean.getNominationList().forEach(nominationBean -> {
        Integer nominationId = nominationBean.getId();
        NominationBean nominationPointSum =
          this.nominationDomain.findByNominationPoint(groupId, nominationId)
            .orElse(new NominationBean(nominationId, 0L, 0L));

        // レース回数
        nominationBean.setNumberOfRaces(nominationPointSum.getNumberOfRaces());

        // レース出走済でポイントがない場合、pointがnullで格納されているため0に変換
        Long point = nominationPointSum.getPoint() == null ? 0L : nominationPointSum.getPoint();
        nominationBean.setPoint(new Point(point));

        // レース結果
        List<RaceResultBean> raceResultBeanList = this.nominationDomain.findByNominationIdOfRaceResult(
          groupId, nominationId).orElse(new ArrayList<>());
        nominationBean.setRaceResultList(raceResultBeanList);
      });
    });

    return ownerBeanList.toString();

  }
}
