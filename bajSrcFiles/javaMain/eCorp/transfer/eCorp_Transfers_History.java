package javaMain.eCorp.transfer;

import static Utilities.Input.ReadTestData;
import static Utilities.ReadData.ReadDataSQL;
import static Utilities.ReadData.getObj;
import static javaMain.common_Functions.AppData.ProceedEmail;
import static javaMain.common_Functions.AppData.StartDate;
import static javaMain.common_Functions.AppData.endDate;
import static javaMain.common_Functions.AppData.sendEmail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Utilities.Log;
import Utilities.ReadData;
import Utilities.TestBase;
import Utilities.Utils;
import javaMain.common_Functions.AppData;
/**
 * Description : Functional Test Script
 * 
 * @author baj80000892
 */
public class eCorp_Transfers_History extends TestBase {

	public static boolean eCorp_Transfers_History_Func  (String TCName, int ScenarioCount, Object[] tCsDataset) throws Exception {

		try {

			if (true) {

				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + ReadData.getJsonData(TCName, ScenarioCount, "DataSet") + "</mark>");
				StartDate = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "StartDate"));// Start and end dates can be read from excel sheet also if required.
				endDate = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "endDate"));
				sendEmail = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "sendEmail"));
				ProceedEmail = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "ProceedEmail"));
				

			} else {
				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + dataset[scenarioCount - 1] + "</mark>");
				StartDate =Utils.setValue( (String) Utils.getUiData(dataset[scenarioCount - 1]).get("StartDate"));
				endDate = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("endDate"));
				sendEmail = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("sendEmail"));
				ProceedEmail = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("ProceedEmail"));
			}

			Utils.click(By.xpath(getObj("Propval1", "TransfersLnk", "JOL_TRANSFERS_HISTORY")), "Click on Transfer Link");
			Utils.click(By.xpath(getObj("Propval1", "History", "JOL_TRANSFERS_HISTORY")), "Click on History ");
			
			
			Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "AccountNumberDropdownDropdown", "JOL_TRANSFERS_HISTORY")), By.xpath(getObj("Propval1", "AccountNumber", "JOL_TRANSFERS_HISTORY")),
					ReadTestData("JOL Transfers - History", "AccountNumber"),"From account dropdown.");
			Log.pass("Selected Account Number is :" + ReadTestData("LocalTransfer", "AccountNumber"));
			Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "TransferTypeDropdown", "JOL_TRANSFERS_HISTORY")), By.xpath(getObj("Propval1", "TransferType1", "JOL_TRANSFERS_HISTORY")),
					ReadTestData("JOL Transfers - History", "TransferType"),"Transfer Type dropdown.");
			Log.pass("Selected Account Number is :" + ReadTestData("JOL Transfers - History", "AccountNumber"));
			Utils.wait(5);
			Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "beneficiarytypeDropdownDropdown", "JOL_TRANSFERS_HISTORY")), By.xpath(getObj("Propval1", "beneficiarytype", "JOL_TRANSFERS_HISTORY")),
					ReadTestData("JOL Transfers - History", "Beneficiary"),"Beneficiary Dropdown.");

			Log.pass("Selected Beneficiary value is : " + ReadTestData("JOL Transfers - History", "Beneficiary"));

			// Enter From and To amount.
			Utils.sendKeys(By.xpath(getObj("Propval1", "AmountFrom", "JOL_TRANSFERS_HISTORY")), ReadTestData(TCName, "From Amount"), "From Amount");

			Utils.sendKeys(By.xpath(getObj("Propval1", "AmountTo", "JOL_TRANSFERS_HISTORY")), ReadTestData(TCName, "To Amount"), "To Amount");

			Utils.wait(2);
			// Start Date
			WebElement sDate = driver.findElement(By.xpath(getObj("Propval1", "StartDate", "JOL_TRANSFERS_HISTORY")));
			sDate.sendKeys(Utils.DateValue((Integer.parseInt(StartDate))));

			// End Date

			WebElement eDate = driver.findElement(By.xpath(getObj("Propval1", "endDate", "JOL_TRANSFERS_HISTORY")));
			eDate.sendKeys(Utils.DateValue((Integer.parseInt(endDate))));

			// Search
			Utils.click(By.xpath(getObj("Propval1", "Search", "JOL_TRANSFERS_HISTORY")), "Clcik on Search");

			int x = Utils.getSize(By.xpath(getObj("Propval1", "SearchResult", "JOL_TRANSFERS_HISTORY")));
			if (x == 0) {
				Log.info("Transfer history records are displayed successfully.");
			} else {
				Log.info("No transfer history details found...");
			}

			String Result = Utils.getText(By.xpath(getObj("Propval1", "SearchResult", "JOL_TRANSFERS_HISTORY")));
			Log.info("Search Result displayed on screen is :" + Result);

			// Start sending email , downloading pdf and printing etc.
			if (Integer.parseInt(sendEmail) == 1) {
				Utils.wait(3);
				Log.info("Starting send email functionality");
				Utils.click(By.xpath(getObj("Propval1", "sendEmailIcon", "JOL_TRANSFERS_HISTORY")), "Send Email Icon");
				Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailTo", "JOL_TRANSFERS_HISTORY")), ReadTestData(AppData.accountSet, "toEmail"), "to email ");
				Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailCC", "JOL_TRANSFERS_HISTORY")), ReadTestData(AppData.accountSet, "ccEmail"), "to CC email ");
				Utils.sendKeys(By.xpath(getObj("Propval1", "bccEmail", "JOL_TRANSFERS_HISTORY")), ReadTestData(AppData.accountSet, "bccEmail"), "to BCC  email ");
				Utils.sendKeys(By.xpath(getObj("Propval1", "emailSubject", "JOL_TRANSFERS_HISTORY")), ReadTestData(AppData.accountSet, "emailSubject"), "email Subject ");
				Utils.sendKeys(By.xpath(getObj("Propval1", "sendEMailMsgBox", "JOL_TRANSFERS_HISTORY")), ReadTestData(AppData.accountSet, "sendEMailMsgBox"), "Mail Body ");

				// Send email if ProceedEmail=1 in DB
				if (Integer.parseInt(ProceedEmail) == 1) {
					// *[contains(@id,'dijit_form_Button_25_label')]
					Utils.click(By.xpath(getObj("Propval1", "sendBtnEle", "JOL_TRANSFERS_HISTORY")), "Send Email Button");
				}
				// Hit cancel email if ProceedEmail=2 in DB.
				else if (Integer.parseInt(ProceedEmail) == 2) {
					Utils.click(By.xpath(getObj("Propval1", "cancelemailBtnEle", "JOL_TRANSFERS_HISTORY")), "Cancel Email Button");
				}

			}
			Utils.wait(2);
			Utils.pressExcapeActions();
			// Download report in pdf format.
			Utils.wait(7);
			Utils.click(By.xpath(getObj("Propval1", "pdfDownloadIcon", "JOL_TRANSFERS_HISTORY")), "pdf download");
			Utils.wait(3);
			Utils.enterOTPAndProceed();
			Utils.moveToElement(By.id("logo"));
			// Download report in excel format.
			Utils.click(By.xpath(getObj("Propval1", "excelDownloadIcon", "JOL_TRANSFERS_HISTORY")), "Excel Download");
			Utils.wait(3);
			Utils.enterOTPAndProceed();
			Utils.moveToElement(By.id("logo"));
			// Print report.
			Utils.click(By.xpath(getObj("Propval1", "printBtnIcon", "JOL_TRANSFERS_HISTORY")), "Print Button");
			// close all other tabs except the main one. i.e 1st page.
			Utils.closeOtherTabs();

		} catch (Exception e) {
			runResult = false;
			throw e;

		}
		return runResult;
	}
}
