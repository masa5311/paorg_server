package com.paorg.paorg_server.valueobject;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.io.Serializable;

// @Embeddable
@Getter
@Setter
public class FirebaseId implements Serializable {

  private String value;

  public FirebaseId(String value) {
    this.value = value;
  }

  public FirebaseId() {

  }
}
