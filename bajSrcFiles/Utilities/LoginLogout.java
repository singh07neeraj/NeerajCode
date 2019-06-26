package Utilities;

import static Utilities.ReadData.getObj;
import static Utilities.ReadData.readConfigXml;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.openqa.selenium.By;

import javaMain.common_Functions.AppData;

public class LoginLogout extends TestBase {

	public static boolean loginECorp() {

		try {

			eTest = extentReport.startTest("Default mandatory login test case");

			Log.info("Account set details entered by user are :- " + "<br>" + "Data Set = " + AppData.getTestDataSet() + "<br>" + "User Name = " + AppData.getUsername() + "<br>" + "Password = " + AppData.getPassword() + "<br>"
					+ "From Account(SAR) = " + AppData.getFromAccountSAR() + "<br>" + "From Account(Foreign) = " + AppData.getFromAccountForeign() + "<br>" + "To Account(SAR) = " + AppData.getToAccountSAR() + "<br>" + "To Account(Foreign) = "
					+ AppData.getToAccountForeign());

			Utils.OpenUrl(readConfigXml("UATeCorpLoginPageURL"));

			if (browserName.equalsIgnoreCase("IE") || browserName.equalsIgnoreCase("Internet Explorer")) {
				Utils.clickSafely(By.id("overridelink"), "Certificate link");// Only for IE
			}

			Utils.sendKeys(By.xpath(getObj("Propval1", "UserName", "LogInLandingPage")), AppData.getUsername(), "User Id"); // reads from excel.
			// "user202978"); gold user.
			Utils.sendKeys(By.xpath(getObj("Propval1", "password", "LogInLandingPage")), AppData.getPassword(), "Password"); // reads from excel.
			Utils.click(By.xpath(getObj("Propval1", "LoginButton", "LogInLandingPage")), "login button");
			Utils.waitTillSaudiWaitIconDisappears();
			// Utils.clickSafely(By.xpath("//*[@id='dijit_form_Button_0_label']"), "Proceed
			// Button on multiple mobiles screen");
			Utils.enterOTPAndProceed();
			Utils.waitTillSaudiWaitIconDisappears();

			return true;

		} catch (AssertionError | Exception e) {

			Log.fail("Unable to log into JOL application ..or  it is already logged in error. " + ExceptionUtils.getStackTrace(e).trim());
			Utils.logFailImage("Login Functionality");
			return false;

		}

	}

	public static boolean loginJOL() {

		try {

			eTest = extentReport.startTest("Default mandatory login test case");

			Log.info("Account set details entered by user are :- " + "<br>" + "Data Set = " + AppData.getTestDataSet() + "<br>" + "User Name = " + AppData.getUsername() + "<br>" + "Password = " + AppData.getPassword() + "<br>"
					+ "From Account(SAR) = " + AppData.getFromAccountSAR() + "<br>" + "From Account(Foreign) = " + AppData.getFromAccountForeign() + "<br>" + "To Account(SAR) = " + AppData.getToAccountSAR() + "<br>" + "To Account(Foreign) = "
					+ AppData.getToAccountForeign());

			Utils.OpenUrl(readConfigXml("UATJOLLoginPageURL"));

			// Utils.clickSafely(By.id("wpthemeLogin"), "IBM login Button");

			if (browserName.equalsIgnoreCase("IE") || browserName.equalsIgnoreCase("Internet Explorer")) {
				Utils.clickSafely(By.id("overridelink"), "Certificate link");// Only for IE
			}

			Utils.sendKeys(By.xpath(getObj("Propval1", "UserName", "LogInLandingPage")), AppData.getUsername(), "User Id"); // reads from excel.
			// "user202978"); gold user.
			Utils.sendKeys(By.xpath(getObj("Propval1", "password", "LogInLandingPage")), AppData.getPassword(), "Password"); // reads from excel.
			Utils.wait(2);
			Utils.click(By.xpath(getObj("Propval1", "LoginButton", "LogInLandingPage")), "login button");
			Utils.waitTillSaudiWaitIconDisappears();
			Utils.clickSafely(By.xpath(getObj("Propval1", "ProceedBtnOnMultipleMobileScreen", "LogInLandingPage")), "Proceed Button on multiple mobiles screen");
			Utils.enterOTPAndProceed();
			Utils.waitTillSaudiWaitIconDisappears();

			return true;

		} catch (AssertionError | Exception e) {

			Log.fail("Unable to log into JOL application ..or  it is already logged in error. " + ExceptionUtils.getStackTrace(e).trim());
			Utils.logFailImage("Login Functionality");

			return false;
		}

	}

	public static void logOutJOL() {

		try {

			Utils.click(By.xpath(getObj("Propval1", "logOutBtn", "LogInLandingPage")), "Logout Button", 14);

			Log.pass("Succssfully logged out from application");

		} catch (Exception e) {

			Log.fail("Unable to logout from JOL application");

		}

	}

