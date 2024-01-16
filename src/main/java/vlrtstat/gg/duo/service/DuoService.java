package vlrtstat.gg.duo.service;

import vlrtstat.gg.duo.constant.DuoMatchFilter;
import vlrtstat.gg.duo.dto.AddDuoDto;
import vlrtstat.gg.duo.dto.AddDuoTicketDto;
import vlrtstat.gg.duo.dto.DuoDetailResponse;
import vlrtstat.gg.duo.dto.DuoListResponse;
import vlrtstat.gg.global.filter.QueueIdFilter;
import vlrtstat.gg.user.domain.User;

public interface DuoService {
    void addDuo(AddDuoDto addDuoDto);

    DuoListResponse duoList(User user, int page, DuoMatchFilter duoMatchFilter, QueueIdFilter queueIdFilter);

    DuoDetailResponse getDuoDetail(Long duoId);

    void addDuoTicket(AddDuoTicketDto addDuoTicketDto);

    void acceptDuoTicket(Long duoId, Long ticketId, User user);
}
