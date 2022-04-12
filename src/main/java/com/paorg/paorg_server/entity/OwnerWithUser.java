package com.paorg.paorg_server.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * オーナー > ユーザー を結合して取得する
 */
@Table(name = "owner", indexes = {
  @Index(name = "owner_key", columnList = "group_id, user_id", unique = true)
})
@Entity
@Getter
@Setter
public class OwnerWithUser extends TableEntityBase {
  @Column(name = "group_id", nullable = false)
  private Integer groupId;

  // @Column(name = "user_id", nullable = false)
  // private Integer userId;
  //
  // @ManyToOne
  // private Group group;

  @ManyToOne
  private User user;
}