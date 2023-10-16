package vlrtstat.gg.match.dto;

import vlrtstat.gg.global.constant.GameMode;
import vlrtstat.gg.global.constant.GameType;
import vlrtstat.gg.global.constant.QueueId;

public class SimpleMatchDto {
    private String matchId;
    private GameMode gameMode;
    private GameType gameType;
    private QueueId queueId;

    public SimpleMatchDto(String matchId, GameMode gameMode, GameType gameType, QueueId queueId) {
        this.matchId = matchId;
        this.gameMode = gameMode;
        this.gameType = gameType;
        this.queueId = queueId;
    }

    public SimpleMatchDto() {
    }

    public String getMatchId() {
        return matchId;
    }

    public void setMatchId(String matchId) {
        this.matchId = matchId;
    }

    public GameMode getGameMode() {
        return gameMode;
    }

    public void setGameMode(GameMode gameMode) {
        this.gameMode = gameMode;
    }

    public GameType getGameType() {
        return gameType;
    }

    public void setGameType(GameType gameType) {
        this.gameType = gameType;
    }

    public QueueId getQueueId() {
        return queueId;
    }

    public void setQueueId(QueueId queueId) {
        this.queueId = queueId;
    }
}
