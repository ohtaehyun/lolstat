package vlrtstat.gg.leaderboard.service;

import vlrtstat.gg.global.constant.Queue;
import vlrtstat.gg.global.constant.Tier;
import vlrtstat.gg.leaderboard.dto.LeaderboardDto;
import vlrtstat.gg.league.domain.LeagueList;

public interface LeaderboardService {
    LeaderboardDto searchLeaderboard(int page, Queue queue);
}
