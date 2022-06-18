package com.paorg.paorg_server.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.paorg.paorg_server.bean.Member;
import com.paorg.paorg_server.domain.TestDomain;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootTest
@Transactional
class GroupServiceTests {

  // 当該クラスの単体テストのみを行いたい場合（他クラスをモック化）：@InjectMocksを有効化
  // 結合テストのみ行いたい場合：@Autowiredを有効化
  // @InjectMocks
  @Autowired
  private GroupService target;

  @Test
  void testFindOwnerListWithPoint() {
    String result = this.target.findOwnerListWithPoint("{\"groupId\": 1," +
      "\"year\": 2022}");

    System.out.println(result);
  }

  @Test
  public void testFindOwnerListWithNomination() {

    String result = this.target.findOwnerListWithNomination("{\"groupId\": 1," +
      "\"year\": 2021}");

    System.out.println(result);

  }

  // @Test
  // public void testCsvWrite() throws JsonProcessingException {
  //   // TestBean testBean = new TestBean(new Id(1), new Name("テスト"),
  //   //   EnumTestType.aaa);
  //   // List<TestBean> testBeanList = new ArrayList<>();
  //   // testBeanList.add(testBean);
  //   // testBeanList.add(testBean);
  //
  //   List<Member> members = new ArrayList<Member>();
  //   members.add(new Member(1L, "user01", "プロフィール１", new Date()));
  //   members.add(new Member(2L, "user02", "プロフィール２", new Date()));
  //
  //   System.out.println(members);
  //
  //   CsvMapper mapper = new CsvMapper();
  //   // mapper.configure(JsonGenerator.Feature.IGNORE_UNKNOWN, true);
  //   String csvText = mapper.writer().writeValueAsString(members);
  //
  //   System.out.println(csvText);
  //   // this.target.csvWrite();;
  // }
  //
}
