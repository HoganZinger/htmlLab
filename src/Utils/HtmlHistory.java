package Utils;

import java.util.Stack;

public class HtmlHistory {
    private static HtmlHistory instance;
    private Stack<HtmlElement> undoStack;
    private Stack<HtmlElement> redoStack;

    private HtmlHistory() {
        undoStack = new Stack<>();
        redoStack = new Stack<>();
    }

    public static HtmlHistory getInstance() {
        if (instance == null) {
            instance = new HtmlHistory();
        }
        return instance;
    }

    public void saveState() {
        HtmlElement currentState = deepClone(HtmlContext.getInstance().getHtmlContent());
        undoStack.push(currentState);
        redoStack.clear(); // 新状态保存后清空重做栈
    }

    public void undo() {
        if (undoStack.isEmpty()) {
            System.out.println("Nothing to undo");
            return;
        }

        HtmlElement currentState = HtmlContext.getInstance().getHtmlContent();
        redoStack.push(deepClone(currentState));

        HtmlElement previousState = undoStack.pop();
        HtmlContext.getInstance().setHtmlContent(previousState);
    }

    public void redo() {
        if (redoStack.isEmpty()) {
            System.out.println("Nothing to redo");
            return;
        }

        HtmlElement currentState = HtmlContext.getInstance().getHtmlContent();
        undoStack.push(deepClone(currentState));

        HtmlElement nextState = redoStack.pop();
        HtmlContext.getInstance().setHtmlContent(nextState);
    }

    private HtmlElement deepClone(HtmlElement element) {
        HtmlElement clone = new HtmlElement(element.getTagName(), element.getId(), element.getTextContent());
        for (HtmlElement child : element.getChildren()) {
            clone.addChild(deepClone(child));
        }
        return clone;
    }
}
