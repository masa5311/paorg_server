package com.paorg.paorg_server.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

@SpringBootTest
// 遅延ロードを可能とするためのトランザクション境界指定
@Transactional
class NominationRepositoryTests {

  // 当該クラスの単体テストのみを行いたい場合（他クラスをモック化）：@InjectMocksを有効化
  // 結合テストのみ行いたい場合：@Autowiredを有効化
  // @InjectMocks
  @Autowired
  private NominationRepository target;

  // @Test
  // public void testFindByYearAndNominationStatus() {
  //
  //   List<Nomination> nominationList = this.target.findByYearAndNominationStatus(
  //     2021, NominationStatus.confirming).orElse(new ArrayList<>());
  //
  //   // assertEquals(target.getId(), result.getId());
  //   System.out.println(nominationList);
  //
  // }

  // @Test
  // public void testFindByUserIdAndYearAndConfirmed() {
  //   List<NominationWithHorse> nominationWithHorseList =
  //     this.target.findByUserIdAndYearAndConfirmed().orElse(new ArrayList<>());
  //
  //   System.out.println(nominationWithHorseList);
  // }

  // @Test
  // public void testFindByOwnerIdWithPoint() {
  //   List<NominationBean> nominationBeanList = this.target.findByOwnerIdWithPoint(
  //     5, 2022).orElse(new ArrayList<>());
  //
  //   System.out.println(nominationBeanList);
  // }

  @Test
  public void testFindByNominationPoint() {
    Long point = this.target.findByNominationPoint(1, 475).orElse(0L);
    System.out.println(point);
  }

}
