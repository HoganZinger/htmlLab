package Commands;

import Elements.HtmlElement;

public class InitCommand implements Command {

    public void execute() {
        HtmlElement root = initializeEditor();
        System.out.println(root.toHtml());
    }

    private HtmlElement initializeEditor() {
        // 创建 HTML 的基本结构
        HtmlElement html = new HtmlElement("html", "html", null);
        HtmlElement head = new HtmlElement("head", "head", null);
        HtmlElement title = new HtmlElement("title", "title", null);
        HtmlElement body = new HtmlElement("body", "body", null);

        // 将标题和主体添加到 head 和 body 中
        head.addChild(title);
        html.addChild(head);
        html.addChild(body);

        return html;
    }

}
