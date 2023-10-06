package vlrtstat.gg.riotAccount;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import vlrtstat.gg.riotAccount.domain.RiotAccount;
import vlrtstat.gg.riotAccount.repository.RiotAccountRepository;

@RestController
public class RiotAccountController {
    private final RiotAccountRepository riotAccountRepository;

    public RiotAccountController(RiotAccountRepository riotAccountRepository) {
        this.riotAccountRepository = riotAccountRepository;
    }

    @GetMapping("/account")
    public String getAccount() {
        RiotAccount ra = riotAccountRepository.findByNameAndTag("Mermaid", "1035");
        return ra.getPuuid();
    }
}
