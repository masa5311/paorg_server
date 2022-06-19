package com.paorg.paorg_server.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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

  @ManyToOne
  private Sex sex;

  // @Column(name = "sex_code", nullable = false)
  // private String sexCode;

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