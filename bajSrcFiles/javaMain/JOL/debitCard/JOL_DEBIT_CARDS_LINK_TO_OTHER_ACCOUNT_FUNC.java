package javaMain.JOL.debitCard;

import static Utilities.Input.ReadTestData;
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
import javaMain.common_Functions.eCorpCommonFunctions;

/**
 * Description : Functional Test Script
 * 
 * @author baj80000892
 */
public class JOL_DEBIT_CARDS_LINK_TO_OTHER_ACCOUNT_FUNC extends TestBase {

	public static boolean LINK_TO_OTHER_ACCOUNT(String TCName, int ScenarioCount, Object[] tCsDataset) throws Exception {

		String Proceed, Confirm, AfterTxfrAdditionalOptions, isNegative, NewTxn;
		try {
			if (isMasterClassRun) {

				Log.pass("Data set for this scenario is " + System.lineSeparator() + ReadData.getJsonData(TCName, ScenarioCount, "DataSet"));

				Proceed = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Proceed"));
				Confirm = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Confirm"));
				AfterTxfrAdditionalOptions = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "AfterTxfrAdditionalOptions"));

				NewTxn = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "NewTxn"));
				AfterTxfrAdditionalOptions = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "AfterTxfrAdditionalOptions"));
				isNegative = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "isNegative"));

			} else {
				Log.pass("Data set for this scenario is " + System.lineSeparator() + dataset[scenarioCount - 1]);

				Proceed = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Proceed"));
				Confirm = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Confirm"));
				AfterTxfrAdditionalOptions = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("AfterTxfrAdditionalOptions"));
				NewTxn = (String) Utils.getUiData(dataset[scenarioCount - 1]).get("NewTxn");
				AfterTxfrAdditionalOptions = (String) Utils.getUiData(dataset[scenarioCount - 1]).get("AfterTxfrAdditionalOptions");
				isNegative = (String) Utils.getUiData(dataset[scenarioCount - 1]).get("isNegative");
			}

			Utils.click(By.xpath(getObj("Propval1", "Cards", "Menues")), "Card Menu");

			Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "WaitingElements", "CreditCard_BeneficiaryManagement")));
			Utils.click(By.xpath(getObj("Propval1", "DebitCard", "DebitCard_LINK_TO_OTHER_ACCOUNT")), "Debit Card");

			Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "WaitingElements", "CreditCard_BeneficiaryManagement")));
			Utils.click(By.xpath(getObj("Propval1", "link", "DebitCard_LINK_TO_OTHER_ACCOUNT")), "Link to other Account(s)");
			Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "WaitingElements", "CreditCard_BeneficiaryManagement")));
			String LandPage = Utils.getText(By.xpath(getObj("Propval1", "LandPage", "DebitCard_LINK_TO_OTHER_ACCOUNT")));

			Log.pass("Page title is " + LandPage);

			Log.pass("Enter Credit Card is " + Input.ReadTestData(TCName, "CreditCardNo"));

			Utils.ClearText(By.xpath(getObj("Propval1", "CreditCard", "DebitCard_LINK_TO_OTHER_ACCOUNT")));

			Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "CreditCardDropDown", "DebitCard_LINK_TO_OTHER_ACCOUNT")), By.xpath(getObj("Propval1", "CreditCard", "DebitCard_LINK_TO_OTHER_ACCOUNT")), ReadTestData(TCName, "C_ACCT"));

			if (isNegative.equalsIgnoreCase("true")) {
				driver.findElement(By.xpath(getObj("Propval1", "AccountDropDown", "DebitCard_LINK_TO_OTHER_ACCOUNT"))).click();
				Utils.ClearText(By.xpath(getObj("Propval1", "Account", "DebitCard_LINK_TO_OTHER_ACCOUNT")));
				driver.findElement(By.xpath(getObj("Propval1", "Account", "DebitCard_LINK_TO_OTHER_ACCOUNT"))).sendKeys(ReadTestData(TCName, "invalidAccountNumber"));
				Utils.pressKeyDown();
				Utils.pressEnter();
				Log.pass("Selected 'To' account number is : " + ReadTestData(TCName, "AccountNumber"));
			} else {
				// Utils.ClearText(By.xpath(getObj("Propval1", "Account",
				// "DebitCard_LINK_TO_OTHER_ACCOUNT")));

				driver.findElement(By.xpath(getObj("Propval1", "AccountDropDown", "DebitCard_LINK_TO_OTHER_ACCOUNT"))).click();
				Utils.ClearText(By.xpath(getObj("Propval1", "Account", "DebitCard_LINK_TO_OTHER_ACCOUNT")));
				driver.findElement(By.xpath(getObj("Propval1", "Account", "DebitCard_LINK_TO_OTHER_ACCOUNT"))).sendKeys(ReadTestData(TCName, "AccountNumber"));
				Utils.pressKeyDown();
				Utils.pressEnter();
				Log.pass("Selected 'To' account number is : " + ReadTestData(TCName, "AccountNumber"));
			}

			if (isNegative.equalsIgnoreCase("true")) {

			}

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
					// This is to validate if the user moves to the next page without selecting
					// Terms and Condition CheckBox//
					Assert.assertEquals(Utils.assertDisplayed(By.xpath(getObj("Propval1", "Confirm", "DebitCard_LINK_TO_OTHER_ACCOUNT")), "Confirm"), false);
					Log.pass("Successfully validated that user is unable to complete transaction without Account Number");
					Utils.logPassImage(TCName);
					return true;
				} catch (AssertionError | Exception e) {
					Log.fail("Proceeded Further without selecting account number hence testcase fail");
					throw e;

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

			try {
				Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "SuccessMessage", "Card")), "Success Message"));
				Log.pass("Debit card link to other account successfully.");
				Log.pass("Message displayed on screen is :" + Utils.getText(By.xpath(getObj("Propval1", "SuccessMessage", "Card"))));
				Utils.logPassImage("Debit card link to other account-Pass");

			} catch (AssertionError | Exception e) {

				Log.fail(" Debit card link to other account failed...Message:" + Utils.getText(By.xpath(getObj("Propval1", "failMessage", "Card"))));
				Utils.logFailImage("Debit card link to other account-Fail");
				throw e;
			}

			if (AfterTxfrAdditionalOptions.equalsIgnoreCase("TRUE")) {

				Log.pass("Starting additional actions after transfer. e.g send email, print and save as favourite.");
				eCorpCommonFunctions.SendEmailDownloadPdfNprintFunc();
				Log.pass("Additional Actions  like send email, print and download pdf/excel etc have  passed successfully.");
				Utils.logPassImage("Additional Actions");

			}

			if (Integer.parseInt(NewTxn) == 1) {
				Utils.scrollDownVertically();
				Utils.click(By.xpath(getObj("Propval1", "NewTransactionBtn", "DebitCard_LINK_TO_OTHER_ACCOUNT")), "New Transaction");
				Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "proceed", "DebitCard_LINK_TO_OTHER_ACCOUNT")), "proceed"));

				Log.pass("New Transaction is landed successfully");
				Utils.logPassImage(TCName);

			} else {
				Utils.click(By.xpath(getObj("Propval1", "Home", "DebitCard_LINK_TO_OTHER_ACCOUNT")), "Home Button.");
				Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "HomepageSuccess", "DebitCard_LINK_TO_OTHER_ACCOUNT")), "HomepageSuccess"));

				Log.pass("Home page is landed successfully");

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
