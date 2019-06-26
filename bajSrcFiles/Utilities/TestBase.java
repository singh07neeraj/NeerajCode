package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import javaMain.common_Functions.AppData;

public class TestBase {

	public static Object[] dataset;
	public static boolean isMasterClassRun = true;
	public static int Totalcounts = 0;
	public static String log4jPropertyFilePath = System.getProperty("user.dir") + "\\bajSrcFiles\\resources\\extras\\log4j.properties";
	public static String g_strDownloadPath = System.getProperty("user.dir") + "\\bajSrcFiles\\resources\\extras\\Downloads";
	public static String g_objFilePath = System.getProperty("user.dir") + "\\bajSrcFiles\\resources\\extras\\obj.xml";
	public static String dynamicXmlPath = null;
	public static String g_appConfigXmlPath = System.getProperty("user.dir") + "\\bajSrcFiles\\resources\\extras\\appConfig.xml";

	public static Exception gException;
	public static String[] Args = null;
	public static String SC;
	public static int Totalcount = 0;
	public static String TCName = null;
	public static int scenarioCount = 1;
	public static String ScenarioCount = null;
	public final static Logger logger = Logger.getLogger(TestBase.class.getName());
	public static ExtentReports extentReport;
	public static ExtentTest eTest;
	public static Properties prop;
	public FileInputStream fis = null;
	public static int DatatableRow;
	protected static String chromeDriverPath = System.getProperty("user.dir") + "\\extJarsNDrivers\\Chromedriver\\chromedriver.exe";
	static String gerkoDriverPath = System.getProperty("user.dir") + "\\extJarsNDrivers\\drivers\\geckodrivers\\geckodriver64.exe";
	static String IEDriverPath = System.getProperty("user.dir") + "\\extJarsNDrivers\\IEDriverServer32\\IEDriverServer32.exe";
	static String extentReportPath = System.getProperty("user.dir") + "\\extentReports";
	static String downloadsFolderPart = System.getProperty("user.dir") + "\\Resources\\Downloads";
	static String extentConfigFilePath = System.getProperty("user.dir") + "\\bajSrcFiles\\resources\\extras\\extent-config.xml";
	public static String browserName =AppData.CurrentBrowser;
	public static volatile boolean runResult = true;
	public static volatile boolean bResVal = false;
	public static WebDriver driver = null;
	// Latest Element which has been found and used in findAnd... Method
	public static WebElement g_eleLatest = null;
	// Default Max wait time in seconds
	public static int g_nMaxWaitTime = 30;
	// Default Min wait time in seconds
	public static int g_nMinWaitTime = 3;
	// Default No wait time in seconds
	public static int g_nNoWaitTime = 1;
	// Max wait time in seconds for Error messages
	public static int g_nMaxErrMsgWaitTime = 3;
	// Sleep time in milliseconds between steps
	public static int g_nSleepTime = 3000;
	// SeleniumUtil Globals

	protected static By SystemError1 = By.xpath("//*[@class=\"error\"]//span");
	protected static By SystemError2 = By.xpath("//*[@class=\"bajsystemError-content-info\"]");
	protected static By SystemError3 = By.xpath("//*[contains(@id,'errors_ns_Z7')]");

	static {

		dynamicXmlPath = "E:\\BajProjects\\objJOL.xml";
		extentReport = new ExtentReports(System.getProperty("user.dir") + "\\extentReports\\" + new SimpleDateFormat("dd_mm_yyyy_hh_mm_ss").format(Calendar.getInstance().getTime()) + ".html", false);
		extentReport.loadConfig(new File(extentConfigFilePath));
		extentReport.addSystemInfo(" App env", "Dev2");
		extentReport.addSystemInfo("Tester", "Alok");

		// isMasterClassRun = GUI_Page2.runFromMasterPage;
	}

