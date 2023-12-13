package vlrtstat.gg.spell.dto;

import vlrtstat.gg.spell.domain.Spell;

public class SpellDto {
    private String name;
    private String description;
    private String image;

    public SpellDto(String name, String description, String image) {
        this.name = name;
        this.description = description;
        this.image = image;
    }

    public SpellDto(Spell spell) {
        this.name = spell.getName();
        this.description = spell.getDescription();
        this.image = spell.getSpellImageUrl();
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
