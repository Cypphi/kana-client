package cypphi.amiss;

import net.fabricmc.api.ModInitializer;
import net.minecraft.client.MinecraftClient;
import cypphi.amiss.modules.ModuleManager;
import cypphi.amiss.commands.CommandManager;
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
		LOGGER.info("Initializing " + name + " b" + version + "...");
		ModuleManager.addModules();
		CommandManager.addCommands();
	}
}
