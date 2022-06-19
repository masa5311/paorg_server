package com.paorg.paorg_server.domain;

import com.paorg.paorg_server.bean.OwnerBean;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Transactional
class OwnerDomainTests {

  // 当該クラスの単体テストのみを行いたい場合（他クラスをモック化）：@InjectMocksを有効化
  // 結合テストのみ行いたい場合：@Autowiredを有効化
  // @InjectMocks
  @Autowired
  private OwnerDomain target;

  @Test
  public void testFindOwnerListWithNomination() {
    List<OwnerBean> result = this.target.findOwnerListWithNomination(1
      , 2021);
    assertNotNull(result);
    System.out.println(result);
    System.out.println(result.get(0).getNominationBeanList().get(0).getHorseName());

  }

}
