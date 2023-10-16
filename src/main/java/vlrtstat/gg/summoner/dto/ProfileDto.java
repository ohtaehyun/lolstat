package vlrtstat.gg.summoner.dto;

import vlrtstat.gg.league.domain.LeagueEntries;
import vlrtstat.gg.league.dto.LeagueEntryDto;
import vlrtstat.gg.summoner.domain.Summoner;

public class ProfileDto {
    private String summonerName;
    private Long summonerLevel;
    private int profileIconId;

    private LeagueEntryDto soloLeagueEntry;
    private LeagueEntryDto flexLeagueEntry;

    public ProfileDto(Summoner summoner, LeagueEntries leagueEntries) {
        this.summonerName = summoner.getName();
        this.summonerLevel = summoner.getSummonerLevel();
        this.profileIconId = summoner.getProfileIconId();
        this.soloLeagueEntry = leagueEntries.getSoloLeague().toDto();
        this.flexLeagueEntry = leagueEntries.getFlexLeague().toDto();
    }

    public String getSummonerName() {
        return summonerName;
    }

    public void setSummonerName(String summonerName) {
        this.summonerName = summonerName;
    }

    public Long getSummonerLevel() {
        return summonerLevel;
    }

    public void setSummonerLevel(Long summonerLevel) {
        this.summonerLevel = summonerLevel;
    }

    public int getProfileIconId() {
        return profileIconId;
    }

    public void setProfileIconId(int profileIconId) {
        this.profileIconId = profileIconId;
    }

    public LeagueEntryDto getSoloLeagueEntry() {
        return soloLeagueEntry;
    }

    public void setSoloLeagueEntry(LeagueEntryDto soloLeagueEntry) {
        this.soloLeagueEntry = soloLeagueEntry;
    }

    public LeagueEntryDto getFlexLeagueEntry() {
        return flexLeagueEntry;
    }

    public void setFlexLeagueEntry(LeagueEntryDto flexLeagueEntry) {
        this.flexLeagueEntry = flexLeagueEntry;
    }
}
