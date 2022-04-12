package com.paorg.paorg_server.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.paorg.paorg_server.entity.EntityInterface;
import com.paorg.paorg_server.entity.Nomination;
import com.paorg.paorg_server.entity.User;
import com.paorg.paorg_server.entity.type.NominationStatus;
import com.paorg.paorg_server.valueobject.*;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.awt.*;
import java.io.Serializable;

/**
 * ユーザー情報を持つ
 */
@AllArgsConstructor
@Getter
public class UserBean extends BeanBase implements Serializable {
  @JsonIgnore
  private Id id;
  @JsonIgnore
  private FirebaseId firebaseId;
  @JsonIgnore
  private DisplayName displayName;

  public UserBean(User entity) {
    this.id = new Id(entity.getId());
    this.firebaseId = new FirebaseId(entity.getFirebaseId());
    this.displayName = new DisplayName(entity.getDisplayName());
  }

  @JsonProperty(value = "id")
  public Integer getId() {
    return this.id.getValue();
  }

  @JsonIgnore
  @Override
  public EntityInterface toEntity() throws JsonProcessingException {
    return BeanFactory.convert(this, User.class);
  }
}
