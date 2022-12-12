package cypphi.amiss.feature.command.impl;

import cypphi.amiss.AmissClient;
import cypphi.amiss.feature.command.Command;
import net.minecraft.text.Text;

import java.util.Arrays;

public class Say extends Command {

    public Say() {
        super("Say", "Says what you want", "say", "echo");
    }

    @Override
    public void execute(String[] args) {
        assert AmissClient.mc.player != null;
        AmissClient.mc.player.sendMessage(Text.of(Arrays.toString(args)), false);
    }
}
