package net.lelyak.data;

import net.lelyak.model.Match;
import org.apache.commons.lang3.StringUtils;
import org.springframework.batch.item.ItemProcessor;

import java.time.LocalDate;

public class MatchDataProcessor implements ItemProcessor<MatchInput, Match> {

    @Override
    public Match process(final MatchInput input) {

        // Set Team 1 and Team 2 depending on the innings order
        final String firstInningsTeam, secondInningsTeam;

        if (StringUtils.equals("bat", input.toss_decision())) {
            firstInningsTeam = input.toss_winner();
            secondInningsTeam = StringUtils.equals(input.toss_winner(), input.team1())
                    ? input.team2()
                    : input.team1();
        } else {
            secondInningsTeam = input.toss_winner();
            firstInningsTeam = StringUtils.equals(input.toss_winner(), input.team1())
                            ? input.team2()
                            : input.team1();
        }

        return Match.builder()
                .city(input.city())
                .team1(firstInningsTeam)
                .venue(input.venue())
                .team2(secondInningsTeam)
                .result(input.result())
                .season(input.season())
                .umpire1(input.umpire1())
                .umpire2(input.umpire2())
                .matchWinner(input.winner())
                .id(Long.parseLong(input.id()))
                .tossWinner(input.toss_winner())
                .date(LocalDate.parse(input.date()))
                .tossDecision(input.toss_decision())
                .resultMargin(input.result_margin())
                .playerOfMatch(input.player_of_match())
                .build();
    }

}