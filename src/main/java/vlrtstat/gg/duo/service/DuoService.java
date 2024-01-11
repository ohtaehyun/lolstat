package vlrtstat.gg.duo.service;

import vlrtstat.gg.duo.constant.DuoMatchFilter;
import vlrtstat.gg.duo.dto.AddDuoDto;
import vlrtstat.gg.duo.dto.DuoListResponse;
import vlrtstat.gg.user.domain.User;

public interface DuoService {
    void addDuo(AddDuoDto addDuoDto);
    DuoListResponse duoList(User user, int page, DuoMatchFilter duoMatchFilter);
}
