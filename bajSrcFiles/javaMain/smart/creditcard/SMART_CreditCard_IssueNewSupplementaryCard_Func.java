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

public class SMART_CreditCard_IssueNewSupplementaryCard_Func extends TestBase {

	public static String Confirm, Paytype, Proceed, AMOUNT, AfterTxfrAdditionalOptions, StartDate_Date_Future, StartDate_Month_Future, StartDate_Year_Future;

	public static boolean IssueNewSupplementaryCard(String TCName, int ScenarioCount, Object[] tCsDataset) throws Exception {

		try {
			
			if (isMasterClassRun) {

				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + ReadData.getJsonData(TCName, ScenarioCount, "DataSet") + "</mark>");

				AfterTxfrAdditionalOptions = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "AfterTxfrAdditionalOptions"));
				AMOUNT = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "AMOUNT"));
				Paytype = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Paytype"));
				Proceed = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Proceed"));
				Confirm = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Confirm"));
				StartDate_Date_Future = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "StartDate_Date_Future"));
				StartDate_Month_Future = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "StartDate_Month_Future"));
				StartDate_Year_Future = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "StartDate_Year_Future"));

			} else {

				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + ReadData.getJsonData(TCName, ScenarioCount, "DataSet") + "</mark>");

				AfterTxfrAdditionalOptions = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("AfterTxfrAdditionalOptions"));
				Paytype = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Paytype"));
				Proceed = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Proceed"));
				Confirm = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Confirm"));
				AMOUNT = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("AMOUNT"));
				StartDate_Date_Future = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("StartDate_Date_Future"));
				StartDate_Month_Future = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("StartDate_Month_Future"));
				StartDate_Year_Future = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("StartDate_Year_Future"));
			}
			
			
			Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "LoadingSpinner", "LogInLandingPage")));

			Utils.click_Smart(By.xpath(getObj("Propval1", "Cards", "SMART_CreditCard_IssueNewSupplementaryCard")), "Cards Menu");
			Utils.wait(2);
			Utils.click_Smart(By.xpath(getObj("Propval1", "RequestaTemporaryLimitIncrease", "SMART_CreditCard_IssueNewSupplementaryCard")), "Request a Temporary Limit Increase");

			Utils.click(By.xpath(getObj("Propval1", "SelectCard", "SMART_CreditCard_IssueNewSupplementaryCard")), "Select Card");

			Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "LoadingSpinner", "LogInLandingPage")));

			if (Paytype.equalsIgnoreCase("Amount")) {
				Utils.sendKeys_Smart1(By.xpath(getObj("Propval1", "Amount", "SMART_CreditCard_IssueNewSupplementaryCard")), AMOUNT, "AMOUNT");

			} else {

				Utils.click(By.xpath(getObj("Propval1", "Percent", "SMART_CreditCard_IssueNewSupplementaryCard")), "Select Card");
				// Utils.sendKeys_Smart1(By.xpath(getObj("Propval1", "Amount",
				// "SMART_CreditCard_IssueNewSupplementaryCard")), AMOUNT, "AMOUNT");
				Utils.sendValDropdown_Smart(By.xpath(getObj("Propval1", "AmountIncrease_Percent_DD", "SMART_CreditCard_IssueNewSupplementaryCard")), AMOUNT + "%", "TransferVia DropDown");

			}
			
			Utils.click_Smart(By.xpath(getObj("Propval1", "ExpiryDate", "SMART_CreditCard_IssueNewSupplementaryCard")), "Expiry Date");
			Log.pass("Langugage "+AppData.getLanguage());
			if (AppData.getLanguage().equalsIgnoreCase("EN")) {
				Log.pass("English date");
				Utils.Changedate_Smart(StartDate_Date_Future, "DateIncreasing_clk", "SMART_CreditCard_IssueNewSupplementaryCard", " '+' button to select future date");
				Utils.Changedate_Smart(StartDate_Month_Future, "MonthIncreasing_clk", "SMART_CreditCard_IssueNewSupplementaryCard", " '+' button to select future month");
				Utils.Changedate_Smart(StartDate_Year_Future, "YearIncreasing_clk", "SMART_CreditCard_IssueNewSupplementaryCard", " '+' button to select future Year");
			} else {
				Log.pass("Arabic date");
				Utils.Changedate_Smart(StartDate_Date_Future, "DateIncreasing_clk_Arb", "SMART_CreditCard_IssueNewSupplementaryCard", " '+' button to select future date");
				Utils.Changedate_Smart(StartDate_Month_Future, "MonthIncreasing_clk_Arb", "SMART_CreditCard_IssueNewSupplementaryCard", " '+' button to select future month");
				Utils.Changedate_Smart(StartDate_Year_Future, "YearIncreasing_clk_Arb", "SMART_CreditCard_IssueNewSupplementaryCard", " '+' button to select future Year");
			}

			Utils.click_Smart(By.xpath(getObj("Propval1", "TandC", "SMART_CreditCard_IssueNewSupplementaryCard")), "TandC");

			Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "LoadingSpinner", "LogInLandingPage")));

			try {
				Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "Proceed", "SMART_CreditCard_IssueNewSupplementaryCard")), "Proceed"));
				Log.pass("Card Payment screen  is displayed");
				Utils.logPassImage("Card Summary");
			} catch (AssertionError | Exception e) {
				Log.fail("Card Payment screen  is not displayed");
				Utils.logFailImage("Card Summary");
				throw e;
			}

			if (Integer.parseInt(Proceed) == 1) {
				Utils.click(By.xpath(getObj("Propval1", "ProceedBtn", "SMART_CreditCard_IssueNewSupplementaryCard")), "Proceed");
				Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "LoadingSpinner", "LogInLandingPage")));
			} else {

				Utils.click(By.xpath(getObj("Propval1", "CancelBtn", "SMART_CreditCard_IssueNewSupplementaryCard")), "Cancel Button on Proceed Page");
				Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "LoadingSpinner", "LogInLandingPage")));
				try {
					Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "HomeSuccess", "SMART_CreditCard_IssueNewSupplementaryCard")), "Home Success"));
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
				Utils.click(By.xpath(getObj("Propval1", "ConfirmBtn", "SMART_CreditCard_IssueNewSupplementaryCard")), "Confirm Button");
				Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "LoadingSpinner", "LogInLandingPage")));
			}

			else {
				Utils.click(By.xpath(getObj("Propval1", "CancelBtn", "SMART_CreditCard_IssueNewSupplementaryCard")), "Cancel Button on ConfirmationPage");
				Utils.click(By.xpath(getObj("Propval1", "Cancel_Yes_Btn", "SMART_CreditCard_IssueNewSupplementaryCard")), "Yes Button to cancel Transaction");

				Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "LoadingSpinner", "LogInLandingPage")));

				try {
					Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "proceed", "SMART_CreditCard_IssueNewSupplementaryCard")), "New Transactions creeen"));
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
			Utils.logPassImage("Fonal Page- Temp Limit Increase");
			try {
				Assert.assertTrue(Utils.assertDisplayed_Smart(By.xpath(getObj("Propval1", "MoneyTransfer_SuccessMsg", "SMART_CreditCard_IssueNewSupplementaryCard")), "Cash Transfer"));
				Utils.scrollIntoView(By.xpath(getObj("Propval1", "Results_Page", "SMART_CreditCard_IssueNewSupplementaryCard")));
				Log.pass(" Message displayed is : " + Utils.getText_Smart(By.xpath(getObj("Propval1", "PrintMessage", "SMART_CreditCard_IssueNewSupplementaryCard"))));
				Utils.logPassImage("Your Cash Transfert has been completed successfully");

			} catch (AssertionError | Exception e) {

				Log.fail("Your Cash Transfer has not been completed");
				Utils.logFailImage(" Your Cash Transfer has not  been completed successfully");
				throw e;

			}

			Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "LoadingSpinner", "LogInLandingPage")));

			if (AfterTxfrAdditionalOptions.equalsIgnoreCase("Home")) {
				Utils.click(By.xpath(getObj("Propval1", "Home", "SMART_CreditCard_IssueNewSupplementaryCard")), "Home");
				Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "LoadingSpinner", "LogInLandingPage")));
				try {
					Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "HomeSuccess", "SMART_CreditCard_IssueNewSupplementaryCard")), "Home Page"));
					Log.info("Successfully navigated to home screen");
					Utils.logPassImage("Home Screen");

				} catch (AssertionError | Exception e) {
					Log.fail("Unable to navigate to home screen..error..");
					Utils.logFailImage("Home Screen");
					throw e;
				}
			}

			else {
				Utils.click(By.xpath(getObj("Propval1", "NewTransaction", "SMART_CreditCard_IssueNewSupplementaryCard")), "NewTransaction");
				Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "LoadingSpinner", "LogInLandingPage")));
				try {
					Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "proceed", "SMART_CreditCard_IssueNewSupplementaryCard")), "New Transactions creeen"));
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
