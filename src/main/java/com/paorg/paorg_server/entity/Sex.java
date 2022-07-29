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
@Table(name = "sex")
public class Sex {
  @Id
  @Column(name = "code", nullable = false, length = 1)
  private String id;

  @Column(name = "name", nullable = false, length = 1)
  private String name;

}