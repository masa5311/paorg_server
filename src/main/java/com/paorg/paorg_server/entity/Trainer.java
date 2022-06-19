package com.paorg.paorg_server.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "trainer")
public class Trainer {
  @Id
  @Column(name = "id", nullable = false)
  private Integer id;

  @Column(name = "name", nullable = false)
  private String name;

  // @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @ManyToOne
  @JoinColumn(name = "trainer_shozoku_id", nullable = false)
  private TrainerShozoku trainerShozoku;

}