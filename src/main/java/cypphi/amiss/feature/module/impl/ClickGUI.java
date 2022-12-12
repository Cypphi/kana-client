package cypphi.amiss.feature.module.impl;

import cypphi.amiss.AmissClient;
import cypphi.amiss.feature.module.Setting;
import cypphi.amiss.feature.module.Module;
import cypphi.amiss.feature.module.ModuleCategory;
import cypphi.amiss.gui.clickgui.ClickGui;
import org.lwjgl.glfw.GLFW;

public class ClickGUI extends Module {

    public ClickGUI() {
        super("ClickGUI", "Opens the clickgui.", GLFW.GLFW_KEY_RIGHT_SHIFT, ModuleCategory.RENDER, new Setting[]{});
    }

    @Override
    public void onEnable() {
        AmissClient.mc.setScreen(ClickGui.INSTANCE);
    }

}
