package com.paorg.paorg_server.valueobject;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 馬名
 */
@Getter
public class HorseName extends Name {

    public HorseName(String value) {
      super(value);
    }
}
