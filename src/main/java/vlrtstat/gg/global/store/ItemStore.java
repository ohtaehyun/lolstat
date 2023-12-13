package vlrtstat.gg.global.store;

import org.springframework.context.ApplicationContext;
import vlrtstat.gg.item.domain.Item;
import vlrtstat.gg.item.repository.ItemRepository;

import java.util.ArrayList;
import java.util.List;

public class ItemStore {
    private static ItemRepository itemRepository;

    private static void setItemRepository() {
        ApplicationContext ac = ApplicationContextStore.getApplicationContext();
        itemRepository = ac.getBean("jsonItemRepository", ItemRepository.class);
    }

    public static Item getItem(int itemId) {
        if (itemRepository == null) setItemRepository();
        return itemRepository.findById(itemId);
    }

    public static Item[] getItems(int[] itemIds) {
        if (itemRepository == null) setItemRepository();
        Item[] items = itemRepository.findByIds(itemIds);
        return itemRepository.findByIds(itemIds);
    }
}
