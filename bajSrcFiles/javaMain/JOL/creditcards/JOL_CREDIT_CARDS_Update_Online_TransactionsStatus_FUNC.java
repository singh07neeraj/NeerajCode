package javaMain.JOL.creditcards;

import static Utilities.Input.ReadTestData;
import static Utilities.ReadData.ReadDataSQL;
import static Utilities.ReadData.getObj;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
public class JOL_CREDIT_CARDS_Update_Online_TransactionsStatus_FUNC extends TestBase {

	public static boolean UpdateTransaction(String TCName, int ScenarioCount, Object[] tCsDataset) throws Exception {

		String Proceed, Confirm, AfterTxfrAdditionalOptions, isNegative, TCButton, CheckBox, OTPCancelConfirm, NewTxn;
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
			}

			Utils.scrollUpVertically();

			Utils.click(By.xpath(getObj("Propval1", "Cards", "Menues")), "Card Manu");
			Utils.wait(6);

			Utils.click(By.xpath(getObj("Propval1", "updatetnx", "UpdateTransactionsStatus")), "Update Transaction");
			Log.pass("Update Online Transactions Status........");

			String LandPage = Utils.getText(By.xpath(getObj("Propval1", "LandPage", "UpdateTransactionsStatus")));

			Log.pass("Page title is " + LandPage);

			Log.pass("Enter Credit Card is " + Input.ReadTestData(TCName, "CreditCardNo"));

