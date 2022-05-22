package com.paorg.paorg_server.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.paorg.paorg_server.entity.type.NominationStatus;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * 指名馬エンティティ（結合なし）
 */
@Table(name = "nomination")
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Nomination extends TableEntityBase {
  // @Id
  // @GeneratedValue(strategy = GenerationType.IDENTITY)
  // @Column(name = "id", nullable = false)
  // private Integer id;

  @Column(name = "year", nullable = false)
  private Integer year;

  @Column(name = "owner_id", nullable = false)
  private Integer ownerId;

  // @Column(name = "user_id", nullable = false)
  // private Integer userId;

  @Column(name = "nominate_rank", nullable = false)
  private Integer nominateRank;

  @Column(name = "horse_id", nullable = false)
  private Integer horseId;

  @Enumerated(EnumType.STRING)
  @Column(name = "nomination_status", nullable = false)
  private NominationStatus nominationStatus;

  // @JsonSerialize(using = LocalDateTimeSerializer.class)
  // @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  // @Column(name = "create_date")
  // private LocalDateTime createDate;
  //
  // @JsonSerialize(using = LocalDateTimeSerializer.class)
  // @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  // @Column(name = "update_date")
  // private LocalDateTime updateDate;

  public void setNominationStatus(NominationStatus nominationStatus) {
    this.nominationStatus = nominationStatus;
  }
}