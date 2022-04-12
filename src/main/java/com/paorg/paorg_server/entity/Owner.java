package com.paorg.paorg_server.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

/**
 * グループユーザーエンティティ（結合なし）
 */
@Table(name = "owner", indexes = {
  @Index(name = "owner_key", columnList = "group_id, user_id", unique = true)
})
@Entity
@Getter
@Setter
public class Owner extends TableEntityBase {
  @Column(name = "group_id", nullable = false)
  private Integer groupId;

  @Column(name = "user_id", nullable = false)
  private Integer userId;

}