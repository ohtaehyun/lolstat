package vlrtstat.gg.global.constant;

public enum LeaderboardTier {
    CHALLENGER(1, "challengerleagues"),
    GRAND_MASTER(2, "grandmasterleagues"),
    MASTER(3, "masterleagues");

    private int page;
    private String text;

    LeaderboardTier(int page, String text) {
        this.page = page;
        this.text = text;
    }

    static public LeaderboardTier fromPage(int page) {
        for (LeaderboardTier value : values()) {
            if (value.page == page) return value;
        }
        return CHALLENGER;
    }

    public int getPage() {
        return page;
    }

    public String getText() {
        return text;
    }
}
