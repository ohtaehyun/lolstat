package vlrtstat.gg.duo.controller;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import vlrtstat.gg.duo.dto.AddDuoDto;
import vlrtstat.gg.duo.dto.AddDuoRequest;
import vlrtstat.gg.duo.service.DuoService;
import vlrtstat.gg.jwt.LoginUser;
import vlrtstat.gg.league.domain.LeagueEntries;
import vlrtstat.gg.league.service.LeagueService;
import vlrtstat.gg.summoner.domain.Summoner;
import vlrtstat.gg.summoner.service.SummonerService;
import vlrtstat.gg.user.domain.User;

@RestController("duo")
@Tag(name = "Duo", description = "듀오 찾기 관련 API")
public class DuoController {
    private SummonerService summonerService;

    private LeagueService leagueService;

    private DuoService duoService;

    public DuoController(SummonerService summonerService, LeagueService leagueService, DuoService duoService) {
        this.summonerService = summonerService;
        this.leagueService = leagueService;
        this.duoService = duoService;
    }

    @PostMapping("/")
    @Parameter(name = "Authorization", required = true, in = ParameterIn.HEADER)
    public void AddDuo(@RequestBody @Valid AddDuoRequest addDuoRequest, @LoginUser User user) {
        Summoner summoner = summonerService.searchSummoner(addDuoRequest.getGameName(), addDuoRequest.getTagLine());
        LeagueEntries leagueEntries = leagueService.searchLeagueEntries(summoner.getId());
        AddDuoDto addDuoDto = new AddDuoDto(user.getId(), summoner, leagueEntries, addDuoRequest.getLine(), addDuoRequest.getWishLines(), addDuoRequest.getWishTiers(), addDuoRequest.getMemo());
        duoService.AddDuo(addDuoDto);
    }
}
