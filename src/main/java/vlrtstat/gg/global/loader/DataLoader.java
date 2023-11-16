package vlrtstat.gg.global.loader;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import vlrtstat.gg.champion.repository.ChampionRepository;
import vlrtstat.gg.item.domain.JpaItem;
import vlrtstat.gg.item.dto.JsonItemDataDto;
import vlrtstat.gg.item.dto.JsonItemDto;
import vlrtstat.gg.item.repository.ItemRepository;
import vlrtstat.gg.item.repository.JpaItemRepository;
import vlrtstat.gg.spell.repository.SpellRepository;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class DataLoader implements ApplicationRunner {
    private JpaItemRepository jpaItemRepository;
    private ObjectMapper objectMapper = new ObjectMapper();

    public DataLoader(JpaItemRepository jpaItemRepository) {
        this.jpaItemRepository = jpaItemRepository;
    }

    private void loadItemData() {
        JSONParser jsonParser = new JSONParser();
        ClassPathResource classPathResource = new ClassPathResource("data/13.20.1/item.json");
        try {
            JSONObject jsonObject = (JSONObject) jsonParser.parse(
                    new InputStreamReader(classPathResource.getInputStream(), "UTF-8")
            );
            JsonItemDataDto jsonItemDataDto = objectMapper.readValue(jsonObject.toJSONString(), JsonItemDataDto.class);
            Map<String, JsonItemDto> data = jsonItemDataDto.getData();
            List<JpaItem> items = new ArrayList<>();
            for (String key : data.keySet()) {
                JsonItemDto jsonItemDto = data.get(key);
                items.add(jsonItemDto.toDomain(Integer.valueOf(key)));
            }
            jpaItemRepository.saveAll(items);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        loadItemData();
    }
}
