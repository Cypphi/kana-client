package hazeclient.haze;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HazeClient implements ModInitializer {
	// Client meta data (looks familiar right?... XD)
	public static String name = "Haze Client", version = "0.0.1", BUILDID = "1";

	public static final Logger LOG = LoggerFactory.getLogger(name);

	@Override
	public void onInitialize() {
		LOG.info("Initializing " + name + " " + version + "_" + BUILDID + "...");
	}
}
