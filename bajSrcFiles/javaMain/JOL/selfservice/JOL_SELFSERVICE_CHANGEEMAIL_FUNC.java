package javaMain.JOL.selfservice;

import static Utilities.ReadData.ReadDataSQL;
import static Utilities.ReadData.getObj;
import static javaMain.common_Functions.AppData.AfterTxfrAdditionalOptions;
import static javaMain.common_Functions.AppData.Confirm;
import static javaMain.common_Functions.AppData.InvalidEmail;
import static javaMain.common_Functions.AppData.NewTxn;
import static javaMain.common_Functions.AppData.OTPProceed;
import static javaMain.common_Functions.AppData.Proceed;
import static javaMain.common_Functions.AppData.TestType;
import static javaMain.common_Functions.AppData.email;
import static javaMain.common_Functions.AppData.modifyEmail;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.openqa.selenium.By;
import org.testng.Assert;

import Utilities.Input;
import Utilities.Log;
import Utilities.ReadData;
import Utilities.TestBase;
import Utilities.Utils;
import javaMain.JOL.transfer.TransferModuleCommonFunctions;

/**
 * Description : Functional Test Script
 * 
 * @author baj80000892
 */
public class JOL_SELFSERVICE_CHANGEEMAIL_FUNC extends TestBase {

