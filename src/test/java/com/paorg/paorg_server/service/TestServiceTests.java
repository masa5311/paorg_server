package com.paorg.paorg_server.service;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.paorg.paorg_server.bean.Member;
import com.paorg.paorg_server.bean.NominationBean;
import com.paorg.paorg_server.bean.TestBean;
import com.paorg.paorg_server.domain.TestDomain;
import com.paorg.paorg_server.entity.Nomination;
import com.paorg.paorg_server.entity.type.EnumTestType;
import com.paorg.paorg_server.valueobject.Id;
import com.paorg.paorg_server.valueobject.Name;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.*;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class TestServiceTests {

  @Mock
  private TestDomain testDomain;

  // 当該クラスの単体テストのみを行いたい場合（他クラスをモック化）：@InjectMocksを有効化
  // 結合テストのみ行いたい場合：@Autowiredを有効化
  // @InjectMocks
  @Autowired
  private TestService target;

  @Test
  public void testRegister() {

    // Test entity = new Test();
    this.target.register("testRegister");

    // assertEquals(target.getId(), result.getId());

  }

  @Test
  public void testCsvWrite() throws JsonProcessingException {
    // TestBean testBean = new TestBean(new Id(1), new Name("テスト"),
    //   EnumTestType.aaa);
    // List<TestBean> testBeanList = new ArrayList<>();
    // testBeanList.add(testBean);
    // testBeanList.add(testBean);

    List<Member> members = new ArrayList<Member>();
    members.add(new Member(1L, "user01", "プロフィール１", new Date()));
    members.add(new Member(2L, "user02", "プロフィール２", new Date()));

    System.out.println(members);

    CsvMapper mapper = new CsvMapper();
    // mapper.configure(JsonGenerator.Feature.IGNORE_UNKNOWN, true);
    String csvText = mapper.writer().writeValueAsString(members);

    System.out.println(csvText);
    // this.target.csvWrite();;
  }

}
