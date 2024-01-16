package vlrtstat.gg.duo.dto;

import vlrtstat.gg.global.constant.Line;
import vlrtstat.gg.global.constant.QueueId;
import vlrtstat.gg.global.constant.Tier;
import vlrtstat.gg.league.domain.LeagueEntries;
import vlrtstat.gg.summoner.domain.Summoner;

import java.util.List;

public class AddDuoDto {
    private Long userId;
    private Summoner summoner;
    private LeagueEntries leagueEntries;
    private List<Line> lines;
    private List<Line> wishLines;
    private List<Tier> wishTiers;
    private String memo;
    private QueueId queueId;

    public AddDuoDto(Long userId, Summoner summoner, LeagueEntries leagueEntries, List<Line> lines, List<Line> wishLines, List<Tier> wishTiers, String memo, QueueId queueId) {
        this.userId = userId;
        this.summoner = summoner;
        this.leagueEntries = leagueEntries;
        this.lines = lines;
        this.wishLines = wishLines;
        this.wishTiers = wishTiers;
        this.memo = memo;
        this.queueId = queueId;
    }

    public Summoner getSummoner() {
        return summoner;
    }

    public LeagueEntries getLeagueEntries() {
        return leagueEntries;
    }

    public List<Line> getLines() {
        return lines;
    }

    public List<Line> getWishLines() {
        return wishLines;
    }

    public List<Tier> getWishTiers() {
        return wishTiers;
    }

    public Long getUserId() {
        return userId;
    }

    public String getMemo() {
        return memo;
    }

    public QueueId getQueueId() {
        return queueId;
    }
}
