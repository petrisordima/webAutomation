package unitbv.util;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class VerifyPages extends TestOperations {

    public String sheetName() {
        return "";
    }

    @Test(dataProvider = "GetDataFromXlsFile")
    public void verifyUrlUsingXPath(String elementChecked, String url, String xpath) {

        goToPage(TestParams.getBaseUrl() + url);
        Util.Log.info("open page : " + url + " to chek :" + elementChecked);

//		if (userIsLoggedIn()) {
        assertElementPresent(xpath);
//	    }
//		else {
//
//			Util.Log.warn("user is not logged in. Logging in with default user");
//			loginDefault();
//            goToPage(TestParams.getBaseUrl());
//			assertElementPresent(xpath);
//		}
    }

    @DataProvider(name = "GetDataFromXlsFile")
    public Object[][] getDataFromXlsFile() throws Exception {
        return (ModuleUtil.getTableArray(sheetName()));
    }

}
