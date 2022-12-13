package cypphi.astel.mixin;

import cypphi.astel.feature.command.CommandHandler;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import net.minecraft.client.gui.screen.ChatScreen;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Arrays;

import static cypphi.astel.AstelClient.mc;

@Mixin(ChatScreen.class)
public class ChatScreenMixin {

    @Redirect(method = "keyPressed", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/screen/ChatScreen;sendMessage(Ljava/lang/String;Z)Z"))
    public boolean intercept(ChatScreen instance, String message, boolean addToHistory) {
        if (message.startsWith(".")) {
            String t = message.substring(".".length());
            if (t.isEmpty()) return true;
            String[] ms = t.trim().split(" +");
            String c = ms[0];
            String[] args = Arrays.copyOfRange(ms, 1, ms.length);
            new CommandHandler().executeCommand(c, args);
        }
        else {
            mc.player.sendMessage(Text.of(message));
        }
        return true;
    }
}
