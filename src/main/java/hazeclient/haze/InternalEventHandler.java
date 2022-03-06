package hazeclient.haze;

import hazeclient.haze.event.Event;
import hazeclient.haze.event.events.listener.KeyEvent;

public class InternalEventHandler {

    public static InternalEventHandler INSTANCE;

    public InternalEventHandler() {
        INSTANCE = this;
    }

    public void onEvent(Event event) {

        /*
        This is called before all the modules.
         */

        if(event instanceof KeyEvent) {
            HazeClient.LOG.debug("Key Pressed: " + ((KeyEvent) event).getKey());
        }

    }

}
