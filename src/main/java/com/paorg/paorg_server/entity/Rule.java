package com.paorg.paorg_server.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "rule")
public class Rule {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Integer id;

  @Column(name = "group_id")
  private Integer groupId;

  @Column(name = "rule_start")
  private Integer ruleStart;

  @Column(name = "rule_end")
  private Integer ruleEnd;

  @Column(name = "created_date")
  private Instant createdDate;

  @Column(name = "updated_date")
  private Instant updatedDate;

}