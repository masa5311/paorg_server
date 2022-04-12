package com.paorg.paorg_server.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.paorg.paorg_server.entity.EntityInterface;
import com.paorg.paorg_server.entity.type.EnumTestType;
import com.paorg.paorg_server.entity.Test;
import com.paorg.paorg_server.valueobject.Id;
import com.paorg.paorg_server.valueobject.Name;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

/**
 * ・集約のデータを持ち編集を統括する
 * ・データを必要に応じて編集して返却
 * ・Entityと一対一とし、Entityの入出力を行う
 * ・JSONとの相互変換
 */
@AllArgsConstructor
@Getter
public class TestBean extends BeanBase implements Serializable {
  @JsonIgnore
  private Id testId;
  @JsonIgnore
  private Name name;
  private EnumTestType enumTest;

  public TestBean(Test test) {
    this.testId = new Id(test.getId());
    this.name = new Name(test.getName());
    this.enumTest = test.getEnumTest();
  }

  @JsonProperty(value = "id")
  public Integer getId() {
    return this.testId.getValue();
  }

  @JsonProperty(value = "name")
  public String getName() {
    return this.name.getValue();
  }

  //　Entityにないフィールドのマッピングテスト用
  public String getTest() {
    return "Entityにないフィールド";
  }

  @JsonIgnore
  @Override
  public EntityInterface toEntity() throws JsonProcessingException {
    return BeanFactory.convert(this, Test.class);
  }

}
