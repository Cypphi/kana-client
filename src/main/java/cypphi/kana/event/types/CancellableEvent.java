package cypphi.kana.event.types;

public class CancellableEvent extends Event {
    private boolean cancelled;

    public final boolean isCancelled() {
        return cancelled;
    }

    public final void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }

    public final void cancel() {
        setCancelled(true);
    }
}
