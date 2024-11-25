import Commands.*;

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
            case "insert":
                return new InsertModel(commandArgs);
            case "append":
                return new AppendModel(commandArgs);
            case "edit-id":
                return new EditIdModel(commandArgs);
            case "edit-text":
                return new EditTextModel(commandArgs);
            case "delete":
                return new DeleteModel(commandArgs);

            default:
                return null;
        }
    }



}

