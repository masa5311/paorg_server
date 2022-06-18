package com.paorg.paorg_server.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.paorg.paorg_server.entity.Crop;
import com.paorg.paorg_server.entity.EntityInterface;
import com.paorg.paorg_server.entity.Nomination;
import com.paorg.paorg_server.entity.type.NominationStatus;
import com.paorg.paorg_server.valueobject.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 指名馬情報
 */
@AllArgsConstructor
@Getter
@Setter
public class NominationBean extends BeanBase implements Serializable {
  /** 指名ID */
  private Id id;
  /** 年度 */
  private Year year;
  // @JsonIgnore
  // private Id ownerId;
  /** 指名順位 */
  private NominationRank nominationRank;
  /** 血統登録番号 */
  private PedigreeRegistrationNumber pedigreeRegistrationNumber;
  /** 馬名 */
  private HorseName horseName;
  /** 性別 */
  private Sex sex;
  /** 父名 */
  private BreedingHorseName sireName;
  /** 母名 */
  private BreedingHorseName damName;
  /** 調教師名 */
  private Name trainerName;
  /** 調教師所属 */
  private TrainerShozokuPlace trainerShozokuPlace;
  /** 指名ステータス */
  private NominationStatus nominationStatus;
  /** レース出走回数 */
  private Long numberOfRaces;
  /** ポイント */
  private Point point;

  public NominationBean(Nomination entity) {
    this.id = new Id(entity.getId());
    this.year = new Year(entity.getYear());
    // this.userId = new Id(entity.getUserId());
    this.nominationRank = new NominationRank(entity.getNominateRank());
    this.pedigreeRegistrationNumber =
      new PedigreeRegistrationNumber(entity.getCropId());
    this.horseName = new HorseName(entity.getCrop().getName());
    this.sex = new Sex(entity.getCrop().getSex().getName());
    this.sireName = new BreedingHorseName(entity.getCrop().getSire().getName());
    this.damName = new BreedingHorseName(entity.getCrop().getDam().getName());
    this.trainerName = new Name(entity.getCrop().getTrainerName());
    this.trainerShozokuPlace = new TrainerShozokuPlace(
      entity.getCrop().getTrainerShozokuPlace());
    this.nominationStatus = entity.getNominationStatus();
  }

  public NominationBean(Integer id, Long numberOfRaces, Long point) {
    this.id = new Id(id);
    // this.pedigreeRegistrationNumber = new PedigreeRegistrationNumber(
    //   crop.getId());
    // this.horseName = new HorseName(crop.getName());
    this.numberOfRaces = numberOfRaces;
    this.point = new Point(point);
  }

  public Integer getId() {
    return this.id.getValue();
  }

  @JsonInclude(JsonInclude.Include.NON_NULL)
  public Integer getYear() {
    return this.year == null ? null : this.year.getValue();
  }

  // @JsonProperty(value = "ownerId")
  // public Integer getOwnerId() {
  //   return this.ownerId.getValue();
  // }

  @JsonInclude(JsonInclude.Include.NON_NULL)
  public Integer getNominationRank() {
    return this.nominationRank == null ? null : this.nominationRank.getValue();
  }

  @JsonInclude(JsonInclude.Include.NON_NULL)
  public Integer getPedigreeRegistrationNumber() {
    return this.pedigreeRegistrationNumber == null ? null : this.pedigreeRegistrationNumber.getValue();
  }

  @JsonInclude(JsonInclude.Include.NON_NULL)
  public String getHorseName() {
    return this.horseName == null ? null : this.horseName.getValue();
  }

  @JsonInclude(JsonInclude.Include.NON_NULL)
  public String getSex() {
    return this.sex == null ? null : this.sex.getValue();
  }

  @JsonInclude(JsonInclude.Include.NON_NULL)
  public String getTrainerName() {
    return this.trainerName == null ? null : this.trainerName.getValue();
  }

  @JsonInclude(JsonInclude.Include.NON_NULL)
  public String getTrainerShozokuPlace() {
    return this.trainerShozokuPlace == null ? null : this.trainerShozokuPlace.getValue();
  }

  @JsonInclude(JsonInclude.Include.NON_NULL)
  public String getSireName() {
    return this.sireName == null ? null : this.sireName.getValue();
  }

  @JsonInclude(JsonInclude.Include.NON_NULL)
  public String getDamName() {
    return this.damName == null ? null : this.damName.getValue();
  }

  @JsonInclude(JsonInclude.Include.NON_NULL)
  public Integer getNominationStatus() {
    return this.nominationStatus == null ? null : this.nominationStatus.getCode();
  }

  @JsonInclude(JsonInclude.Include.NON_NULL)
  public Long getPoint() {
    return this.point == null ? null : this.point.getValue();
  }

  @JsonIgnore
  @Override
  public EntityInterface toEntity() throws JsonProcessingException {
    return BeanFactory.convert(this, Nomination.class);
  }
}
