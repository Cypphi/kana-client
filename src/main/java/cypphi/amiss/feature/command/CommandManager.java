package cypphi.amiss.feature.command;

import cypphi.amiss.feature.command.impl.Say;
import cypphi.amiss.feature.command.impl.Toggle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommandManager {

    public static List<Command> commands = new ArrayList<>();

    public static void addCommands() {
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
