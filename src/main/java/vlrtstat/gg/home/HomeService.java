package vlrtstat.gg.home;

import org.springframework.stereotype.Service;
import vlrtstat.gg.riotContent.domain.Content;
import vlrtstat.gg.riotContent.repository.ContentRepository;

@Service
public class HomeService {
    private ContentRepository contentRepository;

    public HomeService(ContentRepository contentRepository) {
        this.contentRepository = contentRepository;
    }

    public Content getContent() {
        return contentRepository.getContents();
    }
}
