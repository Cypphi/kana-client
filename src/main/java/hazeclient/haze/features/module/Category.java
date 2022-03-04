package hazeclient.haze.features.module;

public enum Category {
    COMBAT("Combat"),
    MOVEMENT("Movement"),
    PLAYER("Player"),
    WORLD("World"),
    RENDER("Render"),
    EXPLOIT("Exploit"),
    MISC("Misc");

    private final String name;

    Category(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
