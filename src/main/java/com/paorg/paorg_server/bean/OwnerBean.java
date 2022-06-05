package com.paorg.paorg_server.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.paorg.paorg_server.entity.EntityInterface;
import com.paorg.paorg_server.entity.Owner;
import com.paorg.paorg_server.valueobject.Id;
import com.paorg.paorg_server.valueobject.Name;
import lombok.Getter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * オーナーBean
 */
@Getter
public class OwnerBean extends BeanBase implements Serializable {
  // オーナーID
  @JsonIgnore
  private Id id;

  // 表示名
  @JsonIgnore
  private Name displayName;

  // ポイント
  private Long point;

  // 指名馬リスト
  private List<NominationBean> nominationBeanList;

  public OwnerBean(Integer id, String displayName, Long point) {
    this.id = new Id(id);
    this.displayName = new Name(displayName);
    this.point = point;
  }

  public OwnerBean(Owner entity) {
    this.id = new Id(entity.getId());
    this.displayName = new Name(entity.getUser().getDisplayName());
    this.nominationBeanList = new ArrayList<>();
    entity.getNominationList().forEach(nomination -> {
      NominationBean bean = new NominationBean(nomination);
      this.nominationBeanList.add(bean);
    });
  }

  @JsonProperty(value = "id")
  public Integer getId() {
    return this.id.getValue();
  }

  @JsonProperty(value = "displayName")
  public String getDisplayName() {
    return this.displayName.getValue();
  }

  @JsonIgnore
  @Override
  public EntityInterface toEntity() throws JsonProcessingException {
    return BeanFactory.convert(this, Owner.class);
  }
}
