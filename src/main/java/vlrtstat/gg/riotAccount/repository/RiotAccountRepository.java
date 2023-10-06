package vlrtstat.gg.riotAccount.repository;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import vlrtstat.gg.riotAccount.domain.RiotAccount;

@FeignClient(name = "RiotAccountClient", url = "${riot.baseUrl}")
public interface RiotAccountRepository {
    @RequestMapping(
            method = RequestMethod.GET,
            path = "/riot/account/v1/accounts/by-riot-id/{gameName}/{tagLine}",
            headers = "X-Riot-Token=${riot.key}"
    )
    RiotAccount findByNameAndTag(
            @PathVariable("gameName") String gameName,
            @PathVariable("tagLine") String tagLine
    );
}
