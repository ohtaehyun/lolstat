package vlrtstat.gg.league.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import vlrtstat.gg.global.constant.Rank;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LeagueItem implements Comparable<LeagueItem> {
    private String summonerId;
    private String summonerName;
    private Rank rank;
    private int leaguePoints;
    private int wins;
    private int losses;

    public LeagueItem(String summonerId, String summonerName, String rank, int leaguePoints, int wins, int losses) {
        this.summonerId = summonerId;
        this.summonerName = summonerName;
        this.rank = Rank.fromText(rank);
        this.leaguePoints = leaguePoints;
        this.wins = wins;
        this.losses = losses;
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

    @Override
    public int compareTo(LeagueItem item) {
        return item.getLeaguePoints() - this.leaguePoints;
    }
}
