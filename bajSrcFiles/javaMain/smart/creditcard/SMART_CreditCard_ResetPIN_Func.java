package javaMain.smart.creditcard;

import static Utilities.ReadData.ReadDataSQL;
import static Utilities.ReadData.getObj;
import static Utilities.ReadData.readConfigXml;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import Utilities.Input;
import Utilities.Log;
import Utilities.ReadData;
import Utilities.TestBase;
import Utilities.Utils;
import javaMain.common_Functions.AppData;
import javaMain.common_Functions.OpenMenuesSmart;

public class SMART_CreditCard_ResetPIN_Func extends TestBase {
	public static String Confirm, Paytype, Proceed, AMOUNT, AfterTxfrAdditionalOptions, OTPProceed;

	public static boolean ResetPIN(String TCName, int ScenarioCount, Object[] tCsDataset) throws Exception {

		try {

			if (isMasterClassRun) {

				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + ReadData.getJsonData(TCName, ScenarioCount, "DataSet") + "</mark>");

				AfterTxfrAdditionalOptions = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "AfterTxfrAdditionalOptions"));
				AMOUNT = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "AMOUNT"));
				Paytype = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Paytype"));
				Proceed = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Proceed"));
				Confirm = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Confirm"));
				OTPProceed = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "OTPProceed"));

			} else {

				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + ReadData.getJsonData(TCName, ScenarioCount, "DataSet") + "</mark>");
				AfterTxfrAdditionalOptions = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("AfterTxfrAdditionalOptions"));
				Paytype = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Paytype"));
				Proceed = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Proceed"));
				Confirm = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Confirm"));
				AMOUNT = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("AMOUNT"));
				OTPProceed = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("OTPProceed"));
			}

			Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "LoadingSpinner", "LogInLandingPage")));
			Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "LoadingSpinner", "LogInLandingPage")));
			Utils.click(By.xpath(getObj("Propval1", "Cards", "SMART_CreditCard_ResetPIN")), "Cards Menu");
			Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "LoadingSpinner", "LogInLandingPage")));
			Utils.wait(2);
			Utils.click(By.xpath(getObj("Propval1", "ResetPIN", "SMART_CreditCard_ResetPIN")), "ResetPIN");

			Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "LoadingSpinner", "LogInLandingPage")));

			Utils.click(By.xpath(getObj("Propval1", "CreditCard", "SMART_CreditCard_ResetPIN")), "CreditCard");
			System.out.println(Input.ReadTestData(TCName, "PIN") + " " + Input.ReadTestData(TCName, "ConfirmPIN"));
			Utils.sendKeys_Smart(By.xpath(getObj("Propval1", "PIN", "SMART_CreditCard_ResetPIN")), Input.ReadTestData(TCName, "PIN"), "PIN");
			Utils.sendKeys_Smart(By.xpath(getObj("Propval1", "ConfirmPIN", "SMART_CreditCard_ResetPIN")), Input.ReadTestData(TCName, "ConfirmPIN"), "Confirm PIN");

			if (Integer.parseInt(Proceed) == 1) {
				Utils.click(By.xpath(getObj("Propval1", "Proceed", "SMART_CreditCard_ResetPIN")), "Proceed");
				Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "LoadingSpinner", "LogInLandingPage")));
			} else {

				Utils.click(By.xpath(getObj("Propval1", "cancel", "SMART_CreditCard_ResetPIN")), "Cancel Button on Proceed Page");
				Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "LoadingSpinner", "LogInLandingPage")));
				try {
					Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "HomeSuccess", "SMART_CreditCard_ResetPIN")), "Home Success"));
					Log.pass("Successfully cancelled the pay or recharge in proceed page");
					Utils.logPassImage("Successfully cancelled pay or recharge-pass");
					return true;

				} catch (AssertionError | Exception e) {

					Log.fail("unable to cancel the pay and recharge");
					Utils.logFailImage("unable to cancel pay or recharge-fail");

					throw e;

				}

			}

			Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "LoadingSpinner", "LogInLandingPage")));

			if (Integer.parseInt(Confirm) == 1) {
				// Click on Confirm Button//
				Utils.click(By.xpath(getObj("Propval1", "ConfirmBtn", "SMART_CreditCard_ResetPIN")), "Confirm Button");
				Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "LoadingSpinner", "LogInLandingPage")));
			}

			else {
				Utils.click(By.xpath(getObj("Propval1", "cancel", "SMART_CreditCard_ResetPIN")), "Cancel Button on ConfirmationPage");
				Utils.click(By.xpath(getObj("Propval1", "Cancel_Yes_Btn", "SMART_CreditCard_ResetPIN")), "Yes Button to cancel Transaction");

				Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "LoadingSpinner", "LogInLandingPage")));

				try {
					Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "proceed", "SMART_CreditCard_ResetPIN")), "New Transactions creeen"));
					Log.pass("Successfully cancelled the confirm page");
					Utils.logPassImage("CancelBtn confirm");
					return true;

				} catch (AssertionError | Exception e) {
					Log.fail("Unable to navigate toNew Transaction screen..error..");
					Utils.logFailImage("New Transaction");
					throw e;
				}

			}

			if (Integer.parseInt(OTPProceed) == 1) {

				Utils.sendKeys(By.xpath(getObj("Propval1", "OTPText", "SMART_CreditCard_ResetPIN")), "0123", "OTP Enter");

				Utils.click(By.xpath(getObj("Propval1", "OTPProceed", "SMART_CreditCard_ResetPIN")), "OTP Proceed");
			} else {
				Utils.click(By.xpath(getObj("Propval1", "cancel", "SMART_CreditCard_ResetPIN")), "Cancel Button on OTP Page");
				Utils.logPassImage("OTP Cancel Button");
				return true;
			}

			Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "LoadingSpinner", "LogInLandingPage")));
			Utils.logPassImage("Your Update Online Transactions Status has been completed successfully");
			try {
				Assert.assertTrue(Utils.assertDisplayed_Smart(By.xpath(getObj("Propval1", "MoneyTransfer_SuccessMsg", "SMART_CreditCard_ResetPIN")), "Cash Transfer"));

				Log.pass(" Message displayed is : " + Utils.getText_Smart(By.xpath(getObj("Propval1", "PrintMessage", "SMART_CreditCard_ResetPIN"))));
				Utils.logPassImage("Your Update Online Transactions Status  has been completed successfully");

			} catch (AssertionError | Exception e) {
				Log.pass(" Message displayed is : " + Utils.getText_Smart(By.xpath(getObj("Propval1", "PrintMessage", "SMART_CreditCard_ResetPIN"))));
				Log.fail("Your Cash Transfer has not been completed successfully");
				Utils.logFailImage(" Your Update Online Transactions Status  has not  been completed successfully");
				throw e;

			}

			Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "LoadingSpinner", "LogInLandingPage")));

			if (AfterTxfrAdditionalOptions.equalsIgnoreCase("Home")) {
				Utils.click(By.xpath(getObj("Propval1", "Home", "SMART_CreditCard_ResetPIN")), "Home");
				Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "LoadingSpinner", "LogInLandingPage")));
				try {
					Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "HomeSuccess", "SMART_CreditCard_ResetPIN")), "Home Page"));
					Log.info("Successfully navigated to home screen");
					Utils.logPassImage("Home Screen");

				} catch (AssertionError | Exception e) {
					Log.fail("Unable to navigate to home screen..error..");
					Utils.logFailImage("Home Screen");
					throw e;
				}
			}

			else {
				Utils.click(By.xpath(getObj("Propval1", "NewTransaction", "SMART_CreditCard_ResetPIN")), "NewTransaction");
				Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "LoadingSpinner", "LogInLandingPage")));
				try {
					Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "proceed", "SMART_CreditCard_ResetPIN")), "New Transactions creeen"));
					Log.pass(" Add another  transaction screen is displayed successfully");
					Utils.logPassImage("New Transaction");

				} catch (AssertionError | Exception e) {
					Log.fail("Unable to navigate toNew Transaction screen..error..");
					Utils.logFailImage("New Transaction");
					throw e;
				}
			}

		} catch (AssertionError | Exception e) {
			runResult = false;
			throw e;
		}
		return runResult;
	}

}
