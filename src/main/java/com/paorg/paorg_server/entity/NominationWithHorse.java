package com.paorg.paorg_server.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.paorg.paorg_server.entity.type.NominationStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * 指名馬 > 馬 を結合して取得する
 */
@Table(name = "nomination")
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NominationWithHorse extends TableEntityBase {

  @Column(name = "year", nullable = false)
  private Integer year;

  @Column(name = "nominate_rank", nullable = false)
  private Integer nominateRank;

  @Enumerated(EnumType.STRING)
  @Column(name = "nomination_status", nullable = false)
  private NominationStatus nominationStatus;

  @ManyToOne
  private Horse horse;

  public void setNominationStatus(NominationStatus nominationStatus) {
    this.nominationStatus = nominationStatus;
  }
}