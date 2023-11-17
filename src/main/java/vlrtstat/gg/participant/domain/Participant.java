package vlrtstat.gg.participant.domain;

import jakarta.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import vlrtstat.gg.item.domain.JpaItem;
import vlrtstat.gg.match.domain.RiotMatch;

@Entity
@Table(name = "Participant", indexes = {
        @Index(name = "idx_participant_matchid", columnList = "matchId")
}, uniqueConstraints = {
        @UniqueConstraint(name = "uc_participant_puuid_matchid", columnNames = {"puuid", "matchId"})
})
public class Participant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String summonerId;

    @Column
    private String summonerName;

    @Column
    private int summonerLevel;

    @Column
    private String puuid;

    @ManyToOne
    @JoinColumn(name = "matchId")
    private RiotMatch match;

    @Column
    private int kills;

    @Column
    private int deaths;

    @Column
    private int assists;

    @Column
    private int goldEarned;

    @Column
    private int goldSpent;

    @Column
    private int championId;

    @Column
    private int champLevel;

    @Column
    private int item0;

    @Column
    private int item1;

    @Column
    private int item2;

    @Column
    private int item3;

    @Column
    private int item4;

    @Column
    private int item5;

    @Column
    private int item6;

    @Column
    private int spell1Casts;

    @Column
    private int spell2Casts;

    @Column
    private int spell3Casts;

    @Column
    private int spell4Casts;

    @Column
    private int summoner1Casts;

    @Column
    private int summoner2Casts;

    @Column
    private int summoner1Id;

    @Column
    private int summoner2Id;

    @Column
    private boolean teamEarlySurrendered;

    @Column
    private int teamId;

    @Column
    private String teamPosition;

    @Column
    private boolean win;

    @Column
    private int visionScore;

    @Column
    private int visionWardsBoughtInGame;

    @Column
    private int wardsPlaced;

    @Column
    private int totalDamageDealt;

    @Column
    private int totalDamageDealtToChampions;

    @Column
    private int totalDamageTaken;

    @Column
    private int totalMinionsKilled;

    public Participant() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSummonerId() {
        return summonerId;
    }

    public void setSummonerId(String summonerId) {
        this.summonerId = summonerId;
    }

    public String getSummonerName() {
        return summonerName;
    }

    public void setSummonerName(String summonerName) {
        this.summonerName = summonerName;
    }

    public int getSummonerLevel() {
        return summonerLevel;
    }

    public void setSummonerLevel(int summonerLevel) {
        this.summonerLevel = summonerLevel;
    }

    public String getPuuid() {
        return puuid;
    }

    public void setPuuid(String puuid) {
        this.puuid = puuid;
    }

    public RiotMatch getMatch() {
        return match;
    }

    public void setMatch(RiotMatch match) {
        this.match = match;
    }

    public int getKills() {
        return kills;
    }

    public void setKills(int kills) {
        this.kills = kills;
    }

    public int getDeaths() {
        return deaths;
    }

    public void setDeaths(int deaths) {
        this.deaths = deaths;
    }

    public int getAssists() {
        return assists;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public int getGoldEarned() {
        return goldEarned;
    }

    public void setGoldEarned(int goldEarned) {
        this.goldEarned = goldEarned;
    }

    public int getGoldSpent() {
        return goldSpent;
    }

    public void setGoldSpent(int goldSpent) {
        this.goldSpent = goldSpent;
    }

    public int getChampionId() {
        return championId;
    }

    public void setChampionId(int championId) {
        this.championId = championId;
    }

    public int getChampLevel() {
        return champLevel;
    }

    public void setChampLevel(int champLevel) {
        this.champLevel = champLevel;
    }

    public int getItem0() {
        return item0;
    }

    public void setItem0(int item0) {
        this.item0 = item0;
    }

    public int getItem1() {
        return item1;
    }

    public void setItem1(int item1) {
        this.item1 = item1;
    }

    public int getItem2() {
        return item2;
    }

    public void setItem2(int item2) {
        this.item2 = item2;
    }

    public int getItem3() {
        return item3;
    }

    public void setItem3(int item3) {
        this.item3 = item3;
    }

    public int getItem4() {
        return item4;
    }

    public void setItem4(int item4) {
        this.item4 = item4;
    }

    public int getItem5() {
        return item5;
    }

    public void setItem5(int item5) {
        this.item5 = item5;
    }

    public int getItem6() {
        return item6;
    }

    public void setItem6(int item6) {
        this.item6 = item6;
    }

    public int getSpell1Casts() {
        return spell1Casts;
    }

    public void setSpell1Casts(int spell1Casts) {
        this.spell1Casts = spell1Casts;
    }

    public int getSpell2Casts() {
        return spell2Casts;
    }

    public void setSpell2Casts(int spell2Casts) {
        this.spell2Casts = spell2Casts;
    }

    public int getSpell3Casts() {
        return spell3Casts;
    }

    public void setSpell3Casts(int spell3Casts) {
        this.spell3Casts = spell3Casts;
    }

    public int getSpell4Casts() {
        return spell4Casts;
    }

    public void setSpell4Casts(int spell4Casts) {
        this.spell4Casts = spell4Casts;
    }

    public int getSummoner1Casts() {
        return summoner1Casts;
    }

    public void setSummoner1Casts(int summoner1Casts) {
        this.summoner1Casts = summoner1Casts;
    }

    public int getSummoner2Casts() {
        return summoner2Casts;
    }

    public void setSummoner2Casts(int summoner2Casts) {
        this.summoner2Casts = summoner2Casts;
    }

    public int getSummoner1Id() {
        return summoner1Id;
    }

    public void setSummoner1Id(int summoner1Id) {
        this.summoner1Id = summoner1Id;
    }

    public int getSummoner2Id() {
        return summoner2Id;
    }

    public void setSummoner2Id(int summoner2Id) {
        this.summoner2Id = summoner2Id;
    }

    public boolean isTeamEarlySurrendered() {
        return teamEarlySurrendered;
    }

    public void setTeamEarlySurrendered(boolean teamEarlySurrendered) {
        this.teamEarlySurrendered = teamEarlySurrendered;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public String getTeamPosition() {
        return teamPosition;
    }

    public void setTeamPosition(String teamPosition) {
        this.teamPosition = teamPosition;
    }

    public boolean isWin() {
        return win;
    }

    public void setWin(boolean win) {
        this.win = win;
    }

    public int getVisionScore() {
        return visionScore;
    }

    public void setVisionScore(int visionScore) {
        this.visionScore = visionScore;
    }

    public int getVisionWardsBoughtInGame() {
        return visionWardsBoughtInGame;
    }

    public void setVisionWardsBoughtInGame(int visionWardsBoughtInGame) {
        this.visionWardsBoughtInGame = visionWardsBoughtInGame;
    }

    public int getWardsPlaced() {
        return wardsPlaced;
    }

    public void setWardsPlaced(int wardsPlaced) {
        this.wardsPlaced = wardsPlaced;
    }

    public int getTotalDamageDealt() {
        return totalDamageDealt;
    }

    public void setTotalDamageDealt(int totalDamageDealt) {
        this.totalDamageDealt = totalDamageDealt;
    }

    public int getTotalDamageDealtToChampions() {
        return totalDamageDealtToChampions;
    }

    public void setTotalDamageDealtToChampions(int totalDamageDealtToChampions) {
        this.totalDamageDealtToChampions = totalDamageDealtToChampions;
    }

    public int getTotalDamageTaken() {
        return totalDamageTaken;
    }

    public void setTotalDamageTaken(int totalDamageTaken) {
        this.totalDamageTaken = totalDamageTaken;
    }

    public int getTotalMinionsKilled() {
        return totalMinionsKilled;
    }

    public void setTotalMinionsKilled(int totalMinionsKilled) {
        this.totalMinionsKilled = totalMinionsKilled;
    }
}