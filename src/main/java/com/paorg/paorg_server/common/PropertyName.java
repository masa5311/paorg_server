package com.paorg.paorg_server.common;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

/**
 * Json等のプロパティを管理する
 */
public enum PropertyName {

  /** グループID */
  GROUP_ID("groupId"),
  /** 年 */
  YEAR("year"),
  ;

  /** プロパティ名 */
  private String name;

  PropertyName(String name) {
    this.name = name;
  }

  /**
   * Jsonから指定プロパティ名の 値 を取得する
   * @param json 取得対象Json
   * @return 指定プロパティ名の 値
   */
  @SneakyThrows
  public Integer getValueFromJson(String json) {
    ObjectMapper mapper = new ObjectMapper();
    JsonNode jsonNode = mapper.readTree(json);
    return jsonNode.get(this.name).asInt();
  }

}
