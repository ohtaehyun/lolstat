package vlrtstat.gg.riotContent.repository;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import vlrtstat.gg.riotContent.domain.Content;

@FeignClient(name = "FeignContentClient", url = "${riot.apBaseUrl}")
public interface ContentRepository {
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/val/content/v1/contents",
            headers = "X-Riot-Token=${riot.key}"
    )
    Content getContents();
}
