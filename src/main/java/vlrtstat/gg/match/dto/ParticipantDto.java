package vlrtstat.gg.match.dto;

import vlrtstat.gg.participant.domain.Participant;

public class ParticipantDto {
    private String summonerId;
    private String summonerName;
    private int summonerLevel;
    private int kills;
    private int deaths;
    private int assists;
    private int goldEarned;
    private int goldSpent;

    public ParticipantDto(Participant participant) {
        this.summonerId = participant.getSummonerId();
        this.summonerName = participant.getSummonerName();
        this.summonerLevel = participant.getSummonerLevel();
        this.kills = participant.getKills();
        this.deaths = participant.getDeaths();
        this.assists = participant.getAssists();
        this.goldEarned = participant.getGoldEarned();
        this.goldSpent = participant.getGoldSpent();
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

    public int getSummonerLevel() {
        return summonerLevel;
    }

    public void setSummonerLevel(int summonerLevel) {
        this.summonerLevel = summonerLevel;
    }

    public int getKills() {
        return kills;
    }

    public void setKills(int kills) {
        this.kills = kills;
    }

    public int getDeaths() {
        return deaths;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }

    public int getAssists() {
        return assists;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public int getGoldEarned() {
        return goldEarned;
    }

    public void setGoldEarned(int goldEarned) {
        this.goldEarned = goldEarned;
    }

    public int getGoldSpent() {
        return goldSpent;
    }

    public void setGoldSpent(int goldSpent) {
        this.goldSpent = goldSpent;
    }
}
