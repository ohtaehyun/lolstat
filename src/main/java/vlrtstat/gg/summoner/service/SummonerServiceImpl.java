package vlrtstat.gg.summoner.service;

import org.springframework.stereotype.Service;
import vlrtstat.gg.match.domain.Match;
import vlrtstat.gg.match.repository.MatchRepository;
import vlrtstat.gg.summoner.domain.Summoner;
import vlrtstat.gg.summoner.domain.SummonerProfile;
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
        ArrayList<Match> matches = new ArrayList<>();
        for (String matchId : MatchIds) {
            matches.add(matchRepository.findById(matchId));
        }
        SummonerProfile summonerProfile = new SummonerProfile();
        summonerProfile.setSummonerName(summoner.getName());
        summonerProfile.setMatches(matches.stream().toArray(match -> new Match[match]));

        return summonerProfile;
    }
}
