package com.paorg.paorg_server.repository;

import com.paorg.paorg_server.entity.Nomination;
import com.paorg.paorg_server.entity.User;
import com.paorg.paorg_server.entity.type.NominationStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

  // @Query("select distinct u from User u left join fetch u.nominationList n where n" +
  //   ".year = :year")
  // Optional<List<User>> findWithNominationListByYear(Integer year);

}
