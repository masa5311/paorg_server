package com.paorg.paorg_server.entity.type;

public enum NominationStatus {
  confirming(1),
  conflict(2),
  confirmed(3),
  rejected(4),
  ;

  // 指名状況コード
  private final Integer code;

  NominationStatus(Integer code) {
    this.code = code;
  }

  /**
   * 指名状況コードを返却する
   *
   * @return
   */
  public Integer getCode() {
    return this.code;
  }
}
