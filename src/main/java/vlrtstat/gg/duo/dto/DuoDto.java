package vlrtstat.gg.duo.dto;

import vlrtstat.gg.duo.constant.DuoQueueId;
import vlrtstat.gg.duo.domain.Duo;
import vlrtstat.gg.global.constant.Line;
import vlrtstat.gg.global.constant.Tier;
import vlrtstat.gg.match.domain.RiotMatch;
import vlrtstat.gg.participant.domain.Participant;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DuoDto {
    private Long id;
    private Long userId;
    private String gameName;
    private String tagLine;
    private String puuid;
    private List<Line> lines;
    private Tier tier;
    private List<Line> wishLines = new ArrayList<>();
    private List<Tier> wishTiers = new ArrayList<>();
    private boolean isMatched;
    private LocalDateTime createdAt;
    private LocalDateTime expiredAt;
    private List<DuoTicketDto> tickets;
    private DuoQueueId duoQueueId;
    private List<DuoRecentMatchDto> recentMatches = new ArrayList<>();
    private String memo;


    public DuoDto(Duo duo) {
        this.id = duo.getId();
        this.gameName = duo.getGameName();
        this.tagLine = duo.getTagLine();
        this.puuid = duo.getPuuid();
        this.lines = duo.getLines();
        this.tier = duo.getTier();
        this.wishLines = duo.getWishLines();
        this.wishTiers = duo.getWishTiers();
        this.isMatched = duo.isMatched();
        this.createdAt = duo.getCreatedAt();
        this.expiredAt = duo.getExpiredAt();
        this.tickets = duo.getTickets().stream().map(DuoTicketDto::new).toList();
        this.userId = duo.getUserId();
        this.memo = duo.getMemo();
        this.duoQueueId = DuoQueueId.fromText(duo.getQueueId().name());
        List<RiotMatch> matches = duo.getRecentMatches();
        for (RiotMatch match : matches) {
            Optional<Participant> optionalParticipant = match.getParticipantByPuuid(puuid);
            if (optionalParticipant.isPresent()) recentMatches.add(new DuoRecentMatchDto(optionalParticipant.get()));
        }
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

    public List<Line> getLines() {
        return lines;
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

    public DuoQueueId getDuoQueueId() {
        return duoQueueId;
    }

    public List<DuoRecentMatchDto> getRecentMatches() {
        return recentMatches;
    }

    public String getMemo() {
        return memo;
    }
}
