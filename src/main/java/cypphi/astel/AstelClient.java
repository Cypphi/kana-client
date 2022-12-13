package cypphi.astel;

import cypphi.astel.feature.command.CommandManager;
import cypphi.astel.feature.module.ModuleManager;
import net.fabricmc.api.ModInitializer;
import net.minecraft.client.MinecraftClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AstelClient implements ModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger("Astel Client");
	public static final MinecraftClient mc = MinecraftClient.getInstance();
	public static String name = "Astel", version = "1.0.0";

	@Override
	public void onInitialize() {
		init();
	}

	void init() {
		LOGGER.info("Initializing " + name + " b" + version + "...");
		ModuleManager.addModules();
		CommandManager.addCommands();
	}
}
