package net.lelyak.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * @author Nazar Lelyak.
 */
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Match implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    private Long id;
    private String season;
    private String city;
    private LocalDate date;
    private String playerOfMatch;
    private String venue;

    private String team1;
    private String team2;
    private String tossWinner;
    private String tossDecision;
    private String matchWinner;

    private String result;
    private String resultMargin;
    private String umpire1;
    private String umpire2;
}
