package cypphi.amiss.feature.module.impl;

import cypphi.amiss.feature.module.ModuleCategory;
import cypphi.amiss.gui.clickgui.ClickGui;
import net.minecraft.client.MinecraftClient;
import org.lwjgl.glfw.GLFW;

import me.lto.amiss.Setting;

public class ClickGUI extends Module {

    public ClickGUI() {
        super("ClickGUI", "Opens the clickgui.", GLFW.GLFW_KEY_RIGHT_SHIFT, ModuleCategory.RENDER, new Setting[]{});
    }

    @Override
    public void onEnable() {
        MinecraftClient.getInstance().setScreen(ClickGui.INSTANCE);
    }

}
