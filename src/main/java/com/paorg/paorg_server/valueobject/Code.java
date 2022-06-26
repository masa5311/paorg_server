package com.paorg.paorg_server.valueobject;

import java.io.Serializable;

/**
 * コード
 */
public class Code extends ValueObjectBase<String> implements Serializable {
  public Code(String value) {
    super(value);
  }
}
