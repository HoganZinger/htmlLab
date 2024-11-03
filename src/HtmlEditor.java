import java.util.Scanner;
import java.io.*;

public class HtmlEditor {
    private HtmlElement root;

    public HtmlEditor() {
        initializeEditor();
    }

    private void initializeEditor() {
        // 创建 HTML 的基本结构
        HtmlElement html = new HtmlElement("html", null, null);
        HtmlElement head = new HtmlElement("head", null, null);
        HtmlElement title = new HtmlElement("title", null, null);
        HtmlElement body = new HtmlElement("body", null, null);

        // 将标题和主体添加到 head 和 body 中
        head.addChild(title);
        html.addChild(head);
        html.addChild(body);

        // 将整个结构赋值给 root
        root = html;
    }

    public String getHtml() {
        return root.toHtml();
    }

    public static void main(String[] args) {
        HtmlEditor editor = new HtmlEditor();
        System.out.println(editor.getHtml());
    }

}
