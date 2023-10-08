package vlrtstat.gg.profile.service;

import org.springframework.stereotype.Service;
import vlrtstat.gg.profile.domain.Profile;
import vlrtstat.gg.riotAccount.domain.RiotAccount;
import vlrtstat.gg.riotAccount.repository.RiotAccountRepository;

@Service
public class ProfileService {
    private RiotAccountRepository riotAccountRepository;

    public ProfileService(RiotAccountRepository riotAccountRepository) {
        this.riotAccountRepository = riotAccountRepository;
    }

    public Profile searchProfile(String gameName, String tagLine) {
        RiotAccount riotAccount = riotAccountRepository.findByNameAndTag(gameName, tagLine);
        return new Profile(riotAccount.getPuuid());
    }

}
