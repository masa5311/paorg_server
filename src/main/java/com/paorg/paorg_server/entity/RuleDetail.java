package com.paorg.paorg_server.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "rule_detail")
public class RuleDetail {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Integer id;

  @Column(name = "rule_id")
  private Integer ruleId;

  @Column(name = "group_id")
  private Integer groupId;

  @Column(name = "race_condition_code", length = 3)
  private String raceConditionCode;

  @Column(name = "race_grade_code", length = 2)
  private String raceGradeCode;

  @Column(name = "age")
  private Integer age;

  @Column(name = "rank")
  private Integer rank;

  @Column(name = "addition")
  private String addition;

  @Column(name = "point")
  private Integer point;

  @Column(name = "created_date")
  private Instant createdDate;

  @Column(name = "updated_date")
  private Instant updatedDate;

}