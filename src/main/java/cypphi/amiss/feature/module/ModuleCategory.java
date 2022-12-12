package cypphi.amiss.feature.module;

import java.awt.*;

public enum ModuleCategory {
    COMBAT("Combat", new Color(162, 23, 33)),
    PLAYER("Player", new Color(63, 154, 29)),
    MOVEMENT("Movement", new Color(31, 67, 157)),
    RENDER("Render", new Color(176, 170, 34)),
    WORLD("World", new Color(218, 123, 18)),
    MISC("Misc", new Color(64, 29, 154));

    private final String name;
    private final Color color;

    ModuleCategory(String name, Color color) {
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public Color getColor() {
        return color;
    }

}
