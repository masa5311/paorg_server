package com.paorg.paorg_server.repository;

import com.paorg.paorg_server.entity.Owner;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.List;

@SpringBootTest
// 遅延ロードを可能とするためのトランザクション境界指定
@Transactional
class OwnerRepositoryTests {

  // 当該クラスの単体テストのみを行いたい場合（他クラスをモック化）：@InjectMocksを有効化
  // 結合テストのみ行いたい場合：@Autowiredを有効化
  // @InjectMocks
  @Autowired
  private OwnerRepository target;

  @Test
  public void testFindAll() {

    List<Owner> ownerList = this.target.findAll();

    System.out.println(ownerList);

  }

  // @Test
  // public void testFindByGroupId() {
  //
  //   List<GroupUser> groupUserList =
  //     this.target.findByGroupId().orElse(new ArrayList<>());
  //
  //   System.out.println(groupUserList);
  //
  // }

}
