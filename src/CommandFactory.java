import Commands.Command;
import Commands.PrintTreeCommand;
import Models.*;

public class CommandFactory {
    public static Command createCommand(String commandType, String[] commandArgs){
        switch(commandType){
            case "init":
                return new InitModel();
            case "print-tree":
                return new PrintTreeModel();
            case "print-indent":
                return new PrintIndentModel();
            default:
                return null;
        }
    }



}

