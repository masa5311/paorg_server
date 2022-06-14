package com.paorg.paorg_server.valueobject;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ValueObjectBaseTest {

  @Test
  public void testYear() {
    Year targetInteger = new Year(2022);

    Integer resultInteger = targetInteger.getValue();
    System.out.println(resultInteger);
  }

}
