package com.paorg.paorg_server.domain;

import com.paorg.paorg_server.bean.NominationBean;
import com.paorg.paorg_server.repository.NominationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

/**
 * 指名馬ドメイン
 */
@Component
@AllArgsConstructor
public class NominationDomain implements DomainInterface {

  @PersistenceContext
  private final EntityManager em;
  private final NominationRepository repository;

  /**
   * 指名馬ごとのレース出走回数、ポイントを取得
   * ・レース未出走の場合：null
   * 
   * @param groupId グループID
   * @param nominationId 指名馬ID
   * @return レース出走回数、ポイント
   */
  public Optional<NominationBean> findByNominationPoint(Integer groupId, Integer nominationId) {
    return this.repository.findByNominationNumberOfRacesAndPoint(groupId, nominationId);
  }

  // public List<NominationBean> findList() {
  //   List<Nomination> nominationList = this.repository.findAll();
  //   List<NominationBean> nominationBeanList = new ArrayList<>();
  //
  //   // 指名Beanリストに変換
  //   nominationList.forEach(
  //     entity -> nominationBeanList.add(new NominationBean(entity)));
  //
  //   return nominationBeanList;
  // }

  // public List<NominationBean> findNominationList(Integer userId, Integer year,
  //   NominationStatus status) {
  //   List<Nomination> nominationList =
  //     this.repository.findByUserIdAndYearAndNominationStatus(userId, year,
  //       status).orElse(new ArrayList<>());
  //
  //   List<NominationBean> nominationBeanList = new ArrayList<>();
  //   nominationList.forEach(
  //     entity -> nominationBeanList.add(new NominationBean(entity)));
  //
  //   return nominationBeanList;
  // }

  // /**
  //  * 指名馬リスト取得（ユーザー別、年度別）
  //  * @param userId ユーザーID
  //  * @param year 年度
  //  * @return 指名馬Beanリスト
  //  */
  // public List<BeanInterface> findNominationListByIdAndYear(Integer userId,
  //   Integer year) {
  //   List<Nomination> nominationList =
  //     this.repository.findByUserIdAndYearAndNominationStatus(userId, year,
  //       NominationStatus.confirming).orElse(new ArrayList<>());
  //
  //   List<BeanInterface> nominationBeanList = new ArrayList<>();
  //   nominationList.forEach(
  //     entity -> nominationBeanList.add(new NominationBean(entity)));
  //
  //   return nominationBeanList;
  // }

  // public String findNominationListByIdAndYearString(Integer userId,
  //   Integer year) {
  //   List<Nomination> nominationList =
  //     this.repository.findByUserIdAndYearAndNominationStatus(userId, year,
  //       NominationStatus.confirmed).orElse(new ArrayList<>());
  //
  //   return nominationList.toString();
  // }
}
