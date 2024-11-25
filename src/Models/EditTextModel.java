package Models;

import Commands.Command;
import Commands.EditTextCommand;

public class EditTextModel implements Command {
    private String[] commandArgs;

    public EditTextModel(String[] commandArgs) {
        this.commandArgs = commandArgs;
    }

    @Override
    public void execute() {
        if (commandArgs.length == 1){
            EditTextCommand editTextCommand = new EditTextCommand(commandArgs[0], null);
            editTextCommand.execute();
        }
        else if (commandArgs.length == 2) {
            EditTextCommand editTextCommand = new EditTextCommand(commandArgs[0], commandArgs[1]);
            editTextCommand.execute();
        }
        else {
            throw new IllegalArgumentException("The number of input parameters is wrong!");
        }
    }
}
