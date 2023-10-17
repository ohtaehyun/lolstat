package vlrtstat.gg.item.domain;


public class Item {
    private String name;
    private String description;
    private String colloq;
    private String plaintext;
    private String[] into;
    private ItemImage image;
    private ItemGold gold;
    private String[] tags;
    private Object maps;
    private Object stats;

    public Item() {
    }

    public Item(String name, String description, String colloq, String plaintext, String[] into, ItemImage image, ItemGold gold, String[] tags, Object maps, Object stats) {
        this.name = name;
        this.description = description;
        this.colloq = colloq;
        this.plaintext = plaintext;
        this.into = into;
        this.image = image;
        this.gold = gold;
        this.tags = tags;
        this.maps = maps;
        this.stats = stats;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getColloq() {
        return colloq;
    }

    public String getPlaintext() {
        return plaintext;
    }

    public String[] getInto() {
        return into;
    }

    public ItemImage getImage() {
        return image;
    }

    public ItemGold getGold() {
        return gold;
    }

    public String[] getTags() {
        return tags;
    }

    public Object getMaps() {
        return maps;
    }

    public Object getStats() {
        return stats;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setColloq(String colloq) {
        this.colloq = colloq;
    }

    public void setPlaintext(String plaintext) {
        this.plaintext = plaintext;
    }

    public void setInto(String[] into) {
        this.into = into;
    }

    public void setImage(ItemImage image) {
        this.image = image;
    }

    public void setGold(ItemGold gold) {
        this.gold = gold;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    public void setMaps(Object maps) {
        this.maps = maps;
    }

    public void setStats(Object stats) {
        this.stats = stats;
    }
}
