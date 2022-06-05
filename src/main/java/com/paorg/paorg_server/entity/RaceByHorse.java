package com.paorg.paorg_server.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "race_by_horse")
public class RaceByHorse {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Integer id;

  @Column(name = "race_id", nullable = false)
  private Long raceId;

  @Column(name = "horse_id", nullable = false)
  private Integer horseId;

  @Column(name = "age", nullable = false)
  private Integer age;

  @Column(name = "rank", nullable = false)
  private Integer rank;

}