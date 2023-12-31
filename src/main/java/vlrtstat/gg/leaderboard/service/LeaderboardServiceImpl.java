package vlrtstat.gg.leaderboard.service;

import org.springframework.stereotype.Service;
import vlrtstat.gg.global.constant.LeaderboardTier;
import vlrtstat.gg.global.constant.Queue;
import vlrtstat.gg.leaderboard.dto.LeaderboardDto;
import vlrtstat.gg.leaderboard.dto.LeaderboardPlayerDto;
import vlrtstat.gg.league.domain.LeagueList;
import vlrtstat.gg.league.repository.LeagueRepository;

import java.util.Arrays;

@Service
public class LeaderboardServiceImpl implements LeaderboardService {
    private LeagueRepository leagueRepository;

    public LeaderboardServiceImpl(LeagueRepository leagueRepository) {
        this.leagueRepository = leagueRepository;
    }

    @Override
    public LeaderboardDto searchLeaderboard(int page, Queue queue) {
        LeaderboardTier leaderboardTier = LeaderboardTier.fromPage(page);
        LeagueList leagueList = leagueRepository.findLeague(leaderboardTier.getText(), queue);
        LeaderboardPlayerDto[] players = Arrays
                .stream(leagueList.getEntries())
                .map(LeaderboardPlayerDto::fromLeagueItem)
                .toArray(LeaderboardPlayerDto[]::new);
        Arrays.sort(players);

        return new LeaderboardDto(
                leagueList.getTier().getText(),
                leagueList.getQueue(),
                players

        );
    }
}
