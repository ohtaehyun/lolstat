package vlrtstat.gg.match.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class RiotMatch {
    @Id
    private String matchId;

    @Column
    private String dataVersion;

    public RiotMatch() {
    }
}
