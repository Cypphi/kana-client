package cypphi.amiss.mixin;

import cypphi.amiss.feature.module.ModuleManager;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.util.math.MatrixStack;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;

@Mixin(GameRenderer.class)
public abstract class GameRendererMixin {
    @Inject(at = @At(value = "FIELD", target = "Lnet/minecraft/client/render/GameRenderer;renderHand:Z", opcode = Opcodes.GETFIELD, ordinal = 0), method = "renderWorld")
    void onRender(MatrixStack matrixstack) {
        for (Module module : ModuleManager.getModules()) {
            if (module.isEnabled()) {
                module.onWorldRender(ms);
            }
        }
    }
}
