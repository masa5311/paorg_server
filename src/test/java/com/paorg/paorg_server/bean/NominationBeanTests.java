package com.paorg.paorg_server.bean;

import com.paorg.paorg_server.entity.BreedingHorse;
import com.paorg.paorg_server.entity.Crop;
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
  public void testToString() {
    Crop crop = new Crop();
    crop.setId(1234567890);
    BreedingHorse dam = new BreedingHorse();
    dam.setName("dam");
    crop.setDam(dam);
    target = new NominationBean(1, 5L, 10000L);

    System.out.println(target.toString());
  }

}
