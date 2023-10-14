package vlrtstat.gg.match.domain;

public class Perk {
    PerkStats statPerks;
    PerkStyle[] styles;

    public Perk(PerkStats statPerks, PerkStyle[] styles) {
        this.statPerks = statPerks;
        this.styles = styles;
    }

    public PerkStats getStatPerks() {
        return statPerks;
    }

    public void setStatPerks(PerkStats statPerks) {
        this.statPerks = statPerks;
    }

    public PerkStyle[] getStyles() {
        return styles;
    }

    public void setStyles(PerkStyle[] styles) {
        this.styles = styles;
    }
}
