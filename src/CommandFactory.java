import Commands.Command;
import Commands.RedoCommand;
import Commands.TestCommand;
import Commands.UndoCommand;
<<<<<<< HEAD
import Commands.ReadCommand;
import Commands.SaveCommand;
=======
import Commands.PrintTreeCommand;
>>>>>>> cc4bcffff0979496213e6c9c755695b4ff32c2ef
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
            case "print-tree":
                return new PrintTreeModel();
            case "print-indent":
                return new PrintIndentModel(commandArgs);
            default:
                return null;
        }
    }



}

