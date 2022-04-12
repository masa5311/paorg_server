package com.paorg.paorg_server.domain;

import com.paorg.paorg_server.bean.UserBean;
import com.paorg.paorg_server.entity.GroupWithOwnerWithUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Transactional
class GroupDomainTests {

  // 当該クラスの単体テストのみを行いたい場合（他クラスをモック化）：@InjectMocksを有効化
  // 結合テストのみ行いたい場合：@Autowiredを有効化
  // @InjectMocks
  @Autowired
  private GroupDomain target;

  @Test
  public void testFindList() {
    GroupWithOwnerWithUser result = this.target.findOwnerListWithRanking(1);
    assertNotNull(result);
    System.out.println(result);
  }

}
