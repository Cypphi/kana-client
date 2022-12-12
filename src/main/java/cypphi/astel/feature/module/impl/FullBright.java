package cypphi.astel.feature.module.impl;

import cypphi.astel.feature.module.Setting;
import cypphi.astel.feature.module.ModuleCategory;
import net.minecraft.client.MinecraftClient;
import cypphi.astel.feature.module.Module;

import static cypphi.astel.AstelClient.mc;

public class FullBright extends Module {

    private double prevBrightness;
    private double set = 9999;

    public FullBright() {
        super("FullBright", "Night Vision.", KEY_UNBOUND, ModuleCategory.RENDER, new Setting[]{});

    }

    @Override
    public void onEnable() {
        prevBrightness = MinecraftClient.getInstance().options.getGamma().getValue();
        mc.options.getGamma().setValue(set);
    }

    @Override
    public void onDisable() {
        if (prevBrightness == set) {
            mc.options.getGamma().setValue(100D);
        }
        else {
            mc.options.getGamma().setValue(prevBrightness);
        }
    }
}
