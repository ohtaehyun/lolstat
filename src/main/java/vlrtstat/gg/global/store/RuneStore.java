package vlrtstat.gg.global.store;

import org.springframework.context.ApplicationContext;
import vlrtstat.gg.rune.domain.Rune;
import vlrtstat.gg.rune.domain.RuneGroup;
import vlrtstat.gg.rune.repository.RuneRepository;

public class RuneStore {
    private static RuneRepository runeRepository;

    private static void setRuneRepository() {
        ApplicationContext ac = ApplicationContextStore.getApplicationContext();
        runeRepository = ac.getBean("runeRepository", RuneRepository.class);
    }

    public static Rune getRune(int runeId) {
        if (runeRepository == null) setRuneRepository();
        return runeRepository.findRuneByRuneId(runeId);
    }

    public static RuneGroup getRuneGroup(int runeId) {
        if (runeRepository == null) setRuneRepository();
        return runeRepository.findRuneGroupByRuneId(runeId);
    }
}
