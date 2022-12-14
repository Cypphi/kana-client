package cypphi.kana;

import cypphi.kana.event.bus.bus.impl.EventBus;
import cypphi.kana.event.types.Event;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.MinecraftClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Kana implements ClientModInitializer {
    private static final Kana INSTANCE = new Kana();

    public static String name = "Kana Client", version = "1.0.0";
    public static final MinecraftClient mc = MinecraftClient.getInstance();
    public static final Logger LOGGER = LoggerFactory.getLogger(name);
    private final EventBus<Event> eventBus = new EventBus<>();

    public final String getName() {
        return name;
    }

    public final String getVersion() {
        return version;
    }

    public final EventBus<Event> getEventBus() {
        return eventBus;
    }

    public static Kana getInstance() {
        return INSTANCE;
    }

    @Override
    public void onInitializeClient() {
        LOGGER.info("Initializing " + name + " " + version);
    }
}
