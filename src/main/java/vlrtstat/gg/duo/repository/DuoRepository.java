package vlrtstat.gg.duo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vlrtstat.gg.duo.domain.Duo;

import java.util.Optional;

public interface DuoRepository extends JpaRepository<Duo, Long> {
    Optional<Duo> findFirstByUserIdAndIsMatchedFalseOrderByExpiredAtDesc(Long userId);
}
