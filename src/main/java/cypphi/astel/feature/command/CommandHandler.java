package cypphi.astel.feature.command;

import cypphi.astel.AstelClient;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;

public class CommandHandler {
    public void executeCommand(String command, String[] args) {
        Command tr = new CommandManager().getByAlias(command);
        if (tr == null) {
            MinecraftClient.getInstance().player.sendMessage(Text.of(String.format("[%s] Invalid Command.", AstelClient.name)), false);
        }
        else {
            tr.execute(args);
        }
    }
}
