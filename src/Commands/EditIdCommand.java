package Commands;

import Utils.HtmlContext;
import Utils.HtmlElement;

public class EditIdCommand implements Command{
    private final String oldId;
    private final String newId;
    private HtmlElement element;

    public EditIdCommand(String oldId, String newId) {
        this.oldId = oldId;
        this.newId = newId;
    }

    @Override
    public void execute() {
        if (!HtmlContext.getInstance().isIdUnique(newId)) {
            throw new IllegalArgumentException("New ID already exists: " + newId);
        }

        element = HtmlContext.getInstance().getElementById(oldId);
        if (element == null) {
            throw new IllegalArgumentException("Element not found: " + oldId);
        }
        element.setId(newId);
        HtmlContext.getInstance().updateElementId(element, oldId, newId);
    }
}
