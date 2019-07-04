package unitbv.tests;


import util.VerifyPagesFromXls;

public class CheckWebPages extends VerifyPagesFromXls {


    @Override
    public String sheetName() {
        return "pagesData";
    }

}
