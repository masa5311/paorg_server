package com.paorg.paorg_server.controller;

import com.paorg.paorg_server.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class GroupController {

  private final GroupService groupService;

  /**
   * グループ別のオーナーリストを取得する（ポイント付き）
   * @param input 取得条件
   * @return グループ別のオーナーリストJson文字列
   */
  @PostMapping("/get_owner_list_with_point")
  public String getOwnerListWithPoint(@RequestBody String input) {

    return this.groupService.findOwnerListWithPoint(input);
  }

  /**
   * グループ別のオーナーリスト（指名馬リスト付き）を取得する
   * @param input 取得条件
   * @return グループ別のオーナーリスト（指名馬リスト付き）Json文字列
   */
  @PostMapping("/get_nomination_list_by_group")
  public String getNominationListByGroup(@RequestBody String input) {
    return this.groupService.findOwnerListWithNomination(input);

  }

}
