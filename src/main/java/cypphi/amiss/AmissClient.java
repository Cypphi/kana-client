package cypphi.amiss;

import net.fabricmc.api.ModInitializer;
import net.minecraft.client.MinecraftClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AmissClient implements ModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger("Amiss Client");
	public static final MinecraftClient mc = MinecraftClient.getInstance();
	public static String name = "Amiss Client", version = "1.0.0";

	@Override
	public void onInitialize() {
		LOGGER.info("Initializing " + name + " " + version + "...");
	}
}
