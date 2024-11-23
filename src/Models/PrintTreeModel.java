package Models;

import Commands.Command;
import Commands.PrintTreeCommand;

public class PrintTreeModel implements Command {
    public void execute() {
        PrintTreeCommand command = new PrintTreeCommand();
        command.execute();
    }


}