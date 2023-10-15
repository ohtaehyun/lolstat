package vlrtstat.gg.summoner.dto;

import vlrtstat.gg.match.dto.SimpleMatchDto;
import vlrtstat.gg.summoner.domain.Summoner;

public class SummonerProfile {
    String summonerName;
    int summonerLevel;
    SimpleMatchDto[] simpleMatches;

    public SummonerProfile(String summonerName, int summonerLevel, SimpleMatchDto[] simpleMatches) {
        this.summonerName = summonerName;
        this.summonerLevel = summonerLevel;
        this.simpleMatches = simpleMatches;
    }

    public SummonerProfile() {}

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

    public SimpleMatchDto[] getSimpleMatches() {
        return simpleMatches;
    }

    public void setSimpleMatches(SimpleMatchDto[] simpleMatches) {
        this.simpleMatches = simpleMatches;
    }
}
