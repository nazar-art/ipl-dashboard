package net.lelyak.repository;

import net.lelyak.model.Match;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Nazar Lelyak.
 */
public interface MatchRepository extends JpaRepository<Match, Long> {

    List<Match> findAllByTeam1OrTeam2(String teamName1, String teamName2, Pageable pageable);

    default List<Match> findLatestMatchesByTeam(String teamName, Pageable pageable) {
        return findAllByTeam1OrTeam2(teamName, teamName, pageable);
    }
}
