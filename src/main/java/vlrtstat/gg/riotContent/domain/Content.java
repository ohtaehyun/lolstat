package vlrtstat.gg.riotContent.domain;

public class Content {
    private String version;
    private ContentItem[] characters;
    private Act[] acts;

    public Content(String version, ContentItem[] characters, Act[] acts) {
        this.version = version;
        this.characters = characters;
        this.acts = acts;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public ContentItem[] getCharacters() {
        return characters;
    }

    public void setCharacters(ContentItem[] characters) {
        this.characters = characters;
    }

    public Act[] getActs() {
        return acts;
    }

    public void setActs(Act[] acts) {
        this.acts = acts;
    }
}
