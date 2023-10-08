package vlrtstat.gg.riotContent.domain;

public class Act {
    private String id;
    private boolean isActive;
    private String name;
    private LocalizedNames localizedNames;

    public Act(String id, boolean isActive, String name, LocalizedNames localizedNames) {
        this.id = id;
        this.isActive = isActive;
        this.name = name;
        this.localizedNames = localizedNames;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
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
}
