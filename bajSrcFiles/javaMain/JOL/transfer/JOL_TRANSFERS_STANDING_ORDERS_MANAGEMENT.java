package javaMain.JOL.transfer;

import static Utilities.Input.ReadTestData;
import static Utilities.ReadData.ReadDataSQL;
import static Utilities.ReadData.getObj;
import static javaMain.common_Functions.AppData.AdditionalActions;
import static javaMain.common_Functions.AppData.Frequency;
import static javaMain.common_Functions.AppData.confirmSkip;
import static javaMain.common_Functions.AppData.deleteDetails;
import static javaMain.common_Functions.AppData.edit;
import static javaMain.common_Functions.AppData.showDetails;
import static javaMain.common_Functions.AppData.skipNextTransfer;

import org.openqa.selenium.By;
import org.testng.Assert;

import Utilities.Input;
import Utilities.Log;
import Utilities.ReadData;
import Utilities.TestBase;
import Utilities.Utils;
import javaMain.common_Functions.OpenJOLMenues;
/**
 * Description : Functional Test Script
 * 
 * @author baj80000892
 */
public class JOL_TRANSFERS_STANDING_ORDERS_MANAGEMENT extends TestBase {

	@SuppressWarnings("unused")
	public static boolean JOL_TRANSFERS_STANDING_ORDERS_MANAGEMENT_functions(String TCName, int ScenarioCount, Object[] tCsDataset) throws Exception {


		try {

			if (isMasterClassRun) {

				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + ReadData.getJsonData(TCName, ScenarioCount, "DataSet") + "</mark>");
				showDetails = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "showDetails"));
				deleteDetails = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "deleteDetails"));
				skipNextTransfer = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "skipNextTransfer"));
				edit = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "edit"));
				confirmSkip = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "confirmSkip"));
				AdditionalActions = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "AfterTxfrAdditionalOptions"));
				Frequency = Utils.setValue(ReadDataSQL(TCName, 7, "Frequency"));
			} else {
				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + dataset[scenarioCount - 1] + "</mark>");
				showDetails = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("showDetails"));
				deleteDetails = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("deleteDetails"));
				skipNextTransfer = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("skipNextTransfer"));
				edit = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("edit"));
				confirmSkip = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("confirmSkip"));
				AdditionalActions = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("AfterTxfrAdditionalOptions"));
				Frequency = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Frequency"));

			}

			// Open Standing orders management screen.
			OpenJOLMenues.openTransfersMenu("StandingOrders");
			
			Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "AccountNumberDropdownDropdown", "STANDING_ORDERS_MANAGEMENT")), By.xpath(getObj("Propval1", "AccountNumber", "STANDING_ORDERS_MANAGEMENT")), Input.ReadTestData(TCName, "AccountNumber")," Account dropdown.");
			Log.pass("Selected Account Number is   is :" + ReadTestData("LocalTransfer", "AccountNumber"));
			Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "freqDropDown", "STANDING_ORDERS_MANAGEMENT")), By.xpath(getObj("Propval1", "freq", "STANDING_ORDERS_MANAGEMENT")), Frequency,"Frequency");
			// Click on Search
			Utils.click(By.xpath(getObj("Propval1", "Search", "STANDING_ORDERS_MANAGEMENT")), " Search");

			try {

				Utils.wait(5);
				Assert.assertFalse(Utils.assertDisplayed(By.xpath(getObj("Propval1", "noSearchResult", "STANDING_ORDERS_MANAGEMENT")), "Result Details."));
				Log.pass("Search result displayed on screen is :" + Utils.getText(By.xpath(getObj("Propval1", "SearchResult", "STANDING_ORDERS_MANAGEMENT"))));
				
			} catch (AssertionError | Exception e) {

				Log.pass("No search results displayed on screen. Displayed text is : "+Utils.getText(By.xpath(getObj("Propval1", "noSearchResult", "STANDING_ORDERS_MANAGEMENT"))));
				Log.info("Setting other dependent actions like 'showDetails/edit details and skip transactions' as false and exiting test case.");
				showDetails="false";
				return true;
			}

			if (showDetails.equalsIgnoreCase("true")) {
				Utils.click(By.xpath(getObj("Propval1", "showDetails", "STANDING_ORDERS_MANAGEMENT")), "show details");

				if (deleteDetails.equalsIgnoreCase("true")) {

					Utils.click(By.xpath(getObj("Propval1", "deleteDetails", "STANDING_ORDERS_MANAGEMENT")), "delete details");
					Utils.click(By.xpath(getObj("Propval1", "confirmBtn", "STANDING_ORDERS_MANAGEMENT")), "confirm button");
					Utils.enterOTPAndProceed();
					Utils.logPassImage("Delete Details");
					try {
						Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "deleteSuccessMessage", "STANDING_ORDERS_MANAGEMENT")), "Delete success message"));
						Log.pass("Successfully deleted standing order details. Message displayed is :" + Utils.getText(By.xpath(getObj("Propval1", "deleteSuccessMessage", "STANDING_ORDERS_MANAGEMENT"))));
						Utils.click(By.xpath(getObj("Propval1", "backToStandingOrders", "STANDING_ORDERS_MANAGEMENT")), "back to standing orders management");
					}

					catch (AssertionError | Exception e) {
						Log.fail("Unable to delete standing order details. error .. :");
						throw e;
					}

				}

				if (skipNextTransfer.equalsIgnoreCase("true")) {

					Utils.click(By.xpath(getObj("Propval1", "skipNextTransfer", "STANDING_ORDERS_MANAGEMENT")), "skip next transfer");

					if (confirmSkip.equalsIgnoreCase("true")) {

						Utils.click(By.xpath(getObj("Propval1", "confirmBtn", "STANDING_ORDERS_MANAGEMENT")), "confirm button");
						Log.pass("Successfully skipped next transfer from standing orders management.");
						Utils.enterOTPAndProceed();
						Utils.wait(6);
						Utils.logPassImage(" Details");
						Utils.click(By.xpath(getObj("Propval1", "backToStandingOrders", "STANDING_ORDERS_MANAGEMENT")), "back to standing orders management");

						return true;
					}
					if (confirmSkip.equalsIgnoreCase("false")) {

						Utils.click(By.xpath(getObj("Propval1", "cancelBtn", "STANDING_ORDERS_MANAGEMENT")), "cancel button");
						Utils.logPassImage(" Details");
						Utils.click(By.xpath(getObj("Propval1", "cancelYes", "STANDING_ORDERS_MANAGEMENT")), "cancel button");
						Utils.logPassImage(" Details");
						Log.pass("Successfully cancelled skipping of standing orders management.");
						return true;
					}
				}

				if (edit.equalsIgnoreCase("true")) {

					Utils.click(By.xpath(getObj("Propval1", "editBtn", "STANDING_ORDERS_MANAGEMENT")), "edit transaction button");
					Utils.logPassImage("edit btn");
					Utils.wait(4);
					Utils.click(By.xpath(getObj("Propval1", "proceedBtn", "STANDING_ORDERS_MANAGEMENT")), "proceed button");
					Utils.click(By.xpath(getObj("Propval1", "confirmBtn", "STANDING_ORDERS_MANAGEMENT")), "confirm button");
					Utils.enterOTPAndProceed();

					try {
						Utils.wait(8);
						Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "editSuccessMessage", "STANDING_ORDERS_MANAGEMENT")), "Edit success message"));
						Log.pass("Successfully edited standing order details. Message displayed is :" + Utils.getText(By.xpath(getObj("Propval1", "editSuccessMessage", "STANDING_ORDERS_MANAGEMENT"))));
					} catch (AssertionError | Exception e) {
						Log.fail("Unable to edit standing order details. error :");
						throw e;
					}

					Utils.click(By.xpath(getObj("Propval1", "backToStandingOrders", "STANDING_ORDERS_MANAGEMENT")), "back to standing orders management");

				}

			}
			// After transaction common functions like send email, print pdf, download excel
			// etc.
			if (AdditionalActions.equalsIgnoreCase("true")) {
				TransferModuleCommonFunctions.sendEmailDownloadExcelnPrintFunc();
			}
		} catch (Exception e) {
			runResult = false;
			throw e;

		}
		return runResult;
	}

}
