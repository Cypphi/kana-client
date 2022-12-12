package cypphi.amiss.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.Window;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import cypphi.amiss.AmissClient;

@Mixin(MinecraftClient.class)
public class MinecraftClientMixin {

	@Inject(method = "tick", at = @At("HEAD"))
	public void onTick(CallbackInfo ci) {

	}

	@Shadow @Final private Window window;

	@Inject(method = "updateWindowTitle", at = @At("HEAD"))
	private void updateWindowTitle(CallbackInfo ci) {
		this.window.setTitle(AmissClient.name + " b" + AmissClient.version);
	}


}
