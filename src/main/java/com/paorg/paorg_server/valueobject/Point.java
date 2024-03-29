package com.paorg.paorg_server.valueobject;

import java.io.Serializable;

/**
 * ポイント
 */
public class Point extends ValueObjectBase<Long> implements Serializable {
  public Point(Long value) {
    super(value);
  }

  public Point(Integer value) {
    super(value == null ? 0L : value.longValue());
  }
}
