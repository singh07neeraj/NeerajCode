package javaMain.JOL.debitCard;

import static Utilities.ReadData.ReadDataSQL;
import static Utilities.ReadData.getObj;

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
public class JOL_CREDIT_CARDS_LINK_TO_OTHER_ACCOUNT_FUNC extends TestBase {

	public static boolean LINK_TO_OTHER_ACCOUNT(String TCName, int ScenarioCount, Object[] tCsDataset) throws Exception {

		String Proceed, Confirm, AfterTxfrAdditionalOptions, isNegative, TCButton, CheckBox, OTPCancelConfirm, NewTxn, C_ACCT, AccountNumber;
		try {
			if (isMasterClassRun) {

				Log.pass("Data set for this scenario is " + System.lineSeparator() + ReadData.getJsonData(TCName, ScenarioCount, "DataSet"));

				Proceed = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Proceed"));
				Confirm = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Confirm"));
				AfterTxfrAdditionalOptions = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "AfterTxfrAdditionalOptions"));

				TCButton = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "TCButton"));
				CheckBox = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "CheckBox"));
				NewTxn = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "NewTxn"));
				AfterTxfrAdditionalOptions = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "AfterTxfrAdditionalOptions"));
				isNegative = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "isNegative"));

				OTPCancelConfirm = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "OTPCancelConfirm"));
				C_ACCT = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "C_ACCT"));
				AccountNumber = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "AccountNumber"));

			} else {
				Log.pass("Data set for this scenario is " + System.lineSeparator() + dataset[scenarioCount - 1]);

				Proceed = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Proceed"));
				Confirm = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Confirm"));
				AfterTxfrAdditionalOptions = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("AfterTxfrAdditionalOptions"));
				TCButton = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("TCButton"));
				CheckBox = (String) Utils.getUiData(dataset[scenarioCount - 1]).get("CheckBox");
				NewTxn = (String) Utils.getUiData(dataset[scenarioCount - 1]).get("NewTxn");
				AfterTxfrAdditionalOptions = (String) Utils.getUiData(dataset[scenarioCount - 1]).get("AfterTxfrAdditionalOptions");
				isNegative = (String) Utils.getUiData(dataset[scenarioCount - 1]).get("isNegative");

				OTPCancelConfirm = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("OTPCancelConfirm"));

				C_ACCT = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("C_ACCT"));

				AccountNumber = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("AccountNumber"));
			}

			Utils.refreshScreeen();
			Utils.wait(2);
			Utils.pressEnter();
			Utils.scrollUpVertically();
			Utils.click(By.xpath(getObj("Propval1", "Cards", "Menues")), "Card Menu");
			Utils.wait(6);

			Utils.click(By.xpath(getObj("Propval1", "DebitCard", "DebitCard_LINK_TO_OTHER_ACCOUNT")), "Debit Card");
			Utils.wait(6);
			Utils.click(By.xpath(getObj("Propval1", "link", "DebitCard_LINK_TO_OTHER_ACCOUNT")), "Link to other Account(s)");

			String LandPage = Utils.getText(By.xpath(getObj("Propval1", "LandPage", "DebitCard_LINK_TO_OTHER_ACCOUNT")));

			Log.pass("Page title is " + LandPage);

			int x = Utils.getSize(By.xpath(getObj("Propval1", "CreditCardDropDown", "DebitCard_LINK_TO_OTHER_ACCOUNT")));
			if (x == 0) {
				Log.fail("Apply Credit Card Page is Not  Displayed......");
			} else {
				Log.pass("Apply Credit Card Page is  Displayed...........");

			}

			Utils.wait(10);

			Log.pass("Enter Credit Card is " + Input.ReadTestData(TCName, "CreditCardNo"));

			Utils.ClearText(By.xpath(getObj("Propval1", "CreditCard", "DebitCard_LINK_TO_OTHER_ACCOUNT")));

			Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "CreditCardDropDown", "DebitCard_LINK_TO_OTHER_ACCOUNT")), By.xpath(getObj("Propval1", "CreditCard", "DebitCard_LINK_TO_OTHER_ACCOUNT")), C_ACCT);

			Utils.wait(6);

			Utils.ClearText(By.xpath(getObj("Propval1", "Account", "DebitCard_LINK_TO_OTHER_ACCOUNT")));

			Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "AccountDropDown", "DebitCard_LINK_TO_OTHER_ACCOUNT")), By.xpath(getObj("Propval1", "Account", "DebitCard_LINK_TO_OTHER_ACCOUNT")), AccountNumber);

			Utils.click(By.xpath(getObj("Propval1", "Additional_Account", "DebitCard_LINK_TO_OTHER_ACCOUNT")), "Additional Account");

			if (Integer.parseInt(Proceed) == 1) {

				Utils.click(By.xpath(getObj("Propval1", "Proceed", "DebitCard_LINK_TO_OTHER_ACCOUNT")), "Proceed");
				Log.pass("Click on Proceed ......");
			} else {

				Utils.click(By.xpath(getObj("Propval1", "Cancel", "DebitCard_LINK_TO_OTHER_ACCOUNT")), "Cancel");
				Log.pass("Click on Cancel Button......");
				Utils.logPassImage(TCName);
				return runResult;

			}

			if (isNegative.equalsIgnoreCase("true")) {
				try {
					// System.out.println(Utils.assertDisplayed(By.xpath(getObj("Propval1",
					// "CreditcardTxt", "ApplyCreditCard")),"false"));
					// This is to validate if the user moves to the next page without selecting
					// Terms and Condition CheckBox//
					Assert.assertEquals(Utils.assertDisplayed(By.xpath(getObj("Propval1", "Confirm", "DebitCard_LINK_TO_OTHER_ACCOUNT")), "Confirm"), false);
					Log.pass("Successfully validated that user is unable to complete transaction without selecting terms and conditions.");
					Utils.logPassImage(TCName);
					return true;
				} catch (AssertionError | Exception e) {
					Log.pass("Proceeded Further");
					runResult = false;

				}

			}

			if (Integer.parseInt(Confirm) == 1) {
				Log.pass("Click on Confirm ......");
				Utils.click(By.xpath(getObj("Propval1", "Confirm", "DebitCard_LINK_TO_OTHER_ACCOUNT")), "Confirm");

				Utils.wait(6);

			} else if (Integer.parseInt(Confirm) == 2) {
				Log.pass("Click on Confirm Modify ......");

				Utils.click(By.xpath(getObj("Propval1", "modify", "DebitCard_LINK_TO_OTHER_ACCOUNT")), "Modify");
				Utils.wait(6);

				Utils.click(By.xpath(getObj("Propval1", "Proceed", "DebitCard_LINK_TO_OTHER_ACCOUNT")), "Modify Proceed");
				Log.pass("Click on Modify Proceed ......");

				Log.pass("Click on Modify Confirm ......");
				Utils.click(By.xpath(getObj("Propval1", "Confirm", "DebitCard_LINK_TO_OTHER_ACCOUNT")), "Modify Confirm");

			} else {
				Utils.click(By.xpath(getObj("Propval1", "Cancel", "DebitCard_LINK_TO_OTHER_ACCOUNT")), "Cancel");
				Utils.wait(6);
				Utils.click(By.xpath(getObj("Propval1", "CancelYes", "DebitCard_LINK_TO_OTHER_ACCOUNT")), "Cancel yes");
				Log.pass("Click on Confirm Return ......");
				Utils.logPassImage(TCName);
				return runResult;
			}

			String Message = Utils.getText(By.xpath(getObj("Propval1", "Message", "DebitCard_LINK_TO_OTHER_ACCOUNT")));

			Log.pass(" Message:" + Message);
			Utils.logPassImage(TCName);

			if (AfterTxfrAdditionalOptions.equalsIgnoreCase("TRUE")) {
				addFavSendEmailDownloadPdfNprintFuncBeneficiary(TCName);
			}

			if (Integer.parseInt(NewTxn) == 1) {
				Utils.scrollDownVertically();
				Utils.click(By.xpath(getObj("Propval1", "NewTransactionBtn", "DebitCard_LINK_TO_OTHER_ACCOUNT")), "New Transaction");
				int y = Utils.getSize(By.xpath(getObj("Propval1", "proceed", "DebitCard_LINK_TO_OTHER_ACCOUNT")));
				if (y > 0) {
					Log.pass("New Transaction is landed successfully");
				} else {
					Log.fail("New Transaction is not landed successfully");

				}

			} else {
				Utils.click(By.xpath(getObj("Propval1", "Home", "DebitCard_LINK_TO_OTHER_ACCOUNT")), "Home Button.");
				int y = Utils.getSize(By.xpath(getObj("Propval1", "HomepageSuccess", "DebitCard_LINK_TO_OTHER_ACCOUNT")));
				if (y > 0) {
					Log.pass("Home page is landed successfully");
				} else {
					Log.fail("Home page is not landed successfully");

				}

				Utils.logPassImage(TCName);
			}

		} catch (Exception e) {

			runResult = false;
			throw e;
		}
		return runResult;
	}

	public static boolean addFavSendEmailDownloadPdfNprintFuncBeneficiary(String Nickname) throws Exception {

		try {
			// Start sending email , downloading pdf and printing etc.
			Utils.wait(3);
			Log.info("Starting send email functionality");

			Utils.click(By.xpath(getObj("Propval1", "sendEmailIcon", "DebitCard_LINK_TO_OTHER_ACCOUNT")), "Send Email Icon");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailTo", "DebitCard_LINK_TO_OTHER_ACCOUNT")), Input.ReadTestData("MarketInfo", "toEmail"), "to email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailCC", "DebitCard_LINK_TO_OTHER_ACCOUNT")), Input.ReadTestData("MarketInfo", "ccEmail"), "to CC email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "bccEmail", "DebitCard_LINK_TO_OTHER_ACCOUNT")), Input.ReadTestData("MarketInfo", "bccEmail"), "to BCC  email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "emailSubject", "DebitCard_LINK_TO_OTHER_ACCOUNT")), Input.ReadTestData("MarketInfo", "emailSubject"), "email Subject ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEMailMsgBox", "DebitCard_LINK_TO_OTHER_ACCOUNT")), Input.ReadTestData("MarketInfo", "sendEMailMsgBox"), "Mail Body ");

			Utils.click(By.xpath(getObj("Propval1", "cancelemailBtnEle", "DebitCard_LINK_TO_OTHER_ACCOUNT")), "Cancel Email Button");
			Utils.wait(5);
			Utils.click(By.xpath(getObj("Propval1", "sendEmailIcon", "DebitCard_LINK_TO_OTHER_ACCOUNT")), "Send Email Icon");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailTo", "DebitCard_LINK_TO_OTHER_ACCOUNT")), Input.ReadTestData("MarketInfo", "toEmail"), "to email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailCC", "DebitCard_LINK_TO_OTHER_ACCOUNT")), Input.ReadTestData("MarketInfo", "ccEmail"), "to CC email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "bccEmail", "DebitCard_LINK_TO_OTHER_ACCOUNT")), Input.ReadTestData("MarketInfo", "bccEmail"), "to BCC  email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "emailSubject", "DebitCard_LINK_TO_OTHER_ACCOUNT")), Input.ReadTestData("MarketInfo", "emailSubject"), "email Subject ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEMailMsgBox", "DebitCard_LINK_TO_OTHER_ACCOUNT")), Input.ReadTestData("MarketInfo", "sendEMailMsgBox"), "Mail Body ");
			Utils.wait(5);
			Utils.click(By.xpath(getObj("Propval1", "sendBtnEle", "DebitCard_LINK_TO_OTHER_ACCOUNT")), "Send Email Button");
			Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "WaitingElements", "DebitCard_LINK_TO_OTHER_ACCOUNT")));
			Utils.pressEnter();
			Utils.wait(2);
			Utils.pressEscapeKey(3);

			Utils.pressEscapeKey(3);
			driver.navigate().refresh();
			// Download report in pdf format.
			Utils.click(By.xpath(getObj("Propval1", "pdfDownloadIcon", "DebitCard_LINK_TO_OTHER_ACCOUNT")), "pdf download");
			Utils.wait(3);
			Utils.enterOTPAndProceed();
			Utils.moveToElement(By.id("logo"));
			driver.navigate().refresh();
			// Download report in excel format.
			/*
			 * Utils.click(By.xpath(getObj("Propval1", "excelDownloadIcon",
			 * "DebitCard_LINK_TO_OTHER_ACCOUNT")), "Excel Download");
			 */
			Utils.wait(3);
			// Utils.enterOTPAndProceed();
			Utils.moveToElement(By.id("logo"));
			// Print report.
			Utils.wait(6);
			driver.navigate().refresh();
			Utils.click(By.xpath(getObj("Propval1", "printBtnIcon", "DebitCard_LINK_TO_OTHER_ACCOUNT")), "Print Button");
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
