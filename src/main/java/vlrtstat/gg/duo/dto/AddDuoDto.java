package vlrtstat.gg.duo.dto;

import vlrtstat.gg.global.constant.Line;
import vlrtstat.gg.global.constant.Tier;
import vlrtstat.gg.league.domain.LeagueEntries;
import vlrtstat.gg.summoner.domain.Summoner;

public class AddDuoDto {
    private Long userId;
    private Summoner summoner;
    private LeagueEntries leagueEntries;
    private Line line;
    private Line[] wishLines;
    private Tier[] wishTiers;
    private String memo;

    public AddDuoDto(Long userId, Summoner summoner, LeagueEntries leagueEntries, Line line, Line[] wishLines, Tier[] wishTiers, String memo) {
        this.userId = userId;
        this.summoner = summoner;
        this.leagueEntries = leagueEntries;
        this.line = line;
        this.wishLines = wishLines;
        this.wishTiers = wishTiers;
        this.memo = memo;
    }

    public Summoner getSummoner() {
        return summoner;
    }

    public LeagueEntries getLeagueEntries() {
        return leagueEntries;
    }

    public Line getLine() {
        return line;
    }

    public Line[] getWishLines() {
        return wishLines;
    }

    public Tier[] getWishTiers() {
        return wishTiers;
    }

    public Long getUserId() {
        return userId;
    }

    public String getMemo() {
        return memo;
    }
}
