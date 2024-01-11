package vlrtstat.gg.duo.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import vlrtstat.gg.global.constant.Line;

public class AddDuoTicketRequest {
    @NotNull
    private String gameName;

    @NotNull
    private String tagLine;

    @NotNull
    private Line line;

    @NotNull
    @Size(min = 1, max = 50)
    private String memo;

    public AddDuoTicketRequest(String gameName, String tagLine, Line line, String memo) {
        this.gameName = gameName;
        this.tagLine = tagLine;
        this.line = line;
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

    public String getMemo() {
        return memo;
    }
}
