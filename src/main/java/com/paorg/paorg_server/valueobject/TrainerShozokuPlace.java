package com.paorg.paorg_server.valueobject;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 調教師所属
 */
public class TrainerShozokuPlace extends ValueObjectBase<String> implements
  Serializable {

  public TrainerShozokuPlace(String value) {
    super(value);
  }
}
