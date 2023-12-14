package vlrtstat.gg.rune.dto;

import vlrtstat.gg.rune.domain.Rune;

public class RuneDto {
    private String name;
    private String description;
    private String image;

    public RuneDto(Rune rune) {
        this.name = rune.getName();
        this.description = rune.getLongDesc();
        this.image = rune.getImageUrl();
    }

    public RuneDto(String name, String description, String image) {
        this.name = name;
        this.description = description;
        this.image = image;
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
