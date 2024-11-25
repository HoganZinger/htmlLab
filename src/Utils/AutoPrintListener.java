package Utils;

import Models.PrintIndentModel;

public class AutoPrintListener implements HtmlChangeListener{
    public AutoPrintListener(){
        HtmlContext.getInstance().addChangeListener(this);
    }
    @Override
    public void update() {
        String[] array = {"2"};
        PrintIndentModel printIndentModel = new PrintIndentModel(array);
        printIndentModel.execute();
    }
}
