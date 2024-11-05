package Commands;

import Utils.*;
import java.util.Objects;

public class InitCommand implements Command {

    @Override
    public void execute() {
        HtmlContext htmlContext = HtmlContext.getInstance();
        if (Objects.equals(htmlContext.getHtmlContent().getId(), "empty")){
            htmlContext.setHtmlContent(initializeEditor());
            System.out.println("initialized html root");
            System.out.println(htmlContext.getHtmlContent().toString());
        }
        else{
            System.out.println("found existing html, no need to initialize");
        }
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
