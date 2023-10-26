package vlrtstat.gg.champion.repository;

import vlrtstat.gg.champion.domain.Champion;

public interface ChampionRepository {
    Champion findById(int id);
}
