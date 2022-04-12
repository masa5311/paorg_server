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
public class UserService {

  private final UserDomain userDomain;

  public String getRanking() {

    return null;

  }

  public String findNominationListByIdAndYearString() {

    return this.userDomain.findNominationListByUserAndYearAndCofirmed(1,
      2021);
  }
}
