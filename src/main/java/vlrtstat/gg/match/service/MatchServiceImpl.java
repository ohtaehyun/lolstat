package vlrtstat.gg.match.service;

import org.springframework.stereotype.Service;
import vlrtstat.gg.match.repository.MatchRepository;

@Service
public class MatchServiceImpl implements MatchService {
    private MatchRepository matchRepository;

    public MatchServiceImpl(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    @Override
    public String[] getMatchHistories(String puuid) {
        return matchRepository.findMatchIdsByPuuid(puuid);
    }
}
