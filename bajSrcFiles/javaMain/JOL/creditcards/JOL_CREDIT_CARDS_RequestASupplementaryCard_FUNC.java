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
public class JOL_CREDIT_CARDS_RequestASupplementaryCard_FUNC extends TestBase {

	public static boolean RequestASupplementaryCard(String TCName, int ScenarioCount, Object[] tCsDataset) throws Exception {

		String delivery, Proceed, Confirm, CheckBox, OTPCancelConfirm, TCButton, isNegative, AfterTxfrAdditionalOptions, NewTxn;

		try {
			if (isMasterClassRun) {

				Log.info("Data set for this scenario is " + System.lineSeparator() + ReadData.getJsonData(TCName, ScenarioCount, "DataSet"));
				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + ReadData.getJsonData(TCName, ScenarioCount, "DataSet") + "</mark>");
				delivery = ReadDataSQL(TCName, ScenarioCount, "delivery");

				Proceed = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Proceed"));
				Confirm = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Confirm"));
				CheckBox = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "CheckBox"));
				OTPCancelConfirm = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "OTPCancelConfirm"));
				TCButton = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "TCButton"));
				isNegative = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "isNegative"));
				AfterTxfrAdditionalOptions = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "AfterTxfrAdditionalOptions"));
				NewTxn = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "NewTxn"));

			} else {
				Log.info("Data set for this scenario is " + System.lineSeparator() + dataset[scenarioCount - 1]);
				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + dataset[scenarioCount - 1] + "</mark>");
				delivery = (String) Utils.getUiData(dataset[scenarioCount - 1]).get("delivery");

				Proceed = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Proceed"));
				Confirm = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Confirm"));
				CheckBox = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("CheckBox"));
				OTPCancelConfirm = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("OTPCancelConfirm"));
				TCButton = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("TCButton"));
				isNegative = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("isNegative"));
				AfterTxfrAdditionalOptions = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("AfterTxfrAdditionalOptions"));
				NewTxn = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("NewTxn"));
			}

			Utils.scrollUpVertically();

			Utils.click(By.xpath(getObj("Propval1", "Cards", "Menues")), "Clcik on Card Manu");
			Utils.wait(6);

			Utils.click(By.xpath(getObj("Propval1", "RequestASupplementaryCard", "RequestASupplementaryCard")), "Request A Supplementary Card");

			String LandPage = Utils.getText(By.xpath(getObj("Propval1", "LandPage", "ApplyCreditCard")));

			Log.pass("Page title is " + LandPage);

			/*
			 * Utils.click(By.xpath(getObj("Propval1", "CreditCard",
			 * "RequestASupplementaryCard")), "Click on Credit Card"); // Enter Credit Card
			 * Type Utils.Sendkeys_DD_substringbased(By.xpath(getObj("Propval1",
			 * "CreditCard", "RequestASupplementaryCard")), ReadDataSQL(TCName,
			 * ScenarioCount, "CreditCard"));
			 */

			Utils.ClearText(By.xpath(getObj("Propval1", "CreditCard", "RequestASupplementaryCard")));
			Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "CreditCardDropdown", "RequestASupplementaryCard")), By.xpath(getObj("Propval1", "CreditCard", "RequestASupplementaryCard")), Input.ReadTestData(TCName, "CreditCardNo"));

			Log.pass("Enter Credit Type is " + ReadTestData("ResetCardPIN", "CreditCardNo"));

			// Enter Card Holder Name
			Utils.sendKeys(By.xpath(getObj("Propval1", "CardHolderName", "RequestASupplementaryCard")), Input.ReadTestData(TCName, "CardHolderName"));
			Log.pass("Enter Card Holder name ");
			// Card Holder No
			Utils.sendKeys(By.xpath(getObj("Propval1", "cardHolderIdNumber", "RequestASupplementaryCard")), Input.ReadTestData(TCName, "cardHolderIdNumber"));
			Log.pass("Enter Card Holder Number ");
			// Select Relation Status
			Utils.sendKeys_DD(By.xpath(getObj("Propval1", "Relationship", "RequestASupplementaryCard")), Input.ReadTestData(TCName, "Relationship"));
			Log.pass("Enter RelationShip ");

			Utils.sendKeys_DD(By.xpath(getObj("Propval1", "Name", "RequestASupplementaryCard")), Input.ReadTestData(TCName, "Name"));
			Log.pass("Enter RelationShip ");
			// Select Card Limits
			Utils.wait(2);
			Utils.clickSafely(By.xpath(getObj("Propval1", "HomeAccept", "RequestASupplementaryCard")), "Accept PopUp");
			Utils.wait(2);
			if (isNegative.equalsIgnoreCase("true")) {
				Utils.click(By.xpath(getObj("Propval1", "Limit", "RequestASupplementaryCard")), "click on Limit");
				Utils.sendKeys(By.xpath(getObj("Propval1", "Limit", "RequestASupplementaryCard")), Input.ReadTestData(TCName, "NegativeAmount"));
			} else {
				Utils.pressTab();
				Utils.click(By.xpath(getObj("Propval1", "Limit", "RequestASupplementaryCard")), "click on Limit");
				Utils.sendKeys(By.xpath(getObj("Propval1", "Limit", "RequestASupplementaryCard")), Input.ReadTestData(TCName, "Amount"));
			}

			if (Integer.parseInt(delivery) == 1) {
				Utils.click(By.xpath(getObj("Propval1", "PickupfromBranch", "ApplyCreditCard")), "Pick up from branch");

				Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "BranchDropdown", "ApplyCreditCard")), By.xpath(getObj("Propval1", "Branch", "ApplyCreditCard")), Input.ReadTestData(TCName, "Branch"));

			} else {

				Utils.click(By.xpath(getObj("Propval1", "expressmail", "RequestASupplementaryCard")), "Select expressmail");

				Utils.sendKeys_DD(By.xpath(getObj("Propval1", "city", "RequestASupplementaryCard")), Input.ReadTestData(TCName, "city"));

				// Select Area

				Utils.sendKeys_DD(By.xpath(getObj("Propval1", "Area", "RequestASupplementaryCard")), Input.ReadTestData(TCName, "Area"));
				// Select Street
				Utils.sendKeys_DD(By.xpath(getObj("Propval1", "street", "RequestASupplementaryCard")), Input.ReadTestData(TCName, "street"));

			}

			/*
			 * System.out.println("ChecBox Value " + getObj("Propval1", "Conditioncheck",
			 * "RequestASupplementaryCard")); Utils.wait(6);
			 * Utils.click(By.xpath(getObj("Propval1", "Conditioncheck",
			 * "RequestASupplementaryCard")), "Successfully Clicked on Condition Check");
			 * Log.pass("Click on Check Box......"); Utils.wait(6);
			 */
			Utils.clickSafely(By.xpath(getObj("Propval1", "HomeAccept", "RequestASupplementaryCard")), "Accept PopUp");
			if (TCButton.equalsIgnoreCase("True")) {
				if (CheckBox.equalsIgnoreCase("True")) {
					// Click on the terms and Conditions CheckBox Directly//
					Utils.click(By.xpath(getObj("Propval1", "CheckBoxTC", "RequestASupplementaryCard")), "on Terms and Conditons Button directly");
				} else if (CheckBox.equalsIgnoreCase("False")) {
					// Click on the link of Terms and Conditions//
					Utils.click(By.xpath(getObj("Propval1", "TnCpoup", "RequestASupplementaryCard")), "which is a link of Terms and Conditions");
					// Click on I Accept Radio of the pop up//
					Utils.click(By.xpath(getObj("Propval1", "TnCAgree", "RequestASupplementaryCard")), "which is I Accept RadioButton");

				}

			} else if (TCButton.equalsIgnoreCase("False")) {
				// Click on Proceed Button//
				Utils.click(By.xpath(getObj("Propval1", "Proceed", "RequestASupplementaryCard")), "Proceed Button");
				try {

					// This is to validate if the user moves to the next page without selecting
					// Terms and Condition CheckBox//
					Assert.assertEquals(Utils.assertDisplayed(By.xpath(getObj("Propval1", "Confirm", "RequestASupplementaryCard")), "Confirm"), false);
					Log.pass("Successfully validated that user is unable to complete transaction without selecting terms and conditions.");
					Utils.logPassImage(TCName);
					return true;
				} catch (AssertionError | Exception e) {
					Log.fail("Proceeded Further without clicking on Terms and Condtions");
					runResult = false;
					throw e;
				}

			}
			Utils.clickSafely(By.xpath(getObj("Propval1", "HomeAccept", "RequestASupplementaryCard")), "Accept PopUp");
			if (Integer.parseInt(Proceed) == 1) {

				Utils.click(By.xpath(getObj("Propval1", "Proceed", "RequestASupplementaryCard")), "Successfully Clicked on Proceed Button");
				Log.pass("Click on Proceed ......");
			} else {

				Utils.click(By.xpath(getObj("Propval1", "Cancel", "RequestASupplementaryCard")), "Successfully Clicked on Cancel Button");
				Log.pass("Click on Cancel Button......");
				return runResult;

			}
			if (isNegative.equalsIgnoreCase("true")) {

				try {

					Assert.assertFalse(Utils.assertDisplayed(By.xpath(getObj("Propval1", "Confirm", "RequestASupplementaryCard")), "error"));
					Log.pass("Not able to proceed  while entering the negative amount hence test case pass!!!!!");
					Utils.logPassImage(TCName);

				} catch (AssertionError | Exception e) {

					Log.fail("able to proceed  while entering the negative amount hence test case fail!!!!");
					Utils.logFailImage(TCName);
					throw e;
				}

			}

			if (Integer.parseInt(Confirm) == 1) {
				Log.pass("Click on Confirm ......");
				Utils.click(By.xpath(getObj("Propval1", "Confirm", "RequestASupplementaryCard")), "Successfully Clicked on Confirm Button");

				Utils.wait(6);

			} else if (Integer.parseInt(Confirm) == 2) {
				Log.pass("Click on Confirm Modify ......");

				Utils.click(By.xpath(getObj("Propval1", "modify", "RequestASupplementaryCard")), "Successfully Clicked on Modify Button");
				Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "WaitingElements", "CreditCard_BeneficiaryManagement")));

				Utils.click(By.xpath(getObj("Propval1", "Conditioncheck", "RequestASupplementaryCard")), "Successfully Clicked on Condition Check");
				Log.pass("Click on modify Check Box......");
				Utils.wait(2);
				Utils.clickSafely(By.xpath(getObj("Propval1", "HomeAccept", "RequestASupplementaryCard")), "Accept PopUp");
				Utils.click(By.xpath(getObj("Propval1", "Proceed", "RequestASupplementaryCard")), "Successfully Clicked on Proceed Button");
				Log.pass("Click on Modify Proceed ......");
				Utils.clickSafely(By.xpath(getObj("Propval1", "HomeAccept", "RequestASupplementaryCard")), "Accept PopUp");
				Log.pass("Click on Modify Confirm ......");
				Utils.click(By.xpath(getObj("Propval1", "Confirm", "RequestASupplementaryCard")), "Successfully Clicked on Confirm Button");

			} else {
				Utils.click(By.xpath(getObj("Propval1", "Cancel", "RequestASupplementaryCard")), "Successfully Clicked on Confirm  Cancel Button");
				Utils.wait(6);
				Utils.click(By.xpath(getObj("Propval1", "CancelYes", "RequestASupplementaryCard")), "Successfully Clicked on Confirm Cancel Yes Button");
				Log.pass("Click on Confirm Cancel ......");
				return runResult;
			}
			if (Integer.parseInt(OTPCancelConfirm) == 1) {

				Utils.enterOTPAndProceed("0123");

			} else {
				Utils.click(By.xpath(getObj("Propval1", "Cancel", "RequestASupplementaryCard")), "Cancel OTP");
				Utils.wait(6);
				Utils.click(By.xpath(getObj("Propval1", "CancelYes", "RequestASupplementaryCard")), "Yes OTP Cancel");
				Utils.logPassImage("OTP Cancel");
				return runResult;

			}

			try {
				Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "SuccessMessage", "Card")), "Success Message"));
				Log.pass("Request A Supplementary Card completed successfully.");
				Log.pass("Message is :" + Utils.getText(By.xpath(getObj("Propval1", "SuccessMessage", "Card"))));
				Utils.logPassImage("Request A Supplementary Card-Pass");

			} catch (AssertionError | Exception e) {

				Log.fail("Request A Supplementary Card failed...Message:" + Utils.getText(By.xpath(getObj("Propval1", "failMessage", "Card"))));
				Utils.logFailImage("Request A Supplementary Card-Fail");
				throw e;
			}

			if (AfterTxfrAdditionalOptions.equalsIgnoreCase("TRUE")) {

				Log.pass("Starting additional actions after transfer. e.g send email, print and save as favourite.");
				eCorpCommonFunctions.sendEmailDownloadExcelnPrintFunc(ScenarioCount);
				Log.pass("Additional Actions  like send email, print and download pdf/excel etc have  passed successfully.");
				Utils.logPassImage("Additional Actions");
			}

			if (Integer.parseInt(NewTxn) == 1) {
				Utils.scrollDownVertically();
				Utils.click(By.xpath(getObj("Propval1", "NewTransactionBtn", "RequestASupplementaryCard")), "New Transaction");
				Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "proceed", "RequestASupplementaryCard")), "New Transaction Home Page"));

				Log.pass("New Transaction is landed successfully");

				Utils.logPassImage(TCName);
			} else {
				Utils.click(By.xpath(getObj("Propval1", "Home", "RequestASupplementaryCard")), "Home Button.");
				Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "HomepageSuccess", "RequestASupplementaryCard")), "Home page"));
				Log.pass("Home page is landed successfully");
				Utils.logPassImage(TCName);
			}

		} catch (Exception e) {

			runResult = false;
			throw e;
		}
		return runResult;
	}

	public static boolean emailRequestASupplementaryCard(String Nickname) throws Exception {

		try {
			// Start sending email , downloading pdf and printing etc.
			Utils.wait(3);
			Log.info("Starting send email functionality");

			Utils.click(By.xpath(getObj("Propval1", "sendEmailIcon", "RequestASupplementaryCard")), "Send Email Icon");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailTo", "RequestASupplementaryCard")), Input.ReadTestData("MarketInfo", "toEmail"), "to email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailCC", "RequestASupplementaryCard")), Input.ReadTestData("MarketInfo", "ccEmail"), "to CC email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "bccEmail", "RequestASupplementaryCard")), Input.ReadTestData("MarketInfo", "bccEmail"), "to BCC  email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "emailSubject", "RequestASupplementaryCard")), Input.ReadTestData("MarketInfo", "emailSubject"), "email Subject ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEMailMsgBox", "RequestASupplementaryCard")), Input.ReadTestData("MarketInfo", "sendEMailMsgBox"), "Mail Body ");

			Utils.click(By.xpath(getObj("Propval1", "cancelemailBtnEle", "RequestASupplementaryCard")), "Cancel Email Button");
			Utils.wait(5);
			Utils.click(By.xpath(getObj("Propval1", "sendEmailIcon", "RequestASupplementaryCard")), "Send Email Icon");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailTo", "RequestASupplementaryCard")), Input.ReadTestData("MarketInfo", "toEmail"), "to email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailCC", "RequestASupplementaryCard")), Input.ReadTestData("MarketInfo", "ccEmail"), "to CC email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "bccEmail", "RequestASupplementaryCard")), Input.ReadTestData("MarketInfo", "bccEmail"), "to BCC  email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "emailSubject", "RequestASupplementaryCard")), Input.ReadTestData("MarketInfo", "emailSubject"), "email Subject ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEMailMsgBox", "RequestASupplementaryCard")), Input.ReadTestData("MarketInfo", "sendEMailMsgBox"), "Mail Body ");
			Utils.wait(5);
			Utils.click(By.xpath(getObj("Propval1", "sendBtnEle", "RequestASupplementaryCard")), "Send Email Button");
			Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "WaitingElements", "RequestASupplementaryCard")));
			Utils.pressEnter();
			Utils.wait(2);
			Utils.pressEscapeKey(3);

			Utils.pressEscapeKey(3);
			driver.navigate().refresh();
			// Download report in pdf format.
			Utils.click(By.xpath(getObj("Propval1", "pdfDownloadIcon", "RequestASupplementaryCard")), "pdf download");
			Utils.wait(3);
			Utils.enterOTPAndProceed();
			Utils.moveToElement(By.id("logo"));
			driver.navigate().refresh();
			// Download report in excel format.
			/*
			 * Utils.click(By.xpath(getObj("Propval1", "excelDownloadIcon",
			 * "RequestASupplementaryCard")), "Excel Download"); Utils.wait(3); //
			 * Utils.enterOTPAndProceed(); Utils.moveToElement(By.id("logo"));
			 */
			// Print report.
			Utils.wait(6);
			driver.navigate().refresh();
			Utils.click(By.xpath(getObj("Propval1", "printBtnIcon", "RequestASupplementaryCard")), "Print Button");
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
