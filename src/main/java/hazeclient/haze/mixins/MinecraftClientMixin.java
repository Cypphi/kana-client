package hazeclient.haze.mixins;

import hazeclient.haze.HazeClient;
import net.minecraft.client.MinecraftClient;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(value = MinecraftClient.class, priority = 1001)
public abstract class MinecraftClientMixin {

    @ModifyArg(method = "updateWindowTitle", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/util/Window;setTitle(Ljava/lang/String;)V"))
    private String setTitle(String s) {
        String customWindowTitle = HazeClient.name + " " + HazeClient.version + " b" + HazeClient.BUILDID;

        return customWindowTitle;
    }
}
