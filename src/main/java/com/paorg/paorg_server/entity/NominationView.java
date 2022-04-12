package com.paorg.paorg_server.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 指名ビューエンティティ
 */
@Table(name = "`nomination_view`")
@Entity
@Getter
@Setter
public class NominationView extends EntityBase implements EntityInterface {
  // @Entity対策（プライマリーキーを求められるため、暫定敵に@Idを付与）
  @Id
  @Column(name = "group_id")
  private Integer groupId;

  @Column(name = "group_name")
  private String groupName;

  @Column(name = "owner_id")
  private Integer ownerId;

  @Column(name = "user_name")
  private String userName;

  @Column(name = "year")
  private Integer year;

  @Column(name = "nominate_rank")
  private Integer nominateRank;

  @Column(name = "horse_id")
  private Integer horseId;

  @Column(name = "horse_name")
  private String horseName;

  @Column(name = "race_id")
  private Long raceId;

  @Column(name = "race_name")
  private String raceName;

  @Column(name = "grade_code")
  private Integer gradeCode;

  @Column(name = "race_condition_code_2")
  private Integer raceConditionCode2;

  @Column(name = "race_condition_code_3")
  private Integer raceConditionCode3;

  @Column(name = "race_ranking")
  private Integer raceRanking;


}