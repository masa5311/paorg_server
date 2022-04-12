package com.paorg.paorg_server.domain;

import com.paorg.paorg_server.bean.NominationBean;
import com.paorg.paorg_server.entity.Nomination;
import com.paorg.paorg_server.repository.NominationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

/**
 * 指名ビュードメイン
 */
@Component
@AllArgsConstructor
public class NominationViewDomain implements DomainInterface {

  // @PersistenceContext
  // private final EntityManager em;
  private final NominationRepository repository;

  public List<NominationBean> findList() {
    List<Nomination> nominationList = this.repository.findAll();
    List<NominationBean> nominationBeanList = new ArrayList<>();

    // 指名Beanリストに変換
    nominationList.forEach(
      entity -> nominationBeanList.add(new NominationBean(entity)));

    return nominationBeanList;
  }

}
