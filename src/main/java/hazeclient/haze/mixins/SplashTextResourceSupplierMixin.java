package hazeclient.haze.mixins;

import net.minecraft.client.resource.SplashTextResourceSupplier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Mixin(SplashTextResourceSupplier.class)
public class SplashTextResourceSupplierMixin {
    private final Random random = new Random();

    private final List<String> hazeSplashes = getHazeSplashes();

    @Inject(method = "get", at = @At("HEAD"), cancellable = true)
    private void onApply(CallbackInfoReturnable<String> cir) {
        cir.setReturnValue(hazeSplashes.get(random.nextInt(hazeSplashes.size())));
    }

    private static List<String> getHazeSplashes() {
        return Arrays.asList(
                "§6Made with §4♥ §6by Cypphi!",
                "§4May contain spaghetti!",
                "§5I LOVE LEAN! ♥",
                "§6It's uncanny how easy it is.",
                "§9♥ §6Stay strong Ukraine! §e♥"
        );
    }

}