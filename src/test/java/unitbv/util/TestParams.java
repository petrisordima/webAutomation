package unitbv.util;

public class TestParams {

    private static int TIMEOUT;
    private static int WAIT;
    private static String BASE_URL;
    private static String SELENIUM_URL;
    private static String BROWSER;
    private static String USER_MD5;
    private static String SCREEN_SHOT_DIR;
    private static String SCREEN_SHOT_URL;
    private static String MAIN_WINDOW;
    private static String DATA_FILE_PATH_XLS;



    // timeout
    public static void setTimeout(int property) {
        TIMEOUT = property;
    }

    public static int getTimeout() {
        return TIMEOUT;
    }

    // wait TestOperations
    public static void setWait(int property) {
        WAIT = property;
    }

    public static int getWait() {
        return WAIT;
    }

    // unitbvurl
    public static void setBaseUrl(String property) {
        BASE_URL = property;
    }

    public static String getBaseUrl() {
        return BASE_URL;
    }

    // selenium url
    public static void setSeleniumUrl(String property) {
        SELENIUM_URL = property;
    }

    public static String getSeleniumUrl() {
        return SELENIUM_URL;
    }

    // selenium url
    public static void setMainWindow(String property) {
        MAIN_WINDOW = property;
    }

    public static String getMainWindow() {
        return MAIN_WINDOW;
    }

    //browser
    public static void setBrowser(String property) {
        BROWSER = property;
    }

    public static String getBrowser() {
        return BROWSER;
    }

    // usermd5
    public static void setUserMd5(String property) {
        USER_MD5 = property;
    }

    public static String getUserMd5() {
        return USER_MD5;
    }

    // ScreenShotDir
    public static void setScreenShotDir(String property) {
        SCREEN_SHOT_DIR = property;
    }

    public static String getScreenShotDir() {
        return SCREEN_SHOT_DIR;
    }

    // ScreenShotUrl
    public static void setScreenShotUrl(String property) {
        SCREEN_SHOT_URL = property;
    }

    public static String getScreenShotUrl() {
        return SCREEN_SHOT_URL;
    }

    // xlsFilePath
    public static void setXlsFilePath(String property) {
        DATA_FILE_PATH_XLS = property;
    }

    public static String getXlsFilePath() {
        return DATA_FILE_PATH_XLS;
    }

}
