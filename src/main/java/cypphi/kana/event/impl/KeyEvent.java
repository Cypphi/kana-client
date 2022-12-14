package cypphi.kana.event.impl;

import cypphi.kana.event.types.Event;

public class KeyEvent extends Event {
    private final int key;

    public KeyEvent(int key) {
        this.key = key;
    }

    public final int getKey() {
        return key;
    }
}
