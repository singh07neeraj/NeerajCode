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
public class JOL_CREDIT_CARDS_DETAIL_INQUIRY_FUNC extends TestBase {

	public static boolean CreditCatdDetails(String TCName, int ScenarioCount, Object[] tCsDataset) throws Exception {

		try {

			if (isMasterClassRun) {

				Log.info("Data set for this scenario is " + System.lineSeparator() + ReadData.getJsonData(TCName, ScenarioCount, "DataSet"));

			} else {
				Log.info("Data set for this scenario is " + System.lineSeparator() + dataset[scenarioCount - 1]);

			}

			Utils.click(By.xpath(getObj("Propval1", "Cards", "Menues")), " Card Manu");
			Utils.wait(6);

			Utils.click(By.xpath(getObj("Propval1", "Details", "Card")), " Card Details");

			String LandPage = Utils.getText(By.xpath(getObj("Propval1", "Cards", "Menues")));

			Log.pass("Page title is " + LandPage);

			// Click on Table

			Utils.click(By.xpath(getObj("Propval1", "Table", "Card")), " Card Table Manu");

			String CardNumber = Utils.getText(By.xpath(getObj("Propval1", "CardNumber", "Card")));

			Log.pass("Displayed Card Number is :" + CardNumber);

			// Click on Graphics

			Utils.click(By.xpath(getObj("Propval1", "Graphic", "Card")), " Graphic Manu");
			try {
				Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "GraphicLandPage", "Card")), "GraphicLandPage"));
				Log.pass("Graphic LandPage is displayed......");
			} catch (AssertionError | Exception e) {
				Log.fail("GraphicLandPage is not displayed");
				throw e;
			}

		} catch (Exception e) {

			runResult = false;
			throw e;
		}
		return runResult;
	}

	public static boolean Transactions(String TCName, int ScenarioCount, Object[] tCsDataset) throws Exception {
		String SearchType, isNegative, AfterTxfrAdditionalOptions;
		try {
			if (isMasterClassRun) {

				Log.info("Data set for this scenario is " + System.lineSeparator() + ReadData.getJsonData(TCName, ScenarioCount, "DataSet"));

				SearchType = ReadDataSQL(TCName, ScenarioCount, "SearchType");
				isNegative = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "isNegative"));
				AfterTxfrAdditionalOptions = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "AfterTxfrAdditionalOptions"));

			} else {
				Log.info("Data set for this scenario is " + System.lineSeparator() + dataset[scenarioCount - 1]);

				SearchType = (String) Utils.getUiData(dataset[scenarioCount - 1]).get("SearchType");
				isNegative = (String) Utils.getUiData(dataset[scenarioCount - 1]).get("isNegative");
				AfterTxfrAdditionalOptions = (String) Utils.getUiData(dataset[scenarioCount - 1]).get("AfterTxfrAdditionalOptions");

			}

			Utils.scrollUpVertically();

			Utils.click(By.xpath(getObj("Propval1", "Cards", "Menues")), " Card Manu");
			Utils.wait(6);

			Utils.click(By.xpath(getObj("Propval1", "Transaction", "Card")), " Card Manu");
			Log.pass("Successful Clicked Card Transaction  Menu........");

			String LandPage = Utils.getText(By.xpath(getObj("Propval1", "LandPage", "Card")));

			Log.pass("Page title is " + LandPage);

			// Select Account

			if (isNegative.equalsIgnoreCase("true")) {
				Utils.ClearText(By.xpath(getObj("Propval1", "CreditCard", "Card")));

				Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "CreditCardDropDown", "Card")), By.xpath(getObj("Propval1", "CreditCard", "Card")), Input.ReadTestData(TCName, "InvalidCreditCardNo"));

			} else {
				Utils.ClearText(By.xpath(getObj("Propval1", "CreditCard", "Card")));

				Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "CreditCardDropDown", "Card")), By.xpath(getObj("Propval1", "CreditCard", "Card")), Input.ReadTestData(TCName, "CreditCardNo"));
				Utils.pressKeyDown();
				Utils.pressKeyDown();
				Utils.pressEnter();
			}
			Log.pass("Enter Credit Type is " + Input.ReadTestData(TCName, "CreditCardNo"));

			Utils.wait(6);

			if (isNegative.equalsIgnoreCase("true")) {
				try {

					Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "error", "Card")), "Error message "));
					Log.pass("Not able to proceed with invalid data hence test case pass");
					Utils.logPassImage(TCName);
					return true;
				} catch (AssertionError | Exception e) {

					Log.fail("able to proceed with invalid data hence test case fail");
					Utils.logFailImage(TCName);

					throw e;
				}
			}

			// Click on Table

			if (Integer.parseInt(SearchType) == 1) {
				Utils.sendValDropdown(By.xpath(getObj("Propval1", "Period", "Card")), Input.ReadTestData(TCName, "period"));
				Utils.wait(6);

				// Click on Search
				Utils.click(By.xpath(getObj("Propval1", "Search", "Card")), " Search");

				Utils.wait(6);

			} else if (Integer.parseInt(SearchType) == 2) {
				Utils.click(By.xpath(getObj("Propval1", "Advance", "Card")), " Advance Search");
				Utils.wait(6);
				// Click TO date
				WebElement TDate = driver.findElement(By.xpath(getObj("Propval1", "FromDate", "Card")));
				TDate.sendKeys(ReadTestData(TCName, "NextDate"));
				// Utils.DateValue((Integer.parseInt(ReadDataSQL(TCName, ScenarioCount, "")))));
				Utils.wait(6);
				// Click From Date
				WebElement FromDate = driver.findElement(By.xpath(getObj("Propval1", "TODate", "Card")));
				FromDate.sendKeys(ReadTestData(TCName, "NextDate"));
				// Utils.DateValue((Integer.parseInt(ReadDataSQL(TCName, ScenarioCount,
				// "FutureDate")))));
				Utils.wait(6);

				Utils.click(By.xpath(getObj("Propval1", "AdvanceSearch", "Card")), " Advance Search ");

			} else {
				Utils.click(By.xpath(getObj("Propval1", "statment", "Card")), " Statment");

				Utils.sendValDropdown(By.xpath(getObj("Propval1", "StatmentPeriod", "Card")), Input.ReadTestData(TCName, "StatmentPeriod"));

				Utils.click(By.xpath(getObj("Propval1", "StatmentSearch", "Card")), " Statment Search");
			}
			Utils.wait(6);
			Utils.logPassImage(TCName);
			// Click on Period
			if (AfterTxfrAdditionalOptions.equalsIgnoreCase("True")) {
				Log.pass("Starting additional actions after transfer. e.g send email, print and save as favourite.");
				eCorpCommonFunctions.sendEmailDownloadExcelnPrintFunc(ScenarioCount);
				Log.pass("Additional Actions  like send email, print and download pdf/excel etc have  passed successfully.");
				Utils.logPassImage("Additional Actions");
			}

		} catch (Exception e) {

			runResult = false;
			throw e;
		}
		return runResult;
	}


	public static boolean PendingTransactions(String TCName, int ScenarioCount, Object[] tCsDataset) throws Exception {
		String isNegative, AfterTxfrAdditionalOptions;
		try {
			if (isMasterClassRun) {

				Log.info("Data set for this scenario is " + System.lineSeparator() + ReadData.getJsonData(TCName, ScenarioCount, "DataSet"));
				isNegative = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "isNegative"));
				AfterTxfrAdditionalOptions = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "AfterTxfrAdditionalOptions"));

			} else {
				Log.info("Data set for this scenario is " + System.lineSeparator() + dataset[scenarioCount - 1]);
				isNegative = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("isNegative"));
				AfterTxfrAdditionalOptions = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("AfterTxfrAdditionalOptions"));
			}

			Utils.click(By.xpath(getObj("Propval1", "Cards", "Menues")), " Card Manu");
			Utils.wait(10);

			Utils.click(By.xpath(getObj("Propval1", "Pending", "Card")), " Pending Transaction Manu");
			Log.pass("Successful Clicked  Pending Transaction  Menu........");

			String LandPage = Utils.getText(By.xpath(getObj("Propval1", "LandPage", "Card")));

			Log.pass("Page title is " + LandPage);

