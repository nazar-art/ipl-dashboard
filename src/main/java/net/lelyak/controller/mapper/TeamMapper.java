package net.lelyak.controller.mapper;

import net.lelyak.controller.dto.TeamDTO;
import net.lelyak.model.Match;
import net.lelyak.model.Team;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

/**
 * @author Nazar Lelyak.
 */
@Mapper(componentModel = "spring")
public interface TeamMapper {
    @Mapping(target = ".", source = "team.id")
    @Mapping(target = ".", source = "team.teamName")
    @Mapping(target = ".", source = "team.totalMatches")
    @Mapping(target = ".", source = "team.totalWins")
    TeamDTO toTeamDTO(Team team, List<Match> matches);
}
