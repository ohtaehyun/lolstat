package vlrtstat.gg.match.repository;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import vlrtstat.gg.match.domain.Match;

@Repository
@FeignClient(name = "MatchRepository", url = "${riot.asiaBaseUrl}")
public interface MatchRepository {
    @RequestMapping(
            path = "/lol/match/v5/matches/by-puuid/{puuid}/ids",
            method = RequestMethod.GET,
            headers = "X-Riot-Token=${riot.key}"
    )
    String[] findIdsByPuuid(@PathVariable("puuid") String puuid);

    @RequestMapping(
            path = "/lol/match/v5/matches/{matchId}",
            method = RequestMethod.GET,
            headers = "X-Riot-Token=${riot.key}"
    )
    Match findById(@PathVariable("matchId") String matchId);


}
