package vlrtstat.gg.rune.repository;

import vlrtstat.gg.rune.domain.Rune;
import vlrtstat.gg.rune.domain.RuneGroup;

public interface RuneRepository {
    RuneGroup findRuneGroupByRuneId(int id);
    Rune findRuneByRuneId(int id);
}
