package Commands;

import Utils.HtmlContext;
import Utils.HtmlElement;

public class PrintIndentCommand implements Command {

    @Override
    public void execute() {
        execute(2);   // 默认缩进2
    }

    public void execute(int indent) {
        HtmlElement root = HtmlContext.getInstance().getHtmlContent();
        printIndent(root, 0, indent);
    }

    private void printIndent(HtmlElement element, int level, int indent) {
        if (element == null) return;

        // 打印缩进
        for (int i = 0; i < level * indent; i++) {
            System.out.print(" ");
        }

        // 获取ID属性
        String id = element.getId() != null ? " id=\"" + element.getId() + "\"" : "";

        // 判断是否有子元素
        if (element.getChildren().isEmpty()) {
            String content = element.getTextContent();
            content = content == null ? "" : content;
            System.out.println("<" + element.getTagName() + id + ">" + content + "</" + element.getTagName() + ">");
        }
        else {
            // 打印起始标签
            System.out.println("<" + element.getTagName() + id + ">");

            // 递归打印子元素
            for (HtmlElement child : element.getChildren()) {
                printIndent(child, level + 1, indent);
            }

            // 打印结束标签
            for (int i = 0; i < level * indent; i++) {
                System.out.print(" ");
            }
            System.out.println("</" + element.getTagName() + ">");
        }
    }
}