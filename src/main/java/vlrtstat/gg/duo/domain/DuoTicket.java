package vlrtstat.gg.duo.domain;

import jakarta.persistence.*;
import vlrtstat.gg.global.constant.Line;
import vlrtstat.gg.global.constant.Tier;
import vlrtstat.gg.match.domain.RiotMatch;
import vlrtstat.gg.user.domain.User;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class DuoTicket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "duo_id")
    private Duo duo;

    @Column
    private String puuid;

    @Column
    private String gameName;

    @Column
    private String tagLine;

    @ElementCollection
    private List<Line> myLines;

    @Column
    private Tier tier;

    @Column(length = 50)
    private String memo;

    @Column
    private boolean isSelected;

    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "duoTicket", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<DuoTicketMatchRelation> relations;

    public DuoTicket() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Duo getDuo() {
        return duo;
    }

    public void setDuo(Duo duo) {
        this.duo = duo;
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

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public List<Line> getMyLines() {
        return myLines;
    }

    public void setMyLines(List<Line> myLines) {
        this.myLines = myLines;
    }

    public List<DuoTicketMatchRelation> getRelations() {
        return relations;
    }

    public void setRelations(List<DuoTicketMatchRelation> relations) {
        this.relations = relations;
    }

    public String getPuuid() {
        return puuid;
    }

    public void setPuuid(String puuid) {
        this.puuid = puuid;
    }

    public List<RiotMatch> getRecentMatches() {
        return this.relations.stream().map(DuoTicketMatchRelation::getRiotMatch).toList();
    }
}
