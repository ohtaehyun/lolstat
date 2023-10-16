package vlrtstat.gg.summoner.service;

import org.springframework.stereotype.Service;
import vlrtstat.gg.league.domain.LeagueEntry;
import vlrtstat.gg.league.repository.LeagueRepository;
import vlrtstat.gg.match.dto.SimpleMatchDto;
import vlrtstat.gg.match.repository.MatchRepository;
import vlrtstat.gg.summoner.domain.Summoner;
import vlrtstat.gg.summoner.dto.ProfileDto;
import vlrtstat.gg.summoner.dto.SummonerProfileDto;
import vlrtstat.gg.summoner.repository.SummonerRepository;

import java.util.ArrayList;

@Service
public class SummonerServiceImpl implements SummonerService {
    private SummonerRepository summonerRepository;
    private MatchRepository matchRepository;
    private LeagueRepository leagueRepository;

    public SummonerServiceImpl(SummonerRepository summonerRepository, MatchRepository matchRepository, LeagueRepository leagueRepository) {
        this.summonerRepository = summonerRepository;
        this.matchRepository = matchRepository;
        this.leagueRepository = leagueRepository;
    }

    @Override
    public Summoner searchSummoner(String summonerName) {
        return summonerRepository.findByName(summonerName);
    }

//    @Override
//    public SummonerProfileDto searchSummonerProfile(String summonerName) {
//        Summoner summoner = summonerRepository.findByName(summonerName);
//
//        LeagueEntry[] leagueEntry = leagueRepository.findBySummonerId(summoner.getId());
//
//        String[] MatchIds = matchRepository.findIdsByPuuid(summoner.getPuuid());
//        ArrayList<SimpleMatchDto> matches = new ArrayList<>();
//        for (String matchId : MatchIds) {
//            matches.add(matchRepository.findById(matchId).toSimpleMatchDto());
//        }
//
//        ProfileDto profileDto = new ProfileDto(summoner, leagueEntry[0]);
//        SummonerProfileDto summonerProfile = new SummonerProfileDto(profileDto, matches.stream().toArray(match -> new SimpleMatchDto[match]));
//
//        return summonerProfile;
//    }
}
