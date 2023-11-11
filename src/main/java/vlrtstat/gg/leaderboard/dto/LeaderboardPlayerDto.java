package vlrtstat.gg.leaderboard.dto;

import vlrtstat.gg.league.domain.LeagueItem;

public class LeaderboardPlayerDto implements Comparable<LeaderboardPlayerDto>{
    private String summonerId;
    private String summonerName;
    private String rank;
    private int leaguePoints;
    private int wins;
    private int loses;

    public LeaderboardPlayerDto(String summonerId, String summonerName, String rank, int leaguePoints, int wins, int loses) {
        this.summonerId = summonerId;
        this.summonerName = summonerName;
        this.rank = rank;
        this.leaguePoints = leaguePoints;
        this.wins = wins;
        this.loses = loses;
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

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
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

    public int getLoses() {
        return loses;
    }

    public void setLoses(int loses) {
        this.loses = loses;
    }

    public static LeaderboardPlayerDto fromLeagueItem(LeagueItem leagueItem) {
        return new LeaderboardPlayerDto(
                leagueItem.getSummonerId(),
                leagueItem.getSummonerName(),
                leagueItem.getRank().getText(),
                leagueItem.getLeaguePoints(),
                leagueItem.getWins(),
                leagueItem.getLosses()
        );
    }

    @Override
    public int compareTo(LeaderboardPlayerDto playerDto) {
        return playerDto.leaguePoints - leaguePoints;
    }
}
