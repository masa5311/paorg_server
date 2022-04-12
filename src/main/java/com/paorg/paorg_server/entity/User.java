package com.paorg.paorg_server.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;

/**
 * ユーザーエンティティ（結合なし）
 */
@Table(name = "user")
@Entity
@Getter
@Setter
public class User extends TableEntityBase {
  // @Id
  // @GeneratedValue(strategy = GenerationType.IDENTITY)
  // @Column(name = "id", nullable = false)
  // private Integer id;

  @Column(name = "firebase_id", nullable = false)
  private String firebaseId;

  @Column(name = "display_name", nullable = false)
  private String displayName;

  // @JsonSerialize(using = LocalDateTimeSerializer.class)
  // @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  // @Column(name = "create_date")
  // private LocalDateTime createDate;
  //
  // @JsonSerialize(using = LocalDateTimeSerializer.class)
  // @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  // @Column(name = "update_date")
  // private LocalDateTime updateDate;

}