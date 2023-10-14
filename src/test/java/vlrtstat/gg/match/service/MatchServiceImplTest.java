package vlrtstat.gg.match.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import vlrtstat.gg.match.repository.MatchRepository;

import static org.junit.jupiter.api.Assertions.*;

class MatchServiceImplTest {
    private MatchRepository matchRepository;

    public MatchServiceImplTest(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    @Test
    void getMatchHistories() {
        String puuid = "WHZpGYnW2SvQRwvVA3U6kWwpNVk8mOy57fMMdUfY5w382PMbefoqdDQRAWFt6OpgponUDsEknBeQjw";
        String[] matchIds = matchRepository.findIdsByPuuid(puuid);
    }
}