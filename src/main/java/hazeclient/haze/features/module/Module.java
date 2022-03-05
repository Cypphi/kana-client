package hazeclient.haze.features.module;

import hazeclient.haze.event.Event;

public class Module {

    private final Category category;
    private final String name;
    private final String description;
    private int keyBind;
    private boolean toggled;
    private boolean visible;

    public Module(Category category, String name, String description, int keyBind, boolean toggled, boolean visible) {
        this.category = category;
        this.name = name;
        this.description = description;
        this.keyBind = keyBind;
        this.toggled = toggled;
        this.visible = visible;
    }

    public Module(Category category, String name, String description, int keyBind) {
        this.category = category;
        this.name = name;
        this.description = description;
        this.keyBind = keyBind;
        this.toggled = false;
        this.visible = true;
    }

    public Module(Category category, String name, String description) {
        this.category = category;
        this.name = name;
        this.description = description;
        this.keyBind = 0;
        this.toggled = false;
        this.visible = true;
    }

    protected void onEnable() {}
    protected void onDisable() {}
    public void onEvent(Event event) {}

    public Category getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getKeyBind() {
        return keyBind;
    }

    public void toggle() { setToggled(!isToggled()); }

    public boolean isToggled() {
        return toggled;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setKeyBind(int keyBind) {
        this.keyBind = keyBind;
    }

    public void setToggled(boolean toggled) {
        this.toggled = toggled;
        if(this.toggled) {
            onEnable();
        } else {
            onDisable();
        }
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

}
