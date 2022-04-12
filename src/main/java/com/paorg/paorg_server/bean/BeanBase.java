package com.paorg.paorg_server.bean;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.paorg.paorg_server.entity.EntityInterface;
import lombok.SneakyThrows;

public abstract class BeanBase implements BeanInterface {

  /**
   * BeanをJson形式で出力する
   *
   * @return 自Beanから変換したJson文字列
   */
  @SneakyThrows
  @Override
  public String toString() {
    ObjectMapper mapper = new ObjectMapper();
    return mapper.writeValueAsString(this);
  }
}
