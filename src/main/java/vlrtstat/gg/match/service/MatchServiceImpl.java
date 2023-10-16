package vlrtstat.gg.match.service;

import org.springframework.stereotype.Service;
import vlrtstat.gg.match.dto.SimpleMatchDto;
import vlrtstat.gg.match.repository.MatchRepository;

import java.util.ArrayList;

@Service
public class MatchServiceImpl implements MatchService {
    private MatchRepository matchRepository;

    public MatchServiceImpl(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    @Override
    public String[] getMatchHistories(String puuid) {
        return matchRepository.findIdsByPuuid(puuid);
    }

    @Override
    public SimpleMatchDto[] searchSimpleMatchesByPuuid(String puuid) {
        String[] MatchIds = matchRepository.findIdsByPuuid(puuid);
        ArrayList<SimpleMatchDto> matches = new ArrayList<>();
        for (String matchId : MatchIds) {
            matches.add(matchRepository.findById(matchId).toSimpleMatchDto());
        }

        return matches.stream().toArray(match -> new SimpleMatchDto[match]);
    }
}
