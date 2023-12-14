package vlrtstat.gg.summoner.repository;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import vlrtstat.gg.summoner.domain.Account;
import vlrtstat.gg.summoner.domain.Summoner;

@Repository
@FeignClient(name = "AccountRepository", url = "${riot.asiaBaseUrl}")
public interface AccountRepository {

    @RequestMapping(
            method = RequestMethod.GET,
            path = "/riot/account/v1/accounts/by-riot-id/{gameName}/{tagLine}",
            headers = "X-Riot-Token=${riot.key}"
    )
    Account findByNameAndTag(@PathVariable("gameName") String gameName, @PathVariable("tagLine") String tagLine);
}
