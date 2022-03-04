package hazeclient.haze.event;

import hazeclient.haze.InternalEventHandler;

public class EventManager {

    public static void callEvent(Event event) {

        InternalEventHandler.INSTANCE.onEvent(event);


    }

}
