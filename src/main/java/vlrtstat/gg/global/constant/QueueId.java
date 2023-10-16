package vlrtstat.gg.global.constant;

public enum QueueId {
    CUSTOM_GAME(0),
    URF_GAME(76),
    DRAFT_GAME(400),
    DYNAMIC_RANK_GAME(410),
    SOLO_RANK_GAME(420),
    NORMAL_GAME(430),
    FLEX_RANK_GAME(440),
    OTHER_GAME(9999);


    private int queueId;

    public int getQueueId() {
        return this.queueId;
    }

    QueueId (int queueId) {
        this.queueId = queueId;
    }

    public static QueueId fromId(int id) {
        for (QueueId type : values()) {
            if (type.getQueueId() == id) {
                return type;
            }
        }
        return QueueId.OTHER_GAME;
    }
}