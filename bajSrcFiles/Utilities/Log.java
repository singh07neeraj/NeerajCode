package Utilities;

import org.testng.Reporter;

import com.relevantcodes.extentreports.LogStatus;

/***
 * @description This class contains useful methods which help in logging the
 *              information into log files, extent reports and test NG default
 *              reports. By using simply LOG.{MthodName} you can log at 3 places
 *              there by reducing lines of code required to create logs.
 * @author baj80000892/Alok Rai
 *
 */
public class Log extends TestBase {

	public static void info(String message) {

		eTest.log(LogStatus.INFO, message);// For extentTest HTML report

		logger.info("Message: " + message);

		Reporter.log(message);
	}

	public static void error(String message) {

		try {
			eTest.log(LogStatus.ERROR, message);// For exstentTest HTML report

			logger.error("Message: " + message);

			Reporter.log(message);
		}

		catch (Exception e) {

			Log.info("Error...." + e.getStackTrace());
		}

	}

	public static void pass(String message) {

		eTest.log(LogStatus.PASS, message);// For extentTest HTML report

		logger.info("Message: " + message);

		Reporter.log(message);

	}

	public static void fail(String message) {

		eTest.log(LogStatus.FAIL, message);// For extentTest HTML report

		logger.error("Message: " + message);

		Reporter.log(message);

	}

	public static void skip(String message) {

		eTest.log(LogStatus.SKIP, message);// For extentTest HTML report

		logger.info("Message: " + message);

		Reporter.log(message);

	}

	public static void fatal(String message) {

		eTest.log(LogStatus.FATAL, message);// For extentTest HTML report

		logger.error("Message: " + message);

		Reporter.log(message);

	}

	public static void warn(String message) {

		eTest.log(LogStatus.WARNING, message);// For extentTest HTML report

		logger.info("Message: " + message);

		Reporter.log(message);

	}
	
}
