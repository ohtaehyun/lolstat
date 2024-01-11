package vlrtstat.gg.duo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vlrtstat.gg.duo.domain.DuoTicket;

public interface DuoTicketRepository extends JpaRepository<DuoTicket, Long> {
}
