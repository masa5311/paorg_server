package com.paorg.paorg_server.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "crop")
public class Crop {
  @Id
  @Column(name = "id", nullable = false)
  private Integer id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "sex_code")
  private Sex sex;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "sire_breeding_horse_id")
  private BreedingHorse sire;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "dam_breeding_horse_id")
  private BreedingHorse dam;

  @OneToOne
  @JoinColumn(name = "id")
  private Racehorse racehorse;

  /**
   * 馬名を取得する
   * ・競走馬未登録
   * 　→母親名 + 年度（血統登録番号の先頭4文字）
   * ・競走馬登録済
   * 　→登録名
   * @return 馬名
   */
  public String getName() {
    if (this.racehorse == null) {
      return this.dam.getName() + this.id.toString().substring(0, 4);
    }
    return this.racehorse.getName();
  }

}