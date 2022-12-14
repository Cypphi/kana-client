package cypphi.kana.util.misc;

import java.util.HashMap;
import java.util.Map;

public abstract class Manager<T> {
    protected final Map<Class<? extends T>, T> instances = new HashMap<>();

    protected abstract void register();

    protected void add(T instance) {
        instances.put((Class<? extends T>) instance.getClass(), instance);
    }
}
