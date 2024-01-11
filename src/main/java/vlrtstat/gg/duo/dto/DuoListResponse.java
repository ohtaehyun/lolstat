package vlrtstat.gg.duo.dto;

import java.util.List;

public class DuoListResponse {
    private DuoDto myDuo;
    private List<DuoDto> duoList;

    public DuoListResponse(DuoDto myDuo, List<DuoDto> duoList) {
        this.myDuo = myDuo;
        this.duoList = duoList;
    }

    public DuoDto getMyDuo() {
        return myDuo;
    }

    public List<DuoDto> getDuoList() {
        return duoList;
    }
}
