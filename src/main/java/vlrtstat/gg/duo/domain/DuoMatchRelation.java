package vlrtstat.gg.duo.domain;

import jakarta.persistence.*;
import vlrtstat.gg.match.domain.RiotMatch;

@Entity
public class DuoMatchRelation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "duo_id")
    private Duo duo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "match_id")
    private RiotMatch match;

    public DuoMatchRelation() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Duo getDuo() {
        return duo;
    }

    public void setDuo(Duo duo) {
        this.duo = duo;
    }

    public RiotMatch getMatch() {
        return match;
    }

    public void setMatch(RiotMatch match) {
        this.match = match;
    }
}
