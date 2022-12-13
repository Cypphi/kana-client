package cypphi.astel.feature.command.impl;

<<<<<<< HEAD:src/main/java/cypphi/amiss/feature/command/impl/Toggle.java
import cypphi.amiss.AmissClient;
import cypphi.amiss.feature.command.Command;
import cypphi.amiss.feature.module.Module;
import cypphi.amiss.feature.module.ModuleManager;
=======
import cypphi.astel.AstelClient;
import cypphi.astel.feature.command.Command;
import cypphi.astel.feature.module.ModuleManager;
import cypphi.astel.feature.module.Module;
>>>>>>> e5e48951a161c0a4d93710f533cca640511c1a13:src/main/java/cypphi/astel/feature/command/impl/Toggle.java
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
