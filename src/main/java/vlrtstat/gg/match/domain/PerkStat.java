package vlrtstat.gg.match.domain;

public class PerkStat {
    private int defense;
    private int flex;
    private int offense;

    public PerkStat(int defense, int flex, int offense) {
        this.setDefense(defense);
        this.setFlex(flex);
        this.setOffense(offense);
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getFlex() {
        return flex;
    }

    public void setFlex(int flex) {
        this.flex = flex;
    }

    public int getOffense() {
        return offense;
    }

    public void setOffense(int offense) {
        this.offense = offense;
    }
}
