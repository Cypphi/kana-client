package cypphi.amiss.feature.module.impl;

import cypphi.amiss.feature.module.Setting;
import cypphi.amiss.feature.module.ModuleCategory;
import net.minecraft.client.MinecraftClient;
import cypphi.amiss.feature.module.Module;

import static cypphi.amiss.AmissClient.mc;

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
