package com.paorg.paorg_server.service;

import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.paorg.paorg_server.bean.TestBean;
import com.paorg.paorg_server.domain.TestDomain;
import com.paorg.paorg_server.entity.Test;
import com.paorg.paorg_server.entity.type.EnumTestType;
import com.paorg.paorg_server.repository.TestRepository;
import com.paorg.paorg_server.valueobject.Id;
import com.paorg.paorg_server.valueobject.Name;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * ・集約を横断する処理をまとめる
 * ・トランザクション管理
 */
@Service
@Transactional
@RequiredArgsConstructor
public class TestService {

  @PersistenceContext
  private EntityManager em;
  private final TestRepository repository;

  private final TestDomain testDomain;

  /**
   * EntityManagerを使った登録
   *
   * @param name
   */
  public void register(String name) {
    // Test test = new Test(name);
    // test.setName(name);

    // this.em.persist(test);
    // TestDomain testDomain = new TestDomain(name);
    // TestDomain testDomain = new TestDomain(this.em, "テスト4");
    testDomain.register(name);
  }

  /**
   * EntityManagerを使った更新
   *
   * @param id
   * @param name
   */
  public void update(Integer id, String name) {
    // Test test = em.find(Test.class, id);
    // test.setName(name);
  }

  /**
   * EntityManagerを使った削除
   *
   * @param id
   */
  public void delete(Integer id) {
    Test test = em.find(Test.class, id);
    em.remove(test);
  }

  /**
   * repositoryを使った全件検索
   *
   * @return
   */
  public List<TestBean> findAll() {

    // testDomain.toEntity();

    List<Test> resultLiset = this.repository.findAll();
    List<TestBean> testBeanList = new ArrayList<>();
    TestBean testBean = null;
    for (Test test : resultLiset) {
      // testBean = new TestBean(test.getId(), test.getName());
      testBean = new TestBean(test);
      testBeanList.add(testBean);
    }
    return testBeanList;
  }

}
