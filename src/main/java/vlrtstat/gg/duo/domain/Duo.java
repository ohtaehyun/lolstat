package vlrtstat.gg.duo.domain;

import jakarta.persistence.*;
import vlrtstat.gg.global.constant.Line;
import vlrtstat.gg.global.constant.Tier;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

    @Column
    private Line line;

    @Column
    private Tier tier;

    @Column
    private List<Line> wishLines = new ArrayList<>();

    @Column
    private List<Tier> wishTiers = new ArrayList<>();

    @Column(columnDefinition = "boolean default false")
    private boolean isMatched;

    @Column(length = 50)
    private String Memo;

    @Column
    private LocalDateTime createdAt;

    @Column
    private LocalDateTime expiredAt;

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

    public Line getLine() {
        return line;
    }

    public void setLine(Line line) {
        this.line = line;
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
}
