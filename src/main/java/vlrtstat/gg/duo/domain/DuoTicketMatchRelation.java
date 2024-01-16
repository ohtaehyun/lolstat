package vlrtstat.gg.duo.domain;

import jakarta.persistence.*;
import vlrtstat.gg.match.domain.RiotMatch;

@Entity
public class DuoTicketMatchRelation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "duoId")
    private DuoTicket duoTicket;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "matchId")
    private RiotMatch riotMatch;

    public DuoTicketMatchRelation() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DuoTicket getDuoTicket() {
        return duoTicket;
    }

    public void setDuoTicket(DuoTicket duoTicket) {
        this.duoTicket = duoTicket;
    }

    public RiotMatch getRiotMatch() {
        return riotMatch;
    }

    public void setRiotMatch(RiotMatch riotMatch) {
        this.riotMatch = riotMatch;
    }
}
