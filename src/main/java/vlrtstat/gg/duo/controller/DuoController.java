package vlrtstat.gg.duo.controller;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import vlrtstat.gg.duo.constant.DuoMatchFilter;
import vlrtstat.gg.duo.dto.*;
import vlrtstat.gg.duo.service.DuoService;
import vlrtstat.gg.global.constant.QueueId;
import vlrtstat.gg.global.filter.QueueIdFilter;
import vlrtstat.gg.jwt.LoginUser;
import vlrtstat.gg.league.domain.LeagueEntries;
import vlrtstat.gg.league.service.LeagueService;
import vlrtstat.gg.match.dto.MatchDto;
import vlrtstat.gg.match.service.MatchService;
import vlrtstat.gg.summoner.domain.Summoner;
import vlrtstat.gg.summoner.service.SummonerService;
import vlrtstat.gg.user.domain.User;

import java.util.Arrays;
import java.util.List;
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
    @Parameter(name = "user", hidden = true)
    public DuoListResponse getDuoList(
            @LoginUser User user,
            @RequestParam(value = "page", required = false, defaultValue = "1") Optional<Integer> optionalPage,
            @RequestParam(value = "match", required = false, defaultValue = "ALL") DuoMatchFilter duoMatchFilter,
            @RequestParam(value = "queue", required = false, defaultValue = "ALL") QueueIdFilter queueIdFilter
    ) {
        int page = optionalPage.orElse(1);
        return duoService.duoList(user, page, duoMatchFilter, queueIdFilter);
    }

    @PostMapping("duo")
    @Parameter(name = "Authorization", required = true, in = ParameterIn.HEADER)
    @Parameter(name = "user", hidden = true)
    public void AddDuo(@RequestBody @Valid AddDuoRequest addDuoRequest, @LoginUser User user) {
        Summoner summoner = summonerService.searchSummoner(addDuoRequest.getGameName(), addDuoRequest.getTagLine());
        LeagueEntries leagueEntries = leagueService.searchLeagueEntries(summoner.getId());
        QueueId queueId = addDuoRequest.getDuoQueueId().getQueueId();
        AddDuoDto addDuoDto = new AddDuoDto(user.getId(), summoner, leagueEntries, addDuoRequest.getLines(), addDuoRequest.getWishLines(), addDuoRequest.getWishTiers(), addDuoRequest.getMemo(), queueId);
        duoService.addDuo(addDuoDto);
    }

    @GetMapping("duo/{duoId}")
    @Parameter(name = "Authorization", required = true, in = ParameterIn.HEADER)
    public DuoDetailResponse DuoDetail(@PathVariable("duoId") Long duoId) {
        return duoService.getDuoDetail(duoId);
    }

    @PostMapping("duo/{duoId}")
    @Parameter(name = "Authorization", required = true, in = ParameterIn.HEADER)
    @Parameter(name = "user", hidden = true)
    public void addDuoTicket(@PathVariable("duoId") Long duoId, @LoginUser User user, @RequestBody @Valid AddDuoTicketRequest addDuoRequest) {
        Summoner summoner = summonerService.searchSummoner(addDuoRequest.getGameName(), addDuoRequest.getTagLine());
        LeagueEntries leagueEntries = leagueService.searchLeagueEntries(summoner.getId());

        AddDuoTicketDto addDuoTicketDto = new AddDuoTicketDto(summoner, leagueEntries, user, duoId, addDuoRequest);
        duoService.addDuoTicket(addDuoTicketDto);
    }

    @PostMapping("duo/{duoId}/{ticketId}/accept")
    @Parameter(name = "Authorization", required = true, in = ParameterIn.HEADER)
    @Parameter(name = "user", hidden = true)
    public void acceptTicket(@PathVariable("duoId") Long duoId, @PathVariable("ticketId") Long ticketId, @LoginUser User user) {
        duoService.acceptDuoTicket(duoId, ticketId, user);
    }
}