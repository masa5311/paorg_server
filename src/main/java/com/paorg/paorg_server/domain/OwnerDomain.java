package com.paorg.paorg_server.domain;

import com.paorg.paorg_server.bean.OwnerBean;
import com.paorg.paorg_server.entity.Owner;
import com.paorg.paorg_server.repository.OwnerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

/**
 * オーナードメイン
 */
@Component
@AllArgsConstructor
public class OwnerDomain {

  @PersistenceContext
  private final EntityManager em;
  private final OwnerRepository repository;

  /**
   * グループIDを元にオーナーを取得
   * ■条件
   * ・グループID
   * ・年度を指定
   * ■内容
   * ・オーナーごとのポイントを取得
   *
   * @param groupId グループID
   * @param year    年度
   * @return オーナーリスト
   */
  public List<OwnerBean> findByGroupIdWithPoint(Integer groupId, Integer year) {
    return this.repository.findByGroupIdWithPoint(groupId, year)
      .orElse(new ArrayList<>());
  }

  /**
   * グループ内の各オーナー別指名馬一覧を取得する
   *
   * @param groupId グループID
   * @param year    年度
   * @return オーナー別指名馬一覧
   */
  public List<OwnerBean> findOwnerListWithNomination(Integer groupId,
    Integer year) {

    List<Owner> ownerList = this.repository.findOwnerListWithNomination(groupId,
      year);
    List<OwnerBean> ownerBeanList = new ArrayList<>();
    ownerList.forEach(owner -> {
      OwnerBean ownerBean = new OwnerBean(owner);
      ownerBeanList.add(ownerBean);
    });
    return ownerBeanList;
  }

}
