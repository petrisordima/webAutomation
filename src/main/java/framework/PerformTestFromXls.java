package framework;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import util.Util;

public class PerformTestFromXls extends TestOperations {

    public String sheetName() {
        return "";
    }

    @Test(dataProvider = "GetDataFromXlsFile")
    public void runTestCase(String operation, String value, String xpath) {

            perform(operation, value, xpath);

    }

    @DataProvider(name = "GetDataFromXlsFile")
    public Object[][] getDataFromXlsFile() {
        return (Util.getTableArray(sheetName()));
    }

    private void perform(String operation, String value, String xpath) {
        System.out.println("");
        switch (operation.toUpperCase()) {
            case "CLICK":
                //Perform click
                click(xpath);
                break;
            case "SENDTEXT":
                sendText(value, xpath);
                break;
            case "GOTOURL":
                goToPage(value);
                break;
            case "ASERTELEMENTPRESENT":
                assertElementPresent(xpath);
                break;
            case "WAIT":
                wait(Integer.parseInt(value));
                break;
            default:
                break;
        }
    }
}
