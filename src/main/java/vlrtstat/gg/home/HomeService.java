package vlrtstat.gg.home;

import org.springframework.stereotype.Service;
import vlrtstat.gg.riotContent.domain.Content;
import vlrtstat.gg.riotContent.repository.RiotContentRepository;

@Service
public class HomeService {
    private RiotContentRepository riotContentRepository;

    public HomeService(RiotContentRepository riotContentRepository) {
        this.riotContentRepository = riotContentRepository;
    }

    public Content getContent() {
        return riotContentRepository.getContents();
    }
}