// Select Account

			if (isNegative.equalsIgnoreCase("true")) {
				Utils.sendValDropdown(By.xpath(getObj("Propval1", "CreditCardNUmber", "Card")), Input.ReadTestData(TCName, "InvalidCreditCard"));
			} else {
				Utils.sendValDropdown(By.xpath(getObj("Propval1", "CreditCardNUmber", "Card")), Input.ReadTestData(TCName, "CreditCardNo"));
				Utils.pressKeyDown();
				Utils.pressKeyDown();
				Utils.pressEnter();

				Log.pass("Selected Accout is  :" + Input.ReadTestData(TCName, "CreditCardNo"));
				Utils.wait(6);
			}

			if (isNegative.equalsIgnoreCase("true")) {
				try {

					Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "error", "Card")), "error"));
					Log.pass("error occour while enteriing the invalid card number hence testcase pass");
					Utils.logPassImage(TCName);
					return true;

				} catch (AssertionError | Exception e) {
					Log.fail("No error occur while entering the invalid card number hence test case fail ");
					Utils.logFailImage(TCName);
					throw e;
				}

			}
			Log.pass("Click on Search Button");

			Utils.click(By.xpath(getObj("Propval1", "Search", "Card")), " Search");

// Search Result	
			Utils.wait(6);
			String Result = Utils.getText(By.xpath(getObj("Propval1", "NoResult", "Card")));

			Log.pass("Displayed Result :" + Result);

			if (AfterTxfrAdditionalOptions.equalsIgnoreCase("true")) {
				Log.pass("Starting additional actions after transfer. e.g send email, print and save as favourite.");
				eCorpCommonFunctions.sendEmailDownloadExcelnPrintFunc(ScenarioCount);
				Log.pass("Additional Actions  like send email, print and download pdf/excel etc have  passed successfully.");
				Utils.logPassImage("Additional Actions");
			}
		} catch (Exception e) {

			runResult = false;
			throw e;
		}
		return runResult;
	}

	public static boolean emailPendingTransactions(String Nickname) throws Exception {

		try {
			// Start sending email , downloading pdf and printing etc.
			Utils.wait(3);
			Log.info("Starting send email functionality");

			Utils.click(By.xpath(getObj("Propval1", "sendEmailIcon", "emailPendingTransactions")), "Send Email Icon");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailTo", "emailPendingTransactions")), Input.ReadTestData("MarketInfo", "toEmail"), "to email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailCC", "emailPendingTransactions")), Input.ReadTestData("MarketInfo", "ccEmail"), "to CC email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "bccEmail", "emailPendingTransactions")), Input.ReadTestData("MarketInfo", "bccEmail"), "to BCC  email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "emailSubject", "emailPendingTransactions")), Input.ReadTestData("MarketInfo", "emailSubject"), "email Subject ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEMailMsgBox", "emailPendingTransactions")), Input.ReadTestData("MarketInfo", "sendEMailMsgBox"), "Mail Body ");

			Utils.click(By.xpath(getObj("Propval1", "cancelemailBtnEle", "emailPendingTransactions")), "Cancel Email Button");
			Utils.wait(5);
			Utils.click(By.xpath(getObj("Propval1", "sendEmailIcon", "emailPendingTransactions")), "Send Email Icon");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailTo", "emailPendingTransactions")), Input.ReadTestData("MarketInfo", "toEmail"), "to email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailCC", "emailPendingTransactions")), Input.ReadTestData("MarketInfo", "ccEmail"), "to CC email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "bccEmail", "emailPendingTransactions")), Input.ReadTestData("MarketInfo", "bccEmail"), "to BCC  email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "emailSubject", "emailPendingTransactions")), Input.ReadTestData("MarketInfo", "emailSubject"), "email Subject ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEMailMsgBox", "emailPendingTransactions")), Input.ReadTestData("MarketInfo", "sendEMailMsgBox"), "Mail Body ");
			Utils.wait(5);
			Utils.click(By.xpath(getObj("Propval1", "sendBtnEle", "emailPendingTransactions")), "Send Email Button");
			Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "WaitingElements", "emailPendingTransactions")));
			Utils.pressEnter();
			Utils.wait(2);
			Utils.pressEscapeKey(3);

			Utils.pressEscapeKey(3);
			driver.navigate().refresh();
			// Download report in pdf format.
			Utils.click(By.xpath(getObj("Propval1", "pdfDownloadIcon", "emailPendingTransactions")), "pdf download");
			Utils.wait(3);
			Utils.enterOTPAndProceed();
			Utils.moveToElement(By.id("logo"));
			driver.navigate().refresh();
			// Download report in excel format.
			Utils.click(By.xpath(getObj("Propval1", "excelDownloadIcon", "emailPendingTransactions")), "Excel Download");
			Utils.wait(3);
			// Utils.enterOTPAndProceed();
			Utils.moveToElement(By.id("logo"));
			// Print report.
			Utils.wait(6);
			driver.navigate().refresh();
			Utils.click(By.xpath(getObj("Propval1", "printBtnIcon", "emailPendingTransactions")), "Print Button");
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

	public static boolean CardPayments(String TCName, int ScenarioCount, Object[] tCsDataset) throws Exception {

		try {
			String Paytype, Proceed, Confirm, isAmountNegative, AMOUNT, other, AddAnotherTransaction, AMOUNT_Modify, AfterTxfrAdditionalOptions;

			if (isMasterClassRun) {

				Log.info("Data set for this scenario is " + System.lineSeparator() + ReadData.getJsonData(TCName, ScenarioCount, "DataSet"));

				Paytype = ReadDataSQL(TCName, ScenarioCount, "Paytype");

				Proceed = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Proceed"));
				Confirm = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Confirm"));

				isAmountNegative = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "isAmountNegative"));
				AMOUNT = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "AMOUNT"));
				other = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "other"));
				AddAnotherTransaction = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "AddAnotherTransaction"));
				AMOUNT_Modify = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "AMOUNT_Modify"));
				AfterTxfrAdditionalOptions = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "AfterTxfrAdditionalOptions"));

			} else {
				Log.info("Data set for this scenario is " + System.lineSeparator() + dataset[scenarioCount - 1]);

				Paytype = (String) Utils.getUiData(dataset[scenarioCount - 1]).get("Paytype");

				Proceed = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Proceed"));
				Confirm = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Confirm"));
				isAmountNegative = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "isAmountNegative"));
				AMOUNT = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("AMOUNT"));

				other = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("other"));

				AMOUNT_Modify = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("AMOUNT_Modify"));
				AfterTxfrAdditionalOptions = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("AfterTxfrAdditionalOptions"));

				AddAnotherTransaction = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("AddAnotherTransaction"));

			}

			Utils.scrollUpVertically();

			Utils.click(By.xpath(getObj("Propval1", "Cards", "Menues")), " Card Manu");
			Utils.wait(10);

			Utils.click(By.xpath(getObj("Propval1", "CardPayment", "Card")), " Card Payment Manu");
			Log.pass("Successful Clicked  Credit Card Payments  Menu........");

			String LandPage = Utils.getText(By.xpath(getObj("Propval1", "LandPage", "Card")));

			Log.pass("Page title is " + LandPage);

			Utils.wait(6);
			if (other.equalsIgnoreCase("NewCard")) {

				Utils.click(By.xpath(getObj("Propval1", "OtherCard", "Card")), " OtherCard");
				Utils.sendKeys(By.xpath(getObj("Propval1", "NickName", "Card")), Input.ReadTestData(TCName, "Nickname"));

				Utils.sendKeys(By.xpath(getObj("Propval1", "sadadrefNO", "Card")), Input.ReadTestData(TCName, "SADAD"));
				Utils.click(By.xpath(getObj("Propval1", "registerCard", "Card")), " Register Card");

				Utils.sendKeys(By.xpath(getObj("Propval1", "OtherCardAmount", "Card")), AMOUNT);

			} else {
				// Select My Cards
				Utils.ClearText(By.xpath(getObj("Propval1", "MyCard", "Card")));

				Utils.sendValDropdown(By.xpath(getObj("Propval1", "MyCard", "Card")), Input.ReadTestData(TCName, "CreditCardNo"));

				Log.pass("Selected Accout is  :" + Input.ReadTestData(TCName, "CreditCardNo"));
				Utils.wait(6);
			}
			Utils.ClearText(By.xpath(getObj("Propval1", "formAccount", "Card")));

			// Select From Account
			Utils.sendValDropdown(By.xpath(getObj("Propval1", "formAccount", "Card")), Input.ReadTestData(TCName, "AccountNumber"));
			Log.pass("Selected From Account Accout is  :" + Input.ReadTestData("JOL Credit Cards-Card Payment", "AccountNumber"));

			if (other.equalsIgnoreCase("NewCard")) {
				Log.pass("Enter Amout is " + AMOUNT);
			} else {
				// Pay type

				if (Integer.parseInt(Paytype) == 1) {
					Utils.click(By.xpath(getObj("Propval1", "Paymin", "Card")), " Pay Min ");

					Log.pass("Select Min Payment ");
				} else if (Integer.parseInt(Paytype) == 2) {
					Utils.click(By.xpath(getObj("Propval1", "PayoutstandingBAL", "Card")), " Pay Out Standing Bill");

					Log.pass("Select Outstanding Balance Payment ");
				} else {
					Log.pass("Select Other Balance Payment ");
					Utils.wait(6);
					Utils.click(By.xpath(getObj("Propval1", "otheramt", "Card")), " other Amount");

					Utils.sendKeys(By.xpath(getObj("Propval1", "amypay", "Card")), AMOUNT);

				}
			}

			if (Integer.parseInt(AddAnotherTransaction) == 1) {

				Utils.click(By.xpath(getObj("Propval1", "addanotherTransaction", "Card")), "addanother Transaction");
				Log.pass("Select Other Balance Payment ");
				Utils.click(By.xpath(getObj("Propval1", "otheramt", "Card")), " other Amount");

				Utils.sendKeys(By.xpath(getObj("Propval1", "amypay", "Card")), AMOUNT_Modify);
			}

			if (Integer.parseInt(Proceed) == 1) {

				Utils.click(By.xpath(getObj("Propval1", "Proceed", "Card")), " Proceed");
			} else if (Integer.parseInt(Proceed) == 2) {
				Utils.click(By.xpath(getObj("Propval1", "addanotherTransaction", "Card")), " another Transaction");
				Log.pass("Select Another Transaction ");
			} else {
				Log.pass("Select Cancel Transaction Button");
				Utils.click(By.xpath(getObj("Propval1", "cancelButton", "Card")), " Cancel Button");
			}

			if (isAmountNegative.equalsIgnoreCase("true")) {
				int home = Utils.getSize(By.xpath(getObj("Propval1", "Confirm", "Card")));
				if (home == 0) {
					Log.pass("Please enter Valid Values");
					Utils.logPassImage("Home Page error");
					return true;
				}

			} else {
				int home = Utils.getSize(By.xpath(getObj("Propval1", "Confirm", "Card")));
				if (home == 0) {
					Log.fail("Please enter Valid Values");
					Utils.logFailImage("Home Page error");
					return false;
				}
			}

			if (Integer.parseInt(Confirm) == 1) {
				Log.pass("Click on Confirmation Button");
				Utils.click(By.xpath(getObj("Propval1", "Confirm", "Card")), " Confirm Button");

			} else if (Integer.parseInt(Confirm) == 2) {
				Log.pass("Select Modify Transaction ");
				Utils.click(By.xpath(getObj("Propval1", "modify", "Card")), "Succesfully Click Modify");
				Utils.wait(6);
				Utils.sendKeys(By.xpath(getObj("Propval1", "amypay", "Card")), AMOUNT_Modify);
			} else {
				Log.pass("Select Cancel  Transaction ");
				Utils.click(By.xpath(getObj("Propval1", "cancelButton", "Card")), " Cancel");
				Utils.wait(6);
				Utils.click(By.xpath(getObj("Propval1", "CancelYes", "Card")), " Cancel Yes");
				return runResult;

			}
			try {
				Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "SuccessMessage", "Card")), "Success Message"));
				Log.pass("Credit card Payments completed successfully.");
				Utils.logPassImage("Payment Result-Pass");

			} catch (AssertionError | Exception e) {

				Log.fail("Credit card Payments failed...Message:" + Utils.getText(By.xpath(getObj("Propval1", "failMessage", "Card"))));
				Utils.logFailImage("Payment Result-Fail");
				throw e;
			}

			Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "WaitingElements", "Card")));
			if (AfterTxfrAdditionalOptions.equalsIgnoreCase("true")) {
				Log.pass("Starting additional actions after transfer. e.g send email, print and save as favourite.");
				eCorpCommonFunctions.sendEmailDownloadExcelnPrintFunc(ScenarioCount);
				Log.pass("Additional Actions  like send email, print and download pdf/excel etc have  passed successfully.");
				Utils.logPassImage("Additional Actions");
			}

		} catch (Exception e) {

			runResult = false;
			throw e;
		}
		return runResult;
	}

	public static boolean addFavSendEmailDownloadPdfNprintFunc(String Nickname) throws Exception {

		try {
			// to click on additional options
			Log.info("Started clicking on additional options");
			Utils.click(By.xpath(getObj("Propval1", "AddAsFavourite", "Card")), "Add As Favourite link");

			Utils.wait(5);
			Utils.sendKeys(By.xpath(getObj("Propval1", "NickName_Txt", "Card")), Nickname, "Save as favourite nick name");
			Utils.click(By.xpath(getObj("Propval1", "AddAsFav_Save_Btn", "Card")), "Add As Favourite Save button");
			Log.pass("Successfully saved transaction as favourite.");
			Utils.wait(3);

			// to click Export PDF link
			Utils.click(By.xpath(getObj("Propval1", "ExportPDF", "Card")), "Export PDF link");
			Log.pass("Export to pdf operation completed successfully");
			Utils.wait(3);
			// to click Print link
			Utils.click(By.xpath(getObj("Propval1", "Print", "Card")), "Print link");
			Utils.wait(3);
			Utils.closeOtherTabs();
			Utils.wait(3);
			driver.navigate().refresh();
			// to click Send By Email link
			/*
			 * Utils.click(By.xpath(getObj("Propval1", "SendByEmail", "Card")),
			 * "Send By Email link"); Utils.wait(3);
			 * Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailTo", "Card")),
			 * ReadTestData("MarketInfo", "toEmail"), "to email ");
			 * Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailCC", "Card")),
			 * ReadTestData("MarketInfo", "ccEmail"), "to CC email ");
			 * Utils.sendKeys(By.xpath(getObj("Propval1", "bccEmail", "Card")),
			 * ReadTestData("MarketInfo", "bccEmail"), "to BCC  email ");
			 * Utils.sendKeys(By.xpath(getObj("Propval1", "emailSubject", "Card")),
			 * ReadTestData("MarketInfo", "emailSubject"), "email Subject ");
			 * Utils.sendKeys(By.xpath(getObj("Propval1", "sendEMailMsgBox", "Card")),
			 * ReadTestData("MarketInfo", "sendEMailMsgBox"), "Mail Body ");
			 * 
			 * Utils.click(By.xpath(getObj("Propval1", "SendByEmail_Send_Btn", "Card")),
			 * "Send by Email Button"); Utils.pressEscapeKey(3);
			 * Utils.waitForInVisibilityOfEle( By.xpath(getObj("Propval1",
			 * "WaitingElements", "Card"))); Utils.pressEnter(); Utils.wait(2);
			 * Utils.pressEscapeKey(3);
			 * 
			 * Utils.pressEscapeKey(3); driver.navigate().refresh();
			 * 
			 * Log.pass("Send email function completed successfully");
			 */
			// add success assertion.

		}

		catch (Exception e) {

			Log.fail("addFavSendEmailDownloadPdfNprintFunc has failed..error " + Utils.getText(By.xpath(getObj("Propval1", "ErrorMsg_SendByEmail", "Additional_Options"))));
			Utils.pressEscapeKey(3);
			runResult = false;
			throw e;
		}

		return runResult;
	}

}
