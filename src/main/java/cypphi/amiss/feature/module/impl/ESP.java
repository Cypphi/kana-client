package cypphi.amiss.feature.module.impl;

import cypphi.amiss.feature.module.Setting;
import cypphi.amiss.feature.module.ModuleCategory;
import cypphi.amiss.feature.module.Module;

public class ESP extends Module {

    public ESP() {
        super("ESP", "Shows you where entities are", KEY_UNBOUND, ModuleCategory.RENDER, new Setting[]{});
    }
}
