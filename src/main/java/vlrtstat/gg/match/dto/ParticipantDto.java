package vlrtstat.gg.match.dto;

import vlrtstat.gg.champion.domain.Champion;
import vlrtstat.gg.champion.dto.ChampionDto;
import vlrtstat.gg.global.store.ChampionStore;
import vlrtstat.gg.item.domain.Item;
import vlrtstat.gg.participant.domain.Participant;
import vlrtstat.gg.spell.domain.Spell;
import vlrtstat.gg.spell.dto.SpellDto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParticipantDto {
    private String summonerId;
    private String summonerName;
    private int summonerLevel;
    private int kills;
    private int deaths;
    private int assists;
    private int goldEarned;
    private int goldSpent;
    private int teamId;
    private List<ItemDto> items = new ArrayList<>();
    private List<SpellDto> spells = new ArrayList<>();

    private ChampionDto champion;

    private int championLevel;

    public ParticipantDto(Participant participant) {
        this.summonerId = participant.getSummonerId();
        this.summonerName = participant.getSummonerName();
        this.summonerLevel = participant.getSummonerLevel();
        this.kills = participant.getKills();
        this.deaths = participant.getDeaths();
        this.assists = participant.getAssists();
        this.goldEarned = participant.getGoldEarned();
        this.goldSpent = participant.getGoldSpent();
        this.teamId = participant.getTeamId();
        this.champion = new ChampionDto(ChampionStore.getChampion(participant.getChampionId()));
        this.championLevel = participant.getChampLevel();

        for (Item item : participant.getItems()) {
            items.add(new ItemDto(item));
        }

        for (Spell spell : participant.getSpells()) {
            spells.add(new SpellDto(spell));
        }
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

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public List<ItemDto> getItems() {
        return items;
    }

    public void setItems(List<ItemDto> items) {
        this.items = items;
    }

    public List<SpellDto> getSpells() {
        return spells;
    }

    public void setSpells(List<SpellDto> spells) {
        this.spells = spells;
    }

    public ChampionDto getChampion() {
        return champion;
    }

    public void setChampion(ChampionDto champion) {
        this.champion = champion;
    }

    public int getChampionLevel() {
        return championLevel;
    }

    public void setChampionLevel(int championLevel) {
        this.championLevel = championLevel;
    }
}
