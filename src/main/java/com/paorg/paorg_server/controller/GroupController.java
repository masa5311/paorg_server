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

  @PostMapping("/get_owner_list_with_ranking")
  public String getOwnerListWithRanking(@RequestBody String contents) {

    return this.groupService.findOwnerListWithRanking(contents);
  }

}
