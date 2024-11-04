package Elements;

import java.util.ArrayList;
import java.util.List;

public class HtmlElement {
    private String tagName;
    private String id;
    private String textContent;
    private List<HtmlElement> children;

    public HtmlElement(String tagName, String id, String textContent) {
        this.tagName = tagName;
        this.id = id;
        this.textContent = textContent;
        this.children = new ArrayList<>();
    }

    public void addChild(HtmlElement child) {
        children.add(child);
    }

    public void removeChild(HtmlElement child) {
        children.remove(child);
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setText(String text) {
        this.textContent = text;
    }

    public String toHtml() {
        StringBuilder html = new StringBuilder();
        html.append("<").append(tagName);
        if (id != null && !id.isEmpty()) {
            html.append(" id=\"").append(id).append("\"");
        }
        html.append(">");
        if (textContent != null) {
            html.append(textContent);
        }
        for (HtmlElement child : children) {
            html.append(child.toHtml());
        }
        html.append("</").append(tagName).append(">");
        return html.toString();
    }

    @Override
    public String toString() {
        return toHtml();
    }
}
