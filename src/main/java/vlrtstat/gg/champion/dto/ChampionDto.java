package vlrtstat.gg.champion.dto;

import vlrtstat.gg.champion.domain.Champion;

public class ChampionDto {
    private String name;
    private String description;
    private String image;

    public ChampionDto(Champion champion) {
        this.name = champion.getName();
        this.description = champion.getBlurb();
        this.image = champion.getChampionImage().getImageUrl();
    }

    public ChampionDto(String name, String description, String image) {
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
