package vlrtstat.gg.item.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import vlrtstat.gg.item.domain.Item;
import vlrtstat.gg.item.repository.ItemRepository;

public class ItemServiceImpl implements ItemService {
    private ItemRepository itemRepository;

    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public Item searchItem(int id) throws JsonProcessingException {
        return itemRepository.findById(id);
    }
}
