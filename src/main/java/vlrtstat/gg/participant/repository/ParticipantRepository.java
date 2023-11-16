package vlrtstat.gg.participant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vlrtstat.gg.participant.domain.Participant;

public interface ParticipantRepository extends JpaRepository<Participant, Long> {
}
