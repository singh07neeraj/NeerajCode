package javaMain.JOL.creditcards;

import static Utilities.Input.ReadTestData;
import static Utilities.ReadData.ReadDataSQL;
import static Utilities.ReadData.getObj;

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
public class JOL_CREDIT_CARDS_CASH_TRANSFERS_FUNC extends TestBase {

	public static boolean CashTransfer(String TCName, int ScenarioCount, Object[] tCsDataset) throws Exception {

		String Proceed, Confirm, AfterTxfrAdditionalOptions, isNegative, AMOUNT, NewTxn;

		try {

			if (isMasterClassRun) {

				Log.info("Data set for this scenario is " + System.lineSeparator() + ReadData.getJsonData(TCName, ScenarioCount, "DataSet"));

				;
				Proceed = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Proceed"));
				Confirm = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Confirm"));
				AfterTxfrAdditionalOptions = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "AfterTxfrAdditionalOptions"));
				isNegative = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "isNegative"));
				AMOUNT = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "AMOUNT"));
				NewTxn = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "NewTxn"));

			} else {
				Log.info("Data set for this scenario is " + System.lineSeparator() + dataset[scenarioCount - 1]);

				Proceed = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Proceed"));
				Confirm = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Confirm"));
				AfterTxfrAdditionalOptions = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("AfterTxfrAdditionalOptions"));
				isNegative = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("isNegative"));
				AMOUNT = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("AMOUNT"));
				NewTxn = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("NewTxn"));

			}

			Utils.scrollUpVertically();

			Utils.click(By.xpath(getObj("Propval1", "Cards", "Menues")), "  Card Manu");
			Utils.wait(6);

			Utils.click(By.xpath(getObj("Propval1", "CashTransfer", "CashTransfer")), " Cash Transfer");

			String LandPage = Utils.getText(By.xpath(getObj("Propval1", "Cards", "Menues")));

			Log.info("Page title is " + LandPage);

			// Select Credit Card
			Utils.click(By.xpath(getObj("Propval1", "CreditCardDropdown", "CashTransfer")), "Credit Card Dropdown");
			driver.findElement(By.xpath(getObj("Propval1", "CreditCardNUmber", "CashTransfer"))).clear();
			driver.findElement(By.xpath(getObj("Propval1", "CreditCardNUmber", "CashTransfer"))).sendKeys(Input.ReadTestData(TCName, "CreditCardNo"));
			Utils.wait(1);
			Utils.pressKeyDown();
			Utils.pressKeyDown();
			Utils.pressEnter();
			/*
			 * Utils.sendValDropdown(By.xpath(getObj("Propval1", "CreditCardNUmber",
			 * "CreditCardNUmber")), Input.ReadTestData(TCName, "CreditCardNo"));
			 * Utils.pressKeyDown(); Utils.pressEnter();
			 */
			Utils.click(By.xpath(getObj("Propval1", "AccountDropdown", "CashTransfer")), "Credit Card Dropdown");
			driver.findElement(By.xpath(getObj("Propval1", "Account", "CashTransfer"))).clear();
			driver.findElement(By.xpath(getObj("Propval1", "Account", "CashTransfer"))).sendKeys(Input.ReadTestData(TCName, "AccountNumber"));
			Utils.wait(1);
			Utils.pressKeyDown();
			Utils.pressKeyDown();
			Utils.pressEnter();

			/*
			 * Utils.ClearText(By.xpath(getObj("Propval1", "Account", "CashTransfer")));
			 * Utils.wait(6); // Select Account
			 * Utils.sendValDropdown(By.xpath(getObj("Propval1", "Account",
			 * "CashTransfer")),Input.ReadTestData(TCName, "AccountNumber"));
			 * Utils.pressKeyDown(); Utils.pressEnter();
			 */
			if (isNegative.equalsIgnoreCase("true")) {
				Utils.ClearText(By.xpath(getObj("Propval1", "Amount", "CashTransfer")));
				Utils.sendKeys(By.xpath(getObj("Propval1", "Amount", "CashTransfer")), AMOUNT);

			} else {
				Utils.ClearText(By.xpath(getObj("Propval1", "Amount", "CashTransfer")));
				Utils.sendKeys(By.xpath(getObj("Propval1", "Amount", "CashTransfer")), AMOUNT);
			}
			Utils.wait(6);
			// Enter Amount

			if (Integer.parseInt(Proceed) == 1) {
				Utils.click(By.xpath(getObj("Propval1", "Proceed", "CashTransfer")), " Proceed");
				Log.pass("Click on Proceed Button............. ");

			} else {
				Utils.click(By.xpath(getObj("Propval1", "Cancel", "CashTransfer")), " Cancel");
				Log.pass("Click on Cancel Button............. ");
				return runResult;
			}
			if (isNegative.equalsIgnoreCase("true")) {
				Assert.assertFalse(Utils.assertDisplayed(By.xpath(getObj("Propval1", "Confirm", "CashTransfer")), "Confirm"));
				Log.pass("User is unable to complete transfer with negative amount hecne testcase pass");
				Log.pass("JOL Credit Cards-cash transfers cancelled successfully");
				Utils.logPassImage(TCName);
				return true;

			}
			if (Integer.parseInt(Confirm) == 1) {
				Utils.click(By.xpath(getObj("Propval1", "Confirm", "CashTransfer")), " Confirm");
				Log.pass("Click on Confirm Button............. ");
			} else if (Integer.parseInt(Confirm) == 2) {

				Utils.click(By.xpath(getObj("Propval1", "modify", "CashTransfer")), "Successfully on Modify");

				Utils.sendKeys(By.xpath(getObj("Propval1", "Amount", "CashTransfer")), ReadTestData("ResetCardPIN", "ModifyAmount"));

				Utils.wait(6);
				Utils.click(By.xpath(getObj("Propval1", "Proceed", "CashTransfer")), " Modify Proceed");
				Utils.wait(6);
				Log.pass("Click on Modify proceed Button............. ");
				Utils.click(By.xpath(getObj("Propval1", "Confirm", "CashTransfer")), " Modify Confirm");
				Log.pass("Click on Modify Confirm Button............. ");
			} else {
				Utils.click(By.xpath(getObj("Propval1", "Cancel", "CashTransfer")), " Cancel ");
				Utils.wait(6);
				Utils.click(By.xpath(getObj("Propval1", "CancelYes", "CashTransfer")), " Cancel yes");

				Log.pass("Click on Cancel  Button............. ");

				return runResult;

			}

			try {
				Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "SuccessMessage", "Card")), "Success Message"));
				Log.pass("Credit Card Cash transfer completed successfully.");
				Log.pass("Success Message is :" + Utils.getText(By.xpath(getObj("Propval1", "SuccessMessage", "Card"))));
				Utils.logPassImage("Transfer Result-Pass");

			} catch (AssertionError | Exception e) {

				Log.fail("Credit Card Cash transfer failed...Message:" + Utils.getText(By.xpath(getObj("Propval1", "failMessage", "Card"))));
				Utils.logFailImage("Transfer Result-Fail");
				throw e;
			}

			if (AfterTxfrAdditionalOptions.equalsIgnoreCase("true")) {

				Log.pass("Starting additional actions after transfer. e.g send email, print and save as favourite.");
				eCorpCommonFunctions.SendEmailDownloadPdfNprintFunc();
				Log.pass("Additional Actions  like send email, print and download pdf/excel etc have  passed successfully.");
				Utils.logPassImage("Additional Actions");
			}

			if (Integer.parseInt(NewTxn) == 1) {
				Utils.scrollDownVertically();
				Utils.click(By.xpath(getObj("Propval1", "NewTransactionBtn", "ApplyCreditCard")), "New Transaction");
				Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "Proceed", "ApplyCreditCard")), "NewTransactionBtn"));

				Log.pass("New Transaction is landed successfully");
				Utils.logPassImage(TCName);

			} else {
				Utils.click(By.xpath(getObj("Propval1", "Home", "ApplyCreditCard")), "Home Button");
				Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "HomepageSuccess", "ApplyCreditCard")), "HomepageSuccess"));

				Log.pass("Home page is landed successfully");
				Utils.logPassImage(TCName);

			}

		} catch (Exception e) {

			runResult = false;
			throw e;
		}
		return runResult;
	}

	public static boolean addFavSendEmailDownloadPdfNprintCashTransfer(String Nickname) throws Exception {

		try {
			// Start sending email , downloading pdf and printing etc.
			Utils.wait(3);
			Log.info("Starting send email functionality");

			Utils.click(By.xpath(getObj("Propval1", "sendEmailIcon", "CashTransfer")), "Send Email Icon");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailTo", "CashTransfer")), Input.ReadTestData("MarketInfo", "toEmail"), "to email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailCC", "CashTransfer")), Input.ReadTestData("MarketInfo", "ccEmail"), "to CC email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "bccEmail", "CashTransfer")), Input.ReadTestData("MarketInfo", "bccEmail"), "to BCC  email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "emailSubject", "CashTransfer")), Input.ReadTestData("MarketInfo", "emailSubject"), "email Subject ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEMailMsgBox", "CashTransfer")), Input.ReadTestData("MarketInfo", "sendEMailMsgBox"), "Mail Body ");

			Utils.click(By.xpath(getObj("Propval1", "cancelemailBtnEle", "CashTransfer")), "Cancel Email Button");
			Utils.wait(5);
			Utils.click(By.xpath(getObj("Propval1", "sendEmailIcon", "CashTransfer")), "Send Email Icon");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailTo", "CashTransfer")), Input.ReadTestData("MarketInfo", "toEmail"), "to email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailCC", "CashTransfer")), Input.ReadTestData("MarketInfo", "ccEmail"), "to CC email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "bccEmail", "CashTransfer")), Input.ReadTestData("MarketInfo", "bccEmail"), "to BCC  email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "emailSubject", "CashTransfer")), Input.ReadTestData("MarketInfo", "emailSubject"), "email Subject ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEMailMsgBox", "CashTransfer")), Input.ReadTestData("MarketInfo", "sendEMailMsgBox"), "Mail Body ");
			Utils.wait(5);
			Utils.click(By.xpath(getObj("Propval1", "sendBtnEle", "CashTransfer")), "Send Email Button");
			Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "WaitingElements", "CashTransfer")));
			Utils.pressEnter();
			Utils.wait(2);
			Utils.pressEscapeKey(3);

			Utils.pressEscapeKey(3);
			driver.navigate().refresh();
			// Download report in pdf format.
			Utils.click(By.xpath(getObj("Propval1", "pdfDownloadIcon", "CashTransfer")), "pdf download");
			Utils.wait(3);
			Utils.enterOTPAndProceed();
			Utils.moveToElement(By.id("logo"));
			driver.navigate().refresh();
			// Download report in excel format.

			// Utils.enterOTPAndProceed();
			Utils.moveToElement(By.id("logo"));
			// Print report.
			Utils.wait(6);
			driver.navigate().refresh();
			Utils.click(By.xpath(getObj("Propval1", "printBtnIcon", "CashTransfer")), "Print Button");
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

	public static boolean Estatment(String TCName, int ScenarioCount, Object[] tCsDataset) throws Exception {
		String AfterTxfrAdditionalOptions, isNegative;

		try {
			if (isMasterClassRun) {

				Log.info("Data set for this scenario is " + System.lineSeparator() + ReadData.getJsonData(TCName, ScenarioCount, "DataSet"));
				AfterTxfrAdditionalOptions = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "AfterTxfrAdditionalOptions"));
				isNegative = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "isNegative"));

			} else {
				Log.info("Data set for this scenario is " + System.lineSeparator() + dataset[scenarioCount - 1]);
				AfterTxfrAdditionalOptions = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("AfterTxfrAdditionalOptions"));
				isNegative = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("isNegative"));
			}

			Utils.scrollUpVertically();

			Utils.click(By.xpath(getObj("Propval1", "Cards", "Menues")), "Card Manu ");
			Utils.wait(6);

			Utils.click(By.xpath(getObj("Propval1", "estatment", "EStatment")), "E-Statment");
			Log.pass("E-Statment Menu........");

			String LandPage = Utils.getText(By.xpath(getObj("Propval1", "LandPage", "EStatment")));

			Log.pass("Page title is " + LandPage);

			Utils.click(By.xpath(getObj("Propval1", "AccountDropdown", "EStatment")), "E-Statment");
			Utils.ClearText(By.xpath(getObj("Propval1", "Account", "EStatment")));
			driver.findElement(By.xpath(getObj("Propval1", "Account", "EStatment"))).sendKeys(Input.ReadTestData(TCName, "CreditCardNo"));
			Utils.pressKeyDown();
			Utils.pressKeyDown();
			Utils.pressKeyDown();
			Utils.pressEnter();

			/*
			 * Log.pass("Selected 'To' account number is : " + ToAcc);
			 * 
			 * Utils.ClearText(By.xpath(getObj("Propval1", "Account", "EStatment"))); //
			 * Select Account Utils.click(By.xpath(getObj("Propval1", "AccountDropdown",
			 * "EStatment")), "Account Drop down");
			 * 
			 * Utils.sendValDropdown(By.xpath(getObj("Propval1", "Account", "EStatment")),
			 * Input.ReadTestData(TCName, "CreditCardNo"));
			 */

			Log.pass("Select Account Number  " + Input.ReadTestData(TCName, "CreditCardNo"));

			Utils.pressEscapeKey(3);
			Utils.wait(3);
			// Click on Table

			Utils.click(By.xpath(getObj("Propval1", "Search", "EStatment")), " Search");

			String Result = Utils.getText(By.xpath(getObj("Propval1", "Result", "EStatment")));

			Log.pass("Displayed Result is  :" + Result);

			if (AfterTxfrAdditionalOptions.equalsIgnoreCase("true")) {
				Log.pass("Starting additional actions after transfer. e.g send email, print and save as favourite.");
				eCorpCommonFunctions.sendEmailDownloadExcelnPrintFunc(ScenarioCount);
				Log.pass("Additional Actions  like send email, print and download pdf/excel etc have  passed successfully.");
				Utils.logPassImage("Additional Actions");
			}

			Utils.logPassImage("E-statment");
		} catch (Exception e) {

			runResult = false;
			throw e;
		}
		return runResult;
	}

	public static boolean emailpdfexcelEstatment(String Nickname) throws Exception {

		try {
			// Start sending email , downloading pdf and printing etc.
			Utils.wait(3);
			Log.info("Starting send email functionality");

			Utils.click(By.xpath(getObj("Propval1", "sendEmailIcon", "EStatment")), "Send Email Icon");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailTo", "EStatment")), Input.ReadTestData("MarketInfo", "toEmail"), "to email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailCC", "EStatment")), Input.ReadTestData("MarketInfo", "ccEmail"), "to CC email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "bccEmail", "EStatment")), Input.ReadTestData("MarketInfo", "bccEmail"), "to BCC  email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "emailSubject", "EStatment")), Input.ReadTestData("MarketInfo", "emailSubject"), "email Subject ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEMailMsgBox", "EStatment")), Input.ReadTestData("MarketInfo", "sendEMailMsgBox"), "Mail Body ");

			Utils.click(By.xpath(getObj("Propval1", "cancelemailBtnEle", "EStatment")), "Cancel Email Button");
			Utils.wait(5);
			Utils.click(By.xpath(getObj("Propval1", "sendEmailIcon", "EStatment")), "Send Email Icon");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailTo", "EStatment")), Input.ReadTestData("MarketInfo", "toEmail"), "to email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailCC", "EStatment")), Input.ReadTestData("MarketInfo", "ccEmail"), "to CC email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "bccEmail", "EStatment")), Input.ReadTestData("MarketInfo", "bccEmail"), "to BCC  email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "emailSubject", "EStatment")), Input.ReadTestData("MarketInfo", "emailSubject"), "email Subject ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEMailMsgBox", "EStatment")), Input.ReadTestData("MarketInfo", "sendEMailMsgBox"), "Mail Body ");
			Utils.wait(5);
			Utils.click(By.xpath(getObj("Propval1", "sendBtnEle", "EStatment")), "Send Email Button");
			Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "WaitingElements", "EStatment")));
			Utils.pressEnter();
			Utils.wait(2);
			Utils.pressEscapeKey(3);

			Utils.pressEscapeKey(3);
			driver.navigate().refresh();
			// Download report in pdf format.
			Utils.click(By.xpath(getObj("Propval1", "pdfDownloadIcon", "EStatment")), "pdf download");
			Utils.wait(3);
			Utils.enterOTPAndProceed();
			Utils.moveToElement(By.id("logo"));
			driver.navigate().refresh();
			// Download report in excel format.
			Utils.click(By.xpath(getObj("Propval1", "excelDownloadIcon", "EStatment")), "Excel Download");
			Utils.wait(3);
			// Utils.enterOTPAndProceed();
			Utils.moveToElement(By.id("logo"));
			// Print report.
			Utils.wait(6);
			driver.navigate().refresh();
			Utils.click(By.xpath(getObj("Propval1", "printBtnIcon", "EStatment")), "Print Button");
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

	public static Boolean CardPaymentHistory(String TCName, int ScenarioCount, Object[] tCsDataset) throws Exception {

		String NextDate, FutureDate, isNegative, AfterTxfrAdditionalOptions;

		try {
			if (isMasterClassRun) {

				Log.info("Data set for this scenario is " + System.lineSeparator() + ReadData.getJsonData(TCName, ScenarioCount, "DataSet"));
				NextDate = Utils.DateValue(Integer.parseInt(ReadDataSQL(TCName, ScenarioCount, "NextDate")));
				FutureDate = Utils.DateValue(Integer.parseInt(ReadDataSQL(TCName, ScenarioCount, "FutureDate")));
				isNegative = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "isNegative"));
				AfterTxfrAdditionalOptions = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "AfterTxfrAdditionalOptions"));
			} else {
				Log.info("Data set for this scenario is " + System.lineSeparator() + dataset[scenarioCount - 1]);
				NextDate = Utils.DateValue(Integer.parseInt(ReadDataSQL(TCName, ScenarioCount, "NextDate")));
				FutureDate = Utils.DateValue(Integer.parseInt(ReadDataSQL(TCName, ScenarioCount, "FutureDate")));
				isNegative = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("isNegative"));
				AfterTxfrAdditionalOptions = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("AfterTxfrAdditionalOptions"));

			}

			Utils.click(By.xpath(getObj("Propval1", "Cards", "Menues")), " Cards Manu");
			Utils.wait(6);

			Utils.click(By.xpath(getObj("Propval1", "history", "CardPaymentHistory")), "History");

			String LandPage = Utils.getText(By.xpath(getObj("Propval1", "LandPage", "CardPaymentHistory")));

			Log.pass("Page title is " + LandPage);

			Utils.ClearText(By.xpath(getObj("Propval1", "CreditCardNumber", "CardPaymentHistory")));

			if (isNegative.equalsIgnoreCase("true")) {
				Utils.sendValDropdown(By.xpath(getObj("Propval1", "CreditCardNumber", "CardPaymentHistory")), ReadTestData(TCName, "InvalidCreditNumber"));
			} else {

				// Select Account
				Utils.sendValDropdown(By.xpath(getObj("Propval1", "CreditCardNumber", "CardPaymentHistory")), ReadTestData(TCName, "CreditCardNo"));
				Utils.pressKeyDown();
				Utils.pressKeyDown();
				Utils.pressEnter();
				Log.pass("Select CreditCard " + ReadTestData("ResetCardPIN", "CreditCardNo"));
			}
			Utils.ClearText(By.xpath(getObj("Propval1", "AccountNumber", "CardPaymentHistory")));

			Utils.wait(6);

			// Select Account
			Utils.sendValDropdown(By.xpath(getObj("Propval1", "AccountNumber", "CardPaymentHistory")), ReadTestData(TCName, "AccountNumber"));
			Utils.pressKeyDown();
			Utils.pressKeyDown();
			Utils.pressEnter();

			Log.pass("Select Account Number  " + ReadTestData("ResetCardPIN", "AccountNumber"));

			Utils.sendKeys(By.xpath(getObj("Propval1", "startdate", "CardPaymentHistory")), ReadTestData(TCName, "NextDate"), "From Date");
			Utils.sendKeys(By.xpath(getObj("Propval1", "enddate", "CardPaymentHistory")), ReadTestData(TCName, "FutureDate"), "To Date");

			Utils.sendKeys(By.xpath(getObj("Propval1", "amountfrom", "CardPaymentHistory")), ReadTestData(TCName, "AmountFrom"), "From Amount");
			Utils.sendKeys(By.xpath(getObj("Propval1", "amountto", "CardPaymentHistory")), ReadTestData(TCName, "AmountTO"), "To Amount");

			if (isNegative.equalsIgnoreCase("true")) {

				try {

					Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "error", "CardPaymentHistory")), "error"));
					Log.pass("Error appear while adding nvalid card number hence test case pass");
					Utils.logPassImage("Worng Credit Card");
					return true;

				} catch (AssertionError | Exception e) {
					Log.fail("No error appear with invalid card number hence test case fail");
					throw e;

				}

			}

			// Click on Table

			Utils.click(By.xpath(getObj("Propval1", "Search", "CardPaymentHistory")), "Search");
			Log.pass("Click on Search.....");

			Utils.wait(6);
			String Result = Utils.getText(By.xpath(getObj("Propval1", "Result", "CardPaymentHistory")));

			Log.pass("Displayed Result is  :" + Result);

			if (AfterTxfrAdditionalOptions.equalsIgnoreCase("true")) {

				emailCardPaymentHistory(TCName);
			}
		} catch (Exception e) {

			runResult = false;
			throw e;
		}
		return runResult;
	}

	public static boolean emailCardPaymentHistory(String Nickname) throws Exception {

		try {
			// Start sending email , downloading pdf and printing etc.
			Utils.wait(3);
			Log.info("Starting send email functionality");

			Utils.click(By.xpath(getObj("Propval1", "sendEmailIcon", "CardPaymentHistory")), "Send Email Icon");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailTo", "CardPaymentHistory")), Input.ReadTestData("MarketInfo", "toEmail"), "to email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailCC", "CardPaymentHistory")), Input.ReadTestData("MarketInfo", "ccEmail"), "to CC email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "bccEmail", "CardPaymentHistory")), Input.ReadTestData("MarketInfo", "bccEmail"), "to BCC  email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "emailSubject", "CardPaymentHistory")), Input.ReadTestData("MarketInfo", "emailSubject"), "email Subject ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEMailMsgBox", "CardPaymentHistory")), Input.ReadTestData("MarketInfo", "sendEMailMsgBox"), "Mail Body ");

			Utils.click(By.xpath(getObj("Propval1", "cancelemailBtnEle", "CardPaymentHistory")), "Cancel Email Button");
			Utils.wait(5);
			Utils.click(By.xpath(getObj("Propval1", "sendEmailIcon", "CardPaymentHistory")), "Send Email Icon");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailTo", "CardPaymentHistory")), Input.ReadTestData("MarketInfo", "toEmail"), "to email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailCC", "CardPaymentHistory")), Input.ReadTestData("MarketInfo", "ccEmail"), "to CC email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "bccEmail", "CardPaymentHistory")), Input.ReadTestData("MarketInfo", "bccEmail"), "to BCC  email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "emailSubject", "CardPaymentHistory")), Input.ReadTestData("MarketInfo", "emailSubject"), "email Subject ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEMailMsgBox", "CardPaymentHistory")), Input.ReadTestData("MarketInfo", "sendEMailMsgBox"), "Mail Body ");
			Utils.wait(5);
			Utils.click(By.xpath(getObj("Propval1", "sendBtnEle", "CardPaymentHistory")), "Send Email Button");
			Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "WaitingElements", "CardPaymentHistory")));
			Utils.pressEnter();
			Utils.wait(2);
			Utils.pressEscapeKey(3);

			Utils.pressEscapeKey(3);
			driver.navigate().refresh();
			// Download report in pdf format.
			Utils.click(By.xpath(getObj("Propval1", "pdfDownloadIcon", "CardPaymentHistory")), "pdf download");
			Utils.wait(3);
			Utils.enterOTPAndProceed();
			Utils.moveToElement(By.id("logo"));
			driver.navigate().refresh();
			// Download report in excel format.
			Utils.click(By.xpath(getObj("Propval1", "excelDownloadIcon", "CardPaymentHistory")), "Excel Download");
			Utils.wait(3);
			// Utils.enterOTPAndProceed();
			Utils.moveToElement(By.id("logo"));
			// Print report.
			Utils.wait(6);
			driver.navigate().refresh();
			Utils.click(By.xpath(getObj("Propval1", "printBtnIcon", "CardPaymentHistory")), "Print Button");
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
