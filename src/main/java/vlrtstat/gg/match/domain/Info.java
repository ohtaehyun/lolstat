package vlrtstat.gg.match.domain;

import vlrtstat.gg.match.constant.GameMode;
import vlrtstat.gg.match.constant.GameType;
import vlrtstat.gg.match.constant.QueueId;

public class Info {
    private Long gameCreation;
    private Long gameDuration;
    private Long gameEndTimestamp;
    private Long gameId;
    private GameMode gameMode;
    private String gameName;
    private Long gameStartTimestamp;
    private GameType gameType;
    private String gameVersion;
    private int mapId;
    private Participant[] participants;
    private String platformId;
    private QueueId queueId;
    private Team[] teams;
    private String tournamentCode;

    public Info(Long gameCreation, Long gameDuration, Long gameEndTimestamp, Long gameId, GameMode gameMode, String gameName, Long gameStartTimestamp, GameType gameType, String gameVersion, int mapId, Participant[] participants, String platformId, int queueId, Team[] teams, String tournamentCode) {
        this.setGameCreation(gameCreation);
        this.setGameDuration(gameDuration);
        this.setGameEndTimestamp(gameEndTimestamp);
        this.setGameId(gameId);
        this.setGameMode(gameMode);
        this.setGameName(gameName);
        this.setGameStartTimestamp(gameStartTimestamp);
        this.setGameType(gameType);
        this.setGameVersion(gameVersion);
        this.setMapId(mapId);
        this.setParticipants(participants);
        this.setPlatformId(platformId);
        this.setQueueId(QueueId.fromId(queueId));
        this.setTeams(teams);
        this.setTournamentCode(tournamentCode);
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
        this.setQueueId(QueueId.fromId(queueId));
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

    public void setQueueId(QueueId queueId) {
        this.queueId = queueId;
    }
}
