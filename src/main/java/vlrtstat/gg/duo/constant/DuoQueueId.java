package vlrtstat.gg.duo.constant;

import vlrtstat.gg.global.constant.QueueId;

public enum DuoQueueId {
    SOLO_RANK_GAME("SOLO_RANK_GAME", QueueId.SOLO_RANK_GAME),
    FLEX_RANK_GAME("FLEX_RANK_GAME", QueueId.FLEX_RANK_GAME),
    QUICK_PLAY("QUICK_PLAY", QueueId.QUICK_PLAY);

    private String text;

    private QueueId queueId;

    DuoQueueId(String text, QueueId queueId) {
        this.text = text;
        this.queueId = queueId;
    }

    public String getText() {
        return text;
    }

    public QueueId getQueueId() {
        return queueId;
    }

    public static DuoQueueId fromText(String text) {
        for (DuoQueueId queueIdFilter : values()) {
            if (text.equals(queueIdFilter.getText())) return queueIdFilter;
        }

        return DuoQueueId.SOLO_RANK_GAME;
    }
}
