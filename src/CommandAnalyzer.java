import Utils.HtmlContext;

import java.util.Objects;

public class CommandAnalyzer {
    private static boolean isInitialized = false; // 追踪是否已有HTML模板,init or read from file

    public String createCommand(String input) {
        String HtmlId = HtmlContext.getInstance().getHtmlContent().getId();

        return switch (input) {
            case "init", "read" -> {
                isInitialized = true;
                yield input;
            }
            case "insert", "append", "edit-text", "delete", "print-indent", "print-tree", "save", "undo", "redo" -> {
                if (Objects.equals(HtmlId, "empty")){
                    isInitialized = false;
                }
                if (!isInitialized) {
                    yield "uninitialized";
                }
                yield input;
            }
            default -> "unknown";
        };
    }
}
