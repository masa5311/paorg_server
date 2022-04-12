package com.paorg.paorg_server.repository;

import com.paorg.paorg_server.entity.GroupWithOwnerWithUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupWithOwnerWithUserRepository extends
  JpaRepository<GroupWithOwnerWithUser, Integer> {
}
