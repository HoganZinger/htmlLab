package Models;

import Commands.Command;
import Commands.SaveCommand;

public class SaveModel implements Command {
    private String[] commandArgs;

    public SaveModel(String[] commandArgs) {
        this.commandArgs = commandArgs;
    }

    public void execute() {
        SaveCommand command = new SaveCommand();
        String filepath = commandArgs[0];
        command.execute(filepath);
    }
}
