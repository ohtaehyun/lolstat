package vlrtstat.gg.duo.service;

import jakarta.ws.rs.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vlrtstat.gg.duo.constant.DuoMatchFilter;
import vlrtstat.gg.duo.domain.Duo;
import vlrtstat.gg.duo.domain.DuoMatchRelation;
import vlrtstat.gg.duo.domain.DuoTicket;
import vlrtstat.gg.duo.domain.DuoTicketMatchRelation;
import vlrtstat.gg.duo.dto.*;
import vlrtstat.gg.duo.error.*;
import vlrtstat.gg.duo.repository.DuoMatchRelationRepository;
import vlrtstat.gg.duo.repository.DuoRepository;
import vlrtstat.gg.duo.repository.DuoTicketMatchRelationRepository;
import vlrtstat.gg.duo.repository.DuoTicketRepository;
import vlrtstat.gg.global.constant.QueueId;
import vlrtstat.gg.global.constant.Tier;
import vlrtstat.gg.global.filter.QueueIdFilter;
import vlrtstat.gg.league.domain.LeagueEntries;
import vlrtstat.gg.league.domain.LeagueEntry;
import vlrtstat.gg.match.domain.RiotMatch;
import vlrtstat.gg.match.service.MatchService;
import vlrtstat.gg.summoner.domain.Summoner;
import vlrtstat.gg.user.domain.User;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class DuoServiceImpl implements DuoService {
    private final DuoRepository duoRepository;

    private final DuoMatchRelationRepository duoMatchRelationRepository;

    private final MatchService matchService;

    private final DuoTicketRepository duoTicketRepository;

    private final DuoTicketMatchRelationRepository duoTicketMatchRelationRepository;

    public DuoServiceImpl(DuoRepository duoRepository, DuoMatchRelationRepository duoMatchRelationRepository, MatchService matchService, DuoTicketRepository duoTicketRepository, DuoTicketMatchRelationRepository duoTicketMatchRelationRepository) {
        this.duoRepository = duoRepository;
        this.duoMatchRelationRepository = duoMatchRelationRepository;
        this.matchService = matchService;
        this.duoTicketRepository = duoTicketRepository;
        this.duoTicketMatchRelationRepository = duoTicketMatchRelationRepository;
    }

    @Override
    @Transactional
    public void addDuo(AddDuoDto addDuoDto) {
        Optional<Duo> optionalDuo = duoRepository.findLiveOne(addDuoDto.getUserId());

        if (optionalDuo.isPresent()) {
            throw new DuoAlreadyExistError();
        }

        Duo duo = new Duo();
        Summoner summoner = addDuoDto.getSummoner();
        QueueId queueId = addDuoDto.getQueueId();

        LeagueEntries leagueEntries = addDuoDto.getLeagueEntries();
        LeagueEntry soloLeague = leagueEntries.getSoloLeague();
        duo.setUserId(addDuoDto.getUserId());
        duo.setGameName(summoner.getGameName());
        duo.setTagLine(summoner.getTagLine());
        duo.setTier(soloLeague.getTier());
        duo.setLines(addDuoDto.getLines());
        duo.setPuuid(summoner.getPuuid());
        duo.setCreatedAt(LocalDateTime.now());
        duo.setExpiredAt(LocalDateTime.now().plusHours(1));
        duo.setMemo(addDuoDto.getMemo());
        duo.setWishLines(addDuoDto.getWishLines());
        duo.setWishTiers(addDuoDto.getWishTiers());
        duo.setQueueId(queueId);
        duoRepository.save(duo);

        List<RiotMatch> riotMatches = matchService.searchRiotMatchesByPuuid(summoner.getPuuid(), 1, 5, QueueIdFilter.fromText(queueId.name()));
        List<DuoMatchRelation> relations = riotMatches.stream().map(match -> {
            DuoMatchRelation duoMatchRelation = new DuoMatchRelation();
            duoMatchRelation.setMatch(match);
            duoMatchRelation.setDuo(duo);
            return duoMatchRelation;
        }).toList();

        duoMatchRelationRepository.saveAll(relations);
    }

    @Override
    @Transactional(readOnly = true)
    public DuoListResponse duoList(User user, int page, DuoMatchFilter duoMatchFilter, QueueIdFilter queueIdFilter) {
        Optional<Duo> myDuo = duoRepository.findLiveOne(user.getId());
        DuoDto myDuoDto = myDuo.isEmpty() ? null : new DuoDto(myDuo.get());

        PageRequest pageRequest = PageRequest.of(page - 1, 20, Sort.Direction.DESC, "createdAt");
        Page<Duo> pageData = duoRepository.findAllByQuery(duoMatchFilter.getBoolValue(), queueIdFilter.getQueueId(), pageRequest);

        List<DuoDto> duoDtos = pageData.getContent().stream().map(duo -> new DuoDto(duo)).toList();

        return new DuoListResponse(myDuoDto, duoDtos);
    }

    @Override
    public DuoDetailResponse getDuoDetail(Long duoId) {
        Optional<Duo> optionalDuo = duoRepository.findById(duoId);
        if (optionalDuo.isEmpty()) throw new NotFoundException();
        DuoDto duoDto = new DuoDto(optionalDuo.get());
        return new DuoDetailResponse(duoDto);
    }

    @Override
    @Transactional
    public void addDuoTicket(AddDuoTicketDto addDuoTicketDto) {
        User user = addDuoTicketDto.getUser();
        Duo duo = duoRepository.findById(addDuoTicketDto.getDuoId()).orElseThrow(NotFoundException::new);
        this.validateDuoAddTicket(duo, user);

        Summoner summoner = addDuoTicketDto.getSummoner();
        Tier tier = addDuoTicketDto.getLeagueEntries().getSoloLeague().getTier();

        DuoTicket duoTicket = new DuoTicket();
        duoTicket.setGameName(summoner.getGameName());
        duoTicket.setTagLine(summoner.getTagLine());
        duoTicket.setLines(addDuoTicketDto.getLines());
        duoTicket.setTier(tier);
        duoTicket.setUser(user);
        duoTicket.setDuo(duo);
        duoTicket.setSelected(false);
        duoTicket.setMemo(addDuoTicketDto.getMemo());
        duoTicket.setCreatedAt(LocalDateTime.now());

        duoTicketRepository.save(duoTicket);

        List<RiotMatch> riotMatches = matchService.searchRiotMatchesByPuuid(summoner.getPuuid(), 1, 5, QueueIdFilter.fromText(duo.getQueueId().name()));
        List<DuoTicketMatchRelation> relations = riotMatches.stream().map(match -> {
            DuoTicketMatchRelation duoMatchRelation = new DuoTicketMatchRelation();
            duoMatchRelation.setRiotMatch(match);
            duoMatchRelation.setDuoTicket(duoTicket);
            return duoMatchRelation;
        }).toList();

        duoTicketMatchRelationRepository.saveAll(relations);
    }

    @Override
    @Transactional
    public void acceptDuoTicket(Long duoId, Long ticketId, User user) {
        Duo duo = duoRepository.findByIdAndUserId(duoId, user.getId()).orElseThrow(NotFoundException::new);
        DuoTicket duoTicket = duo.getTicketById(ticketId).orElseThrow(NotFoundException::new);
        validateDuo(duo);

        duo.setMatched(true);
        duoTicket.setSelected(true);

        duoRepository.save(duo);
        duoTicketRepository.save(duoTicket);
    }

    private void validateDuo(Duo duo) {
        if (duo.isMatched()) throw new DuoAlreadyMatchedError();
        if (duo.getExpiredAt().isBefore(LocalDateTime.now())) throw new DuoExpiredError();
    }

    private void validateDuoAddTicket(Duo duo, User user) {
        this.validateDuo(duo);
        if (duo.getUserId().equals(user.getId())) throw new DuoOwnerTryTicketError();
        Optional<DuoTicket> optionalTicket = duoTicketRepository.findByUserIdAndDuoId(user.getId(), duo.getId());
        if (optionalTicket.isPresent()) throw new DuoTicketAlreadyExist();
    }
}