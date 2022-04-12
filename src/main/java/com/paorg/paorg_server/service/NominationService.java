package com.paorg.paorg_server.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.paorg.paorg_server.bean.BeanInterface;
import com.paorg.paorg_server.domain.NominationDomain;
import com.paorg.paorg_server.domain.UserDomain;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class NominationService {

  private final NominationDomain nominationDomain;
  private final UserDomain userDomain;


  // public List<Nomination> findAll() {
  //   List<Nomination> result = this.repository.findAll();
  //   return result;
  // }

  public List<BeanInterface> findNominationList() {
    return null;

  }

  // @SneakyThrows
  // public List<BeanInterface> findNominationListByIdAndYear(String contents) {
  //
  //   ObjectMapper mapper = new ObjectMapper();
  //   JsonNode inputJson = mapper.readTree(contents);
  //   Integer userId = inputJson.get("userId").asInt();
  //   Integer year = inputJson.get("year").asInt();
  //
  //   return this.nominationDomain.findNominationListByIdAndYear(userId, year);
  // }

  public String findNominationListByIdAndYearString() {

    return this.userDomain.findNominationListByUserAndYearAndCofirmed(1,
      2021);
  }
}
