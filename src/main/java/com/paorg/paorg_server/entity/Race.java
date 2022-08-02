package com.paorg.paorg_server.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "race")
public class Race {
  @Id
  @Column(name = "id", nullable = false)
  private Long id;

  @Column(name = "date", nullable = false)
  private Integer date;

  @Column(name = "race_course_code", nullable = false)
  private Integer raceCourseCode;

  @Column(name = "race_no", nullable = false)
  private Integer raceNo;

  @Column(name = "special_race_code", length = 4)
  private String specialRaceCode;

  @Column(name = "name")
  private String name;

  @Column(name = "race_grade_code")
  private String raceGradeCode;

  @Column(name = "race_type_id", nullable = false)
  private Integer raceTypeId;

  @Column(name = "race_condition_code", nullable = false, length = 3)
  private String raceConditionCode;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "race_condition_code", insertable = false, updatable = false)
  private RaceCondition raceCondition;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "race_grade_code", insertable = false, updatable = false)
  private RaceGrade raceGrade;

}