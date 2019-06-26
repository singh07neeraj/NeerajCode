package javaMain.JOL.transfer;

import static Utilities.Input.ReadTestData;
import static Utilities.ReadData.ReadDataSQL;
import static Utilities.ReadData.getObj;
import static javaMain.common_Functions.AppData.AdditionalActions;
import static javaMain.common_Functions.AppData.FromAcc;
import static javaMain.common_Functions.AppData.ProceedEmail;
import static javaMain.common_Functions.AppData.StartDate;
import static javaMain.common_Functions.AppData.TransferType;
import static javaMain.common_Functions.AppData.ViewDetails;
import static javaMain.common_Functions.AppData.endDate;
import static javaMain.common_Functions.AppData.sendEmail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Utilities.Input;
import Utilities.Log;
import Utilities.ReadData;
import Utilities.TestBase;
import Utilities.Utils;
import javaMain.common_Functions.AppData;
import javaMain.common_Functions.OpenJOLMenues;

/**
 * Description : Functional Test Script
 * 
 * @author baj80000892
 */
public class JOL_TRANSFERS_HISTORY extends TestBase {

	public static boolean JOL_TRANSFERS_HISTORY_functions(String TCName, int ScenarioCount, Object[] tCsDataset) throws Exception {

		try {

			if (isMasterClassRun) {

				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + ReadData.getJsonData(TCName, ScenarioCount, "DataSet") + "</mark>");
				StartDate = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "StartDate"));// Start and end dates can be read from excel sheet also if required.
				endDate = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "endDate"));
				sendEmail = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "sendEmail"));
				ProceedEmail = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "ProceedEmail"));
				AdditionalActions = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "AdditionalActions"));
				ViewDetails = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "ViewDetails"));
				TransferType = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "TransferType"));
			} else {
				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + dataset[scenarioCount - 1] + "</mark>");
				StartDate = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("StartDate"));
				endDate = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("endDate"));
				sendEmail = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("sendEmail"));
				ProceedEmail = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("ProceedEmail"));
				AdditionalActions = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("AdditionalActions"));
				ViewDetails = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("ViewDetails"));
				TransferType = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("TransferType"));
			}

			if (TransferType.equalsIgnoreCase("SarToBeneficiary")) {
				FromAcc = AppData.getFromAccountSAR();
			} else if (TransferType.equalsIgnoreCase("ForeignToBeneficiary")) {
				FromAcc = AppData.getFromAccountForeign();
			} else {
				FromAcc = Input.ReadTestData(TCName, "AccountNumber");
			}

			// Open Transfers- History page.
			OpenJOLMenues.openTransfersMenu("TransfersHistory");

			Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "AccountNumberDropdownDropdown", "JOL_TRANSFERS_HISTORY")), By.xpath(getObj("Propval1", "AccountNumber", "JOL_TRANSFERS_HISTORY")), FromAcc, "From account dropdown.");
			Log.pass("Selected Account Number is : " + FromAcc);

			Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "TransferTypeDropdown", "JOL_TRANSFERS_HISTORY")), By.xpath(getObj("Propval1", "TransferType1", "JOL_TRANSFERS_HISTORY")), ReadTestData(TCName, "TransferType"),
					"Transfer Type dropdown.");

			Utils.wait(5);
			Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "beneficiarytypeDropdownDropdown", "JOL_TRANSFERS_HISTORY")), By.xpath(getObj("Propval1", "beneficiarytype", "JOL_TRANSFERS_HISTORY")), ReadTestData(TCName, "Beneficiary"),
					"Beneficiary Dropdown.");

			Log.pass("Selected Beneficiary value is : " + ReadTestData(TCName, "Beneficiary"));

			// Enter From and To amount.
			Utils.sendKeys(By.xpath(getObj("Propval1", "AmountFrom", "JOL_TRANSFERS_HISTORY")), ReadTestData(TCName, "FromAmount"), "From Amount");

			Utils.sendKeys(By.xpath(getObj("Propval1", "AmountTo", "JOL_TRANSFERS_HISTORY")), ReadTestData(TCName, "ToAmount"), "To Amount");

			Utils.wait(2);
			// Start Date
			WebElement sDate = driver.findElement(By.xpath(getObj("Propval1", "StartDate", "JOL_TRANSFERS_HISTORY")));
			sDate.sendKeys(Input.ReadTestData(TCName, "DateFrom"));

			// End Date
			WebElement eDate = driver.findElement(By.xpath(getObj("Propval1", "endDate", "JOL_TRANSFERS_HISTORY")));
			eDate.sendKeys(Input.ReadTestData(TCName, "DateTo"));

			// Search
			Utils.click(By.xpath(getObj("Propval1", "Search", "JOL_TRANSFERS_HISTORY")), "Search");
			Utils.wait(8);
			int x = Utils.getSizeNoException(By.xpath("(//*[@idx=\"0\"])[2]"));
			if (x > 0) {
				Log.pass("Transfer history records are displayed successfully.");
			} else {
				Log.pass("No transfer history details found...Skipping other test steps");
				return true;
			}

			Log.info("Search Result displayed on screen is : " + Utils.getText(By.xpath(getObj("Propval1", "SearchResult", "JOL_TRANSFERS_HISTORY"))));

			if (ViewDetails.equalsIgnoreCase("true")) {

				// View Details
				Utils.click(By.xpath("//*[contains(@onclick,'showTransferDetailsDialog_ns')]"), "View Details Icon");
				Utils.wait(3);
				Utils.logPassImage(TCName + " View Details ");
				Utils.clickSafely(By.xpath("(//*[@class=\"pdfGrid\"])[2]"), "pdf download on view details icon");
				Utils.wait(3);
				Utils.logPassImage(TCName + " pdf");
				Utils.closeOtherTabs();
				Utils.clickSafely(By.xpath("(//*[@class=\"printGrid\"])[2]"), "Print- view details icon");
				Utils.wait(3);
				Utils.logPassImage(TCName + " Print");
				Utils.closeOtherTabs();
				Utils.sendKeys(By.xpath("//*[contains(@id,'remarks_ns_Z7')]"), Input.ReadTestData(TCName, "Remarks"), "Remarks input field");
				Utils.wait(3);
				Utils.logPassImage(TCName + " Remarks");
				Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "tagDropDown", "JOL_TRANSFERS_HISTORY")), By.xpath(getObj("Propval1", "tagInput", "JOL_TRANSFERS_HISTORY")), Input.ReadTestData(TCName, "TagValue"), "Tag Name");
				Utils.clickSafely(By.xpath("//*[contains(@id,'buttonSave_ns_Z7')]"), "Save Button");
				Utils.clickSafely(By.id("dijit_form_Button_45_label"), "Accept Button");
				Utils.wait(3);
				Utils.logPassImage(TCName + " Accept Button");
				Utils.refreshScreeen();
				Utils.waitTillSaudiWaitIconDisappears();

				Log.pass("Successfully completed View details actions like download pdf, print and save as favourite etc from view details pop up window.");
				Utils.wait(3);
				Utils.pressEscapeKey(3);
			}

			// Start sending email , downloading pdf and printing etc.

			if (AdditionalActions.equalsIgnoreCase("true")) {

				Log.pass("Starting additional actions after transfer. e.g send email, print and save as favourite from the top left menu(EN)");
				TransferModuleCommonFunctions.sendEmailDownloadExcelnPrintFunc();
				Log.pass("Completed additional actions");
				Utils.wait(5);
				Utils.pressEscapeKey(3);
			}

		} catch (AssertionError | Exception e) {
			runResult = false;
			throw e;

		}
		return runResult;
	}
}
