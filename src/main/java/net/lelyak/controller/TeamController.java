package net.lelyak.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.lelyak.controller.dto.TeamDTO;
import net.lelyak.controller.mapper.TeamMapper;
import net.lelyak.model.Match;
import net.lelyak.model.Team;
import net.lelyak.repository.MatchRepository;
import net.lelyak.repository.TeamRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

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
    private final TeamMapper mapper;

    @GetMapping("team")
    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    @GetMapping("team/{teamName}")
    public TeamDTO getTeam(
            @PathVariable String teamName,
            @PageableDefault(size = 4, sort = {"date"}, direction = Sort.Direction.DESC) Pageable pageable
    ) {
        var team = teamRepository.findByTeamName(teamName);
        log.debug("teamName search: {} : {}", teamName, team);
        var latestMatches = matchRepository.findLatestMatchesByTeam(teamName, pageable);
        return mapper.toTeamDTO(team, latestMatches);
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
