package cypphi.amiss.feature.command;

public class Command {

    public String name, description;
    public String[] aliases;

    public Command(String name, String description, String... aliases) {
        this.name = name;
        this.description = description;
        this.aliases = aliases;
    }

    public void execute(String[] args) {}
}
