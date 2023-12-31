package vlrtstat.gg.summoner.service;

import vlrtstat.gg.summoner.domain.Account;
import vlrtstat.gg.summoner.domain.Summoner;
import vlrtstat.gg.summoner.dto.SummonerProfileDto;

public interface SummonerService {
    Summoner searchSummoner(String gameName, String tagLine);

    Summoner searchSummoner(String puuid);

    Summoner findBySummonerId(String summonerId);
}
