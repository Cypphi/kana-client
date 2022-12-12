package cypphi.astel.feature.module.impl;

import cypphi.astel.feature.module.Setting;
import cypphi.astel.feature.module.ModuleCategory;
import cypphi.astel.feature.module.Module;

public class ESP extends Module {

    public ESP() {
        super("ESP", "Shows you where entities are", KEY_UNBOUND, ModuleCategory.RENDER, new Setting[]{});
    }
}
