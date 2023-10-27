package vlrtstat.gg.match.service;

import vlrtstat.gg.match.domain.Match;
import vlrtstat.gg.match.dto.SimpleMatchDto;

public interface MatchService {
    SimpleMatchDto[] searchSimpleMatchesByPuuid(String puuid, int page);
}
