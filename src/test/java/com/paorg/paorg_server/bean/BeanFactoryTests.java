package com.paorg.paorg_server.bean;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.paorg.paorg_server.entity.type.EnumTestType;
import com.paorg.paorg_server.valueobject.Id;
import com.paorg.paorg_server.valueobject.Name;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

@SpringBootTest
class BeanFactoryTests {

  @Test
  public void testConvert() throws JsonProcessingException {
    // 準備
    TestBean fromBean = new TestBean(new Id(1), new Name("testConvert"),
      EnumTestType.aaa);

    // 実行
    com.paorg.paorg_server.entity.Test result = BeanFactory.convert(fromBean,
      com.paorg.paorg_server.entity.Test.class);

    // 検証
    assertEquals(1, result.getId());
    assertEquals("testConvert", result.getName());
    assertEquals(EnumTestType.aaa, result.getEnumTest());
  }

}
