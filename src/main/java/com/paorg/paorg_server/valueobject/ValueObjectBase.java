package com.paorg.paorg_server.valueobject;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ValueObjectBase<T> {
  T value;
}
