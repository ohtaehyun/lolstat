package vlrtstat.gg.match.domain;

public class Team {
    private Ban[] bans;
    private Objectives objectives;
    private int teamId;
    private boolean win;

    public Team(Ban[] bans, Objectives objectives, int teamId, boolean win) {
        this.setBans(bans);
        this.setObjectives(objectives);
        this.setTeamId(teamId);
        this.setWin(win);
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
