package vlrtstat.gg.summoner.dto;

import vlrtstat.gg.match.dto.SimpleMatchDto;

public class SummonerProfileDto {
    private ProfileDto profile;
    private SimpleMatchDto[] matches;

    public SummonerProfileDto(ProfileDto profile, SimpleMatchDto[] matches) {
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

    public SimpleMatchDto[] getMatches() {
        return matches;
    }

    public void setMatches(SimpleMatchDto[] matches) {
        this.matches = matches;
    }
}
