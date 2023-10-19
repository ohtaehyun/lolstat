package vlrtstat.gg.match.dto;

import vlrtstat.gg.item.dto.ItemDto;

public class SimpleParticipantDto {
    private String summonerName;
    private int summonerLevel;
    private int championId;
    private int champLevel;
    private String lane;
    private String role;
    private int teamId;
    private int kills;
    private int deaths;
    private int assists;
    private int summoner1Id;
    private int summoner2Id;
    private int spell1Casts;
    private int spell2Casts;
    private int spell3Casts;
    private int spell4Casts;
    private int summoner1Casts;
    private int summoner2Casts;
    private ItemDto[] items;
    private int item0;
    private int item1;
    private int item2;
    private int item3;
    private int item4;
    private int item5;
    private int item6;
    private boolean win;

    public SimpleParticipantDto(String summonerName, int summonerLevel, int championId, int champLevel, String lane, String role, int teamId, int kills, int deaths, int assists, int summoner1Id, int summoner2Id, int spell1Casts, int spell2Casts, int spell3Casts, int spell4Casts, int summoner1Casts, int summoner2Casts, int item0, int item1, int item2, int item3, int item4, int item5, int item6, boolean win) {
        this.summonerName = summonerName;
        this.summonerLevel = summonerLevel;
        this.championId = championId;
        this.champLevel = champLevel;
        this.lane = lane;
        this.role = role;
        this.teamId = teamId;
        this.kills = kills;
        this.deaths = deaths;
        this.assists = assists;
        this.summoner1Id = summoner1Id;
        this.summoner2Id = summoner2Id;
        this.spell1Casts = spell1Casts;
        this.spell2Casts = spell2Casts;
        this.spell3Casts = spell3Casts;
        this.spell4Casts = spell4Casts;
        this.summoner1Casts = summoner1Casts;
        this.summoner2Casts = summoner2Casts;
        this.item0 = item0;
        this.item1 = item1;
        this.item2 = item2;
        this.item3 = item3;
        this.item4 = item4;
        this.item5 = item5;
        this.item6 = item6;
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

    public boolean isWin() {
        return win;
    }

    public void setWin(boolean win) {
        this.win = win;
    }
}
