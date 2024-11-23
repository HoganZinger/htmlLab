package Commands;

import Utils.*;
import java.util.Objects;

public class UndoCommand implements Command {
    @Override
    public void execute() {
        HtmlHistory.getInstance().undo();
    }
}
