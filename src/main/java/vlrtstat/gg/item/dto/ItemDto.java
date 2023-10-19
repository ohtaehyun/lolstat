package vlrtstat.gg.item.dto;

public class ItemDto {
    private String name;
    private String plaintext;
    private String image;

    public ItemDto(String name, String plaintext, String image) {
        this.name = name;
        this.plaintext = plaintext;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlaintext() {
        return plaintext;
    }

    public void setPlaintext(String plaintext) {
        this.plaintext = plaintext;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
