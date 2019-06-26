package Utilities;

import static Utilities.ReadData.getObj;
import static Utilities.ReadData.readConfigXml;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

/*import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;*/

public class Utils extends TestBase {

	private static Workbook book;
	private static String filePath = System.getProperty("user.dir") + "\\screenshots\\";
	public static JavascriptExecutor js = (JavascriptExecutor) driver;

	private static Sheet sheet;
	static Log log = new Log();
	static WebElement globalElement = null;
	static int windowCount = 0;
	public static Actions actions = null;
	// public static SoftAssert sAssert = new SoftAssert();

	/**
	 * @return The line number of the code that ran this method
	 * @author Brian_Entei
	 */
	public static int getLineNumber() {
		return ___8drrd3148796d_Xaf();
	}

	public static boolean sendKeys_Smart1(By element, String keyword, String... strElementName) throws Exception {

		boolean flag = false;
		WebElement WebElement = null;
		String elementName = null;

		if (element == null) {

			Log.error("Element element object path is null.. Unable to locate element.. Check if x path is correctly given in object files.");
			return flag;
		}
		try {
			elementName = strElementName[0]; // strElementName;
		} catch (Exception e) {

			elementName = element.toString().substring(element.toString().indexOf("->") + 1);
		}
		try {
			WebElement = driver.findElement(element);
			Utils.wait(10);
			if (WebElement == null) {

				Log.fail(" Element is null..........Unable to locat element to send data. Waited for 40 seconds. ");
				return flag;
			} else {

				// scrollIntoViewbyJS(WebElement);
				// waitForVisibilityOfElement(WebElement);
				WebElement.click();
				try {
					WebElement.clear();
				} catch (Exception e) {
				}
				// highlighElement(WebElement);
				WebElement.sendKeys(keyword);
				// Thread.sleep(1000);
				// WebElement.sendKeys(Keys.TAB);

				Log.pass("Successfully Entered data [ " + keyword + " ] into field : " + elementName);
				flag = true;
			}
		} catch (Exception e) {
			Log.fail("Unable to send data to element : " + ExceptionUtils.getStackTrace(e));
			Utils.logFailImage("Error");
			e.printStackTrace();
			flag = false;
			throw e;
		}
		return flag;
	}

	public static boolean Sendkeys_DD_substringbased(By element, String keyword, String... strFieldName) {

		Actions KeyStrokes = new Actions(driver);
		WebElement ele = null;
		String finalFieldName = null;

		try {
			finalFieldName = strFieldName[0];
		} catch (Exception e) {
			finalFieldName = keyword.toString();
		}
		try {
			if (Utils.getSize(element) > 0) {
				try {
					ele = driver.findElement(element);
					scrollIntoViewbyJS(ele);
					waitForVisibilityOfElement(ele);
					try {
						ele.click();
						ele.clear();
					} catch (Exception e) {

					}

					Thread.sleep(2000);
					ele.sendKeys(keyword);
					Thread.sleep(2000);
					KeyStrokes.sendKeys(Keys.ARROW_DOWN).build().perform();
					Thread.sleep(2000);
					KeyStrokes.sendKeys(Keys.ENTER).build().perform();

					Log.pass("Successfully entered data : " + keyword + "Into field " + finalFieldName);
					runResult = true;
				} catch (Exception e) {
					Log.error("Unable to select data from DropDown : " + ExceptionUtils.getStackTrace(e));
					Utils.logFailImage("Error");
					runResult = false;

				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return runResult;
	}

	public static boolean Changedate_Smart(String Datetype, String ElementName, String PageName, String Description) throws Exception {

		try {
			Utils.wait(2);
			for (int i = 0; i < Integer.parseInt(Datetype); i++) {
				Utils.click_Smart(By.xpath(getObj("Propval1", ElementName, PageName)), Description);

			}
		}

		catch (Exception e) {
			Log.error("Unable to change date" + ExceptionUtils.getStackTrace(e));
			Utils.logFailImage("Error");
			runResult = false;
			throw e;

		}

		return runResult;
	}

	public static boolean waitForVisibilityOfElement(WebElement element) {
		boolean b = false;
		try {
			FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(40, TimeUnit.SECONDS).pollingEvery(2, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
			wait.until(ExpectedConditions.visibilityOf(element));
			b = true;
		}

		catch (Exception e) {

			// Log.error("Visibility of element failed : " + e.getStackTrace());
			// Utils.logFailImage("Error");
			b = false;
		}

		return b;
	}

	public static void scrollIntoView(By byElement) {
		WebElement element = null;
		try {

			element = driver.findElement(byElement);
			js.executeScript("arguments[0].scrollIntoView(true)", element);
			Thread.sleep(2000);
			// element.click();
			// Log.pass(" Scrolled into view : " + eleName);
		}

		catch (Exception e) {

			// Log.error(" Unable to Scroll into view : " + element + " " +
			// ExceptionUtils.getStackTrace(e));
		}

	}

	/**
	 * This methods name is ridiculous on purpose to prevent any other method names
	 * in the stack trace from potentially matching this one.
	 * 
	 * @return The line number of the code that called the method that called this
	 *         method(Should only be called by getLineNumber()).
	 * @author Brian_Entei
	 */

	public static int getSize(By byElement) throws Exception {

		List<WebElement> list = null;
		int countOfElement = 0;
		try {
			FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(25, TimeUnit.SECONDS).pollingEvery(500, TimeUnit.MILLISECONDS).ignoring(NoSuchElementException.class);
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(byElement)));
			list = driver.findElements(byElement);
			countOfElement = list.size();
		}

		catch (Exception e) {
			// Utils.logFailImage("Error while getting count of element " +
			// byElement.toString());
			throw e;
		}
		return countOfElement;
	}

	/***
	 * @author Alok
	 * @Description This method will click on a given element. if element not
	 *              visible or not yet present in DOM ,then it will wait for 60
	 *              seconds before throwing an exception.
	 * @param element to click and element name to put in logs/reports.
	 * @return True- If element was found and clicked successfully. False- If
	 *         element was not clicked due to exception.
	 */
	public static boolean click_Smart(By element, String eleName, int... moreArgs) throws Exception {
		String elementName = null;
		WebElement webEle = null;
		int timOut = 1;
		int throwException = 1;
		boolean bFlag = false;

		try {
			timOut = moreArgs[0];
		} catch (Exception e) {
			timOut = g_nMaxWaitTime; // TestBase class has this info.
		}

		try {
			throwException = moreArgs[1];
		} catch (Exception e) {
			throwException = 1; // Will throw exception.
		}

		if (element == null) {
			Log.fail("Element object  xpath value is null.. Unable to locate element.. ");
			return false;
		}
		try {
			elementName = eleName; // eleName[0];
		} catch (Exception e) {
			elementName = element.toString();
		}
		try {
			FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(timOut, TimeUnit.SECONDS).pollingEvery(1, TimeUnit.SECONDS).ignoring(NoSuchElementException.class).ignoring(NullPointerException.class);
			wait.until(ExpectedConditions.visibilityOfElementLocated(element));
			wait.until(ExpectedConditions.elementToBeClickable(element));

			webEle = driver.findElement(element);
			// scrollIntoViewbyJS(webEle);
			highlighElement(webEle);
			webEle.click();
			Log.pass("Successfully clicked element- " + elementName);
			// Utils.logPassImage(TCName+" Scenario Count- "+scenarioCount);
			bFlag = true;
		} catch (Exception e) {

			// Utils.logFailImage("Error");
			bFlag = false;
			if (throwException == 0) {
				// Do not throw exception as user as given 0 as 2nd parameter. Sometimes it is
				// not required
			} else {
				Log.fail("Unable to click element : " + elementName); // comment this if error comes twice in logs.
				Utils.logFailImage(TCName + " Scenario Count- " + scenarioCount);
				throw e;
			}
		}
		return bFlag;
	}

	public static String getText_Smart(By ByElement) {
		WebElement element = null;

		try {
			FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(20, TimeUnit.SECONDS).pollingEvery(500, TimeUnit.MILLISECONDS).ignoring(NoSuchElementException.class);
			wait.until(ExpectedConditions.visibilityOfElementLocated(ByElement));

			element = driver.findElement(ByElement);

			if (element == null) {
				Log.fail("Element is null.... unable to get text");
				return null;
			} else {
				// scrollIntoViewbyJS(element);
				waitForVisibilityOfElement(element);
				element.getText();
				Log.pass("Message displayed on screen is : " + element.getText());
				return element.getText();
			}
		} catch (Exception e) {
			Log.fail("Unable to get message on screen using element : " + element.toString() + " " + ExceptionUtils.getStackTrace(e));
			Utils.logFailImage("Error");
			return "Text not found";
		}
	}

	public static boolean assertDisplayed_Smart(By element, String strElemName) {

		try {
			Utils.waitForVisibilityOfElement(driver.findElement(element));
			WebElement webEle = driver.findElement(element);
			// Utils.scrollIntoViewbyJS(webEle);
			Utils.highlighElement(webEle);
			Assert.assertTrue(webEle.isDisplayed());
			Log.pass(strElemName + " is displayed on screen");
			bResVal = true;
		} catch (AssertionError | Exception e) {
			Log.pass(strElemName + " is not displayed on screen ");
			bResVal = false;
		}
		return bResVal;
	}

	public static boolean sendKeys_Smart(By element, String keyword, String... strElementName) throws Exception {

		boolean flag = false;
		WebElement WebElement = null;
		String elementName = null;

		if (element == null) {

			Log.error("Element element object path is null.. Unable to locate element.. Check if x path is correctly given in object files.");
			return flag;
		}
		try {
			elementName = strElementName[0]; // strElementName;
		} catch (Exception e) {

			elementName = element.toString().substring(element.toString().indexOf("->") + 1);
		}
		try {
			FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(40, TimeUnit.SECONDS).pollingEvery(1, TimeUnit.NANOSECONDS).ignoring(NoSuchElementException.class);
			wait.until(ExpectedConditions.visibilityOfElementLocated(element));
			wait.until(ExpectedConditions.elementToBeClickable(element));
			WebElement = driver.findElement(element);

			if (WebElement == null) {

				Log.fail(" Element is null..........Unable to locat element to send data. Waited for 40 seconds. ");
				return flag;
			} else {

				// scrollIntoViewbyJS(WebElement);
				// waitForVisibilityOfElement(WebElement);
				WebElement.click();
				try {
					WebElement.clear();
				} catch (Exception e) {
				}
				// highlighElement(WebElement);
				WebElement.sendKeys(keyword);
				// Thread.sleep(1000);
				// WebElement.sendKeys(Keys.TAB);

				Log.pass("Successfully Entered data [ " + keyword + " ] into field : " + elementName);
				flag = true;
			}
		} catch (Exception e) {
			Log.fail("Unable to send data to element : " + ExceptionUtils.getStackTrace(e));
			Utils.logFailImage("Error");
			e.printStackTrace();
			flag = false;
			throw e;
		}
		return flag;
	}

	public static boolean sendValDropdown_Smart(By element, String keyword, String... fieldName) throws Exception {

		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(15, TimeUnit.SECONDS).pollingEvery(500, TimeUnit.MILLISECONDS).ignoring(NoSuchElementException.class).ignoring(NullPointerException.class);

		Actions KeyStrokes = new Actions(driver);
		WebElement ele = null;
		String finalFieldName = null;

		try {
			finalFieldName = fieldName[0];
		} catch (Exception e) {
			finalFieldName = element.toString();
		}
		try {
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(element)));
			ele = driver.findElement(element);
			ele.click();
			// ele.clear();
			ele.sendKeys(keyword);
			Thread.sleep(1000);
			KeyStrokes.sendKeys(Keys.ENTER).build().perform();
			// Thread.sleep(1000);
			Utils.pressTab();
			Log.pass("Successfully sent value :  ' " + keyword + " '  to field :  " + finalFieldName);
			runResult = true;
		} catch (Exception e) {
			Log.fail("Unable to select data from DropDown : " + ExceptionUtils.getStackTrace(e));
			runResult = false;
			throw e;
		}
		return runResult;
	}

