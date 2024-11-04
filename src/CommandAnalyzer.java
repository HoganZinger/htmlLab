public class CommandAnalyzer {
    private static boolean isInitialized = false; // 追踪是否已有HTML模板,init or read from file

    public String createCommand(String input) {
        return switch (input) {
            case "init", "read" -> {
                isInitialized = true;
                yield input;
            }
            case "insert", "append", "edit-text", "delete", "print-indent", "print-tree", "save", "undo", "redo" -> {
                if (!isInitialized) {
                    yield "uninitialized";
                }
                yield input;
            }
            default -> "unknown";
        };
    }
}
