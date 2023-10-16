package vlrtstat.gg.summoner.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import vlrtstat.gg.summoner.dto.SummonerProfileDto;
import vlrtstat.gg.summoner.service.SummonerComplexService;
import vlrtstat.gg.summoner.service.SummonerService;

@RestController
public class SummonerController {
    private SummonerComplexService summonerComplexService;

    public SummonerController(SummonerComplexService summonerComplexService) {
        this.summonerComplexService = summonerComplexService;
    }

    @GetMapping("/summoner/{summonerName}")
    public SummonerProfileDto searchSummoner(@PathVariable("summonerName") String summonerName) {
        return summonerComplexService.searchSummoner(summonerName);
    }
}
