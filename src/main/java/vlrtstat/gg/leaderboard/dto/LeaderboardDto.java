package vlrtstat.gg.leaderboard.dto;

public class LeaderboardDto {
    private String tier;
    private String queue;
    private LeaderboardPlayerDto[] players;

    public LeaderboardDto(String tier, String queue, LeaderboardPlayerDto[] players) {
        this.tier = tier;
        this.queue = queue;
        this.players = players;
    }

    public String getTier() {
        return tier;
    }

    public void setTier(String tier) {
        this.tier = tier;
    }

    public String getQueue() {
        return queue;
    }

    public void setQueue(String queue) {
        this.queue = queue;
    }

    public LeaderboardPlayerDto[] getPlayers() {
        return players;
    }

    public void setPlayers(LeaderboardPlayerDto[] players) {
        this.players = players;
    }
}
