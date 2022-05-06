package com.paorg.paorg_server.controller;

import com.paorg.paorg_server.bean.BeanInterface;
import com.paorg.paorg_server.bean.stub.NominationStub;
import com.paorg.paorg_server.bean.stub.UserStub;
import com.paorg.paorg_server.service.NominationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class NominationController {

  private final NominationService nominationService;

  @GetMapping("/get_nominatied_horse_list")
  public List<BeanInterface> getNominatiedHorseList() {

    // List<Nomination> result = this.nominationService.findAll();
    List<BeanInterface> result = this.nominationService.findNominationList();
    return result;
  }

  // @PostMapping("/get_nomination_list_by_id_and_year")
  // public List<BeanInterface> getNominationListByIdAndYear(
  //   @RequestBody String contents) {
  //
  //   List<BeanInterface> result = this.nominationService.findNominationListByIdAndYear(
  //     contents);
  //   return result;
  // }

  @PostMapping("/get_nomination_list_by_id_and_year")
  public List<UserStub> getNominationListByIdAndYear(
    @RequestBody String contents) {
    // public Map<Integer, List<String>> getNominationListByIdAndYear(@RequestBody String contents) {

    NominationStub nominationWaka1 = new NominationStub(1, "エフフォーリア", "牡",
      "（美）鹿戸", "エピファネイア", "ケイティーズハート", 10000);
    NominationStub nominationWaka2 = new NominationStub(2, "グレナディアガーズ", "牡",
      "（栗）中内田", "Frankel", "ウェイヴェルアベニュー", 8000);
    NominationStub nominationWaka3 = new NominationStub(3, "サリオス", "牡",
      "（美）堀", "ハーツクライ", "サロミナ", 5000);

    List<NominationStub> nominationStubListWaka = new ArrayList<>();
    nominationStubListWaka.add(nominationWaka1);
    nominationStubListWaka.add(nominationWaka2);
    nominationStubListWaka.add(nominationWaka3);

    UserStub userStubWaka = new UserStub("若鷹正", nominationStubListWaka);

    NominationStub nominationSan1 = new NominationStub(1, "ディープインパクト", "牡",
      "（栗）池江泰郎", "サンデーサイレンス", "ウインドインハーヘア", 1000);
    NominationStub nominationSan2 = new NominationStub(2, "レイデオロ", "牡",
      "（美）藤沢和雄", "キングカメハメハ", "ラドラーダ", 500);
    NominationStub nominationSan3 = new NominationStub(3, "ブエナビスタ", "牝",
      "（栗）松田博資", "スペシャルウィーク", "ビワハイジ", 100);

    List<NominationStub> nominationStubListSan = new ArrayList<>();
    nominationStubListSan.add(nominationSan1);
    nominationStubListSan.add(nominationSan2);
    nominationStubListSan.add(nominationSan3);

    UserStub userStubSan = new UserStub("三冠馬主", nominationStubListSan);

    List<UserStub> userStubList = new ArrayList<>();
    userStubList.add(userStubWaka);
    userStubList.add(userStubSan);

    return userStubList;

    // Map<String, List<NominationStub>> nominationMap = new HashMap<>();
    // nominationMap.put("若鷹正", nominationStubListWaka);
    // nominationMap.put("三冠馬主", nominationStubListSan);

    // List<String> stringList = new ArrayList<>();
    // stringList.add("a");
    // stringList.add("b");
    // stringList.add("c");
    //
    // Map<Integer, List<String>> testMap = new HashMap<>();
    // testMap.put(1, stringList);
    // return testMap;

    // return this.nominationService.findNominationListByIdAndYearString();
  }

}
