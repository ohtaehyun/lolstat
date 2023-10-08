package vlrtstat.gg.home;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "hello";
    }

    @GetMapping("/contents")
    public String getContent() {
        return "";
    }
}
