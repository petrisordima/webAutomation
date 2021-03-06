package unitbv.tests;

import framework.TestOperations;
import org.testng.annotations.Test;
import unitbv.entities.Web;

public class CheckISGrade extends TestOperations {


    @Test
    public void verifyISGradeOnIntranet() {

        goToUrl(Web.PLATFORM_URL);

        //  Perform Login
        login("username", "password");

        //  Check course IS grade is present
        click(Web.HomePage.Profile.PROFILE_PHOTO);
        click(Web.HomePage.Profile.PROFILE_GRADES);
        assertElementPresent(Web.MyGradesPage.IS_COURSE);
        wait(2);
        click(Web.MyGradesPage.IS_COURSE);
        assertElementPresent(Web.MyGradesPage.ISGrades.COURSE_TOTAL);
        click(Web.HomePage.Profile.PROFILE_PHOTO);
        click(Web.HomePage.Profile.PROFILE_GRADES);

        // back to homepage
        click(Web.HomePage.HOME_LOGO);

    }

    //  Reusable login method

    public void login(String username, String password) {
        sendText("petrisor.dima@student.unitbv.ro", Web.LoginPage.INPUT_USERNAME);
        sendText("VrTzBsDJDwFz54Q", Web.LoginPage.INPUT_PASSWORD);
        click(Web.LoginPage.BTN_LOGIN);
    }
}
