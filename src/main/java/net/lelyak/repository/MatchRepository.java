package net.lelyak.repository;

import net.lelyak.model.Match;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

/**
 * @author Nazar Lelyak.
 */
public interface MatchRepository extends JpaRepository<Match, Long> {

    List<Match> findAllByTeam1OrTeam2(String teamName1, String teamName2, Pageable pageable);

    @Query("select m from Match m " +
            "where (m.team1 = :teamName or m.team2 = :teamName) " +
            "and m.date between :startDate and :endDate " +
            "order by m.date desc")
    List<Match> getAllMatchesByTeamBetweenDates(
            @Param("teamName") String teamName,
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate
    );


    default List<Match> findLatestMatchesByTeam(String teamName, Pageable pageable) {
        return findAllByTeam1OrTeam2(teamName, teamName, pageable);
    }
}
