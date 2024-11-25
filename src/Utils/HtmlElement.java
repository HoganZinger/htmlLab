package Utils;

import java.util.ArrayList;
import java.util.List;

public class HtmlElement {
    private String tagName;
    private String id;
    private String textContent;
    private List<HtmlElement> children;

    private HtmlElement parent;

    public HtmlElement(String tagName, String id, String textContent) {
        this.tagName = tagName;
        this.id = id;
        this.textContent = textContent;
        this.children = new ArrayList<>();
    }

    // 一些必要的getter方法
    public String getTagName() {
        return tagName;
    }

    public String getTextContent() {
        return textContent;
    }

    public List<HtmlElement> getChildren() {
        return children;
    }

    public void setParent(HtmlElement parent) { this.parent = parent; }

    public HtmlElement getParent() { return parent; }

    public void addChild(HtmlElement child) {
        children.add(child);
        child.setParent(this);
    }

    public void removeChild(HtmlElement child) {
        children.remove(child);
        child.setParent(null);
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
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
