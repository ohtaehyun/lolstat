package vlrtstat.gg.summoner.service;

import org.springframework.stereotype.Service;
import vlrtstat.gg.league.domain.LeagueEntries;
import vlrtstat.gg.league.service.LeagueService;
import vlrtstat.gg.match.dto.SimpleMatchDto;
import vlrtstat.gg.match.service.MatchService;
import vlrtstat.gg.summoner.domain.Summoner;
import vlrtstat.gg.summoner.dto.ProfileDto;
import vlrtstat.gg.summoner.dto.SummonerProfileDto;

@Service
public class SummonerComplexServiceImpl implements SummonerComplexService{
    private SummonerService summonerService;
    private LeagueService leagueService;
    private MatchService matchService;

    public SummonerComplexServiceImpl(SummonerService summonerService, LeagueService leagueService, MatchService matchService) {
        this.summonerService = summonerService;
        this.leagueService = leagueService;
        this.matchService = matchService;
    }

    @Override
    public SummonerProfileDto searchSummoner(String summonerName) {
        Summoner summoner = summonerService.searchSummoner(summonerName);
        LeagueEntries leagueEntries = leagueService.searchLeagueEntries(summoner.getId());
        SimpleMatchDto[] simpleMatchDtos = matchService.searchSimpleMatchesByPuuid(summoner.getPuuid());
        SummonerProfileDto summonerProfile = new SummonerProfileDto(summoner, leagueEntries, simpleMatchDtos);
        return summonerProfile;
    }
}
