package vlrtstat.gg.riotAccount.repository;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import vlrtstat.gg.riotAccount.client.RiotAccountFeignClient;

@Repository
public class ApiRiotAccountRepository implements RiotAccountRepository {
    private final RiotAccountFeignClient feignClient;
    @Value("${riot.key}")
    private String apiKey;

    public ApiRiotAccountRepository(RiotAccountFeignClient feignClient) {
        this.feignClient = feignClient;
    }

    @Override
    public String findPuuidNameAndTag() {
        return feignClient.getRiotAccount(apiKey).getPuuid();
    }
}
