package Commands;

import Utils.HtmlContext;
import Utils.HtmlElement;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class SaveCommand implements Command {

    @Override
    pubilc void execute(String[] args) {
        if(args.length < 1) {
            System.out.println("Empty path!");
            return;
        }

        String fileName = args[0];
        String htmlcontent = HtmlContext.getInstance().getHtmlContent();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(htmlcontent);
            System.out.println("Successfully saved:" + fileName);
        }catch (IOException e) {
            System.out.println("error:" + e.getMessage());
        }
    }
}
