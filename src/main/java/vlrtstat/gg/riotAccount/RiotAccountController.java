package vlrtstat.gg.riotAccount;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import vlrtstat.gg.riotAccount.repository.RiotAccountRepository;

@RestController
public class RiotAccountController {
    private RiotAccountRepository riotAccountRepository;

    public RiotAccountController(RiotAccountRepository riotAccountRepository) {
        this.riotAccountRepository = riotAccountRepository;
    }

    @GetMapping("/account")
    public String getAccount() {
        return riotAccountRepository.findPuuidNameAndTag();
    }
}
