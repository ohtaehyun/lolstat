package vlrtstat.gg.duo.dto;

import vlrtstat.gg.duo.domain.DuoTicket;
import vlrtstat.gg.global.constant.Line;
import vlrtstat.gg.global.constant.Tier;
import vlrtstat.gg.match.domain.RiotMatch;
import vlrtstat.gg.participant.domain.Participant;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DuoTicketDto {
    private Long id;
    private Long userId;
    private Long duoId;
    private String gameName;
    private String tagLine;
    private List<Line> lines;
    private Tier tier;
    private String memo;
    private LocalDateTime createdAt;
    private List<DuoRecentMatchDto> recentMatches = new ArrayList<>();
    private String puuid;

    public DuoTicketDto(DuoTicket duoTicket) {
        this.id = duoTicket.getId();
        this.lines = duoTicket.getLines();
        this.tier = duoTicket.getTier();
        this.duoId = duoTicket.getDuo().getId();
        this.userId = duoTicket.getUser().getId();
        this.gameName = duoTicket.getGameName();
        this.tagLine = duoTicket.getTagLine();
        this.memo = duoTicket.getMemo();
        this.createdAt = duoTicket.getCreatedAt();
        this.puuid = duoTicket.getPuuid();

        for (RiotMatch recentMatch : duoTicket.getRecentMatches()) {
            Optional<Participant> optionalParticipant = recentMatch.getParticipantByPuuid(puuid);
            if (optionalParticipant.isPresent()) recentMatches.add(new DuoRecentMatchDto(optionalParticipant.get()));
        }
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

    public List<Line> getLines() {
        return lines;
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

    public String getPuuid() {
        return puuid;
    }

    public List<DuoRecentMatchDto> getRecentMatches() {
        return recentMatches;
    }
}
