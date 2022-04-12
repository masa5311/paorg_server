package com.paorg.paorg_server.entity.type;

import lombok.Getter;

@Getter
public enum EnumTestType {

  aaa("aaaaa", 1),
  bbb("bbbbb", 2),
  ;

  private final String label;
  private final Integer id;

  private EnumTestType(String label, Integer id) {
    this.label = label;
    this.id = id;
  }
}
