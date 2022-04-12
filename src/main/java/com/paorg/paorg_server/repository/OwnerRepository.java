package com.paorg.paorg_server.repository;

import com.paorg.paorg_server.entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnerRepository extends
  JpaRepository<Owner, Integer> {

  // @Query("select distinct gu from GroupUser gu left join fetch gu.user where " +
  //   "gu.group.id = 1")
  // Optional<List<GroupUser>> findByGroupId();

}
