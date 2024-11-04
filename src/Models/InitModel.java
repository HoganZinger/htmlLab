package Models;
import Commands.Command;
import Commands.InitCommand;

public class InitModel implements Command{
    public void execute() {
        InitCommand command = new InitCommand();
        command.execute();
    }


}
