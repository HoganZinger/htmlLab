package Commands;

import Utils.*;
import java.util.Objects;

public class RedoCommand implements Command {
    @Override
    public void execute() {
        HtmlHistory.getInstance().redo();
    }
}
