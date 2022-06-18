package com.paorg.paorg_server.repository;

import com.paorg.paorg_server.bean.NominationBean;
import com.paorg.paorg_server.entity.Nomination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public interface NominationRepository extends
  JpaRepository<Nomination, Integer> {

  // @Query("select new com.paorg.paorg_server.bean.NominationBean(n.id, c, " +
  //   "sum(rd.point)) from Owner o" +
  //   " join Nomination n on o.id = :ownerId" +
  //   "   and n.year = :year and o.id = n.ownerId" +
  //   " join Crop c on n.cropId = c.id" +
  //   " join RaceByHorse rbh on c.id = rbh.horseId" +
  //   " join Race r on rbh.raceId = r.id" +
  //   " join Rule r2 on o.groupId = r2.groupId" +
  //   "   and r2.ruleStart < :year and :year < r2.ruleEnd" +
  //   " join RuleDetail rd on rd.ruleId = r2.id" +
  //   "   and concat(r.raceConditionCode,  coalesce(r.raceGradeCode, '') ) =" +
  //   "       concat(rd.raceConditionCode, coalesce(rd.raceGradeCode, '') )" +
  //   "   and rbh.rank = rd.rank" +
  //   "   and rbh.age = rd.age" +
  //   " group by c.id")
  // Optional<List<NominationBean>> findByOwnerIdWithPoint(
  //   @Param("ownerId") Integer ownerId, @Param("year") Integer year);

  /**
   * 指名馬のポイントを取得する
   * @param groupId グループID：ルール特定用
   * @param nominationId 指名馬ID：ポイント取得対象
   * @return 指名馬のポイント
   */
  @Query("select sum(rd.point) from Nomination n" +
    " join Crop c on n.id = :nominationId and n.cropId = c.id" +
    " join RaceByHorse rbh on c.id = rbh.horseId" +
    " join Race r on rbh.raceId = r.id" +
    " join Rule r2 on r2.groupId = :groupId" +
    "   and r2.ruleStart < n.year and n.year < r2.ruleEnd" +
    " join RuleDetail rd on rd.ruleId = r2.id" +
    "   and concat(r.raceConditionCode,  coalesce(r.raceGradeCode, '') ) =" +
    "       concat(rd.raceConditionCode, coalesce(rd.raceGradeCode, '') )" +
    "   and rbh.rank = rd.rank" +
    "   and rbh.age = rd.age" +
    " group by c.id")
  Optional<Long> findByNominationPoint(
    @Param("groupId") Integer groupId,
    @Param("nominationId") Integer nominationId);
}
