package vlrtstat.gg.riotMatch.controller;

import org.springframework.web.bind.annotation.RestController;
import vlrtstat.gg.riotMatch.service.MatchService;

@RestController
public class MatchController {
    private MatchService matchService;

    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }
}
