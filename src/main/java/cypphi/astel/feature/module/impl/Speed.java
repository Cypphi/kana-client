package cypphi.astel.feature.module.impl;

import cypphi.astel.feature.module.Setting;
import cypphi.astel.feature.module.ModuleCategory;
import cypphi.astel.feature.module.Module;

public class Speed extends Module {

    public Speed() {
        super("Speed", "Makes you move faster", KEY_UNBOUND, ModuleCategory.MOVEMENT, new Setting[]{});

    }

    @Override
    public void onTick() {
        super.onTick();
    }
}
