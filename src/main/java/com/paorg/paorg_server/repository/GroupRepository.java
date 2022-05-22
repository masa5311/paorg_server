package com.paorg.paorg_server.repository;

import com.paorg.paorg_server.bean.OwnerBean;
import com.paorg.paorg_server.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GroupRepository extends JpaRepository<Group, Integer> {

  /**
   * グループIDを元にオーナーを検索する
   * ・年度指定
   * ・オーナーごとのポイントを計算
   * @param groupId グループID
   * @param year 年度
   * @return オーナーリスト
   */
  @Query("select new com.paorg.paorg_server.bean.OwnerBean(o.id" +
    ", u.displayName, sum(r2.point))" +
    " from Group g" +
    "     join Owner o on g.id = :groupId and g.id = o.groupId" +
    "     join Nomination n on n.year = :year and o.id = n.ownerId" +
    "     join Horse h on n.horseId = h.id" +
    "     join RaceByHorse rbh on h.id = rbh.horseId" +
    "     join Race r on rbh.raceId = r.id" +
    "     join Rule r2" +
    "         on concat(r.raceConditionCode,  coalesce(r.gradeCode, '') ) =" +
    "            concat(r2.raceConditionCode, coalesce(r2.gradeCode, '') )" +
    "                  and rbh.rank = r2.rank" +
    "                  and rbh.age = r2.age" +
    "     join User u on o.userId = u.id" +
    " group by u.displayName" +
    " order by sum(r2.point) desc")
  Optional<List<OwnerBean>> findByGroupIdWithPoint(
    @Param("groupId") Integer groupId, @Param("year") Integer year);

}
