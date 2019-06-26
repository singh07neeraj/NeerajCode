package javaMain.eCorp.PendingActions;

import static Utilities.ReadData.ReadDataSQL;
import static Utilities.ReadData.getObj;
import static javaMain.common_Functions.AppData.AdditionalActions;
import static javaMain.common_Functions.AppData.Approve;
import static javaMain.common_Functions.AppData.Cancel;
import static javaMain.common_Functions.AppData.CancelYes;
import static javaMain.common_Functions.AppData.Home;
import static javaMain.common_Functions.AppData.RejectCancel;
import static javaMain.common_Functions.AppData.Status;
import static javaMain.common_Functions.AppData.Transaction;
import static javaMain.common_Functions.AppData.txnViewBtn;

import org.openqa.selenium.By;
import org.testng.Assert;

import Utilities.Log;
import Utilities.ReadData;
import Utilities.TestBase;
import Utilities.Utils;
import javaMain.common_Functions.AppData;
import javaMain.common_Functions.OpenEcorpMenues;
import javaMain.common_Functions.eCorpCommonFunctions;

/**
 * Description : Functional Test Script
 * 
 * @author baj80000892
 */

public class AuditPendingActions extends TestBase {

	@SuppressWarnings("unused")
	public static Boolean AuditPendingActionsFunc(String TCName, int ScenarioCount, Object[] tCsDataset) throws Exception {

		try {

			if (true) {

				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + ReadData.getJsonData(TCName, ScenarioCount, "DataSet") + "</mark>");

				Approve = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Approve"));
				Cancel = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Cancel"));
				Home = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Home"));
				RejectCancel = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "RejectCancel"));
				AdditionalActions = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "AdditionalActions"));
				CancelYes = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "CancelYes"));

				Status = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Status"));
				Transaction = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Transaction"));
				txnViewBtn = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "txnViewBtn"));
				
				
			} else {

				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + dataset[scenarioCount - 1] + "</mark>");

				Approve = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Approve"));
				Cancel = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Cancel"));
				Home = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Home"));
				RejectCancel = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("RejectCancel"));
				AdditionalActions = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("AdditionalActions"));
				CancelYes = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("CancelYes"));

				Status = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Status"));
				Transaction = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Transaction"));
				txnViewBtn = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("txnViewBtn"));
			}

			// Open Pending Actions screen
			OpenEcorpMenues.PendingActionsMenu("AuditPendingActions");

			Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "StatusDropDown", "PendingActions")), By.xpath(getObj("Propval1", "StatusINput", "PendingActions")), Status, "Status");
			Log.info("Successfully selected Beneficiary Type.");

			Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "TransDropDown", "PendingActions")), By.xpath(getObj("Propval1", "TransInput", "PendingActions")), Transaction, "Transaction");
			Log.info("Successfully selected Beneficiary Category Type.");

			Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "AccDropdown", "PendingActions")), By.xpath(getObj("Propval1", "AccInput", "PendingActions")), AppData.getFromAccountSAR(), "Beneficiary Type");
			Log.info("Successfully selected Initiator Type.");

			Utils.click(By.xpath(getObj("Propval1", "searchBtn", "PendingActions")), "Search Button");
			Utils.wait(3);
			//

			try {

				Assert.assertFalse(Utils.assertDisplayed(By.xpath(getObj("Propval1", "NoResultsFound", "PendingActions")), "No Results Found."));
				Log.pass("Search results are successfully displayed on screen..");

			} catch (AssertionError | Exception e) {

				Log.pass("Threre are no search results on screen. Hence skipping dependent test steps.");
				// Skip steps
			}

				if (txnViewBtn.equalsIgnoreCase("true")) {

					Utils.click(By.xpath(getObj("Propval1", "txnViewBtn", "PendingActions")), "Transaction view button");
					Log.pass("Transaction view button screen is opened successfully.");
					Utils.logPassImage("Transaction view button");
					Utils.pressEscapeKey(3);

				}
			
			if (AdditionalActions.equalsIgnoreCase("true")) {

				Log.pass("Starting additional actions after transfer. e.g send email, print and save as favourite.");
				eCorpCommonFunctions.sendEmailDownloadExcelnPrintFunc(ScenarioCount);
				Log.pass("Additional Actions  like send email, print and download pdf/excel etc have  passed successfully.");
				Utils.logPassImage("Additional Actions");

			}
		}

		catch (AssertionError |

				Exception e) {

			runResult = false;
			throw e;

		}
		return runResult;
	}
}
