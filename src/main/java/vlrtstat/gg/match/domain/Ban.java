package vlrtstat.gg.match.domain;

public class Ban {
    private int championId;
    private int pickTurn;

    public Ban(int championId, int pickTurn) {
        this.setChampionId(championId);
        this.setPickTurn(pickTurn);
    }

    public int getChampionId() {
        return championId;
    }

    public void setChampionId(int championId) {
        this.championId = championId;
    }

    public int getPickTurn() {
        return pickTurn;
    }

    public void setPickTurn(int pickTurn) {
        this.pickTurn = pickTurn;
    }
}
