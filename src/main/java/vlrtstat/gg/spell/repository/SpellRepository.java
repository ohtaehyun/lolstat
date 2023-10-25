package vlrtstat.gg.spell.repository;

import vlrtstat.gg.spell.domain.Spell;

public interface SpellRepository {
    Spell findById(int id);
    Spell[] findByIds(int[] ids);
}
