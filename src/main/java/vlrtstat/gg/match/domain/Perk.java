package vlrtstat.gg.match.domain;

public class Perk {
    PerkStat statPerks;
    PerkStyle[] styles;

    public Perk(PerkStat statPerks, PerkStyle[] styles) {
        this.statPerks = statPerks;
        this.styles = styles;
    }

    public PerkStat getStatPerks() {
        return statPerks;
    }

    public void setStatPerks(PerkStat statPerks) {
        this.statPerks = statPerks;
    }

    public PerkStyle[] getStyles() {
        return styles;
    }

    public void setStyles(PerkStyle[] styles) {
        this.styles = styles;
    }
}
