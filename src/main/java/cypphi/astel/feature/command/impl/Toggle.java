package cypphi.astel.feature.command.impl;

import cypphi.astel.AstelClient;
import cypphi.astel.feature.command.Command;
import cypphi.astel.feature.module.ModuleManager;
import cypphi.astel.feature.module.Module;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;

public class Toggle extends Command {

    public Toggle() {
        super("Toggle", "Enables or disables modules.", "toggle", "t");
    }

    @Override
    public void execute(String[] args) {
        if (args.length == 0) {
            MinecraftClient.getInstance().player.sendMessage(Text.of(String.format("[%s] No module name!", AstelClient.name)), false);
            return;
        }
        Module module = ModuleManager.getModule(args[1]);
        if (module != null) {
            module.toggle();
        }

    }
}
