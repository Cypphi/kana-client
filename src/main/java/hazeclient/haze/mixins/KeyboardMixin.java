package hazeclient.haze.mixins;

import hazeclient.haze.Debug;
import hazeclient.haze.HazeClient;
import hazeclient.haze.event.EventManager;
import hazeclient.haze.event.events.listener.KeyEvent;
import hazeclient.haze.utils.StringUtils;
import net.minecraft.client.Keyboard;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.ChatScreen;
import org.lwjgl.glfw.GLFW;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Keyboard.class)
public abstract class KeyboardMixin {

    @Inject(method = "onKey", at = @At("HEAD"), cancellable = true)
    private void onKeyEvent(long windowPointer, int key, int scanCode, int action, int modifiers, CallbackInfo callbackInfo) {
        if (key >= 0) {
            KeyEvent.Global event = new KeyEvent.Global(key, scanCode, action, modifiers);
            EventManager.callEvent(event);

            if (event.isCancelled()) {
                callbackInfo.cancel();
            }
        }
    }

    @Inject(method = "onKey", at = @At(value = "INVOKE", target = "net/minecraft/client/util/InputUtil.isKeyPressed(JI)Z", ordinal = 5), cancellable = true)
    private void onKeyEvent_1(long windowPointer, int key, int scanCode, int action, int modifiers, CallbackInfo callbackInfo) {
        if (StringUtils.isValidPrefixForFastChatOpen(Debug.CHAT_PREFIX) && key == Debug.CHAT_PREFIX.charAt(0)) {
            MinecraftClient.getInstance().setScreen(new ChatScreen(Debug.CHAT_PREFIX));
        }

        HazeClient.moduleManager.handleKeypress(key);

        if (key >= 0) {
            KeyEvent.InWorld event = new KeyEvent.InWorld(key, scanCode);
            EventManager.callEvent(event);

            if (event.isCancelled()) {
                callbackInfo.cancel();
            }
        }
    }

}
