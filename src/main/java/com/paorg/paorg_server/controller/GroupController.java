package com.paorg.paorg_server.controller;

import com.paorg.paorg_server.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class GroupController {

  private final GroupService groupService;

  // 500エラー
  // @PostMapping("/get_owner_list_with_ranking")
  // public String getOwnerListWithRanking(@RequestBody String contents) {
  //
  //   return this.groupService.findOwnerListWithRanking(contents);
  // }

  // 400エラー
  // @RequestMapping("/get_owner_list_with_ranking")
  // public String getOwnerListWithRanking(@RequestBody String contents) {
  //
  //   return this.groupService.findOwnerListWithRanking(contents);
  // }

  // 成功：this.members = await this.$axios.$get('/get_owner_list_with_ranking')
  // @RequestMapping("/get_owner_list_with_ranking")
  // public String getOwnerListWithRanking() {
  //
  //   return "あああ";
  // }

  // 成功：await this.$axios.$post('/get_owner_list_with_ranking')
  // @RequestMapping("/get_owner_list_with_ranking")
  // public String getOwnerListWithRanking() {
  //
  //   return "あああ";
  // }

  // 成功：await this.$axios.$post('/get_owner_list_with_ranking', params)
  // const params = {
  //   userId: "ユーザーID"
  // }
  @PostMapping("/get_owner_list_with_ranking")
  public String getOwnerListWithRanking(@RequestBody String contents) {

    return contents;
  }

  // 下記でエンコードしている
  // const params = new URLSearchParams()
  // params.append('userId', 'ユーザーID')
  // 成功：await this.$axios.$post('/get_owner_list_with_ranking', params)
  // エンコードしたパラメータもデコードされる
  // @PostMapping("/get_owner_list_with_ranking")
  // public String getOwnerListWithRanking(@RequestParam("userId") String userId) {
  //
  //   return userId;
  // }

  // 下記でエンコードしている
  // const params = new URLSearchParams()
  // params.append('userId', 'ユーザーID')
  // 失敗：await this.$axios.$post('/get_owner_list_with_ranking', params)
  // エンコードされたまま受け取ってしまう
  // @PostMapping("/get_owner_list_with_ranking")
  // public String getOwnerListWithRanking(@RequestBody String contents) {
  //
  //   return contents;
  // }

}
