package vlrtstat.gg.item.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Repository;
import vlrtstat.gg.item.domain.Item;

public interface ItemRepository {
    Item findById(int itemId);
}
