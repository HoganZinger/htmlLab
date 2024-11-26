package Models;

import Commands.Command;
import Commands.SaveCommand;

public class SaveModel implements Command {
    private String[] commandArgs;

    public SaveModel(String[] commandArgs) {
        this.commandArgs = commandArgs;
    }

    public void execute() {
        SaveCommand command = new SaveCommand(commandArgs);
        command.execute();
    }
}
