package net.lelyak.data;

import lombok.Data;

/**
 * @author Nazar Lelyak.
 * updated csv source:
 * id,season,city,date,match_type,player_of_match,
 * venue,team1,team2,
 * toss_winner,toss_decision,winner,result,
 * result_margin,target_runs,target_overs,super_over,
 * method,umpire1,umpire2
 */
@Data
public class MatchInput {
    private String id;
    private String season;
    private String city;
    private String date;
    private String match_type;
    private String player_of_match;
    private String venue;
    private String team1;
    private String team2;
    private String toss_winner;
    private String toss_decision;
    private String winner;
    private String result;
    private String result_margin;
    private String target_runs;
    private String target_overs;
    private String super_over;

    private String method;
    private String umpire1;
    private String umpire2;
}
