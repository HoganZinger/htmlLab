package Models;

import Commands.Command;
import Commands.PrintIndentCommand;

public class PrintIndentModel implements Command {
    private String[] commandArgs;

    public PrintIndentModel(String[] commandArgs) {
        this.commandArgs = commandArgs;
    }

    public void execute() {
        PrintIndentCommand command = new PrintIndentCommand();
        if (commandArgs.length > 0) {
            try {
                int indent = Integer.parseInt(commandArgs[0]);
                command.execute(indent);
            } catch (NumberFormatException e) {
                System.out.println("Invalid indent value, using default.");
                command.execute();
            }
        } else {
            command.execute();
        }
    }
}
