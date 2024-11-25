package Commands;

import Utils.HtmlContext;
import Utils.HtmlElement;

public class DeleteCommand implements Command{
    private final String elementId;
    private HtmlElement element;
    private HtmlElement parentElement;
    private int deleteIndex;

    public DeleteCommand(String elementId) {
        this.elementId = elementId;
    }

    @Override
    public void execute() {
        element = HtmlContext.getInstance().getElementById(elementId);
        if (element == null) {
            throw new IllegalArgumentException("Element not found: " + elementId);
        }

        if (element == HtmlContext.getInstance().getHtmlContent()) {
            throw new IllegalArgumentException("Cannot delete root element");
        }

        parentElement = element.getParent();
        deleteIndex = parentElement.getChildren().indexOf(element);
        parentElement.removeChild(element);
        HtmlContext.getInstance().removeFromIdMap(element);
    }
}
