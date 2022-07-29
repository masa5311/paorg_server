package com.paorg.paorg_server.valueobject;

import java.io.Serializable;

/**
 * 名前
 */
public class Name extends ValueObjectBase<String> implements Serializable {

  public Name(String value) {
    super(value);
  }

}
