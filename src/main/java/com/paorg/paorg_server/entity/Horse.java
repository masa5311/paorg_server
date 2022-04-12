package com.paorg.paorg_server.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDateTime;

@Table(name = "horse")
@Entity
@Getter
@Setter
public class Horse extends TableEntityBase {
  // @Id
  // @Column(name = "id", nullable = false)
  // private Integer id;

  @Column(name = "year")
  private Integer year;

  @Column(name = "name", length = 50)
  private String name;

  @Column(name = "chichi", nullable = false, length = 50)
  private String chichi;

  @Column(name = "haha", nullable = false, length = 50)
  private String haha;

  @Column(name = "seibetsu", nullable = false)
  private Character seibetsu;

  // @Column(name = "kyusya", length = 30)
  // private String kyusya;

  // @Column(name = "no", nullable = false, length = 10)
  // private String no;

  // @JsonIgnore
  // @Column(name = "create_date")
  // private LocalDateTime createDate;
  //
  // @JsonIgnore
  // @Column(name = "update_date")
  // private LocalDateTime updateDate;

}