package vlrtstat.gg.global.https;


import io.swagger.v3.oas.annotations.Hidden;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CertController {
    @Hidden
    @GetMapping("/.well-known/acme-challenge/ev2c8iRJPcBgQ5hZsqO83G4Pha8L-wPl1H881-AmLr8")
    public String applyHttps() {
        return "ev2c8iRJPcBgQ5hZsqO83G4Pha8L-wPl1H881-AmLr8.YmTS33CArM04GAVS8NWf2ve1DwGIGFe2bqs5ca3V65k";
    }
}
