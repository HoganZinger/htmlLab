package Models;
import Commands.Command;
import Commands.InsertCommand;


public class InsertModel implements Command{
    private String[] commandArgs;

    public InsertModel(String[] commandArgs) {
        this.commandArgs = commandArgs;
    }

    @Override
    public void execute() {
        if (commandArgs.length == 3){
            InsertCommand insertCommand = new InsertCommand(commandArgs[0], commandArgs[1], commandArgs[2],null);
            insertCommand.execute();
        }
        else if (commandArgs.length == 4) {
            InsertCommand insertCommand = new InsertCommand(commandArgs[0], commandArgs[1], commandArgs[2], commandArgs[3]);
            insertCommand.execute();
        }
        else {
            throw new IllegalArgumentException("The number of input parameters is wrong!");
        }
    }

}
