package vlrtstat.gg.riotAccount.service;

import org.springframework.stereotype.Service;
import vlrtstat.gg.riotAccount.repository.RiotAccountRepository;

@Service
public class RiotAccountService {
    private final RiotAccountRepository riotAccountRepository;

    public RiotAccountService(RiotAccountRepository riotAccountRepository) {
        this.riotAccountRepository = riotAccountRepository;
    }

    public String getPuuidByNameAndTagLine(String gameName, String tagLine) {
        return riotAccountRepository.findByNameAndTag(gameName, tagLine).getPuuid();
    }
}