			if (isNegative.equalsIgnoreCase("true")) {
				Utils.ClearText(By.xpath(getObj("Propval1", "CreditCard", "UpdateTransactionsStatus")));

				Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "CreditCardDropDown", "UpdateTransactionsStatus")), By.xpath(getObj("Propval1", "CreditCard", "UpdateTransactionsStatus")), Input.ReadTestData(TCName, "InvalidCreditCardNo"),
						"InvalidCreditCardNo");
			} else {
				Utils.ClearText(By.xpath(getObj("Propval1", "CreditCard", "UpdateTransactionsStatus")));

				Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "CreditCardDropDown", "UpdateTransactionsStatus")), By.xpath(getObj("Propval1", "CreditCard", "UpdateTransactionsStatus")), Input.ReadTestData(TCName, "CreditCardNo"),
						"CreditCardNo");

				Utils.wait(6);
				Log.pass("Enter Credit Type is " + ReadTestData("ResetCardPIN", "CreditCardNo"));

				Utils.ClearText(By.xpath(getObj("Propval1", "status", "UpdateTransactionsStatus")));
				Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "statusDropDown", "UpdateTransactionsStatus")), By.xpath(getObj("Propval1", "status", "UpdateTransactionsStatus")), Input.ReadTestData(TCName, "status"));

			}

			Log.pass("Enter Credit Type is " + Input.ReadTestData(TCName, "status"));

			if (TCButton.equalsIgnoreCase("True")) {
				if (CheckBox.equalsIgnoreCase("True")) {
					// Click on the terms and Conditions CheckBox Directly//
					Utils.click(By.xpath(getObj("Propval1", "CheckBoxTC", "ApplyCreditCard")), "on Terms and Conditons Button directly");
				} else if (CheckBox.equalsIgnoreCase("False")) {
					// Click on the link of Terms and Conditions//
					Utils.click(By.xpath(getObj("Propval1", "TnCpoup", "ApplyCreditCard")), "which is a link of Terms and Conditions");
					// Click on I Accept Radio of the pop up//
					Utils.click(By.xpath(getObj("Propval1", "TnCAgree", "ApplyCreditCard")), "which is I Accept RadioButton");

				}

			} else if (TCButton.equalsIgnoreCase("False")) {
				// Click on Proceed Button//
				Utils.click(By.xpath(getObj("Propval1", "Proceed", "ApplyCreditCard")), "Proceed Button");
				try {
					// System.out.println(Utils.assertDisplayed(By.xpath(getObj("Propval1",
					// "CreditcardTxt", "ApplyCreditCard")),"false"));
					// This is to validate if the user moves to the next page without selecting
					// Terms and Condition CheckBox//
					Assert.assertEquals(Utils.assertDisplayed(By.xpath(getObj("Propval1", "Confirm", "ApplyCreditCard")), "false"), false);
					Log.pass("Successfully validated that user is unable to complete transaction without selecting terms and conditions.");
					return true;
				} catch (AssertionError | Exception e) {
					Log.fail("Proceeded Further without clicking on Terms and Condtions");
					runResult = false;
					throw e;
				}

			}

			if (Integer.parseInt(Proceed) == 1) {

				Utils.click(By.xpath(getObj("Propval1", "Proceed", "UpdateTransactionsStatus")), "Proceed");
				Log.pass("Click on Proceed ......");
			} else {

				Utils.click(By.xpath(getObj("Propval1", "Cancel", "UpdateTransactionsStatus")), "Cancel");
				Log.pass("Click on Cancel Button......");
				Utils.logPassImage(TCName);
				return runResult;

			}

			if (isNegative.equalsIgnoreCase("true")) {
				try {

					Assert.assertFalse(Utils.assertDisplayed(By.xpath(getObj("Propval1", "Confirm", "UpdateTransactionsStatus")), "error"));
					Log.pass("Not able to proceed  while entering the invalid data hence test case pass!!!!!");
					Utils.logPassImage(TCName);
					return true;

				} catch (AssertionError | Exception e) {

					Log.fail("able to proceed  while entering the invalid data hence test case fail!!!!");
					Utils.logFailImage(TCName);
					throw e;
				}

			}
			if (Integer.parseInt(Confirm) == 1) {
				Log.pass("Click on Confirm ......");
				Utils.click(By.xpath(getObj("Propval1", "Confirm", "UpdateTransactionsStatus")), "Confirm");

				Utils.wait(6);

			} else if (Integer.parseInt(Confirm) == 2) {
				Log.pass("Click on Confirm Modify ......");

				Utils.click(By.xpath(getObj("Propval1", "modify", "UpdateTransactionsStatus")), "Modify");
				Utils.wait(6);

				Utils.click(By.xpath(getObj("Propval1", "CheckBoxTC", "ApplyCreditCard")), "on Terms and Conditons Button directly");

				Utils.click(By.xpath(getObj("Propval1", "Proceed", "UpdateTransactionsStatus")), "Modify Proceed");
				Log.pass("Click on Modify Proceed ......");

				Log.pass("Click on Modify Confirm ......");
				Utils.click(By.xpath(getObj("Propval1", "Confirm", "UpdateTransactionsStatus")), "Modify Confirm");

			} else {
				Utils.click(By.xpath(getObj("Propval1", "Cancel", "UpdateTransactionsStatus")), "Cancel");
				Utils.wait(6);
				Utils.click(By.xpath(getObj("Propval1", "CancelYes", "UpdateTransactionsStatus")), "Cancel yes");
				Log.pass("Click on Confirm Return ......");
				Utils.logPassImage(TCName);
				return runResult;
			}

			if (Integer.parseInt(OTPCancelConfirm) == 1) {

				Utils.enterOTPAndProceed("0123");

			} else {
				Utils.click(By.xpath(getObj("Propval1", "Cancel", "UpdateTransactionsStatus")), "Cancel OTP");
				Utils.wait(6);
				Utils.click(By.xpath(getObj("Propval1", "CancelYes", "UpdateTransactionsStatus")), "Yes OTP Cancel");
				Utils.logPassImage(TCName);
				return runResult;

			}

			try {
				Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "SuccessMessage", "Card")), "Success Message"));
				Log.pass("Online Transaction completed successfully.");
				Log.pass("Displayed Message :" + Utils.getText(By.xpath(getObj("Propval1", "SuccessMessage", "Card"))));
				Utils.logPassImage("Online Transactio-Pass");

			} catch (AssertionError | Exception e) {

				Log.fail("Online Transactio failed...Message:" + Utils.getText(By.xpath(getObj("Propval1", "failMessage", "Card"))));
				Utils.logFailImage("Online Transactio-Fail");
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
				Utils.click(By.xpath(getObj("Propval1", "NewTransactionBtn", "UpdateTransactionsStatus")), "New Transaction");
				Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "proceed", "UpdateTransactionsStatus")), "New Transaction Home Page"));

				Log.pass("New Transaction is landed successfully");

				Utils.logPassImage(TCName);

			} else {
				Utils.click(By.xpath(getObj("Propval1", "Home", "UpdateTransactionsStatus")), "Home Button.");
				Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "HomepageSuccess", "UpdateTransactionsStatus")), "Home page"));
				Log.pass("Home page is landed successfully");
				Utils.logPassImage(TCName);

			}

		} catch (Exception e) {

			runResult = false;
			throw e;
		}
		return runResult;
	}

	public static boolean UploadTransaction(String Nickname) throws Exception {

		try {
			// Start sending email , downloading pdf and printing etc.
			Utils.wait(3);
			Log.info("Starting send email functionality");

			Utils.click(By.xpath(getObj("Propval1", "sendEmailIcon", "UpdateTransactionsStatus")), "Send Email Icon");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailTo", "UpdateTransactionsStatus")), Input.ReadTestData("MarketInfo", "toEmail"), "to email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailCC", "UpdateTransactionsStatus")), Input.ReadTestData("MarketInfo", "ccEmail"), "to CC email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "bccEmail", "UpdateTransactionsStatus")), Input.ReadTestData("MarketInfo", "bccEmail"), "to BCC  email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "emailSubject", "UpdateTransactionsStatus")), Input.ReadTestData("MarketInfo", "emailSubject"), "email Subject ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEMailMsgBox", "UpdateTransactionsStatus")), Input.ReadTestData("MarketInfo", "sendEMailMsgBox"), "Mail Body ");

			Utils.click(By.xpath(getObj("Propval1", "cancelemailBtnEle", "UpdateTransactionsStatus")), "Cancel Email Button");
			Utils.wait(5);
			Utils.click(By.xpath(getObj("Propval1", "sendEmailIcon", "UpdateTransactionsStatus")), "Send Email Icon");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailTo", "UpdateTransactionsStatus")), Input.ReadTestData("MarketInfo", "toEmail"), "to email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailCC", "UpdateTransactionsStatus")), Input.ReadTestData("MarketInfo", "ccEmail"), "to CC email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "bccEmail", "UpdateTransactionsStatus")), Input.ReadTestData("MarketInfo", "bccEmail"), "to BCC  email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "emailSubject", "UpdateTransactionsStatus")), Input.ReadTestData("MarketInfo", "emailSubject"), "email Subject ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEMailMsgBox", "UpdateTransactionsStatus")), Input.ReadTestData("MarketInfo", "sendEMailMsgBox"), "Mail Body ");
			Utils.wait(5);
			Utils.click(By.xpath(getObj("Propval1", "sendBtnEle", "UpdateTransactionsStatus")), "Send Email Button");
			Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "WaitingElements", "UpdateTransactionsStatus")));
			Utils.pressEnter();
			Utils.wait(2);
			Utils.pressEscapeKey(3);

			Utils.pressEscapeKey(3);
			driver.navigate().refresh();
			// Download report in pdf format.
			Utils.click(By.xpath(getObj("Propval1", "pdfDownloadIcon", "UpdateTransactionsStatus")), "pdf download");
			Utils.wait(3);
			Utils.enterOTPAndProceed();
			Utils.moveToElement(By.id("logo"));
			driver.navigate().refresh();
			// Download report in excel format.

			Utils.wait(3);
			// Utils.enterOTPAndProceed();
			Utils.moveToElement(By.id("logo"));
			// Print report.
			Utils.wait(6);
			driver.navigate().refresh();
			Utils.click(By.xpath(getObj("Propval1", "printBtnIcon", "UpdateTransactionsStatus")), "Print Button");
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

	public static boolean TemparyLimitInCrease(String TCName, int ScenarioCount, Object[] tCsDataset) throws Exception {

		String Proceed, Limit, Confirm, TCButton, CheckBox, NewTxn, AfterTxfrAdditionalOptions, isNegative;

		try {

			if (isMasterClassRun) {

				Log.pass("Data set for this scenario is " + System.lineSeparator() + ReadData.getJsonData(TCName, ScenarioCount, "DataSet"));
				Limit = ReadDataSQL(TCName, ScenarioCount, "Limit");
				Proceed = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Proceed"));
				Confirm = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Confirm"));

				TCButton = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "TCButton"));
				CheckBox = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "CheckBox"));
				NewTxn = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "NewTxn"));
				AfterTxfrAdditionalOptions = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "AfterTxfrAdditionalOptions"));
				isNegative = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "isNegative"));

			} else {
				Log.pass("Data set for this scenario is " + System.lineSeparator() + dataset[scenarioCount - 1]);
				Limit = (String) Utils.getUiData(dataset[scenarioCount - 1]).get("Limit");
				Proceed = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Proceed"));
				Confirm = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Confirm"));

				TCButton = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("TCButton"));
				CheckBox = (String) Utils.getUiData(dataset[scenarioCount - 1]).get("CheckBox");
				NewTxn = (String) Utils.getUiData(dataset[scenarioCount - 1]).get("NewTxn");
				AfterTxfrAdditionalOptions = (String) Utils.getUiData(dataset[scenarioCount - 1]).get("AfterTxfrAdditionalOptions");
				isNegative = (String) Utils.getUiData(dataset[scenarioCount - 1]).get("isNegative");
			}

			Utils.scrollUpVertically();
			Utils.click(By.xpath(getObj("Propval1", "Cards", "Menues")), "Card Menues");
			Utils.wait(6);

			Utils.click(By.xpath(getObj("Propval1", "Limit", "TempLimitIncrease")), " Temp Limit Increase");

			String LandPage = Utils.getText(By.xpath(getObj("Propval1", "LandPage", "TempLimitIncrease")));

			Log.pass("Page title is " + LandPage);

			Utils.ClearText(By.xpath(getObj("Propval1", "CreditCard", "TempLimitIncrease")));

			if (isNegative.equalsIgnoreCase("true")) {
				Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "CreditCardDropDown", "TempLimitIncrease")), By.xpath(getObj("Propval1", "CreditCard", "TempLimitIncrease")), Input.ReadTestData(TCName, "InvalidCreditCardNo"));
			} else {
				Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "CreditCardDropDown", "TempLimitIncrease")), By.xpath(getObj("Propval1", "CreditCard", "TempLimitIncrease")), Input.ReadTestData(TCName, "CreditCardNo"));
				Utils.pressKeyDown();
				Utils.pressKeyDown();
			}
			Log.pass("Enter Credit Type is " + Input.ReadTestData(TCName, "CreditCardNo"));
