package com.paorg.paorg_server.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * グループエンティティ（結合なし）
 */
@Table(name = "`group`")
@Entity
@Getter
@Setter
public class Group extends TableEntityBase {
  @Column(name = "name", nullable = false, length = 20)
  private String name;
}