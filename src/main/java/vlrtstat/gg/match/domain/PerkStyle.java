package vlrtstat.gg.match.domain;

public class PerkStyle {
    String description;
    PerkStyleSelection[] selections;
    int style;

    public PerkStyle(String description, PerkStyleSelection[] selections, int style) {
        this.description = description;
        this.selections = selections;
        this.style = style;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public PerkStyleSelection[] getSelections() {
        return selections;
    }

    public void setSelections(PerkStyleSelection[] selections) {
        this.selections = selections;
    }

    public int getStyle() {
        return style;
    }

    public void setStyle(int style) {
        this.style = style;
    }
}
