import java.util.Scanner;

import Utils.AutoPrintListener;
import Utils.HtmlContext;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String command;

        System.out.println("Welcome to the HTML Editor!");
        System.out.println("Commands: \n'init', 'insert tagName idValue insertLocation [textContent]', \n'append tagName idValue parentElement [textContent]', 'edit-id oldId newId', \n'edit-text element [newTextContent]'" +
                "'delete element', \n'print-indent [indent]', 'print-tree', 'spell-check', \n'read filepath', 'save filepath', 'undo', 'redo', 'exit'\n");
        System.out.println("Use 'init' to get an empty template or 'read filepath' to get an existing one");
        CommandCaller commandCaller = new CommandCaller();
        CommandAnalyzer commandAnalyzer = new CommandAnalyzer();
        AutoPrintListener autoPrintIndent = new AutoPrintListener();

        while (true) {
            System.out.print("> ");
            command = scanner.nextLine();
            if (command.equals("exit")) {
                System.out.println("Exiting...");
                scanner.close();
                break;
            }
            if (command.equals("get-context")) {
                System.out.println(HtmlContext.getInstance().getHtmlContent().toString());
                continue;
            }

            commandCaller.executeCommand(commandAnalyzer.createCommand(command));

        }
    }
}
