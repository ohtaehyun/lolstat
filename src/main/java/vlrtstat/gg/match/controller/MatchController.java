package vlrtstat.gg.match.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import vlrtstat.gg.global.filter.QueueIdFilter;
import vlrtstat.gg.match.dto.MatchDto;
import vlrtstat.gg.match.service.MatchService;

@RestController
@Tag(name = "Match", description = "전적 API")
public class MatchController {
    private final MatchService matchService;

    public MatchController(MatchService matchService) {
        this.matchService = matchService;
    }

    @GetMapping("matches/{puuid}")
    @Operation(description = "소환사 전적 검색 v2")
    MatchDto[] searchMatchV2(
            @PathVariable("puuid") String puuid,
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "queue", required = false, defaultValue = "ALL") QueueIdFilter queueIdFilter
            ) {
        return matchService.searchMatchedByPuuid(puuid, page, queueIdFilter);
    }
}