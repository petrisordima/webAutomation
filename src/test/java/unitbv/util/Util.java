package unitbv.util;

import org.testng.Reporter;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.text.Format;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {

	/**
	 * sysdate logger, logs the date in the specified format. In this case
	 * dd-MM_HH-mm-ss
	 */
	public static String logTime() {

		Format formatter;
		Date date = new Date();
		formatter = new SimpleDateFormat("dd-MM_HH-mm-ss");
		return formatter.format(date);
	}


	/**
	 * string formatter for eliminating accents and bizarre characters form
	 * logs. Formats in ASCII
	 *
	 */
	public static String formatNoAccent(String str) {
//		String nfdNormalizedString = Normalizer.normalize(str, Normalizer..NFD);
//		nfdNormalizedString = nfdNormalizedString.replaceAll("[^\\p{ASCII}]", "");
		return str;
	}

	/**
	 * file uploader using the robot function
	 */
	public static void uploadFile(String filePath) {

		StringSelection ss = new StringSelection(filePath);

		java.awt.Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

		try {
			Robot robot = new Robot();
			TestOperations.wait(1);

			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);

			TestOperations.wait(4);

			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);

			TestOperations.wait(2);

		} catch (AWTException e) {

			e.printStackTrace();
		}

	}

	/**
	 * file uploader using the robot function
	 */
	public static void autoDownloadFile() {



		try {
			Robot robot = new Robot();
			TestOperations.wait(1);

			robot.keyPress(KeyEvent.VK_DOWN);
			robot.keyPress(KeyEvent.VK_DOWN);


			TestOperations.wait(2);

			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);

			TestOperations.wait(4);

		} catch (AWTException e) {

			e.printStackTrace();
		}


	}

	/**
	 * logger, visible in the reporter output from the xsl test report. Uses
	 * Reporter.Log() from webdriver
	 */
	public static class Log {

		public static String info(String message) {

			String s = logTime() + " [INFO] - " + message;
			Reporter.log(s);
			return (s);
		}

		public static String warn(String message) {

			String s = logTime() + " [WARN] - " + message;
			Reporter.log(s);
			return (s);
		}

		public static String error(String message) {

			String s = logTime() + " [ERROR] - " + message;
			Reporter.log(s);
			return (s);
		}

	}

}
