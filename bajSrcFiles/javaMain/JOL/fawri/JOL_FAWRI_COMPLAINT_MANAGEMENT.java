package javaMain.JOL.fawri;

import static Utilities.ReadData.ReadDataSQL;
import static Utilities.ReadData.getObj;
import static javaMain.common_Functions.AppData.AdditionalOptions;
import static javaMain.common_Functions.AppData.BeneficiaryType;
import static javaMain.common_Functions.AppData.StartDate;
import static javaMain.common_Functions.AppData.Status;

import org.openqa.selenium.By;
import org.testng.Assert;

import Utilities.Log;
import Utilities.ReadData;
import Utilities.TestBase;
import Utilities.Utils;
import javaMain.JOL.transfer.TransferModuleCommonFunctions;

public class JOL_FAWRI_COMPLAINT_MANAGEMENT extends TestBase {

	static String AmountFrom, AmountTo, Enddate, NewComplaint, ComplaintType, ComplaintHistory, MobileNumber, ComplaintDesc, Exec_Proceed, Proceed, Confirmation_btn;
	static boolean NewComplaintflag = false;

	public static Boolean JOL_FAWRI_COMPLAINT_MANAGEMENT_Func(String TCName, int ScenarioCount, Object[] tCsDataset) throws Exception

	{

		try {

			if (isMasterClassRun) {

				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + ReadData.getJsonData(TCName, ScenarioCount, "DataSet") + "</mark>");

				BeneficiaryType = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "BeneficiaryType"));
				Status = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Status"));
				AmountFrom = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "AmountFrom"));
				AmountTo = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "AmountTo"));
				StartDate = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "StartDate"));
				Enddate = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Enddate"));
				ComplaintType = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "ComplaintType"));
				MobileNumber = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "MobileNumber"));
				ComplaintDesc = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "ComplaintDesc"));
				Exec_Proceed = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Exec_Proceed"));
				Confirmation_btn = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Confirmation_btn"));
				NewComplaint = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "NewComplaint"));
				ComplaintHistory = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "ComplaintHistory"));
				AdditionalOptions = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "AdditionalOptions"));
			} else {

				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + ReadData.getJsonData(TCName, ScenarioCount, "DataSet") + "</mark>");

				BeneficiaryType = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("BeneficiaryType"));
				Status = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Status"));
				AmountFrom = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("AmountFrom"));
				AmountTo = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("AmountTo"));
				StartDate = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("StartDate"));
				Enddate = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Enddate"));
				ComplaintType = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("ComplaintType"));
				MobileNumber = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("MobileNumber"));
				ComplaintDesc = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("ComplaintDesc"));
				Exec_Proceed = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Exec_Proceed"));
				Confirmation_btn = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Confirmation_btn"));
				NewComplaint = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("NewComplaint"));
				ComplaintHistory = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("ComplaintHistory"));
				AdditionalOptions = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("AdditionalOptions"));

			}

			Utils.scrollUpVertically();
			FawriComplaintMgmt_TillGrid();

			if (NewComplaint.equalsIgnoreCase("true")) {

				try {
					NewComplaintflag = true;
					Utils.clickSafely(By.xpath(getObj("Propval1", "RowOnComplaintMgmtPage", "FawriComplaintManagement")), "Radio Button on results page");
					Utils.click(By.xpath(getObj("Propval1", "NewComplaint_btn", "FawriComplaintManagement")), "New Complaint Button");

					Utils.Sendkeys_DD_substringbased(By.xpath(getObj("Propval1", "ComplaintType_DD", "FawriComplaintManagement")), ComplaintType, ComplaintType);
					Utils.sendKeys(By.xpath(getObj("Propval1", "MobileNo_txt", "FawriComplaintManagement")), MobileNumber, "Mobile number text box");

					Utils.sendKeys(By.xpath(getObj("Propval1", "ComplaintDesc_TxtArea", "FawriComplaintManagement")), ComplaintDesc, "Mobile number text box");

					if (Integer.parseInt(Exec_Proceed) == 1) {

						Utils.click(By.xpath(getObj("Propval1", "Exec_Proceed_btn", "FawriComplaintManagement")), "Proceed Button on Execution page");
					}
					if (Integer.parseInt(Exec_Proceed) == 2) {
						Utils.click(By.xpath(getObj("Propval1", "Exec_Cancel_btn", "FawriComplaintManagement")), "cancel Button on Execution page");
						Log.pass("Cancelled successfully");
						return runResult;
					}
					if (Integer.parseInt(Confirmation_btn) == 1) {
						Utils.click(By.xpath(getObj("Propval1", "Confirmation_Confirm_btn", "FawriComplaintManagement")), "Confirm Button on Confirmation page");
					} else if (Integer.parseInt(Confirmation_btn) == 2) {
						Utils.click(By.xpath(getObj("Propval1", "Confirmation_Modify_btn", "FawriComplaintManagement")), "modify Button on Confirmation page");
						Utils.click(By.xpath(getObj("Propval1", "Exec_Proceed_btn", "FawriComplaintManagement")), "Proceed Button on Execution page");
						Utils.click(By.xpath(getObj("Propval1", "Confirmation_Confirm_btn", "FawriComplaintManagement")), "Confirm Button on Confirmation page");
					} else {
						Utils.click(By.xpath(getObj("Propval1", "Confirmation_Confirm_btn", "FawriComplaintManagement")), "cancel Button on Confirmation page");
						return runResult;
					}

					try {
						Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "SuccessMessage", "FawriComplaintManagement")), "Success Message"));
						Log.pass("Your complaint has been logged sucessfully. displayed message is :-" + Utils.getText(By.xpath(getObj("Propval1", "SuccessMessage", "FawriComplaintManagement"))));
						Utils.logPassImage("Your complaint has been logged sucessfully - Pass");

					} catch (AssertionError | Exception e) {

						Log.fail("Your complaint has not been logged");
						Utils.logFailImage("Your complaint has not been logged - Fail");
						throw e;

					}

				} catch (AssertionError | Exception e) {

					Log.fail("Your complaint has not been logged");
					Utils.logFailImage("Your complaint has not been logged - Fail");
					throw e;
				}
			}
			
			if (ComplaintHistory.equalsIgnoreCase("true")) {
				if (NewComplaintflag) {
					FawriComplaintMgmt_TillGrid();
				}
				Utils.click(By.xpath(getObj("Propval1", "ComplaintHistory_btn", "FawriComplaintManagement")), "Complaint history Button on home page");

				// Enter start date//
				Utils.Sendkeys_DD_substringbased(By.xpath(getObj("Propval1", "StartDate_DD", "FawriComplaintManagement")), StartDate, "Start Date");

				// Enter end date//
				Utils.Sendkeys_DD_substringbased(By.xpath(getObj("Propval1", "EndDate_DD", "FawriComplaintManagement")), Enddate, "End date");
				Utils.pressTab();
				Utils.click(By.xpath(getObj("Propval1", "Search_btn", "FawriComplaintManagement")), "Search Button");
				Utils.wait(3);
				try {
					Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "ItemsDisplayed", "FawriBeneficiaryManagement")), "Search results"));
					Log.pass("Search results are displayed successfully. Results displayed are :-" + Utils.getText(By.xpath(getObj("Propval1", "ItemsDisplayed", "FawriBeneficiaryManagement"))));
					Utils.logPassImage("Search results are displayed successfully - Pass");

				} catch (AssertionError | Exception e) {

					Log.fail("Search results are not displayed");
					Utils.logFailImage("Search results are not displayed - Fail");
					throw e;

				}

				if (AdditionalOptions.equalsIgnoreCase("true")) {
					TransferModuleCommonFunctions.sendEmailDownloadExcelnPrintFunc();
				}
			}

		}

		catch (Exception e) {
			runResult = false;
			throw e;
		}

		return runResult;
	}

	public static void FawriComplaintMgmt_TillGrid() throws Exception {
		Utils.wait(3);
		Utils.click(By.xpath(getObj("Propval1", "FawriLnk", "FawriComplaintManagement")), "Fawri Link");

		Utils.click(By.xpath(getObj("Propval1", "FawriMgmt_lnk", "FawriComplaintManagement")), "Fawri Management Link");
		Utils.click(By.xpath(getObj("Propval1", "ComplaintMgmt_lnk", "FawriComplaintManagement")), "Fawri Complaint management Link");

		Utils.waitForInVisibilityOfEle(By.xpath("//*[@id='overlayInfo']"));
		String ComplaintMgmt_HomePage = Utils.getText(By.xpath(getObj("Propval1", "ComplaintMgmt_HomePage", "FawriComplaintManagement")));

		if (ComplaintMgmt_HomePage == null) {

			Log.fail("Complaint Management page is not displayed..");
		} else {
			Log.pass("Complaint Management page is displayed.. and page title is: " + ComplaintMgmt_HomePage);
		}

		// Select From Beneficiary//
		Utils.Sendkeys_DD_substringbased(By.xpath(getObj("Propval1", "Beneficiary_DD", "FawriComplaintManagement")), BeneficiaryType, "Beneificiary");

		// Select From Status//
		Utils.Sendkeys_DD_substringbased(By.xpath(getObj("Propval1", "Status_DD", "FawriComplaintManagement")), Status, "Status");

		Utils.sendKeys(By.xpath(getObj("Propval1", "AmountFromTxt", "FawriComplaintManagement")), AmountFrom, "Amount from text box");

		Utils.sendKeys(By.xpath(getObj("Propval1", "AmountToTxt", "FawriComplaintManagement")), AmountTo, "Amount to text box");

		// Enter start date//
		Utils.Sendkeys_DD_substringbased(By.xpath(getObj("Propval1", "StartDate_DD", "FawriComplaintManagement")), StartDate, "Start Date");

		// Enter end date//
		Utils.Sendkeys_DD_substringbased(By.xpath(getObj("Propval1", "EndDate_DD", "FawriComplaintManagement")), Enddate, "End date");
		Utils.pressTab();

		Utils.click(By.xpath(getObj("Propval1", "Search_btn", "FawriComplaintManagement")), "Search Button");
		Utils.wait(5);
		Utils.clickSafely(By.xpath(getObj("Propval1", "AcceptButton", "FawriComplaintManagement")), "Accept Button");

		try {
			Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "ItemsDisplayed", "FawriBeneficiaryManagement")), "Search results"));
			Log.pass("Search results are displayed successfully. Results displayed are :-" + Utils.getText(By.xpath(getObj("Propval1", "ItemsDisplayed", "FawriBeneficiaryManagement"))));
			Utils.logPassImage("Search results are displayed successfully - Pass");

		} catch (AssertionError | Exception e) {

			Log.fail("Search results are not displayed");
			Utils.logFailImage("Search results are not displayed - Fail");
			throw e;

		}

	}

}
