package com.paorg.paorg_server.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.paorg.paorg_server.entity.EntityInterface;
import com.paorg.paorg_server.entity.RaceCondition;
import com.paorg.paorg_server.valueobject.Code;
import com.paorg.paorg_server.valueobject.Point;
import com.paorg.paorg_server.valueobject.RaceName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;

/**
 * レース結果Bean
 */
@AllArgsConstructor
@Getter
@Setter
public class RaceResultBean extends BeanBase {
  /** レース名 */
  private RaceName raceName;
  /** 条件コード */
  @JsonIgnore
  private Code conditionCode;
  /** 条件名 */
  @JsonIgnore
  private RaceName conditionName;
  /** グレードコード */
  @JsonIgnore
  private Code gradeCode;
  /** グレード名 */
  @JsonIgnore
  private RaceName gradeName;
  /** ランキング */
  private Integer ranking;
  /** ポイント */
  private Point point;

  public RaceResultBean(String raceName, RaceCondition condition,
    String gradeCode, String gradeName, Integer ranking, Integer point) {
    this.raceName = new RaceName(raceName);
    this.conditionCode = new Code(condition.getCode());
    this.conditionName = new RaceName(condition.getValue());
    this.gradeCode = new Code(gradeCode);
    this.gradeName = new RaceName(gradeName);
    this.ranking = ranking;
    this.point = new Point(point);
  }

  /**
   * レース名を生成する
   *
   * ■内容
   * 1.条件コードで判定
   *  1.新馬、未勝利の場合
   *   条件名
   *  2.1勝クラス
   *   1.平場の場合
   *    条件名
   *   2.特別の場合
   *    レース名 + (条件名)
   *  3.オープン
   *   1.重賞の場合
   *    レース名 + (グレード名)
   *   2.重賞以外
   *    レース名 + (条件名 + グレード名)
   *
   * @return
   */
  @JsonProperty(value = "raceName")
  @JsonInclude(JsonInclude.Include.NON_NULL)
  public String getRaceNameValue() {
    ConditionEnum conditionEnum = ConditionEnum.getByCode(
      this.conditionCode.getValue());
    GradeEnum gradeEnum = GradeEnum.getByCode(this.gradeCode.getValue());

    switch (conditionEnum) {
      case _701:
      case _703:
        return this.conditionName.getValue();
      case _005:
        if (this.gradeCode.getValue() == null) {
          return this.conditionName.getValue();
        }
        return this.raceName.getValue() + "(" + this.conditionName.getValue()
          + " " + this.gradeName.getValue() + ")";
      default:
        switch (gradeEnum) {
          case A:
          case B:
          case C:
          case D:
            return this.raceName.getValue() + "(" + this.gradeName.getValue() + ")";
          default:
            return this.raceName.getValue() + "(" + this.conditionName.getValue()
              + " " + this.gradeName.getValue() + ")";
        }
    }
  }

  @JsonProperty(value = "point")
  @JsonInclude(JsonInclude.Include.NON_NULL)
  public Long getPointValue() {
    return this.point == null ? null : this.point.getValue();
  }

  @Override
  public EntityInterface toEntity() throws JsonProcessingException {
    return null;
  }

  /**
   * 条件Enum
   */
  public enum ConditionEnum {
    _005("005"),
    _701("701"),
    _702("702"),
    _703("703"),
    _999("999"),
    ;

    private String code;

    ConditionEnum(String code) {
      this.code = code;
    }

    public String getCode() {
      return this.code;
    }

    public static ConditionEnum getByCode(String code) {
      return Arrays.stream(ConditionEnum.values())
        .filter(conditionEnum -> conditionEnum.getCode().equals(code))
        .findAny()
        .orElseThrow();
    }
  }

  /**
   * グレードEnum
   */
  public enum GradeEnum {
    A("A"),
    B("B"),
    C("C"),
    D("D"),
    E("E"),
    L("L"),
    ;

    private String code;

    GradeEnum(String code) {
      this.code = code;
    }

    public String getCode() {
      return this.code;
    }

    public static GradeEnum getByCode(String code) {
      return Arrays.stream(GradeEnum.values())
        .filter(gradeEnum -> gradeEnum.getCode().equals(code))
        .findAny()
        .orElse(null);
    }
  }
}