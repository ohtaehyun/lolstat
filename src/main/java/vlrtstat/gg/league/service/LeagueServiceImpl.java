package vlrtstat.gg.league.service;

import vlrtstat.gg.league.domain.LeagueEntry;
import vlrtstat.gg.league.repository.LeagueRepository;

public class LeagueServiceImpl implements  LeagueService{
    private LeagueRepository leagueRepository;

    public LeagueServiceImpl(LeagueRepository leagueRepository) {
        this.leagueRepository = leagueRepository;
    }

    @Override
    public LeagueEntry[] findLeagueEntryBySummonerId(String summonerId) {
        return new LeagueEntry[0];
    }
}
