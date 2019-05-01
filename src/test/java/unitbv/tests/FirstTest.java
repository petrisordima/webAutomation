package unitbv.tests;

import org.testng.annotations.Test;
import framework.TestOperations;

public class FirstTest extends TestOperations {


    @Test
    public static void verificareNoteIntranet() {

        goToPage("https://elearning.unitbv.ro/login/index.php");
        sendText("petrisor.dima@student.unitbv.ro", "//input[@name='username']");
        sendText("VrTzBsDJDwFz54Q", "//input[@name='password']");
        click("//input[@type='submit']");
        click("(//b[contains(@class,'caret')])[1]");
        click("//a[@data-title='grades,grades']");
        assertElementPresent("//td[contains(.,'80,00')]");
        click("//a[@class='brand']");
        click("//a[contains(.,'Platforma e-Learning 2018-2019')]");
        click("//span[@class='item-content-wrap'][contains(.,'Pagina principală')]");
        assertElementPresent("//td[contains(.,'80,00')]");


    }
}
