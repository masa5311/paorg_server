package com.paorg.paorg_server.valueobject;

import java.io.Serializable;

/**
 * 年度
 */
public class Year extends ValueObjectBase<Integer> implements Serializable {
  public Year(Integer value) {
    super(value);
  }

}
