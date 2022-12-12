package me.lto.amiss.modules.mods;

import me.lto.amiss.Setting;
import me.lto.amiss.modules.Module;
import me.lto.amiss.modules.ModuleCategory;

public class ESP extends Module {

    public ESP() {
        super("ESP", "Shows you where entities are", KEY_UNBOUND, ModuleCategory.RENDER, new Setting[]{});
    }


}
