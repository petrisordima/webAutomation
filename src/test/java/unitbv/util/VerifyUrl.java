package unitbv.util;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by pdima on 18/11/2015.
 */
public class VerifyUrl extends TestOperations {



    @Test(dataProvider = "GetDataFromXlsFile")
    public static void verifyUrlUsingXPath(String jspurl) {


        driver.get(TestParams.getBaseUrl() + jspurl);

        if (driver.getPageSource().contains("Une erreur administration inattendue s'est produite. Veuillez contacter votre administrateur.")) {
            Assert.fail(Util.Log.error("Page not loaded"));
            wait(1);
        } else {
            Util.Log.info(" [OK] - Page Loaded OK");
            wait(1);
        }
    }

    @DataProvider(name = "GetDataFromXlsFile")
    public Object[][] getDataFromXlsFile() throws Exception {
        return (ModuleUtil.getTableArray("Technique"));
    }
}
