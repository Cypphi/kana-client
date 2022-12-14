package cypphi.astel;

import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.MinecraftClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AstelClient implements ClientModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("Astel Client");
    public static final MinecraftClient mc = MinecraftClient.getInstance();
    public static String name = "Astel Client", version = "1.0.0";

    @Override
    public void onInitializeClient() {
        LOGGER.info("Initializing " + name + " " + version);
    }
}
