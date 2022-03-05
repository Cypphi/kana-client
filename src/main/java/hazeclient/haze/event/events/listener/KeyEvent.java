package hazeclient.haze.event.events.listener;

import hazeclient.haze.event.CancellableEvent;

public class KeyEvent extends CancellableEvent {

    private final int key;
    private final int scanCode;

    public KeyEvent(int key, int scanCode) {
        this.key = key;
        this.scanCode = scanCode;
    }

    public int getKey() {
        return key;
    }

    public int getScanCode() {
        return scanCode;
    }

    public static class Global extends KeyEvent {

        private final int action;
        private final int modifiers;

        public Global(int key, int scanCode, int action, int modifiers) {
            super(key, scanCode);
            this.action = action;
            this.modifiers = modifiers;
        }

        public int getAction() {
            return action;
        }

        public int getModifiers() {
            return modifiers;
        }

    }

    public static class InWorld extends KeyEvent {

        public InWorld(int key, int scanCode) {
            super(key, scanCode);
        }

    }
}
