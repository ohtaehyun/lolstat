package vlrtstat.gg.global.store;

import org.springframework.context.ApplicationContext;
import vlrtstat.gg.spell.domain.Spell;
import vlrtstat.gg.spell.repository.SpellRepository;

public class SpellStore {
    private static SpellRepository spellRepository;

    private static void setSpellRepository() {
        ApplicationContext ac = ApplicationContextStore.getApplicationContext();
        spellRepository = ac.getBean("jsonSpellRepository", SpellRepository.class);
    }

    public static Spell getSpell(int spellId) {
        if (spellRepository == null) setSpellRepository();
        return spellRepository.findById(spellId);
    }

    public static Spell[] getSpells(int[] spellIds) {
        if (spellRepository == null) setSpellRepository();
        return spellRepository.findByIds(spellIds);
    }
}
