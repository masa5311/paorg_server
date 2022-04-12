package com.paorg.paorg_server.repository;

import com.paorg.paorg_server.entity.Nomination;
import com.paorg.paorg_server.entity.NominationView;
import com.paorg.paorg_server.entity.Test;
import com.paorg.paorg_server.entity.UserWithNominationWithHorse;
import com.paorg.paorg_server.valueobject.TestId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TestRepository extends JpaRepository<Test, Integer> {
}
