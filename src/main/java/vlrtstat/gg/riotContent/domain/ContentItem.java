package vlrtstat.gg.riotContent.domain;

public class ContentItem {
    private String id;
    private String name;
    private LocalizedNames localizedNames;
    private String assetName;
    private String assetPath;

    public ContentItem(String id, String name, LocalizedNames localizedNames, String assetName, String assetPath) {
        this.id = id;
        this.name = name;
        this.localizedNames = localizedNames;
        this.assetName = assetName;
        this.assetPath = assetPath;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalizedNames getLocalizedNames() {
        return localizedNames;
    }

    public void setLocalizedNames(LocalizedNames localizedNames) {
        this.localizedNames = localizedNames;
    }

    public String getAssetName() {
        return assetName;
    }

    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }

    public String getAssetPath() {
        return assetPath;
    }

    public void setAssetPath(String assetPath) {
        this.assetPath = assetPath;
    }
}
