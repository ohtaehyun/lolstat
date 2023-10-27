package vlrtstat.gg.match.controller;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.QueryParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import vlrtstat.gg.match.dto.SimpleMatchDto;
import vlrtstat.gg.match.service.MatchService;

@RestController
public class MatchController {
    private MatchService matchService;

    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }

    @GetMapping("matches/{puuid}")
    SimpleMatchDto[] searchMatch(@PathVariable("puuid") String puuid, @RequestParam(value = "page", defaultValue = "1") int page) {
        return matchService.searchSimpleMatchesByPuuid(puuid, page);
    }
}
