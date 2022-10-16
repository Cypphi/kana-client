package hazeclient.haze;

import net.fabricmc.api.ModInitializer;
import net.minecraft.client.MinecraftClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

public class HazeClient implements ModInitializer {
	public static String name = "Haze", version = "0.0.1";
	public static final MinecraftClient mc = MinecraftClient.getInstance();
	public static final Logger LOGGER = LoggerFactory.getLogger(name);

	@Override
	public void onInitialize() {
		LOGGER.info("Initializing Resolute " + version + "...");
	}
}
