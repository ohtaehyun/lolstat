package vlrtstat.gg.duo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import vlrtstat.gg.duo.domain.Duo;

import java.util.Optional;

public interface DuoRepository extends JpaRepository<Duo, Long> {
    @Query(
            "select a from Duo a " +
                "where a.userId = ?1 and a.isMatched = false and current_timestamp between a.createdAt and a.expiredAt"
    )
    Optional<Duo> findLiveOne(Long userId);
    Page<Duo> findAllBy(PageRequest pageRequest);
    Page<Duo> findAllByIsMatched(boolean matched, PageRequest pageRequest);
    Optional<Duo> findByIdAndUserId(Long id, Long userId);
}
