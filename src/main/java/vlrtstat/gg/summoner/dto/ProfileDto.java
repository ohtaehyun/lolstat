package vlrtstat.gg.summoner.dto;

import vlrtstat.gg.league.domain.LeagueEntry;
import vlrtstat.gg.summoner.domain.Summoner;

public class ProfileDto {
    private String summonerName;
    private Long summonerLevel;
    private int profileIconId;
    private String rank;
    private String tier;
    private int leaguePoints;
    private int wins;
    private int losses;

    public ProfileDto(String summonerName, Long summonerLevel, int profileIconId, String rank, String tier, int leaguePoints, int wins, int losses) {
        this.summonerName = summonerName;
        this.summonerLevel = summonerLevel;
        this.profileIconId = profileIconId;
        this.rank = rank;
        this.tier = tier;
        this.leaguePoints = leaguePoints;
        this.wins = wins;
        this.losses = losses;
    }

    public ProfileDto(Summoner summoner, LeagueEntry leagueEntry) {
        this.summonerName = summoner.getName();
        this.summonerLevel = summoner.getSummonerLevel();
        this.profileIconId = summoner.getProfileIconId();
        this.rank = leagueEntry.getRank();
        this.tier = leagueEntry.getTier();
        this.wins = leagueEntry.getWins();
        this.losses = leagueEntry.getLosses();
        this.leaguePoints = leagueEntry.getLeaguePoints();
    }

    public String getSummonerName() {
        return summonerName;
    }

    public void setSummonerName(String summonerName) {
        this.summonerName = summonerName;
    }

    public Long getSummonerLevel() {
        return summonerLevel;
    }

    public void setSummonerLevel(Long summonerLevel) {
        this.summonerLevel = summonerLevel;
    }

    public int getProfileIconId() {
        return profileIconId;
    }

    public void setProfileIconId(int profileIconId) {
        this.profileIconId = profileIconId;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getTier() {
        return tier;
    }

    public void setTier(String tier) {
        this.tier = tier;
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
}
