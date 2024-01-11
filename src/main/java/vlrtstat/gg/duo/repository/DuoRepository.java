package vlrtstat.gg.duo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vlrtstat.gg.duo.domain.Duo;

public interface DuoRepository extends JpaRepository<Duo, Long> {
}
