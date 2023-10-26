package vlrtstat.gg.match.dto;

import vlrtstat.gg.champion.dto.ChampionDto;
import vlrtstat.gg.item.dto.ItemDto;
import vlrtstat.gg.spell.dto.SpellDto;

public class SimpleParticipantDto {
    private String summonerName;
    private int summonerLevel;
    private int championLevel;
    private int kills;
    private int deaths;
    private int assists;
    private String lane;
    private String role;
    private int teamId;
    private int spell1Casts;
    private int spell2Casts;
    private int spell3Casts;
    private int spell4Casts;
    private int summoner1Casts;
    private int summoner2Casts;
    private ItemDto[] items;
    private SpellDto[] spells;
    private ChampionDto champion;
    private boolean win;

    public SimpleParticipantDto(String summonerName, int summonerLevel, int championLevel, int kills, int deaths, int assists, String lane, String role, int teamId, int spell1Casts, int spell2Casts, int spell3Casts, int spell4Casts, int summoner1Casts, int summoner2Casts, boolean win) {
        this.summonerName = summonerName;
        this.summonerLevel = summonerLevel;
        this.championLevel = championLevel;
        this.kills = kills;
        this.deaths = deaths;
        this.assists = assists;
        this.lane = lane;
        this.role = role;
        this.teamId = teamId;
        this.spell1Casts = spell1Casts;
        this.spell2Casts = spell2Casts;
        this.spell3Casts = spell3Casts;
        this.spell4Casts = spell4Casts;
        this.summoner1Casts = summoner1Casts;
        this.summoner2Casts = summoner2Casts;
        this.win = win;
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

    public String getLane() {
        return lane;
    }

    public void setLane(String lane) {
        this.lane = lane;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
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

    public boolean isWin() {
        return win;
    }

    public void setWin(boolean win) {
        this.win = win;
    }

    public ItemDto[] getItems() {
        return items;
    }

    public void setItems(ItemDto[] items) {
        this.items = items;
    }

    public SpellDto[] getSpells() {
        return spells;
    }

    public void setSpells(SpellDto[] spells) {
        this.spells = spells;
    }

    public ChampionDto getChampion() {
        return champion;
    }

    public void setChampion(ChampionDto champion) {
        this.champion = champion;
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

    public int getChampionLevel() {
        return championLevel;
    }

    public void setChampionLevel(int championLevel) {
        this.championLevel = championLevel;
    }
}
