package me.lto.amiss.commands;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import me.lto.amiss.commands.cmds.Say;
import me.lto.amiss.commands.cmds.Toggle;

public class CommandManager {

    public static List<Command> commands = new ArrayList<>();

    public void addCommands() {
        commands.add(new Toggle());
        commands.add(new Say());
    }

    public List<Command> getCommands() {return commands;}


    public Command getByAlias(String command) {
        for (Command cmd : commands) {
            if (Arrays.stream(cmd.aliases).anyMatch(s -> s.equalsIgnoreCase(command))) {
                return cmd;
            }
        }
        return null;
    }
}
