package unitbv.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * The main. Where all test operations are initialized and
 * prepares the test execution, loading its parameters
 *
 * @author pdima
 */

public class InitWebDriver {

    public static WebDriver driver;


    @BeforeSuite
    public static void openDriver() throws Exception {

        // loads test parameters from ..z_ts\\fwk.properties
        ModuleUtil.readParams();
        System.setProperty("webdriver.gecko.driver", "resources/geckodriver.exe");
        Util.Log.info("Start Driver");
        System.out.println("  [INFO] - browser set in unitbv.propreties = " + TestParams.getBrowser());
        System.out.println("  [INFO] - wait betwen operation set in unitbv.propreties = " + TestParams.getWait());
        if (TestParams.getSeleniumUrl() != null) {
            driver = new RemoteWebDriver(new URL(TestParams.getSeleniumUrl()), DesiredCapabilities.firefox());
        } else {
            if (TestParams.getBrowser().equals("chrome")) {
                System.setProperty("webdriver.chrome.driver", "D:\\kits\\ChromeDriver\\chromedriver.exe");
                driver = new ChromeDriver();
            } else {
                if (TestParams.getBrowser().equals("firefox")) {
                    driver = new FirefoxDriver();
                } else {
                    if (TestParams.getBrowser().equals("ie")) {
                        //System.setProperty("webdriver.ie.driver", "D:\\kits\\ChromeDriver\\iedriver.exe");
                        driver = new InternetExplorerDriver();
                    } else
                        driver = new FirefoxDriver();
                    System.out.println(" [CONFIGURATION ERROR] - Browser mispelled. Check browser parameter in unitbv.proprieties. Firefox set as defaut");
                    Util.Log.error("[CONFIGURATION ERROR] - Browser mispelled. Check browser parameter in unitbv.proprieties. Firefox set as defaut");
                }

            }
        }

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        String mainWindow = driver.getWindowHandle();
        //TestOperations.goToPage(TestParams.getBaseUrl());

    }

    @AfterSuite
    public void closeDriver() {

        Util.Log.info("Stop Driver");
        driver.close();
        //driver.quit();
    }

}
