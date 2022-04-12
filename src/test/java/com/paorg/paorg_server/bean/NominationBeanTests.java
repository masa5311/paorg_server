package com.paorg.paorg_server.bean;

import com.paorg.paorg_server.entity.EntityInterface;
import com.paorg.paorg_server.entity.Nomination;
import com.paorg.paorg_server.valueobject.Id;
import com.paorg.paorg_server.valueobject.Name;
import com.paorg.paorg_server.valueobject.TestId;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

@SpringBootTest
class NominationBeanTests {

  private NominationBean target;

  @Test
  public void testToEntity() {
    // target = new NominationBean(new Id(1), new Name("テスト"));
    // Nomination result = (Nomination) this.target.toEntity();

    // assertEquals(target.getId(), result.getId());

  }

}
