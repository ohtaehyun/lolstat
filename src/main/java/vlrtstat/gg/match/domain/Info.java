package vlrtstat.gg.match.domain;

import vlrtstat.gg.match.constant.GameMode;
import vlrtstat.gg.match.constant.GameType;
import vlrtstat.gg.match.constant.QueueId;

public class Info {
    Long gameCreation;
    Long gameDuration;
    Long gameEndTimestamp;
    Long gameId;
    GameMode gameMode;
    String gameName;
    Long gameStartTimestamp;
    GameType gameType;
    String gameVersion;
    int mapId;
    Participant[] participants;
    String platformId;
    QueueId queueId;
    Team[] teams;
    String tournamentCode;

    public Info(Long gameCreation, Long gameDuration, Long gameEndTimestamp, Long gameId, GameMode gameMode, String gameName, Long gameStartTimestamp, GameType gameType, String gameVersion, int mapId, Participant[] participants, String platformId, int queueId, Team[] teams, String tournamentCode) {
        this.gameCreation = gameCreation;
        this.gameDuration = gameDuration;
        this.gameEndTimestamp = gameEndTimestamp;
        this.gameId = gameId;
        this.gameMode = gameMode;
        this.gameName = gameName;
        this.gameStartTimestamp = gameStartTimestamp;
        this.gameType = gameType;
        this.gameVersion = gameVersion;
        this.mapId = mapId;
        this.participants = participants;
        this.platformId = platformId;
        this.queueId = QueueId.fromId(queueId);
        this.teams = teams;
        this.tournamentCode = tournamentCode;
    }

    public Long getGameCreation() {
        return gameCreation;
    }

    public void setGameCreation(Long gameCreation) {
        this.gameCreation = gameCreation;
    }

    public Long getGameDuration() {
        return gameDuration;
    }

    public void setGameDuration(Long gameDuration) {
        this.gameDuration = gameDuration;
    }

    public Long getGameEndTimestamp() {
        return gameEndTimestamp;
    }

    public void setGameEndTimestamp(Long gameEndTimestamp) {
        this.gameEndTimestamp = gameEndTimestamp;
    }

    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    public GameMode getGameMode() {
        return gameMode;
    }

    public void setGameMode(GameMode gameMode) {
        this.gameMode = gameMode;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public Long getGameStartTimestamp() {
        return gameStartTimestamp;
    }

    public void setGameStartTimestamp(Long gameStartTimestamp) {
        this.gameStartTimestamp = gameStartTimestamp;
    }

    public GameType getGameType() {
        return gameType;
    }

    public void setGameType(GameType gameType) {
        this.gameType = gameType;
    }

    public String getGameVersion() {
        return gameVersion;
    }

    public void setGameVersion(String gameVersion) {
        this.gameVersion = gameVersion;
    }

    public int getMapId() {
        return mapId;
    }

    public void setMapId(int mapId) {
        this.mapId = mapId;
    }

    public Participant[] getParticipants() {
        return participants;
    }

    public void setParticipants(Participant[] participants) {
        this.participants = participants;
    }

    public String getPlatformId() {
        return platformId;
    }

    public void setPlatformId(String platformId) {
        this.platformId = platformId;
    }

    public QueueId getQueueId() {
        return queueId;
    }

    public void setQueueId(int queueId) {
        this.queueId = QueueId.fromId(queueId);
    }

    public Team[] getTeams() {
        return teams;
    }

    public void setTeams(Team[] teams) {
        this.teams = teams;
    }

    public String getTournamentCode() {
        return tournamentCode;
    }

    public void setTournamentCode(String tournamentCode) {
        this.tournamentCode = tournamentCode;
    }
}
