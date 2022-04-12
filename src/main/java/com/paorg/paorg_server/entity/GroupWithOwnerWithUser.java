package com.paorg.paorg_server.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * グループ > オーナー > ユーザー を結合して取得する
 */
@Table(name = "`group`")
@Entity
@Getter
@Setter
public class GroupWithOwnerWithUser extends TableEntityBase {
  @Column(name = "name", nullable = false, length = 20)
  private String name;

  @OneToMany
  @JoinColumn(name = "group_id")
  private List<OwnerWithUser> ownerList;
}