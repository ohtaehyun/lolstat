package vlrtstat.gg.summoner.service;

import vlrtstat.gg.summoner.domain.Summoner;

public interface SummonerService {
    Summoner searchSummoner(String summonerName);
}
