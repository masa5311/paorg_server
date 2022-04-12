package com.paorg.paorg_server.repository;

import com.paorg.paorg_server.domain.TestDomain;
import com.paorg.paorg_server.entity.User;
import com.paorg.paorg_server.service.TestService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
// 遅延ロードを可能とするためのトランザクション境界指定
@Transactional
class UserRepositoryTests {

  // 当該クラスの単体テストのみを行いたい場合（他クラスをモック化）：@InjectMocksを有効化
  // 結合テストのみ行いたい場合：@Autowiredを有効化
  // @InjectMocks
  @Autowired
  private UserRepository target;

  @Test
  public void testFindAll() {

    List<User> userList = this.target.findAll();

    // assertEquals(target.getId(), result.getId());
    System.out.println(userList);

  }

  // @Test
  // public void testFindByIdWithNominationListByYear() {
  //
  //   List<User> userList =
  //     this.target.findWithNominationListByYear(2021).orElse(new ArrayList<>());
  //
  //   // assertEquals(target.getId(), result.getId());
  //   System.out.println(userList);
  //
  // }

}
