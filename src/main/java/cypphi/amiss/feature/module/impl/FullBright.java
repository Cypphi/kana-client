package me.lto.amiss.modules.mods;

import me.lto.amiss.Setting;
import me.lto.amiss.modules.Module;
import me.lto.amiss.modules.ModuleCategory;
import net.minecraft.client.MinecraftClient;

public class FullBright extends Module {

    private double prevBrightness;
    private double set = 9999;

    public FullBright() {
        super("FullBright", "Night Vision.", KEY_UNBOUND, ModuleCategory.RENDER, new Setting[]{});

    }

    @Override
    public void onEnable() {
        prevBrightness = MinecraftClient.getInstance().options.gamma;
        MinecraftClient.getInstance().options.gamma = set;
    }

    @Override
    public void onDisable() {
        if (prevBrightness == set) {
            MinecraftClient.getInstance().options.gamma = 100;
        }
        else {
            MinecraftClient.getInstance().options.gamma = set;
        }
    }
}
