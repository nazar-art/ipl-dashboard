package net.lelyak.data;

/**
 * @author Nazar Lelyak.
 */
public record MatchInput(
        String id,
        String season,
        String city,
        String date,
        String match_type,
        String player_of_match,
        String venue,
        String team1,
        String team2,
        String toss_winner,
        String toss_decision,
        String winner,
        String result,
        String result_margin,
        String target_runs,
        String target_overs,
        String super_over,
        String method,
        String umpire1,
        String umpire2
) {
}
