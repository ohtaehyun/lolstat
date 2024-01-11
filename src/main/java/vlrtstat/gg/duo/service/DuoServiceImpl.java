package vlrtstat.gg.duo.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vlrtstat.gg.duo.domain.Duo;
import vlrtstat.gg.duo.dto.AddDuoDto;
import vlrtstat.gg.duo.repository.DuoRepository;
import vlrtstat.gg.league.domain.LeagueEntries;
import vlrtstat.gg.league.domain.LeagueEntry;
import vlrtstat.gg.summoner.domain.Summoner;

import java.time.LocalDateTime;

@Service
public class DuoServiceImpl implements DuoService {
    private final DuoRepository duoRepository;

    public DuoServiceImpl(DuoRepository duoRepository) {
        this.duoRepository = duoRepository;
    }

    @Override
    @Transactional
    public void AddDuo(AddDuoDto addDuoDto) {
        Duo duo = new Duo();
        Summoner summoner = addDuoDto.getSummoner();
        LeagueEntries leagueEntries = addDuoDto.getLeagueEntries();
        LeagueEntry soloLeague = leagueEntries.getSoloLeague();
        duo.setUserId(addDuoDto.getUserId());
        duo.setGameName(summoner.getGameName());
        duo.setTagLine(summoner.getTagLine());
        duo.setTier(soloLeague.getTier());
        duo.setLine(addDuoDto.getLine());
        duo.setPuuid(summoner.getPuuid());
        duo.setCreatedAt(LocalDateTime.now());
        duo.setCreatedAt(LocalDateTime.now().plusHours(1));
        duoRepository.save(duo);
    }
}
