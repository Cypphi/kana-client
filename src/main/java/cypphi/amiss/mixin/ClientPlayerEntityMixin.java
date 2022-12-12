package cypphi.amiss.mixin;


import net.minecraft.client.network.ClientPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import me.lto.amiss.modules.Module;
import me.lto.amiss.modules.ModuleCategory;
import me.lto.amiss.modules.ModuleManager;

@Mixin(ClientPlayerEntity.class)
public class ClientPlayerEntityMixin {

    @Inject(method = "tick", at = @At("TAIL"))
    void postTick(CallbackInfo ci) {
        for (Module module : ModuleManager.getModules()) {
            if (module.isToggled()) module.onTick();
        }
    }

}
