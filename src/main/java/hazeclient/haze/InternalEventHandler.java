package hazeclient.haze;

import hazeclient.haze.event.Event;

public class InternalEventHandler {

    public static InternalEventHandler INSTANCE;

    public InternalEventHandler() {
        INSTANCE = this;
    }

    public void onEvent(Event event) {

        /*
        This is called before all the modules.
         */

    }

}
