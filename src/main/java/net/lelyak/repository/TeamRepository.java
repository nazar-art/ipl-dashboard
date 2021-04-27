package net.lelyak.repository;

import net.lelyak.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Nazar Lelyak.
 */
public interface TeamRepository extends JpaRepository<Team, Long> {

    Team findByTeamName(String teamName);

}
