package vlrtstat.gg.rune.domain;

import vlrtstat.gg.global.store.PropertyStore;
import vlrtstat.gg.rune.dto.RuneDto;

public class Rune {
    private int id;
    private String key;
    private String icon;
    private String name;
    private String shortDesc;
    private String longDesc;

    public Rune() {
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

    public String getShortDesc() {
        return shortDesc;
    }

    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }

    public String getLongDesc() {
        return longDesc;
    }

    public void setLongDesc(String longDesc) {
        this.longDesc = longDesc;
    }

    public String getImageUrl() {
        return PropertyStore.getProperty("aws.s3.url") + "/" + icon;
    }

    public RuneDto toRuneDto() {
        return new RuneDto(name, shortDesc, getImageUrl());
    }
}
