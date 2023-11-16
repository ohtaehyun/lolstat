package vlrtstat.gg.item.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vlrtstat.gg.item.domain.JpaItem;

public interface JpaItemRepository extends JpaRepository<JpaItem, Integer> {
    JpaItem save(JpaItem item);
}
