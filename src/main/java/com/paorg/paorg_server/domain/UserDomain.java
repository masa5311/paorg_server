package com.paorg.paorg_server.domain;

import com.paorg.paorg_server.bean.BeanInterface;
import com.paorg.paorg_server.bean.NominationBean;
import com.paorg.paorg_server.bean.UserBean;
import com.paorg.paorg_server.entity.Nomination;
import com.paorg.paorg_server.entity.User;
import com.paorg.paorg_server.entity.UserWithNominationWithHorse;
import com.paorg.paorg_server.entity.type.NominationStatus;
import com.paorg.paorg_server.repository.NominationRepository;
import com.paorg.paorg_server.repository.UserRepository;
import com.paorg.paorg_server.repository.UserWithNominationWithHorseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

/**
 * ユーザードメイン
 */
@Component
@AllArgsConstructor
public class UserDomain implements DomainInterface {

  @PersistenceContext
  private final EntityManager em;
  private final UserRepository repository;
  private final UserWithNominationWithHorseRepository withNominationWithHorseRepository;

  public List<UserBean> findList() {
    List<User> userList = this.repository.findAll();
    List<UserBean> userBeanList = new ArrayList<>();

    userList.forEach(entity -> userBeanList.add(new UserBean(entity)));

    return userBeanList;
  }

  // public List<BeanInterface> findNominationListByUserAndYearAndCofirmed(Integer userId,
  //   Integer year) {
  //   List<Nomination> nominationList =
  //     this.repository.findWithNominationListByYear(userId, year,
  //       NominationStatus.confirmed).orElse(new ArrayList<>());
  //
  //   List<BeanInterface> nominationBeanList = new ArrayList<>();
  //   nominationList.forEach(
  //     entity -> nominationBeanList.add(new NominationBean(entity)));
  //
  //   return nominationBeanList;
  // }

  public String findNominationListByUserAndYearAndCofirmed(Integer userId,
    Integer year) {
    List<UserWithNominationWithHorse> nominationList =
      this.withNominationWithHorseRepository.findByUserIdAndYearAndConfirmed(
        userId, year).orElse(new ArrayList<>());

    return nominationList.toString();
  }

}