// Enter % Amount
			if (Integer.parseInt(Limit) == 1) {
				Utils.click(By.xpath(getObj("Propval1", "percent", "TempLimitIncrease")), " Percent Limit");

				Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "percentValueDropDown", "TempLimitIncrease")), By.xpath(getObj("Propval1", "percentValue", "TempLimitIncrease")), Input.ReadTestData(TCName, "percentValue"));

			} else {
				Utils.sendKeys(By.xpath(getObj("Propval1", "Amount", "TempLimitIncrease")), Input.ReadTestData(TCName, "Amount"));
			}

			// Click From Date
			WebElement FromDate = driver.findElement(By.xpath(getObj("Propval1", "Date", "TempLimitIncrease")));
			FromDate.sendKeys(Input.ReadTestData(TCName, "FutureDate"));
			// FromDate.sendKeys(Utils.DateValue((Integer.parseInt(ReadDataSQL(TCName,
			// ScenarioCount, "FutureDate")))));
			Utils.wait(6);

			Log.pass("Future Date is  " + Utils.DateValue((Integer.parseInt(ReadDataSQL(TCName, ScenarioCount, "FutureDate")))));

			if (TCButton.equalsIgnoreCase("True")) {
				if (CheckBox.equalsIgnoreCase("True")) {
					// Click on the terms and Conditions CheckBox Directly//
					Utils.click(By.xpath(getObj("Propval1", "CheckBoxTC", "TempLimitIncrease")), "on Terms and Conditons Button directly");
				} else if (CheckBox.equalsIgnoreCase("False")) {
					// Click on the link of Terms and Conditions//
					Utils.click(By.xpath(getObj("Propval1", "TnCpoup", "TempLimitIncrease")), "which is a link of Terms and Conditions");
					// Click on I Accept Radio of the pop up//
					Utils.click(By.xpath(getObj("Propval1", "TnCAgree", "TempLimitIncrease")), "which is I Accept RadioButton");

				}

			} else if (TCButton.equalsIgnoreCase("False")) {
				// Click on Proceed Button//
				Utils.click(By.xpath(getObj("Propval1", "Proceed", "TempLimitIncrease")), "Proceed Button");
				try {

					Assert.assertEquals(Utils.assertDisplayed(By.xpath(getObj("Propval1", "Confirm", "TempLimitIncrease")), "False"), false);
					Log.pass("Successfully validated that user is unable to complete transaction without selecting terms and conditions.");
					return true;
				} catch (AssertionError | Exception e) {
					Log.fail("Proceeded Further without clicking on Terms and Condtions");
					runResult = false;
					throw e;
				}

			}

			Log.pass("Click on Check Box.....  ");

			if (Integer.parseInt(Proceed) == 1) {

				Utils.click(By.xpath(getObj("Propval1", "Proceed", "TempLimitIncrease")), "Proceed");
				Log.pass("Click on Proceed ......");
			} else {

				Utils.click(By.xpath(getObj("Propval1", "Cancel", "TempLimitIncrease")), "Cancel");
				Log.pass("Click on Cancel Button......");
				Utils.logPassImage(TCName);
				return true;

			}

			if (isNegative.equalsIgnoreCase("true")) {
				try {

					Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "Confirm", "TempLimitIncrease")), "Confirm"));
					Log.pass("Not able to proceed with invalid data hence test case pass");
					Utils.logPassImage(TCName);
					return true;
				} catch (AssertionError | Exception e) {

					Log.fail("able to proceed with invalid data hence test case fail");
					Utils.logFailImage(TCName);

					throw e;
				}

			}

			int confirmhompeage = Utils.getSize(By.xpath(getObj("Propval1", "Confirm", "TempLimitIncrease")));

			if (confirmhompeage == 0) {
				Log.error("Please review home page");
				runResult = false;
				Utils.logFailImage(TCName);
				return runResult;
			}
			if (Integer.parseInt(Confirm) == 1) {
				Log.pass("Click on Confirm ......");
				Utils.click(By.xpath(getObj("Propval1", "Confirm", "TempLimitIncrease")), "Confirm");

				Utils.wait(6);

			} else if (Integer.parseInt(Confirm) == 2) {
				Log.pass("Click on Confirm Modify ......");

				Utils.click(By.xpath(getObj("Propval1", "modify", "TempLimitIncrease")), "Modify");
				Utils.wait(6);

				Utils.click(By.xpath(getObj("Propval1", "Conditioncheck", "TempLimitIncrease")), "Condtion Check");
				Log.pass("Click on modify Check Box......");
				Utils.wait(6);
				Utils.click(By.xpath(getObj("Propval1", "Proceed", "TempLimitIncrease")), "Proceed");
				Log.pass("Click on Modify Proceed ......");

				Log.pass("Click on Modify Confirm ......");
				Utils.click(By.xpath(getObj("Propval1", "Confirm", "TempLimitIncrease")), "Confirm Modify");

			} else {
				Utils.click(By.xpath(getObj("Propval1", "Cancel", "TempLimitIncrease")), "Confirm Cancel ");
				Utils.wait(6);
				Utils.click(By.xpath(getObj("Propval1", "CancelYes", "TempLimitIncrease")), "Cancel Yes");
				Log.pass("Click on Confirm Return ......");

				Utils.logPassImage(TCName);
				return true;
			}

			try {
				Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "SuccessMessage", "Card")), "Success Message"));
				Log.pass("Tempary Limit InCrease completed successfully.");
				Utils.logPassImage("Tempary Limit InCrease-Pass");

			} catch (AssertionError | Exception e) {

				Log.fail("Tempary Limit InCrease failed...Message:" + Utils.getText(By.xpath(getObj("Propval1", "failMessage", "Card"))));
				Utils.logFailImage("Tempary Limit InCrease-Fail");
				throw e;
			}

			if (AfterTxfrAdditionalOptions.equalsIgnoreCase("true")) {
				Log.pass("Starting additional actions after transfer. e.g send email, print and save as favourite.");
				eCorpCommonFunctions.SendEmailDownloadPdfNprintFunc();
				Log.pass("Additional Actions  like send email, print and download pdf/excel etc have  passed successfully.");
			}

			if (NewTxn.equalsIgnoreCase("NewTransactionBtn")) {
				Utils.scrollDownVertically();
				Utils.click(By.xpath(getObj("Propval1", "NewTransactionBtn", "TempLimitIncrease")), "New Transaction");

				Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "proceed", "TempLimitIncrease")), "New Transaction Home Page"));

				Log.pass("New Transaction is landed successfully");

				Utils.logPassImage(TCName);

			} else {
				Utils.click(By.xpath(getObj("Propval1", "Home", "TempLimitIncrease")), "Home Button.");
				Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "HomepageSuccess", "TempLimitIncrease")), "Home page"));
				Log.pass("Home page is landed successfully");
				Utils.logPassImage(TCName);
			}

		} catch (Exception e) {

			runResult = false;
			throw e;
		}
		return runResult;
	}

	public static boolean emailTemparyLimitInCrease(String Nickname) throws Exception {

		try {
			// Start sending email , downloading pdf and printing etc.
			Utils.wait(3);
			Log.info("Starting send email functionality");

			Utils.click(By.xpath(getObj("Propval1", "sendEmailIcon", "TempLimitIncrease")), "Send Email Icon");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailTo", "TempLimitIncrease")), Input.ReadTestData("MarketInfo", "toEmail"), "to email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailCC", "TempLimitIncrease")), Input.ReadTestData("MarketInfo", "ccEmail"), "to CC email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "bccEmail", "TempLimitIncrease")), Input.ReadTestData("MarketInfo", "bccEmail"), "to BCC  email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "emailSubject", "TempLimitIncrease")), Input.ReadTestData("MarketInfo", "emailSubject"), "email Subject ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEMailMsgBox", "TempLimitIncrease")), Input.ReadTestData("MarketInfo", "sendEMailMsgBox"), "Mail Body ");

			Utils.click(By.xpath(getObj("Propval1", "cancelemailBtnEle", "TempLimitIncrease")), "Cancel Email Button");
			Utils.wait(5);
			Utils.click(By.xpath(getObj("Propval1", "sendEmailIcon", "TempLimitIncrease")), "Send Email Icon");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailTo", "TempLimitIncrease")), Input.ReadTestData("MarketInfo", "toEmail"), "to email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailCC", "TempLimitIncrease")), Input.ReadTestData("MarketInfo", "ccEmail"), "to CC email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "bccEmail", "TempLimitIncrease")), Input.ReadTestData("MarketInfo", "bccEmail"), "to BCC  email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "emailSubject", "TempLimitIncrease")), Input.ReadTestData("MarketInfo", "emailSubject"), "email Subject ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEMailMsgBox", "TempLimitIncrease")), Input.ReadTestData("MarketInfo", "sendEMailMsgBox"), "Mail Body ");
			Utils.wait(5);
			Utils.click(By.xpath(getObj("Propval1", "sendBtnEle", "TempLimitIncrease")), "Send Email Button");
			Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "WaitingElements", "TempLimitIncrease")));
			Utils.pressEnter();
			Utils.wait(2);
			Utils.pressEscapeKey(3);

			Utils.pressEscapeKey(3);
			driver.navigate().refresh();
			// Download report in pdf format.
			Utils.click(By.xpath(getObj("Propval1", "pdfDownloadIcon", "TempLimitIncrease")), "pdf download");
			Utils.wait(3);
			Utils.enterOTPAndProceed();
			Utils.moveToElement(By.id("logo"));
			driver.navigate().refresh();
			// Download report in excel format.

			Utils.wait(3);
			// Utils.enterOTPAndProceed();
			Utils.moveToElement(By.id("logo"));
			// Print report.
			Utils.wait(6);
			driver.navigate().refresh();
			Utils.click(By.xpath(getObj("Propval1", "printBtnIcon", "TempLimitIncrease")), "Print Button");
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

	public static boolean Beneficiary_Management(String TCName, int ScenarioCount, Object[] tCsDataset) throws Exception {

		String OTPCancelConfirm, Proceed, Confirm, AfterTxfrAdditionalOptions;

		try {

			if (isMasterClassRun) {

				Log.pass("Data set for this scenario is " + System.lineSeparator() + ReadData.getJsonData(TCName, ScenarioCount, "DataSet"));

				OTPCancelConfirm = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "OTPCancelConfirm"));
				Proceed = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Proceed"));
				Confirm = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Confirm"));
				AfterTxfrAdditionalOptions = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "AfterTxfrAdditionalOptions"));

			} else {
				Log.pass("Data set for this scenario is " + System.lineSeparator() + dataset[scenarioCount - 1]);

				OTPCancelConfirm = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("OTPCancelConfirm"));
				Proceed = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Proceed"));
				Confirm = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Confirm"));
				AfterTxfrAdditionalOptions = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("AfterTxfrAdditionalOptions"));

			}

			Utils.scrollUpVertically();

			Utils.click(By.xpath(getObj("Propval1", "Cards", "Menues")), "Card Menus");
			Utils.wait(6);

			Utils.click(By.xpath(getObj("Propval1", "BeneficiaryManagement", "CreditCard_BeneficiaryManagement")), "Beneficiary Management");

			String LandPage = Utils.getText(By.xpath(getObj("Propval1", "LandPage", "CreditCard_BeneficiaryManagement")));

			Log.pass("Page title is " + LandPage);

			Utils.logPassImage(TCName);

			if (AfterTxfrAdditionalOptions.equalsIgnoreCase("TRUE")) {

				Log.pass("Starting additional actions after transfer. e.g send email, print and save as favourite.");
				eCorpCommonFunctions.sendEmailDownloadExcelnPrintFunc(ScenarioCount);
				Log.pass("Additional Actions  like send email, print and download pdf/excel etc have  passed successfully.");
				Utils.logPassImage("Additional Actions");
			}
			Log.pass("Click on AddNewBeneficiary page");
			Utils.click(By.xpath(getObj("Propval1", "AddNewBeneficiary", "CreditCard_BeneficiaryManagement")), "Add Beneficiary Management");

			String Beneficiary = Utils.getText(By.xpath(getObj("Propval1", "LandPage", "CreditCard_BeneficiaryManagement")));

			Log.pass("Page title is :" + Beneficiary);
			Utils.logPassImage(TCName);
		} catch (Exception e) {

			runResult = false;
			throw e;
		}
		return runResult;
	}

	/************************************************************************************************************************/

	public static boolean addFavSendEmailDownloadPdfNprintFuncBeneficiary(String Nickname) throws Exception {

		try {
			// Start sending email , downloading pdf and printing etc.
			Utils.wait(3);
			Log.info("Starting send email functionality");

			Utils.click(By.xpath(getObj("Propval1", "sendEmailIcon", "CreditCard_BeneficiaryManagement")), "Send Email Icon");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailTo", "CreditCard_BeneficiaryManagement")), Input.ReadTestData("MarketInfo", "toEmail"), "to email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailCC", "CreditCard_BeneficiaryManagement")), Input.ReadTestData("MarketInfo", "ccEmail"), "to CC email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "bccEmail", "CreditCard_BeneficiaryManagement")), Input.ReadTestData("MarketInfo", "bccEmail"), "to BCC  email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "emailSubject", "CreditCard_BeneficiaryManagement")), Input.ReadTestData("MarketInfo", "emailSubject"), "email Subject ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEMailMsgBox", "CreditCard_BeneficiaryManagement")), Input.ReadTestData("MarketInfo", "sendEMailMsgBox"), "Mail Body ");

			Utils.click(By.xpath(getObj("Propval1", "cancelemailBtnEle", "CreditCard_BeneficiaryManagement")), "Cancel Email Button");
			Utils.wait(5);
			Utils.click(By.xpath(getObj("Propval1", "sendEmailIcon", "CreditCard_BeneficiaryManagement")), "Send Email Icon");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailTo", "CreditCard_BeneficiaryManagement")), Input.ReadTestData("MarketInfo", "toEmail"), "to email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailCC", "CreditCard_BeneficiaryManagement")), Input.ReadTestData("MarketInfo", "ccEmail"), "to CC email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "bccEmail", "CreditCard_BeneficiaryManagement")), Input.ReadTestData("MarketInfo", "bccEmail"), "to BCC  email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "emailSubject", "CreditCard_BeneficiaryManagement")), Input.ReadTestData("MarketInfo", "emailSubject"), "email Subject ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEMailMsgBox", "CreditCard_BeneficiaryManagement")), Input.ReadTestData("MarketInfo", "sendEMailMsgBox"), "Mail Body ");
			Utils.wait(5);
			Utils.click(By.xpath(getObj("Propval1", "sendBtnEle", "CreditCard_BeneficiaryManagement")), "Send Email Button");
			Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "WaitingElements", "CreditCard_BeneficiaryManagement")));
			Utils.pressEnter();
			Utils.wait(2);
			Utils.pressEscapeKey(3);

			Utils.pressEscapeKey(3);
			driver.navigate().refresh();
			// Download report in pdf format.
			Utils.click(By.xpath(getObj("Propval1", "pdfDownloadIcon", "CreditCard_BeneficiaryManagement")), "pdf download");
			Utils.wait(3);
			Utils.enterOTPAndProceed();
			Utils.moveToElement(By.id("logo"));
			driver.navigate().refresh();
			// Download report in excel format.
			Utils.click(By.xpath(getObj("Propval1", "excelDownloadIcon", "CreditCard_BeneficiaryManagement")), "Excel Download");
			Utils.wait(3);
			// Utils.enterOTPAndProceed();
			Utils.moveToElement(By.id("logo"));
			// Print report.
			Utils.wait(6);
			driver.navigate().refresh();
			Utils.click(By.xpath(getObj("Propval1", "printBtnIcon", "CreditCard_BeneficiaryManagement")), "Print Button");
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

	/************************************************************************************************************************/

	public static boolean ActivateCreditCard(String TCName, int ScenarioCount, Object[] tCsDataset) throws Exception {
		String OTPCancelConfirm, Proceed, Confirm, AfterTxfrAdditionalOptions;

		try {

			if (isMasterClassRun) {

				Log.pass("Data set for this scenario is " + System.lineSeparator() + ReadData.getJsonData(TCName, ScenarioCount, "DataSet"));

				OTPCancelConfirm = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "OTPCancelConfirm"));
				Proceed = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Proceed"));
				Confirm = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Confirm"));
				AfterTxfrAdditionalOptions = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "AfterTxfrAdditionalOptions"));

			} else {
				Log.pass("Data set for this scenario is " + System.lineSeparator() + dataset[scenarioCount - 1]);

				OTPCancelConfirm = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("OTPCancelConfirm"));
				Proceed = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Proceed"));
				Confirm = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Confirm"));
				AfterTxfrAdditionalOptions = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("AfterTxfrAdditionalOptions"));

			}

			Utils.click(By.xpath(getObj("Propval1", "Cards", "Menues")), "Card Menu");
			Utils.wait(6);

			Utils.click(By.xpath(getObj("Propval1", "ActivateCreditCard", "ActivateCreditCard")), " Activate Credit Card");

			String LandPage = Utils.getText(By.xpath(getObj("Propval1", "LandPage", "ActivateCreditCard")));

			Log.pass("Page title is " + LandPage);

			if (Integer.parseInt(Proceed) == 1) {
				Utils.click(By.xpath(getObj("Propval1", "Proceed", "ActivateCreditCard")), " Proceed");

			}

			else {
				Utils.click(By.xpath(getObj("Propval1", "Cancel", "ActivateCreditCard")), "Cancel");

				return runResult;
			}

			if (Integer.parseInt(Confirm) == 1) {
				Utils.click(By.xpath(getObj("Propval1", "Confirm", "ActivateCreditCard")), "Confirm");

			}

			else if (Integer.parseInt(Confirm) == 2) {
				Utils.click(By.xpath(getObj("Propval1", "modify", "ActivateCreditCard")), "Modify");

				Utils.wait(6);
				Utils.click(By.xpath(getObj("Propval1", "Proceed", "ActivateCreditCard")), "Proceed");

				Utils.wait(6);
				Utils.click(By.xpath(getObj("Propval1", "Confirm", "ActivateCreditCard")), "Confirm");

			}

			else {
				Utils.click(By.xpath(getObj("Propval1", "Cancel", "ActivateCreditCard")), "Cancel");
				Utils.wait(6);
				Utils.click(By.xpath(getObj("Propval1", "CancelYes", "ActivateCreditCard")), "Cancel yes");
				return runResult;

			}

			if (Integer.parseInt(OTPCancelConfirm) == 2) {
				Utils.click(By.xpath(getObj("Propval1", "Cancel", "ActivateCreditCard")), "Cancel OTP");
				Utils.wait(6);
				Utils.click(By.xpath(getObj("Propval1", "CancelYes", "ActivateCreditCard")), "Cancel OTP  yes");

				return runResult;
			} else {
				// Utils.enterOTP("0123");
				Utils.enterOTPAndProceed("0123");
				Log.pass("Activate Credit Card ! Enter OTP");
			}

			try {
				Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "SuccessMessage", "Card")), "Success Message"));
				Log.pass("Activate Credit Card completed successfully.");
				Utils.logPassImage("Activate Credit Card-Pass");

			} catch (AssertionError | Exception e) {

				Log.fail("Activate Credit Card failed...Message:" + Utils.getText(By.xpath(getObj("Propval1", "failMessage", "Card"))));
				Utils.logFailImage("Activate Credit Card-Fail");
				throw e;
			}

			Utils.logPassImage("Success Image");

			Utils.click(By.xpath(getObj("Propval1", "SETPIN", "ActivateCreditCard")), "SET PIN");

			if (AfterTxfrAdditionalOptions.equalsIgnoreCase("TRUE")) {
				addFavSendEmailDownloadPdfNprintFunc("Automation");
			}

		} catch (Exception e) {

			runResult = false;
			throw e;
		}
		return runResult;
	}

	public static boolean addFavSendEmailDownloadPdfNprintFunc(String Nickname) throws Exception {

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
