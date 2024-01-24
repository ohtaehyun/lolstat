package vlrtstat.gg.rune.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;
import vlrtstat.gg.rune.domain.Rune;
import vlrtstat.gg.rune.domain.RuneGroup;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

@Repository
public class JsonRuneRepository implements RuneRepository {
    private static RuneGroup[] runeGroups;

    public JsonRuneRepository(@Value("${riot.version}") String riotVersion) throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        ClassPathResource classPathResource = new ClassPathResource("data/" + riotVersion + "/runesReforged.json");
        JSONArray jsonArray = (JSONArray) jsonParser.parse(
                new InputStreamReader(classPathResource.getInputStream(), "UTF-8")
        );
        ArrayList<RuneGroup> runeGroupArrayList = new ArrayList<>();

        ObjectMapper objectMapper = new ObjectMapper();

        for (int i = 0; i < jsonArray.size(); i++) {
            RuneGroup runeGroup = objectMapper.readValue(jsonArray.get(i).toString(), RuneGroup.class);
            runeGroupArrayList.add(runeGroup);
        }

        runeGroups = runeGroupArrayList.toArray(rga -> new RuneGroup[rga]);
    }

    @Override
    public RuneGroup findRuneGroupByRuneId(int id) {
        for (RuneGroup runeGroup : runeGroups) {
            if (runeGroup.hasRune(id)) {
                return runeGroup;
            }
        }
        return new RuneGroup();
    }

    @Override
    public Rune findRuneByRuneId(int id) {
        for (RuneGroup runeGroup : runeGroups) {
            if (runeGroup.hasRune(id)) return runeGroup.getRuneById(id);
        }
        return new Rune();
    }
}
