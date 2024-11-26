package Models;

import Commands.Command;
import Commands.EditIdCommand;

public class EditIdModel implements Command {
    private String[] commandArgs;

    public EditIdModel(String[] commandArgs) {
        this.commandArgs = commandArgs;
    }

    @Override
    public void execute() {
        if (commandArgs.length == 2){
            EditIdCommand editIdCommand = new EditIdCommand(commandArgs[0], commandArgs[1]);
            editIdCommand.execute();
        }
        else {
            throw new IllegalArgumentException("The number of input parameters is wrong!");
        }
    }
}
