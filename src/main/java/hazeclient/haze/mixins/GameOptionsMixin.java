package hazeclient.haze.mixins;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.GameOptions;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.io.File;

@Mixin(GameOptions.class)
public class GameOptionsMixin {

    // This is staying, anyone who unironically uses auto jump should slit their throat.
    @Shadow public boolean autoJump;

    @Inject(method = "<init>", at = @At("RETURN"))
    private void disableAutoJump(MinecraftClient client, File optionsFile, CallbackInfo ci) {
        this.autoJump = false;
    }
}
