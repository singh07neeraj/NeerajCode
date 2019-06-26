package javaMain.eCorp.accounts;

import static Utilities.ReadData.ReadDataSQL;
import static Utilities.ReadData.getObj;
import static javaMain.common_Functions.AppData.AfterTxfrAdditionalOptions;
import static javaMain.common_Functions.AppData.Confirm;
import static javaMain.common_Functions.AppData.FutureDate;
import static javaMain.common_Functions.AppData.NextDate;
import static javaMain.common_Functions.AppData.Proceed;
import static javaMain.common_Functions.AppData.isNegative;
import static javaMain.common_Functions.AppData.nextstep;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Utilities.Input;
import Utilities.Log;
import Utilities.ReadData;
import Utilities.TestBase;
import Utilities.Utils;
import javaMain.common_Functions.JolCommonFunctions;
/**
 * Description : Functional Test Script
 * 
 * @author baj80000892
 */
public class eCorp_ACCOUNT_REQUEST_STEMENT_BYMAIL_FUNC extends TestBase {

	public static Boolean eCorpaccountemail(String TCName, int ScenarioCount, Object[] tCsDataset) throws Exception {

		try {

			if (isMasterClassRun) {
				Log.pass("Data set for this scenario is " + System.lineSeparator() + ReadData.getJsonData(TCName, ScenarioCount, "DataSet"));
				Proceed = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Proceed"));
				Confirm = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Confirm"));
				NextDate = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "NextDate"));
				FutureDate = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "FutureDate"));
				nextstep = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "nextstep"));
				AfterTxfrAdditionalOptions = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "AfterTxfrAdditionalOptions"));
				isNegative = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "isNegative"));

			}

			else {
				Log.pass("Data set for this scenario is " + System.lineSeparator() + dataset[scenarioCount - 1]);
				Proceed = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Proceed"));
				Confirm = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Confirm"));
				NextDate = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("NextDate"));
				FutureDate = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("FutureDate"));
				nextstep = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("nextstep"));
				AfterTxfrAdditionalOptions = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("AfterTxfrAdditionalOptions"));
				isNegative = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("isNegative"));
			}
			
			Log.pass("nextstep is : " + nextstep);
			// click on Account Top
			Utils.click(By.xpath(getObj("Propval1", "Accounts", "eCorp_ACCOUNT_REQUEST_STEMENT")), "Accounts link");
			Utils.wait(10);

			// Click on Account Summary
			Utils.click(By.xpath(getObj("Propval1", "Requestemail", "eCorp_ACCOUNT_REQUEST_STEMENT")), "Request Statement by Mail link");

			if (isNegative.equalsIgnoreCase("true")) {
				Utils.click(By.xpath(getObj("Propval1", "Accountdropdown", "eCorp_ACCOUNT_REQUEST_STEMENT")), "StartDatedropdown");
				Utils.sendKeys(By.xpath(getObj("Propval1", "Account", "eCorp_ACCOUNT_REQUEST_STEMENT")), Input.ReadTestData(TCName, "InvalidAccountNumber"), "Account");

			} else {
				Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "Accountdropdown", "eCorp_ACCOUNT_REQUEST_STEMENT")), By.xpath(getObj("Propval1", "Account", "eCorp_ACCOUNT_REQUEST_STEMENT")), Input.ReadTestData(TCName, "AccountNumber"));
			}
			WebElement StartDate = driver.findElement(By.xpath(getObj("Propval1", "StartDate", "eCorp_ACCOUNT_REQUEST_STEMENT")));
			StartDate.sendKeys(Input.ReadTestData(TCName, "NextDate"));

			WebElement endtDate = driver.findElement(By.xpath(getObj("Propval1", "endDate", "eCorp_ACCOUNT_REQUEST_STEMENT")));
			endtDate.sendKeys(Input.ReadTestData(TCName, "FutureDate"));

			Utils.wait(4);
			if (Integer.parseInt(Proceed) == 1) {
				// Click on Proceed Button
				Utils.click(By.xpath(getObj("Propval1", "Proceed", "eCorp_ACCOUNT_REQUEST_STEMENT")), "Proceed button");
			}

			else {
				// Click on Cancel
				Utils.click(By.xpath(getObj("Propval1", "Cancel", "eCorp_ACCOUNT_REQUEST_STEMENT")), "Cancel button");
				return runResult;
			}

			Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "WaitingElements", "eCorp_ACCOUNT_REQUEST_STEMENT")));

			if (isNegative.equalsIgnoreCase("true")) {

				try {

					Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "TransactionNotFound", "eCorp_ACCOUNT_REQUEST_STEMENT")), "Txn not found message"));
					Log.pass("error found with invalid account number hence test case pass");
					Utils.logPassImage(TCName);
					return true;
				}

				catch (AssertionError | Exception e) {
					Log.fail("No error found with invalid account number hence test case fail");
					Utils.logFailImage(TCName);
				}

			}

			Utils.wait(3);
			if (Integer.parseInt(Confirm) == 1) {
				Utils.click(By.xpath(getObj("Propval1", "Confirm", "eCorp_ACCOUNT_REQUEST_STEMENT")), "Confirm button");

				Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "WaitingElements", "eCorp_ACCOUNT_REQUEST_STEMENT")));

			}

			else if (Integer.parseInt(Confirm) == 2) {
				Utils.click(By.xpath(getObj("Propval1", "Modfy", "eCorp_ACCOUNT_REQUEST_STEMENT")), "Modify button");

				Utils.ClearText(By.xpath(getObj("Propval1", "Account", "eCorp_ACCOUNT_REQUEST_STEMENT")));
				Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "Accountdropdown", "eCorp_ACCOUNT_REQUEST_STEMENT")), By.xpath(getObj("Propval1", "Account", "eCorp_ACCOUNT_REQUEST_STEMENT")), Input.ReadTestData(TCName, "AccountNumber"));

				Utils.wait(3);
				Utils.click(By.xpath(getObj("Propval1", "Proceed", "eCorp_ACCOUNT_REQUEST_STEMENT")), "Proceed button");
				Utils.wait(3);
				Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "WaitingElements", "eCorp_ACCOUNT_REQUEST_STEMENT")));

				Utils.click(By.xpath(getObj("Propval1", "Confirm", "eCorp_ACCOUNT_REQUEST_STEMENT")), "Confirm button");

			} else {
				Utils.click(By.xpath(getObj("Propval1", "Cancel", "eCorp_ACCOUNT_REQUEST_STEMENT")), "Cancel button");
				Utils.wait(3);
				Utils.click(By.xpath(getObj("Propval1", "Cancelyes", "eCorp_ACCOUNT_REQUEST_STEMENT")), "CancelYes button");
				return runResult;
			}

			Utils.wait(10);
			Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "WaitingElements", "eCorp_ACCOUNT_REQUEST_STEMENT")));
			String Sucess = Utils.getText(By.xpath(getObj("Propval1", "SuccessMsg", "eCorp_ACCOUNT_REQUEST_STEMENT")));
			Log.pass("Displayed Message is " + Sucess);
			Utils.logPassImage(TCName);

			if (AfterTxfrAdditionalOptions.equalsIgnoreCase("true")) {
				Log.pass("Starting additional actions after transfer. e.g send email, print and save as favourite.");
				JolCommonFunctions.sendEmailDownloadExcelnPrintFunc(ScenarioCount);
				Log.pass("Additional Actions  like send email, print and download pdf/excel etc have  passed successfully.");
				Utils.logPassImage("Additional Actions");
			}

			if (nextstep.equalsIgnoreCase("NewTransaction"))

			{
				Utils.click(By.xpath(getObj("Propval1", "NewTransaction", "eCorp_ACCOUNT_REQUEST_STEMENT")), "New Transaction");
				Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "ProceedBtn", "eCorp_ACCOUNT_REQUEST_STEMENT")), "ProceedBtn"));
				Log.pass("New Transaction Page is  landed succesfully");

			} else {
				Utils.click(By.xpath(getObj("Propval1", "Home", "eCorp_ACCOUNT_REQUEST_STEMENT")), "Home button");
				Utils.wait(5);
				Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "HomeGraphic", "eCorp_ACCOUNT_REQUEST_STEMENT")), "HomeGraphic"));
				Log.pass("Home Page is  landed succesfully");

			}
		} catch (Exception e) {
			runResult = false;
			throw e;
		}
		return runResult;
	}

	

}
