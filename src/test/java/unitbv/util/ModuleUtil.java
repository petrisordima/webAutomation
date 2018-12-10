package unitbv.util;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ModuleUtil {

    public static void readParams() {

        Properties prop = new Properties();
        Util.Log.info("Preparing test execution ");
        try {

            FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/z_ts/ts.properties");

            Util.Log.info("Loading unitbv.proprieties file ");

            prop.load(fis);
            TestParams.setTimeout(Integer.parseInt(prop.getProperty("timeout")));
            TestParams.setWait(Integer.parseInt(prop.getProperty("wait")));
            TestParams.setBaseUrl(prop.getProperty("base.url"));
            TestParams.setSeleniumUrl(prop.getProperty("selenium.url"));
            TestParams.setBrowser(prop.getProperty("browser"));
            TestParams.setUserMd5(prop.getProperty("user.md5"));
            TestParams.setScreenShotDir(prop.getProperty("screen.shot.dir"));
            TestParams.setScreenShotUrl(prop.getProperty("screen.shot.url"));
            TestParams.setXlsFilePath(prop.getProperty("file.path.xls"));


            Util.Log.info("File Loaded. Test parameters are: ");

        } catch (FileNotFoundException e) {
            e.getCause();
            Util.Log.error("unitbv.proprieties file not found ");
        } catch (IOException e) {
            e.getCause();
        }

        Util.Log.info("@ ____General Parameters___ @ ");
        Util.Log.info(" screen.shot.dir 				: " + TestParams.getScreenShotDir());
        Util.Log.info(" screen.shot.url 				: " + TestParams.getScreenShotUrl());
        Util.Log.info(" unitbv.url 						: " + TestParams.getBaseUrl());
        Util.Log.info(" selenium.url 					: " + TestParams.getSeleniumUrl());
        Util.Log.info(" browser						    : " + TestParams.getBrowser());
        Util.Log.info(" user.md5 						: " + TestParams.getUserMd5());
        Util.Log.info(" timeout 						: " + TestParams.getTimeout());
        Util.Log.info(" wait 							: " + TestParams.getWait());
        Util.Log.info("@ ____Test Data Parameters (Xls)____@  ");

        Util.Log.info("@ ____________ @ ");
        Util.Log.info("Finished reading parameters. Begining test execution");

    }

    public static void ScreenShot() {
        try {
            String newFileNamePath;
            String urlFileNamePath;
            String time = Util.logTime();
            File directory = new File(TestParams.getScreenShotDir());
            newFileNamePath = TestParams.getScreenShotDir() + "\\" + time + ".png";
            urlFileNamePath = TestParams.getScreenShotUrl() +"/" + time + ".png";
            System.out.println(" [ERROR] - ScreenShot taken: " + urlFileNamePath);
            Robot robot = new Robot();
            BufferedImage bi = robot.createScreenCapture(new Rectangle(1680, 1050));
            ImageIO.write(bi, "png", new File(newFileNamePath));
            Util.Log.error("ScreenShot taken : " + urlFileNamePath);
        } catch (AWTException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * reads data from xls filefrom the @sheetNeme - passed from
     * getDataFromXlsFile() - passed by sheetName() from the main test class
     *
     * @DATA_TAG_XLS - the delimiter in the xls sheet when defining the test
     * data table
     * @DATA_FILE_PATH_XLS - file location
     */

    public static String[][] getTableArray(String sheetName) {

        final String DATA_TAG_XLS = "Data";
        try {
            String[][] tabArray;
            //Workbook workbook = Workbook.getWorkbook(new File(System.getProperty("user.dir") + System.getProperty("file.separator") + TestParams.getXlsFilePath()));
            Workbook workbook = Workbook.getWorkbook(new File(TestParams.getXlsFilePath()));
            Sheet sheet = workbook.getSheet(sheetName);
            int startRow, startCol, endRow, endCol, ci, cj;
            Cell tableStart = sheet.findCell(DATA_TAG_XLS);
            startRow = tableStart.getRow();
            startCol = tableStart.getColumn();
            Cell tableEnd = sheet.findCell(DATA_TAG_XLS, startCol + 1, startRow + 1, 100, 64000, false);
            endRow = tableEnd.getRow();
            endCol = tableEnd.getColumn();
            tabArray = new String[endRow - startRow - 1][endCol - startCol - 1];
            ci = 0;
            for (int i = startRow + 1; i < endRow; i++, ci++) {
                cj = 0;
                for (int j = startCol + 1; j < endCol; j++, cj++) {
                    tabArray[ci][cj] = sheet.getCell(j, i).getContents();
                }
            }
            return (tabArray);

        } catch (Exception e) {
            System.out.println(" [CONFIGURATION ERROR] - Sheet name : " + sheetName + " not found in " + TestParams.getXlsFilePath() +". Skipping test");
            Util.Log.error(" [CONFIGURATION ERROR] - Sheet name : " + sheetName + " not found in " + TestParams.getXlsFilePath() + ". Skipping test");
        }
        return null;

    }

}
