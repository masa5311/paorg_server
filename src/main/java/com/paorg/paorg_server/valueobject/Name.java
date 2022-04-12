package com.paorg.paorg_server.valueobject;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.io.Serializable;

// @Embeddable
@Getter
@Setter
public class Name implements Serializable {

  private String value;

  public Name(String value) {
    this.value = value;
  }

  public Name() {

  }
}
