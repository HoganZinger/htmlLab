package Commands;

import Utils.HtmlContext;
import Utils.HtmlElement;

public class AppendCommand implements Command {

    private final String tagName;
    private final String idValue;
    private final String parentId;
    private final String textContent;
    private HtmlElement newElement;
    private HtmlElement parentElement;
    private int insertIndex;
    public AppendCommand(String tagName, String idValue, String parentId, String textContent) {
        this.tagName = tagName;
        this.idValue = idValue;
        this.parentId = parentId;
        this.textContent = textContent;
    }
    @Override
    public void execute() {
        if (!HtmlContext.getInstance().isIdUnique(idValue)) {
            throw new IllegalArgumentException("ID already exists: " + idValue);
        }

        parentElement = HtmlContext.getInstance().getElementById(parentId);
        if (parentElement == null) {
            throw new IllegalArgumentException("Parent element not found: " + parentId);
        }

        newElement = new HtmlElement(tagName, idValue, null);
        if (textContent != null) {
            newElement.setText(textContent);
        }

        parentElement.addChild(newElement);
        HtmlContext.getInstance().addToIdMap(newElement);
    }
}
