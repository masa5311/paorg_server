package com.paorg.paorg_server.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

/**
 * ユーザー > 指名馬 > 馬 を結合して取得する
 */
@Table(name = "user")
@Entity
@Getter
@Setter
// @NamedEntityGraph(
//   name = "User.nominationList",
//   attributeNodes = @NamedAttributeNode("nominationList")
// )
public class UserWithNominationWithHorse extends TableEntityBase {

  @JsonIgnore
  @Column(name = "firebase_id", nullable = false)
  private String firebaseId;

  @Column(name = "display_name", nullable = false)
  private String displayName;

  // エンティティで結合する場合：NominationEntityにuserIdフィールドが必要
  // @OneToMany(mappedBy = "userId")
  // テーブルのカラム名で結合する場合：NominationEntityにuserIdフィールドは不要
  @OneToMany
  @JoinColumn(name = "user_id")
  private List<NominationWithHorse> nominationList;

}