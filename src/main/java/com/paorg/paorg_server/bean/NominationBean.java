package com.paorg.paorg_server.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.paorg.paorg_server.entity.Crop;
import com.paorg.paorg_server.entity.EntityInterface;
import com.paorg.paorg_server.entity.Nomination;
import com.paorg.paorg_server.entity.type.NominationStatus;
import com.paorg.paorg_server.valueobject.*;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;
import java.util.Optional;

/**
 * 指名馬情報
 */
@AllArgsConstructor
@Getter
public class NominationBean extends BeanBase implements Serializable {
  // 指名ID
  @JsonIgnore
  private Id id;
  @JsonIgnore
  private Year year;
  @JsonIgnore
  private Id ownerId;
  @JsonIgnore
  private NominationRank nominateRank;
  @JsonIgnore
  private Id horseId;
  @JsonIgnore
  private HorseName horseName;
  @JsonIgnore
  private Sex sex;
  @JsonIgnore
  private BreedingHorseName sireName;
  @JsonIgnore
  private BreedingHorseName damName;
  @JsonIgnore
  private Name trainerName;
  @JsonIgnore
  private TrainerShozokuPlace trainerShozokuPlace;
  @JsonIgnore
  private NominationStatus nominationStatus;
  @JsonIgnore
  private Point point;

  public NominationBean(Nomination entity) {
    this.id = new Id(entity.getId());
    this.year = new Year(entity.getYear());
    // this.userId = new Id(entity.getUserId());
    this.nominateRank = new NominationRank(entity.getNominateRank());
    // this.horseId = new Id(entity.getHorseId());
    this.horseName = new HorseName(entity.getCrop().getName());
    this.sex = new Sex(entity.getCrop().getSex().getName());
    this.sireName = new BreedingHorseName(entity.getCrop().getSire().getName());
    this.damName = new BreedingHorseName(entity.getCrop().getDam().getName());
    this.trainerName = new Name(entity.getCrop().getTrainerName());
    this.trainerShozokuPlace = new TrainerShozokuPlace(
      entity.getCrop().getTrainerShozokuPlace());
    this.nominationStatus = entity.getNominationStatus();
  }

  public NominationBean(Integer id, Crop crop, Long point) {
    this.id = new Id(id);
    this.horseName = new HorseName(crop.getName());
    this.point = new Point(point);
  }

  @JsonProperty(value = "id")
  public Integer getId() {
    return this.id.getValue();
  }

  @JsonProperty(value = "year")
  @JsonInclude(JsonInclude.Include.NON_NULL)
  public Integer getYear() {
    return Optional.ofNullable(this.year).map(value -> value.getValue())
      .orElse(null);
  }

  // @JsonProperty(value = "ownerId")
  // public Integer getOwnerId() {
  //   return this.ownerId.getValue();
  // }

  @JsonProperty(value = "nominateRank")
  @JsonInclude(JsonInclude.Include.NON_NULL)
  public Integer getNominateRank() {
    return Optional.ofNullable(this.nominateRank).map(value -> value.getValue())
      .orElse(null);
  }

  // @JsonProperty(value = "horseId")
  // public Integer getHorseId() {
  //   return this.horseId.getValue();
  // }

  @JsonProperty(value = "horseName")
  public String getHorseName() {
    return Optional.ofNullable(this.horseName).map(value -> value.getValue())
      .orElse(null);
  }

  @JsonProperty(value = "sex")
  @JsonInclude(JsonInclude.Include.NON_NULL)
  public String getSex() {
    return Optional.ofNullable(this.sex).map(value -> value.getValue())
      .orElse(null);
  }

  @JsonProperty(value = "trainerName")
  @JsonInclude(JsonInclude.Include.NON_NULL)
  public String getTrainerName() {
    return Optional.ofNullable(this.trainerName).map(value -> value.getValue())
      .orElse(null);
  }

  @JsonProperty(value = "trainerShozokuPlace")
  @JsonInclude(JsonInclude.Include.NON_NULL)
  public String getTrainerShozokuPlace() {
    return Optional.ofNullable(this.trainerShozokuPlace)
      .map(value -> value.getValue()).orElse(null);
  }

  @JsonProperty(value = "sireName")
  @JsonInclude(JsonInclude.Include.NON_NULL)
  public String getSireName() {
    return Optional.ofNullable(this.sireName).map(value -> value.getValue())
      .orElse(null);
  }

  @JsonProperty(value = "damName")
  @JsonInclude(JsonInclude.Include.NON_NULL)
  public String getDamName() {
    return Optional.ofNullable(this.damName).map(value -> value.getValue())
      .orElse(null);
  }

  @JsonProperty(value = "nominationStatusCode")
  @JsonInclude(JsonInclude.Include.NON_NULL)
  public Integer getNominationStatus() {
    return Optional.ofNullable(this.nominationStatus)
      .map(value -> value.getCode()).orElse(null);
  }

  @JsonProperty(value = "point")
  @JsonInclude(JsonInclude.Include.NON_NULL)
  public Long getPoint() {
    return Optional.ofNullable(this.point).map(value -> value.getValue())
      .orElse(null);
  }

  @JsonIgnore
  @Override
  public EntityInterface toEntity() throws JsonProcessingException {
    return BeanFactory.convert(this, Nomination.class);
  }
}
