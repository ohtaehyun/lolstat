package vlrtstat.gg.match.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vlrtstat.gg.match.domain.RiotMatch;

import java.util.Optional;

public interface MatchRepository extends JpaRepository<RiotMatch, Long> {
    Optional<RiotMatch> findByMatchId(String matchId);
    RiotMatch save(RiotMatch riotMatch);
}
