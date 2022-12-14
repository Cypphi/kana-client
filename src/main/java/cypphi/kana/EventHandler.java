package cypphi.kana;

import cypphi.kana.event.impl.HUDRenderEvent;
import me.x150.renderer.event.EventListener;
import me.x150.renderer.event.EventType;
import me.x150.renderer.event.events.ScreenRenderEvent;

public class EventHandler {
    @EventListener(EventType.HUD_RENDER)
    public void onHudRenderEvent(ScreenRenderEvent event) {
        Kana.getInstance().getEventBus().post(new HUDRenderEvent(event));
    }
}
