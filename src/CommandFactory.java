import Commands.Command;
import Commands.RedoCommand;
import Commands.TestCommand;
import Commands.UndoCommand;
import Commands.ReadCommand;
import Commands.SaveCommand;
import Models.*;
import Utils.StateSavingCommandDecorator;

public class CommandFactory {
    public static Command createCommand(String commandType, String[] commandArgs){
        switch(commandType){
            case "init":
                return new InitModel();
            case "undo":
                return new UndoCommand(); 
            case "redo":
                return new RedoCommand();
            case "read":
                return new ReadCommand(commandArgs);
            case "save":
                return new SaveCommand(commandArgs);
            case "test":
                return new StateSavingCommandDecorator(new TestCommand(commandArgs));
            default:
                return null;
        }
    }



}

