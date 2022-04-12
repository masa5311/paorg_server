package com.paorg.paorg_server.controller;

import com.paorg.paorg_server.bean.BeanInterface;
import com.paorg.paorg_server.service.NominationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

  @GetMapping("/get_nomination_list_by_id_and_year")
  public String getNominationListByIdAndYear() {

    return this.nominationService.findNominationListByIdAndYearString();
  }

}
