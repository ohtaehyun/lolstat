package vlrtstat.gg.match.repository;

import vlrtstat.gg.match.domain.RiotMatch;

import java.util.Optional;

public interface MatchRepository {
    Optional<RiotMatch> find(String matchId);
    RiotMatch save(RiotMatch riotMatch);
}
