package com.paorg.paorg_server.domain;

import com.paorg.paorg_server.repository.TestRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class TestDomainTests {

  // 当該クラスの単体テストのみを行いたい場合（他クラスをモック化）：@InjectMocksを有効化
  // 結合テストのみ行いたい場合：@Autowiredを有効化
  // @InjectMocks
  @Autowired
  private TestDomain target;

  @Autowired
  private TestRepository testRepository;

  @Test
  public void testRegister() {

    long beforeCount = this.testRepository.count();

    this.target.register("testRegister");

    // long afterCount = this.testRepository.count();
    List<com.paorg.paorg_server.entity.Test> testList = this.testRepository.findAll();

    assertEquals(beforeCount + 1, testList.size());
    System.out.println(testList);

  }

}
