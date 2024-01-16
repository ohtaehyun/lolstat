package vlrtstat.gg.duo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import vlrtstat.gg.duo.domain.Duo;
import vlrtstat.gg.global.constant.QueueId;

import java.util.Optional;

public interface DuoRepository extends JpaRepository<Duo, Long> {
    @Query(
            "select a from Duo a " +
                "where a.userId = ?1 and a.isMatched = false and current_timestamp between a.createdAt and a.expiredAt"
    )
    Optional<Duo> findLiveOne(Long userId);

    @Query(
            "select d from Duo d " +
                    "where (:matched is null or d.isMatched = :matched ) " +
                    "and " +
                    "(:queueId is null or d.queueId = :queueId)"
    )
    Page<Duo> findAllByQuery(@Param("matched") Boolean matched, @Param("queueId") QueueId queueId, PageRequest pageRequest);
    Optional<Duo> findByIdAndUserId(Long id, Long userId);
}
