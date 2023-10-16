package vlrtstat.gg.league.service;

import vlrtstat.gg.league.domain.LeagueEntry;

public interface LeagueService {
    LeagueEntry[] findLeagueEntryBySummonerId(String summonerId);
}
