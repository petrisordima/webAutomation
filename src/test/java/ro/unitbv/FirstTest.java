package ro.unitbv;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

public class FirstTest {

    public static WebDriver driver;


    @Test
    public static void elTest() throws InterruptedException {

        System.setProperty("webdriver.gecko.driver", "resources\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get("https://google.ro");


        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();


        driver.findElement(By.name("q")).sendKeys("anhken");
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        Thread.sleep(2000);

        driver.quit();
        driver.close();

    }
}
