package cypphi.kana;

import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.MinecraftClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KanaClient implements ClientModInitializer {
    public static String name = "Kana Client", version = "1.0.0";
    public static final MinecraftClient mc = MinecraftClient.getInstance();
    public static final Logger LOGGER = LoggerFactory.getLogger(name);

    @Override
    public void onInitializeClient() {
        LOGGER.info("Initializing " + name + " " + version);
    }
}
