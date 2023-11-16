package vlrtstat.gg.match.domain;

import jakarta.persistence.*;
import vlrtstat.gg.global.constant.GameMode;
import vlrtstat.gg.match.client.response.MatchResponse;
import vlrtstat.gg.participant.domain.Participant;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "RiotMatch", indexes = {
        @Index(name = "idx_riotmatch_matchid_unq", columnList = "matchId", unique = true)
})
public class RiotMatch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String matchId;

    @Column
    private Long gameId;

    @Column
    private String dataVersion;

    @Column
    private Date gameCreation;

    @Column
    private Long gameDuration;

    @Column
    private Date gameStart;

    @Column
    private Date gameEnd;

    @Column
    private GameMode gameMode;

    @Column
    private String gameName;

    @OneToMany(mappedBy = "match")
    private List<Participant> participants;

    public RiotMatch() {
    }

    public RiotMatch(MatchResponse matchResponse) {
        this.matchId = matchResponse.getMetadata().getMatchId();
        this.gameId = matchResponse.getInfo().getGameId();
        this.dataVersion = matchResponse.getMetadata().getDataVersion();
        this.gameCreation = new Date(matchResponse.getInfo().getGameCreation());
        this.gameDuration = matchResponse.getInfo().getGameDuration();
        this.gameStart = new Date(matchResponse.getInfo().getGameStartTimestamp());
        this.gameEnd = new Date(matchResponse.getInfo().getGameEndTimestamp());
        this.gameMode = matchResponse.getInfo().getGameMode();
        this.gameName = matchResponse.getInfo().getGameName();
    }

    public String getMatchId() {
        return matchId;
    }

    public void setMatchId(String matchId) {
        this.matchId = matchId;
    }

    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    public String getDataVersion() {
        return dataVersion;
    }

    public void setDataVersion(String dataVersion) {
        this.dataVersion = dataVersion;
    }

    public Date getGameCreation() {
        return gameCreation;
    }

    public void setGameCreation(Date gameCreation) {
        this.gameCreation = gameCreation;
    }

    public Long getGameDuration() {
        return gameDuration;
    }

    public void setGameDuration(Long gameDuration) {
        this.gameDuration = gameDuration;
    }

    public Date getGameStart() {
        return gameStart;
    }

    public void setGameStart(Date gameStart) {
        this.gameStart = gameStart;
    }

    public Date getGameEnd() {
        return gameEnd;
    }

    public void setGameEnd(Date gameEnd) {
        this.gameEnd = gameEnd;
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
}