	public TestBase() {

		prop = new Properties();
		// isMasterClassRun= GUI_Page2.runFromMasterPage;
		try {
			fis = new FileInputStream(System.getProperty("user.dir") + "\\bajSrcFiles\\resources\\extras\\config.properties");
			prop.load(fis);
			PropertyConfigurator.configure(log4jPropertyFilePath);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @description This method will store the JSON data read from java GUI into
	 *              global variable array - dataset
	 * @param TCsds
	 */
	public static void setTCsDataSet(Object[] TCsds) {
		dataset = TCsds;
	}

	public static WebDriver getDriver() {
		return driver;
	}

	@BeforeTest()
	public static void setUP() {

		boolean loginFlag = false;

		Utils.customAlertByJS("Starting test case execution. Please make sure you have set the correct details in testData.xlsx file for atleast -  " + "Login details, Account Sets(From and To Accounts), Beneficiary names and other dynamic data..");

		if (AppData.getChannel().equalsIgnoreCase("JOL") || AppData.getChannel().equalsIgnoreCase("AlJazira Online")) {
			loginFlag = LoginLogout.loginJOL();
		} else if (AppData.getChannel().equalsIgnoreCase("eCorp") || AppData.getChannel().equalsIgnoreCase("AlJazira Corporate")) {
			loginFlag = LoginLogout.loginECorp();
		} else if (AppData.getChannel().equalsIgnoreCase("Smart") || AppData.getChannel().equalsIgnoreCase("AlJazira Smart")) {
			loginFlag = LoginLogout.loginSmart();
		}

		if (Utils.getSizeNoException(SystemError1) > 0 || Utils.getSizeNoException(SystemError2) > 0 || Utils.getSizeNoException(SystemError3) > 0) {

			Log.fatal("Unable to login/Fatal Error.." + Utils.getTextNoException(SystemError1) + " " + Utils.getTextNoException(SystemError2) + " " + Utils.getTextNoException(SystemError3));
			Utils.logFailImage("Login issue");
			Log.fatal("Stopping test case execution.Test report will not be generated in this case.");
			System.exit(1);

		}

		if (loginFlag == false) {
			Log.fatal("Unable to log into application. Quitting driver..Stopping test case execution");
			System.exit(0);
		} else {

			Log.pass("Successfully logged into the application");

		}

		if (isMasterClassRun) {
			Log.info("Key 'isMasterClassRun'='true', hence started executing selected master test cases along with all child scenarios");
		} else {
			Log.info("Started executing all selected child test scenarios");
		}

		if (AppData.getLanguage().equalsIgnoreCase("Arabic")) {

			// Smart arabic
			if (AppData.getChannel().equalsIgnoreCase("Smart") || AppData.getChannel().equalsIgnoreCase("AlJazira Smart")) {
				
				Utils.clickSafely(By.xpath("//*[@id='bajLangLink']"), "Arabic");
				Utils.waitForInVisibilityOfEle(By.xpath(ReadData.getObj("Propval1", "LoadingSpinner", "LogInLandingPage")));
				Log.pass("Changed language to arabic as per requirement.");
				
			// JOL and eCorp Arabic	
			} else {
				
				Utils.clickSafely(By.xpath("//*[@id='bajlanglink']"), "Arabic");
				Log.pass("Changed language to arabic as per requirement.");
			}

		}

	}

	public void extentSetUp() {

		Utils.enterOTPAndProceed();
		eTest = extentReport.startTest(TCName);
		Log.info("Staretd execution of test case -> " + TCName);
		// Utils.customAlertByJS(method.getName() + " test started");

	}

	@AfterMethod()
	public void afterMethod(ITestResult result) {

		if (result.getStatus() == ITestResult.SUCCESS) {
			String screenshot = Utils.takeScreenShot(result.getName());
			String image = eTest.addScreenCapture(screenshot);
			eTest.log(LogStatus.PASS, "title verification", image);
		}

		else if (result.getStatus() == ITestResult.FAILURE) {

			Utils.wait(3);
			String screenshot = Utils.takeScreenShot(result.getName());
			String image = eTest.addScreenCapture(screenshot);
			eTest.log(LogStatus.FAIL, image);
			Utils.refreshScreeen(); // To reload the screen in case some unwanted pop up has appeared.
		} else if (result.getStatus() == ITestResult.STARTED) {

			Utils.wait(3);
			String screenshot = Utils.takeScreenShot(result.getName());
			String image = eTest.addScreenCapture(screenshot);
			eTest.log(LogStatus.PASS, image);
			Utils.refreshScreeen(); // To reload the screen in case some unwanted pop up has appeared.
		}

		else if (result.getStatus() == ITestResult.SKIP) {

			Utils.wait(3);
			String screenshot = Utils.takeScreenShot(result.getName());
			String image = eTest.addScreenCapture(screenshot);
			eTest.log(LogStatus.PASS, image);
			Utils.refreshScreeen(); // To reload the screen in case some unwanted pop up has appeared.
		}

		Utils.enterOTPAndProceed();

	}

	@BeforeClass

	public void thisClassTestStarted() {
		logger.info("***** Test case execution of Class " + getClass().getName() + "started******");
	}

	@AfterClass(alwaysRun = true)
	public void endTest() {
		Log.info("***************All test cases of Class " + getClass().getName() + " executed******");
	}

	@BeforeSuite()
	public void driverAndExtentReportSetup() throws Exception {
		try {
			Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe");
			Runtime.getRuntime().exec("taskkill /F /IM chrome.exe");
			// Runtime.getRuntime().exec("taskkill /F /IM Excel.exe");
			// eTest.assignCategory("BAJ JOL Test Cases");
			logger.info("Killed process chromedriver.exe");
			logger.info("Configuring extent report and launching browsser.");
			launchBrowser();

		} catch (Exception e) {
			logger.error("driverAndExtentReportSetup failed. Error..." + e.getLocalizedMessage());
			e.printStackTrace();
		}

	}

	@AfterSuite(alwaysRun = true)
	public static void tearDown() throws Exception {
		// extent report related code below
		extentReport.endTest(eTest);
		extentReport.flush();
		Thread.sleep(1000);
		logger.info("*********** All test classes run. Extent report generated and put in : " + extentReportPath + " .Quitting browser**********");

	}

	public static WebDriver launchBrowser() throws Exception {

		boolean bPageLoaded = false;

		try {

			if (browserName.equalsIgnoreCase("Chrome") || browserName.equalsIgnoreCase("Google Chrome")) {
				ChromeOptions objChromeOptions = new ChromeOptions();
				objChromeOptions.addArguments("disable-infobars");
				objChromeOptions.addArguments("disable-gpu");
				// objChromeOptions.addArguments("--headless");
				System.setProperty("webdriver.chrome.driver", chromeDriverPath);
				driver = new ChromeDriver(objChromeOptions);

			} else if (browserName.equalsIgnoreCase("Firefox") || browserName.equalsIgnoreCase("FF")) {
				System.setProperty("webdriver.gecko.driver", gerkoDriverPath);
				driver = new FirefoxDriver();

			} else if (browserName.equalsIgnoreCase("IE") || browserName.equalsIgnoreCase("Internet Explorer")) {

				System.setProperty("webdriver.ie.driver", IEDriverPath);
				DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
				capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
				driver = new InternetExplorerDriver();

			}
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			bPageLoaded = waitForPageToLoad();

			if (bPageLoaded) {
				logger.info("Successfully launched the browser");
			} else {
				logger.error("Browser did not launched within max wait time :: " + g_nMaxWaitTime + " Secs.");
			}
			logger.info("********* Launching " + browserName + " browser*****************");
			return driver;

		} catch (Exception e) {

			logger.error(" Failed to initialize driver and browser setup. Stopping execution... error... " + ExceptionUtils.getStackTrace(e));
			System.exit(1);
			return null;
		}
	}

	public static boolean waitForPageToLoad(int... nMaxWaiTimeInSec) {
		boolean bResult = false;
		String strJSScript = "return document.readyState";
		String strReadtStausToWait = "complete";
		String strActualStatus = "";
		int nTimer = 0;
		int nMaxWaitTime = -1;

		if (nMaxWaiTimeInSec.length > 0)
			nMaxWaitTime = nMaxWaiTimeInSec[0];
		else
			nMaxWaitTime = g_nMaxWaitTime;

		logger.info("Waiting for page to load... Max Wait Time is :: " + nMaxWaitTime + " Secs.");

		try {
			if (driver == null) {
				logger.error("Driver object is NULL :: Failed to Wait");
				return bResult;
			}
			do {
				JavascriptExecutor jsExec = (JavascriptExecutor) driver;
				strActualStatus = jsExec.executeScript(strJSScript).toString();
				Thread.sleep(1000);
				nTimer++;
				logger.info("Current Page Status :: " + strActualStatus + " :: Waited For " + nTimer + " Seconds");
				if (strActualStatus.trim().equalsIgnoreCase(strReadtStausToWait)) {
					bResult = true;
					break;
				}

			} while (nTimer <= nMaxWaitTime);

			return bResult;

		} catch (Exception ex) {

			logger.error(" Page load failed :" + ExceptionUtils.getStackTrace(ex));
			return bResult;
		}
	}

}