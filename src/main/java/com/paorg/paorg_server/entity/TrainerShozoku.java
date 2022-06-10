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
@Table(name = "trainer_shozoku")
public class TrainerShozoku {
  @Id
  @Column(name = "id", nullable = false)
  private Integer id;

  @Column(name = "place", nullable = false)
  private String place;

}