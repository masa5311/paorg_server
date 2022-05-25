package com.paorg.paorg_server.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.paorg.paorg_server.entity.EntityInterface;
import com.paorg.paorg_server.entity.Owner;
import com.paorg.paorg_server.entity.User;
import com.paorg.paorg_server.valueobject.DisplayName;
import com.paorg.paorg_server.valueobject.FirebaseId;
import com.paorg.paorg_server.valueobject.Id;
import com.paorg.paorg_server.valueobject.Name;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class OwnerBean extends BeanBase implements Serializable {
  @JsonIgnore
  private Id id;
  @JsonIgnore
  private Name displayName;
  // @JsonIgnore
  private Long point;

  public OwnerBean(Integer id, String displayName, Long point) {
    this.id = new Id(id);
    this.displayName = new Name(displayName);
    this.point = point;
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
