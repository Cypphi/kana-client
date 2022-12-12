package me.lto.amiss.commands.cmds;

import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;

import java.util.Arrays;

import me.lto.amiss.commands.Command;

public class Say extends Command {

    public Say() {
        super("Say", "Says what you want", "say", "echo");
    }

    @Override
    public void execute(String[] args) {
        assert MinecraftClient.getInstance().player != null;
        MinecraftClient.getInstance().player.sendMessage(Text.of(Arrays.toString(args)), false);
    }
}
