package me.lto.amiss.modules.mods;

import me.lto.amiss.Setting;
import me.lto.amiss.modules.Module;
import me.lto.amiss.modules.ModuleCategory;

public class Speed extends Module {

    public Speed() {
        super("Speed", "Makes you move faster", KEY_UNBOUND, ModuleCategory.MOVEMENT, new Setting[]{});

    }

    @Override
    public void onTick() {
        super.onTick();
    }
}
