package vlrtstat.gg.summoner.service;

import vlrtstat.gg.summoner.domain.Summoner;
import vlrtstat.gg.summoner.dto.SummonerProfileDto;

public interface SummonerService {
    Summoner searchSummoner(String gameName, String tagLine);

//    SummonerProfileDto searchSummonerProfile(String summonerName);
}
