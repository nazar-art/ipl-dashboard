package net.lelyak.controller.dto;


import net.lelyak.model.Match;

import java.util.List;

/**
 * @author Nazar Lelyak.
 */
public record TeamDTO(long id, String teamName, long totalMatches, long totalWins, List<Match> matches) {
}
