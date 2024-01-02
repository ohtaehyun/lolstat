package vlrtstat.gg.summoner.dto;

import vlrtstat.gg.league.domain.LeagueEntries;
import vlrtstat.gg.match.dto.MatchDto;
import vlrtstat.gg.match.dto.SimpleMatchDto;
import vlrtstat.gg.summoner.domain.Summoner;

public class SummonerProfileDto {
    private ProfileDto profile;
    private MatchDto[] matches;

    public SummonerProfileDto(Summoner summoner, LeagueEntries leagueEntries, MatchDto[] matches) {
        this.profile = new ProfileDto(summoner, leagueEntries);
        this.matches = matches;
    }

    public SummonerProfileDto(ProfileDto profile, MatchDto[] matches) {
        this.profile = profile;
        this.matches = matches;
    }

    public SummonerProfileDto() {};

    public ProfileDto getProfile() {
        return profile;
    }

    public void setProfile(ProfileDto profile) {
        this.profile = profile;
    }

    public MatchDto[] getMatches() {
        return matches;
    }

    public void setMatches(MatchDto[] matches) {
        this.matches = matches;
    }
}
