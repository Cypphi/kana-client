package cypphi.astel.mixin;

import cypphi.astel.feature.module.Module;
import cypphi.astel.feature.module.ModuleManager;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.util.math.MatrixStack;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GameRenderer.class)
public abstract class GameRendererMixin {
    @Inject(at = @At(value = "FIELD", target = "Lnet/minecraft/client/render/GameRenderer;renderHand:Z", opcode = Opcodes.GETFIELD, ordinal = 0), method = "renderWorld")
    void onRender(float tickDelta, long limitTime, MatrixStack matrices, CallbackInfo ci) {
        for (Module module : ModuleManager.getModules()) {
            if (module.isToggled()) {
                module.onWorldRender(matrices);
            }
        }
    }
}
