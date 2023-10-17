package vlrtstat.gg.league.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import vlrtstat.gg.global.constant.QueueType;
import vlrtstat.gg.global.constant.Rank;
import vlrtstat.gg.global.constant.Tier;
import vlrtstat.gg.league.domain.LeagueEntry;

@Schema(description = "랭크 정보")
public class LeagueEntryDto {
    private QueueType queueType;
    private Tier tier;
    private Rank rank;
    private int leaguePoints;
    private int wins;
    private int losses;

    public LeagueEntryDto(QueueType queueType, Tier tier, Rank rank, int wins, int losses, int leaguePoints) {
        this.queueType = queueType;
        this.tier = tier;
        this.rank = rank;
        this.wins = wins;
        this.losses = losses;
        this.leaguePoints = leaguePoints;
    }

    public LeagueEntryDto(LeagueEntry leagueEntry) {
        this.queueType = leagueEntry.getQueueType();
        this.tier = leagueEntry.getTier();
        this.rank = leagueEntry.getRank();
        this.wins = leagueEntry.getWins();
        this.losses = leagueEntry.getLosses();
        this.leaguePoints = leagueEntry.getLeaguePoints();
    }

    public QueueType getQueueType() {
        return queueType;
    }

    public void setQueueType(QueueType queueType) {
        this.queueType = queueType;
    }

    public Tier getTier() {
        return tier;
    }

    public void setTier(Tier tier) {
        this.tier = tier;
    }

    public Rank getRank() {
        return rank;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public int getLeaguePoints() {
        return leaguePoints;
    }

    public void setLeaguePoints(int leaguePoints) {
        this.leaguePoints = leaguePoints;
    }
}
