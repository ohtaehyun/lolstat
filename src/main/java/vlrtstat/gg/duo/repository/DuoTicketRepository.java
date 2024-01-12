package vlrtstat.gg.duo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vlrtstat.gg.duo.domain.DuoTicket;

import java.util.Optional;

public interface DuoTicketRepository extends JpaRepository<DuoTicket, Long> {
    Optional<DuoTicket> findByIdAndDuoIdAndIsSelectedFalse(Long id, Long duoId);
    Optional<DuoTicket> findByUserIdAndDuoId(Long userId, Long duoId);
}
