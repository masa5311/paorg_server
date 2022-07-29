package com.paorg.paorg_server.domain;

import com.paorg.paorg_server.repository.GroupRepository;
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
  private final GroupRepository repository;

}
