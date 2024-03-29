package vlrtstat.gg.duo.dto;

import vlrtstat.gg.global.constant.Line;
import vlrtstat.gg.league.domain.LeagueEntries;
import vlrtstat.gg.summoner.domain.Summoner;
import vlrtstat.gg.user.domain.User;

import java.util.List;

public class AddDuoTicketDto {
    private Summoner summoner;
    private LeagueEntries leagueEntries;
    private User user;
    private Long duoId;
    private List<Line> lines;

    private String memo;

    public AddDuoTicketDto(Summoner summoner, LeagueEntries leagueEntries, User user, Long duoId, AddDuoTicketRequest addDuoTicketRequest) {
        this.summoner = summoner;
        this.leagueEntries = leagueEntries;
        this.user = user;
        this.duoId = duoId;
        this.lines = addDuoTicketRequest.getLines();
        this.memo = addDuoTicketRequest.getMemo();
    }

    public Summoner getSummoner() {
        return summoner;
    }

    public LeagueEntries getLeagueEntries() {
        return leagueEntries;
    }

    public User getUser() {
        return user;
    }

    public Long getDuoId() {
        return duoId;
    }

    public List<Line> getLines() {
        return lines;
    }

    public String getMemo() {
        return memo;
    }
}
