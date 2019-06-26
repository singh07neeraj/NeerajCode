package javaMain.eCorp.accounts;

import static Utilities.Input.ReadTestData;
import static Utilities.ReadData.ReadDataSQL;
import static Utilities.ReadData.getObj;
import static javaMain.common_Functions.AppData.AccountNumber;
import static javaMain.common_Functions.AppData.AfterTxfrAdditionalOptions;
import static javaMain.common_Functions.AppData.Branch;
import static javaMain.common_Functions.AppData.Confirm;
import static javaMain.common_Functions.AppData.Menu;
import static javaMain.common_Functions.AppData.Proceed;
import static javaMain.common_Functions.AppData.Type;
import static javaMain.common_Functions.AppData.isNegative;
import static javaMain.common_Functions.AppData.nextstep;
import static javaMain.common_Functions.AppData.other;

import org.openqa.selenium.By;
import org.testng.Assert;

import Utilities.Log;
import Utilities.ReadData;
import Utilities.TestBase;
import Utilities.Utils;
import javaMain.common_Functions.eCorpCommonFunctions;

/**
 * Description : Functional Test Script
 * 
 * @author baj80000892
 */

public class eCorp_ACCOUNTS_eCorp_OrderCheckBook extends TestBase {

	public static boolean eCorp_ACCOUNTS_eCorp_OrderCheckBook_Func(String TCName, int ScenarioCount, Object[] tCsDataset) throws Exception {
		
		try {

			if (isMasterClassRun) {
				Log.pass("Data set for this scenario is " + System.lineSeparator() + ReadData.getJsonData(TCName, ScenarioCount, "DataSet"));
				Menu = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Menu"));
				Proceed = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Proceed"));
				Confirm = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Confirm"));
				nextstep = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "nextstep"));
				AccountNumber = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "AccountNumber"));
				Branch = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Branch"));
				Type = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Type"));
				other = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "other"));
				AfterTxfrAdditionalOptions = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "AfterTxfrAdditionalOptions"));
				isNegative = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "isNegative"));
			}

			else {
				Log.pass("Data set for this scenario is " + System.lineSeparator() + dataset[scenarioCount - 1]);
				Menu = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Menu"));
				Proceed = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Proceed"));
				Confirm = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Confirm"));
				nextstep = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("nextstep"));
				AccountNumber = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("AccountNumber"));
				Branch = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Branch"));
				Type = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Type"));
				other = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("other"));
				AfterTxfrAdditionalOptions = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("AfterTxfrAdditionalOptions"));
				isNegative = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("isNegative"));
			}

			Log.pass("Next Step is ............." + nextstep);

			Utils.wait(2);
			// Click on Accounts Tab//
			Utils.click(By.xpath(getObj("Propval1", "AccountsTab", "eCorp_OrderCheckBook")), "Accounts link");
			Utils.wait(4);
			// Click Beneficiaries Link on the left Panel//
			Utils.click(By.xpath(getObj("Propval1", "Checks", "eCorp_OrderCheckBook")), "Checks link");
			Utils.wait(4);

			// Click AddBeneficiary Link on the left Panel//
			Utils.click(By.xpath(getObj("Propval1", "OrderCheckBookLnk_Menu_Y", "eCorp_OrderCheckBook")), "Order Checkbook link");

			// Enter Account No

			Utils.ClearText(By.xpath(getObj("Propval1", "Account", "eCorp_OrderCheckBook")));
			Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "Accountdropdown", "eCorp_OrderCheckBook")), By.xpath(getObj("Propval1", "Account", "eCorp_OrderCheckBook")), ReadTestData(TCName, "AccountNumber"));

			Utils.wait(4);

			if (isNegative.equalsIgnoreCase("true")) {

				try {

					Utils.click(By.xpath(getObj("Propval1", "Branchdropdown", "eCorp_OrderCheckBook")), "Branchdropdown");
					Utils.sendKeys(By.xpath(getObj("Propval1", "Branch", "eCorp_OrderCheckBook")), ReadTestData(TCName, "NegativeBranch"), "NegativeBranch");
					Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "HomePageError", "eCorp_OrderCheckBook")), "values not vaid"));
					Log.pass("Enter field is not valid. Terminating test case.");
					Utils.logPassImage(TCName);
					return true;
				}

				catch (AssertionError | Exception e) {
					Log.fail("No error occur while enter the wrong values hence test case fail");
					Utils.logFailImage(TCName);
					throw e;
				}

			}

			// Select No of Check

			Utils.ClearText(By.xpath(getObj("Propval1", "Branch", "eCorp_OrderCheckBook")));
			Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "Branchdropdown", "eCorp_OrderCheckBook")), By.xpath(getObj("Propval1", "Branch", "eCorp_OrderCheckBook")), ReadTestData(TCName, "Branch"));

			// Select Branch

			Utils.ClearText(By.xpath(getObj("Propval1", "checkBookType", "eCorp_OrderCheckBook")));
			Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "checkBookTypedropdown", "eCorp_OrderCheckBook")), By.xpath(getObj("Propval1", "checkBookType", "eCorp_OrderCheckBook")), ReadTestData(TCName, "Type"));

			Utils.wait(4);
			// Select check book type

			Utils.ClearText(By.xpath(getObj("Propval1", "numberOfcheckbooks", "eCorp_OrderCheckBook")));
			Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "numberOfcheckbooksdropdown", "eCorp_OrderCheckBook")), By.xpath(getObj("Propval1", "numberOfcheckbooks", "eCorp_OrderCheckBook")), ReadTestData(TCName, "other"));

			Utils.wait(4);

			// Select Branch//
			Utils.wait(2);
			int ProceedType = Integer.parseInt(Proceed);
			if (ProceedType == 1) {
				// Click on Proceed Button//
				Utils.click(By.xpath(getObj("Propval1", "ProceedBtn", "eCorp_OrderCheckBook")), "Proceed Button");

			}

			else if (ProceedType == 2) {
				// Click on OrderStatus//
				Utils.click(By.xpath(getObj("Propval1", "OrderStatus", "eCorp_OrderCheckBook")), "OrderStatus button");
				return runResult;
			}

			else if (ProceedType == 3) {
				// Click on Cancel Button//
				Utils.click(By.xpath(getObj("Propval1", "CancelTransBtn", "eCorp_OrderCheckBook")), "Cancel button");
				return runResult;
			}

			int ConfirmType = Integer.parseInt(Confirm);
			if (ConfirmType == 1) {
				// Click on Confirm Button//
				Utils.click(By.xpath(getObj("Propval1", "ConfirmBtn", "eCorp_OrderCheckBook")), "Confirm Button");
			} else if (ConfirmType == 2) {

				// Click on Modify Button//
				Utils.click(By.xpath(getObj("Propval1", "ModifyBtn", "eCorp_OrderCheckBook")), "Modify button");

				Utils.wait(5);

				// Click on Proceed Button//
				Utils.click(By.xpath(getObj("Propval1", "ProceedBtn", "eCorp_OrderCheckBook")), "Proceed Button");

				// Click on Confirm Button//
				Utils.click(By.xpath(getObj("Propval1", "ConfirmBtn", "eCorp_OrderCheckBook")), "Confirm Button");

			}

			else if (ConfirmType == 3) {

				// Click on Cancel Button//
				Utils.click(By.xpath(getObj("Propval1", "CancelTransBtn", "eCorp_OrderCheckBook")), "Cancel button");
				Utils.wait(2);

				Utils.click(By.xpath(getObj("Propval1", "CancelTransBtn_Confirm", "eCorp_OrderCheckBook")), "Cancel_Yes button");
				Utils.logPassImage(TCName);
				return runResult;

			}

			String SuccessCount = Utils.getText(By.xpath(getObj("Propval1", "SuccessMessage", "eCorp_OrderCheckBook")));
			Log.pass("Dispalyed message is " + SuccessCount);

			if (AfterTxfrAdditionalOptions.equalsIgnoreCase("true")) {
				Log.pass("Starting additional actions after transfer. e.g send email, print and save as favourite.");
				eCorpCommonFunctions.sendEmailDownloadExcelnPrintFunc(ScenarioCount);
				Log.pass("Additional Actions  like send email, print and download pdf/excel etc have  passed successfully.");
				Utils.logPassImage("Additional Actions");
			}
			if (nextstep.equalsIgnoreCase("OrdersStatus")) {

				Utils.click(By.xpath(getObj("Propval1", "OrdersStatus", "eCorp_OrderCheckBook")), "Orders Status Search");
				Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "OrdersStatusSearch", "eCorp_OrderCheckBook")), "OrdersStatusSearch"));
				Log.pass("order status Page is  landed succesfully");

				Utils.logPassImage(TCName);

			}

			else if (nextstep.equalsIgnoreCase("NewTransaction"))

			{
				Utils.click(By.xpath(getObj("Propval1", "NewTransaction", "eCorp_OrderCheckBook")), "New Transaction");
				Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "ProceedBtn", "eCorp_OrderCheckBook")), "ProceedBtn"));

				Log.pass("New Transaction Page is  landed succesfully");
				Utils.logPassImage(TCName);

			} else {
				Utils.click(By.xpath(getObj("Propval1", "Home", "eCorp_OrderCheckBook")), "Home button");

				Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "HomeGraphic", "eCorp_OrderCheckBook")), "HomeGraphic"));

				Log.pass("Home Page is  landed succesfully");
				Utils.logPassImage(TCName);

			}
		}

		catch (Exception e) {
			runResult = false;
			e.printStackTrace();
			throw e;
		}
		return runResult;
	}

}