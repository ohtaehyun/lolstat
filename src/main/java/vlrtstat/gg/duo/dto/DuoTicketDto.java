package vlrtstat.gg.duo.dto;

import vlrtstat.gg.duo.domain.DuoTicket;
import vlrtstat.gg.global.constant.Line;
import vlrtstat.gg.global.constant.Tier;

import java.time.LocalDateTime;

public class DuoTicketDto {
    private Long id;
    private Long userId;
    private Long duoId;
    private String gameName;
    private String tagLine;
    private Line line;
    private Tier tier;
    private String memo;
    private LocalDateTime createdAt;

    public DuoTicketDto(DuoTicket duoTicket) {
        this.id = duoTicket.getId();
        this.line = duoTicket.getLine();
        this.tier = duoTicket.getTier();
        this.duoId = duoTicket.getDuo().getId();
        this.userId = duoTicket.getUser().getId();
        this.gameName = duoTicket.getGameName();
        this.tagLine = duoTicket.getTagLine();
        this.memo = duoTicket.getMemo();
        this.createdAt = duoTicket.getCreatedAt();
    }

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getDuoId() {
        return duoId;
    }

    public String getGameName() {
        return gameName;
    }

    public String getTagLine() {
        return tagLine;
    }

    public Line getLine() {
        return line;
    }

    public Tier getTier() {
        return tier;
    }

    public String getMemo() {
        return memo;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
