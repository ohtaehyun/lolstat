package vlrtstat.gg.item.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import vlrtstat.gg.item.domain.JpaItem;

import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class JsonItemDto {
    private String name;
    private String description;
    private String plaintext;
    private String imageUrl;

    @JsonProperty("image")
    private void unpackNameFromNestedObject(Map<String, String> image) {
        imageUrl = image.get("full");
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

    public String getPlaintext() {
        return plaintext;
    }

    public void setPlaintext(String plaintext) {
        this.plaintext = plaintext;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public JpaItem toDomain(int id) {
        return new JpaItem(id, name, description, plaintext, imageUrl);
    }
}
