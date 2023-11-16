package vlrtstat.gg.match.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import vlrtstat.gg.match.domain.RiotMatch;

import java.util.Optional;

@Repository
@Transactional
public class JpaMatchRepository implements MatchRepository{

    @PersistenceContext
    private EntityManager em;


    @Override
    public Optional<RiotMatch> find(String matchId) {
        RiotMatch match = em.find(RiotMatch.class, matchId);
        return Optional.ofNullable(match);
    }

    @Override
    public RiotMatch save(RiotMatch riotMatch) {
        em.persist(riotMatch);
        return riotMatch;
    }
}
