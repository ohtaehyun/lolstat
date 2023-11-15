package vlrtstat.gg;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import vlrtstat.gg.match.repository.JpaMatchRepository;

@Configuration
public class JpaConfig {
//    private final EntityManager em;
//
//    public JpaConfig(EntityManager em) {
//        this.em = em;
//    }
//
//    @Bean
//    public JpaMatchRepository jpaMatchRepository() {
//        return new JpaMatchRepository(em);
//    }
}