package cypphi.astel.feature.command.impl;

import cypphi.astel.AstelClient;
import cypphi.astel.feature.command.Command;
import net.minecraft.text.Text;

import java.util.Arrays;

public class Say extends Command {

    public Say() {
        super("Say", "Says what you want", "say", "echo");
    }

    @Override
    public void execute(String[] args) {
        assert AstelClient.mc.player != null;
        AstelClient.mc.player.sendMessage(Text.of(Arrays.toString(args)), false);
    }
}
