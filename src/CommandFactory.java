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
                return new ReadModel(commandArgs);
            case "save":
                return new SaveModel(commandArgs);
            case "test":
                return new StateSavingCommandDecorator(new TestCommand(commandArgs));
            case "print-tree":
                return new PrintTreeModel();
            case "print-indent":
                return new PrintIndentModel(commandArgs);
            case "insert":
                return new StateSavingCommandDecorator(new InsertModel(commandArgs));
            case "append":
                return new StateSavingCommandDecorator(new AppendModel(commandArgs));
            case "edit-id":
                return new StateSavingCommandDecorator(new EditIdModel(commandArgs));
            case "edit-text":
                return new StateSavingCommandDecorator(new EditTextModel(commandArgs));
            case "delete":
                return new StateSavingCommandDecorator(new DeleteModel(commandArgs));

            default:
                return null;
        }
    }



}

