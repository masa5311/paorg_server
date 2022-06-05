package com.paorg.paorg_server.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.List;

/**
 * オーナーエンティティ（結合なし）
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

  @OneToOne
  @JoinColumn(insertable = false, updatable = false)
  private User user;

  @OneToMany
  @JoinColumn(name = "owner_id")
  private List<Nomination> nominationList;

}