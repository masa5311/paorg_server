package com.paorg.paorg_server.repository;

import com.paorg.paorg_server.entity.EntityInterface;
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
public interface NominationRepository extends
  JpaRepository<Nomination, Integer> {

  // Optional<List<Nomination>> findByUserIdAndYearAndNominationStatus(
  //   Integer userId, Integer year, NominationStatus status);

  Optional<List<Nomination>> findByYearAndNominationStatus(
    Integer year, NominationStatus status);

  @Query("select nwh from NominationWithHorse nwh")
  Optional<List<NominationWithHorse>> findByUserIdAndYearAndConfirmed();

}
