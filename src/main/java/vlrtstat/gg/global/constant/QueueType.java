package vlrtstat.gg.global.constant;

public enum QueueType {
    RANKED_SOLO("RANKED_SOLO_5x5"),
    RANKED_TEAM("RANKED_TEAM_5x5"),
    UNKNOWN("UNKNOWN");

    private String text;

    QueueType(String text) {
        this.text = text;
    }

    public static QueueType fromText(String text) {
        for (QueueType queueType : values()) {
            if (queueType.getText().equals(text)) return queueType;
        }
        return UNKNOWN;
    }

    public String getText() {
        return text;
    }
}
