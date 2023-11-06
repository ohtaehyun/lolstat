package vlrtstat.gg.league.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import vlrtstat.gg.global.constant.Rank;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LeagueItem {
    private String summonerId;
    private String summonerName;
    private Rank rank;
    private int leaguePoints;
    private int wins;
    private int losses;
}
