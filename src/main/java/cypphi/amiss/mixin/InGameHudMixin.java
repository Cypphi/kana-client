package cypphi.amiss.mixin;

import cypphi.amiss.feature.command.CommandHandler;
import cypphi.amiss.feature.module.ModuleManager;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.network.message.MessageType;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import cypphi.amiss.feature.module.Module;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Arrays;
import java.util.UUID;

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
