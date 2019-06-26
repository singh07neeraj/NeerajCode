package javaMain.JOL.creditcards;

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
public class JOL_CREDIT_CARDS_APPLY_NEWCREDITCARD_FUNC extends TestBase {

	public static boolean ApplyNewCreditCard(String TCName, int ScenarioCount, Object[] tCsDataset) throws Exception {

		String delivery, Proceed, Confirm, OTPCancelConfirm, TCButton, CheckBox, NewTxn, AfterTxfrAdditionalOptions,
				isNegative;

		try {

			if (isMasterClassRun) {

				Log.pass("Data set for this scenario is " + System.lineSeparator()
						+ ReadData.getJsonData(TCName, ScenarioCount, "DataSet"));
				delivery = ReadDataSQL(TCName, ScenarioCount, "delivery");

				Proceed = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Proceed"));
				Confirm = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Confirm"));

				OTPCancelConfirm = ReadDataSQL(TCName, ScenarioCount, "OTPCancelConfirm");
				TCButton = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "TCButton"));
				CheckBox = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "CheckBox"));
				NewTxn = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "NewTxn"));
				isNegative = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "isNegative"));
				AfterTxfrAdditionalOptions = Utils
						.setValue(ReadDataSQL(TCName, ScenarioCount, "AfterTxfrAdditionalOptions"));

			} else {
				Log.pass("Data set for this scenario is " + System.lineSeparator() + dataset[scenarioCount - 1]);
				delivery = (String) Utils.getUiData(dataset[scenarioCount - 1]).get("delivery");

				Proceed = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Proceed"));
				Confirm = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Confirm"));
				OTPCancelConfirm = (String) Utils.getUiData(dataset[scenarioCount - 1]).get("OTPCancelConfirm");
				TCButton = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("TCButton"));
				CheckBox = (String) Utils.getUiData(dataset[scenarioCount - 1]).get("CheckBox");
				isNegative = (String) Utils.getUiData(dataset[scenarioCount - 1]).get("isNegative");
				NewTxn = (String) Utils.getUiData(dataset[scenarioCount - 1]).get("NewTxn");
				AfterTxfrAdditionalOptions = (String) Utils.getUiData(dataset[scenarioCount - 1])
						.get("AfterTxfrAdditionalOptions");
			}

			Utils.scrollUpVertically();
						
			Utils.click(By.xpath(getObj("Propval1", "Cards", "Menues")), "Card Menus");
			Utils.wait(6);

			Utils.click(By.xpath(getObj("Propval1", "applyCreditCard", "ApplyCreditCard")), "Apply Credit Card ");

			String LandPage = Utils.getText(By.xpath(getObj("Propval1", "LandPage", "ApplyCreditCard")));

			Log.pass("Page title is " + LandPage);

			if (isNegative.equalsIgnoreCase("true")) {
				Utils.sendKeys_DD(By.xpath(getObj("Propval1", "CreditCardType", "ApplyCreditCard")),
						Input.ReadTestData(TCName, "InvalidCreditType"));

			} else {
				
				Utils.sendKeys_DD(By.xpath(getObj("Propval1", "CreditCardType", "ApplyCreditCard")),
						Input.ReadTestData(TCName, "CreditType"));
				
				Utils.sendKeys_DD(By.xpath(getObj("Propval1", "CreditCard", "ApplyCreditCard")),
						Input.ReadTestData(TCName, "CreditCard"));
			}
			
		
			Utils.waitForInVisibilityOfEle(
					By.xpath(getObj("Propval1", "WaitingElements", "CreditCard_BeneficiaryManagement")));
			Utils.clickSafely(By.xpath(getObj("Propval1", "CredtiCardAccept", "ApplyCreditCard")), "credit Card Accept");
			// Enter email
			Utils.ClearText(By.xpath(getObj("Propval1", "email", "ApplyCreditCard")));

			Utils.sendKeys_DD(By.xpath(getObj("Propval1", "email", "ApplyCreditCard")),
					Input.ReadTestData(TCName, "email"));

			// Clear Text
			Utils.ClearText(By.xpath(getObj("Propval1", "NameonCard", "ApplyCreditCard")));

			// Enter Card Name
			Utils.sendKeys_DD(By.xpath(getObj("Propval1", "NameonCard", "ApplyCreditCard")),
					Input.ReadTestData(TCName, "NameonCard"));

			if (Integer.parseInt(delivery) == 1) {
				Utils.click(By.xpath(getObj("Propval1", "PickupfromBranch", "ApplyCreditCard")), "Pick up from branch");

				Utils.ClearText(By.xpath(getObj("Propval1", "Branch", "ApplyCreditCard")));
				Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "BranchDropdown", "ApplyCreditCard")),
						By.xpath(getObj("Propval1", "Branch", "ApplyCreditCard")),
						Input.ReadTestData(TCName, "Branch"));

			} else {

				Utils.click(By.xpath(getObj("Propval1", "expressmail", "ApplyCreditCard")), "Select expressmail");

				Utils.sendKeys_DD(By.xpath(getObj("Propval1", "city", "ApplyCreditCard")),
						Input.ReadTestData(TCName, "city"));

				// Select Area

				Utils.sendKeys_DD(By.xpath(getObj("Propval1", "area", "ApplyCreditCard")),
						Input.ReadTestData(TCName, "area"));
				// Select Street
				Utils.sendKeys_DD(By.xpath(getObj("Propval1", "street", "ApplyCreditCard")),
						Input.ReadTestData(TCName, "street"));

			}

			// Enter CIty

			Utils.wait(6);
			// Utils.click(By.xpath(getObj("Propval1", "Conditioncheck",
			// "ApplyCreditCard")), "Conditioncheck");

			if (TCButton.equalsIgnoreCase("True")) {
				if (CheckBox.equalsIgnoreCase("True")) {
					// Click on the terms and Conditions CheckBox Directly//
					Utils.click(By.xpath(getObj("Propval1", "CheckBoxTC", "ApplyCreditCard")),
							"on Terms and Conditons Button directly");
				} else if (CheckBox.equalsIgnoreCase("False")) {
					// Click on the link of Terms and Conditions//
					Utils.click(By.xpath(getObj("Propval1", "TnCpoup", "ApplyCreditCard")),
							"which is a link of Terms and Conditions");
					// Click on I Accept Radio of the pop up//
					Utils.click(By.xpath(getObj("Propval1", "TnCAgree", "ApplyCreditCard")),
							"which is I Accept RadioButton");

				}

			} else if (TCButton.equalsIgnoreCase("False")) {
				// Click on Proceed Button//
				Utils.click(By.xpath(getObj("Propval1", "Proceed", "ApplyCreditCard")), "Proceed Button");
				try {

					Assert.assertEquals(
							Utils.assertDisplayed(By.xpath(getObj("Propval1", "Confirm", "ApplyCreditCard")), "false"),
							false);
					Log.pass(
							"Successfully validated that user is unable to complete transaction without selecting terms and conditions.");
					return true;
				} catch (AssertionError | Exception e) {
					Log.fail("Proceeded Further without clicking on Terms and Condtions");
					runResult = false;
					throw e;
				}

			}

			if (Integer.parseInt(Proceed) == 1) {

				Utils.click(By.xpath(getObj("Propval1", "Proceed", "ApplyCreditCard")), "Proceed");

			} else {

				Utils.click(By.xpath(getObj("Propval1", "Cancel", "ApplyCreditCard")), "Cancel Proceed");

			}

			if (isNegative.equalsIgnoreCase("true")) {
				try {
					Assert.assertFalse(Utils.assertDisplayed(By.xpath(getObj("Propval1", "Confirm", "ApplyCreditCard")),
							"Confirm"));
					Log.pass("Not able to click on Confirm with invalid data hence test case pass");
					Utils.logPassImage(TCName);
					return runResult;

				} catch (AssertionError | Exception e) {
					Log.fail("User are able to go to confirm page with invalid data also hence test case fail");
					Utils.logFailImage(TCName);
					throw e;
				}
			}
			int Confirm1 = Utils.getSize(By.xpath(getObj("Propval1", "Confirm", "ApplyCreditCard")));
			if (Confirm1 == 0) {
				Log.fail("Please enter valid fields");
				Utils.logPassImage("Not able to proceed please review page again");
				return false;
			}

			if (Integer.parseInt(Confirm) == 1) {

				Utils.click(By.xpath(getObj("Propval1", "Confirm", "ApplyCreditCard")), "Comfirm");

				Utils.wait(6);

			} else if (Integer.parseInt(Confirm) == 2) {

				Utils.click(By.xpath(getObj("Propval1", "modify", "ApplyCreditCard")), "Modify");
				Utils.waitForInVisibilityOfEle(
						By.xpath(getObj("Propval1", "WaitingElements", "CreditCard_BeneficiaryManagement")));
				Utils.clickSafely(By.xpath(getObj("Propval1", "CredtiCardAccept", "ApplyCreditCard")), "credit Card Accept");
				Utils.wait(3);
				Utils.click(By.xpath(getObj("Propval1", "Conditioncheck", "ApplyCreditCard")), "Condition Check");
				Utils.waitForInVisibilityOfEle(
						By.xpath(getObj("Propval1", "WaitingElements", "CreditCard_BeneficiaryManagement")));
				Utils.click(By.xpath(getObj("Propval1", "Proceed", "ApplyCreditCard")), "Modify Proceed");
				Utils.waitForInVisibilityOfEle(
						By.xpath(getObj("Propval1", "WaitingElements", "CreditCard_BeneficiaryManagement")));
				Utils.click(By.xpath(getObj("Propval1", "Confirm", "ApplyCreditCard")), "Modify Confirm");

			} else {
				Utils.click(By.xpath(getObj("Propval1", "Cancel", "ApplyCreditCard")), "Confirm Cancel");

				Utils.click(By.xpath(getObj("Propval1", "CancelYes", "ApplyCreditCard")), "Confirm Cancel Yes");

				return runResult;
			}

			if (Integer.parseInt(OTPCancelConfirm) == 1) {

				Utils.enterOTPAndProceed("0123");

			} else {
				Utils.click(By.xpath(getObj("Propval1", "Cancel", "ApplyCreditCard")), "Cancel OTP");

				Utils.click(By.xpath(getObj("Propval1", "CancelYes", "ApplyCreditCard")), "Yes OTP Cancel");

				return runResult;

			}

			try {
				Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "SuccessMessage", "Card")),
						"Success Message"));
				Log.pass("Credit card apply new credit card successfully.");
				Log.pass("Message is :" + Utils.getText(By.xpath(getObj("Propval1", "SuccessMessage", "Card"))));
				Utils.logPassImage("apply new credit card-Pass");

			} catch (AssertionError | Exception e) {

				Log.fail("Credit card apply new credit card failed...Message:"
						+ Utils.getText(By.xpath(getObj("Propval1", "failMessage", "Card"))));
				Utils.logFailImage("apply new credit card-Fail");

			}

			/*
			 * try { String Success = Utils.getText(By.xpath(getObj("Propval1",
			 * "SuccessMessage", "Card"))); Utils.logPassImage("Apply New Credit Card");
			 * Log.pass(" Message:" + Success); } catch (Exception e) {
			 * Log.pass("Success Object No found" + e.getMessage()); }
			 */
			if (AfterTxfrAdditionalOptions.equalsIgnoreCase("TRUE")) {
				Log.pass("Starting additional actions after transfer. e.g send email, print and save as favourite.");
				eCorpCommonFunctions.sendEmailDownloadExcelnPrintFunc(ScenarioCount);
				Log.pass(
						"Additional Actions  like send email, print and download pdf/excel etc have  passed successfully.");
				Utils.logPassImage("Additional Actions");

			}

			if (Integer.parseInt(NewTxn) == 1) {
				Utils.scrollDownVertically();
				Utils.click(By.xpath(getObj("Propval1", "NewTransactionBtn", "ApplyCreditCard")), "New Transaction");

				Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "proceed", "ApplyCreditCard")),
						"NewTransaction Home page"));

				Log.pass("New Transaction is landed successfully");
				Utils.logPassImage(TCName);

			} else {
				Utils.click(By.xpath(getObj("Propval1", "Home", "ApplyCreditCard")), "Home Button.");
				Assert.assertTrue(Utils.assertDisplayed(
						By.xpath(getObj("Propval1", "HomepageSuccess", "ApplyCreditCard")), "HomepageSuccess"));
				Log.pass("Home page is landed successfully");
				Utils.logPassImage(TCName);

			}

		} catch (Exception e) {

			runResult = false;
			throw e;
		}
		return runResult;
	}

	public static boolean sendEmailDownloadExcelnPrintFuncOrderStatusApplyCredtiCard() throws Exception {

		try {
			// Start sending email , downloading pdf and printing etc.
			Utils.wait(3);
			Log.info("Starting send email functionality");

			Utils.click(By.xpath(getObj("Propval1", "sendEmailIcon", "ApplyCreditCard")), "Send Email Icon");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailTo", "ApplyCreditCard")),
					Input.ReadTestData("MarketInfo", "toEmail"), "to email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailCC", "ApplyCreditCard")),
					Input.ReadTestData("MarketInfo", "ccEmail"), "to CC email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "bccEmail", "ApplyCreditCard")),
					Input.ReadTestData("MarketInfo", "bccEmail"), "to BCC  email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "emailSubject", "ApplyCreditCard")),
					Input.ReadTestData("MarketInfo", "emailSubject"), "email Subject ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEMailMsgBox", "ApplyCreditCard")),
					Input.ReadTestData("MarketInfo", "sendEMailMsgBox"), "Mail Body ");

			Utils.click(By.xpath(getObj("Propval1", "cancelemailBtnEle", "ApplyCreditCard")), "Cancel Email Button");
			Utils.wait(5);
			Utils.click(By.xpath(getObj("Propval1", "sendEmailIcon", "ApplyCreditCard")), "Send Email Icon");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailTo", "ApplyCreditCard")),
					Input.ReadTestData("MarketInfo", "toEmail"), "to email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailCC", "ApplyCreditCard")),
					Input.ReadTestData("MarketInfo", "ccEmail"), "to CC email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "bccEmail", "ApplyCreditCard")),
					Input.ReadTestData("MarketInfo", "bccEmail"), "to BCC  email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "emailSubject", "ApplyCreditCard")),
					Input.ReadTestData("MarketInfo", "emailSubject"), "email Subject ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEMailMsgBox", "ApplyCreditCard")),
					Input.ReadTestData("MarketInfo", "sendEMailMsgBox"), "Mail Body ");
			Utils.wait(5);
			Utils.click(By.xpath(getObj("Propval1", "sendBtnEle", "ApplyCreditCard")), "Send Email Button");
			Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "WaitingElements", "ApplyCreditCard")));
			Utils.pressEnter();
			Utils.wait(2);
			Utils.pressEscapeKey(3);
			// Download report in pdf format.
			Utils.click(By.xpath(getObj("Propval1", "pdfDownloadIcon", "ApplyCreditCard")), "pdf download");
			Utils.wait(3);
			Utils.enterOTPAndProceed();
			Utils.moveToElement(By.id("logo"));
			// Download report in excel format.

			// Print report.
			Utils.click(By.xpath(getObj("Propval1", "printBtnIcon", "ApplyCreditCard")), "Print Button");
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

	public static Boolean ReSetPIN(String TCName, int ScenarioCount, Object[] tCsDataset) throws Exception {

		String OTPCancelConfirm, Proceed, Confirm, isNegative, AfterTxfrAdditionalOptions, NewTxn;
		try {

			if (isMasterClassRun) {

				Log.pass("Data set for this scenario is " + System.lineSeparator()
						+ ReadData.getJsonData(TCName, ScenarioCount, "DataSet"));

				OTPCancelConfirm = ReadDataSQL(TCName, ScenarioCount, "OTPCancelConfirm");

				Proceed = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Proceed"));
				Confirm = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Confirm"));
				isNegative = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "isNegative"));
				AfterTxfrAdditionalOptions = Utils
						.setValue(ReadDataSQL(TCName, ScenarioCount, "AfterTxfrAdditionalOptions"));
				NewTxn = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "NewTxn"));

			} else {
				Log.pass("Data set for this scenario is " + System.lineSeparator() + dataset[scenarioCount - 1]);

				OTPCancelConfirm = (String) Utils.getUiData(dataset[scenarioCount - 1]).get("OTPCancelConfirm");

				Proceed = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Proceed"));
				Confirm = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Confirm"));
				isNegative = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("isNegative"));
				AfterTxfrAdditionalOptions = Utils.setValue(
						(String) Utils.getUiData(dataset[scenarioCount - 1]).get("AfterTxfrAdditionalOptions"));
				NewTxn = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("NewTxn"));
			}

			Utils.scrollUpVertically();

			Utils.click(By.xpath(getObj("Propval1", "Cards", "Menues")), "Card Manu");

			Utils.click(By.xpath(getObj("Propval1", "pin", "ResetCardPIN")), "PIN Reset");
			Log.pass("Successful Open Card PIN Reset by Menu.......");

			String LandPage = Utils.getText(By.xpath(getObj("Propval1", "LandPage", "ResetCardPIN")));

			Log.pass("Page title is " + LandPage);

			if (isNegative.equalsIgnoreCase("true"))
			{
				
			}
			else
			{

			// Enter Credit Card Type
			Utils.ClearText(By.xpath(getObj("Propval1", "CreditCard", "ResetCardPIN")));
			Utils.sendValDropdown(By.xpath(getObj("Propval1", "CreditCard", "ResetCardPIN")),
					Input.ReadTestData(TCName, "CreditCardNo"),"Credit Card Number");
			}
			Log.pass("Enter Credit card begin with " + Input.ReadTestData(TCName, "CreditCardNo"));

			// Enter PIN
			Utils.click(By.xpath(getObj("Propval1", "PINKeyword1", "ResetCardPIN")), "PINKeyword1");

			Utils.click(By.xpath(getObj("Propval1", "PIN1", "ResetCardPIN")), "Enter 1st PIN");
			Utils.click(By.xpath(getObj("Propval1", "PIN2", "ResetCardPIN")), "Enter 2nd PIN");
			Utils.click(By.xpath(getObj("Propval1", "PIN3", "ResetCardPIN")), "Enter 3rd PIN");
			Utils.click(By.xpath(getObj("Propval1", "PIN4", "ResetCardPIN")), "Enter 4th PIN");

			Utils.click(By.xpath(getObj("Propval1", "ConfirmPIN", "ResetCardPIN")), "Confirm PIN");

			// Enter PIN
			Utils.click(By.xpath(getObj("Propval1", "PINKeyword2", "ResetCardPIN")), "Display virtual keyboard");

			Utils.click(By.xpath(getObj("Propval1", "PIN1", "ResetCardPIN")), "Enter 1st PIN");
			Utils.click(By.xpath(getObj("Propval1", "PIN2", "ResetCardPIN")), "Enter 2nd PIN");
			Utils.click(By.xpath(getObj("Propval1", "PIN3", "ResetCardPIN")), "Enter 3rd PIN");
			Utils.click(By.xpath(getObj("Propval1", "PIN4", "ResetCardPIN")), "Enter 4th PIN");
			// *[@id="keyboardInputNumpad"]//td[1]
			Log.pass("Enter Confirm PIN.............................");

			if (Integer.parseInt(Proceed) == 1) {

				Utils.click(By.xpath(getObj("Propval1", "Proceed", "ResetCardPIN")), "Proceed");
				
			} else {

				Utils.click(By.xpath(getObj("Propval1", "Cancel", "ResetCardPIN")), "Cancel");
				
				Utils.logPassImage(TCName);
				return runResult;

			}

			
			if (isNegative.equalsIgnoreCase("true")) {
				try {

					Assert.assertFalse(Utils.assertDisplayed(By.xpath(getObj("Propval1", "Confirm", "RequestASupplementaryCard")), "error"));
					Log.pass("Not able to proceed  without selecting Card hence test case pass!!!!!");
					Utils.logPassImage(TCName);
					return true;

				} catch (AssertionError | Exception e) {

					Log.fail("able to proceed without selecting Card  hence test case fail!!!!");
					Utils.logFailImage(TCName);
					throw e;
				}

			} 
			if (Integer.parseInt(Confirm) == 1) {

				Utils.click(By.xpath(getObj("Propval1", "Confirm", "ResetCardPIN")), "Confirm");

				Utils.wait(6);

			} else if (Integer.parseInt(Confirm) == 2) {
			

				Utils.click(By.xpath(getObj("Propval1", "modify", "ResetCardPIN")), "Modify");
				Utils.wait(6);

				// Enter PIN
				Utils.click(By.xpath(getObj("Propval1", "PINKeyword1", "ResetCardPIN")), "Display virtual keyboard");
				Log.pass("Clcik on PIN KeyBord");

				Utils.click(By.xpath(getObj("Propval1", "PIN1", "ResetCardPIN")), "Enter 1st PIN");
				Utils.click(By.xpath(getObj("Propval1", "PIN2", "ResetCardPIN")), "Enter 2nd PIN");
				Utils.click(By.xpath(getObj("Propval1", "PIN3", "ResetCardPIN")), "Enter 3rd PIN");
				Utils.click(By.xpath(getObj("Propval1", "PIN4", "ResetCardPIN")), "Enter 4th PIN");
				// *[@id="keyboardInputNumpad"]//td[1]

				Utils.click(By.xpath(getObj("Propval1", "ConfirmPIN", "ResetCardPIN")), "Confirm PIN");

				// Enter PIN
				Utils.click(By.xpath(getObj("Propval1", "PINKeyword2", "ResetCardPIN")), "Confirm  virtual keyboard");

				Utils.click(By.xpath(getObj("Propval1", "PIN1", "ResetCardPIN")), "Enter 1st PIN");
				Utils.click(By.xpath(getObj("Propval1", "PIN2", "ResetCardPIN")), "Enter 2nd PIN");
				Utils.click(By.xpath(getObj("Propval1", "PIN3", "ResetCardPIN")), "Enter 3rd PIN");
				Utils.click(By.xpath(getObj("Propval1", "PIN4", "ResetCardPIN")), "Enter 4th PIN");

				Utils.click(By.xpath(getObj("Propval1", "Proceed", "ResetCardPIN")), "Proceed");
				// Click on Confirm
				Utils.click(By.xpath(getObj("Propval1", "Confirm", "ResetCardPIN")), "COnfirm");

			} else {
				Utils.click(By.xpath(getObj("Propval1", "Cancel", "ResetCardPIN")), "Cancel");
				Utils.wait(6);
				Utils.click(By.xpath(getObj("Propval1", "CancelYes", "ResetCardPIN")), "Cancel Yes");
				Utils.logPassImage(TCName);
				return runResult;
			}

			if (Integer.parseInt(OTPCancelConfirm) == 1) {

				Utils.enterOTPAndProceed("0123");
				Log.pass("Enter OTP..........");

			} else {
				Utils.click(By.xpath(getObj("Propval1", "Cancel", "ResetCardPIN")), "Cancel OTP");
				Utils.wait(6);
				Utils.click(By.xpath(getObj("Propval1", "CancelYes", "ResetCardPIN")), "Yes OTP Cancel");
				Log.pass("OTP Cancel ......");
				Utils.logPassImage(TCName);
				return runResult;

			}

			try {
				Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "SuccessMessage", "Card")),	"Success Message"));
				Log.pass("Reset pin completed successfully.");
				Log.pass("Message is :" + Utils.getText(By.xpath(getObj("Propval1", "SuccessMessage", "Card"))));
				Utils.logPassImage("Reset pin-Pass");

			} catch (AssertionError | Exception e) {

				Log.fail("Reset pin failed...Message:"
						+ Utils.getText(By.xpath(getObj("Propval1", "failMessage", "Card"))));
				Utils.logFailImage("Reset pin-Fail");
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
				Utils.click(By.xpath(getObj("Propval1", "NewTransactionBtn", "ResetCardPIN")), "New Transaction");
				Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "proceed", "ResetCardPIN")), "New Transaction Home Page"));

				Log.pass("New Transaction is landed successfully");

				Utils.logPassImage(TCName);
			

			} else {
				Utils.click(By.xpath(getObj("Propval1", "Home", "ResetCardPIN")), "Home Button.");
				Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "HomepageSuccess", "ResetCardPIN")), "Home page"));
				Log.pass("Home page is landed successfully");
				Utils.logPassImage(TCName);
			}

		} catch (Exception e) {

			runResult = false;
			throw e;
		}
		return runResult;
	}

	public static boolean emailReSetPIN(String Nickname) throws Exception {

		try {
			// Start sending email , downloading pdf and printing etc.
			Utils.wait(3);
			Log.info("Starting send email functionality");

			Utils.click(By.xpath(getObj("Propval1", "sendEmailIcon", "ResetCardPIN")), "Send Email Icon");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailTo", "ResetCardPIN")),
					Input.ReadTestData("MarketInfo", "toEmail"), "to email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailCC", "ResetCardPIN")),
					Input.ReadTestData("MarketInfo", "ccEmail"), "to CC email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "bccEmail", "ResetCardPIN")),
					Input.ReadTestData("MarketInfo", "bccEmail"), "to BCC  email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "emailSubject", "ResetCardPIN")),
					Input.ReadTestData("MarketInfo", "emailSubject"), "email Subject ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEMailMsgBox", "ResetCardPIN")),
					Input.ReadTestData("MarketInfo", "sendEMailMsgBox"), "Mail Body ");

			Utils.click(By.xpath(getObj("Propval1", "cancelemailBtnEle", "ResetCardPIN")), "Cancel Email Button");
			Utils.wait(5);
			Utils.click(By.xpath(getObj("Propval1", "sendEmailIcon", "ResetCardPIN")), "Send Email Icon");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailTo", "ResetCardPIN")),
					Input.ReadTestData("MarketInfo", "toEmail"), "to email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailCC", "ResetCardPIN")),
					Input.ReadTestData("MarketInfo", "ccEmail"), "to CC email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "bccEmail", "ResetCardPIN")),
					Input.ReadTestData("MarketInfo", "bccEmail"), "to BCC  email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "emailSubject", "ResetCardPIN")),
					Input.ReadTestData("MarketInfo", "emailSubject"), "email Subject ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEMailMsgBox", "ResetCardPIN")),
					Input.ReadTestData("MarketInfo", "sendEMailMsgBox"), "Mail Body ");
			Utils.wait(5);
			Utils.click(By.xpath(getObj("Propval1", "sendBtnEle", "ResetCardPIN")), "Send Email Button");
			Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "WaitingElements", "ResetCardPIN")));
			Utils.pressEnter();
			Utils.wait(2);
			Utils.pressEscapeKey(3);

			Utils.pressEscapeKey(3);
			driver.navigate().refresh();
			// Download report in pdf format.
			Utils.click(By.xpath(getObj("Propval1", "pdfDownloadIcon", "ResetCardPIN")), "pdf download");
			Utils.wait(3);
			Utils.enterOTPAndProceed();
			Utils.moveToElement(By.id("logo"));
			driver.navigate().refresh();
			// Download report in excel format.
			/*
			 * Utils.click(By.xpath(getObj("Propval1", "excelDownloadIcon",
			 * "ResetCardPIN")), "Excel Download"); Utils.wait(3); //
			 * Utils.enterOTPAndProceed(); Utils.moveToElement(By.id("logo"));
			 */
			// Print report.
			Utils.wait(6);
			driver.navigate().refresh();
			Utils.click(By.xpath(getObj("Propval1", "printBtnIcon", "ResetCardPIN")), "Print Button");
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
