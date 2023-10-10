package vlrtstat.gg.riotLeaderBoard.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import vlrtstat.gg.riotLeaderBoard.service.RiotLeaderBoardService;

@RestController
public class RiotLeaderBoardController {
    private RiotLeaderBoardService riotLeaderBoardService;

    public RiotLeaderBoardController(RiotLeaderBoardService riotLeaderBoardService) {
        this.riotLeaderBoardService = riotLeaderBoardService;
    }

    @GetMapping("/leaderboards")
    public String getLeaderboards(
            @RequestParam(name = "act", defaultValue = "-1") int act,
            @RequestParam(name = "episode", defaultValue = "-1") int episode
    ) {
        return act + "" + episode + "";
    }
}
