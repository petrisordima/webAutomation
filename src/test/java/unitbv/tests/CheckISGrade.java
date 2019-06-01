package unitbv.tests;

import framework.TestOperations;
import org.testng.annotations.Test;
import unitbv.entities.ELearningWebPages;

public class CheckISGrade extends TestOperations {


    @Test
    public static void verifyISGradeOnIntranet() {

        goToUrl(ELearningWebPages.PLATFORM_URL);

        //  Perform Login
        login("petrisor.dima@student.unitbv.ro", "VrTzBsDJDwFz54Q");

        //  Check course IS grade is present
        click(ELearningWebPages.HomepagePage.Profile.PROFILE_PHOTO);
        click(ELearningWebPages.HomepagePage.Profile.PROFILE_GRADES);
        assertElementPresent(ELearningWebPages.MyGradesPage.IS_COURSE);
        click(ELearningWebPages.MyGradesPage.IS_COURSE);
        assertElementPresent(ELearningWebPages.MyGradesPage.ISGrades.COURSE_TOTAL);
        click(ELearningWebPages.HomepagePage.Profile.PROFILE_PHOTO);
        click(ELearningWebPages.HomepagePage.Profile.PROFILE_GRADES);

        // back to homepage
        click(ELearningWebPages.HOME_LOGO);

    }

    //  Reusable login method

    public static void login(String username, String password) {
        sendText("petrisor.dima@student.unitbv.ro", ELearningWebPages.LoginPage.INPUT_USERNAME);
        sendText("VrTzBsDJDwFz54Q", ELearningWebPages.LoginPage.INPUT_PASSWORD);
        click(ELearningWebPages.LoginPage.BTN_LOGIN);
    }
}
