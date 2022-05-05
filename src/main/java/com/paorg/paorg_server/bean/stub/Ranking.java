package com.paorg.paorg_server.bean.stub;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.paorg.paorg_server.bean.BeanBase;
import com.paorg.paorg_server.entity.EntityInterface;
import lombok.Data;

@Data
public class Ranking {

  private Integer rank;
  private String userName;
  private Integer point;
  private String representativeHorse;

}
