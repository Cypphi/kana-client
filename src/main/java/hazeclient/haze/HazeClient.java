package hazeclient.haze;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.MinecraftClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

public class HazeClient implements ModInitializer {
	public static String name = "Haze", version = "0.0.1", buildId = "1", mcVersion = "1.18.2";
	public static final MinecraftClient mc = MinecraftClient.getInstance();
	public static final Logger LOG = LoggerFactory.getLogger(name);

	private static final File hazeClientPath = new File("haze-client");

	@Override
	public void onInitialize() {
		LOG.info("Initializing " + name + " " + version + "_" + buildId + "...");

		try {
			if (FabricLoader.getInstance().getEnvironmentType() == EnvType.CLIENT) {
				if (!hazeClientPath.exists()) {
					hazeClientPath.mkdirs();
				}
			} else {
				LOG.info("This is a client-side utility mod you dumb nigger.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
