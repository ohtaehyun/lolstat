package vlrtstat.gg.global.store;

import org.springframework.context.ApplicationContext;
import vlrtstat.gg.champion.domain.Champion;
import vlrtstat.gg.champion.repository.ChampionRepository;

public class ChampionStore {
    private static ChampionRepository championRepository;

    private static void setRepository() {
        ApplicationContext ac = ApplicationContextStore.getApplicationContext();
        championRepository = ac.getBean("championRepository", ChampionRepository.class);
    }

    public static Champion getChampion(int championId) {
        if (championRepository == null) setRepository();
        return championRepository.findById(championId);
    }
}
