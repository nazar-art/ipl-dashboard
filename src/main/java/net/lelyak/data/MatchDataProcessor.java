package net.lelyak.data;

import net.lelyak.model.Match;
import org.apache.commons.lang3.StringUtils;
import org.springframework.batch.item.ItemProcessor;

import java.time.LocalDate;

public class MatchDataProcessor implements ItemProcessor<MatchInput, Match> {

    @Override
    public Match process(final MatchInput input) {

        // Set Team 1 and Team 2 depending on the innings order
        String firstInningsTeam, secondInningsTeam;

        if ("bat".equals(input.getToss_decision())) {
            firstInningsTeam = input.getToss_winner();
            secondInningsTeam = StringUtils.equals(input.getToss_winner(), input.getTeam1())
                    ? input.getTeam2()
                    : input.getTeam1();

        } else {
            secondInningsTeam = input.getToss_winner();
            firstInningsTeam = StringUtils.equals(input.getToss_winner(), input.getTeam1())
                            ? input.getTeam2()
                            : input.getTeam1();
        }

        return Match.builder()
                .city(input.getCity())
                .team1(firstInningsTeam)
                .venue(input.getVenue())
                .team2(secondInningsTeam)
                .result(input.getResult())
                .season(input.getSeason())
                .umpire1(input.getUmpire1())
                .umpire2(input.getUmpire2())
                .matchWinner(input.getWinner())
                .id(Long.parseLong(input.getId()))
                .tossWinner(input.getToss_winner())
                .date(LocalDate.parse(input.getDate()))
                .tossDecision(input.getToss_decision())
                .resultMargin(input.getResult_margin())
                .playerOfMatch(input.getPlayer_of_match())
                .build();
    }

}