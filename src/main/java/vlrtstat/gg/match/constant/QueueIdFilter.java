package vlrtstat.gg.match.constant;

import vlrtstat.gg.global.constant.QueueId;

public enum QueueIdFilter {
    ALL("ALL", QueueId.OTHER_GAME),
    SOLO_RANK_GAME("SOLO_RANK_GAME", QueueId.SOLO_RANK_GAME),
    FLEX_RANK_GAME("FLEX_RANK_GAME", QueueId.FLEX_RANK_GAME),
    QUICK_PLAY("QUICK_PLAY", QueueId.QUICK_PLAY);

    private String text;

    private QueueId queueId;

    QueueIdFilter(String text, QueueId queueId) {
        this.text = text;
        this.queueId = queueId;
    }

    public String getText() {
        return text;
    }

    public QueueId getQueueId() {
        return queueId;
    }

    public static QueueIdFilter fromText(String text) {
        for (QueueIdFilter queueIdFilter : values()) {
            if (text.equals(queueIdFilter.getText())) return queueIdFilter;
        }

        return QueueIdFilter.ALL;
    }
}
