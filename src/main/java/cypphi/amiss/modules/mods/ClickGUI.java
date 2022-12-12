package me.lto.amiss.modules.mods;

import net.minecraft.client.MinecraftClient;
import org.lwjgl.glfw.GLFW;

import me.lto.amiss.Setting;
import me.lto.amiss.gui.clickgui.ClickGui;
import me.lto.amiss.modules.Module;
import me.lto.amiss.modules.ModuleCategory;

public class ClickGUI extends Module {

    public ClickGUI() {
        super("ClickGUI", "Opens the clickgui.", GLFW.GLFW_KEY_RIGHT_SHIFT, ModuleCategory.RENDER, new Setting[]{});
    }

    @Override
    public void onEnable() {
        MinecraftClient.getInstance().setScreen(ClickGui.INSTANCE);
    }

}
