package vlrtstat.gg.riotLeaderBoard.repository;

import feign.QueryMap;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "RiotLeaderBoardRepository", url = "${riot.baseUrl}")
public interface RiotLeaderBoardRepository {
    @RequestMapping(
         value = "/val/ranked/v1/leaderboards/by-act/{actId}",
         method = RequestMethod.GET
    )
    void findLeaderBoards(@PathVariable("actId") String actId);
}
