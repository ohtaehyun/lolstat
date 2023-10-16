package vlrtstat.gg.league.service;

import vlrtstat.gg.league.domain.LeagueEntries;

public interface LeagueService {
    LeagueEntries searchLeagueEntries(String summonerId);
}
