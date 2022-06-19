package com.paorg.paorg_server.valueobject;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ValueObjectBaseTests {

  @Test
  void testEqualsString不一致() {
    Name name1 = new Name("名前１");
    Name name2 = new Name("名前２");

    assertFalse(name1.equals(name2));

  }

  @Test
  void testEqualsString一致() {
    Name name1 = new Name("名前１");
    Name name2 = new Name("名前１");

    assertTrue(name1.equals(name2));

  }

  @Test
  public void testYear() {
    Year targetInteger = new Year(2022);

    Integer resultInteger = targetInteger.getValue();
    System.out.println(resultInteger);
  }

}
