package me.lto.amiss.commands.cmds;

import me.lto.amiss.Amiss;
import me.lto.amiss.commands.Command;
import me.lto.amiss.modules.Module;
import me.lto.amiss.modules.ModuleManager;
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
