package hazeclient.haze.features.module;

import hazeclient.haze.features.module.impl.misc.*;

import java.util.ArrayList;

public class ModuleManager {

    private final ArrayList<Module> modules = new ArrayList<>();

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

}
