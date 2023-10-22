package vlrtstat.gg.item.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;
import vlrtstat.gg.item.domain.Item;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

@Repository
public class JsonItemRepository implements ItemRepository {
    private static JSONObject itemData;

    public JsonItemRepository() throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        ClassPathResource classPathResource = new ClassPathResource("data/13.20.1/item.json");
        JSONObject jsonObject = (JSONObject) jsonParser.parse(
                new InputStreamReader(classPathResource.getInputStream(), "UTF-8")
        );
        itemData = (JSONObject) jsonObject.get("data");
    }

    @Override
    public Item findById(int itemId) {
        ObjectMapper objectMapper = new ObjectMapper();
        JSONObject jsonItem = (JSONObject) itemData.getOrDefault(Integer.toString(itemId), new JSONObject());
        try {
            return objectMapper.readValue(jsonItem.toJSONString(), Item.class);
        } catch (JsonProcessingException e) {
            return new Item();
        }
    }
}
