package com.paorg.paorg_server.repository;

import com.paorg.paorg_server.bean.OwnerBean;
import com.paorg.paorg_server.entity.Group;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
// 遅延ロードを可能とするためのトランザクション境界指定
@Transactional
class GroupRepositoryTests {

  // 当該クラスの単体テストのみを行いたい場合（他クラスをモック化）：@InjectMocksを有効化
  // 結合テストのみ行いたい場合：@Autowiredを有効化
  // @InjectMocks
  @Autowired
  private GroupRepository target;

  @Test
  public void testFindAll() {

    List<Group> groupList = this.target.findAll();

    System.out.println(groupList);

  }

  @Test
  public void testFindByGroupIdWithPoint() {

    List<OwnerBean> groupList = this.target.findByGroupIdWithPoint(1, 2021)
      .orElse(new ArrayList<>());

    System.out.println(groupList);

  }
}
