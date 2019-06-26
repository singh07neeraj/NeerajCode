package javaMain.eCorp.accounts;

import static Utilities.Input.ReadTestData;
import static Utilities.ReadData.ReadDataSQL;
import static Utilities.ReadData.getObj;
import static javaMain.common_Functions.AppData.AccountNumber;
import static javaMain.common_Functions.AppData.AdditionalOptions;
import static javaMain.common_Functions.AppData.Confirm;
import static javaMain.common_Functions.AppData.Currency;
import static javaMain.common_Functions.AppData.Home;
import static javaMain.common_Functions.AppData.NewTxn;
import static javaMain.common_Functions.AppData.OTPProceed;
import static javaMain.common_Functions.AppData.OrderStatus;
import static javaMain.common_Functions.AppData.Proceed;
import static javaMain.common_Functions.AppData.TestType;
import static javaMain.common_Functions.AppData.selectTnCfrompopup;
import static javaMain.common_Functions.AppData.termConditions;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Utilities.Input;
import Utilities.Log;
import Utilities.ReadData;
import Utilities.TestBase;
import Utilities.Utils;
import javaMain.JOL.transfer.TransferModuleCommonFunctions;

/**
 * Description : Functional Test Script
 * 
 * @author baj80000892
 */
public class eCorp_ACCOUNT_OPEN_ADDITIONAL_ACCOUNT_FUNC extends TestBase {

