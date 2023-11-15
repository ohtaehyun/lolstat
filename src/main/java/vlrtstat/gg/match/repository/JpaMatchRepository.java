package vlrtstat.gg.match.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class JpaMatchRepository {

    @PersistenceContext
    private EntityManager em;
}
