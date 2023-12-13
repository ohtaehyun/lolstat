package vlrtstat.gg.participant.domain;

import jakarta.persistence.*;
import vlrtstat.gg.global.store.ItemStore;
import vlrtstat.gg.global.store.RuneStore;
import vlrtstat.gg.global.store.SpellStore;
import vlrtstat.gg.item.domain.Item;
import vlrtstat.gg.match.domain.RiotMatch;
import vlrtstat.gg.rune.domain.Rune;
import vlrtstat.gg.rune.domain.RuneGroup;
import vlrtstat.gg.spell.domain.Spell;

import java.util.ArrayList;
import java.util.List;

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

    @Column(name = "item0_id")
    private int item0Id;

    @Column(name = "item1_id")
    private int item1Id;

    @Column(name = "item2_id")
    private int item2Id;

    @Column(name = "item3_id")
    private int item3Id;

    @Column(name = "item4_id")
    private int item4Id;

    @Column(name = "item5_id")
    private int item5Id;

    @Column(name = "item6_id")
    private int item6Id;

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

    @Column
    private int mainRuneGroupId;
    @Column
    private int subRuneGroupId;

    @ElementCollection(fetch = FetchType.LAZY)
    private int[] mainRuneIds;

    @ElementCollection(fetch = FetchType.LAZY)
    private int[] subRuneIds;


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

    public void setItem0Id(int item0Id) {
        this.item0Id = item0Id;
    }

    public int getItem1Id() {
        return item1Id;
    }

    public void setItem1Id(int item1Id) {
        this.item1Id = item1Id;
    }

    public int getItem2Id() {
        return item2Id;
    }

    public void setItem2Id(int item2Id) {
        this.item2Id = item2Id;
    }

    public int getItem3Id() {
        return item3Id;
    }

    public void setItem3Id(int item3Id) {
        this.item3Id = item3Id;
    }

    public int getItem4Id() {
        return item4Id;
    }

    public void setItem4Id(int item4Id) {
        this.item4Id = item4Id;
    }

    public int getItem5Id() {
        return item5Id;
    }

    public void setItem5Id(int item5Id) {
        this.item5Id = item5Id;
    }

    public int getItem6Id() {
        return item6Id;
    }

    public void setItem6Id(int item6Id) {
        this.item6Id = item6Id;
    }

    public Item[] getItems() {
        int[] itemIds = new int[] {item0Id, item1Id, item2Id, item3Id, item4Id, item5Id, item6Id};

        return ItemStore.getItems(itemIds);
    }

    public Rune getMainRune() {
        return RuneStore.getRune(spell1Casts);
    }

    public RuneGroup getSubRuneGroup() {
        return RuneStore.getRuneGroup(summoner1Casts);
    }

    public Spell[] getSpells() {
        int[] spellIds = new int[] {summoner1Id, summoner2Id};
        return SpellStore.getSpells(spellIds);
    }

    public int getItem0Id() {
        return item0Id;
    }

    public int getMainRuneGroupId() {
        return mainRuneGroupId;
    }

    public void setMainRuneGroupId(int mainRuneGroupId) {
        this.mainRuneGroupId = mainRuneGroupId;
    }

    public int getSubRuneGroupId() {
        return subRuneGroupId;
    }

    public void setSubRuneGroupId(int subRuneGroupId) {
        this.subRuneGroupId = subRuneGroupId;
    }

    public int[] getMainRuneIds() {
        return mainRuneIds;
    }

    public void setMainRuneIds(int[] mainRuneIds) {
        this.mainRuneIds = mainRuneIds;
    }

    public int[] getSubRuneIds() {
        return subRuneIds;
    }

    public void setSubRuneIds(int[] subRuneIds) {
        this.subRuneIds = subRuneIds;
    }
}