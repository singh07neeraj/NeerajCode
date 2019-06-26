package javaMain.JOL.accounts;

import static Utilities.ReadData.ReadDataSQL;
import static Utilities.ReadData.getObj;
import static javaMain.common_Functions.AppData.SearchType;
import static javaMain.common_Functions.AppData.otherActions;
import static javaMain.common_Functions.AppData.showDetails;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.openqa.selenium.By;
import org.testng.Assert;

import Utilities.Input;
import Utilities.Log;
import Utilities.ReadData;
import Utilities.TestBase;
import Utilities.Utils;

/**
 * Description : Functional Test Script
 * 
 * @author baj80000892
 */
public class JOL_ACCOUNT_TRANSACTIONS_INQUIRY_FUNC extends TestBase {

	public static Boolean JOlTransacationInquiry(String TCName, int ScenarioCount, Object[] tCsDataset) throws Exception {

		try {

			if (isMasterClassRun) {

				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + ReadData.getJsonData(TCName, ScenarioCount, "DataSet") + "</mark>");
				SearchType = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "SearchType"));
				showDetails = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "showDetails"));
				otherActions = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "otherActions"));

			}

			else {
				
				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + ReadData.getJsonData(TCName, ScenarioCount, "DataSet") + "</mark>");
				SearchType = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("SearchType"));
				showDetails = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("showDetails"));
				otherActions = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("otherActions"));
			}

			// click on Account Top
			Utils.click(By.xpath(getObj("Propval1", "Accounts", "JOL_ACCOUNTS_DEAILS_INQUIRY")), "Accounts link");
			Utils.wait(4);

			// Click on Account Summary
			Utils.click(By.xpath(getObj("Propval1", "Transaction", "JOL_ACCOUNT_TRANSACTIONS_INQUIRY")), "Account Transactions link");
			Utils.wait(4);
			
			if (Integer.parseInt(SearchType) == 1) {

				// to click on basic radio button
				Utils.click(By.xpath(getObj("Propval1", "Basic_rdb", "JOL_ACCOUNT_TRANSACTIONS_INQUIRY")), "Basic radio button");
				// Select Account
				Utils.click(By.xpath(getObj("Propval1", "Account", "JOL_ACCOUNT_TRANSACTIONS_INQUIRY")), "Select Account drop down");
				Utils.wait(3);

				Utils.sendValDropdown(By.xpath(getObj("Propval1", "Acctno_DD", "JOL_ACCOUNT_TRANSACTIONS_INQUIRY")), Input.ReadTestData("JOL Account - Transactions Enquiry", "AcctNO"), "Acct No dropdown","Acct No dropdown");
				Utils.wait(3);
				// Select Period
				Utils.click(By.xpath(getObj("Propval1", "period", "JOL_ACCOUNT_TRANSACTIONS_INQUIRY")), "Select month drop down");
				Utils.wait(2);

				Utils.sendValDropdown(By.xpath(getObj("Propval1", "Period_DD", "JOL_ACCOUNT_TRANSACTIONS_INQUIRY")), Input.ReadTestData("JOL Account - Transactions Enquiry", "Period"), "Period dropdown","Period dropdown");

				// Click Search button
				Utils.click(By.xpath(getObj("Propval1", "Search", "JOL_ACCOUNT_TRANSACTIONS_INQUIRY")), "Search button");

				Utils.wait(5);

				try {

					Assert.assertFalse(Utils.assertDisplayed(By.xpath(getObj("Propval1", "NoResultsFound", "JOL_ACCOUNT_TRANSACTIONS_INQUIRY")), "No Results found Details."));

					Log.pass("Search result displayed on screen is :" + Utils.getText(By.xpath(getObj("Propval1", "ResultsOnSearchWindow", "JOL_ACCOUNT_TRANSACTIONS_INQUIRY"))));

				} catch (AssertionError | Exception e) {

					Log.pass("No search results displayed on screen. Displayed text is : " + Utils.getText(By.xpath(getObj("Propval1", "NoResultsFound", "JOL_ACCOUNT_TRANSACTIONS_INQUIRY"))));
					Log.info("Setting other dependent actions like 'showDetails' as false and exiting test case.");

					showDetails = "false";
					return true;
				}

				if (showDetails.equalsIgnoreCase("true")) {
					// Click on Account Details
					Utils.click(By.xpath(getObj("Propval1", "AccountDetails", "JOL_ACCOUNT_TRANSACTIONS_INQUIRY")), "Click on Account Details");
					// To Click PDF on Transaction Details
					Utils.click(By.xpath(getObj("Propval1", "PDF", "JOL_ACCOUNT_TRANSACTIONS_INQUIRY")), "Click on PDF");

					// To Click Print on Transaction Details
					Utils.click(By.xpath(getObj("Propval1", "Print", "JOL_ACCOUNT_TRANSACTIONS_INQUIRY")), "Click on Print");
					// Utils.wait(5);
					Utils.closeOtherTabs();
					// Utils.wait(3);
					// Enter Remark
					Utils.sendKeys(By.xpath(getObj("Propval1", "remarks", "JOL_ACCOUNT_TRANSACTIONS_INQUIRY")), Input.ReadTestData("JOL Account - Transactions Enquiry", "Remarks"), "Remarks");
					// Select Tag
					Utils.click(By.xpath(getObj("Propval1", "Tagdropdown", "JOL_ACCOUNT_TRANSACTIONS_INQUIRY")), "Tag drop down");
					// Utils.wait(3);

					Utils.sendValDropdown(By.xpath(getObj("Propval1", "Tag", "JOL_ACCOUNT_TRANSACTIONS_INQUIRY")), Input.ReadTestData("JOL Account - Transactions Enquiry", "Tag"), "Tag dropdown");

					// Click on Save
					Utils.click(By.xpath(getObj("Propval1", "Save", "JOL_ACCOUNT_TRANSACTIONS_INQUIRY")), "Save Details");
					Utils.wait(3);
					Utils.pressEnter();
					Utils.wait(3);
					Utils.pressEscapeKey(3);
					Utils.wait(3);
				}

			} else {
				// to click on advanced radio button
				Utils.click(By.xpath(getObj("Propval1", "Advanced_rdb", "JOL_ACCOUNT_TRANSACTIONS_INQUIRY")), "Advanced radio button");
				// Select Account
				// Select Account
				Utils.click(By.xpath(getObj("Propval1", "Account", "JOL_ACCOUNT_TRANSACTIONS_INQUIRY")), "Select Account drop down");
				Utils.wait(3);

				Utils.sendValDropdown(By.xpath(getObj("Propval1", "Acctno_DD", "JOL_ACCOUNT_TRANSACTIONS_INQUIRY")), Input.ReadTestData("JOL Account - Transactions Enquiry", "AcctNO"), "AcctNo dropdown");

				Utils.sendKeys(By.xpath(getObj("Propval1", "DebitCredit_DD", "JOL_ACCOUNT_TRANSACTIONS_INQUIRY")), Input.ReadTestData("JOL Account - Transactions Enquiry", "DebitCreditType"), "DebitCreditType");

				Utils.sendKeys(By.xpath(getObj("Propval1", "TransactionType_DD", "JOL_ACCOUNT_TRANSACTIONS_INQUIRY")), Input.ReadTestData("JOL Account - Transactions Enquiry", "TransactionType"), "TransactionType");

				Utils.sendKeys(By.xpath(getObj("Propval1", "TagType_DD", "JOL_ACCOUNT_TRANSACTIONS_INQUIRY")), Input.ReadTestData("JOL Account - Transactions Enquiry", "TagType"), "TagType");

				Utils.sendKeys(By.xpath(getObj("Propval1", "Keyword_txt", "JOL_ACCOUNT_TRANSACTIONS_INQUIRY")), Input.ReadTestData("JOL Account - Transactions Enquiry", "Keyword"), "Keyword");

				Utils.click(By.xpath(getObj("Propval1", "StartDate_DD_click", "JOL_ACCOUNT_TRANSACTIONS_INQUIRY")), "Start date drop down");
				// Utils.wait(3);

				Utils.sendKeys(By.xpath(getObj("Propval1", "StartDate_DD", "JOL_ACCOUNT_TRANSACTIONS_INQUIRY")), Input.ReadTestData("JOL Account - Transactions Enquiry", "StartDate"), "StartDate");

				Utils.click(By.xpath(getObj("Propval1", "EndDate_DD_click", "JOL_ACCOUNT_TRANSACTIONS_INQUIRY")), "End date drop down");

				Utils.sendKeys(By.xpath(getObj("Propval1", "EndDate_DD", "JOL_ACCOUNT_TRANSACTIONS_INQUIRY")), Input.ReadTestData("JOL Account - Transactions Enquiry", "Enddate"), "Enddate");

				Utils.sendKeys(By.xpath(getObj("Propval1", "FromAmount_txt", "JOL_ACCOUNT_TRANSACTIONS_INQUIRY")), Input.ReadTestData("JOL Account - Transactions Enquiry", "AmountFrom"), "AmountFrom");

				Utils.sendKeys(By.xpath(getObj("Propval1", "ToAmount_txt", "JOL_ACCOUNT_TRANSACTIONS_INQUIRY")), Input.ReadTestData("JOL Account - Transactions Enquiry", "AmountTo"), "AmountTo");

				Utils.click(By.xpath(getObj("Propval1", "Search_btn", "JOL_ACCOUNT_TRANSACTIONS_INQUIRY")), "Search button");
				Utils.wait(5);
				try {

					Assert.assertFalse(Utils.assertDisplayed(By.xpath(getObj("Propval1", "NoResultsFound", "JOL_ACCOUNT_TRANSACTIONS_INQUIRY")), "Result Details."));

					Log.pass("Search result displayed on screen is :" + Utils.getText(By.xpath(getObj("Propval1", "ResultsOnSearchWindow", "JOL_ACCOUNT_TRANSACTIONS_INQUIRY"))));

				} catch (AssertionError | Exception e) {

					Log.pass("No search results displayed on screen. Displayed text is : " + Utils.getText(By.xpath(getObj("Propval1", "NoResultsFound", "JOL_ACCOUNT_TRANSACTIONS_INQUIRY"))));
					Log.info("Setting other dependent actions like 'showDetails' as false and exiting test case.");

					showDetails = "false";
					return true;
				}

			}

			if (otherActions.equalsIgnoreCase("true")) {
				sendEmailDownloadExcelnPrintFuncOrderStatus();
			}

		}

		catch (AssertionError | Exception e){
			runResult = false;
			e.printStackTrace();
			throw e;

		}
		return runResult;
	}

	public static boolean sendEmailDownloadExcelnPrintFuncOrderStatus() throws Exception {

		try {
			// Start sending email , downloading pdf and printing etc.
			Utils.wait(3);
			Log.info("Starting send email functionality");
			Utils.wait(3);
			Utils.click(By.xpath(getObj("Propval1", "sendEmailIcon", "JOL_ACCOUNT_TRANSACTIONS_INQUIRY")), "Send Email Icon");

			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailTo", "JOL_ACCOUNT_TRANSACTIONS_INQUIRY")), Input.ReadTestData("AccountSet1", "toEmail"), "to email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailCC", "JOL_ACCOUNT_TRANSACTIONS_INQUIRY")), Input.ReadTestData("AccountSet1", "ccEmail"), "to CC email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "bccEmail", "JOL_ACCOUNT_TRANSACTIONS_INQUIRY")), Input.ReadTestData("AccountSet1", "bccEmail"), "to BCC  email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "emailSubject", "JOL_ACCOUNT_TRANSACTIONS_INQUIRY")), Input.ReadTestData("AccountSet1", "emailSubject"), "email Subject ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEMailMsgBox", "JOL_ACCOUNT_TRANSACTIONS_INQUIRY")), Input.ReadTestData("AccountSet1", "sendEMailMsgBox"), "Mail Body ");

			Utils.click(By.xpath(getObj("Propval1", "cancelemailBtnEle", "JOL_ACCOUNT_TRANSACTIONS_INQUIRY")), "Cancel Email Button");
			Utils.wait(5);
			Utils.click(By.xpath(getObj("Propval1", "sendEmailIcon", "JOL_ACCOUNT_TRANSACTIONS_INQUIRY")), "Send Email Icon");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailTo", "JOL_ACCOUNT_TRANSACTIONS_INQUIRY")), Input.ReadTestData("AccountSet1", "toEmail"), "to email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailCC", "JOL_ACCOUNT_TRANSACTIONS_INQUIRY")), Input.ReadTestData("AccountSet1", "ccEmail"), "to CC email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "bccEmail", "JOL_ACCOUNT_TRANSACTIONS_INQUIRY")), Input.ReadTestData("AccountSet1", "bccEmail"), "to BCC  email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "emailSubject", "JOL_ACCOUNT_TRANSACTIONS_INQUIRY")), Input.ReadTestData("AccountSet1", "emailSubject"), "email Subject ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEMailMsgBox", "JOL_ACCOUNT_TRANSACTIONS_INQUIRY")), Input.ReadTestData("AccountSet1", "sendEMailMsgBox"), "Mail Body ");
			Utils.wait(5);
			Utils.click(By.xpath(getObj("Propval1", "sendBtnEle", "JOL_ACCOUNT_TRANSACTIONS_INQUIRY")), "Send Email Button");
			Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "WaitingElements", "JOL_ACCOUNT_TRANSACTIONS_INQUIRY")));
			Utils.pressEnter();
			Utils.wait(2);
			Utils.pressEscapeKey(3);
			// Download report in pdf format.
			Utils.click(By.xpath(getObj("Propval1", "pdfDownloadIcon", "JOL_ACCOUNT_TRANSACTIONS_INQUIRY")), "pdf download");
			Utils.wait(3);
			Utils.enterOTPAndProceed();
			Utils.moveToElement(By.id("logo"));
			// Download report in excel format.
			Utils.click(By.xpath(getObj("Propval1", "excelDownloadIcon", "JOL_ACCOUNT_TRANSACTIONS_INQUIRY")), "Excel Download");
			Utils.wait(3);
			Utils.enterOTPAndProceed();
			Utils.moveToElement(By.id("logo"));
			// Print report.
			Utils.click(By.xpath(getObj("Propval1", "printBtnIcon", "JOL_ACCOUNT_TRANSACTIONS_INQUIRY")), "Print Button");
			// close all other tabs except the main one. i.e 1st page.
			Utils.closeOtherTabs();
		}

		catch (Exception e) {
			Log.error("Unable to send email semail, print and download pdf etc." + ExceptionUtils.getStackTrace(e));
			Utils.logFailImage("Error");
			runResult = false;
			throw e;

		}

		return runResult;
	}

}
