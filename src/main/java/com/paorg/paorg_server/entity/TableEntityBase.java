package com.paorg.paorg_server.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.SneakyThrows;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass
public abstract class TableEntityBase extends EntityBase {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Integer id;

  @JsonIgnore
  @Column(name = "created_date")
  private LocalDateTime createdDate;

  @JsonIgnore
  @Column(name = "updated_date")
  private LocalDateTime updatedDate;

  @PrePersist
  public void onPrePersist() {
    this.createdDate = LocalDateTime.now();
  }

  @PreUpdate
  public void onPreUpdate() {
    this.updatedDate = LocalDateTime.now();
  }

  /**
   * EntityをJson形式で出力する
   *
   * @return 自Entityから変換したJson文字列
   */
  // @SneakyThrows
  // @Override
  // public String toString() {
  //   ObjectMapper mapper = new ObjectMapper();
  //   return mapper.writeValueAsString(this);
  // }
}
