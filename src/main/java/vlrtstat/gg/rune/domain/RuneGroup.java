package vlrtstat.gg.rune.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import vlrtstat.gg.global.propertyStore.PropertyStore;
import vlrtstat.gg.rune.dto.RuneDto;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RuneGroup {
    private int id;
    private String key;
    private String icon;
    private String name;
    private Slot[] slots;

    public RuneGroup() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Slot[] getSlots() {
        return slots;
    }

    public void setSlots(Slot[] slots) {
        this.slots = slots;
    }

    public boolean hasRune(int id) {
        if (this.id == id) {
            return true;
        }

        for (Slot slot : slots) {
            if (slot.hasRune(id)) return true;
        }

        return false;
    }

    public Rune getRuneById(int id) {
        for (Slot slot : slots) {
            return slot.getRuneById(id);
        }
        return new Rune();
    }


    public String getImageUrl() {
        return PropertyStore.getProperty("aws.s3.url") + "/" + icon;
    }

    public RuneDto toRuneDto() {
        return new RuneDto(name, "", getImageUrl());
    }
}