	@SuppressWarnings("unused")
	public static boolean OpenAdditionalAcc(String TCName, int ScenarioCount, Object[] tCsDataset) throws Exception {

		try {

			if (isMasterClassRun) {

				Log.pass("Data set for this scenario is " + System.lineSeparator() + ReadData.getJsonData(TCName, ScenarioCount, "DataSet"));
				Proceed = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Proceed"));
				Confirm = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Confirm"));
				termConditions = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "termConditions"));
				selectTnCfrompopup = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "selectTnCfrompopup"));
				OTPProceed = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "OTPProceed"));
				AdditionalOptions = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "AdditionalOptions"));
				NewTxn = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "NewTxn"));
				TestType = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "TestType"));
				AccountNumber = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "AccountNumber"));
				Currency = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Currency"));
				Home = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Home"));
				OrderStatus = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "OrderStatus"));
				TestType = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "TestType"));

			}
			

			else {

				Log.pass("Data set for this scenario is " + System.lineSeparator() + dataset[scenarioCount - 1]);
				Proceed = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Proceed"));
				Confirm = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Confirm"));
				termConditions = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("termConditions"));
				selectTnCfrompopup = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("selectTnCfrompopup"));
				OTPProceed = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("OTPProceed"));
				AdditionalOptions = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("AdditionalOptions"));
				NewTxn = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("NewTxn"));
				TestType = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("TestType"));
				AccountNumber = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("AccountNumber"));
				Currency = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Currency"));
				Home = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Home"));
				OrderStatus = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("OrderStatus"));
				TestType = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("TestType"));

			}

			Utils.click(By.xpath(getObj("Propval1", "Accounts", "eCorp_ACCOUNT_OPEN_ADDITIONAL_ACCOUNT")), "Accounts link");
			// Click on Open Additional Account
			Utils.click(By.xpath(getObj("Propval1", "openAccount", "eCorp_ACCOUNT_OPEN_ADDITIONAL_ACCOUNT")), "Open Additional Account link");
			// Clear Currecny
			Utils.ClearText(By.xpath(getObj("Propval1", "Currency", "eCorp_ACCOUNT_OPEN_ADDITIONAL_ACCOUNT")));
			// Select Currency
			Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "CurrencyDropdown", "eCorp_ACCOUNT_OPEN_ADDITIONAL_ACCOUNT")), By.xpath(getObj("Propval1", "Currency", "eCorp_ACCOUNT_OPEN_ADDITIONAL_ACCOUNT")), Currency, "Currency");

			if (TestType.equalsIgnoreCase("N")) {
				Utils.click(By.xpath(getObj("Propval1", "AccountDropdown", "eCorp_ACCOUNT_OPEN_ADDITIONAL_ACCOUNT")), "AccountDropdown");
				Utils.sendKeys(By.xpath(getObj("Propval1", "Account", "eCorp_ACCOUNT_OPEN_ADDITIONAL_ACCOUNT")), ReadTestData(TCName, "InvalidAccountNumber"), "InvalidAccountNumber");
			} else {
				// Clear Accounts
				Utils.ClearText(By.xpath(getObj("Propval1", "Account", "eCorp_ACCOUNT_OPEN_ADDITIONAL_ACCOUNT")));
				// Select Account
				Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "AccountDropdown", "eCorp_ACCOUNT_OPEN_ADDITIONAL_ACCOUNT")), By.xpath(getObj("Propval1", "Account", "eCorp_ACCOUNT_OPEN_ADDITIONAL_ACCOUNT")),
						ReadTestData(TCName, "AccountNumber"), "Account Dropdown");
			}
			if (Integer.parseInt(Proceed) == 1) {
				// Click on Proceed Button
				Utils.click(By.xpath(getObj("Propval1", "Proceed", "eCorp_ACCOUNT_OPEN_ADDITIONAL_ACCOUNT")), "Proceed button");
			} else {
				Utils.click(By.xpath(getObj("Propval1", "Cancel", "eCorp_ACCOUNT_OPEN_ADDITIONAL_ACCOUNT")), "Cancel button");
				Log.pass("Successfully canclled the transaction");
				Utils.logPassImage(TCName);
				return true;
			}

			if (TestType.equalsIgnoreCase("N")) {

				try {

					Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "WorngAccount", "eCorp_ACCOUNT_OPEN_ADDITIONAL_ACCOUNT")), "Wrong Account Number"));
					Log.pass("Entered Account Number is not valid");
					Utils.logPassImage(TCName);
					return true;
				}

				catch (AssertionError | Exception e) {
					Log.pass("Able to go to confirm page");
					Utils.logFailImage(TCName);

					throw e;
				}

			}

			if (Integer.parseInt(Confirm) == 1) {

				if (termConditions.equalsIgnoreCase("true")) {

					if (selectTnCfrompopup.equalsIgnoreCase("false")) {
						Utils.click(By.xpath(getObj("Propval1", "checkbox", "eCorp_ACCOUNT_OPEN_ADDITIONAL_ACCOUNT")), "Terms and Conditions checkbox");
					} else {

						Utils.click(By.xpath(getObj("Propval1", "TnCpoup", "eCorp_ACCOUNT_OPEN_ADDITIONAL_ACCOUNT")), "Terms and Conditions checkbox Pop UP");

						Utils.click(By.xpath(getObj("Propval1", "TnCAgree", "eCorp_ACCOUNT_OPEN_ADDITIONAL_ACCOUNT")), "Terms and Conditions checkbox Pop Up Agree");

						Log.pass("Successfully clicked on agree with T&C popup");
					}

				} else if (termConditions.equalsIgnoreCase("false")) {

					Utils.click(By.xpath(getObj("Propval1", "Confirm", "eCorp_ACCOUNT_OPEN_ADDITIONAL_ACCOUNT")), "Confirm button");
					Assert.assertTrue(Utils.getSize(By.xpath(getObj("Propval1", "OTPTextbox", "eCorp_ACCOUNT_OPEN_ADDITIONAL_ACCOUNT"))) == 0);
					Utils.click(By.xpath(getObj("Propval1", "openAccount", "eCorp_ACCOUNT_OPEN_ADDITIONAL_ACCOUNT")), "Open Additional Account link");
					Utils.click(By.xpath(getObj("Propval1", "Cancelyes", "eCorp_ACCOUNT_OPEN_ADDITIONAL_ACCOUNT")), "CancelYes button");
					Log.pass("As expected - User is unable to open additional account without accepting 'terms and conditions'");
					Utils.logPassImage(TCName);
					return true;

				}
				Utils.wait(5);
				// Click on Confirm Button
				Utils.click(By.xpath(getObj("Propval1", "Confirm", "eCorp_ACCOUNT_OPEN_ADDITIONAL_ACCOUNT")), "Confirm button");

			} else if (Integer.parseInt(Confirm) == 2) {
				// Click on Modify
				Utils.click(By.xpath(getObj("Propval1", "Modfy", "eCorp_ACCOUNT_OPEN_ADDITIONAL_ACCOUNT")), "Modify button");
				// Modify Currency
				Utils.ClearText(By.xpath(getObj("Propval1", "Currency", "eCorp_ACCOUNT_OPEN_ADDITIONAL_ACCOUNT")));
				// Select Currency
				Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "CurrencyDropdown", "eCorp_ACCOUNT_OPEN_ADDITIONAL_ACCOUNT")), By.xpath(getObj("Propval1", "Currency", "eCorp_ACCOUNT_OPEN_ADDITIONAL_ACCOUNT")),
						Input.ReadTestData(TCName, "ModifyCurrency"), "Currency");

				// Clear Accounts
				Utils.ClearText(By.xpath(getObj("Propval1", "Account", "eCorp_ACCOUNT_OPEN_ADDITIONAL_ACCOUNT")));
				// Select Account
				Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "AccountDropdown", "eCorp_ACCOUNT_OPEN_ADDITIONAL_ACCOUNT")), By.xpath(getObj("Propval1", "Account", "eCorp_ACCOUNT_OPEN_ADDITIONAL_ACCOUNT")),
						Input.ReadTestData(TCName, "AccountNumber"), "Account Number");

				Utils.wait(5);
				// Click on Proceed
				Utils.click(By.xpath(getObj("Propval1", "Proceed", "eCorp_ACCOUNT_OPEN_ADDITIONAL_ACCOUNT")), "Proceed button");

				// ..........

				if (termConditions.equalsIgnoreCase("true")) {
					Utils.click(By.xpath(getObj("Propval1", "checkbox", "eCorp_ACCOUNT_OPEN_ADDITIONAL_ACCOUNT")), "Terms and Conditions checkbox");

				} else if (termConditions.equalsIgnoreCase("false")) {

					Utils.click(By.xpath(getObj("Propval1", "Confirm", "eCorp_ACCOUNT_OPEN_ADDITIONAL_ACCOUNT")), "Confirm button");

					try {
						WebElement elemToFind = driver.findElement(By.xpath(getObj("Propval1", "OTPTextbox", "eCorp_ACCOUNT_OPEN_ADDITIONAL_ACCOUNT")));
						boolean elementstatus = elemToFind.isDisplayed();

					} catch (NoSuchElementException e) {
						Log.pass("As expected - OTP text box is not appearing after clicking on confirm button");
					}

					Utils.click(By.xpath(getObj("Propval1", "openAccount", "eCorp_ACCOUNT_OPEN_ADDITIONAL_ACCOUNT")), "Open Additional Account link");
					Utils.click(By.xpath(getObj("Propval1", "Cancelyes", "eCorp_ACCOUNT_OPEN_ADDITIONAL_ACCOUNT")), "Cancel-Yes button");
					Log.pass("As expected - User is unable to open additional account without accepting 'terms and conditions'");
					Utils.logPassImage(TCName);
					return true;

				}

				Utils.wait(5);
				// Click on Proceed Button
				Utils.click(By.xpath(getObj("Propval1", "Confirm", "eCorp_ACCOUNT_OPEN_ADDITIONAL_ACCOUNT")), "Confirm button");

			} else {
				Utils.click(By.xpath(getObj("Propval1", "Cancel", "eCorp_ACCOUNT_OPEN_ADDITIONAL_ACCOUNT")), "Cancel button");
				Utils.click(By.xpath(getObj("Propval1", "Cancelyes", "eCorp_ACCOUNT_OPEN_ADDITIONAL_ACCOUNT")), "Cancel-Yes button");
				Log.pass("Successfully cancelled the transaction");
				Utils.logPassImage(TCName);
				return true;

			}

			Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "WaitingElements", "eCorp_ACCOUNT_OPEN_ADDITIONAL_ACCOUNT")));

			try {
				Utils.wait(4);
				Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "SuccessMsg", "eCorp_ACCOUNT_OPEN_ADDITIONAL_ACCOUNT")), "Success Message"));
				Log.pass("Additional account opened successfully...");
				Utils.logPassImage("Additional account opened successfully");
			}

			catch (AssertionError | Exception e) {
				Log.fail("Unable to open additional account... error message displayed is.." + Utils.getText(By.xpath(getObj("Propval1", "ErrorMsg", "eCorp_ACCOUNT_OPEN_ADDITIONAL_ACCOUNT"))));
				Utils.logFailImage("Unable to open additional account");
				throw e;
			}

			if (AdditionalOptions.equalsIgnoreCase("true")) {
				Log.pass("Starting additional actions after transfer. e.g send email, print and save as favourite.");
				TransferModuleCommonFunctions.addFavSendEmailDownloadPdfNprint();
				Log.pass("Additional Actions  like send email, print and download pdf/excel etc have  passed successfully.");
				Utils.logPassImage("Additional Actions");
			}

			if (NewTxn.equalsIgnoreCase("true")) {

				Utils.scrollDownVertically();
				Utils.click(By.xpath(getObj("Propval1", "NewTransactionBtn", "eCorp_ACCOUNT_OPEN_ADDITIONAL_ACCOUNT")), "New Transaction button");
				Utils.wait(11);
				try {
					Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "proceed", "eCorp_ACCOUNT_OPEN_ADDITIONAL_ACCOUNT")), "New Transactions creeen"));
					Log.pass(" Add another  transaction screen is displayed successfully");
					Utils.logPassImage("New Transaction");

				} catch (AssertionError | Exception e) {
					Log.fail("Unable to navigate toNew Transaction screen..error..");
					Utils.logFailImage("New Transaction");
					throw e;
				}
			}

			else if (Home.equalsIgnoreCase("true")) {

				Log.pass("Starting navigation to home screen");
				Utils.clickSafely(By.xpath(getObj("Propval1", "HomeBtn", "Add_New_Beneficiary")), "Home Button");

				try {

					Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "HomepageSuccess", "eCorp_ACCOUNT_OPEN_ADDITIONAL_ACCOUNT")), "Home Page"));
					Log.info("Successfully navigated to home screen");
					Utils.logPassImage("Home Screen");

				} catch (AssertionError | Exception e) {
					Log.fail("Unable to navigate to home screen..error..");
					Utils.logFailImage("Home Screen");
					throw e;
				}

			} else if (OrderStatus.equalsIgnoreCase("true")) {

				Log.pass("Starting navigation to Order Status screen");
				Utils.click(By.xpath(getObj("Propval1", "OrderStatus", "eCorp_ACCOUNT_OPEN_ADDITIONAL_ACCOUNT")), "Order Status button");
				Utils.logPassImage("Order Status Screen");

				try {

					Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "OrderStatus_Search", "eCorp_ACCOUNT_OPEN_ADDITIONAL_ACCOUNT")), "Order Status"));
					Log.info("Successfully navigated to Order Status");
					Utils.logPassImage("Order Status");

				} catch (AssertionError | Exception e) {
					Log.fail("Unable to navigate toOrder Status screen..error..");
					Utils.logFailImage("Order Status Screen");
					throw e;
				}

			}

			else {
				Log.pass("Starting navigation to home screen by default.");
				Utils.clickSafely(By.xpath(getObj("Propval1", "HomeBtn", "Add_New_Beneficiary")), "Home Button");
				Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "HomepageSuccess", "eCorp_ACCOUNT_OPEN_ADDITIONAL_ACCOUNT")), "Home Page"));
				Log.info("Successfully navigated to home screen");
			}

		} catch (AssertionError | Exception e) {
			runResult = false;
			throw e;
		}

		return runResult;
	}

}
