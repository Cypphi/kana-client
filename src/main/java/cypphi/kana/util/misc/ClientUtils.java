package cypphi.kana.util.misc;

import cypphi.kana.module.Module;

import java.util.function.Supplier;

public class ClientUtils {
    public static Supplier<Boolean> moduleEnabledSupplier(Module module) {
        return module::isEnabled;
    }
}