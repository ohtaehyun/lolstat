package vlrtstat.gg.summoner.service;

import vlrtstat.gg.summoner.dto.SummonerProfileDto;

public interface SummonerComplexService {
    SummonerProfileDto searchSummoner(String gameName, String tagLine);
    SummonerProfileDto searchSummoner(String puuid);
    SummonerProfileDto searchBySummonerId(String summonerId);
}
