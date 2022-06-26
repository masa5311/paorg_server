package com.paorg.paorg_server.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "race_condition")
public class RaceCondition {
  @Id
  @Column(name = "code", nullable = false, length = 3)
  private String code;

  @Column(name = "value", nullable = false)
  private String value;

}