package vlrtstat.gg.match.dto;

import vlrtstat.gg.champion.dto.ChampionDto;
import vlrtstat.gg.item.dto.ItemDto;
import vlrtstat.gg.rune.dto.RuneDto;
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
    private ItemDto[] items;
    private SpellDto[] spells;
    private ChampionDto champion;
    private boolean win;
    private RuneDto mainRune;
    private RuneDto subRune;

    public SimpleParticipantDto(String summonerName, int summonerLevel, int championLevel, int kills, int deaths, int assists, String lane, String role, int teamId, boolean win) {
        this.summonerName = summonerName;
        this.summonerLevel = summonerLevel;
        this.championLevel = championLevel;
        this.kills = kills;
        this.deaths = deaths;
        this.assists = assists;
        this.lane = lane;
        this.role = role;
        this.teamId = teamId;
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

    public RuneDto getMainRune() {
        return mainRune;
    }

    public void setMainRune(RuneDto mainRune) {
        this.mainRune = mainRune;
    }

    public RuneDto getSubRune() {
        return subRune;
    }

    public void setSubRune(RuneDto subRune) {
        this.subRune = subRune;
    }
}
