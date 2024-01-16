package vlrtstat.gg.duo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vlrtstat.gg.duo.domain.DuoTicketMatchRelation;

public interface DuoTicketMatchRelationRepository extends JpaRepository<DuoTicketMatchRelation, Long> {
}
