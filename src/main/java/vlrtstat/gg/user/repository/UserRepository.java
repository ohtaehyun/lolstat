package vlrtstat.gg.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vlrtstat.gg.user.domain.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmailAndIsDeletedFalse(String email);
}
