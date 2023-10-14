package vlrtstat.gg.match.domain;

public class Ban {
    int championId;
    int pickTurn;

    public Ban(int championId, int pickTurn) {
        this.championId = championId;
        this.pickTurn = pickTurn;
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
