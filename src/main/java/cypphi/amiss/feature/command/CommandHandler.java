package me.lto.amiss.commands;

import me.lto.amiss.Amiss;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

public class CommandHandler {
    public void executeCommand(String command, String[] args) {
        Command tr = new CommandManager().getByAlias(command);
        if (tr == null) {
            MinecraftClient.getInstance().player.sendMessage(Text.of(String.format("[%s] Invalid Command.", Amiss.name)), false);
        }
        else {
            tr.execute(args);
        }
    }
}
