package cypphi.amiss.feature.command.impl;

import cypphi.amiss.feature.command.Command;
import cypphi.amiss.feature.module.ModuleManager;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;

public class Toggle extends Command {

    public Toggle() {
        super("Toggle", "Enables or disables modules.", "toggle", "t");
    }

    @Override
    public void execute(String[] args) {
        if (args.length == 0) {
            MinecraftClient.getInstance().player.sendMessage(Text.of(String.format("[%s] No module name!", Amiss.name)), false);
            return;
        }
        Module module = ModuleManager.getModule(args[1]);
        if (module != null) {
            module.toggle();
        }

    }
}
