package vlrtstat.gg.riotAccount.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import vlrtstat.gg.riotAccount.domain.RiotAccount;

@FeignClient(name = "RiotAccount", url = "https://asia.api.riotgames.com")
public interface RiotAccountFeignClient {
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/riot/account/v1/accounts/by-riot-id/Mermaid/1035"
    )
    RiotAccount getRiotAccount(
            @RequestHeader("X-Riot-Token") String apiKey
    );
}
