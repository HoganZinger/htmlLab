package Commands;

import Utils.*;

public class TestCommand implements Command {
    private String testId;

    public TestCommand(String[] args) {
        this.testId = args.length > 0 ? args[0] : "test";
    }

    @Override
    public void execute() {
        HtmlContext htmlContext = HtmlContext.getInstance();
        HtmlElement currentContent = htmlContext.getHtmlContent();

        // 创建一个新的测试元素
        HtmlElement testElement = new HtmlElement("div", testId, "Test Content " + testId);

        // 如果是空状态，先初始化基本结构
        if (currentContent.getId().equals("empty")) {
            HtmlElement html = new HtmlElement("html", "html", null);
            HtmlElement body = new HtmlElement("body", "body", null);
            html.addChild(body);
            body.addChild(testElement);
            htmlContext.setHtmlContent(html);
        } else {
            // 找到body元素并添加测试元素
            HtmlElement body = currentContent.getChildren().get(1); // body是第二个子元素
            body.addChild(testElement);
        }

        System.out.println("Added test element: " + testElement.toHtml());
    }
}