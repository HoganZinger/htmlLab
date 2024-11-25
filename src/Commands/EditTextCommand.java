package Commands;

import Utils.HtmlContext;
import Utils.HtmlElement;

public class EditTextCommand implements Command{
    private final String elementId;
    private final String newText;
    private HtmlElement element;
    private String oldText;

    public EditTextCommand(String elementId, String newText) {
        this.elementId = elementId;
        this.newText = newText;
    }

    @Override
    public void execute() {
        element = HtmlContext.getInstance().getElementById(elementId);
        if (element == null) {
            throw new IllegalArgumentException("Element not found: " + elementId);
        }

        oldText = element.getTextContent();
        element.setText(newText);
    }

}
