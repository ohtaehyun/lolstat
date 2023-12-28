package vlrtstat.gg.userEmailSend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vlrtstat.gg.userEmailSend.domain.UserEmailSend;

import java.util.Optional;

@Repository
public interface UserEmailSendRepository extends JpaRepository<UserEmailSend, Long> {
    Optional<UserEmailSend> findFirstByUserIdOrderByExpiredAtDesc(long userId);
}
