package hazeclient.haze.features.module;

import hazeclient.haze.event.EventManager;
import hazeclient.haze.features.module.impl.misc.*;

import java.util.ArrayList;

public class ModuleManager {

    private final ArrayList<Module> modules = new ArrayList<>();
    protected final EventManager eventManager = new EventManager();

    public ModuleManager() {
        initialize();
    }

    protected void initialize() {

        modules.clear();

        modules.add(new TestModule());

    }

    public ArrayList<Module> getModules() {
        return modules;
    }

    public ArrayList<Module> getModules(Category category) {
        ArrayList<Module> moduleslist = new ArrayList<>();
        for(Module m : modules) {
            if(m.getCategory() == category) {
                moduleslist.add(m);
            }
        }
        return moduleslist;
    }

    public void handleKeypress(int key) {
        for(Module module : modules) {
            if(module.getKeyBind() == key) {
                module.toggle();
            }
        }
    }

}
