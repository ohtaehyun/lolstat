package vlrtstat.gg.rune.domain;

public class Slot {
    private Rune[] runes;

    public Slot() {
    }

    public Rune[] getRunes() {
        return runes;
    }

    public void setRunes(Rune[] runes) {
        this.runes = runes;
    }

    public boolean hasRune(int id) {
        for (Rune rune : runes) {
            if (rune.getId() == id) return true;
        }
        return false;
    }

    public Rune getRuneById(int id) {
        for (Rune rune : runes) {
            if (rune.getId() == id) {
                return rune;
            }
        }
        return new Rune();
    }
}
