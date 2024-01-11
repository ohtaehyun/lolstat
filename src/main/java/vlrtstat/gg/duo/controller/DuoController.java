package vlrtstat.gg.duo.controller;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.ws.rs.QueryParam;
import org.springframework.web.bind.annotation.*;
import vlrtstat.gg.duo.constant.DuoMatchFilter;
import vlrtstat.gg.duo.dto.AddDuoDto;
import vlrtstat.gg.duo.dto.AddDuoRequest;
import vlrtstat.gg.duo.dto.DuoListResponse;
import vlrtstat.gg.duo.service.DuoService;
import vlrtstat.gg.jwt.LoginUser;
import vlrtstat.gg.league.domain.LeagueEntries;
import vlrtstat.gg.league.service.LeagueService;
import vlrtstat.gg.summoner.domain.Summoner;
import vlrtstat.gg.summoner.service.SummonerService;
import vlrtstat.gg.user.domain.User;

import java.util.Optional;

@RestController
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

    @GetMapping("duo")
    @Parameter(name = "Authorization", required = true, in = ParameterIn.HEADER)
    public DuoListResponse getDuoList(
            @LoginUser User user,
            @RequestParam(value = "page", required = false, defaultValue = "1") Optional<Integer> optionalPage,
            @RequestParam(value = "filter", required = false, defaultValue = "all") DuoMatchFilter duoMatchFilter
    ) {
        int page = optionalPage.orElse(1);
        return duoService.duoList(user, page, duoMatchFilter);
    }

    @PostMapping("duo")
    @Parameter(name = "Authorization", required = true, in = ParameterIn.HEADER)
    public void AddDuo(@RequestBody @Valid AddDuoRequest addDuoRequest, @LoginUser User user) {
        Summoner summoner = summonerService.searchSummoner(addDuoRequest.getGameName(), addDuoRequest.getTagLine());
        LeagueEntries leagueEntries = leagueService.searchLeagueEntries(summoner.getId());
        AddDuoDto addDuoDto = new AddDuoDto(user.getId(), summoner, leagueEntries, addDuoRequest.getLine(), addDuoRequest.getWishLines(), addDuoRequest.getWishTiers(), addDuoRequest.getMemo());
        duoService.addDuo(addDuoDto);
    }
}