package com.paorg.paorg_server.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.paorg.paorg_server.common.PropertyName;
import com.paorg.paorg_server.domain.GroupDomain;
import com.paorg.paorg_server.domain.OwnerDomain;
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
  private final OwnerDomain ownerDomain;

  /**
   * グループ内オーナー別ポイント情報取得
   * ・グループ指定
   * ・年度指定
   *
   * @param input Json
   * @return グループ内オーナー別ポイント情報Json文字列
   */
  @SneakyThrows
  public String findOwnerListWithPoint(String input) {

    Integer groupId = PropertyName.GROUP_ID.getValueFromJson(input);
    Integer year = PropertyName.YEAR.getValueFromJson(input);

    return ownerDomain.findByGroupIdWithPoint(groupId, year).toString();
  }

  /**
   * グループ内オーナー別指名馬リスト取得
   * ・グループ指定
   * ・年度指定
   *
   * @param input Json
   * @return グループ内オーナー別指名馬一覧Json文字列
   */
  @SneakyThrows
  public String findOwnerListWithNomination(String input) {

    Integer groupId = PropertyName.GROUP_ID.getValueFromJson(input);
    Integer year = PropertyName.YEAR.getValueFromJson(input);

    return ownerDomain.findOwnerListWithNomination(groupId, year).toString();

  }
}
