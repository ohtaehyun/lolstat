package vlrtstat.gg.userEmailSend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vlrtstat.gg.userEmailSend.domain.UserEmailSend;

@Repository
public interface UserEmailSendRepository extends JpaRepository<UserEmailSend, Long> {
}
