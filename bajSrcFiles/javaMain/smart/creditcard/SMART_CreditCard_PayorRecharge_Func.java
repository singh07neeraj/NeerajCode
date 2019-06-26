package javaMain.smart.creditcard;

import static Utilities.ReadData.ReadDataSQL;
import static Utilities.ReadData.getObj;
import static Utilities.ReadData.readConfigXml;
import static javaMain.common_Functions.AppData.ExecutionTime;

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

public class SMART_CreditCard_PayorRecharge_Func extends TestBase {

	public static String Confirm, Paytype, Proceed, AMOUNT, AfterTxfrAdditionalOptions;

	public static boolean PayorRecharge(String TCName, int ScenarioCount, Object[] tCsDataset) throws Exception {

		try {

			if (isMasterClassRun) {

				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + ReadData.getJsonData(TCName, ScenarioCount, "DataSet") + "</mark>");

				AfterTxfrAdditionalOptions = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "AfterTxfrAdditionalOptions"));
				AMOUNT = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "AMOUNT"));
				Paytype = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Paytype"));
				Proceed = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Proceed"));
				Confirm = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Confirm"));

			} else {

				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + ReadData.getJsonData(TCName, ScenarioCount, "DataSet") + "</mark>");

				AfterTxfrAdditionalOptions = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("AfterTxfrAdditionalOptions"));
				Paytype = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Paytype"));
				Proceed = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Proceed"));
				Confirm = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Confirm"));
				AMOUNT = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("AMOUNT"));
			}
	
			Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "LoadingSpinner", "LogInLandingPage")));
			Utils.click(By.xpath(getObj("Propval1", "Cards", "SMART_CreditCard_PayorRecharge")), "Cards Menu");
			Utils.click(By.xpath(getObj("Propval1", "PayorRecharge", "SMART_CreditCard_PayorRecharge")), "Pay or Recharge");
			Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "LoadingSpinner", "LogInLandingPage")));

			try {
				Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "Proceed", "SMART_CreditCard_PayorRecharge")), "Proceed"));
				Log.pass("Card Payment screen  is displayed");
				Utils.logPassImage("Card Summary");
			} catch (AssertionError | Exception e) {
				Log.fail("Card Payment screen  is not displayed");
				Utils.logFailImage("Card Summary");
				throw e;
			}

			Utils.click(By.xpath(getObj("Propval1", "mycards", "SMART_CreditCard_PayorRecharge")), "my cards");

			Utils.click(By.xpath(getObj("Propval1", "SelectCard", "SMART_CreditCard_PayorRecharge")), "Select Card");
			Utils.wait(3);

			Utils.click(By.xpath(getObj("Propval1", "AccountDetails", "SMART_CreditCard_PayorRecharge")), "Select Card");

			if (Paytype.equalsIgnoreCase("Minimum")) {
				Utils.click(By.xpath(getObj("Propval1", "Minimum", "SMART_CreditCard_PayorRecharge")), "Minimum");
			} else if (Paytype.equalsIgnoreCase("outstandingBalance")) {
				Utils.click(By.xpath(getObj("Propval1", "outstandingBalance", "SMART_CreditCard_PayorRecharge")), "outstandingBalance");
			} else {
				Utils.click(By.xpath(getObj("Propval1", "OtherAmount", "SMART_CreditCard_PayorRecharge")), "OtherAmount");
			}
			Utils.sendKeys_Smart1(By.xpath(getObj("Propval1", "Amount", "SMART_CreditCard_PayorRecharge")), AMOUNT, "AMOUNT");

			if (Integer.parseInt(Proceed) == 1) {
				Utils.click(By.xpath(getObj("Propval1", "Proceed", "SMART_CreditCard_PayorRecharge")), "Proceed");
				Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "LoadingSpinner", "LogInLandingPage")));
			} else {

				Utils.click(By.xpath(getObj("Propval1", "CancelBtn", "SMART_CreditCard_PayorRecharge")), "Cancel Button on Proceed Page");
				Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "LoadingSpinner", "LogInLandingPage")));
				try {
					Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "HomeSuccess", "SMART_CreditCard_PayorRecharge")), "Home Success"));
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
				Utils.click(By.xpath(getObj("Propval1", "ConfirmBtn", "SMART_CreditCard_PayorRecharge")), "Confirm Button");
				Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "LoadingSpinner", "LogInLandingPage")));
			}

			else {
				Utils.click(By.xpath(getObj("Propval1", "CancelBtn", "SMART_CreditCard_PayorRecharge")), "Cancel Button on ConfirmationPage");
				Utils.click(By.xpath(getObj("Propval1", "Cancel_Yes_Btn", "SMART_CreditCard_PayorRecharge")), "Yes Button to cancel Transaction");

				Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "LoadingSpinner", "LogInLandingPage")));

				try {
					Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "proceed", "SMART_CreditCard_PayorRecharge")), "New Transactions creeen"));
					Log.pass("Successfully cancelled the confirm page");
					Utils.logPassImage("CancelBtn confirm");
					return true;

				} catch (AssertionError | Exception e) {
					Log.fail("Unable to navigate toNew Transaction screen..error..");
					Utils.logFailImage("New Transaction");
					throw e;
				}

			}

			Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "LoadingSpinner", "LogInLandingPage")));

			try {
				Assert.assertTrue(Utils.assertDisplayed_Smart(By.xpath(getObj("Propval1", "MoneyTransfer_SuccessMsg", "SMART_CreditCard_PayorRecharge")), "Money transfer success message on results page"));
				Utils.scrollIntoView(By.xpath(getObj("Propval1", "Results_Page", "SMART_CreditCard_PayorRecharge")));
				Log.pass(" Message displayed is : " + Utils.getText_Smart(By.xpath(getObj("Propval1", "PrintMessage", "SMART_CreditCard_PayorRecharge"))));
				Utils.logPassImage("Your card payment has been completed successfully");
				Utils.logPassImage("Payment Successfull");

			} catch (AssertionError | Exception e) {

				Log.fail("Your card payment has not been completed successfully");
				Utils.logFailImage(" Your card payment has not  been completed successfully");
				Utils.logFailImage("Payment failed");
				throw e;

			}

			Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "LoadingSpinner", "LogInLandingPage")));

			if (AfterTxfrAdditionalOptions.equalsIgnoreCase("Home")) {
				Utils.click(By.xpath(getObj("Propval1", "Home", "SMART_CreditCard_PayorRecharge")), "Home");
				Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "LoadingSpinner", "LogInLandingPage")));
				try {
					Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "HomeSuccess", "SMART_CreditCard_PayorRecharge")), "Home Page"));
					Log.info("Successfully navigated to home screen");
					Utils.logPassImage("Home Screen");

				} catch (AssertionError | Exception e) {
					Log.fail("Unable to navigate to home screen..error..");
					Utils.logFailImage("Home Screen");
					throw e;
				}
			}

			else {
				Utils.click(By.xpath(getObj("Propval1", "NewTransaction", "SMART_CreditCard_PayorRecharge")), "NewTransaction");
				Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "LoadingSpinner", "LogInLandingPage")));
				try {
					Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "proceed", "SMART_CreditCard_PayorRecharge")), "New Transactions creeen"));
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
