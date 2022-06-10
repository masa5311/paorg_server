package com.paorg.paorg_server.valueobject;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class TrainerShozokuPlace implements Serializable {

  private String value;

  public TrainerShozokuPlace(String value) {
    this.value = value;
  }

  public TrainerShozokuPlace() {

  }
}
