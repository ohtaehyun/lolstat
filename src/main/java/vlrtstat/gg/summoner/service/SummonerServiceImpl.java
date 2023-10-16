package vlrtstat.gg.summoner.service;

import org.springframework.stereotype.Service;
import vlrtstat.gg.match.domain.Match;
import vlrtstat.gg.match.dto.SimpleMatchDto;
import vlrtstat.gg.match.repository.MatchRepository;
import vlrtstat.gg.summoner.domain.Summoner;
import vlrtstat.gg.summoner.dto.SummonerProfile;
import vlrtstat.gg.summoner.repository.SummonerRepository;

import java.util.ArrayList;

@Service
public class SummonerServiceImpl implements SummonerService {
    private SummonerRepository summonerRepository;
    private MatchRepository matchRepository;

    public SummonerServiceImpl(SummonerRepository summonerRepository, MatchRepository matchRepository) {
        this.summonerRepository = summonerRepository;
        this.matchRepository = matchRepository;
    }

    @Override
    public Summoner searchSummoner(String summonerName) {
        return summonerRepository.findByName(summonerName);
    }

    @Override
    public SummonerProfile searchSummonerProfile(String summonerName) {
        Summoner summoner = summonerRepository.findByName(summonerName);
        String puuid = summoner.getPuuid();
        String[] MatchIds = matchRepository.findIdsByPuuid(puuid);
        ArrayList<SimpleMatchDto> matches = new ArrayList<>();
        for (String matchId : MatchIds) {
            matches.add(matchRepository.findById(matchId).toSimpleMatchDto());
        }
        SummonerProfile summonerProfile = new SummonerProfile();
        summonerProfile.setSummonerName(summoner.getName());
        summonerProfile.setSummonerLevel(summoner.getSummonerLevel());
        summonerProfile.setSimpleMatches(matches.stream().toArray(match -> new SimpleMatchDto[match]));

        return summonerProfile;
    }
}
