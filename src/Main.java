import java.util.Scanner;

public class Main {
    private static boolean isInitialized = false; // 追踪是否已有HTML模板,init or read from file

    public static void main(String[] args) {
        HtmlEditor editor;
        Scanner scanner = new Scanner(System.in);
        String command;

        System.out.println("Welcome to the HTML Editor!");
        System.out.println("Commands: 'init', 'insert tagName idValue insertLocation [textContent]', 'append tagName idValue parentElement [textContent]', 'edit-id oldId newId', 'edit-text element [newTextContent]'" +
                "'delete element', 'print-indent [indent]', 'print-tree', 'spell-check', 'read filepath', 'save filepath', 'undo', 'redo', 'exit");
        System.out.println("Use 'init' to get an empty template or 'read filepath' to get an existing one");

        while (true) {
            System.out.print("> ");
            command = scanner.nextLine();

            String[] parts = command.split(" ", 2);


            switch (parts[0]) {
                case "init":
                    editor = new HtmlEditor();
                    isInitialized = true;
                    System.out.println("HTML template initialized.");
                    break;
                case "insert":
                    if(!isInitialized) {
                        System.out.println("HTML template not initialized!\nUse 'init' to init a empty template, or 'read filepath' to read from a existing file");
                        break;
                    }
                case "append":
                    if(!isInitialized) {
                        System.out.println("HTML template not initialized!\nUse 'init' to init a empty template, or 'read filepath' to read from a existing file");
                        break;
                    }
                case "edit-text":
                    if(!isInitialized) {
                        System.out.println("HTML template not initialized!\nUse 'init' to init a empty template, or 'read filepath' to read from a existing file");
                        break;
                    }
                case "delete":
                    if(!isInitialized) {
                        System.out.println("HTML template not initialized!\nUse 'init' to init a empty template, or 'read filepath' to read from a existing file");
                        break;
                    }
                case "print-indent":
                    if(!isInitialized) {
                        System.out.println("HTML template not initialized!\nUse 'init' to init a empty template, or 'read filepath' to read from a existing file");
                        break;
                    }
                case "print-tree":
                    if(!isInitialized) {
                        System.out.println("HTML template not initialized!\nUse 'init' to init a empty template, or 'read filepath' to read from a existing file");
                        break;
                    }
                case "read":
                    break;
                case "save":
                    if(!isInitialized) {
                        System.out.println("HTML template not initialized!\nUse 'init' to init a empty template, or 'read filepath' to read from a existing file");
                        break;
                    }
                case "undo":
                    break;
                case "redo":
                    break;
                case "exit":
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Unknown command.The supported commands are:\n");
            }
        }
    }
}
