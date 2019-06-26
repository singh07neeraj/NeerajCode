package javaMain.eCorp.Rawatebcom;

import static Utilities.ReadData.ReadDataSQL;
import static Utilities.ReadData.getObj;

import org.openqa.selenium.By;
import org.testng.Assert;

import Utilities.Input;
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
public class eCorp_RAWATEBCOM_PAYROLL_FILE_DETAILS_FUNC extends TestBase {

	public static Boolean PayrollFileDetails(String TCName, int ScenarioCount, Object[] tCsDataset) throws Exception {

		String AfterTxfrAdditionalOptions, File, AccountNumber, Status, isNegative;
		try {

			if (isMasterClassRun) {

				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + ReadData.getJsonData(TCName, ScenarioCount, "DataSet") + "</mark>");

				AfterTxfrAdditionalOptions = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "AfterTxfrAdditionalOptions"));
				File = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "File"));
				AccountNumber = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "AccountNumber"));
				Status = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Status"));
				isNegative = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "isNegative"));

			} else {

				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + dataset[scenarioCount - 1] + "</mark>");
				AfterTxfrAdditionalOptions = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("AfterTxfrAdditionalOptions"));
				File = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("File"));
				AccountNumber = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("AccountNumber"));
				Status = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Status"));
				isNegative = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("isNegative"));

			}

			Utils.click(By.xpath(getObj("Propval1", "Rawatebcom", "eCorp_Rawatebcom_PayrollFileDetails")), "Rawatebcom");
			Utils.click(By.xpath(getObj("Propval1", "Report", "eCorp_Rawatebcom_PayrollFileDetails")), "Report");

			Utils.click(By.xpath(getObj("Propval1", "PayrollFileDetails", "eCorp_Rawatebcom_PayrollFileDetails")), "Payroll Result File");

			// Verify landing page
			String LandPage = Utils.getText(By.xpath(getObj("Propval1", "LandPage", "eCorp_Rawatebcom_PayrollFileDetails")));

			Log.pass("Landed Page is  :" + LandPage);

			Utils.sendKeys(By.xpath(getObj("Propval1", "File", "eCorp_Rawatebcom_PayrollFileDetails")), File, "File");
			// Utils.pressTab();
			Utils.click(By.xpath(getObj("Propval1", "AccountNumber", "eCorp_Rawatebcom_PayrollFileDetails")), "AccountNumber");
			Utils.sendKeys(By.xpath(getObj("Propval1", "AccountNumberInput", "eCorp_Rawatebcom_PayrollFileDetails")), AccountNumber, "AccountNumber");

			Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "Statusdropdown", "eCorp_Rawatebcom_PayrollFileDetails")), By.xpath(getObj("Propval1", "Status", "eCorp_Rawatebcom_PayrollFileDetails")), Status, "Status");

			if (isNegative.equalsIgnoreCase("true")) {

				try {

					Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "error", "eCorp_Rawatebcom_PayrollFileDetails")), "Invalid Date"));
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

				Utils.click(By.xpath(getObj("Propval1", "SearchArabic", "eCorp_Rawatebcom_PayrollFileDetails")), "Search");

			} else {
				Utils.click(By.xpath(getObj("Propval1", "Search", "eCorp_Rawatebcom_PayrollFileDetails")), "Search");
			}

			Utils.wait(3);

			// Verify landing page
			String Result = Utils.getText(By.xpath(getObj("Propval1", "Result", "eCorp_Rawatebcom_PayrollFileDetails")));

			Log.pass("Total Result Displayed :" + Result);

			Utils.logPassImage(TCName);
			if (AfterTxfrAdditionalOptions.equalsIgnoreCase("true")) {
				addFavSendEmailDownloadPdfNprintFuncBeneficiary(TCName);
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

			Utils.click(By.xpath(getObj("Propval1", "sendEmailIcon", "eCorp_Rawatebcom_PayrollFileDetails")), "Send Email Icon");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailTo", "eCorp_Rawatebcom_PayrollFileDetails")), Input.ReadTestData("MarketInfo", "toEmail"), "to email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailCC", "eCorp_Rawatebcom_PayrollFileDetails")), Input.ReadTestData("MarketInfo", "ccEmail"), "to CC email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "bccEmail", "eCorp_Rawatebcom_PayrollFileDetails")), Input.ReadTestData("MarketInfo", "bccEmail"), "to BCC  email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "emailSubject", "eCorp_Rawatebcom_PayrollFileDetails")), Input.ReadTestData("MarketInfo", "emailSubject"), "email Subject ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEMailMsgBox", "eCorp_Rawatebcom_PayrollFileDetails")), Input.ReadTestData("MarketInfo", "sendEMailMsgBox"), "Mail Body ");

			Utils.click(By.xpath(getObj("Propval1", "cancelemailBtnEle", "eCorp_Rawatebcom_PayrollFileDetails")), "Cancel Email Button");
			Utils.wait(5);
			Utils.click(By.xpath(getObj("Propval1", "sendEmailIcon", "eCorp_Rawatebcom_PayrollFileDetails")), "Send Email Icon");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailTo", "eCorp_Rawatebcom_PayrollFileDetails")), Input.ReadTestData("MarketInfo", "toEmail"), "to email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailCC", "eCorp_Rawatebcom_PayrollFileDetails")), Input.ReadTestData("MarketInfo", "ccEmail"), "to CC email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "bccEmail", "eCorp_Rawatebcom_PayrollFileDetails")), Input.ReadTestData("MarketInfo", "bccEmail"), "to BCC  email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "emailSubject", "eCorp_Rawatebcom_PayrollFileDetails")), Input.ReadTestData("MarketInfo", "emailSubject"), "email Subject ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEMailMsgBox", "eCorp_Rawatebcom_PayrollFileDetails")), Input.ReadTestData("MarketInfo", "sendEMailMsgBox"), "Mail Body ");
			Utils.wait(5);
			Utils.click(By.xpath(getObj("Propval1", "sendBtnEle", "eCorp_Rawatebcom_PayrollFileDetails")), "Send Email Button");
			Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "WaitingElements", "eCorp_Rawatebcom_PayrollFileDetails")));
			Utils.pressEnter();
			Utils.wait(2);
			Utils.pressEscapeKey(3);

			Utils.pressEscapeKey(3);
			driver.navigate().refresh();
			// Download report in pdf format.
			Utils.click(By.xpath(getObj("Propval1", "pdfDownloadIcon", "eCorp_Rawatebcom_PayrollFileDetails")), "pdf download");
			Utils.wait(3);
			Utils.enterOTPAndProceed();
			Utils.moveToElement(By.id("logo"));
			driver.navigate().refresh();
			// Download report in excel format.
			Utils.click(By.xpath(getObj("Propval1", "excelDownloadIcon", "eCorp_Rawatebcom_PayrollFileDetails")), "Excel Download");
			Utils.wait(3);
			// Utils.enterOTPAndProceed();
			Utils.moveToElement(By.id("logo"));
			// Print report.
			Utils.wait(6);
			driver.navigate().refresh();
			Utils.click(By.xpath(getObj("Propval1", "printBtnIcon", "eCorp_Rawatebcom_PayrollFileDetails")), "Print Button");
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
