package Commands;

import Utils.HtmlContext;
import Utils.HtmlElement;

public class PrintTreeCommand implements Command {

    @Override
    public void execute() {
        HtmlElement root = HtmlContext.getInstance().getHtmlContent();
        printTree(root, "", true, true); // 第四个参数表示是否是根节点
    }

    private void printTree(HtmlElement element, String prefix, boolean isLast, boolean isRoot) {
        if (element == null) return;

        // 判断是否是根节点，根节点无前缀
        if (isRoot) {
            System.out.println(element.getTagName() + (element.getId() != null ? "#" + element.getId() : ""));
        } else {
            // 判断是否是最后一个子节点
            String connector = isLast ? "└── " : "├── ";

            // 获取标签和 ID 信息
            String id = element.getId() != null ? "#" + element.getId() : "";
            System.out.println(prefix + connector + element.getTagName() + id);
        }

        // 更新前缀，用于子元素的缩进
        String newPrefix = isRoot ? "" : (prefix + (isLast ? "    " : "│   "));

        // 如果有内容，输出内容为子节点
        String content = element.getTextContent();
        if (content != null && !content.trim().isEmpty()) {
            System.out.println(newPrefix + "└── " + content.trim());
        }

        // 递归打印子元素
        int childCount = element.getChildren().size();
        for (int i = 0; i < childCount; i++) {
            printTree(element.getChildren().get(i), newPrefix, i == childCount - 1, false);
        }
    }
}