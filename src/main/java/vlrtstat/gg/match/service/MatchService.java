package vlrtstat.gg.match.service;

import vlrtstat.gg.global.filter.QueueIdFilter;
import vlrtstat.gg.match.domain.RiotMatch;
import vlrtstat.gg.match.dto.MatchDto;

import java.util.List;

public interface MatchService {
    RiotMatch searchMatch(String matchId);

    MatchDto[] searchMatchesByPuuid(String puuid, int page, int size);

    MatchDto[] searchMatchedByPuuid(String puuid, int page, int size, QueueIdFilter queueIdFilter);

    List<RiotMatch> searchRiotMatchesByPuuid(String puuid, int page, int size, QueueIdFilter queueIdFilter);
}
