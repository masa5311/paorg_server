package com.paorg.paorg_server.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "racehorse")
public class Racehorse {
  @Id
  @Column(name = "id", nullable = false)
  private Integer id;

  @Column(name = "name")
  private String name;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "sex_code")
  private Sex sex;

  // @ManyToOne(fetch = FetchType.LAZY)
  // @JoinColumn(name = "trainer_id")
  // private Trainer trainer;

}