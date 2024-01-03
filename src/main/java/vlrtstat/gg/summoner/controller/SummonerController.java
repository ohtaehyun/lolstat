package vlrtstat.gg.summoner.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vlrtstat.gg.summoner.dto.SummonerProfileDto;
import vlrtstat.gg.summoner.service.SummonerComplexService;

@RestController
@RequestMapping("/summoner")
@Tag(name = "summoner", description = "소환사 API")
public class SummonerController {
    private SummonerComplexService summonerComplexService;

    public SummonerController(SummonerComplexService summonerComplexService) {
        this.summonerComplexService = summonerComplexService;
    }

    @GetMapping("/{summonerName}")
    @Operation(description = "소환사 정보 검색")
    public SummonerProfileDto searchSummoner(@PathVariable("summonerName") String summonerName) {
        String[] summonerInfo = summonerName.split("-");
        return summonerComplexService.searchSummoner(summonerInfo[0], summonerInfo[1]);
    }

    @GetMapping("/puuid/{puuid}")
    @Operation(description = "puuid로 소환사 정보 검색")
    public SummonerProfileDto searchSummonerByPuuid(@PathVariable("puuid") String puuid) {
        return summonerComplexService.searchSummoner(puuid);
    }

    @GetMapping("/puuid/{summonerId}")
    @Operation(description = "소환사 정보 검색")
    public SummonerProfileDto searchSummonerBySummonerId(@PathVariable("summonerId") String summonerId) {
        return summonerComplexService.searchBySummonerId(summonerId);
    }
}
