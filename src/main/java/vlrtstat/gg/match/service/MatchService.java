package vlrtstat.gg.match.service;

import vlrtstat.gg.global.filter.QueueIdFilter;
import vlrtstat.gg.match.domain.RiotMatch;
import vlrtstat.gg.match.dto.MatchDto;

public interface MatchService {
    RiotMatch searchMatch(String matchId);

    MatchDto[] searchMatchesByPuuid(String puuid, int page);

    MatchDto[] searchMatchedByPuuid(String puuid, int page, QueueIdFilter queueIdFilter);
}
