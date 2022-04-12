package com.paorg.paorg_server.domain;

import com.paorg.paorg_server.entity.GroupWithOwnerWithUser;
import com.paorg.paorg_server.repository.GroupWithOwnerWithUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * グループドメイン
 */
@Component
@AllArgsConstructor
public class GroupDomain implements DomainInterface {

  @PersistenceContext
  private final EntityManager em;
  private final GroupWithOwnerWithUserRepository repository;

  public GroupWithOwnerWithUser findOwnerListWithRanking(Integer groupId) {
    return this.repository.findById(groupId)
      .orElse(new GroupWithOwnerWithUser());
  }

}
