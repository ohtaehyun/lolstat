package vlrtstat.gg.duo.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import vlrtstat.gg.global.constant.Line;

import java.util.List;

public class AddDuoTicketRequest {
    @NotNull
    private String gameName;

    @NotNull
    private String tagLine;

    @NotNull
    private List<Line> lines;

    @NotNull
    @Size(min = 1, max = 50)
    private String memo;

    public AddDuoTicketRequest(String gameName, String tagLine, Line line, String memo) {
        this.gameName = gameName;
        this.tagLine = tagLine;
        this.lines = lines;
        this.memo = memo;
    }

    public String getGameName() {
        return gameName;
    }

    public String getTagLine() {
        return tagLine;
    }

    public List<Line> getLines() {
        return lines;
    }

    public String getMemo() {
        return memo;
    }
}
