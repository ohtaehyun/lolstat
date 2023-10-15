package vlrtstat.gg.summoner.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import vlrtstat.gg.summoner.domain.Summoner;
import vlrtstat.gg.summoner.domain.SummonerProfile;
import vlrtstat.gg.summoner.service.SummonerService;

@RestController
public class SummonerController {
    private SummonerService summonerService;

    public SummonerController(SummonerService summonerService) {
        this.summonerService = summonerService;
    }

    @GetMapping("/summoner/{summonerName}")
    public SummonerProfile search(@PathVariable("summonerName") String summonerName) {
        return summonerService.searchSummonerProfile(summonerName);
    }
}
