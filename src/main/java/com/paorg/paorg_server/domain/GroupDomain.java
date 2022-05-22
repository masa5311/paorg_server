package com.paorg.paorg_server.domain;

import com.paorg.paorg_server.bean.OwnerBean;
import com.paorg.paorg_server.repository.GroupRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

/**
 * グループドメイン
 */
@Component
@AllArgsConstructor
public class GroupDomain implements DomainInterface {

  @PersistenceContext
  private final EntityManager em;
  // private final GroupWithOwnerWithUserRepository repository;
  private final GroupRepository repository;

  // public GroupWithOwnerWithUser findOwnerListWithRanking(Integer groupId) {
  //   return this.repository.findById(groupId)
  //     .orElse(new GroupWithOwnerWithUser());
  // }

  /**
   * グループIDを元にオーナーを検索する
   * ・年度を指定
   * ・オーナーごとのポイントを取得する
   * @param groupId グループID
   * @param year 年度
   * @return オーナーリスト
   */
  public List<OwnerBean> findByGroupIdWithPoint(Integer groupId, Integer year) {
    return this.repository.findByGroupIdWithPoint(groupId, year).orElse(new ArrayList<>());
  }

}
