package vlrtstat.gg.spell.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;
import vlrtstat.gg.item.domain.Item;
import vlrtstat.gg.spell.domain.Spell;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

@Repository
public class JsonSpellRepository implements  SpellRepository {
    private HashMap<String, Spell> spellHashMap = new HashMap<>();
    public JsonSpellRepository() throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        ClassPathResource classPathResource = new ClassPathResource("data/13.20.1/summoner.json");
        JSONObject jsonObject = (JSONObject) jsonParser.parse(
                new InputStreamReader(classPathResource.getInputStream(), "UTF-8")
        );
        JSONObject spellData = (JSONObject) jsonObject.get("data");

        Iterator<String> keys = spellData.keySet().iterator();

        ObjectMapper objectMapper = new ObjectMapper();
        while (keys.hasNext()) {
            String key = keys.next();
            JSONObject jsonSpell = (JSONObject) spellData.get(key);
            Spell spell = objectMapper.readValue(jsonSpell.toJSONString(), Spell.class);
            spellHashMap.put(spell.getKey(), spell);
        }
    }

    @Override
    public Spell findById(int id) {
        String key = Integer.toString(id);
        return spellHashMap.getOrDefault(key, new Spell());
    }

    @Override
    public Spell[] findByIds(int[] ids) {
        ArrayList<Spell> spells = new ArrayList<>();
        for (int id : ids) {
            spells.add(findById(id));
        }
        return spells.toArray(spell -> new Spell[spell]);
    }
}
