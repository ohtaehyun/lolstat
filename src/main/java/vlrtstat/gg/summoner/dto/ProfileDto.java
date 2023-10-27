package vlrtstat.gg.summoner.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import vlrtstat.gg.league.domain.LeagueEntries;
import vlrtstat.gg.league.dto.LeagueEntryDto;
import vlrtstat.gg.summoner.domain.Summoner;

@Schema(description = "소환사 프로필 정보 응답 DTO")
public class ProfileDto {
    private String puuid;
    @Schema(description = "소환사명")
    private String summonerName;

    @Schema(description = "소환사 레벨")
    private Long summonerLevel;

    @Schema(description = "소환사 아이콘 이미지 주소")
    private String profileIcon;

    @Schema(description = "솔로 랭크 정보")
    private LeagueEntryDto soloLeagueEntry;

    @Schema(description = "자유 랭크 정보")
    private LeagueEntryDto flexLeagueEntry;

    public ProfileDto(Summoner summoner, LeagueEntries leagueEntries) {
        this.puuid = summoner.getPuuid();
        this.summonerName = summoner.getName();
        this.summonerLevel = summoner.getSummonerLevel();
        this.profileIcon = summoner.getProfileIconUrl();
        this.soloLeagueEntry = leagueEntries.getSoloLeague().toDto();
        this.flexLeagueEntry = leagueEntries.getFlexLeague().toDto();
    }

    public String getPuuid() {
        return puuid;
    }

    public void setPuuid(String puuid) {
        this.puuid = puuid;
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

    public String getProfileIcon() {
        return profileIcon;
    }

    public void setProfileIcon(String profileIcon) {
        this.profileIcon = profileIcon;
    }
}
