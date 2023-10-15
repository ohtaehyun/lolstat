package vlrtstat.gg.summoner.domain;

import vlrtstat.gg.match.domain.Match;

public class SummonerProfile {
    String summonerName;
    Match[] matches;

    public SummonerProfile() {
    }

    public SummonerProfile(String summonerName, Match[] matches) {
        this.summonerName = summonerName;
        this.matches = matches;
    }

    public String getSummonerName() {
        return summonerName;
    }

    public void setSummonerName(String summonerName) {
        this.summonerName = summonerName;
    }

    public Match[] getMatches() {
        return matches;
    }

    public void setMatches(Match[] matches) {
        this.matches = matches;
    }
}
