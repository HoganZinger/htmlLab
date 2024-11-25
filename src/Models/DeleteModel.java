package Models;

import Commands.Command;
import Commands.DeleteCommand;
import Commands.EditIdCommand;

public class DeleteModel implements Command {
    private String[] commandArgs;

    public DeleteModel(String[] commandArgs) {
        this.commandArgs = commandArgs;
    }

    @Override
    public void execute() {
        if (commandArgs.length == 1){
            DeleteCommand deleteCommand = new DeleteCommand(commandArgs[0]);
            deleteCommand.execute();
        }
        else {
            throw new IllegalArgumentException("The number of input parameters is wrong!");
        }
    }
}
