package com.paorg.paorg_server.bean.stub;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class UserStub {

  private String userName;
  private List<NominationStub> nominationList;
}
