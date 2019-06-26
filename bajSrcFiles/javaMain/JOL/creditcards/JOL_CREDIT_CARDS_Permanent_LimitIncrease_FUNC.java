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
public class JOL_CREDIT_CARDS_Permanent_LimitIncrease_FUNC extends TestBase {

	public static Boolean PermanentLimitIncrease(String TCName, int ScenarioCount, Object[] tCsDataset)
			throws Exception {

		String Limit, Proceed, Confirm, CheckBox, OTPCancelConfirm, TCButton, isNegative, AfterTxfrAdditionalOptions,
				NewTxn;

		try {

			if (isMasterClassRun) {

				Log.info("Data set for this scenario is " + System.lineSeparator()
						+ ReadData.getJsonData(TCName, ScenarioCount, "DataSet"));

				Limit = ReadDataSQL(TCName, ScenarioCount, "Limit");
				Proceed = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Proceed"));
				Confirm = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Confirm"));
				CheckBox = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "CheckBox"));
				OTPCancelConfirm = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "OTPCancelConfirm"));
				TCButton = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "TCButton"));
				isNegative = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "isNegative"));
				AfterTxfrAdditionalOptions = Utils
						.setValue(ReadDataSQL(TCName, ScenarioCount, "AfterTxfrAdditionalOptions"));
				NewTxn = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "NewTxn"));
			} else {
				Log.info("Data set for this scenario is " + System.lineSeparator() + dataset[scenarioCount - 1]);

				Limit = (String) Utils.getUiData(dataset[scenarioCount - 1]).get("Limit");
				Proceed = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Proceed"));
				Confirm = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Confirm"));
				CheckBox = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("CheckBox"));
				OTPCancelConfirm = Utils
						.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("OTPCancelConfirm"));
				TCButton = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("TCButton"));
				isNegative = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("isNegative"));
				AfterTxfrAdditionalOptions = Utils.setValue(
						(String) Utils.getUiData(dataset[scenarioCount - 1]).get("AfterTxfrAdditionalOptions"));
				NewTxn = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("NewTxn"));
			}

			Utils.scrollUpVertically();

			Utils.click(By.xpath(getObj("Propval1", "Cards", "Menues")), "Card Manu");
			Utils.wait(6);

			Utils.click(By.xpath(getObj("Propval1", "LimitIncrease", "PermLimitIncrease")), "Permanent Limit Increase");
			Log.pass("Successful Click on Permanent LimitIncrease ");

			String LandPage = Utils.getText(By.xpath(getObj("Propval1", "LandPage", "PermLimitIncrease")));

			Log.pass("Page title is " + LandPage);

			// Enter Credit Card Type

			Utils.ClearText(By.xpath(getObj("Propval1", "CreditCard", "PermLimitIncrease")));
			Utils.sendValDropdown(By.xpath(getObj("Propval1", "CreditCard", "PermLimitIncrease")),
					ReadTestData(TCName, "CreditCardNo"));

			Log.pass("Enter Credit :" + ReadTestData(TCName, "CreditCardNo"));

			if (Integer.parseInt(Limit) == 1) {
				Utils.click(By.xpath(getObj("Propval1", "percent", "PermLimitIncrease")), "Click on Percent Limit");

				Utils.clickDropdownAndSendValue(
						By.xpath(getObj("Propval1", "percentValueDropDown", "PermLimitIncrease")),
						By.xpath(getObj("Propval1", "percentValue", "PermLimitIncrease")),
						ReadTestData(TCName, "percentlimit"));

				/*
				 * Utils.Sendkeys_DD_substringbased(By.xpath(getObj("Propval1", "percentValue",
				 * "PermLimitIncrease")), ReadTestData("ResetCardPIN", "percentlimit"));
				 */

			} else {
				Utils.sendKeys(By.xpath(getObj("Propval1", "Amount", "PermLimitIncrease")),
						ReadTestData(TCName, "Amount"));
			}

			Utils.sendKeys(By.xpath(getObj("Propval1", "UploadFile", "PermLimitIncrease")),
					"\\\\10.242.36.32\\BajProjects\\AfterGUI\\UploadFile.pdf", "upload salary slip");
			Utils.pressEscapeKey(3);
			if (TCButton.equalsIgnoreCase("True")) {
				if (CheckBox.equalsIgnoreCase("True")) {
					// Click on the terms and Conditions CheckBox Directly//
					Utils.click(By.xpath(getObj("Propval1", "CheckBoxTC", "PermLimitIncrease")),
							"on Terms and Conditons Button directly");
				} else if (CheckBox.equalsIgnoreCase("False")) {
					// Click on the link of Terms and Conditions//
					Utils.click(By.xpath(getObj("Propval1", "TnCpoup", "PermLimitIncrease")),
							"which is a link of Terms and Conditions");
					// Click on I Accept Radio of the pop up//
					Utils.click(By.xpath(getObj("Propval1", "TnCAgree", "PermLimitIncrease")),
							"which is I Accept RadioButton");

				}

			} else if (TCButton.equalsIgnoreCase("False")) {
				// Click on Proceed Button//
				Utils.click(By.xpath(getObj("Propval1", "Proceed", "PermLimitIncrease")), "Proceed Button");
				try {

					Assert.assertEquals(
							Utils.assertDisplayed(By.xpath(getObj("Propval1", "Confirm", "ApplyCreditCard")), "Confirm"),
							false);
					Log.pass(
							"Successfully validated that user is unable to complete transaction without selecting terms and conditions.");
					Utils.logPassImage(TCName);
					return true;
				} catch (AssertionError | Exception e) {
					Log.fail("Proceeded Further without clicking on Terms and Condtions");
					runResult = false;
					throw e;
				}

			}

			if (Integer.parseInt(Proceed) == 1) {

				Utils.click(By.xpath(getObj("Propval1", "Proceed", "PermLimitIncrease")), "Proceed ......");

			} else {

				Utils.click(By.xpath(getObj("Propval1", "Cancel", "PermLimitIncrease")), "Cancel Button......");

				return runResult;

			}

			if (Integer.parseInt(Confirm) == 1) {

				Utils.click(By.xpath(getObj("Propval1", "Confirm", "PermLimitIncrease")), "Confirm");

				Utils.wait(6);

			} else if (Integer.parseInt(Confirm) == 2) {

				Utils.click(By.xpath(getObj("Propval1", "modify", "PermLimitIncrease")), "Modify");
				Utils.wait(6);

				Utils.click(By.xpath(getObj("Propval1", "CheckBoxTC", "PermLimitIncrease")),
						"on Terms and Conditons Button directly");

				Utils.wait(6);
				Utils.click(By.xpath(getObj("Propval1", "Proceed", "PermLimitIncrease")), "Proceed");

				Utils.click(By.xpath(getObj("Propval1", "Confirm", "PermLimitIncrease")), "Confirm");

			} else {
				Utils.click(By.xpath(getObj("Propval1", "Cancel", "PermLimitIncrease")), "Cancel");
				Utils.wait(6);
				Utils.click(By.xpath(getObj("Propval1", "CancelYes", "PermLimitIncrease")), "Cancel Yes");

				return runResult;
			}

			if (Integer.parseInt(OTPCancelConfirm) == 1) {

				Utils.enterOTPAndProceed("0123");

			} else {
				Utils.click(By.xpath(getObj("Propval1", "Cancel", "ApplyCreditCard")), "Cancel OTP");
				Utils.wait(6);
				Utils.click(By.xpath(getObj("Propval1", "CancelYes", "ApplyCreditCard")), "Yes OTP Cancel");

				return runResult;

			}

			try {
				Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "SuccessMessage", "Card")),
						"Success Message"));
				Log.pass("Permanent limit increase completed successfully.");
				Log.pass("Displayed message is :"+Utils.getText(By.xpath(getObj("Propval1", "SuccessMessage", "Card"))));
				Utils.logPassImage("Permanent Limit inscrease-Pass");

			} catch (AssertionError | Exception e) {

				Log.fail("Permanent limit increase failed...Message:"
						+ Utils.getText(By.xpath(getObj("Propval1", "failMessage", "Card"))));
				Utils.logFailImage("Permanent Limit inscrease-Fail");
				throw e;
			}

			if (AfterTxfrAdditionalOptions.equalsIgnoreCase("TRUE")) {
				Log.pass("Starting additional actions after transfer. e.g send email, print and save as favourite.");
				eCorpCommonFunctions.sendEmailDownloadExcelnPrintFunc(ScenarioCount);
				Log.pass(
						"Additional Actions  like send email, print and download pdf/excel etc have  passed successfully.");
				Utils.logPassImage("Additional Actions");
			}

			if (Integer.parseInt(NewTxn) == 1) {
				Utils.scrollDownVertically();
				Utils.click(By.xpath(getObj("Propval1", "NewTransactionBtn", "PermLimitIncrease")), "New Transaction");
				Assert.assertTrue(
						Utils.assertDisplayed(By.xpath(getObj("Propval1", "proceed", "PermLimitIncrease")), "proceed"));
				Log.pass("New Transaction is landed successfully");
				Utils.logPassImage(TCName);

			} else {
				Utils.click(By.xpath(getObj("Propval1", "Home", "PermLimitIncrease")), "Home Button.");
				Assert.assertTrue(Utils.assertDisplayed(
						By.xpath(getObj("Propval1", "HomepageSuccess", "PermLimitIncrease")), "HomepageSuccess"));

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

			Utils.click(By.xpath(getObj("Propval1", "sendEmailIcon", "PermLimitIncrease")), "Send Email Icon");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailTo", "PermLimitIncrease")),
					Input.ReadTestData("MarketInfo", "toEmail"), "to email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailCC", "PermLimitIncrease")),
					Input.ReadTestData("MarketInfo", "ccEmail"), "to CC email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "bccEmail", "PermLimitIncrease")),
					Input.ReadTestData("MarketInfo", "bccEmail"), "to BCC  email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "emailSubject", "PermLimitIncrease")),
					Input.ReadTestData("MarketInfo", "emailSubject"), "email Subject ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEMailMsgBox", "PermLimitIncrease")),
					Input.ReadTestData("MarketInfo", "sendEMailMsgBox"), "Mail Body ");

			Utils.click(By.xpath(getObj("Propval1", "cancelemailBtnEle", "PermLimitIncrease")), "Cancel Email Button");
			Utils.wait(5);
			Utils.click(By.xpath(getObj("Propval1", "sendEmailIcon", "PermLimitIncrease")), "Send Email Icon");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailTo", "PermLimitIncrease")),
					Input.ReadTestData("MarketInfo", "toEmail"), "to email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailCC", "PermLimitIncrease")),
					Input.ReadTestData("MarketInfo", "ccEmail"), "to CC email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "bccEmail", "PermLimitIncrease")),
					Input.ReadTestData("MarketInfo", "bccEmail"), "to BCC  email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "emailSubject", "PermLimitIncrease")),
					Input.ReadTestData("MarketInfo", "emailSubject"), "email Subject ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEMailMsgBox", "PermLimitIncrease")),
					Input.ReadTestData("MarketInfo", "sendEMailMsgBox"), "Mail Body ");
			Utils.wait(5);
			Utils.click(By.xpath(getObj("Propval1", "sendBtnEle", "PermLimitIncrease")), "Send Email Button");
			Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "WaitingElements", "PermLimitIncrease")));
			Utils.pressEnter();
			Utils.wait(2);
			Utils.pressEscapeKey(3);

			Utils.pressEscapeKey(3);
			driver.navigate().refresh();
			// Download report in pdf format.
			Utils.click(By.xpath(getObj("Propval1", "pdfDownloadIcon", "PermLimitIncrease")), "pdf download");
			Utils.wait(3);
			Utils.enterOTPAndProceed();
			Utils.moveToElement(By.id("logo"));
			driver.navigate().refresh();
			// Download report in excel format.

			// Print report.
			Utils.wait(6);
			driver.navigate().refresh();
			Utils.click(By.xpath(getObj("Propval1", "printBtnIcon", "PermLimitIncrease")), "Print Button");
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
