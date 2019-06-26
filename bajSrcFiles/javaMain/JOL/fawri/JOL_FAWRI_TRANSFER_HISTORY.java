package javaMain.JOL.fawri;

import static Utilities.Input.ReadTestData;
import static Utilities.ReadData.ReadDataSQL;
import static Utilities.ReadData.getObj;

import org.openqa.selenium.By;
import org.testng.Assert;

import Utilities.Log;
import Utilities.ReadData;
import Utilities.TestBase;
import Utilities.Utils;
import javaMain.common_Functions.AppData;

public class JOL_FAWRI_TRANSFER_HISTORY extends TestBase {

	static String BeneficiaryType, Status, AmountFrom, AmountTo, StartDate, Enddate, details, AdditionalOptions;

	public static Boolean JOL_FAWRI_TRANSFER_HISTORY_Func(String TCName, int ScenarioCount, Object[] tCsDataset) throws Exception

	{

		try {

			if (isMasterClassRun) {

				Log.pass("Data set for this scenario is " + System.lineSeparator() + ReadData.getJsonData(TCName, ScenarioCount, "DataSet"));

				BeneficiaryType = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "BeneficiaryType"));
				Status = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Status"));
				AmountFrom = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "AmountFrom"));
				AmountTo = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "AmountTo"));
				StartDate = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "StartDate"));
				Enddate = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Enddate"));
				details = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "details"));
				AdditionalOptions = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "AdditionalOptions"));

			} else {

				Log.pass("Data set for this scenario is " + System.lineSeparator() + dataset[scenarioCount - 1]);

				BeneficiaryType = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("BeneficiaryType"));
				Status = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Status"));
				AmountFrom = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("AmountFrom"));
				AmountTo = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("AmountTo"));
				StartDate = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("StartDate"));
				Enddate = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Enddate"));
				details = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("details"));
				AdditionalOptions = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("AdditionalOptions"));

			}

			Utils.scrollUpVertically();
			FawriTransferHistory_TillGrid();

		}

		catch (Exception e) {
			runResult = false;
			throw e;
		}

		return runResult;
	}

	public static void FawriTransferHistory_TillGrid() throws Exception {
		Utils.click(By.xpath(getObj("Propval1", "FawriLnk", "FawriTransferHistory")), "Fawri Link");

		Utils.click(By.xpath(getObj("Propval1", "TransferHistory_lnk", "FawriTransferHistory")), "Fawri Transfer History Link");

		Utils.waitForInVisibilityOfEle(By.xpath("//*[@id='overlayInfo']"));

		// Select From Beneficiary//
		Utils.Sendkeys_DD_substringbased(By.xpath(getObj("Propval1", "Beneficiary_DD", "FawriTransferHistory")), BeneficiaryType, "Beneificiary");

		// Select From Status//
		Utils.Sendkeys_DD_substringbased(By.xpath(getObj("Propval1", "Status_DD", "FawriTransferHistory")), Status, "Status");

		Utils.sendKeys(By.xpath(getObj("Propval1", "AmountFromTxt", "FawriTransferHistory")), AmountFrom, "Amount from text box");

		Utils.sendKeys(By.xpath(getObj("Propval1", "AmountToTxt", "FawriTransferHistory")), AmountTo, "Amount to text box");

		// Enter start date//
		Utils.Sendkeys_DD_substringbased(By.xpath(getObj("Propval1", "StartDate_DD", "FawriTransferHistory")), StartDate, "Start Date");

		// Enter end date//
		Utils.Sendkeys_DD_substringbased(By.xpath(getObj("Propval1", "EndDate_DD", "FawriTransferHistory")), Enddate, "End date");
		Utils.pressTab();
		// click on search button
		Utils.click(By.xpath(getObj("Propval1", "Search_btn", "FawriTransferHistory")), "Search Button");
		try {
			Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "ItemsDisplayed", "FawriBeneficiaryManagement")), "Search results"));
			Log.pass("Search results are displayed successfully. Results displayed are :-" + Utils.getText(By.xpath(getObj("Propval1", "ItemsDisplayed", "FawriBeneficiaryManagement"))));
			Utils.logPassImage("Search results are displayed successfully - Pass");

		} catch (AssertionError | Exception e) {

			Log.fail("Search results are not displayed");
			Utils.logFailImage("Search results are not displayed - Fail");
			throw e;

		}

		Utils.wait(2);
		if (details.equalsIgnoreCase("true")) {

			Utils.click(By.xpath(getObj("Propval1", "TransactionDetails_clk", "FawriTransferHistory")), "Details click on grid");
			// Click on PDF
			Utils.click(By.xpath(getObj("Propval1", "PDF", "FawriTransferHistory")), "Click on PDF");
			// Click on Print
			Utils.click(By.xpath(getObj("Propval1", "Print_CompDetails", "FawriTransferHistory")), "Click on Print");

			Utils.closeOtherTabs();

			// Click on close
			Utils.click(By.xpath(getObj("Propval1", "ComplaintDetails_close", "FawriTransferHistory")), "Click on close");

		}
		if (AdditionalOptions.equalsIgnoreCase("true")) {

			sendEmailDownloadExcelnPrintFuncOrderStatus();

		}
	}

	public static boolean sendEmailDownloadExcelnPrintFuncOrderStatus() throws Exception {

		try {

			Utils.wait(3);
			// Download report in pdf format.
			Utils.click(By.xpath(getObj("Propval1", "pdfDownloadIcon", "AlZCapital")), "pdf download");
			Utils.wait(3);
			Utils.enterOTPAndProceed();
			Utils.wait(3);
			Utils.moveToElement(By.id("logo"));
			// Print report.
			Utils.click(By.xpath(getObj("Propval1", "printBtnIcon", "AlZCapital")), "Print Button");
			// close all other tabs except the main one. i.e 1st page.
			Utils.closeOtherTabs();

			// Start sending email , downloading pdf and printing etc.
			Utils.wait(5);
			Log.info("Starting send email functionality");

			Utils.click(By.xpath(getObj("Propval1", "sendEmailIcon", "FawriComplaintManagement")), "Send Email Icon");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailTo", "FawriComplaintManagement")), ReadTestData(AppData.accountSet, "toEmail"), "to email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailCC", "FawriComplaintManagement")), ReadTestData(AppData.accountSet, "ccEmail"), "to CC email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "bccEmail", "FawriComplaintManagement")), ReadTestData(AppData.accountSet, "bccEmail"), "to BCC  email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "emailSubject", "FawriComplaintManagement")), ReadTestData(AppData.accountSet, "emailSubject"), "email Subject ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEMailMsgBox", "FawriComplaintManagement")), ReadTestData(AppData.accountSet, "sendEMailMsgBox"), "Mail Body ");

			Utils.click(By.xpath(getObj("Propval1", "sendBtnEle", "FawriComplaintManagement")), "Send Email Button");

			Utils.waitForInVisibilityOfEle(By.xpath("//*[@id='overlayInfo']"));
			Utils.pressEnter();
			Utils.wait(3);
			Utils.pressEscapeKey(3);
			Utils.wait(3);
			Log.pass("Successfully completed other actions like send email, download pdf, excel and print search result etc.");
		}

		catch (Exception e) {
			Log.fail("Unable to complete other actions like send email, download pdf, excel and print search result etc error..");
			Utils.logFailImage(TCName + "  Scenario count -" + ScenarioCount + " - sendEmailDownloadExcelnPrintFunc-error");
			runResult = false;
			throw e;

		}

		return runResult;
	}

}
