package com.paorg.paorg_server.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.paorg.paorg_server.domain.GroupDomain;
import com.paorg.paorg_server.domain.UserDomain;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * グループサービス
 */
@Service
@Transactional
@RequiredArgsConstructor
public class GroupService {

  private final GroupDomain groupDomain;

  @SneakyThrows
  public String findOwnerListWithRanking(String contents) {

    ObjectMapper mapper = new ObjectMapper();
    JsonNode inputJson = mapper.readTree(contents);
    Integer groupId = inputJson.get("groupId").asInt();

    return groupDomain.findOwnerListWithRanking(groupId).toString();
  }
}
