package com.paorg.paorg_server.repository;

import com.paorg.paorg_server.entity.OwnerWithUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupUserWithUserRepository extends
  JpaRepository<OwnerWithUser, Integer> {

  // @Query("select distinct gu from GroupUserWithUser gu left join fetch gu.user where " +
  //   "gu.group.id = 1")
  // Optional<List<GroupUserWithUser>> findByGroupId();

}
