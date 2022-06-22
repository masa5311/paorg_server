package com.paorg.paorg_server.bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.paorg.paorg_server.entity.EntityInterface;
import com.paorg.paorg_server.valueobject.Name;
import com.paorg.paorg_server.valueobject.Point;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * レース結果Bean
 */
@AllArgsConstructor
@Getter
@Setter
public class RaceResultBean extends BeanBase {
  /** レース名 */
  private Name raceName;
  /** ランキング */
  private Integer ranking;
  /** ポイント */
  private Point point;

  public RaceResultBean(String raceName, Integer ranking, Integer point) {
    this.raceName = new Name(raceName);
    this.ranking = ranking;
    this.point = new Point(point);
  }

  @JsonProperty(value = "raceName")
  @JsonInclude(JsonInclude.Include.NON_NULL)
  public String getRaceNameValue() {
    return this.raceName == null ? null : this.raceName.getValue();
  }

  @JsonProperty(value = "point")
  @JsonInclude(JsonInclude.Include.NON_NULL)
  public Long getPointValue() {
    return this.point == null ? null : this.point.getValue();
  }

  @Override
  public EntityInterface toEntity() throws JsonProcessingException {
    return null;
  }
}