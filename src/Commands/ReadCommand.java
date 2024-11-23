package Commands;

import Utils.*;
import Utils.HtmlContext;
import Utils.HtmlElement;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadCommand implements Command {
    
    @Override
    public void execute(String[] args) {
        if (args.length < 1) {
            System.out.println("wrong filepath");
            return;
        }

        String fileName = args[0];
        File file = new File(fileName);

        //文件名不存在
        if (!file.exists()) {
            System.out.println("The filepath doesn't exist:" + fileName);
            return;
        }

        //
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            System.out.println("error:" + e.getMessage());
            return;
        }

        //更新HTML缓冲区
        HtmlContext.getInstance().setHtmlContent(content.toString());
        System.out.println("Successfully load into buffer");
    }

    
}
