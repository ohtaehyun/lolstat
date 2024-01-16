package vlrtstat.gg.duo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vlrtstat.gg.duo.domain.DuoMatchRelation;


public interface DuoMatchRelationRepository extends JpaRepository<DuoMatchRelation, Long> {
}
