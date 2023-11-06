package vlrtstat.gg.league.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import vlrtstat.gg.global.constant.Tier;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LeagueList {
    private String leagueId;
    private LeagueItem entries;
    private Tier tier;
    private String queue;
    private String name;

    public String getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(String leagueId) {
        this.leagueId = leagueId;
    }

    public LeagueItem getEntries() {
        return entries;
    }

    public void setEntries(LeagueItem entries) {
        this.entries = entries;
    }

    public Tier getTier() {
        return tier;
    }

    public void setTier(String tier) {
        this.tier = Tier.fromText(tier);
    }

    public String getQueue() {
        return queue;
    }

    public void setQueue(String queue) {
        this.queue = queue;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
