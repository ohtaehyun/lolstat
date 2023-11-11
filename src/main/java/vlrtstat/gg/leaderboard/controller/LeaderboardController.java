package vlrtstat.gg.leaderboard.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import vlrtstat.gg.global.constant.Queue;
import vlrtstat.gg.leaderboard.dto.LeaderboardDto;
import vlrtstat.gg.leaderboard.service.LeaderboardService;
import vlrtstat.gg.league.domain.LeagueList;

@RestController
public class LeaderboardController {
    private LeaderboardService leaderboardService;

    public LeaderboardController(LeaderboardService leaderboardService) {
        this.leaderboardService = leaderboardService;
    }

    @GetMapping("/leaderboard")
    LeaderboardDto searchLeaderboard(
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "queue", defaultValue = "RANKED_SOLO_5x5") Queue queue
    ) {
        return leaderboardService.searchLeaderboard(page, queue);
    }
}
