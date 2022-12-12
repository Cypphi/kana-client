package cypphi.astel.mixin;

import cypphi.astel.feature.module.ModuleManager;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import cypphi.astel.feature.module.Module;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InGameHud.class)
public class InGameHudMixin {

    @Inject(method = "render", at = @At("RETURN"))
    public void render(MatrixStack matrices, float tickDelta, CallbackInfo ci) {
        for (Module module : ModuleManager.getModules()) {
            if (module.isToggled()) module.onHudRender(matrices);
        }
    }

    @Inject(method = "renderOverlay", at = @At("HEAD"), cancellable = true)
    public void noPumpkin(Identifier texture, float opacity, CallbackInfo ci) {
        // code uh
    }
}
