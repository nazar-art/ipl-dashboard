package net.lelyak.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.lelyak.model.Match;
import net.lelyak.model.Team;
import net.lelyak.repository.MatchRepository;
import net.lelyak.repository.TeamRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

/**
 * @author Nazar Lelyak.
 */
@Slf4j
@CrossOrigin
@RestController
@RequiredArgsConstructor
public class TeamController {

    private final TeamRepository teamRepository;
    private final MatchRepository matchRepository;

    @GetMapping("team/{teamName}")
    public Team getTeam(
            @PathVariable String teamName,
            @PageableDefault(size = 4, sort = {"date"}, direction = Sort.Direction.DESC) Pageable pageable
    ) {
        Team team = teamRepository.findByTeamName(teamName);
        log.debug("teamName search: {} : {}", teamName, team);
        team.setMatches(matchRepository.findLatestMatchesByTeam(teamName, pageable));
        return team;
    }

    @GetMapping("team/{teamName}/matches")
    public List<Match> getMatchesForTeam(
            @PathVariable String teamName,
            @RequestParam int year
    ) {
        LocalDate startDate = LocalDate.of(year, 1, 1);
        LocalDate endDate = startDate.plusYears(1);

        return matchRepository.getAllMatchesByTeamBetweenDates(teamName, startDate, endDate);
    }
}
