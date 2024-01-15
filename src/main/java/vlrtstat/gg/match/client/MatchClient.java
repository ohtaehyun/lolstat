package vlrtstat.gg.match.client;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import vlrtstat.gg.match.client.response.MatchResponse;

@FeignClient(name = "MatchClient", url = "${riot.asiaBaseUrl}")
public interface MatchClient {
    @RequestMapping(
            path = "/lol/match/v5/matches/by-puuid/{puuid}/ids",
            method = RequestMethod.GET,
            headers = "X-Riot-Token=${riot.key}"
    )
    String[] findIdsByPuuid(@PathVariable("puuid") String puuid, @RequestParam("start") int start);

    @RequestMapping(
            path = "/lol/match/v5/matches/by-puuid/{puuid}/ids",
            method = RequestMethod.GET,
            headers = "X-Riot-Token=${riot.key}"
    )
    String[] findIdsByPuuid(@PathVariable("puuid") String puuid, @RequestParam("start") int start, @RequestParam("queue") int queue);

    @RequestMapping(
            path = "/lol/match/v5/matches/{matchId}",
            method = RequestMethod.GET,
            headers = "X-Riot-Token=${riot.key}"
    )
    @Cacheable(cacheNames = "match", key = "#matchId")
    MatchResponse findById(@PathVariable("matchId") String matchId);
}
