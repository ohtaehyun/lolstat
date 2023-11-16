package vlrtstat.gg.match.service;

import vlrtstat.gg.match.domain.RiotMatch;
import vlrtstat.gg.match.dto.SimpleMatchDto;

public interface MatchService {
    SimpleMatchDto[] searchSimpleMatchesByPuuid(String puuid, int page);

    RiotMatch searchMatch(String matchId);

    RiotMatch[] searchMatchesByPuuid(String puuid, int page);
}
