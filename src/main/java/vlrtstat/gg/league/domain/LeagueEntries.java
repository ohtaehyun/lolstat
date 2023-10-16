package vlrtstat.gg.league.domain;

public class LeagueEntries {
    private LeagueEntry soloLeague;
    private LeagueEntry flexLeague;

    public LeagueEntries(LeagueEntry soloLeague, LeagueEntry flexLeague) {
        this.soloLeague = soloLeague;
        this.flexLeague = flexLeague;
    }

    public LeagueEntry getSoloLeague() {
        return soloLeague;
    }

    public void setSoloLeague(LeagueEntry soloLeague) {
        this.soloLeague = soloLeague;
    }

    public LeagueEntry getFlexLeague() {
        return flexLeague;
    }

    public void setFlexLeague(LeagueEntry flexLeague) {
        this.flexLeague = flexLeague;
    }
}
