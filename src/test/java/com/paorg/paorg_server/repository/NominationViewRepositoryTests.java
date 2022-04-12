package com.paorg.paorg_server.repository;

import com.paorg.paorg_server.entity.NominationView;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
// 遅延ロードを可能とするためのトランザクション境界指定
@Transactional
class NominationViewRepositoryTests {

  // 当該クラスの単体テストのみを行いたい場合（他クラスをモック化）：@InjectMocksを有効化
  // 結合テストのみ行いたい場合：@Autowiredを有効化
  // @InjectMocks
  @Autowired
  private NominationViewRepository target;

  @Test
  public void testFindByUserIdAndYearAndConfirmed() {

    List<NominationView> nominationViewList =
      this.target.findByUserIdAndYearAndConfirmed().orElse(new ArrayList<>());

    System.out.println(nominationViewList);
  }

}
