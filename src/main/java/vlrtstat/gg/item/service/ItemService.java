package vlrtstat.gg.item.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import vlrtstat.gg.item.domain.Item;

public interface ItemService {
    Item searchItem(int id) throws JsonProcessingException;
}
