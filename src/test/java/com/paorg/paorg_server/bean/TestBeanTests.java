package com.paorg.paorg_server.bean;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.paorg.paorg_server.entity.type.EnumTestType;
import com.paorg.paorg_server.valueobject.Id;
import com.paorg.paorg_server.valueobject.Name;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TestBeanTests {

  private TestBean target;

  @Test
  public void testTest() {
    TestBean bean = new TestBean(new Id(1), new Name("テスト"),
      EnumTestType.aaa);

    // 同じ値であることを確認
    assertEquals("テスト", bean.getName());

    // 同じインスタンスであることを確認
    assertSame("テスト", bean.getName());
  }

  @Test
  public void testToEntity() throws JsonProcessingException {
    // 準備
    this.target = new TestBean(new Id(1), new Name("testToEntity"),
      EnumTestType.aaa);

    // 実行
    com.paorg.paorg_server.entity.Test result = (com.paorg.paorg_server.entity.Test) this.target.toEntity();

    // 検証
    assertEquals(1, result.getId());
    assertEquals("testToEntity", result.getName());
    assertEquals(EnumTestType.aaa, result.getEnumTest());


  }
}
