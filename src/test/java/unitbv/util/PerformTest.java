package unitbv.util;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PerformTest extends TestOperations {

    public String sheetName() {
        return "";
    }

    @Test(dataProvider = "GetDataFromXlsFile")
    public void runTestCase(String operation, String value, String xpath) {

        perform(operation, value, xpath);

    }

    @DataProvider(name = "GetDataFromXlsFile")
    public Object[][] getDataFromXlsFile() throws Exception {
        return (ModuleUtil.getTableArray(sheetName()));
    }

    public void perform(String operation, String value, String xpath) {
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
