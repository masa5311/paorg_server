package com.paorg.paorg_server.bean;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.paorg.paorg_server.entity.EntityInterface;
import com.paorg.paorg_server.entity.Test;

public interface BeanInterface {
  EntityInterface toEntity() throws JsonProcessingException;

}
