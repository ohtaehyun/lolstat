package vlrtstat.gg.duo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import vlrtstat.gg.duo.domain.Duo;

import java.util.Optional;

public interface DuoRepository extends JpaRepository<Duo, Long> {
    Optional<Duo> findFirstByUserIdAndIsMatchedFalseOrderByExpiredAtDesc(Long userId);

    Page<Duo> findAllBy(PageRequest pageRequest);
    Page<Duo> findAllByIsMatched(boolean matched, PageRequest pageRequest);
}
