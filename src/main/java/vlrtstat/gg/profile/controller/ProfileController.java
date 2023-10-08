package vlrtstat.gg.profile.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import vlrtstat.gg.profile.service.ProfileService;

@RestController("/profile")
public class ProfileController {
    private ProfileService profileService;

    public ProfileController(ProfileService profileService) {
        this.profileService = profileService;
    }

    @GetMapping("/{gameName}/{tagLine}")
    public String searchProfile(@PathVariable String gameName, @PathVariable String tagLine) {
        return profileService.searchProfile(gameName, tagLine).getPuuid();
    }
}
