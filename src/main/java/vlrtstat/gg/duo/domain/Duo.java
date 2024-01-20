package vlrtstat.gg.duo.domain;

import jakarta.persistence.*;
import vlrtstat.gg.global.constant.Line;
import vlrtstat.gg.global.constant.QueueId;
import vlrtstat.gg.global.constant.Tier;
import vlrtstat.gg.match.domain.RiotMatch;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Entity
public class Duo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String gameName;

    @Column
    private String tagLine;

    @Column
    private Long userId;

    @Column
    private String puuid;

    @ElementCollection
    private List<Line> myLines;

    @Column
    private Tier tier;

    @ElementCollection
    private List<Line> wishLines = new ArrayList<>();

    @ElementCollection
    private List<Tier> wishTiers = new ArrayList<>();

    @Column(columnDefinition = "boolean default false")
    private boolean isMatched;

    @Column(length = 50)
    private String Memo;

    @Column
    private LocalDateTime createdAt;

    @Column
    private LocalDateTime expiredAt;

    @OneToMany(mappedBy = "duo", cascade = CascadeType.ALL)
    private List<DuoTicket> tickets = new ArrayList<>();

    @Column
    private QueueId queueId;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "duo", cascade = CascadeType.ALL)
    private List<DuoMatchRelation> relations;

    public Duo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public String getTagLine() {
        return tagLine;
    }

    public void setTagLine(String tagLine) {
        this.tagLine = tagLine;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getPuuid() {
        return puuid;
    }

    public void setPuuid(String puuid) {
        this.puuid = puuid;
    }

    public List<Line> getLines() {
        return myLines;
    }

    public void setLines(List<Line> lines) {
        this.myLines = lines;
    }

    public Tier getTier() {
        return tier;
    }

    public void setTier(Tier tier) {
        this.tier = tier;
    }

    public List<Line> getWishLines() {
        return wishLines;
    }

    public void setWishLines(List<Line> wishLines) {
        this.wishLines = wishLines;
    }

    public List<Tier> getWishTiers() {
        return wishTiers;
    }

    public void setWishTiers(List<Tier> wishTiers) {
        this.wishTiers = wishTiers;
    }

    public boolean isMatched() {
        return isMatched;
    }

    public void setMatched(boolean matched) {
        isMatched = matched;
    }

    public String getMemo() {
        return Memo;
    }

    public void setMemo(String memo) {
        Memo = memo;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getExpiredAt() {
        return expiredAt;
    }

    public void setExpiredAt(LocalDateTime expiredAt) {
        this.expiredAt = expiredAt;
    }

    public List<DuoTicket> getTickets() {
        return tickets;
    }

    public void setTickets(List<DuoTicket> tickets) {
        this.tickets = tickets;
    }

    public void addTickets(DuoTicket ticket) {
        this.tickets.add(ticket);
    }

    public Optional<DuoTicket> getTicketById(Long ticketId) {
        for (DuoTicket ticket : tickets) {
            if (ticket.getId().equals(ticketId)) return Optional.of(ticket);
        }
        return Optional.empty();
    }

    public List<Line> getMyLines() {
        return myLines;
    }

    public void setMyLines(List<Line> myLines) {
        this.myLines = myLines;
    }

    public QueueId getQueueId() {
        return queueId;
    }

    public void setQueueId(QueueId queueId) {
        this.queueId = queueId;
    }

    public List<DuoMatchRelation> getRelations() {
        return relations;
    }

    public void setRelations(List<DuoMatchRelation> relations) {
        this.relations = relations;
    }

    public List<RiotMatch> getRecentMatches() {
        return relations.stream().map(DuoMatchRelation::getMatch).toList();
    }
}
