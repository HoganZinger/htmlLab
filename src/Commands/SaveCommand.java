package Commands;

import Utils.HtmlContext;
import Utils.HtmlElement;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class SaveCommand implements Command {
    private String[] filepath;

    public SaveCommand(String[] filepath) {
        this.filepath = filepath;
    }

    @Override
    public void execute() {

        if(filepath.length < 1) {
            System.out.println("Empty path!");
        }

        String fileName = filepath[0];
        String htmlcontent = HtmlContext.getInstance().getHtmlContent().getTextContent();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(htmlcontent);
            System.out.println("Successfully saved:" + fileName);
        }catch (IOException e) {
            System.out.println("error:" + e.getMessage());
        }
    }
}
