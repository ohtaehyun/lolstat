package vlrtstat.gg.league.repository;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import vlrtstat.gg.league.domain.LeagueEntry;

@Repository
@FeignClient(name = "LeagueRepository", url = "${riot.baseUrl}")
public interface LeagueRepository {
    @RequestMapping(
            value = "/lol/league/v4/entries/by-summoner/{encryptedSummonerId}",
            method = RequestMethod.GET,
            headers = "X-Riot-Token=${riot.key}"
    )
    LeagueEntry[] findBySummonerId(@PathVariable("encryptedSummonerId") String summonerId);
}
