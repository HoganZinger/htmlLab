package Models;

import Commands.Command;
import Commands.ReadCommand;

public class ReadModel implements Command {
    private String[] commandArgs;

    public ReadModel(String[] commandArgs) {
        this.commandArgs = commandArgs;
    }
    
    public void execute() {
        ReadCommand command = new ReadCommand(commandArgs);
        command.execute();
    }
}
