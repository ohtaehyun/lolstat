package vlrtstat.gg.duo.constant;

public enum DuoMatchFilter {
    MATCHING("MATCHING", false),
    MATCHED("MATCHED", true),
    ALL("ALL", null);

    private String text;

    private Boolean boolValue;

    DuoMatchFilter(String text, Boolean boolValue) {
        this.text = text;
        this.boolValue = boolValue;
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

    public Boolean getBoolValue() {
        return boolValue;
    }
}
