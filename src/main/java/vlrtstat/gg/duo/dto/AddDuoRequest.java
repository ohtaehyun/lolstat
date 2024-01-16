package vlrtstat.gg.duo.dto;

import io.swagger.v3.oas.annotations.Hidden;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import vlrtstat.gg.duo.constant.DuoQueueId;
import vlrtstat.gg.global.constant.Line;
import vlrtstat.gg.global.constant.Tier;

import java.util.List;

public class AddDuoRequest {
    @NotNull
    private String gameName;

    @NotNull
    private String tagLine;

    @NotNull
    private List<Line> lines;

    @NotNull
    private List<Line> wishLines;

    @NotNull
    private List<Tier> wishTiers;

    @NotNull
    private DuoQueueId duoQueueId;

    @NotNull
    @NotEmpty
    @Length(min = 1, max = 50)
    private String memo;

    @AssertTrue(message = "희망 라인과 희망 티어는 필수입니다.")
    @Hidden
    public boolean assertBody() {
        return wishLines.size() > 0 && wishTiers.size() > 0;
    }

    public AddDuoRequest(String gameName, String tagLine, List<Line> lines, @NotNull List<Line> wishLines, @NotNull List<Tier> wishTiers, DuoQueueId duoQueueId, String memo) {
        this.gameName = gameName;
        this.tagLine = tagLine;
        this.lines = lines;
        this.wishLines = wishLines;
        this.wishTiers = wishTiers;
        this.duoQueueId = duoQueueId;
        this.memo = memo;
    }

    public String getGameName() {
        return gameName;
    }

    public String getTagLine() {
        return tagLine;
    }

    public List<Line> getWishLines() {
        return wishLines;
    }

    public List<Tier> getWishTiers() {
        return wishTiers;
    }

    public String getMemo() {
        return memo;
    }

    public List<Line> getLines() {
        return lines;
    }

    public DuoQueueId getDuoQueueId() {
        return duoQueueId;
    }
}
