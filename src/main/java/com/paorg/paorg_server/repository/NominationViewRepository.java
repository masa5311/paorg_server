package com.paorg.paorg_server.repository;

import com.paorg.paorg_server.entity.Nomination;
import com.paorg.paorg_server.entity.NominationView;
import com.paorg.paorg_server.entity.NominationWithHorse;
import com.paorg.paorg_server.entity.type.NominationStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NominationViewRepository extends
  JpaRepository<NominationView, Integer> {

  @Query("select nv from NominationView nv")
  Optional<List<NominationView>> findByUserIdAndYearAndConfirmed();

}
