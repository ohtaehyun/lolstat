package vlrtstat.gg.leaderboard.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LeaderboardController {
    @GetMapping("/leaderboard/{queue}")
    Object getLeaderboard() {
        return null;
    }
}
