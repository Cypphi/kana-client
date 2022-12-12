package cypphi.amiss.mixin;

import cypphi.amiss.AmissClient;
import cypphi.amiss.gui.screen.MainMenuScreen;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.TitleScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftClient.class)
public abstract class MinecraftClientMixin {
    @ModifyArg(method = "updateWindowTitle", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/util/Window;setTitle(Ljava/lang/String;)V"))
    private String setTitle(String s) {
        return AmissClient.name + " " + AmissClient.version;
    }

    @Inject(method = "setScreen", at = @At("HEAD"), cancellable = true)
    public void openScreen(Screen screen, CallbackInfo ci) {
        if (screen instanceof TitleScreen) {
            ci.cancel();
            AmissClient.mc.setScreen(new MainMenuScreen());
        }
    }
}
