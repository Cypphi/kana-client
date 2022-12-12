package cypphi.amiss.mixin;

import cypphi.amiss.feature.module.ModuleManager;
import net.minecraft.client.Keyboard;
import net.minecraft.client.MinecraftClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Keyboard.class)
public class KeyboardMixin {

    private MinecraftClient client;

    @Inject(method = "onKey", at = @At(value = "INVOKE", target = "net/minecraft/client/util/InputUtil.isKeyPressed(JI)Z", ordinal = 5), cancellable = true)
    private void onKey(long window, int key, int scanCode, int action, int modifiers, CallbackInfo callbackInfo) {
        if (action == 1 && window == this.client.getWindow().getHandle() && this.client.currentScreen == null) {
            for (Module module : ModuleManager.getModules()) {
                if (module.getKeyCode() == key) {
                    module.toggle();
                }
            }
        }
    }
}
