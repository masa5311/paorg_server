package com.paorg.paorg_server.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.paorg.paorg_server.domain.GroupDomain;
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

  /**
   * オーナー別ポイント情報取得
   *
   * @param contents Json
   * @return オーナー別ポイント情報Json文字列
   */
  @SneakyThrows
  public String findOwnerListWithPoint(String contents) {

    ObjectMapper mapper = new ObjectMapper();
    JsonNode inputJson = mapper.readTree(contents);
    Integer groupId = inputJson.get("groupId").asInt();
    Integer year = inputJson.get("year").asInt();

    return groupDomain.findByGroupIdWithPoint(groupId, year).toString();
  }
}