	public static boolean loginSmart() {

		try {

			eTest = extentReport.startTest("Default mandatory login test case");

			Log.info("Account set details entered by user are :- " + "<br>" + "Data Set = " + AppData.getTestDataSet() + "<br>" + "User Name = " + AppData.getUsername() + "<br>" + "Password = " + AppData.getPassword() + "<br>"
					+ "From Account(SAR) = " + AppData.getFromAccountSAR() + "<br>" + "From Account(Foreign) = " + AppData.getFromAccountForeign() + "<br>" + "To Account(SAR) = " + AppData.getToAccountSAR() + "<br>" + "To Account(Foreign) = "
					+ AppData.getToAccountForeign());

			Utils.OpenUrl(readConfigXml("UATSmartLoginPageURL"));
			if (browserName.equalsIgnoreCase("IE") || browserName.equalsIgnoreCase("Internet Explorer")) {
				Utils.clickSafely(By.id("overridelink"), "Certificate link");// Only for IE
			}
			Utils.sendKeys(By.xpath(getObj("Propval1", "UserName", "LogInLandingPage")), AppData.getUsername(), "User Id"); // reads from excel.
			// "user202978"); gold user.
			Utils.sendKeys(By.xpath(getObj("Propval1", "password", "LogInLandingPage")), AppData.getPassword(), "Password"); // reads from excel.
			Utils.wait(4);
			Utils.click(By.xpath(getObj("Propval1", "LoginButton", "LogInLandingPage")), "login button");
			Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "LoadingSpinner", "LogInLandingPage")));

			try {
				Utils.click(By.xpath(getObj("Propval1", "ProceedBtnOnMultipleMobileScreen", "LogInLandingPage")), "Proceed Button on multiple mobiles screen", 15, 0);

			} catch (Exception e) {
				// Nothing
			}

			Utils.enterOTPAndProceed();
			Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "LoadingSpinner", "LogInLandingPage")));

			Log.pass("Successfully logged into Smart application");
			// Utils.logPassImage("Login Functionality");

			return true;

		} catch (AssertionError | Exception e) {

			Log.fail("Unable to log into Smart application ..or  it is already logged in error. " + ExceptionUtils.getStackTrace(e).trim());
			Utils.logFailImage("Login Functionality");

			return false;
		}

	}

	/***
	 * @description This method is useful when some unwanted pop up comes in
	 *              application and it causes all remaining test cases to fail As
	 *              menues do not open due to overlapping by pop up. In this case
	 *              this method will logout user and re login hence unwanted pop up
	 *              will be closed and remaining tets cases will resume work as
	 *              usual. This test case can be called in the catch block of test
	 *              case class.To be used smartly based on requirement.
	 * @throws Exception - When login/logout Objects not found on screen.
	 * @author baj80000892/Alok Rai
	 */
	public static void reLoginJOL() {

		try {

			Utils.pressEscapeKey(4);
			Utils.click(By.xpath(getObj("Propval1", "logOutBtn", "LogInLandingPage")), "Logout Button", 14);
			// Utils.OpenUrl(AppData.getAppUrl());
			Utils.OpenUrl(readConfigXml("UATJOLLoginPageURL"));

			if (browserName.equalsIgnoreCase("IE") || browserName.equalsIgnoreCase("Internet Explorer")) {
				Utils.clickSafely(By.id("overridelink"), "Certificate link");// Only for IE
			}
			Utils.sendKeys(By.xpath(getObj("Propval1", "UserName", "LogInLandingPage")), AppData.getUsername(), "User Id"); // reads from excel.
			// "user202978"); gold user.
			Utils.sendKeys(By.xpath(getObj("Propval1", "password", "LogInLandingPage")), AppData.getPassword(), "Password"); // reads from excel.

			Utils.click(By.xpath(getObj("Propval1", "LoginButton", "LogInLandingPage")), "login button");
			Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "SaudiWaitLogo", "LogInLandingPage")));

			try {
				Utils.click(By.xpath(getObj("Propval1", "ProceedBtnOnMultipleMobileScreen", "LogInLandingPage")), "Proceed Button on multiple mobiles screen", 5, 0);

			} catch (Exception e) {
				// Nothing
			}
			Utils.enterOTPAndProceed();
			Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "SaudiWaitLogo", "LogInLandingPage")));
			// Utils.assertDisplayed(By.xpath(getObj("Propval1", "appLogo",
			// "LogInLandingPage")), "Application Logo");
			Log.pass("Successfully relogged in the user in JOL application. User name is : " + AppData.getUsername());

		} catch (Exception e) {

			Log.fail("Unable to perform re login for user : " + AppData.getUsername() + " error.." + ExceptionUtils.getStackTrace(e).trim());
		}
	}

}
