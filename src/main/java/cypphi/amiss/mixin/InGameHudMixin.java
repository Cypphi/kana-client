package cypphi.amiss.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.network.MessageType;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import me.lto.amiss.commands.CommandHandler;
import me.lto.amiss.commands.CommandManager;
import me.lto.amiss.modules.Module;
import me.lto.amiss.modules.ModuleManager;

import java.util.Arrays;
import java.util.UUID;

@Mixin(InGameHud.class)
public class InGameHudMixin {


    @Inject(at = @At("HEAD"), method = "addChatMessage", cancellable = true)
    public void handleMessage(MessageType type, Text message, UUID sender, CallbackInfo ci) {
        if (message.asString().startsWith(".")) {
            ci.cancel();
            String t = message.asString().substring(".".length());
            if (t.isEmpty()) return;
            String[] ms = t.trim().split(" +");
            String c = ms[0];
            String[] args = Arrays.copyOfRange(ms, 1, ms.length);
            new CommandHandler().executeCommand(c, args);
        }
    }

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
