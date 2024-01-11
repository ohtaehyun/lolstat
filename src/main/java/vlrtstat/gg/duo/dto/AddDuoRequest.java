package vlrtstat.gg.duo.dto;

import io.swagger.v3.oas.annotations.Hidden;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import vlrtstat.gg.global.constant.Line;
import vlrtstat.gg.global.constant.Tier;

public class AddDuoRequest {
    @NotNull
    private String gameName;

    @NotNull
    private String tagLine;

    @NotNull
    private Line line;

    @NotNull
    private Line[] wishLines;

    @NotNull
    private Tier[] wishTiers;

    @NotNull
    @NotEmpty
    @Length(min = 1, max = 50)
    private String memo;

    @AssertTrue(message = "희망 라인과 희망 티어는 필수입니다.")
    @Hidden
    public boolean assertBody() {
        return wishLines.length > 0 && wishTiers.length > 0;
    }

    public AddDuoRequest(String gameName, String tagLine, Line line, @NotNull Line[] wishLines, @NotNull Tier[] wishTiers, String memo) {
        this.gameName = gameName;
        this.tagLine = tagLine;
        this.line = line;
        this.wishLines = wishLines;
        this.wishTiers = wishTiers;
        this.memo = memo;
    }

    public String getGameName() {
        return gameName;
    }

    public String getTagLine() {
        return tagLine;
    }

    public Line getLine() {
        return line;
    }

    public Line[] getWishLines() {
        return wishLines;
    }

    public Tier[] getWishTiers() {
        return wishTiers;
    }

    public String getMemo() {
        return memo;
    }
}
