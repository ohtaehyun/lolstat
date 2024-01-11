package vlrtstat.gg.duo.dto;

import vlrtstat.gg.duo.domain.Duo;
import vlrtstat.gg.global.constant.Line;
import vlrtstat.gg.global.constant.Tier;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class DuoDto {
    private Long id;
    private Long userId;
    private String gameName;
    private String tagLine;
    private String puuid;
    private Line line;
    private Tier tier;
    private List<Line> wishLines = new ArrayList<>();
    private List<Tier> wishTiers = new ArrayList<>();
    private boolean isMatched;
    private LocalDateTime createdAt;
    private LocalDateTime expiredAt;

    private List<DuoTicketDto> tickets;


    public DuoDto(Duo duo) {
        this.id = duo.getId();
        this.gameName = duo.getGameName();
        this.tagLine = duo.getTagLine();
        this.puuid = duo.getPuuid();
        this.line = duo.getLine();
        this.tier = duo.getTier();
        this.wishLines = duo.getWishLines();
        this.wishTiers = duo.getWishTiers();
        this.isMatched = duo.isMatched();
        this.createdAt = duo.getCreatedAt();
        this.expiredAt = duo.getExpiredAt();
        this.tickets = duo.getTickets().stream().map(DuoTicketDto::new).toList();
        this.userId = duo.getUserId();
    }

    public Long getId() {
        return id;
    }

    public String getGameName() {
        return gameName;
    }

    public String getTagLine() {
        return tagLine;
    }

    public String getPuuid() {
        return puuid;
    }

    public Line getLine() {
        return line;
    }

    public Tier getTier() {
        return tier;
    }

    public List<Line> getWishLines() {
        return wishLines;
    }

    public List<Tier> getWishTiers() {
        return wishTiers;
    }

    public boolean isMatched() {
        return isMatched;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getExpiredAt() {
        return expiredAt;
    }

    public List<DuoTicketDto> getTickets() {
        return tickets;
    }

    public Long getUserId() {
        return userId;
    }
}