package vlrtstat.gg.duo.dto;

import vlrtstat.gg.duo.domain.DuoTicket;

public class DuoDetailResponse {
    private DuoDto duo;

    public DuoDetailResponse(DuoDto duo) {
        this.duo = duo;
    }

    public DuoDto getDuo() {
        return duo;
    }
}
