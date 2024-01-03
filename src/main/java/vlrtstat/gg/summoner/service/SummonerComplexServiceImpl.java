package vlrtstat.gg.summoner.service;

import org.springframework.stereotype.Service;
import vlrtstat.gg.league.domain.LeagueEntries;
import vlrtstat.gg.league.service.LeagueService;
import vlrtstat.gg.match.dto.MatchDto;
import vlrtstat.gg.match.dto.SimpleMatchDto;
import vlrtstat.gg.match.service.MatchService;
import vlrtstat.gg.summoner.domain.Account;
import vlrtstat.gg.summoner.domain.Summoner;
import vlrtstat.gg.summoner.dto.SummonerProfileDto;

@Service
public class SummonerComplexServiceImpl implements SummonerComplexService {
    private SummonerService summonerService;
    private LeagueService leagueService;
    private MatchService matchService;

    public SummonerComplexServiceImpl(SummonerService summonerService, LeagueService leagueService, MatchService matchService) {
        this.summonerService = summonerService;
        this.leagueService = leagueService;
        this.matchService = matchService;
    }

    @Override
    public SummonerProfileDto searchSummoner(String gameName, String tagLine) {
        Summoner summoner = summonerService.searchSummoner(gameName, tagLine);
        LeagueEntries leagueEntries = leagueService.searchLeagueEntries(summoner.getId());

        MatchDto[] matchDtos = matchService.searchMatchesByPuuid(summoner.getPuuid(), 1);
        return new SummonerProfileDto(summoner, leagueEntries, matchDtos);
    }

    @Override
    public SummonerProfileDto searchSummoner(String puuid) {
        Summoner summoner = summonerService.searchSummoner(puuid);
        LeagueEntries leagueEntries = leagueService.searchLeagueEntries(summoner.getId());

        MatchDto[] matchDtos = matchService.searchMatchesByPuuid(summoner.getPuuid(), 1);
        return new SummonerProfileDto(summoner, leagueEntries, matchDtos);
    }

    @Override
    public SummonerProfileDto searchBySummonerId(String summonerId) {
        Summoner summoner = summonerService.findBySummonerId(summonerId);
        LeagueEntries leagueEntries = leagueService.searchLeagueEntries(summoner.getId());

        MatchDto[] matchDtos = matchService.searchMatchesByPuuid(summoner.getPuuid(), 1);
        return new SummonerProfileDto(summoner, leagueEntries, matchDtos);
    }
}
