package vlrtstat.gg.summoner.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import vlrtstat.gg.league.domain.LeagueEntries;
import vlrtstat.gg.league.dto.LeagueEntryDto;
import vlrtstat.gg.summoner.domain.Summoner;

@Schema(description = "소환사 프로필 정보 응답 DTO")
public class ProfileDto {
    @Schema(description = "소환사명")
    private String summonerName;
    @Schema(description = "소환사 레벨")
    private Long summonerLevel;

    @Schema(description = "소환사 아이콘 id (추후 이미지 경로로 변경 예정)")
    private int profileIconId;

    @Schema(description = "솔로 랭크 정보")
    private LeagueEntryDto soloLeagueEntry;
    @Schema(description = "자유 랭크 정보")
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
