package vlrtstat.gg.summoner.repository;

import feign.Headers;
import feign.QueryMap;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import vlrtstat.gg.summoner.domain.Summoner;

@FeignClient(name = "SummonerRepository", url = "${riot.baseUrl}")
public interface SummonerRepository {

    @RequestMapping(
            method = RequestMethod.GET,
            path = "/lol/summoner/v4/summoners/by-name/{summonerName}",
            headers = "X-Riot-Token=${riot.key}"
    )
    Summoner findByName(@PathVariable("summonerName") String summonerName);
}
