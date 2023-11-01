package vlrtstat.gg.champion.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import vlrtstat.gg.champion.dto.ChampionDto;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Champion {
    private String name;
    private String blurb;
    @JsonProperty("image")
    private ChampionImage championImage;
    private String key;

    public Champion() {
        this.championImage = new ChampionImage();
    }

    public Champion(String name, String blurb, ChampionImage championImage, String key) {
        this.name = name;
        this.blurb = blurb;
        this.championImage = championImage;
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBlurb() {
        return blurb;
    }

    public void setBlurb(String blurb) {
        this.blurb = blurb;
    }

    public ChampionImage getChampionImage() {
        return championImage;
    }

    public void setChampionImage(ChampionImage championImage) {
        this.championImage = championImage;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public ChampionDto toChampionDto() {
        return new ChampionDto(name, blurb, championImage.getImageUrl());
    }
}