	public static int getSizeNoException(By byElement) {

		List<WebElement> list = null;
		int countOfElement = 0;
		try {
			FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(25, TimeUnit.SECONDS).pollingEvery(500, TimeUnit.MILLISECONDS).ignoring(NoSuchElementException.class);
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(byElement)));
			list = driver.findElements(byElement);
			countOfElement = list.size();
		}

		catch (Exception e) {
			// Utils.logFailImage("Error while getting count of element " +
			// byElement.toString());
			// throw e;
		}
		return countOfElement;
	}

	private static int ___8drrd3148796d_Xaf() {
		boolean thisOne = false;
		int thisOneCountDown = 1;
		StackTraceElement[] elements = Thread.currentThread().getStackTrace();
		for (StackTraceElement element : elements) {
			String methodName = element.getMethodName();
			int lineNum = element.getLineNumber();
			if (thisOne && (thisOneCountDown == 0)) {
				return lineNum;
			} else if (thisOne) {
				thisOneCountDown--;
			}
			if (methodName.equals("___8drrd3148796d_Xaf")) {
				thisOne = true;
			}
		}
		return -1;
	}

	public static String setValue(String strInitialValue) {

		if (strInitialValue == null) {

			System.out.println("Field value not found in ReadData or in GUI. Returning '0'  as default value in String fomat.");
			return "0";
		}

		else {
			return strInitialValue;
		}

	}

	public static void sendKeys_DD(By value, String keyword) {

		WebElement WebElement = driver.findElement(value);
		try {
			if (WebElement == null) {

				Log.error(" Element is null.......... ");

			} else {
				Thread.sleep(1000);
				WebElement.sendKeys(keyword);
				WebElement.sendKeys(Keys.ENTER);
			}
		} catch (Exception e) {
			Log.error("Unable to send data to element : " + ExceptionUtils.getStackTrace(e));
			Utils.logFailImage("Error");
			e.printStackTrace();

		}

	}

	/***
	 * @author baj80000892/Alok Rai
	 * @Description this method can enter otp into the OTP fields in JOL/ECorp
	 *              Application and will click proceed. Can be used when ever user
	 *              needs to enter OTP during some transaction.
	 * @param otp - Optional parameter. If OTP not provided, then it wil read value
	 *            from the app config xml using readConfigXml method of class
	 *            ReadData.java.
	 */
	public static void enterOTPAndProceed(String... otp) {

		String strOtp = null;
		int strOtpSize = 0;

		try {
			strOtpSize = Utils.getSize(By.xpath(getObj("Propval1", "OTPField", "OTP")));
		} catch (Exception e) {
		}

		try {
			if (strOtpSize > 0) {

				try {
					strOtp = otp[0];
				} catch (Exception e) {
					strOtp = readConfigXml("OTP");
					Log.pass("Otp not provided by code. Entering default OTP from path : " + g_appConfigXmlPath);
				}
				Utils.sendKeys(By.xpath(getObj("Propval1", "OTPField", "OTP")), strOtp, "Otp Input");
				Utils.click(By.xpath(getObj("Propval1", "ProceedBtn", "OTP")), "Proceed");
				Log.pass("Entered otp " + strOtp + " as required");

			} else {
				logger.info("Otp is not required by the screen.");
			}

		} catch (Exception e) {
			// Nothing
		}

	}

	public static void ClearText(By value) {

		WebElement WebElement = driver.findElement(value);
		try {
			if (WebElement == null) {

				Log.error(" Element is null.......... ");

			} else {
				Thread.sleep(1000);
				WebElement.clear();

			}
		} catch (Exception e) {
			Log.error("Unable to send data to element : " + ExceptionUtils.getStackTrace(e));
			e.printStackTrace();

		}

	}

	public static List<WebElement> listOfWebElements(By byElement) {

		// globalElement = driver.findElement(byElement);
		List<WebElement> list = driver.findElements(byElement);
		return list;

	}

	public static Object executeScript(String script) {
		JavascriptExecutor exe = (JavascriptExecutor) driver;
		// Log.pass(script);
		return exe.executeScript(script);
	}

	public static void scrollDownVertically() {
		executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

	public static void scrollUpVertically() {
		executeScript("window.scrollTo(0, -document.body.scrollHeight)");
	}

	public static void scrollDownByPixel() {
		executeScript("window.scrollBy(0,1500)");
	}

	public static void scrollUpByPixel() {
		executeScript("window.scrollBy(0,-1500)");
	}

	public static void ZoomInBypercentage() {
		Robot robot;
		try {
			robot = new Robot();

			robot.keyPress(KeyEvent.VK_CONTROL);
			Utils.waitForSeconds(3);
			robot.keyPress(KeyEvent.VK_MINUS);
			Utils.waitForSeconds(3);
			robot.keyPress(KeyEvent.VK_MINUS);
			Utils.waitForSeconds(3);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_MINUS);
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void pressSpaceKey() {
		Robot robot;
		try {
			robot = new Robot();
			robot.keyPress(KeyEvent.VK_SPACE);
			robot.keyRelease(KeyEvent.VK_SPACE);

		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/***
	 * @description this method can be used to close unwanted alert pop up in the
	 *              application. Unwanted alerts cause all test cases to fail.
	 * @param count - Number of times you want to press escape key.
	 * @author baj80000892/Alok Rai
	 */
	public static void pressEscapeKey(int count) {

		Robot robot;
		for (int i = 0; i <= count; i++) {
			try {
				Thread.sleep(1);
				/*
				 * robot = new Robot(); robot.keyPress(KeyEvent.VK_ESCAPE);
				 * robot.keyRelease(KeyEvent.VK_ESCAPE);
				 */
				Actions action = new Actions(driver);
				action.sendKeys(Keys.ESCAPE).build().perform();

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	public static void ZoomBy100percentage() {
		executeScript("document.body.style.zoom='100%'");
	}

	/*************************************************************
	 * @author :Alok
	 * @Method_Name: acceptAlertPopup.
	 * @Description :This method will accept alert pop up.
	 * 
	 ***********************************************************/
	public static boolean acceptAlertPopup() {

		boolean b = false;
		try {
			Alert alert = driver.switchTo().alert();
			alert.accept();
			b = true;
		} catch (NoAlertPresentException e) {
			Log.error("Error....." + e.getStackTrace());
			b = false;
		}
		return b;
	}

	public static void hitEnter(By byElement) {

		driver.findElement(byElement).sendKeys(Keys.ENTER);

	}

	public static boolean mouseHover(By byElement) {

		try {
			Utils.waitTillSaudiWaitIconDisappears();
			FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(40, TimeUnit.SECONDS).pollingEvery(1, TimeUnit.SECONDS).ignoring(NoSuchElementException.class).ignoring(NullPointerException.class);
			wait.until(ExpectedConditions.visibilityOfElementLocated(byElement));
			wait.until(ExpectedConditions.elementToBeClickable(byElement));

			globalElement = driver.findElement(byElement);
			Actions ac = new Actions(driver);
			ac.moveToElement(globalElement).build().perform();
			return true;
		}

		catch (Exception e) {
			Log.error("Unable to hover on element.." + globalElement + " ");
			throw e;
		}
	}

	public static boolean clickByActions(By byElement) {

		try {
			globalElement = driver.findElement(byElement);
			Actions ac = new Actions(driver);
			ac.moveToElement(globalElement).click().build().perform();
			return true;
		}

		catch (Exception e) {

			Log.error("Unable to click on element.." + globalElement + " " + e.getLocalizedMessage());
			e.printStackTrace();
			return false;
		}

	}

	public static void Decimal(By element) {

		final String decimal = "10.12";
		WebElement element1 = driver.findElement(element);
		element1.sendKeys(decimal);

	}

	/*************************************************************
	 * @author :Alok
	 * @Method_Name: assertIfEqual.
	 * @Description :This method will compare two strings and return true if equal
	 *              or false if not equal.
	 * @param: strActual- Actual string.
	 * @param: strExpected- Expected string.
	 ***********************************************************/
	protected static boolean assertIfEqual(String strActual, String strExpected) {
		boolean b = false;
		try {
			Assert.assertEquals(strActual, strExpected);
			Log.pass("Actual string: [ " + strActual + " ] is matching with Expected string: [ " + strExpected + " ]");
			b = true;

		} catch (AssertionError e) {
			Log.error("Actual string: [ " + strActual + " ] does not match with Expected string: [ " + strExpected + " ]");
			b = false;
		}
		return b;
	}

	/**
	 * @author Alok Rai
	 * @param Actual
	 * @param Expected
	 * @return Returns true if Actual and Ecpected objects are same. Returns false
	 *         if Actual and Expected are not same.
	 */

	public static boolean assertTrue(Object Actual, Object Expected) {

		// SoftAssert sAssert = new SoftAssert();
		try {
			Assert.assertTrue(Actual == Expected);

			// sAssert.assertAll();

			Log.pass("Assertion passed : " + Actual + " is equal to " + Expected);

			return true;
		}

		catch (AssertionError e) {

			Log.fail("Assertion failed : " + Actual + " is not equal to " + Expected);

			return false;
		}

	}

	/*************************************************************
	 * @author :Alok
	 * @Method_Name: collectBrowserJSerrorMessages
	 * @Description : This method will collect all JavaScript error messages present
	 *              in the opened URL.
	 * 
	 ***********************************************************/
	public static void collectBrowserJSerrorMessages() {

		// Below code will collect all f12 broswe console errors and flush to
		// log file.
		Log.pass(" Method to collect Browser console erros called...........");
		LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
		for (LogEntry entry : logEntries) {

			Log.pass(entry.getTimestamp() + " " + entry.getLevel() + " " + entry.getMessage());
		}
	}

	/*************************************************************
	 * @author :Alok
	 * @Method_Name: dismissAlertPopup
	 * @Description : This method will dismiss the alert pop up.
	 ***********************************************************/
	public static void dismissAlertPopup() {
		try {
			Alert alert = driver.switchTo().alert();
			alert.dismiss();
		} catch (NoAlertPresentException e) {
			Log.error("Error....." + e.getStackTrace());
		}
	}

	public void setImplicitWait(long timeOutInSeconds, TimeUnit unit) {

		Log.pass("Waiting for " + timeOutInSeconds + " seconds.");
		driver.manage().timeouts().implicitlyWait(timeOutInSeconds, unit);

	}

	/*************************************************************
	 * @author :Alok
	 * @Method_Name: getAlertPopupMessage.
	 * @Description :This method will retutn the alert pop up text message
	 * 
	 ***********************************************************/
	public static String getAlertPopupMessage() {
		try {
			Alert alert = driver.switchTo().alert();
			return alert.getText();
		} catch (NoAlertPresentException e) {
			Log.error("Error....." + e.getStackTrace());
			return null;
		}
	}

	/*************************************************************
	 * @author :Alok
	 * @Method_Name: getCurrentSystemDate.
	 * @Description :This method will returm current system date to the user.
	 * 
	 ***********************************************************/
	public static String getCurrentSystemDate() {
		DateFormat df = new SimpleDateFormat("MM/dd/YYYY");
		Date dateobj = new Date();
		return df.format(dateobj);
	}

	/*************************************************************
	 * @author :Alok
	 * @Method_Name: getTestDataFromExcel.
	 * @Description :This method will read data from excel sheet.
	 * @param: strSheetName- Excel sheet name.
	 * @param: strSheetPath- Absolute path of excel sheet.
	 ***********************************************************/
	public static Object[][] getTestDataFromExcel(String strSheetName, String strSheetPath) {

		Log.pass("********* Reading data from sheet: " + strSheetName);
		FileInputStream file = null;
		try {
			file = new FileInputStream(strSheetPath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		sheet = book.getSheet(strSheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				System.out.println(data[i][k]);
			}
		}
		return data;
	}

	/*************************************************************
	 * @author :Alok
	 * @Method_Name: switchToFrameByElement
	 * @Description : This method will be used to switch the driver to an iframe
	 *              using some element.
	 * @param: element- Element present in iframe.
	 ***********************************************************/
	public static boolean switchToFrameByElement(WebElement element) {
		boolean b = false;
		try {
			driver.switchTo().frame(element);
			b = true;
		} catch (Exception e) {
			Log.error("Error....." + e.getStackTrace());
			e.printStackTrace();
			b = false;
		}
		return b;
	}

	/*************************************************************
	 * @author :Alok
	 * @Method_Name: switchToFrameByIndex
	 * @Description : This method will switch to an iframe using its index.
	 * @param: nIframeIndex- Index of the iframe.
	 ***********************************************************/
	public static boolean switchToFrameByIndex(WebDriver driver, int nIframeIndex) {

		boolean b = false;
		try {
			driver.switchTo().frame(nIframeIndex);
			b = true;
		} catch (Exception e) {
			Log.error("Error....." + e.getStackTrace());
			b = false;
		}
		return b;
	}

	/*************************************************************
	 * @author :Alok
	 * @Method_Name: switchToFrameByNameOrID
	 * @Description : This method can switch the driver to an iframes using either
	 *              frame name of id.
	 * @param: strFrameIDOrName- iframe id or name.
	 ***********************************************************/
	public static boolean switchToFrameByNameOrID(String strFrameIDOrName) {
		boolean b = false;
		try {
			driver.switchTo().frame(strFrameIDOrName);
			// Log.pass("Switched to frame: " + strFrameIDOrName);
			b = true;
		} catch (Exception e) {

			// Log.error("Unable to switch to iframe ....." + strFrameIDOrName + " " +
			// e.getStackTrace());
			b = false;
		}
		return b;
	}

	/*************************************************************
	 * @author :Alok
	 * @Method_Name: waitForElemewntToBeClickable
	 * @Description : Waits for an element to be clickable.
	 * @param: element- element to wait for.
	 ***********************************************************/
	public static boolean waitForElemewntToBeClickable(WebElement element) {
		boolean b = false;
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(element));
		}

		catch (Exception e) {
			Log.error("Unable to wait for element : " + e.getStackTrace());
			e.printStackTrace();
			b = false;
		}
		return b;
	}

	/*************************************************************
	 * @author :Alok
	 * @Method_Name: FileWrite
	 * @Description : Property File Write
	 * @param: FileName- Complete path of file
	 * @param: ObName- Object to be write into the file
	 * @param: ObValue - Value of the Object written to the file
	 ***********************************************************/
	public static void FileWrite(String FileName, String ObName, String ObValue) {
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

			BufferedWriter out = new BufferedWriter(new FileWriter("c://output.txt"));

			String inputLine = null;
			do {
				inputLine = in.readLine();
				out.write(inputLine);
				out.newLine();
			} while (!inputLine.equalsIgnoreCase("eof"));
			System.out.print("Write Successful");
			out.close();
			in.close();
		} catch (IOException e1) {
			System.out.println("Error during reading/writing");
		}

	}

	public static boolean waitTillSaudiWaitIconDisappears() {
		boolean b = false;
		try {
			Thread.sleep(1000);
			FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(120, TimeUnit.SECONDS).pollingEvery(500, TimeUnit.MILLISECONDS).ignoring(NoSuchElementException.class);
			wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath(getObj("Propval1", "saudiWaitLogo", "Menues")))));
			b = true;
		}

		catch (Exception e) {

			// Log.error("In Visibility of element failed : " + e.getStackTrace());
			// Utils.logFailImage("Error");
			// throw e;
		}

		return b;
	}

	public static void scrollToElement(WebDriver driver, By elem) {
		// waitForElementVisibility(driver, elem);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(elem));
	}

	public static void moveToElement(By byElement) {

		new Actions(driver).moveToElement(driver.findElement(byElement)).build().perform();
	}

	public static void scrollDown(WebDriver driver) {
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0,2000)");
	}

	public static void scrollToBottom(WebDriver driver) throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(2000);
	}

	public static void horizontalScroll(WebDriver driver) throws InterruptedException {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		Thread.sleep(2000);
	}

	public static void verticalScroll(WebDriver driver) throws InterruptedException {

		((JavascriptExecutor) driver).executeScript("window.scrollBy(1000,0)");
	}

	/***
	 * @author Alok
	 * @Description This method will wait for a given seconds while polling every 2
	 *              seconds.
	 * @param timeOutInSeconds
	 */
	public static void waitForSeconds(int timeOutInSeconds) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
			wait.pollingEvery(2, TimeUnit.SECONDS);
			wait.ignoring(NoSuchElementException.class);
			wait.ignoring(ElementNotVisibleException.class);
			wait.ignoring(StaleElementReferenceException.class);
			wait.ignoring(NoSuchFrameException.class);
			logger.info("Waiting for " + timeOutInSeconds + " seconds");

		} catch (Exception e) {
			Log.error("Unable to wait ... Error : " + e.getStackTrace());
			e.printStackTrace();
		}
	}

	public static void wait(int timeinSeconds) {
		try {
			Utils.waitTillSaudiWaitIconDisappears();
			Thread.sleep(timeinSeconds * 1000);
			// logger.info("Waiting for " + timeInMiliSeconds + " seconds");

		} catch (Exception e) {
			Log.error("Unable to wait ... Error : " + e.getStackTrace());
			e.printStackTrace();
		}
	}

	public static WebElement findElement(By byElement) {

		try {
			globalElement = driver.findElement(byElement);
			return globalElement;
		} catch (Exception e) {
			Log.error("Unable to find element using x path : " + globalElement + " " + e.getStackTrace());
			return null;
		}

	}

	public static By findElementByLabel(String strLblName) {

		try {
			globalElement = driver.findElement(By.xpath("//*[contains(text(),'" + strLblName + "')]"));

			return By.xpath("//*[contains(text(),'" + strLblName + "')]");
		} catch (Exception e) {
			Log.error("Unable to find element using x path : " + globalElement + " " + e.getStackTrace());
			return null;
		}

	}

	public static boolean uploadImage(By byElement, String strImgName) {

		String strImgFullPath = System.getProperty("user.dir") + "\\src\\main\\resources\\TestData\\Images\\" + strImgName;
		try {
			driver.findElement(byElement).sendKeys(strImgFullPath);
			Log.pass("Successfully uploaded image : " + strImgName);
			return true;
		} catch (Exception e) {
			Log.error("Failed to upload image.." + strImgName + " " + e.getStackTrace());
			return false;
		}
	}

	/***
	 * @author Alok
	 * @Description This method wait for an element for 30 seconds polling every 2
	 *              seconds. can be used for those elements which appear/disappear
	 *              on the UI frequently.
	 * @param element
	 * @return
	 */
	public boolean waitForVisibilityOfEle(WebElement element) {
		try {
			FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(30, TimeUnit.SECONDS).pollingEvery(2, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
			wait.until(ExpectedConditions.visibilityOf(element));
			bResVal = true;
		} catch (Exception e) {
			Log.error("Element " + element + " was not visible :" + e.getStackTrace());
			bResVal = false;
		}
		return bResVal;
	}

	/***
	 * @author Alok
	 * @Description This method wait for an element for 30 seconds polling every 2
	 *              seconds. can be used for those elements which appear/disappear
	 *              on the UI frequently.
	 * @param element
	 * @return
	 */
	public static boolean waitForInVisibilityOfEle(By ByElement) {

		WebElement ele = null;
		try {
			ele = driver.findElement(ByElement);
			if (ele == null) {
				Log.info("Element is null.. unable to wait for invisibility..");
				bResVal = false;
			} else {
				FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(40, TimeUnit.SECONDS).pollingEvery(2, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
				wait.until(ExpectedConditions.invisibilityOf(ele));
				bResVal = true;
			}
		} catch (Exception e) {
			Log.info("Unable to wait for invisibility of element : " + e.getStackTrace());
			bResVal = false;
		}
		return bResVal;
	}

	/***
	 * @author Alok
	 * @Description This method will wait for a page to load for a given seconds of
	 *              time.
	 * @param pageLoadTimeOutInSeconds
	 * @return True- If page is loaded in given time. False- If page is not loaded
	 *         within given time.
	 */
	public static boolean waitForPageToLoad(int pageLoadTimeOutInSeconds) {

		Log.pass("Waiting for page to load within " + pageLoadTimeOutInSeconds + " seconds.");
		try {
			driver.manage().timeouts().pageLoadTimeout(pageLoadTimeOutInSeconds, TimeUnit.SECONDS);
			Log.pass("Page loaded successfully");
			bResVal = true;
		} catch (Exception e) {
			Log.error("Failed to load page within " + pageLoadTimeOutInSeconds + " seconds :" + e.getStackTrace());
			bResVal = false;
		}
		return bResVal;

	}

	/**
	 * @author Alok
	 * @Description This method will wait for the visibility of the given element
	 *              for a given time.
	 * @param element
	 * @param timeOutInSeconds
	 * @return Returns true if element is visible. Returns false if element is not
	 *         visible.
	 */
	public boolean waitUntilElementVisible(WebElement element, int timeOutInSeconds) {

		Log.pass("Waiting for : " + element.toString() + " to be visible in " + timeOutInSeconds + " seconds");
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
			wait.pollingEvery(2, TimeUnit.SECONDS);
			wait.ignoring(NoSuchElementException.class);
			wait.ignoring(ElementNotVisibleException.class);
			wait.ignoring(StaleElementReferenceException.class);
			wait.ignoring(NoSuchFrameException.class);
			wait.until(ExpectedConditions.visibilityOf(element));
			Log.pass(" Element " + element + " is visible");
			bResVal = true;
		} catch (Exception e) {
			Log.error(" Error occured while waiting for element :" + element + " " + e.getStackTrace());
			bResVal = true;
		}
		return bResVal;
	}

	/***
	 * @author Alok
	 * @Description This method will press ENTER key OR will thor exception if error
	 *              occurs.
	 * 
	 */
	public static void pressEnter() {
		try {
			Thread.sleep(2000);
			Actions actions = new Actions(driver);
			actions.sendKeys(Keys.ENTER).build().perform();
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

	public static void pressExcapeActions() {
		try {
			Thread.sleep(2000);
			Actions actions = new Actions(driver);
			actions.sendKeys(Keys.ESCAPE).build().perform();
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

	public static void pressKeyDown() {
		try {
			Thread.sleep(1000);
			Actions actions = new Actions(driver);
			actions.sendKeys(Keys.ARROW_DOWN).build().perform();
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

	public static boolean sendValDropdown(By element, String keyword, String... strFieldName) throws Exception {

		Actions KeyStrokes = new Actions(driver);
		WebElement ele = null;
		try {
			ele = driver.findElement(element);
			scrollIntoViewbyJS(ele);
			waitForVisibilityOfElement(ele);
			ele.click();
			ele.clear();
			ele.sendKeys(keyword);
			Thread.sleep(1000);
			KeyStrokes.sendKeys(Keys.ARROW_DOWN).build().perform();
			Thread.sleep(1000);
			KeyStrokes.sendKeys(Keys.ENTER).build().perform();

			Log.pass("Successfully entered data : " + keyword + "Into field " + strFieldName);
			runResult = true;
		} catch (Exception e) {
			Log.fail("Unable to selectdatas from DropDown : " + ExceptionUtils.getStackTrace(e));
			runResult = false;
			throw e;
		}
		return runResult;
	}

	public static void pressTab() {
		try {
			Actions actions = new Actions(driver);
			Thread.sleep(2000);
			actions.sendKeys(Keys.TAB).build().perform();
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

	public static void closeTab() {

		Actions action = new Actions(driver);
		action.sendKeys(Keys.CONTROL + "W").build().perform();
	}

	/***
	 * @author baj80000892/Alok Rai
	 * @param byElement byelement to which you need to click. Ideally the dropdown
	 *                  arrow down button locator
	 * @param index     the index in dropdown. e.g sending 3 will click the third
	 *                  value in dropdown.
	 */
	public static void selectByIndex(By byElement, int index) {

		try {

			// Utils.click(byElement);
			for (int i = 1; i <= index; i++) {

				actions.sendKeys(Keys.ARROW_DOWN).build().perform();
			}

			Utils.wait(2);
			actions.sendKeys(Keys.ENTER).build().perform();
			Log.pass("Successfully selected index no.   " + index + " in dropdown of element- " + byElement);
		}

		catch (Exception e) {

			Log.error("Unable to  select index no.   " + index + " in dropdown of element- " + byElement);
			e.printStackTrace();
		}

	}

	/***
	 * @author Alok
	 * @Description This method will generate a random number
	 * @return
	 */
	public static String generateNumber() {
		long i = (long) (Math.random() * 1000 + 3333300000L);
		return String.valueOf(i);
	}

	public static void setClipboardData(String string) {
		StringSelection stringSelection = new StringSelection(string);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
	}

	/***
	 * @author Alok
	 * @Description This method will switch the driver to new window from the old
	 *              one.
	 * @throws InterruptedException
	 */
	public static boolean waitForNewWindowAndSwitchToIt() throws InterruptedException {
		String cHandle = driver.getWindowHandle();
		String newWindowHandle = null;

		Set<String> allWindowHandles = driver.getWindowHandles();
		try {
			// Wait for 20 seconds for the new window and throw exception if not found
			for (int i = 0; i < 20; i++) {
				if (allWindowHandles.size() > 1) {
					for (String allHandlers : allWindowHandles) {
						if (!allHandlers.equals(cHandle))
							newWindowHandle = allHandlers;
					}
					driver.switchTo().window(newWindowHandle);
					bResVal = true;
					break;
				}
			}
			if (cHandle == newWindowHandle) {
				bResVal = false;
				throw new RuntimeException("Time out - No window found");
			}
		} catch (RuntimeException e) {
			Log.error(" No such window to switch to :" + e.getStackTrace());
			bResVal = false;
		}
		return bResVal;
	}

	/***
	 * @author Alok
	 * @Description This method will return the current window title;
	 * @param driver
	 * @return
	 */
	public static String getCurrentWindowTitle() {
		return driver.getTitle();
	}

	/***
	 * @author Alok
	 * @Description This method will perform broken links test. All URL links which
	 *              are not working will be caught here.
	 * @throws MalformedURLException
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public static void brokenLinksTest() throws MalformedURLException, IOException, InterruptedException {

		Log.pass(" Broken links test started for URL : " + driver.getCurrentUrl());
		List<WebElement> list = driver.findElements(By.tagName("a"));
		List<WebElement> ActiveLinks = new ArrayList<WebElement>();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getAttribute("href") != null) {
				ActiveLinks.add(list.get(i));
			}
		}
		Log.pass(" Active links across the whole application are: " + ActiveLinks.size());
		for (int j = 0; j < ActiveLinks.size(); j++) {
			try {
				HttpURLConnection connection = (HttpURLConnection) new URL(ActiveLinks.get(j).getAttribute("href")).openConnection();
				connection.connect();
				connection.disconnect();
				Log.pass("Opening URL: " + ActiveLinks.get(j).getAttribute("href") + ".....>" + connection.getResponseMessage());
			} catch (Exception e) {
				Log.fail(".......Broken links test failed for URL : " + ActiveLinks.get(j).getAttribute("href") + " \n " + e + " ..........");
				// eTest.log(LogStatus.FAIL, ".......Broken links test failed for URL : " +
				// ActiveLinks.get(j).getAttribute("href") + " \n " + e + " ..........");
			}
		}
	}

	/***
	 * @author Alok
	 * @Description This method will click on a given element. if element not
	 *              visible or not yet present in DOM ,then it will wait for 60
	 *              seconds before throwing an exception.
	 * @param element to click and element name to put in logs/reports.
	 * @return True- If element was found and clicked successfully. False- If
	 *         element was not clicked due to exception.
	 */
	public static boolean click(By element, String eleName, int... moreArgs) throws Exception {
		String elementName = null;
		WebElement webEle = null;
		int timOut = 1;
		int throwException = 1;
		boolean bFlag = false;

		try {
			timOut = moreArgs[0];
		} catch (Exception e) {
			timOut = g_nMaxWaitTime; // TestBase class has this info.
		}

		try {
			throwException = moreArgs[1];
		} catch (Exception e) {
			throwException = 1; // Will throw exception.
		}

		if (element == null) {
			Log.fail("Element object  xpath value is null.. Unable to locate element.. ");
			return false;
		}
		try {
			elementName = eleName; // eleName[0];
		} catch (Exception e) {
			elementName = element.toString();
		}
		try {
			Utils.waitTillSaudiWaitIconDisappears();
			FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(timOut, TimeUnit.SECONDS).pollingEvery(1, TimeUnit.SECONDS).ignoring(NoSuchElementException.class).ignoring(NullPointerException.class);
			wait.until(ExpectedConditions.visibilityOfElementLocated(element));
			wait.until(ExpectedConditions.elementToBeClickable(element));

			webEle = driver.findElement(element);
			scrollIntoViewbyJS(webEle);
			highlighElement(webEle);
			webEle.click();
			Utils.waitTillSaudiWaitIconDisappears();
			Log.pass("Successfully clicked element- " + elementName);
			// Utils.logPassImage(TCName+" Scenario Count- "+scenarioCount);
			bFlag = true;
		} catch (Exception e) {

			// Utils.logFailImage("Error");
			bFlag = false;
			if (throwException == 0) {
				// Do not throw exception as user as given 0 as 2nd parameter. Sometimes it is
				// not required
			} else {
				Log.fail("Unable to click element : " + elementName); // comment this if error comes twice in logs.
				Utils.logFailImage(TCName + " Scenario Count- " + scenarioCount);
				throw e;
			}
		}
		return bFlag;
	}

	/***
	 * @author Alok
	 * @Description This method will click on a given element. if element not
	 *              visible or not yet present in DOM ,then it will wait for 60
	 *              seconds before time out but will not throw any exception. To be
	 *              used in scenarios where you just want co click safely but do not
	 *              want it to throw any error.
	 * @param element to click and element name to put in logs/reports.
	 * @return True- If element was found and clicked successfully. False- If
	 *         element was not clicked due to exception.
	 */
	public static boolean clickSafely(By element, String eleName) {

		String elementName = null;
		WebElement webEle = null;
		int timOut = 1;
		boolean bFlag = false;

		if (element == null) {
			Log.fail("Element object  xpath value is null.. Unable to locate element.. ");
			return false;
		}
		try {
			elementName = eleName; // eleName[0];
		} catch (Exception e) {
			elementName = element.toString();
		}
		try {
			Utils.waitTillSaudiWaitIconDisappears();
			FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(timOut, TimeUnit.SECONDS).pollingEvery(1, TimeUnit.SECONDS).ignoring(NoSuchElementException.class).ignoring(NullPointerException.class);
			wait.until(ExpectedConditions.visibilityOfElementLocated(element));
			wait.until(ExpectedConditions.elementToBeClickable(element));

			webEle = driver.findElement(element);
			scrollIntoViewbyJS(webEle);
			highlighElement(webEle);
			webEle.click();
			Log.pass("Successfully clicked element- " + elementName);
			// Utils.logPassImage(TCName+" Scenario Count- "+scenarioCount);
			bFlag = true;

		} catch (Exception e) {

			// Log.info("Unable to click element : " + elementName);
			// Utils.logInfoImage(TCName + " Scenario Count- " + scenarioCount);

		}
		return bFlag;
	}

	/***
	 * @author Alok
	 * @description This method will show a custom alert to the user with the given
	 *              text and alert will be closed after 2 seconds.
	 * @param alertMessage
	 * @throws InterruptedException
	 */
	public static void customAlertByJS(String alertMessage)   {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("alert('" + alertMessage + "')");
			Thread.sleep(8000);
			driver.switchTo().alert().accept();
		} catch (Exception e) {
			// No action
		}

	}

	/***
	 * @author Alok
	 * @description This method will draw blue border around a given element.
	 * @param element
	 */
	public static void drawborder(WebElement element) {
		js.executeScript("arguments[o].style.border='3px solid blue'", element);

	}

	/***
	 * @author Alok
	 * @description This method will get text of an element.
	 * @param firstname
	 * @return the String value found.
	 */
	public static String getText(By ByElement) {
		WebElement element = null;

		try {
			Utils.waitTillSaudiWaitIconDisappears();

			FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(20, TimeUnit.SECONDS).pollingEvery(500, TimeUnit.MILLISECONDS).ignoring(NoSuchElementException.class);
			wait.until(ExpectedConditions.visibilityOfElementLocated(ByElement));

			element = driver.findElement(ByElement);

			if (element == null) {
				Log.fail("Element is null.... unable to get text");
				return "No value found";
			} else {
				scrollIntoViewbyJS(element);
				waitForVisibilityOfElement(element);
				element.getText();
				Log.pass("Message displayed on screen is : " + element.getText());
				return element.getText();
			}
		} catch (Exception e) {
			Log.fail("Unable to get message on screen using object locator  : " + ByElement.toString() + " " + ExceptionUtils.getStackTrace(e));
			Utils.logFailImage("Error");
			return "No value found";
		}
	}

	/***
	 * @author Alok
	 * @description This method will get text of an element.
	 * @param firstname
	 * @return the String value found.
	 */
	public static String getTextNoException(By ByElement) {
		WebElement element = null;

		try {
			FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(20, TimeUnit.SECONDS).pollingEvery(500, TimeUnit.MILLISECONDS).ignoring(NoSuchElementException.class);
			wait.until(ExpectedConditions.visibilityOfElementLocated(ByElement));

			element = driver.findElement(ByElement);
			scrollIntoViewbyJS(element);
			waitForVisibilityOfElement(element);
			return element.getText();
		} catch (Exception e) {
			return "";
		}
	}

	/***
	 * @author Alok
	 * @description This method will highlight the given element in gold color.
	 * @param element
	 */
	public static void highlighElement(WebElement element) {
		js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].style.background='Magenta'", element);

	}

	public static void refreshScreeen() {

		driver.navigate().refresh();
		Utils.wait(3);
	}

	public static String DateValue(int DateValue) {
		String CurrentDate = null;
		final DateFormat dateFormat = new SimpleDateFormat("dd/MM/YYYY");
		Calendar calendar = Calendar.getInstance();

		calendar.add(Calendar.DATE, DateValue);
		Date tomorrow = calendar.getTime();

		CurrentDate = dateFormat.format(tomorrow).toString();

		Log.pass("Future Date : " + CurrentDate);

		return CurrentDate;

	}

	public static boolean sendKeysIfPresent(By element, String keyword, String... strElementName) {

		boolean b = false;
		WebElement WebElement = null;
		String eleName = null;

		try {
			eleName = strElementName[0];

		} catch (Exception e) {
			eleName = element.toString();
		}

		try {
			if (Utils.getSize(element) > 0) {

				try {

					FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(3, TimeUnit.SECONDS).pollingEvery(500, TimeUnit.MILLISECONDS).ignoring(NoSuchElementException.class);
					wait.until(ExpectedConditions.visibilityOfElementLocated(element));
					wait.until(ExpectedConditions.elementToBeClickable(element));
					WebElement = driver.findElement(element);

					scrollIntoViewbyJS(WebElement);
					// waitForVisibilityOfElement(WebElement);
					try {
						WebElement.click();
						WebElement.clear();
					} catch (Exception e) {
						// No action needed
					}
					highlighElement(WebElement);
					WebElement.sendKeys(keyword);
					Thread.sleep(1000);

					Log.pass("Successfully Entered data [ " + keyword + " ] into field : " + eleName);
					b = true;

				} catch (Exception e) {
					// Log.fail("Unable to send data to element : " + eleName + " " +
					// ExceptionUtils.getStackTrace(e));
					// Utils.logFailImage("Error");
					// b = false;
				}

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		}
		return b;

	}

	/***
	 * @author Alok
	 * @description This method will check whether and element is displayed on UI or
	 *              not.
	 * @param element
	 * @return True- If element is displayed. False- If element is not displayed on
	 *         UI.
	 */
	public boolean isElementDisplayed(WebElement element) {

		return element.isDisplayed();

	}

	/***
	 * @author Alok
	 * @description This method will assert whether an element is displayed on
	 *              screen or not.
	 * @param element
	 * @return True- If element is displayed. False- If element is not displayed.
	 * @throws InterruptedException
	 */
	public static boolean assertDisplayed(By element, String strElemName) {

		try {
			Utils.waitForVisibilityOfElement(driver.findElement(element));
			WebElement webEle = driver.findElement(element);
			Utils.scrollIntoViewbyJS(webEle);
			Utils.highlighElement(webEle);
			Assert.assertTrue(webEle.isDisplayed());
			Log.pass(strElemName + " is displayed on screen");
			bResVal = true;
		} catch (AssertionError | Exception e) {
			Log.pass(strElemName + " is not displayed on screen ");
			bResVal = false;
		}
		return bResVal;
	}

	/***
	 * @author Alok
	 * @description This method will assert whether an element is displayed on
	 *              screen or not.
	 * @param element
	 * @return True- If element is displayed. False- If element is not displayed.
	 * @throws InterruptedException
	 */
	public static boolean assertDisplayedWithException(By element, String strElemName) throws AssertionError, Exception {

		try {
			Utils.waitForVisibilityOfElement(driver.findElement(element));
			WebElement webEle = driver.findElement(element);
			Utils.scrollIntoViewbyJS(webEle);
			Utils.highlighElement(webEle);
			Assert.assertTrue(webEle.isDisplayed());
			Log.pass(strElemName + " is successfully displayed on screen.");
			Utils.logPassImage(TCName + "  " + strElemName);
			bResVal = true;
		} catch (AssertionError | Exception e) {
			Log.fail(strElemName + " is not displayed on screen ");
			Utils.logFailImage(TCName + "  " + strElemName);
			bResVal = false;
			throw e;
		}
		return bResVal;
	}

	/***
	 * @author Alok
	 * @description This method will check whether a given file is downloaded into a
	 *              given directory or not.
	 * @param          downloadPath,fileName.
	 * @param fileName
	 * @return True- If file is downloaded. False- If file is not downloaded.
	 */
	public static boolean isFileDownloaded(String downloadPath, String fileName) {
		boolean b = false;
		try {

			File dir = new File(downloadPath);
			File[] dir_contents = dir.listFiles();

			for (int i = 0; i < dir_contents.length; i++) {
				if (dir_contents[i].getName().contains(fileName) == true) {
					b = true;

					Log.pass("File " + fileName + " downloaded successfully");
					break;
				}

			}
			b = false;

			Log.error("File " + fileName + " download failed");

		} catch (Exception e) {

			b = false;

			Log.error("File " + fileName + " download failed");
		}

		return b;
	}

	/***
	 * @author Alok
	 * @description This method will click on a given element using javascript.
	 * @param driver
	 * @param element
	 */
	public static void clickByJS(By element1) {

		WebElement element = driver.findElement(element1);

		try {
			if (element.isEnabled() && element.isDisplayed()) {
				Utils.scrollIntoViewbyJS(element);
				((JavascriptExecutor) driver).executeScript("arguements[0].click(, arg1);", element);
			}
		} catch (Exception e) {
			Log.error("Error....." + e.getStackTrace());
		}
	}

	/***
	 * @author Alok
	 * @descriptiopn Thi smethod will scroll to a given element using javascript.
	 * @param element
	 */
	public static void scrollIntoViewbyJS(WebElement element) {

		js.executeScript("arguments[0].scrollIntoView(true);", element);
		// Log.pass(" Scrolled to...." + element);
	}

	public static void scrollIntoViewAndClick(By element1) {
		WebElement element = null;
		try {

			element = driver.findElement(element1);
			js.executeScript("arguments[0].scrollIntoView(true)", element);
			Thread.sleep(2000);
			element.click();
			Log.pass(" Scrolled to  " + element + " and clicked");
		}

		catch (Exception e) {

			Log.error(" Unable to click " + element + " " + e);
		}

	}

	public static void scrollToElement(WebDriver driver, WebElement element) {

		Point location = element.getLocation();
		js.executeScript("javascript:window.scrollBy(0," + location.y + ")");

	}

	public static boolean selectByIndex(int index, WebElement element) {
		boolean b = false;
		try {
			Select s = new Select(element);
			s.selectByIndex(index);
			Log.pass("Selected element by index :" + index);
		} catch (Exception e) {

			Log.error("Unable to select the element by index : " + element.toString());
			b = false;
		}
		return b;
	}

	public static boolean selectByName(String name, WebElement element) {
		boolean b = false;
		try {
			Select s = new Select(element);
			s.selectByVisibleText(name);
			Log.pass("Selected element --" + name);
			b = true;
		}

		catch (Exception e) {

			Log.error("Unable to select the element : " + element.toString());
			b = false;
		}
		return b;
	}

	/**
	 * @author Alok
	 * @Description This method will run auto IT script present at a given path.
	 * @param strAutoItExePath
	 * @return true if script is run successfully. False if script threw some error.
	 */
	public static boolean runAutoITScript(String strAutoItExePath) {

		try {
			Thread.sleep(2000);
			Runtime.getRuntime().exec(strAutoItExePath);
			Log.pass("Auto IT script run successfully ");
			bResVal = true;
		} catch (Exception e) {
			Log.error("Failed to run auto IT script : " + strAutoItExePath + " " + e.getStackTrace());
			bResVal = false;
		}
		return bResVal;
	}

	/***
	 * @author Alok
	 * @description This method will clear the text present in an input field.
	 * @param element
	 * @return True- If clear field is successfull. False- If clear field process
	 *         encounters some exception.
	 */
	public static boolean clearField(WebElement element) {

		try {
			scrollIntoViewbyJS(element);
			waitForVisibilityOfElement(element);
			element.click();
			element.clear();
			Log.pass("Cleared field " + element.toString() + " " + "successfully");
			return true;
		}

		catch (Exception e) {
			Log.error("Unable to clear field : " + element.toString() + " " + e.getStackTrace());
			Utils.logFailImage("Error");
			return false;
		}

	}

	/***
	 * @author Alok
	 * @description This method will upload a selected file using robot class.To be
	 *              used for uploading files.
	 * @param path
	 * @return True- If upload is successfull. False- If upload process encounters
	 *         some exception.
	 * @throws AWTException
	 */
	public static boolean selectUploadFilebyRobot(String path) throws AWTException {

		try {
			Log.pass(" Selecting file using robot class");
			Robot robot = new Robot();
			StringSelection selection = new StringSelection(path);
			Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
			clipboard.setContents(selection, selection);

			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);

			Log.pass("File selected using Robot from the path :- " + path.toString().toUpperCase());
			return true;
		}

		catch (Exception e) {

			Log.error("Unable to upload file ...." + e.getStackTrace());
			return false;
		}

	}

	/**
	 * @author Alok Rai
	 * @param element - Element to which data needs to be entered.
	 * @param         keyword- The data which needs to be sent to the element.
	 * @throws Exception- Throws exception when any of the step fails.
	 */
	public static boolean sendKeys1(By element, String keyword, String... strElementName) throws Exception {

		boolean b = false;
		WebElement WebElement = null;
		String elementName = null;

		if (element == null) {

			Log.error("Element element object path is null.. Unable to locate element.. Check if x path is correctly given in object files.");
			return b;
		}
		try {
			elementName = strElementName[0];
		} catch (Exception e) {

			elementName = element.toString().substring(element.toString().indexOf("->") + 1);
		}
		try {
			FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(40, TimeUnit.SECONDS).pollingEvery(2, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
			wait.until(ExpectedConditions.visibilityOfElementLocated(element));
			wait.until(ExpectedConditions.elementToBeClickable(element));
			WebElement = driver.findElement(element);

			if (WebElement == null) {

				Log.error(" Element is null..........Unable to locat element to send data. Waited for 40 seconds. ");
				return b;
			} else {

				scrollIntoViewbyJS(WebElement);
				// waitForVisibilityOfElement(WebElement);
				WebElement.click();
				try {
					WebElement.clear();
				} catch (Exception e) {
				}
				highlighElement(WebElement);
				WebElement.sendKeys(keyword);
				Thread.sleep(1000);
				// WebElement.sendKeys(Keys.TAB);

				Log.pass("Successfully Entered data [ " + keyword + " ] into field : " + elementName);
				b = true;
			}
		} catch (Exception e) {
			Log.error("Unable to send data to element : " + ExceptionUtils.getStackTrace(e));
			e.printStackTrace();
			b = false;
			throw e;
		}
		return b;
	}

	/**
	 * @author Alok Rai
	 * @param element - Element to which data needs to be entered.
	 * @param         keyword- The data which needs to be sent to the element.
	 * @throws Exception- Throws exception when any of the step fails.
	 */
	public static boolean sendKeys(By element, String keyword, String... strElementName) throws Exception {

		boolean flag = false;
		WebElement WebElement = null;
		String elementName = null;

		if (element == null) {

			Log.error("Element element object path is null.. Unable to locate element.. Check if x path is correctly given in object files.");
			return flag;
		}
		try {
			elementName = strElementName[0]; // strElementName;
		} catch (Exception e) {

			elementName = element.toString().substring(element.toString().indexOf("->") + 1);
		}
		try {
			FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(40, TimeUnit.SECONDS).pollingEvery(1, TimeUnit.NANOSECONDS).ignoring(NoSuchElementException.class);
			wait.until(ExpectedConditions.visibilityOfElementLocated(element));
			wait.until(ExpectedConditions.elementToBeClickable(element));
			WebElement = driver.findElement(element);

			if (WebElement == null) {

				Log.fail(" Element is null..........Unable to locat element to send data. Waited for 40 seconds. ");
				return flag;
			} else {

				scrollIntoViewbyJS(WebElement);
				// waitForVisibilityOfElement(WebElement);
				WebElement.click();
				try {
					WebElement.clear();
				} catch (Exception e) {
				}
				highlighElement(WebElement);
				WebElement.sendKeys(keyword);
				// Thread.sleep(1000);
				// WebElement.sendKeys(Keys.TAB);

				Log.pass("Successfully Entered data [ " + keyword + " ] into field : " + elementName);
				flag = true;
			}
		} catch (Exception e) {
			Log.fail("Unable to send data to element : " + ExceptionUtils.getStackTrace(e));
			Utils.logFailImage("Error");
			e.printStackTrace();
			flag = false;
			throw e;
		}
		return flag;
	}

	/***
	 * @author Alok
	 * @description This method will send given string to a given element using
	 *              actions class. To be used when normal selenium sendkeys is not
	 *              working.
	 * @param element
	 * @param keyword
	 * @return
	 */
	public static boolean sendkeysActions(WebElement element, String keyword) {
		boolean b = false;
		try {
			Actions action = new Actions(driver);
			action.moveToElement(element);
			action.click(element);
			// element.clear();
			action.sendKeys(keyword);
			action.build().perform();

			String fullString = element.toString();
			String subString = fullString.substring(fullString.indexOf("->") + 1);

			Log.pass(" Send data [ " + keyword + " ] to element : " + subString.trim());
			b = true;
		}

		catch (Exception e) {

			Log.error("Unable to send data to field : " + element.toString());
			b = false;
		}
		return b;
	}

	/***
	 * @author Alok
	 * @description This method will switch the driver default content.
	 * @return
	 */
	public static boolean switchToDefaultContent() {
		try {
			driver.switchTo().defaultContent();
			Log.pass(" Switching to default window ");
			return true;
		} catch (Exception e) {
			Log.error("Unable to switch to default content :" + e.getStackTrace());
			return false;
		}
	}

	/**
	 * @author baj80000892/Alok Rai
	 * @Description This method will close all the tabs opened except the first one.
	 * @return true- if operation is successfull. False- If operation throws eome
	 *         error.
	 */
	public static boolean closeOtherTabs() {

		try {
			String originalHandle = driver.getWindowHandle();

			for (String handle : driver.getWindowHandles()) {
				if (!handle.equals(originalHandle)) {
					driver.switchTo().window(handle);
					driver.close();
				}
			}
			driver.switchTo().window(originalHandle);
			Log.pass("Successfully closed all window tabs except the main one.");
			return true;
		}

		catch (Exception e) {
			Log.fail("Unable to close window tabs except the main tab...error.. ." + ExceptionUtils.getStackTrace(e));
			return false;
		}
	}

	/***
	 * @author Alok
	 * @description This method will swicth the driver focus to a given frame by its
	 *              id.
	 * @param id
	 * @return True- If switch is successfull. False- If switch is not successfull.
	 */
	public boolean switchToFrameById(String id) {

		boolean b = false;
		try {

			driver.switchTo().frame(id);
			Log.pass("Switching to frame : " + id);
			b = true;

		} catch (Exception e) {
			Log.error("Error....." + e.getStackTrace());
			b = false;
		}

		return b;
	}

	/***
	 * @author Alok
	 * @description This method will switch the driver focus to most recently opened
	 *              browser tab/window.Useful where a test case execution causes
	 *              various links to be clicked and tabs to be opened as a
	 *              consequence.
	 * @return True- If switch is succesful. False- If switch is not successful.
	 */
	public static boolean switchToNextTab() {

		Utils.wait(3);

		try {
			Set<String> windows = driver.getWindowHandles();
			Iterator<String> itr = windows.iterator();
			ArrayList<String> ids = new ArrayList<String>();
			while (itr.hasNext()) {
				ids.add(itr.next());
			}
			windowCount++;
			driver.switchTo().window(ids.get(windowCount));
			System.out.println("Switched to tab/window : " + ids.get(windowCount));
			bResVal = true;
		} catch (Exception e) {
			System.out.println("unable to switch to new tab/window : " + e.getStackTrace());
			bResVal = false;
		}
		return bResVal;
	}

	/***
	 * @author Alok
	 * @description This method will switch the driver focus to most recently opened
	 *              browser tab/window.Useful where a test case execution causes
	 *              various links to be clicked and tabs to be opened as a
	 *              consequence.
	 * @return True- If switch is succesful. False- If switch is not successful.
	 */
	public static boolean switchToMainTab() {

		Utils.wait(3);

		try {
			Set<String> windows = driver.getWindowHandles();
			Iterator<String> itr = windows.iterator();
			ArrayList<String> ids = new ArrayList<String>();
			while (itr.hasNext()) {
				ids.add(itr.next());
			}
			windowCount++;
			driver.switchTo().window(ids.get(windowCount - 1));
			System.out.println("Switched to tab/window : " + ids.get(windowCount - 1));
			bResVal = true;
		} catch (Exception e) {
			System.out.println("unable to switch to new tab/window : " + e.getStackTrace());
			bResVal = false;
		}
		return bResVal;
	}

	/***
	 * @author Alok
	 * @description This method will take screenshot of the screen only for a given
	 *              height and width for a given element.
	 * @param element
	 * @throws IOException
	 */
	public static void takePartialScreenShot(WebElement element) throws IOException {

		// String screenShot = System.getProperty("user.dir") + "\\screenShot.png";

		File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		Point p = element.getLocation();

		int width = element.getSize().getWidth();
		int height = element.getSize().getHeight();

		BufferedImage img = ImageIO.read(screen);

		BufferedImage dest = img.getSubimage(p.getX(), p.getY(), width, height);

		ImageIO.write(dest, "png", screen);

		// Files.copy(screen, new File(screenShot)); to do
	}

	/***
	 * @author Alok
	 * @description This method will take screenshot when called.Usually used by
	 *              extent report for adding screenshots to report after a test
	 *              method is executed.
	 * @param methodName
	 * @return True- If screenshot is taken and saved successfully.False- If some
	 *         exception occurs while taking and copying screenshot..
	 */
	public static String takeScreenShot(String methodName) {

		try {
			Utils.wait(2);
			String DestFileDir = null;
			// driver.manage().window().maximize();
			Calendar calendar = Calendar.getInstance();
			SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
			String destFileName = TCName + " " + scenarioCount + " " + formater.format(calendar.getTime());

			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

			DestFileDir = filePath + methodName + destFileName + ".png";
			Files.copy(scrFile.toPath(), new File(DestFileDir).toPath());
			// Log.pass("***Placed screen shot in " + filePath + " ***");

			return DestFileDir;
		} catch (Exception e) {

			e.printStackTrace();
			return null;

		}
	}

	/***
	 * @description This method can be used to take image of the screen as pass
	 *              status when called.
	 * @param imgName
	 * @author baj80000892/Alok Rai
	 */
	public static void logPassImage(String imgName) {
		try {
			Utils.wait(2);
			String screenshot = Utils.takeScreenShot(imgName + " " + "Scenario Count   " + scenarioCount + "  Pass");
			String image = eTest.addScreenCapture(screenshot);
			eTest.log(LogStatus.PASS, image);
		}

		catch (Exception e) {
			Log.fail("Unable to take pass image.. error.." + ExceptionUtils.getStackTrace(e));
		}

	}

	/***
	 * @description This method can be used to take image of the screen as info
	 *              status when called.
	 * @param imgName
	 * @author baj80000892/Alok Rai
	 */
	public static void logInfoImage(String imgName) {
		try {
			Utils.wait(2);
			String screenshot = Utils.takeScreenShot(imgName + " " + "Scenario Count : " + ScenarioCount + " - Info");
			String image = eTest.addScreenCapture(screenshot);
			eTest.log(LogStatus.INFO, image);
		}

		catch (Exception e) {
			Log.fail("Unable to take pass image.. error.." + ExceptionUtils.getStackTrace(e));
		}

	}

	/***
	 * @description This method can be used to take image of the screen as fail
	 *              status when called.
	 * @param imgName
	 * @author baj80000892/Alok Rai
	 */

	public static void logFailImage(String imgName) {
		try {
			Utils.wait(2);
			String screenshot = Utils.takeScreenShot(imgName + " " + "Scenario Count - " + ScenarioCount + " - Fail");
			String image = eTest.addScreenCapture(screenshot);
			eTest.log(LogStatus.FAIL, image);
		}

		catch (Exception e) {
			Log.fail("Unable to take fail image.. error.." + ExceptionUtils.getStackTrace(e));
		}

	}

	public static void logWarnImage(String imgName) {
		try {
			Utils.wait(2);
			String screenshot = Utils.takeScreenShot(imgName);
			String image = eTest.addScreenCapture(screenshot);
			eTest.log(LogStatus.WARNING, image);
		}

		catch (Exception e) {
			Log.fail("Unable to take fail image.. error.." + ExceptionUtils.getStackTrace(e));
		}

	}

	/***
	 * @author Alok
	 * @description This method will take screenshot of pages where there is
	 *              vertical scroll bar or page height is such that in one screen it
	 *              will not fit. Hence this method will keep scrolling the page
	 *              downwards and taking screenshot.e.g shopping websites like
	 *              amazon and flipkart.
	 * @param methodName - Current executing method name.
	 * @return
	 * @throws IOException
	 * @return True- If screenshot is successfully taken and copied to goven
	 *         directory. False- If some exception occurs during the entire process.
	 */
	/*
	 * public static boolean takeScreenShotByAShotUtility(String methodName) throws
	 * IOException {
	 * 
	 * 
	 * try { Calendar calendar = Calendar.getInstance(); SimpleDateFormat formater =
	 * new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss"); String destFileNameTime =
	 * formater.format(calendar.getTime()); String DestFileName = methodName +
	 * destFileNameTime + ".png"; // screen will be scrolled and captured Screenshot
	 * screenshot = new
	 * AShot().shootingStrategy(ShootingStrategies.viewportPasting(100))
	 * .takeScreenshot(driver); // To save the screenshot in desired location
	 * ImageIO.write(screenshot.getImage(), "PNG", new
	 * File(System.getProperty("user.dir") + "\\screenshots\\" + DestFileName));
	 * Log.pass("***Placed screen shot in " + filePath + " ***"); bResVal = true; }
	 * catch (Exception e) { Log.error("Unable to take screenshot :" +
	 * e.getStackTrace()); bResVal = false; } return bResVal;
	 * 
	 * }
	 */
	public static long compareDates() throws Exception {

		final String createdDate = "10/17/2018";
		final String closeDate = "11/16/2018";

		String date1inddmm = createdDate.substring(3, 5) + createdDate.substring(0, 2) + createdDate.substring(6, 10);

		String date2inddmm = closeDate.substring(3, 5) + " " + closeDate.substring(0, 2) + " " + closeDate.substring(6, 10);

		Date Date1 = new SimpleDateFormat("dd/mm/yyyy", Locale.ENGLISH).parse(date1inddmm.toString());
		Date Date2 = new SimpleDateFormat("dd/mm/yyyy", Locale.ENGLISH).parse(date2inddmm);

		long diffInDays = TimeUnit.MILLISECONDS.toDays(Date2.getTime() - Date1.getTime());

		return diffInDays;
	}

	public static void clickValueInDropdown(By element, String Value) {

		try {
			Thread.sleep(1000);

			List<WebElement> options = driver.findElements(element);
			for (WebElement option : options) {
				if (option.getText().equals(Value)) {
					option.click();
					// Thread.sleep(2000);
					// option.sendKeys(Keys.TAB);
					Log.pass("Selected value.. " + option.getText());
				}
			}
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

	}

	public static void clickFristValueInDropdown() {

		try {
			Thread.sleep(1000);
			Actions ac = new Actions(driver);
			ac.sendKeys(Keys.ARROW_DOWN).build().perform();
			ac.sendKeys(Keys.ENTER).build().perform();
			Thread.sleep(1000);
			Log.pass("Selected frist value in dropdown");

		} catch (InterruptedException e) {

			e.printStackTrace();
		}

	}

	/***
	 * @author Alok
	 * @Description - This method will take By element and string as argument and
	 *              pass the string data to the given element.
	 * @param ByElement- By locator of the element on the UI
	 * @param charLength- String which we need to send as inut.
	 */
	/*
	 * public static void sendCharsToElement(By ByElement, String charLength) {
	 * 
	 * try { Utils.sendKeys(ByElement, charLength); } catch (Exception e) {
	 * Log.error("Unable to enter " + charLength.length() +
	 * " character size data to element.." + globalElement + " " +
	 * e.getStackTrace()); e.printStackTrace(); }
	 * 
	 * }
	 */

	/***
	 * @Description this method can be used to open a url as per requirement.
	 * @param strUrl - the URL which user needs to b eopened by driver object.
	 */
	public static void OpenUrl(String strUrl) {

		try {

			driver.get(strUrl);
			Utils.wait(4);
			Log.pass("Opened URL :" + strUrl.trim());

		} catch (Exception e) {

			Log.error("Uanble to open Url :" + strUrl + " " + e.getStackTrace());
		}

	}

	/***
	 * @description this method can be used to select values in the dropdown fields
	 *              like acc number, gender etc. Here this method will first click
	 *              on the dropdown link and then enter the value to the field.
	 * @param byElementDropdown by Element of the dropdown arrow.
	 * @param byElementInput    byElement of the input field adjacent to the
	 *                          dropdown.
	 * @param strValue          value which needs to be entered into the field.
	 * @throws Exception throws exception in case of issues. Calling method must
	 *                   handle this exception or throw forward.
	 */
	public static void clickDropdownAndSendValue(By byElementDropdown, By byElementInput, String strValue, String... fieldName) throws Exception {

		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(15, TimeUnit.SECONDS).pollingEvery(500, TimeUnit.MILLISECONDS).ignoring(NoSuchElementException.class).ignoring(NullPointerException.class);
		String finalFieldName = null;

		try {
			finalFieldName = fieldName[0];
		} catch (Exception e) {
			finalFieldName = byElementInput.toString();
		}

		try {

			wait.until(ExpectedConditions.visibilityOf(driver.findElement(byElementDropdown)));
			// Utils.click(byElementDropdown, "", 5);
			driver.findElement(byElementDropdown).click();
			try {
				driver.findElement(byElementDropdown).clear();
			} catch (Exception e) {
			}

			Utils.pressTab();
			driver.findElement(byElementInput).clear();
			driver.findElement(byElementInput).sendKeys(strValue);
			Utils.pressKeyDown();
			Utils.pressEnter();
			Log.pass("Successfully sent value :  ' " + strValue + " '  to field :  " + finalFieldName);

		} catch (Exception e) {

			Log.pass("Unable to send value : " + strValue + " to field : ' " + finalFieldName + "  '" + "Retrying..");

			driver.findElement(byElementInput).click();
			Utils.pressTab();
			driver.findElement(byElementInput).sendKeys(strValue);
			Utils.pressKeyDown();
			Utils.pressEnter();

		}

	}

	public static boolean sendKeysForException(By element, String keyword, String... strElementName) throws Exception {

		boolean b = false;
		WebElement WebElement = null;
		String elementName = null;

		if (element == null) {

			Log.error("Element element object path is null.. Unable to locate element.. Check if x path is correctly given in object files.");
			return b;
		}
		try {
			elementName = strElementName[0];
		} catch (Exception e) {

			elementName = element.toString().substring(element.toString().indexOf("->") + 1);
		}
		try {
			FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(20, TimeUnit.SECONDS).pollingEvery(2, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
			wait.until(ExpectedConditions.visibilityOfElementLocated(element));
			wait.until(ExpectedConditions.elementToBeClickable(element));
			WebElement = driver.findElement(element);

			if (WebElement == null) {

				Log.error(" Element is null..........Unable to locat element to send data. Waited for 40 seconds. ");
				return b;
			} else {

				scrollIntoViewbyJS(WebElement);
				// waitForVisibilityOfElement(WebElement);
				WebElement.click();
				try {
					WebElement.clear();
				} catch (Exception e) {
				}
				highlighElement(WebElement);
				WebElement.sendKeys(keyword);
				Thread.sleep(1000);
				WebElement.sendKeys(Keys.TAB);

				Log.pass("Successfully Entered data [ " + keyword + " ] into field : " + elementName);
				b = true;
			}
		} catch (Exception e) {
			Log.error("Unable to send data to element : " + ExceptionUtils.getStackTrace(e));
			e.printStackTrace();
			b = false;
			throw e;
		}
		return b;
	}

	public static Map<String, Object> getUiData(Object json) throws JSONException {

		if (json instanceof JSONObject)
			return _jsonToMap_((JSONObject) json);

		else if (json instanceof String) {
			JSONObject jsonObject = new JSONObject((String) json);
			return _jsonToMap_(jsonObject);
		}
		return null;
	}

	/***
	 * @author baj80000892/Alok Rai
	 * @description the methods below will be used to convert String format json
	 *              data into map and return the map Object.
	 * @param json
	 * @return Map Object containing Key and values.
	 * @throws JSONException
	 */

	private static Map<String, Object> _jsonToMap_(JSONObject json) throws JSONException {
		Map<String, Object> retMap = new HashMap<String, Object>();

		if (json != JSONObject.NULL) {
			retMap = toMap(json);
		}
		return retMap;
	}

	private static Map<String, Object> toMap(JSONObject object) throws JSONException {
		Map<String, Object> map = new HashMap<String, Object>();

		Iterator<String> keysItr = object.keys();
		while (keysItr.hasNext()) {
			String key = keysItr.next();
			Object value = object.get(key);

			if (value instanceof JSONArray) {
				value = toList((JSONArray) value);
			}

			else if (value instanceof JSONObject) {
				value = toMap((JSONObject) value);
			}
			map.put(key, value);
		}
		return map;
	}

	public static List<Object> toList(JSONArray array) throws JSONException {
		List<Object> list = new ArrayList<Object>();
		for (int i = 0; i < array.length(); i++) {
			Object value = array.get(i);
			if (value instanceof JSONArray) {
				value = toList((JSONArray) value);
			}

			else if (value instanceof JSONObject) {
				value = toMap((JSONObject) value);
			}
			list.add(value);
		}
		return list;
	}

	public static String getAttributeValue(By byElement, String string) {

		try {
			Utils.waitForPageToLoad(20);
			return driver.findElement(byElement).getAttribute(string);
		}

		catch (Exception e) {
			return "No Value";
		}

	}
}
