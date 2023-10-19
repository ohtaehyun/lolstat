package vlrtstat.gg.match.service;

import vlrtstat.gg.match.domain.Match;
import vlrtstat.gg.match.dto.SimpleMatchDto;

public interface MatchService {
    String[] getMatchHistories(String puuid);

    SimpleMatchDto[] searchSimpleMatchesByPuuid(String puuid);

    Match[] searchMatchesByPuuid(String puuid);
}
