package vlrtstat.gg.duo.dto;

public class MyDuoResponse {
    private DuoDto myduo;

    public MyDuoResponse(DuoDto myduo) {
        this.myduo = myduo;
    }

    public DuoDto getMyduo() {
        return myduo;
    }
}
