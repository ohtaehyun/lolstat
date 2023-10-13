package vlrtstat.gg.summoner.service;

import org.springframework.stereotype.Service;
import vlrtstat.gg.summoner.domain.Summoner;
import vlrtstat.gg.summoner.repository.SummonerRepository;

@Service
public class SummonerServiceImpl implements SummonerService {
    private SummonerRepository summonerRepository;

    public SummonerServiceImpl(SummonerRepository summonerRepository) {
        this.summonerRepository = summonerRepository;
    }

    @Override
    public Summoner searchSummoner(String summonerName) {
        return summonerRepository.findByName(summonerName);
    }
}
