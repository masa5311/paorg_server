package com.paorg.paorg_server.service;

import com.paorg.paorg_server.bean.OwnerBean;
import com.paorg.paorg_server.common.PropertyName;
import com.paorg.paorg_server.domain.GroupDomain;
import com.paorg.paorg_server.domain.NominationDomain;
import com.paorg.paorg_server.domain.OwnerDomain;
import com.paorg.paorg_server.valueobject.Point;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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
   * グループ内オーナー別ポイント情報取得
   * ・グループ指定
   * ・年度指定
   *
   * @param input Json
   * @return グループ内オーナー別ポイント情報Json文字列
   */
  @SneakyThrows
  public String findOwnerListWithPoint(String input) {

    Integer groupId = PropertyName.GROUP_ID.getValueFromJson(input);
    Integer year = PropertyName.YEAR.getValueFromJson(input);

    return ownerDomain.findByGroupIdWithPoint(groupId, year).toString();
  }

  /**
   * グループ内オーナー別指名馬リスト取得
   * ■条件
   * ・グループID
   * ・年度
   *
   * ■内容
   * ・グループIDと年度を元に指名馬リストを取得
   * ・取得した指名馬ごとのポイントを取得
   *
   * @param input Json
   * @return グループ内オーナー別指名馬一覧Json文字列
   */
  @SneakyThrows
  public String findOwnerListWithNomination(String input) {

    Integer groupId = PropertyName.GROUP_ID.getValueFromJson(input);
    Integer year = PropertyName.YEAR.getValueFromJson(input);
    List<OwnerBean> ownerBeanList = ownerDomain.findOwnerListWithNomination(
      groupId, year);
    ownerBeanList.forEach(ownerBean -> {
      ownerBean.getNominationBeanList().forEach(nominationBean -> {
        Integer nominationId = nominationBean.getId();
        Long point = this.nominationDomain.findByNominationPoint(groupId,
          nominationId);
        nominationBean.setPoint(new Point(point));
      });
    });

    return ownerBeanList.toString();

  }
}
