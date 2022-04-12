package com.paorg.paorg_server.bean;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class BeanFactory {

  /**
   * 変換前オブジェクトを、指定クラスに変換して返却する
   * １．変換前オブジェクトをJSOM文字列に変換
   * ２．JSON文字列を指定クラスにマッピング
   *
   * @param from    変換前オブジェクト
   * @param toClass 指定クラス
   * @param <T>     変換後クラス名
   * @return 変換後オブジェクト
   */
  public static <T> T convert(Object from, Class<T> toClass) throws
    JsonProcessingException {

    ObjectMapper mapper = new ObjectMapper();
    // JSONに存在し、マッピング先のJavaオブジェクトにフィールドがない場合のエラーを無視する
    mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    // Javaオブジェクト ⇒ JSON
    String jsonString = mapper.writeValueAsString(from);

    // JSON ⇒ Javaオブジェクト
    // Javaオブジェクトにマッピングされるフィールドがない場合、エラーになる
    return mapper.readValue(jsonString, toClass);

  }

}
