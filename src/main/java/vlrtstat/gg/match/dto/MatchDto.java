package vlrtstat.gg.match.dto;

import vlrtstat.gg.global.constant.GameMode;
import vlrtstat.gg.global.constant.GameType;
import vlrtstat.gg.global.constant.QueueId;
import vlrtstat.gg.match.domain.RiotMatch;

public class MatchDto {
    private String matchId;
    private GameMode gameMode;
    private GameType gameType;
    private QueueId queueId;
    private ParticipantDto[] participants;

    public MatchDto(RiotMatch match) {
        this.matchId = match.getMatchId();
        this.gameMode = match.getGameMode();
        this.gameType = match.getGameType();
        this.queueId = match.getQueueId();
        this.participants = match
                .getParticipants()
                .stream()
                .map(ParticipantDto::new)
                .toArray(ParticipantDto[]::new);
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

    public ParticipantDto[] getParticipants() {
        return participants;
    }

    public void setParticipants(ParticipantDto[] participants) {
        this.participants = participants;
    }
}
