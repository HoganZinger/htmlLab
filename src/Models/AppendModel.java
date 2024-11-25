package Models;

import Commands.AppendCommand;
import Commands.Command;


public class AppendModel implements Command {
    private String[] commandArgs;

    public AppendModel(String[] commandArgs) {
        this.commandArgs = commandArgs;
    }

    @Override
    public void execute() {
        if (commandArgs.length == 3){
            AppendCommand appendCommand = new AppendCommand(commandArgs[0], commandArgs[1], commandArgs[2],null);
            appendCommand.execute();
        }
        else if (commandArgs.length == 4) {
            AppendCommand appendCommand = new AppendCommand(commandArgs[0], commandArgs[1], commandArgs[2],commandArgs[3]);
            appendCommand.execute();
        }
        else {
            throw new IllegalArgumentException("The number of input parameters is wrong!");
        }
    }
}
