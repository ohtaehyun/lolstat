package vlrtstat.gg.match.domain;

public class Objectives {
    private Objective baron;
    private Objective champion;
    private Objective dragon;
    private Objective inhibitor;
    private Objective riftHerald;
    private Objective tower;

    public Objectives(Objective baron, Objective champion, Objective dragon, Objective inhibitor, Objective riftHerald, Objective tower) {
        this.setBaron(baron);
        this.setChampion(champion);
        this.setDragon(dragon);
        this.setInhibitor(inhibitor);
        this.setRiftHerald(riftHerald);
        this.setTower(tower);
    }

    public Objective getBaron() {
        return baron;
    }

    public void setBaron(Objective baron) {
        this.baron = baron;
    }

    public Objective getChampion() {
        return champion;
    }

    public void setChampion(Objective champion) {
        this.champion = champion;
    }

    public Objective getDragon() {
        return dragon;
    }

    public void setDragon(Objective dragon) {
        this.dragon = dragon;
    }

    public Objective getInhibitor() {
        return inhibitor;
    }

    public void setInhibitor(Objective inhibitor) {
        this.inhibitor = inhibitor;
    }

    public Objective getRiftHerald() {
        return riftHerald;
    }

    public void setRiftHerald(Objective riftHerald) {
        this.riftHerald = riftHerald;
    }

    public Objective getTower() {
        return tower;
    }

    public void setTower(Objective tower) {
        this.tower = tower;
    }
}
