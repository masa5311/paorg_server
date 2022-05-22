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

@AllArgsConstructor
@Getter
public class OwnerBean extends BeanBase implements Serializable {
  // @JsonIgnore
  private Integer id;
  // @JsonIgnore
  private String displayName;
  // @JsonIgnore
  private Long point;

  // @JsonProperty(value = "id")
  // public Integer getId() {
  //   return this.id;
  // }

  @JsonIgnore
  @Override
  public EntityInterface toEntity() throws JsonProcessingException {
    return BeanFactory.convert(this, Owner.class);
  }
}
