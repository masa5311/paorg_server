package com.paorg.paorg_server.valueobject;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
public class TestId implements Serializable {

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Integer id;

  public TestId(int id) {
    this.id = id;
  }

  protected TestId() {
  }
}
