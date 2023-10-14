package vlrtstat.gg.match.domain;

public class Team {
    Ban[] bans;
    Objectives objectives;
    int teamId;
    boolean win;

    public Team(Ban[] bans, Objectives objectives, int teamId, boolean win) {
        this.bans = bans;
        this.objectives = objectives;
        this.teamId = teamId;
        this.win = win;
    }

    public Ban[] getBans() {
        return bans;
    }

    public void setBans(Ban[] bans) {
        this.bans = bans;
    }

    public Objectives getObjectives() {
        return objectives;
    }

    public void setObjectives(Objectives objectives) {
        this.objectives = objectives;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public boolean isWin() {
        return win;
    }

    public void setWin(boolean win) {
        this.win = win;
    }
}
