package com.paorg.paorg_server.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.paorg.paorg_server.entity.EntityInterface;
import com.paorg.paorg_server.entity.Owner;
import com.paorg.paorg_server.valueobject.Id;
import com.paorg.paorg_server.valueobject.Name;
import com.paorg.paorg_server.valueobject.Point;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * オーナーBean
 */
@Getter
@Setter
public class OwnerBean extends BeanBase implements Serializable {
  /** オーナーID */
  private Id id;
  /** 表示名 */
  private Name displayName;
  /** ポイント */
  private Point point;
  /** ランキング */
  private Integer ranking;

  /** 指名馬リスト */
  @JsonInclude(JsonInclude.Include.NON_NULL)
  private List<NominationBean> nominationList;

  public OwnerBean(Integer id, String displayName, Long point) {
    this.id = new Id(id);
    this.displayName = new Name(displayName);
    this.point = point == null ? new Point(0L) : new Point(point);
  }

  public OwnerBean(Owner entity) {
    this.id = new Id(entity.getId());
    this.displayName = new Name(entity.getUser().getDisplayName());
    this.nominationList = new ArrayList<>();
    entity.getNominationList().forEach(nomination -> {
      NominationBean bean = new NominationBean(nomination);
      this.nominationList.add(bean);
    });
  }

  @JsonProperty(value = "id")
  public Integer getIdValue() {
    return this.id.getValue();
  }

  @JsonProperty(value = "displayName")
  public String getDisplayNameValue() {
    return this.displayName.getValue();
  }

  @JsonProperty(value = "point")
  @JsonInclude(JsonInclude.Include.NON_NULL)
  public Long getPointValue() {
    return this.point == null ? null : this.point.getValue();
  }

  @JsonIgnore
  @Override
  public EntityInterface toEntity() throws JsonProcessingException {
    return BeanFactory.convert(this, Owner.class);
  }
}
