package cypphi.amiss.feature.module;

import cypphi.amiss.Setting;
import net.minecraft.client.util.math.MatrixStack;

public abstract class Module {

    public static final int KEY_UNBOUND = -57204;
    private String name, description;
    private ModuleCategory category;

    private boolean toggled = false;
    private int keyCode;

    private Setting[] settings;

    public Module(String name, String description, int keyCode, ModuleCategory category, Setting[] settings) {
        this.name = name;
        this.description = description;
        this.keyCode = keyCode;
        this.category = category;
        this.settings = settings;
    }

    public boolean isToggled() {
        return toggled;
    }

    public void toggle() {
        toggled = !toggled;
        if (toggled) {
            onEnable();
        }
        else {
            onDisable();
        }
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getKeyCode() {
        return keyCode;
    }

    public ModuleCategory getCategory() {
        return category;
    }

    public Setting[] getSettings() {
        return settings;
    }

    public void onEnable() {}

    public void onTick() {}

    public void onHudRender(MatrixStack matrices) {}

    public void onWorldRender(MatrixStack matrices) {}

    public void onDisable() {}

}
