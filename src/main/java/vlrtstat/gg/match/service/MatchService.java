package vlrtstat.gg.match.service;

import vlrtstat.gg.match.domain.RiotMatch;
import vlrtstat.gg.match.dto.MatchDto;
import vlrtstat.gg.match.dto.SimpleMatchDto;

public interface MatchService {
    RiotMatch searchMatch(String matchId);

    MatchDto[] searchMatchesByPuuid(String puuid, int page);
}
