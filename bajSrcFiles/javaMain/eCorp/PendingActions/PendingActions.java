package javaMain.eCorp.PendingActions;

import static Utilities.ReadData.ReadDataSQL;
import static Utilities.ReadData.getObj;
import static javaMain.common_Functions.AppData.AdditionalActions;
import static javaMain.common_Functions.AppData.Approve;
import static javaMain.common_Functions.AppData.Cancel;
import static javaMain.common_Functions.AppData.CancelYes;
import static javaMain.common_Functions.AppData.Home;
import static javaMain.common_Functions.AppData.RejectCancel;

import org.openqa.selenium.By;
import org.testng.Assert;

import Utilities.Log;
import Utilities.ReadData;
import Utilities.TestBase;
import Utilities.Utils;
import javaMain.common_Functions.OpenEcorpMenues;
import javaMain.common_Functions.eCorpCommonFunctions;

/**
 * Description : Functional Test Script
 * 
 * @author baj80000892
 */

public class PendingActions extends TestBase {

	@SuppressWarnings("unused")
	public static Boolean pendingAuthorizationRequestsFunc(String TCName, int ScenarioCount, Object[] tCsDataset) throws Exception {

		try {

			if (true) {

				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + ReadData.getJsonData(TCName, ScenarioCount, "DataSet") + "</mark>");

				Approve = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Approve"));
				Cancel = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Cancel"));
				Home = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Home"));
				RejectCancel = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "RejectCancel"));
				AdditionalActions = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "AdditionalActions"));
				CancelYes = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "CancelYes"));

			} else {

				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + dataset[scenarioCount - 1] + "</mark>");

				Approve = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Approve"));
				Cancel = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Cancel"));
				Home = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Home"));
				RejectCancel = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("RejectCancel"));
				AdditionalActions = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("AdditionalActions"));
				CancelYes = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("CancelYes"));
			}

			// Get count of pending actions.
			Log.pass("Pending Actions count is : " + Utils.getAttributeValue(By.xpath(getObj("Propval1", "PendingActionsCount", "PendingActions")), "data-pending-attr"));

			// Open Pending Actions screen
			OpenEcorpMenues.PendingActionsMenu("PendingActions");

			// Proceed with test steps only if data is displayed on screen, othewise exit
			// the test case flow.
			try {
				Utils.wait(12);
				Assert.assertFalse(Utils.assertDisplayed(By.xpath("//*[contains(text(),'No pending authorization requests')]"), "No pending authorization requests"));

			} catch (AssertionError | Exception e) {

				Log.info("No pending authorization requests found on screen.. skipping remaining test steps/cases.");
				return true;
			}

			Utils.mouseHover(By.xpath(getObj("Propval1", "DetailsShow", "PendingActions")));
			Utils.wait(4);
			Utils.mouseHover(By.id("top_name_theme"));

			// Select Record

			Utils.click(By.xpath(getObj("Propval1", "selectRecChkBox", "PendingActions")), "New Request Checkbox");
			Log.pass("Successfully selected redord/s for  Approving/Rejecting");

			if (Approve.equalsIgnoreCase("true")) {

				Utils.click(By.xpath(getObj("Propval1", "ApproveBtn", "PendingActions")), "Approve"); 

				if (Cancel.equalsIgnoreCase("true")) {

					Utils.click(By.xpath(getObj("Propval1", "CancelBtn", "PendingActions")), "Cancel");
					if (CancelYes.equalsIgnoreCase("true")) {
						Utils.click(By.xpath(getObj("Propval1", "CancelYesBtn", "PendingActions")), "Cancel- Yes");
						Log.pass("Successfully cancelled the transaction. Exiting test case flow.");
						return true;
					}

					else {
						Utils.wait(2);
						Utils.click(By.xpath(getObj("Propval1", "CancelNoBtn", "PendingActions")), "Cancel-No");
						Log.pass("Successfully aborted the cancelling of transaction.. Proceeding with remaining steps");
						Utils.click(By.xpath(getObj("Propval1", "ConfirmBtn", "PendingActions")), "Confirm");
					}

				} else {

					Utils.click(By.xpath(getObj("Propval1", "ConfirmBtn", "PendingActions")), "Confirm");
				}

			}

			try {
				Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "Message", "PendingActions")), "Success Message"));
				Log.pass(" Pending Action/s approved successfully. Message displayed is : " + Utils.getText(By.xpath(getObj("Propval1", "Message", "PendingActions"))));
				Utils.logPassImage("Pening Action Approval-Pass");

			} catch (AssertionError | Exception e) {

				Log.fail("Pending Action/s approval failed . .error... ");
				Log.fail("Skipping other test steps of this scenario due to failure..");
				Utils.logFailImage("Transfer Result-Fail");
				throw e;

			}
			// Reject button on 1st screen itself.
			if (Approve.equalsIgnoreCase("false")) {

				Utils.click(By.xpath(getObj("Propval1", "RejectBtn", "PendingActions")), "Reject");

				if (RejectCancel.equalsIgnoreCase("true")) {

					Utils.click(By.xpath(getObj("Propval1", "RejectCancelBtn", "PendingActions")), "Reject-Cancel");
					Log.pass("Successfully cancelled the rejection process of new pending request");
					return true;
				}

				else {

					Utils.click(By.xpath(getObj("Propval1", "RejectConfirmBtn", "PendingActions")), "Reject- Confirm");
					Log.pass("Successfully confirmed the rejection of pending request.");
					return true;
				}

			}

			if (AdditionalActions.equalsIgnoreCase("true")) {

				Log.pass("Starting additional actions after transfer. e.g send email, print and save as favourite.");
				eCorpCommonFunctions.SendEmailDownloadPdfNprintFunc();
				Log.pass("Send Email, Ecport to PDF and Print functions have passed successfully.");

			}

			if (Home.equalsIgnoreCase("true")) {
				Utils.click(By.xpath(getObj("Propval1", "HomeBtn", "PendingActions")), "Home ");
			}

			else {
				Utils.click(By.xpath(getObj("Propval1", "BackToPendingAuthReqScreen", "PendingActions")), "Back To Pending Authorizations");
				Utils.wait(7);
				// Assert that user is back to pending auth requests page
				Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "landingPage", "Menues")), "Pending Authorization Requests"));
			}

		}

		catch (AssertionError | Exception e) {

			runResult = false;
			throw e;

		}
		return runResult;
	}
}
