package Utils;

public class HtmlContext {
    private static HtmlContext instance;
    private HtmlElement htmlContent;

    private HtmlContext() {
        this.htmlContent = new HtmlElement(null, "empty", null);
    }

    public HtmlElement getHtmlContent() {
        return this.htmlContent;
    }

    public void setHtmlContent(HtmlElement content) {
        this.htmlContent = content;
    }

    public static HtmlContext getInstance() {
        if (instance == null) {
            instance = new HtmlContext();
        }
        return instance;
    }
}