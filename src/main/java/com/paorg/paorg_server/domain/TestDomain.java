package com.paorg.paorg_server.domain;

import com.paorg.paorg_server.entity.type.EnumTestType;
import com.paorg.paorg_server.entity.Test;
import com.paorg.paorg_server.repository.TestRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


/**
 * Testの集約ルートドメイン
 * ・Test集約の処理（編集、永続化等）を統括する
 */
// @Service
// @NoArgsConstructor
// @Transactional
// @RequiredArgsConstructor
// @ComponentScan
@Component
@AllArgsConstructor
public class TestDomain {

  @PersistenceContext
  private final EntityManager em;
  private TestRepository repository;

  public void register(String name) {
    // Test test = new Test(this.name.getName());
    Test test = Test.builder().name(name).enumTest(EnumTestType.aaa).build();

    this.em.persist(test);

  }

}
