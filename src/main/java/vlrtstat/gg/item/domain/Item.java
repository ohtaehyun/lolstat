package vlrtstat.gg.item.domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import vlrtstat.gg.item.dto.ItemDto;

@JsonIgnoreProperties(ignoreUnknown = true)
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
    private Object effect;
    private boolean hideFromAll;
    private int depth;
    private String[] from;
    private boolean consumed;
    private boolean consumeOnFull;
    private boolean inStore;
    private String requiredChampion;
    private int stacks;

    public int getStacks() {
        return stacks;
    }

    public void setStacks(int stacks) {
        this.stacks = stacks;
    }

    public boolean isConsumeOnFull() {
        return consumeOnFull;
    }

    public void setConsumeOnFull(boolean consumeOnFull) {
        this.consumeOnFull = consumeOnFull;
    }

    public boolean isInStore() {
        return inStore;
    }

    public void setInStore(boolean inStore) {
        this.inStore = inStore;
    }

    public String getRequiredChampion() {
        return requiredChampion;
    }

    public void setRequiredChampion(String requiredChampion) {
        this.requiredChampion = requiredChampion;
    }

    public boolean isConsumed() {
        return consumed;
    }

    public void setConsumed(boolean consumed) {
        this.consumed = consumed;
    }

    public String[] getFrom() {
        return from;
    }

    public void setFrom(String[] from) {
        this.from = from;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

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

    public ItemDto toItemDto() {
        String imageUrl = "";
        if (image != null) {
            imageUrl = image.getImageUrl();
        }
        return new ItemDto(name, plaintext, imageUrl);
    }

    public Object getEffect() {
        return effect;
    }

    public void setEffect(Object effect) {
        this.effect = effect;
    }

    public boolean isHideFromAll() {
        return hideFromAll;
    }

    public void setHideFromAll(boolean hideFromAll) {
        this.hideFromAll = hideFromAll;
    }

    public String getItemImage() {
        if (this.image == null) {
            return "";
        }
        return this.image.getImageUrl();
    }
}
