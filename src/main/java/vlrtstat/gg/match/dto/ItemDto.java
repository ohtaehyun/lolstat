package vlrtstat.gg.match.dto;

import vlrtstat.gg.item.domain.Item;

public class ItemDto {
    private String name;
    private String description;
    private String image;

    public ItemDto(Item item) {
        this.name = item.getName();
        this.description = item.getDescription();
        this.image = item.getItemImage();
    }

    public ItemDto(String name, String description, String imageUrl) {
        this.name = name;
        this.description = description;
        this.image = imageUrl;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getImage() {
        return image;
    }
}
