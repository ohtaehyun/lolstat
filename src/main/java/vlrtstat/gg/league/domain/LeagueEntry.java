package vlrtstat.gg.league.domain;

import vlrtstat.gg.global.constant.QueueType;
import vlrtstat.gg.global.constant.Rank;
import vlrtstat.gg.global.constant.Tier;
import vlrtstat.gg.league.dto.LeagueEntryDto;

public class LeagueEntry {
    private String leagueId;
    private String summonerId;
    private String summonerName;
    private QueueType queueType;
    private Tier tier;
    private Rank rank;
    private int leaguePoints;
    private int wins;
    private int losses;
    private boolean hotStreak;
    private boolean veteran;
    private boolean freshBlood;
    private boolean inactive;
    private MiniSeries miniSeries;

    public LeagueEntry(String leagueId, String summonerId, String summonerName, String queueType, String tier, String rank, int leaguePoints, int wins, int losses, boolean hotStreak, boolean veteran, boolean freshBlood, boolean inactive, MiniSeries miniSeries) {
        this.leagueId = leagueId;
        this.summonerId = summonerId;
        this.summonerName = summonerName;
        this.queueType = QueueType.fromText(queueType);
        this.tier = Tier.fromText(tier);
        this.rank = Rank.fromText(rank);
        this.leaguePoints = leaguePoints;
        this.wins = wins;
        this.losses = losses;
        this.hotStreak = hotStreak;
        this.veteran = veteran;
        this.freshBlood = freshBlood;
        this.inactive = inactive;
        this.miniSeries = miniSeries;
    }

    public LeagueEntry(QueueType queueType, String summonerId) {
        this.summonerId = summonerId;
        this.queueType = queueType;
        this.tier = Tier.UNRANKED;
        this.rank = Rank.UNRANKED;
        this.wins = 0;
        this.losses = 0;
    }

    public LeagueEntry() {
    }

    public String getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(String leagueId) {
        this.leagueId = leagueId;
    }

    public String getSummonerId() {
        return summonerId;
    }

    public void setSummonerId(String summonerId) {
        this.summonerId = summonerId;
    }

    public String getSummonerName() {
        return summonerName;
    }

    public void setSummonerName(String summonerName) {
        this.summonerName = summonerName;
    }

    public QueueType getQueueType() {
        return queueType;
    }

    public void setQueueType(String queueType) {
        this.queueType = QueueType.fromText(queueType);
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

    public void setRank(String rank) {
        this.rank = Rank.fromText(rank);
    }

    public int getLeaguePoints() {
        return leaguePoints;
    }

    public void setLeaguePoints(int leaguePoints) {
        this.leaguePoints = leaguePoints;
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

    public boolean isHotStreak() {
        return hotStreak;
    }

    public void setHotStreak(boolean hotStreak) {
        this.hotStreak = hotStreak;
    }

    public boolean isVeteran() {
        return veteran;
    }

    public void setVeteran(boolean veteran) {
        this.veteran = veteran;
    }

    public boolean isFreshBlood() {
        return freshBlood;
    }

    public void setFreshBlood(boolean freshBlood) {
        this.freshBlood = freshBlood;
    }

    public boolean isInactive() {
        return inactive;
    }

    public void setInactive(boolean inactive) {
        this.inactive = inactive;
    }

    public MiniSeries getMiniSeries() {
        return miniSeries;
    }

    public void setMiniSeries(MiniSeries miniSeries) {
        this.miniSeries = miniSeries;
    }

    public LeagueEntryDto toDto() {
        return new LeagueEntryDto(
                queueType,
                tier,
                rank,
                wins,
                losses,
                leaguePoints
        );
    }
}
