package vlrtstat.gg.spell.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import vlrtstat.gg.spell.dto.SpellDto;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Spell {
    private String id;
    private String name;
    private String description;

    @JsonProperty("image")
    private SpellImage spellImage;
    private String key;

    public Spell() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public SpellImage getSpellImage() {
        return spellImage;
    }

    public void setSpellImage(SpellImage spellImage) {
        this.spellImage = spellImage;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public SpellDto toSpellDto() {
        String imageUrl = "";
        if (spellImage != null) {
            imageUrl = spellImage.getImageUrl();
        }
        return new SpellDto(name, description, imageUrl);
    }
}
