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
@Table(name = "breeding_horse")
public class BreedingHorse {
  @Id
  @Column(name = "id", nullable = false)
  private Integer id;

  @Column(name = "name")
  private String name;

}