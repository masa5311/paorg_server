package com.paorg.paorg_server.repository;

import com.paorg.paorg_server.entity.User;
import com.paorg.paorg_server.entity.UserWithNominationWithHorse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * ユーザー⇒指名⇒馬を取得するリポジトリ
 */
@Repository
public interface UserWithNominationWithHorseRepository extends
  JpaRepository<UserWithNominationWithHorse, Integer> {

  /**
   * 指定したユーザーの指名確定した指名馬一覧を取得する
   * 条件：ユーザーID、年度
   *
   * @param userId ユーザーID
   * @param year   年度
   * @return ユーザー、指名、馬のリスト
   */
  @Query("select distinct u from UserWithNominationWithHorse u left join fetch u.nominationList n " +
    "where u.id = :userId and n.year = :year")
  Optional<List<UserWithNominationWithHorse>> findByUserIdAndYearAndConfirmed(
    Integer userId, Integer year);

}
