package hazeclient.haze.mixins;

import hazeclient.haze.HazeClient;
import hazeclient.haze.gui.screen.MainMenu;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.TitleScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = MinecraftClient.class, priority = 1001)
public abstract class MinecraftClientMixin {
    private final MinecraftClient mc = (MinecraftClient) (Object) this;

    @ModifyArg(method = "updateWindowTitle", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/util/Window;setTitle(Ljava/lang/String;)V"))
    private String setTitle(String s) {
        return HazeClient.name + " " + HazeClient.version + " b" + HazeClient.buildId;
    }

    @Inject(method = "setScreen", at = @At("HEAD"), cancellable = true)
    public void openScreen(Screen screen, CallbackInfo ci) {
        // yup
        if(screen instanceof TitleScreen) {
            ci.cancel();
            mc.setScreen(new MainMenu());
        }
    }
}
