package Commands;

import Utils.HtmlElement;
import Utils.HtmlContext;

public class InsertCommand implements Command {


    private final String tagName;
    private final String idValue;
    private final String insertLocationId;
    private final String textContent;
    private HtmlElement newElement;
    private HtmlElement targetElement;
    private HtmlElement parentElement;
    private int insertIndex;

    public InsertCommand(String tagName, String idValue, String insertLocationId, String textContent) {
        this.tagName = tagName;
        this.idValue = idValue;
        this.insertLocationId = insertLocationId;
        this.textContent = textContent;
    }
    @Override
    public void execute() {
        if (!HtmlContext.getInstance().isIdUnique(idValue)) {
            throw new IllegalArgumentException("ID already exists: " + idValue);
        }

        targetElement = HtmlContext.getInstance().getElementById(insertLocationId);
        if (targetElement == null) {
            throw new IllegalArgumentException("Target element not found: " + insertLocationId);
        }

        parentElement = targetElement.getParent();
        if (parentElement == null) {
            throw new IllegalArgumentException("Cannot insert before root element");
        }
        newElement = new HtmlElement(tagName, idValue, null);
        if (textContent != null) {
            newElement.setText(textContent);
        }

        insertIndex = parentElement.getChildren().indexOf(targetElement);
        parentElement.getChildren().add(insertIndex, newElement);
        newElement.setParent(parentElement);
        HtmlContext.getInstance().addToIdMap(newElement);
    }
}