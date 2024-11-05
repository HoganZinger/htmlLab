import Commands.Command;
import Models.*;

public class CommandFactory {
    public static Command createCommand(String commandType, String[] commandArgs){
        switch(commandType){
            case "init":
                return new InitModel();
            default:
                return null;
        }
    }



}

