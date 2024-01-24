package vlrtstat.gg.champion.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;
import vlrtstat.gg.champion.domain.Champion;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;

@Repository
public class JsonChampionRepository implements ChampionRepository {
    HashMap<String, Champion> championHashMap = new HashMap<>();



    public JsonChampionRepository(@Value("${riot.version}") String riotVersion) throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        ClassPathResource classPathResource = new ClassPathResource("data/" + riotVersion + "/champion.json");
        JSONObject jsonObject = (JSONObject) jsonParser.parse(
                new InputStreamReader(classPathResource.getInputStream(), "UTF-8")
        );
        JSONObject championData = (JSONObject) jsonObject.get("data");
        Iterator<String> keys = championData.keySet().iterator();

        ObjectMapper objectMapper = new ObjectMapper();
        while (keys.hasNext()) {
            String key = keys.next();
            JSONObject jsonChampion = (JSONObject) championData.get(key);

            Champion champion = objectMapper.readValue(jsonChampion.toJSONString(), Champion.class);
            championHashMap.put(champion.getKey(), champion);
        }
    }

    @Override
    public Champion findById(int id) {
        return championHashMap.getOrDefault(Integer.toString(id), new Champion());
    }
}
