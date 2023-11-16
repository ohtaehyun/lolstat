package vlrtstat.gg.match.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.QueryParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import vlrtstat.gg.match.domain.RiotMatch;
import vlrtstat.gg.match.dto.SimpleMatchDto;
import vlrtstat.gg.match.service.MatchService;

@RestController
@Tag(name = "MatchResponse", description = "전적 API")
public class MatchController {
    private MatchService matchService;

    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }

    @GetMapping("matches/v2/{puuid}")
    @Operation(description = "소환사 전적 검색 v2")
    RiotMatch[] searchMatchV2(@PathVariable("puuid") String puuid, @RequestParam(value = "page", defaultValue = "1") int page) {
        return matchService.searchMatchesByPuuid(puuid, page);
    }

    @GetMapping("matches/{puuid}")
    @Operation(description = "소환사 전적 검색")
    SimpleMatchDto[] searchMatch(@PathVariable("puuid") String puuid, @RequestParam(value = "page", defaultValue = "1") int page) {
        return matchService.searchSimpleMatchesByPuuid(puuid, page);
    }

    @GetMapping("timeline/{matchId}")
    @Operation(description = "매치 상세 타임라인 검색")
    Object searchTimeline(@PathVariable("matchId") String matchId) {

        return null;
    }
}
