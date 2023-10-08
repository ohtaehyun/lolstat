package vlrtstat.gg.match.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import vlrtstat.gg.match.service.MatchService;

@RestController
public class MatchController {
    private MatchService matchService;

    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }
}
