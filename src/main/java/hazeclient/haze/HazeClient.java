package hazeclient.haze;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.client.MinecraftClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

public class HazeClient implements ModInitializer {
	// Client meta data (looks familiar right?... XD)
	public static String name = "Haze Client", version = "0.0.1", BUILDID = "1";
	public static final MinecraftClient mc = MinecraftClient.getInstance();
	public static final Logger LOG = LoggerFactory.getLogger(name);

	private static File hazeClientPath = new File("haze-client");

	// Directory to let someone know how retarded they are (from what I've seen Haze will crash when you load it on a fabric server but it's still funny.)
	private static File hazeClientNotMadeForServers = new File("this-is-a-client-side-mod-you-dumb-nigger");

	@Override
	public void onInitialize() {
		LOG.info("Initializing " + name + " " + version + "_" + BUILDID + "...");

		try {
			if (FabricLoader.getInstance().getEnvironmentType() == EnvType.CLIENT) {
				hazeClientPath.mkdirs();
			} else {
				// yap
				LOG.info("This is a client-side utility mod you dumb nigger.");
				hazeClientNotMadeForServers.mkdirs();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
