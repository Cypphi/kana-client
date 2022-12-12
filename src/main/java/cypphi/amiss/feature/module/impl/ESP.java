package cypphi.amiss.feature.module.impl;

import cypphi.amiss.feature.module.ModuleCategory;

public class ESP extends Module {

    public ESP() {
        super("ESP", "Shows you where entities are", KEY_UNBOUND, ModuleCategory.RENDER, new Setting[]{});
    }
}
