package vlrtstat.gg.match.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jdk.jfr.DataAmount;

@Entity
public class Match {
    @Id
    private String matchId;

    public Match() {
    }
}
