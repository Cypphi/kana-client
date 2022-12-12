package cypphi.amiss.feature.module.impl;

import cypphi.amiss.feature.module.Setting;
import cypphi.amiss.feature.module.ModuleCategory;
import cypphi.amiss.feature.module.Module;

public class Speed extends Module {

    public Speed() {
        super("Speed", "Makes you move faster", KEY_UNBOUND, ModuleCategory.MOVEMENT, new Setting[]{});

    }

    @Override
    public void onTick() {
        super.onTick();
    }
}
