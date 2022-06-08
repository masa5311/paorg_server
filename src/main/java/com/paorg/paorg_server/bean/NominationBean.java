package com.paorg.paorg_server.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.paorg.paorg_server.entity.EntityInterface;
import com.paorg.paorg_server.entity.Nomination;
import com.paorg.paorg_server.entity.type.NominationStatus;
import com.paorg.paorg_server.valueobject.*;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

/**
 * 指名情報を持つ
 */
@AllArgsConstructor
@Getter
public class NominationBean extends BeanBase implements Serializable {
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
  private NominationStatus nominationStatus;

  public NominationBean(Nomination entity) {
    this.id = new Id(entity.getId());
    this.year = new Year(entity.getYear());
    // this.userId = new Id(entity.getUserId());
    this.nominateRank = new NominationRank(entity.getNominateRank());
    // this.horseId = new Id(entity.getHorseId());
    this.horseName = new HorseName(entity.getCrop().getName());
    this.sex = new Sex(entity.getCrop().getSex().getName());
    this.nominationStatus = entity.getNominationStatus();
  }

  @JsonProperty(value = "id")
  public Integer getId() {
    return this.id.getValue();
  }

  @JsonProperty(value = "year")
  public Integer getYear() {
    return this.year.getValue();
  }

  // @JsonProperty(value = "ownerId")
  // public Integer getOwnerId() {
  //   return this.ownerId.getValue();
  // }

  @JsonProperty(value = "nominateRank")
  public Integer getNominateRank() {
    return this.nominateRank.getValue();
  }

  // @JsonProperty(value = "horseId")
  // public Integer getHorseId() {
  //   return this.horseId.getValue();
  // }

  @JsonProperty(value = "horseName")
  public String getHorseName() {
    return this.horseName.getValue();
  }

  @JsonProperty(value = "sex")
  public String getSex() { return  this.sex.getValue(); }

  @JsonProperty(value = "nominationStatusCode")
  public Integer getNominationStatus() {
    return this.nominationStatus.getCode();
  }

  @JsonIgnore
  @Override
  public EntityInterface toEntity() throws JsonProcessingException {
    return BeanFactory.convert(this, Nomination.class);
  }
}
