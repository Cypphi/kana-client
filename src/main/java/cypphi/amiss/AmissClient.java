package cypphi.amiss;

import cypphi.amiss.feature.command.CommandManager;
import cypphi.amiss.feature.module.ModuleManager;
import net.fabricmc.api.ModInitializer;
import net.minecraft.client.MinecraftClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AmissClient implements ModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger("Astel Client");
	public static final MinecraftClient mc = MinecraftClient.getInstance();
	public static String name = "Astel ", version = "1.0.0";

	@Override
	public void onInitialize() {
		init();
	}

	void init() {
		LOGGER.info("Initializing " + name + " " + version + "...");
		ModuleManager.addModules();
		CommandManager.addCommands();
	}
}
