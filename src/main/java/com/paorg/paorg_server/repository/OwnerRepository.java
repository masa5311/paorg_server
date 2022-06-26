package com.paorg.paorg_server.repository;

import com.paorg.paorg_server.bean.OwnerBean;
import com.paorg.paorg_server.entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OwnerRepository extends
  JpaRepository<Owner, Integer> {

  /**
   * グループIDを元にオーナーを検索する（JPQL）
   * ・年度指定
   * ・オーナーごとのポイントを計算
   * ・ポイントでソート（降順）
   *
   * @param groupId グループID
   * @param year    年度
   * @return オーナーリスト
   */
  @Query("select new com.paorg.paorg_server.bean.OwnerBean(o.id" +
    ", u.displayName, sum(rd.point)) from Group g" +
    "     join Owner o on g.id = :groupId and g.id = o.groupId" +
    "     join Nomination n on n.year = :year" +
    "                      and o.id = n.ownerId" +
    "                      and n.status = 3" +
    "     join Crop c on n.cropId = c.id" +
    "     left outer join RaceByHorse rbh on c.id = rbh.horseId" +
    "     left outer join Race r on rbh.raceId = r.id" +
    "     join Rule r2 on g.id = r2.groupId" +
    "          and r2.ruleStart < :year and :year < r2.ruleEnd" +
    "     left outer join RuleDetail rd on rd.ruleId = r2.id" +
    "        and concat(r.raceConditionCode,  coalesce(r.raceGradeCode, '') ) =" +
    "            concat(rd.raceConditionCode, coalesce(rd.raceGradeCode, '') )" +
    "                  and rbh.rank = rd.rank" +
    "                  and rbh.age = rd.age" +
    "     join User u on o.userId = u.id" +
    " group by u.displayName" +
    " order by sum(rd.point) desc")
  Optional<List<OwnerBean>> findByGroupIdWithPoint(
    @Param("groupId") Integer groupId, @Param("year") Integer year);

  /**
   * グループIDを元にオーナー別の指名馬一覧を取得
   * ・年度指定
   * ・指名馬：指名が確定した指名馬を対象
   *
   * @param groupId グループID
   * @param year    年度
   * @return オーナー別指名馬一覧
   */
  @Query("select distinct o from Owner o " +
    "     inner join fetch o.nominationList n " +
    "     inner join fetch n.crop c" +
    " where o.groupId = :groupId" +
    "      and n.year = :year" +
    "      and n.status = 3" +
    " order by n.nominateRank")
  List<Owner> findOwnerListWithNomination(Integer groupId, Integer year);

}
