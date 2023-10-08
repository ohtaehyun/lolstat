package vlrtstat.gg.home;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import vlrtstat.gg.riotContent.domain.Content;

@RestController
public class HomeController {
    private HomeService homeService;

    public HomeController(HomeService homeService) {
        this.homeService = homeService;
    }

    @GetMapping("/")
    public String home() {
        return "hello";
    }

    @GetMapping("/contents")
    public Content getContents() {
        return homeService.getContent();
    }
}
