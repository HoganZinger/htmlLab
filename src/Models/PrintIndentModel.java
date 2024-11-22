package Models;

import Commands.Command;
import Commands.PrintIndentCommand;

public class PrintIndentModel implements Command {
    public void execute() {
        PrintIndentCommand command = new PrintIndentCommand();
        command.execute();
    }


}
