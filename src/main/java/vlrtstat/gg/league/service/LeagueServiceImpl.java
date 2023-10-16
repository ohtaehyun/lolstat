package vlrtstat.gg.league.service;

import org.springframework.stereotype.Service;
import vlrtstat.gg.global.constant.QueueType;
import vlrtstat.gg.league.domain.LeagueEntries;
import vlrtstat.gg.league.domain.LeagueEntry;
import vlrtstat.gg.league.repository.LeagueRepository;

import java.util.Arrays;

@Service
public class LeagueServiceImpl implements  LeagueService{
    private LeagueRepository leagueRepository;

    public LeagueServiceImpl(LeagueRepository leagueRepository) {
        this.leagueRepository = leagueRepository;
    }

    @Override
    public LeagueEntries searchLeagueEntries(String summonerId) {
        LeagueEntry[] leagueEntries = leagueRepository.findBySummonerId(summonerId);

        LeagueEntry soloEntry = Arrays
                .stream(leagueEntries)
                .filter(leagueEntry -> leagueEntry.getQueueType() == QueueType.RANKED_SOLO)
                .findAny()
                .orElse(new LeagueEntry(QueueType.RANKED_SOLO, summonerId));

        LeagueEntry flexEntry = Arrays
                .stream(leagueEntries)
                .filter(leagueEntry -> leagueEntry.getQueueType() == QueueType.RANKED_TEAM)
                .findAny()
                .orElse(new LeagueEntry(QueueType.RANKED_TEAM, summonerId));

        return new LeagueEntries(soloEntry, flexEntry);
    }
}
