package vlrtstat.gg.match.domain;

import java.util.ArrayList;
import java.util.List;

public class PerkStyle {
    private String description;
    private PerkStyleSelection[] selections;
    private int style;

    public PerkStyle(String description, PerkStyleSelection[] selections, int style) {
        this.setDescription(description);
        this.setSelections(selections);
        this.setStyle(style);
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

    public int[] getPerkIds() {
        List<Integer> ids = new ArrayList<>();
        for (PerkStyleSelection selection : selections) {
            ids.add(selection.getPerk());
        }
        return ids.stream().mapToInt(i -> i).toArray();
    }
}
