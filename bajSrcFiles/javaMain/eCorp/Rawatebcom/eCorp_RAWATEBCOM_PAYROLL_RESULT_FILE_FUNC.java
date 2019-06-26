package javaMain.eCorp.Rawatebcom;

import static Utilities.ReadData.ReadDataSQL;
import static Utilities.ReadData.getObj;
import static javaMain.common_Functions.AppData.AfterTxfrAdditionalOptions;
import static javaMain.common_Functions.AppData.FutureDate;
import static javaMain.common_Functions.AppData.NextDate;
import static javaMain.common_Functions.AppData.Status;
import static javaMain.common_Functions.AppData.isNegative;

import org.openqa.selenium.By;
import org.testng.Assert;

import Utilities.Input;
import Utilities.Log;
import Utilities.ReadData;
import Utilities.TestBase;
import Utilities.Utils;
import javaMain.common_Functions.AppData;
import javaMain.common_Functions.eCorpCommonFunctions;

/**
 * Description : Functional Test Script
 * 
 * @author baj80000892
 */
public class eCorp_RAWATEBCOM_PAYROLL_RESULT_FILE_FUNC extends TestBase {

	public static Boolean PayrollResultFile(String TCName, int ScenarioCount, Object[] tCsDataset) throws Exception {

		try {

			if (isMasterClassRun) {

				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + ReadData.getJsonData(TCName, ScenarioCount, "DataSet") + "</mark>");

				AfterTxfrAdditionalOptions = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "AfterTxfrAdditionalOptions"));
				NextDate = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "NextDate"));
				FutureDate = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "FutureDate"));
				Status = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Status"));
				isNegative = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "isNegative"));

			} else {

				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + dataset[scenarioCount - 1] + "</mark>");
				AfterTxfrAdditionalOptions = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("AfterTxfrAdditionalOptions"));
				NextDate = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("NextDate"));
				FutureDate = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("FutureDate"));
				Status = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Status"));
				isNegative = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("isNegative"));

			}

			Utils.click(By.xpath(getObj("Propval1", "Rawatebcom", "eCorp_Rawatebcom_PayrollResultFile")), "Rawatebcom");
			Utils.click(By.xpath(getObj("Propval1", "Report", "eCorp_Rawatebcom_PayrollResultFile")), "Report");

			Utils.click(By.xpath(getObj("Propval1", "PayrollResultFile", "eCorp_Rawatebcom_PayrollResultFile")), "Payroll Result File");

			// Verify landing page
			String LandPage = Utils.getText(By.xpath(getObj("Propval1", "LandPage", "eCorp_Rawatebcom_PayrollResultFile")));

			Log.pass("Landed Page is  :" + LandPage);

			Utils.click(By.xpath(getObj("Propval1", "StartDatedropdown", "eCorp_Rawatebcom_PayrollResultFile")), "StartDatedropdown");
			Utils.sendKeys(By.xpath(getObj("Propval1", "StartDate", "eCorp_Rawatebcom_PayrollResultFile")), NextDate, "NextDate");

			Utils.click(By.xpath(getObj("Propval1", "EndDatedropdown", "eCorp_Rawatebcom_PayrollResultFile")), "StartDatedropdown");
			Utils.sendKeys(By.xpath(getObj("Propval1", "EndDate", "eCorp_Rawatebcom_PayrollResultFile")), FutureDate, "FutureDate");

			/*
			 * Utils.clickDropdownAndSendValue( By.xpath(getObj("Propval1",
			 * "StartDatedropdown", "eCorp_Rawatebcom_PayrollResultFile")),
			 * By.xpath(getObj("Propval1", "StartDate",
			 * "eCorp_Rawatebcom_PayrollResultFile")), NextDate, "NextDate");
			 * 
			 * Utils.clickDropdownAndSendValue( By.xpath(getObj("Propval1",
			 * "EndDatedropdown", "eCorp_Rawatebcom_PayrollResultFile")),
			 * By.xpath(getObj("Propval1", "EndDate",
			 * "eCorp_Rawatebcom_PayrollResultFile")), FutureDate, "FutureDate");
			 */

			if (isNegative.equalsIgnoreCase("true")) {

				try {

					Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "error", "eCorp_Rawatebcom_PayrollResultFile")), "Invalid Date"));
					Log.pass("Date is not  valid format, Please review the screenshot for more details.");
					Utils.logPassImage(TCName);
					return true;

				} catch (AssertionError | Exception e) {

					Log.fail("Please review the page again or view the screenshot for more details or make it \"isNegative\" True to avoid this error ");
					Utils.logFailImage(TCName);
					return false;

				}

			}
			if (AppData.getLanguage().equalsIgnoreCase("Arabic")) {

				Utils.click(By.xpath(getObj("Propval1", "SearchArabic", "eCorp_Rawatebcom_PayrollResultFile")), "Search");
				Utils.wait(3);

			} else {
				Utils.click(By.xpath(getObj("Propval1", "Search", "eCorp_Rawatebcom_PayrollResultFile")), "Search");
				Utils.wait(3);
			}
			// Verify landing page
			String Result = Utils.getText(By.xpath(getObj("Propval1", "Result", "eCorp_Rawatebcom_PayrollResultFile")));

			Log.pass("Total Result Displayed :" + Result);

			Utils.logPassImage(TCName);
			if (AfterTxfrAdditionalOptions.equalsIgnoreCase("true")) {
				Log.pass("Starting additional actions after transfer. e.g send email, print and save as favourite.");
				eCorpCommonFunctions.sendEmailDownloadExcelnPrintFunc(ScenarioCount);
				Log.pass("Additional Actions  like send email, print and download pdf/excel etc have  passed successfully.");
				Utils.logPassImage("Additional Actions");

			}

		}

		catch (Exception e) {
			runResult = false;
			e.printStackTrace();

			return runResult;
		}
		return runResult;
	}

	public static boolean addFavSendEmailDownloadPdfNprintFuncBeneficiary(String Nickname) throws Exception {

		try {
			// Start sending email , downloading pdf and printing etc.
			Utils.wait(3);
			Log.info("Starting send email functionality");

			Utils.click(By.xpath(getObj("Propval1", "sendEmailIcon", "eCorp_Rawatebcom_PayrollResultFile")), "Send Email Icon");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailTo", "eCorp_Rawatebcom_PayrollResultFile")), Input.ReadTestData("MarketInfo", "toEmail"), "to email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailCC", "eCorp_Rawatebcom_PayrollResultFile")), Input.ReadTestData("MarketInfo", "ccEmail"), "to CC email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "bccEmail", "eCorp_Rawatebcom_PayrollResultFile")), Input.ReadTestData("MarketInfo", "bccEmail"), "to BCC  email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "emailSubject", "eCorp_Rawatebcom_PayrollResultFile")), Input.ReadTestData("MarketInfo", "emailSubject"), "email Subject ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEMailMsgBox", "eCorp_Rawatebcom_PayrollResultFile")), Input.ReadTestData("MarketInfo", "sendEMailMsgBox"), "Mail Body ");

			Utils.click(By.xpath(getObj("Propval1", "cancelemailBtnEle", "eCorp_Rawatebcom_PayrollResultFile")), "Cancel Email Button");
			Utils.wait(5);
			Utils.click(By.xpath(getObj("Propval1", "sendEmailIcon", "eCorp_Rawatebcom_PayrollResultFile")), "Send Email Icon");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailTo", "eCorp_Rawatebcom_PayrollResultFile")), Input.ReadTestData("MarketInfo", "toEmail"), "to email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailCC", "eCorp_Rawatebcom_PayrollResultFile")), Input.ReadTestData("MarketInfo", "ccEmail"), "to CC email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "bccEmail", "eCorp_Rawatebcom_PayrollResultFile")), Input.ReadTestData("MarketInfo", "bccEmail"), "to BCC  email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "emailSubject", "eCorp_Rawatebcom_PayrollResultFile")), Input.ReadTestData("MarketInfo", "emailSubject"), "email Subject ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEMailMsgBox", "eCorp_Rawatebcom_PayrollResultFile")), Input.ReadTestData("MarketInfo", "sendEMailMsgBox"), "Mail Body ");
			Utils.wait(5);
			Utils.click(By.xpath(getObj("Propval1", "sendBtnEle", "eCorp_Rawatebcom_PayrollResultFile")), "Send Email Button");
			Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "WaitingElements", "eCorp_Rawatebcom_PayrollResultFile")));
			Utils.pressEnter();
			Utils.wait(2);
			Utils.pressEscapeKey(3);

			Utils.pressEscapeKey(3);
			driver.navigate().refresh();
			// Download report in pdf format.
			Utils.click(By.xpath(getObj("Propval1", "pdfDownloadIcon", "eCorp_Rawatebcom_PayrollResultFile")), "pdf download");
			Utils.wait(3);
			Utils.enterOTPAndProceed();
			Utils.moveToElement(By.id("logo"));
			driver.navigate().refresh();
			// Download report in excel format.
			Utils.click(By.xpath(getObj("Propval1", "excelDownloadIcon", "eCorp_Rawatebcom_PayrollResultFile")), "Excel Download");
			Utils.wait(3);
			// Utils.enterOTPAndProceed();
			Utils.moveToElement(By.id("logo"));
			// Print report.
			Utils.wait(6);
			driver.navigate().refresh();
			Utils.click(By.xpath(getObj("Propval1", "printBtnIcon", "eCorp_Rawatebcom_PayrollResultFile")), "Print Button");
			// close all other tabs except the main one. i.e 1st page.
			Utils.closeOtherTabs();

		}

		catch (Exception e) {
			Log.error("Unable to send email semail, print and download pdf etc.");
			Utils.logFailImage("Error");
			runResult = false;
			throw e;

		}

		return runResult;
	}

}
