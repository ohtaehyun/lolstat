package vlrtstat.gg.duo.constant;

public enum DuoMatchFilter {
    MATCHING("matching"),
    MATCHED("matched"),
    ALL("all");

    private String text;

    DuoMatchFilter(String text) {
        this.text = text;
    }

    public static DuoMatchFilter fromText(String text) {
        for (DuoMatchFilter duoFilter : values()) {
            if (duoFilter.text.equals(text)) return duoFilter;
        }
        return DuoMatchFilter.ALL;
    }

    public String getText() {
        return text;
    }
}
