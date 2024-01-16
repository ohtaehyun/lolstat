package vlrtstat.gg.duo.dto;

import vlrtstat.gg.champion.domain.Champion;
import vlrtstat.gg.champion.dto.ChampionDto;
import vlrtstat.gg.global.store.ChampionStore;
import vlrtstat.gg.participant.domain.Participant;

public class DuoRecentMatchDto {
    private ChampionDto championDto;
    private int kills;
    private int deaths;
    private int assists;
    private boolean win;

    public DuoRecentMatchDto(Participant participant) {
        Champion champion = ChampionStore.getChampion(participant.getChampionId());
        this.championDto = new ChampionDto(champion);
        this.kills = participant.getKills();
        this.deaths = participant.getDeaths();
        this.assists = participant.getAssists();
        this.win = participant.isWin();
    }

    public ChampionDto getChampionDto() {
        return championDto;
    }

    public int getKills() {
        return kills;
    }

    public int getDeaths() {
        return deaths;
    }

    public int getAssists() {
        return assists;
    }

    public boolean isWin() {
        return win;
    }
}
