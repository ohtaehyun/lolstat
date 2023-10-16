package vlrtstat.gg.match.service;

import vlrtstat.gg.match.dto.SimpleMatchDto;

public interface MatchService {
    String[] getMatchHistories(String puuid);

    SimpleMatchDto[] searchSimpleMatchesByPuuid(String puuid);
}
