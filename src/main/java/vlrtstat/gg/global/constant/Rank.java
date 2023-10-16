package vlrtstat.gg.global.constant;

public enum Rank {
    RANK_ONE("I"),
    RANK_TWO("II"),
    RANK_THREE("III"),
    RANK_FOUR("IV"),
    UNRANKED("UNRANKED");

    private String text;

    Rank(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public static Rank fromText(String text) {
        for (vlrtstat.gg.global.constant.Rank rank : values()) {
            if (rank.getText().equals(text)) return rank;
        }
        return UNRANKED;
    }
}