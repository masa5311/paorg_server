package com.paorg.paorg_server.controller;

import com.paorg.paorg_server.bean.stub.Ranking;
import com.paorg.paorg_server.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class GroupController {

  private final GroupService groupService;

  @PostMapping("/get_owner_list_with_ranking")
  public List<Ranking> getOwnerListWithRanking(@RequestBody String contents) {

    List<Ranking> rankingList = new ArrayList<>();
    Ranking user1 = new Ranking();
    Ranking user2 = new Ranking();
    Ranking user3 = new Ranking();

    user1.setRank(1);
    user1.setUserName("若鷹正");
    user1.setPoint(100000);
    user1.setRepresentativeHorse("エフフォーリア");
    user2.setRank(2);
    user2.setUserName("三冠馬主");
    user2.setRepresentativeHorse("ディープインパクト");
    user2.setPoint(10000);
    user3.setRank(3);
    user3.setUserName("めがね");
    user3.setPoint(1000);
    user3.setRepresentativeHorse("ドゥラメンテ");

    rankingList.add(user1);
    rankingList.add(user2);
    rankingList.add(user3);

    return rankingList;
  }

}
