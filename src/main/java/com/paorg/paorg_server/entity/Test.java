package com.paorg.paorg_server.entity;

import com.paorg.paorg_server.entity.type.EnumTestType;
import lombok.*;

import javax.persistence.*;

@Table(name = "test")
@Entity
@Getter
// @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Test extends TableEntityBase {
  @Column(name = "name", nullable = false)
  private String name;

  @Enumerated(EnumType.STRING)
  @Column(name = "enum_test", nullable = false)
  private EnumTestType enumTest;

  public void setEnumTest(EnumTestType enumTest) {
    this.enumTest = enumTest;
  }

}