	public static Boolean changeemail(String TCName, int ScenarioCount, Object[] tCsDataset) throws Exception {

		try {

			if (isMasterClassRun) {

				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + ReadData.getJsonData(TCName, ScenarioCount, "DataSet") + "</mark>");
				AfterTxfrAdditionalOptions = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "AfterTxfrAdditionalOptions"));
				Proceed = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Proceed"));
				Confirm = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Confirm"));
				OTPProceed = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "OTPProceed"));
				NewTxn = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "NewTxn"));
				TestType = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "TestType"));
				email = Input.ReadTestData(TCName, "email");
				modifyEmail = Input.ReadTestData(TCName, "modifyEmail");
				InvalidEmail = Input.ReadTestData(TCName, "InvalidEmail");
			} else {

				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + dataset[scenarioCount - 1] + "</mark>");
				AfterTxfrAdditionalOptions = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("AfterTxfrAdditionalOptions"));
				Proceed = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Proceed"));
				Confirm = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Confirm"));
				OTPProceed = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("OTPProceed"));
				NewTxn = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("NewTxn"));
				TestType = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("TestType"));
				email = Input.ReadTestData(TCName, "email");
				modifyEmail = Input.ReadTestData(TCName, "modifyEmail");
				InvalidEmail = Input.ReadTestData(TCName, "InvalidEmail");
			}

			Utils.click(By.xpath(getObj("Propval1", "SelfServices", "JOL_SELFSERVICE_changeemail")), "Self Services");

			Utils.click(By.xpath(getObj("Propval1", "changeemail", "JOL_SELFSERVICE_changeemail")), "change email");

			// View Status Landed Page
			String ViewStatus = Utils.getTextNoException(By.xpath(getObj("Propval1", "LandPage", "JOL_SELFSERVICE_changeemail")));
			Log.info("Landed Page Title is :" + ViewStatus);
			Utils.sendKeys(By.xpath(getObj("Propval1", "email", "JOL_SELFSERVICE_changeemail")), email, "Email");

			if (TestType.equalsIgnoreCase("N")) {

				Log.pass("Starting negative test scenario. Searching using invalid email ");
				Utils.sendKeys(By.xpath(getObj("Propval1", "email", "JOL_SELFSERVICE_changeemail")), InvalidEmail, "Email");
				Utils.pressTab();
				int x = Utils.getSizeNoException(By.xpath(getObj("Propval1", "error", "JOL_SELFSERVICE_changeemail")));
				if (x == 1) {
					Log.pass("Entered email is not valid.Please re enter a valid email. TS passed. ");
					Log.pass("It is verified that user can not change email if new email is in invalid format.");
					return true;
				}
			}

			if (Integer.parseInt(Proceed) == 1) {
				Utils.click(By.xpath(getObj("Propval1", "proceed", "JOL_SELFSERVICE_changeemail")), "Proceed");
			} else if (Integer.parseInt(Proceed) == 2) {
				Utils.click(By.xpath(getObj("Propval1", "nochange", "JOL_SELFSERVICE_changeemail")), "cancel");
				Log.pass("No changes in email");
				return true;
			} else {
				Utils.click(By.xpath(getObj("Propval1", "cancel", "JOL_SELFSERVICE_changeemail")), "cancel");
				return true;
			}

			int confirm1 = Utils.getSizeNoException(By.xpath(getObj("Propval1", "confirm", "JOL_SELFSERVICE_changeemail")));

			if (confirm1 == 0) {
				Log.fail("Please enter valid email");
				return false;
			}

			if (Integer.parseInt(Confirm) == 1) {
				Utils.click(By.xpath(getObj("Propval1", "confirm", "JOL_SELFSERVICE_changeemail")), "confirm");
			}

			else if (Integer.parseInt(Confirm) == 2) {
				Utils.click(By.xpath(getObj("Propval1", "modify", "JOL_SELFSERVICE_changeemail")), "modify");
				Utils.sendKeys(By.xpath(getObj("Propval1", "email", "JOL_SELFSERVICE_changeemail")), modifyEmail, "Email");

				int z = Utils.getSizeNoException(By.xpath(getObj("Propval1", "error", "JOL_SELFSERVICE_changeemail")));
				if (z == 0) {
					Log.pass("email is not valid: ");
					return false;
				}
				Utils.click(By.xpath(getObj("Propval1", "proceed", "JOL_SELFSERVICE_changeemail")), "Proceed");
				Utils.click(By.xpath(getObj("Propval1", "confirm", "JOL_SELFSERVICE_changeemail")), "confirm");
			}

			else {
				Utils.click(By.xpath(getObj("Propval1", "cancel", "JOL_SELFSERVICE_changeemail")), "cancel");
				Utils.click(By.xpath(getObj("Propval1", "OTPCancelConfirm", "JOL_SELFSERVICE_changeemail")), "cancel");
				Log.pass("Confirm is cancel successfully");
				return true;

			}

			if (Integer.parseInt(OTPProceed) == 1) {
				Utils.enterOTPAndProceed("0123");
			} else if (Integer.parseInt(OTPProceed) == 2) {
				Utils.click(By.xpath(getObj("Propval1", "OTPBack", "JOL_SELFSERVICE_changeemail")), "OTP Back");
				Utils.click(By.xpath(getObj("Propval1", "confirm", "JOL_SELFSERVICE_changeemail")), "OTP Back");
				Utils.enterOTPAndProceed("0123");
			} else {
				Utils.click(By.xpath(getObj("Propval1", "OTPCancelCancel", "JOL_SELFSERVICE_changeemail")), "OTP Back");
				Utils.click(By.xpath(getObj("Propval1", "OTPCancelConfirm", "JOL_SELFSERVICE_changeemail")), "OTP Back");
				Log.pass("OTP is canceled successfully");
				return true;
			}

			try {
				Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "SuccessMessage", "Card")), "Success Message"));
				Log.pass("Change email completed successfully.");
				Utils.logPassImage("Change email-Pass");

			} catch (AssertionError | Exception e) {

				Log.fail("Change email failed...Message:" + Utils.getText(By.xpath(getObj("Propval1", "failMessage", "Card"))));
				Utils.logFailImage("Change email-Fail");
				throw e;
			}

			if (Integer.parseInt(NewTxn) == 1) {
				Utils.scrollDownVertically();
				Utils.click(By.xpath(getObj("Propval1", "NewTransactionBtn", "JOL_SELFSERVICE_changeemail")), "New Transaction");
				int y = Utils.getSizeNoException(By.xpath(getObj("Propval1", "proceed", "JOL_SELFSERVICE_changeemail")));
				if (y > 0) {
					Log.pass("New Transaction page has opened successfully");
				} else {
					Log.fail("New Transaction has not opened..error..");
					Utils.logFailImage("New Txn screen");
				}

			} else {
				Utils.click(By.xpath(getObj("Propval1", "Home", "JOL_SELFSERVICE_changeemail")), "Home Button.");
				int y = Utils.getSizeNoException(By.xpath(getObj("Propval1", "Home", "JOL_SELFSERVICE_changeemail")));
				if (y > 0) {
					Log.pass("Home page is landed successfully");
				} else {
					Log.fail("Home page is not landed successfully");

				}
			}

			if (AfterTxfrAdditionalOptions.equalsIgnoreCase("true")) {
				TransferModuleCommonFunctions.sendEmailDownloadExcelnPrintFunc();
			}
		}

		catch (Exception e) {
			runResult = false;
			throw e;
		}
		return runResult;
	}

	public static boolean sendEmailDownloadExcelnPrintFuncOrderStatus() throws Exception {

		try {
			// Start sending email , downloading pdf and printing etc.
			Utils.wait(3);
			Log.info("Starting send email functionality");

			Utils.click(By.xpath(getObj("Propval1", "sendEmailIcon", "JOL_SELFSERVICE_VIEWLIMIT")), "Send Email Icon");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailTo", "JOL_SELFSERVICE_VIEWLIMIT")), Input.ReadTestData("MarketInfo", "toEmail"), "to email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailCC", "JOL_SELFSERVICE_VIEWLIMIT")), Input.ReadTestData("MarketInfo", "ccEmail"), "to CC email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "bccEmail", "JOL_SELFSERVICE_VIEWLIMIT")), Input.ReadTestData("MarketInfo", "bccEmail"), "to BCC  email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "emailSubject", "JOL_SELFSERVICE_VIEWLIMIT")), Input.ReadTestData("MarketInfo", "emailSubject"), "email Subject ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEMailMsgBox", "JOL_SELFSERVICE_VIEWLIMIT")), Input.ReadTestData("MarketInfo", "sendEMailMsgBox"), "Mail Body ");

			Utils.click(By.xpath(getObj("Propval1", "cancelemailBtnEle", "JOL_SELFSERVICE_VIEWLIMIT")), "Cancel Email Button");
			Utils.wait(5);
			Utils.click(By.xpath(getObj("Propval1", "sendEmailIcon", "JOL_SELFSERVICE_VIEWLIMIT")), "Send Email Icon");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailTo", "JOL_SELFSERVICE_VIEWLIMIT")), Input.ReadTestData("MarketInfo", "toEmail"), "to email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailCC", "JOL_SELFSERVICE_VIEWLIMIT")), Input.ReadTestData("MarketInfo", "ccEmail"), "to CC email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "bccEmail", "JOL_SELFSERVICE_VIEWLIMIT")), Input.ReadTestData("MarketInfo", "bccEmail"), "to BCC  email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "emailSubject", "JOL_SELFSERVICE_VIEWLIMIT")), Input.ReadTestData("MarketInfo", "emailSubject"), "email Subject ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEMailMsgBox", "JOL_SELFSERVICE_VIEWLIMIT")), Input.ReadTestData("MarketInfo", "sendEMailMsgBox"), "Mail Body ");
			Utils.wait(5);
			Utils.click(By.xpath(getObj("Propval1", "sendBtnEle", "JOL_SELFSERVICE_VIEWLIMIT")), "Send Email Button");
			Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "WaitingElements", "JOL_SELFSERVICE_VIEWLIMIT")));
			Utils.pressEnter();
			Utils.wait(2);
			Utils.pressEscapeKey(3);
			// Download report in pdf format.
			Utils.click(By.xpath(getObj("Propval1", "pdfDownloadIcon", "JOL_SELFSERVICE_VIEWLIMIT")), "pdf download");
			Utils.wait(3);
			Utils.enterOTPAndProceed();
			Utils.moveToElement(By.id("logo"));
			// Download report in excel format.
			Utils.click(By.xpath(getObj("Propval1", "excelDownloadIcon", "JOL_SELFSERVICE_VIEWLIMIT")), "Excel Download");
			Utils.wait(3);
			Utils.enterOTPAndProceed();
			Utils.moveToElement(By.id("logo"));
			// Print report.
			Utils.click(By.xpath(getObj("Propval1", "printBtnIcon", "JOL_SELFSERVICE_VIEWLIMIT")), "Print Button");
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
