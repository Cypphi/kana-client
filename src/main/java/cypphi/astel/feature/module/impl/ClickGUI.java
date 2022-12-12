package cypphi.astel.feature.module.impl;

import cypphi.astel.AstelClient;
import cypphi.astel.feature.module.Setting;
import cypphi.astel.feature.module.Module;
import cypphi.astel.feature.module.ModuleCategory;
import cypphi.astel.gui.clickgui.ClickGui;
import org.lwjgl.glfw.GLFW;

public class ClickGUI extends Module {

    public ClickGUI() {
        super("ClickGUI", "Opens the clickgui.", GLFW.GLFW_KEY_RIGHT_SHIFT, ModuleCategory.RENDER, new Setting[]{});
    }

    @Override
    public void onEnable() {
        AstelClient.mc.setScreen(ClickGui.INSTANCE);
    }

}
