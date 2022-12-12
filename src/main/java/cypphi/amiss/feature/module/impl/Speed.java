package cypphi.amiss.feature.module.impl;

import cypphi.amiss.feature.module.ModuleCategory;
import me.lto.amiss.Setting;

public class Speed extends Module {

    public Speed() {
        super("Speed", "Makes you move faster", KEY_UNBOUND, ModuleCategory.MOVEMENT, new Setting[]{});

    }

    @Override
    public void onTick() {
        super.onTick();
    }
}
