package hazeclient.haze.event;

import hazeclient.haze.HazeClient;
import hazeclient.haze.InternalEventHandler;
import hazeclient.haze.event.events.listener.KeyEvent;
import hazeclient.haze.features.module.Module;
import net.minecraft.client.MinecraftClient;

public class EventManager {

    public static void callEvent(Event event) {

        InternalEventHandler.INSTANCE.onEvent(event);

        for(Module module : HazeClient.moduleManager.getModules()) {
            if(module.isToggled()) {
                module.onEvent(event);
            }
        }

    }

}
