package com.paorg.paorg_server.domain;

import com.paorg.paorg_server.bean.BeanInterface;
import com.paorg.paorg_server.bean.NominationBean;
import com.paorg.paorg_server.entity.type.NominationStatus;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class NominationDomainTests {

  // 当該クラスの単体テストのみを行いたい場合（他クラスをモック化）：@InjectMocksを有効化
  // 結合テストのみ行いたい場合：@Autowiredを有効化
  // @InjectMocks
  @Autowired
  private NominationDomain target;

  // @Test
  // public void testFindList() {
  //   List<NominationBean> result = this.target.findList();
  //   assertNotNull(result);
  // }

  // @Test
  // public void testFindNominationList() {
  //   List<NominationBean> result = this.target.findNominationList(1, 2021,
  //     NominationStatus.confirming);
  //   assertNotNull(result);
  //   System.out.println(result);
  // }
  //
  // @Test
  // public void testFindNominationListByIdAndYear() {
  //   List<BeanInterface> result = this.target.findNominationListByIdAndYear(1,
  //     2021);
  //   assertNotNull(result);
  //   System.out.println(result);
  // }

}
