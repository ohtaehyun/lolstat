package vlrtstat.gg.item.repository;

import org.assertj.core.api.Assertions;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;
import vlrtstat.gg.item.domain.Item;

import java.io.IOException;

class JsonItemRepositoryTest {
    ItemRepository itemRepository = new JsonItemRepository();

    JsonItemRepositoryTest() throws IOException, ParseException {
    }

    @Test
    void 존재하는_장비_찾기() {
        int itemId = 1001;
        Item item = itemRepository.findById(itemId);
        Assertions.assertThat(item.getName()).isEqualTo("장화");
    }

    @Test
    void 존재하지_않는_장비() {
        int itemId = 0;
        Item item = itemRepository.findById(itemId);
        Assertions.assertThat(item.getName()).isEqualTo(null);
    }
}