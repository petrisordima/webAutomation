package framework;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import util.Util;

public class PerformTestFromXls extends TestOperations {

    public String sheetName() {
        return "";
    }

    @Test(dataProvider = "GetDataFromXlsFile")
    public void runTestCase(String operation, String xpath, String value) {

        perform(operation, xpath, value);

    }

    @DataProvider(name = "GetDataFromXlsFile")
    public Object[][] getDataFromXlsFile() {
        return (Util.getTableArray(sheetName()));
    }

    private void perform(String operation, String xpath, String value) {
        System.out.println("");
        switch (operation.toUpperCase()) {
            case "CLICK":
                //Perform click
                click(xpath);
                break;
            case "SEND_TEXT":
                sendText(value, xpath);
                break;
            case "GO_TO_URL":
                goToPage(value);
                break;
            case "ASERT_ELEMENT_PRESENT":
                assertElementPresent(xpath);
                break;
            case "WAIT":
                wait(Integer.parseInt(value));
                break;
            case "DOUBLE_CLICK":
                doubleClick(xpath);
                break;
            case "CLICK_BUTTON_TEXT":
                clickButton(xpath);
                break;
            case "CLICK_ELEMENT_WITH_TEXT":
                clickElementWithText(value);
                break;
            case "SEND_TEXT_ENTER":
                sendText(value, xpath);
                break;
            case "ASSERT_TEXT_EQUALS":
                assertTextEquals(xpath, value);
                break;
            case "GO_TO_POP_UP":
                goToPopUp();
                break;
            case "UPLOAD_FILE":
                uploadFile(value);
                break;
            case "DOWNLOAD_FILE":
                autoDownloadFile();
                break;
            default:
                break;
        }
    }
}
