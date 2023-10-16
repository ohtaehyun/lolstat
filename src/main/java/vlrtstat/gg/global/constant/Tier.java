package vlrtstat.gg.global.constant;

public enum Tier {
    CHALLENGER("CHALLENGER"),
    GRANDMASTER("GRANDMASTER"),
    MASTER("MASTER"),
    DIAMOND("DIAMOND"),
    EMERALD("EMERALD"),
    PLATINUM("PLATINUM"),
    GOLD("GOLD"),
    SILVER("SILVER"),
    BRONZE("BRONZE"),
    IRON("IRON"),
    UNRANKED("UNRANKED");

    private String text;

    public String getText() {
        return text;
    }

    Tier(String text) {

        this.text = text;
    }

    public static Tier fromText(String text) {
        for (Tier tier : values()) {
            if (tier.getText().equals(text)) return tier;
        }

        return UNRANKED;
    }

}
