package javaMain.eCorp.accounts;

import static Utilities.ReadData.ReadDataSQL;
import static Utilities.ReadData.getObj;
import static javaMain.common_Functions.AppData.AfterTxfrAdditionalOptions;
import static javaMain.common_Functions.AppData.SendEMail;
import static javaMain.common_Functions.AppData.SendSMS;
import static javaMain.common_Functions.AppData.details;

import org.openqa.selenium.By;

import Utilities.Input;
import Utilities.Log;
import Utilities.TestBase;
import Utilities.Utils;
import javaMain.common_Functions.eCorpCommonFunctions;

/**
 * Description : Functional Test Script
 * 
 * @author baj80000892
 */
public class eCorp_ACCOUNTS_DEAILS_FUNC extends TestBase {

	public static boolean eCorpAccountDetails(String TCName, int ScenarioCount, Object[] tCsDataset) throws Exception {

		try {

			if (isMasterClassRun) {

				AfterTxfrAdditionalOptions = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "AfterTxfrAdditionalOptions"));
				details = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "details"));
				SendSMS = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "SendSMS"));
				SendEMail = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "SendEMail"));

			}

			else {

				AfterTxfrAdditionalOptions = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("AfterTxfrAdditionalOptions"));
				details = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("details"));
				SendSMS = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("SendSMS"));
				SendEMail = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("SendEMail"));
			}

			// click on Account Top
			Utils.click(By.xpath(getObj("Propval1", "Accounts", "eCorp_ACCOUNTS_DEAILS_INQUIRY")), "Accounts link");

			// Click on Account Details
			Utils.click(By.xpath(getObj("Propval1", "details", "eCorp_ACCOUNTS_DEAILS_INQUIRY")),
					"Account details link");
			Utils.waitForInVisibilityOfEle(
					By.xpath(getObj("Propval1", "WaitingElements", "eCorp_ACCOUNTS_DEAILS_INQUIRY")));
			Utils.wait(3);
			Utils.ClearText(By.xpath(getObj("Propval1", "Account", "eCorp_ACCOUNTS_DEAILS_INQUIRY")));
			// Select Account

			Utils.clickDropdownAndSendValue(
					By.xpath(getObj("Propval1", "Accountdropdown", "eCorp_ACCOUNTS_DEAILS_INQUIRY")),
					By.xpath(getObj("Propval1", "Account", "eCorp_ACCOUNTS_DEAILS_INQUIRY")),
					Input.ReadTestData(TCName, "AccountNumber"));
			try {
				String Nickname = Utils
						.getText(By.xpath(getObj("Propval1", "NickName", "eCorp_ACCOUNTS_DEAILS_INQUIRY")));
				String Balance = Utils
						.getText(By.xpath(getObj("Propval1", "Balance", "eCorp_ACCOUNTS_DEAILS_INQUIRY")));

				Log.pass("Account details page is displayed.. and Account user name is : " + Nickname
						+ "Current Balance is :" + Balance);
			} catch (Exception e) {

			}

			/*
			 * if (Integer.parseInt(details) == 1) { // Click on Account Details
			 * Utils.click(By.xpath(getObj("Propval1", "AccountDetails",
			 * "eCorp_ACCOUNTS_DEAILS_INQUIRY")), "Click on Account Details");
			 * 
			 * // Click on PDF Utils.click(By.xpath(getObj("Propval1", "PDF",
			 * "eCorp_ACCOUNTS_DEAILS_INQUIRY")), "Click on PDF"); // Click on Print
			 * Utils.click(By.xpath(getObj("Propval1", "Print",
			 * "eCorp_ACCOUNTS_DEAILS_INQUIRY")), "Click on Print");
			 * 
			 * Utils.closeOtherTabs();
			 * 
			 * // Enter Remark Utils.sendKeys(By.xpath(getObj("Propval1", "remarks",
			 * "eCorp_ACCOUNTS_DEAILS_INQUIRY")), Input.ReadTestData(TCName, "Remarks"),
			 * "Remarks");
			 * 
			 * // String handle= driver.getWindowHandle();
			 * 
			 * // Select Tag Utils.click(By.xpath(getObj("Propval1", "Tagdropdown",
			 * "eCorp_ACCOUNTS_DEAILS_INQUIRY")), "Tag drop down"); Utils.wait(3);
			 * 
			 * Utils.sendValDropdown(By.xpath(getObj("Propval1", "Tag",
			 * "eCorp_ACCOUNTS_DEAILS_INQUIRY")),
			 * Input.ReadTestData("JOL_ACCOUNTS_SUMMARY_INQUIRY_FUNC", "Tag"), "Tag");
			 * Utils.wait(3);
			 * 
			 * // Click on Save Utils.click(By.xpath(getObj("Propval1", "Save",
			 * "eCorp_ACCOUNTS_DEAILS_INQUIRY")), "Save Details"); Utils.wait(3);
			 * Utils.pressEnter(); Utils.wait(3); Utils.pressEscapeKey(3); }
			 */
			if (SendSMS.equalsIgnoreCase("true")) {

				// Click on SMS Send
				Utils.click(By.xpath(getObj("Propval1", "sms", "eCorp_ACCOUNTS_DEAILS_INQUIRY")), "Send sms button");
				Utils.wait(1);
				// Click on Send SMS

				Utils.click(By.xpath(getObj("Propval1", "smssend", "eCorp_ACCOUNTS_DEAILS_INQUIRY")), "send button");
				Utils.wait(3);
				// Click on Accept 
				Utils.click(By.xpath(getObj("Propval1", "Accept", "eCorp_ACCOUNTS_DEAILS_INQUIRY")), "Accept button");
				Utils.wait(3);
			}
			if (SendEMail.equalsIgnoreCase("true")) {
				// Click on email Send
				Utils.click(By.xpath(getObj("Propval1", "email", "eCorp_ACCOUNTS_DEAILS_INQUIRY")), "Email button");

				Utils.wait(3);

				// Click on email SMS

				Utils.click(By.xpath(getObj("Propval1", "emailsend", "eCorp_ACCOUNTS_DEAILS_INQUIRY")),
						"send email button.");
				Utils.wait(5);
				Utils.waitForInVisibilityOfEle(
						By.xpath(getObj("Propval1", "WaitingElements", "eCorp_ACCOUNTS_DEAILS_INQUIRY")));
				Utils.pressEnter();

			}

			if(AfterTxfrAdditionalOptions.equalsIgnoreCase("true"))
			{

                Log.pass("Starting additional actions after transfer. e.g send email, print and save as favourite.");
                eCorpCommonFunctions.sendEmailDownloadExcelnPrintFunc(ScenarioCount);
                Log.pass("Additional Actions  like send email, print and download pdf/excel etc have  passed successfully.");
                Utils.logPassImage("Additional Actions");

			}
		}

		catch (Exception e) {
			runResult = false;
			e.printStackTrace();
			throw e;
		}
		return runResult;
	}
	
	public static boolean addFavSendEmailDownloadPdfNprintFuncBeneficiary(String Nickname) throws Exception {

		try {
			// Start sending email , downloading pdf and printing etc.
			Utils.wait(3);
			Log.info("Starting send email functionality");

			Utils.click(By.xpath(getObj("Propval1", "sendEmailIcon", "eCorp_ACCOUNTS_DEAILS_INQUIRY")), "Send Email Icon");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailTo", "eCorp_ACCOUNTS_DEAILS_INQUIRY")),
					Input.ReadTestData("MarketInfo", "toEmail"), "to email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailCC", "eCorp_ACCOUNTS_DEAILS_INQUIRY")),
					Input.ReadTestData("MarketInfo", "ccEmail"), "to CC email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "bccEmail", "eCorp_ACCOUNTS_DEAILS_INQUIRY")),
					Input.ReadTestData("MarketInfo", "bccEmail"), "to BCC  email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "emailSubject", "eCorp_ACCOUNTS_DEAILS_INQUIRY")),
					Input.ReadTestData("MarketInfo", "emailSubject"), "email Subject ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEMailMsgBox", "eCorp_ACCOUNTS_DEAILS_INQUIRY")),
					Input.ReadTestData("MarketInfo", "sendEMailMsgBox"), "Mail Body ");

			Utils.click(By.xpath(getObj("Propval1", "cancelemailBtnEle", "eCorp_ACCOUNTS_DEAILS_INQUIRY")),
					"Cancel Email Button");
			Utils.wait(5);
			Utils.click(By.xpath(getObj("Propval1", "sendEmailIcon", "eCorp_ACCOUNTS_DEAILS_INQUIRY")), "Send Email Icon");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailTo", "eCorp_ACCOUNTS_DEAILS_INQUIRY")),
					Input.ReadTestData("MarketInfo", "toEmail"), "to email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailCC", "eCorp_ACCOUNTS_DEAILS_INQUIRY")),
					Input.ReadTestData("MarketInfo", "ccEmail"), "to CC email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "bccEmail", "eCorp_ACCOUNTS_DEAILS_INQUIRY")),
					Input.ReadTestData("MarketInfo", "bccEmail"), "to BCC  email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "emailSubject", "eCorp_ACCOUNTS_DEAILS_INQUIRY")),
					Input.ReadTestData("MarketInfo", "emailSubject"), "email Subject ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEMailMsgBox", "eCorp_ACCOUNTS_DEAILS_INQUIRY")),
					Input.ReadTestData("MarketInfo", "sendEMailMsgBox"), "Mail Body ");
			Utils.wait(5);
			Utils.click(By.xpath(getObj("Propval1", "sendBtnEle", "eCorp_ACCOUNTS_DEAILS_INQUIRY")), "Send Email Button");
			Utils.waitForInVisibilityOfEle(
					By.xpath(getObj("Propval1", "WaitingElements", "eCorp_ACCOUNTS_DEAILS_INQUIRY")));
			Utils.pressEnter();
			Utils.wait(2);
			Utils.pressEscapeKey(3);
			
			Utils.pressEscapeKey(3);
			driver.navigate().refresh();
			// Download report in pdf format.
			Utils.click(By.xpath(getObj("Propval1", "pdfDownloadIcon", "eCorp_ACCOUNTS_DEAILS_INQUIRY")), "pdf download");
			Utils.wait(3);
			Utils.enterOTPAndProceed();
			Utils.moveToElement(By.id("logo"));
			driver.navigate().refresh();
			// Download report in excel format.
			Utils.click(By.xpath(getObj("Propval1", "excelDownloadIcon", "eCorp_ACCOUNTS_DEAILS_INQUIRY")),
					"Excel Download");
			Utils.wait(3);
		//	Utils.enterOTPAndProceed();
			Utils.moveToElement(By.id("logo"));
			// Print report.
			Utils.wait(6);
			driver.navigate().refresh();
			Utils.click(By.xpath(getObj("Propval1", "printBtnIcon", "eCorp_ACCOUNTS_DEAILS_INQUIRY")), "Print Button");
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
