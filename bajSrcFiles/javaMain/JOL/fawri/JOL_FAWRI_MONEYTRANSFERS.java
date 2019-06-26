package javaMain.JOL.fawri;

import static Utilities.Input.ReadTestData;
import static Utilities.ReadData.ReadDataSQL;
import static Utilities.ReadData.getObj;
import static Utilities.ReadData.readConfigXml;
import static javaMain.common_Functions.AppData.AdditionalActions;
import static javaMain.common_Functions.AppData.CancelYes;
import static javaMain.common_Functions.AppData.CheckBox;
import static javaMain.common_Functions.AppData.Confirm;
import static javaMain.common_Functions.AppData.Currency;
import static javaMain.common_Functions.AppData.OTPCancelConfirm;
import static javaMain.common_Functions.AppData.OTPProceed;
import static javaMain.common_Functions.AppData.Proceed;
import static javaMain.common_Functions.AppData.Purpose;
import static javaMain.common_Functions.AppData.TCButton;
import static javaMain.common_Functions.AppData.TransferVia;

import org.openqa.selenium.By;
import org.testng.Assert;

import Utilities.Input;
import Utilities.Log;
import Utilities.ReadData;
import Utilities.TestBase;
import Utilities.Utils;
import javaMain.common_Functions.AppData;


public class JOL_FAWRI_MONEYTRANSFERS extends TestBase {

	public static Boolean JOL_FAWRI_MONEYTRANSFERS_functions(String TCName, int ScenarioCount, Object[] tCsDataset) throws Exception

	{

		try {

			if (isMasterClassRun) {
				// if (true) {

				Log.pass("Data set for this scenario is " + System.lineSeparator() + ReadData.getJsonData(TCName, ScenarioCount, "DataSet"));
				TransferVia = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "TransferVia"));
				Currency = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Currency"));
				Proceed = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Proceed"));
				Confirm = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Confirm"));
				OTPProceed = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "OTPProceed"));
				CancelYes = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "CancelYes"));
				OTPCancelConfirm = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "OTPCancelConfirm"));
				TCButton = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "TCButton"));
				CheckBox = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "CheckBox"));
				Purpose = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Purpose"));
				AdditionalActions = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "AdditionalActions"));
			} else {

				Log.pass("Data set for this scenario is " + System.lineSeparator() + dataset[scenarioCount - 1]);

				TransferVia = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("TransferVia"));
				Currency = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Currency"));
				Proceed = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Proceed"));
				Confirm = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Confirm"));
				OTPProceed = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("OTPProceed"));
				CancelYes = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("CancelYes"));
				OTPCancelConfirm = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("OTPCancelConfirm"));
				TCButton = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("TCButton"));
				CheckBox = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("CheckBox"));
				Purpose = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Purpose"));
				AdditionalActions = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("AdditionalActions"));
			}

			Utils.scrollUpVertically();
			Utils.click(By.xpath(getObj("Propval1", "FawriLnk", "FawriMoneyTransfers")), "Fawri Link");
			// Utils.click(By.xpath(getObj("Propval1", "MoneyTransfers_Menu_Y",
			// "FawriMoneyTransfers")),"Money Transfers Link on the left
			// panel");

			// Select From Account//
			Utils.Sendkeys_DD_substringbased(By.xpath(getObj("Propval1", "FromAccount", "FawriMoneyTransfers")), Input.ReadTestData(TCName, "FromAccount"), "From Account dropdown ");

			if (Integer.parseInt(TransferVia) == 1)// Transfer Via as RIA//
			{
				// Select Transfer Via as RIA//
				Utils.Sendkeys_DD_substringbased(By.xpath(getObj("Propval1", "TransferVia", "FawriMoneyTransfers")), Input.ReadTestData(TCName, "TransferVia_Ria"), "Transfer Via drop down");

				// Select RIA Beneficiary//
				Utils.Sendkeys_DD_substringbased(By.xpath(getObj("Propval1", "selectBeneficiary", "FawriMoneyTransfers")), Input.ReadTestData(TCName, "Beneficiary_RIA"), "Beneficiary drop down ");
				System.out.println(Input.ReadTestData(TCName, "Beneficiary_RIA"));
			} else if (Integer.parseInt(TransferVia) == 2)// Transfer Via as
			// MoneyGram//
			{
				// Select Transfer Via as MoneyGram//
				Utils.Sendkeys_DD_substringbased(By.xpath(getObj("Propval1", "TransferVia", "FawriMoneyTransfers")), Input.ReadTestData(TCName, "TransferVia_MoneyGram"), "Transfer Via drop down");

				// Select MoneyGram Beneficiary//
				Utils.Sendkeys_DD_substringbased(By.xpath(getObj("Propval1", "selectBeneficiary", "FawriMoneyTransfers")), Input.ReadTestData(TCName, "Beneficiary_MoneyGram"), "Beneficiary drop down");

			}

			else if (Integer.parseInt(TransferVia) == 3)// Direct Bank Deposit
			// as Transfer Via//
			{
				// Select Direct Bank Deposit as Transfer Via//
				Utils.Sendkeys_DD_substringbased(By.xpath(getObj("Propval1", "TransferVia", "FawriMoneyTransfers")), Input.ReadTestData(TCName, "TransferVia_DirectBankDeposit"), "Transfer Via drop down");

				// Select Direct Bank Deposit Beneficiary//
				Utils.Sendkeys_DD_substringbased(By.xpath(getObj("Propval1", "selectBeneficiary", "FawriMoneyTransfers")), Input.ReadTestData(TCName, "Beneficiary_DirectBankDeposit"), "Beneficiary drop down ");

			}

			if (Integer.parseInt(Currency) == 2) {
				// Select Beneficiary Currency as Currency//
				Utils.click(By.xpath(getObj("Propval1", "OtherCurrencyRadioButton", "FawriMoneyTransfers")), "Currency other than SAR");

			}

			// Enter Amount//
			Utils.sendKeys(By.xpath(getObj("Propval1", "AmountTxt", "FawriMoneyTransfers")), Input.ReadTestData(TCName, "Amount"), "Amount text box ");

			// Press Tab to calculate the Equivalent Amount//
			Utils.pressTab();
			Utils.wait(3);
			Utils.clickSafely(By.xpath(getObj("Propval1", "AcceptButton", "FawriMoneyTransfers")), "Accept button");

			// Select Category//
			Utils.Sendkeys_DD_substringbased(By.xpath(getObj("Propval1", "Category", "FawriMoneyTransfers")), Input.ReadTestData(TCName, "Category"), "Category drop down ");

			// Select Purpose//
			Utils.Sendkeys_DD_substringbased(By.xpath(getObj("Propval1", "Purpose", "FawriMoneyTransfers")), Purpose, "Purpose dropdown");

			// Select Payment Details//
			Utils.sendKeys(By.xpath(getObj("Propval1", "PaymentDetails", "FawriMoneyTransfers")), Input.ReadTestData(TCName, "Payment Details"), "Payment Details as " + Input.ReadTestData(TCName, "Payment Details"));

			// Terms and Conditions Button
			if (TCButton.equalsIgnoreCase("True")) {
				if (CheckBox.equalsIgnoreCase("True")) {
					// Click on the terms and Conditions CheckBox Directly//
					Utils.click(By.xpath(getObj("Propval1", "CheckBoxTC", "FawriMoneyTransfers")), "on Terms and Conditons Button directly");
				} else if (CheckBox.equalsIgnoreCase("False")) {
					// Click on the link of Terms and Conditions//
					Utils.click(By.xpath(getObj("Propval1", "TnCpoup", "FawriMoneyTransfers")), "which is a link of Terms and Conditions");
					// Click on I Accept Radio of the pop up//
					Utils.click(By.xpath(getObj("Propval1", "TnCAgree", "FawriMoneyTransfers")), "which is I Accept RadioButton");

				}

			} else if (TCButton.equalsIgnoreCase("False")) {
				// Click on Proceed Button//
				Utils.click(By.xpath(getObj("Propval1", "ProceedBtn", "FawriMoneyTransfers")), "Proceed Button");
				try {
					// This is to validate if the user moves to the next page
					// without selecting Terms and Condition CheckBox//
					Assert.assertEquals(Utils.assertDisplayed(By.xpath(getObj("Propval1", "TransferDetails", "FawriMoneyTransfers")), "Confirm"), false);
					Log.pass("Successfully validated that user is unable to complete transaction without selecting terms and conditions.");
					return runResult;
				} catch (AssertionError | Exception e) {
					Log.fail("Proceeded Further without clicking on Terms and Condtions");
					runResult = false;
					throw e;
				}

			}

			if (Integer.parseInt(Proceed) == 1) {

				// Click on Proceed Button//
				Utils.click(By.xpath(getObj("Propval1", "ProceedBtn", "FawriMoneyTransfers")), "Proceed Button");
				Utils.waitForInVisibilityOfEle(By.xpath("//*[@id='overlayInfo']"));
				Utils.wait(3);
				// Click on the popup
				Utils.clickSafely(By.xpath(getObj("Propval1", "AcceptButton", "FawriMoneyTransfers")), "Accept button");
				Utils.wait(3);
				try {
					Utils.waitForInVisibilityOfEle(By.xpath("//*[@id='overlayInfo']"));
					// Click on the terms and Conditions CheckBox
					Utils.clickSafely(By.xpath(getObj("Propval1", "CheckBoxTC", "FawriMoneyTransfers")), "on Terms and Conditons Button directly");

				} catch (Exception e) {
					// Nothing
				}
				Utils.wait(3);
				// Click on Proceed Button//
				Utils.clickSafely(By.xpath(getObj("Propval1", "ProceedBtn", "FawriMoneyTransfers")), "Proceed Button");

			} else if (Integer.parseInt(Proceed) == 2) {
				// Click on Cancel Button//
				Utils.click(By.xpath(getObj("Propval1", "CancelTransBtn", "FawriMoneyTransfers")), "Cancel Button");
				Log.pass("Transaction Successfully cancelled");
				return runResult;
			}

			if (Integer.parseInt(Confirm) == 1) {

				Utils.wait(3);
				// Click on Confirm Button//
				Utils.click(By.xpath(getObj("Propval1", "ConfirmBtn", "FawriMoneyTransfers")), "Confirm Button");

			} else if (Integer.parseInt(Confirm) == 2) {
				// Click on Modify Button//
				Utils.click(By.xpath(getObj("Propval1", "ModifyBtn", "FawriMoneyTransfers")), "Modify Button");

				// Enter Modified Amount//
				Utils.sendKeys(By.xpath(getObj("Propval1", "AmountTxt", "FawriMoneyTransfers")), Input.ReadTestData(TCName, "ModifiedAmount"), "Modified Amount as " + Input.ReadTestData(TCName, "ModifiedAmount"));

				// Click on the terms and Conditions CheckBox
				Utils.click(By.xpath(getObj("Propval1", "CheckBoxTC", "FawriMoneyTransfers")), "on Terms and Conditons Button directly");
				Utils.wait(5);
				// Click on Proceed Button//
				Utils.click(By.xpath(getObj("Propval1", "ProceedBtn", "FawriMoneyTransfers")), "Proceed Button");
				Utils.waitForInVisibilityOfEle(By.xpath("//*[@id='overlayInfo']"));
				// Click on Confirm Button//
				Utils.click(By.xpath(getObj("Propval1", "ConfirmBtn", "FawriMoneyTransfers")), "Confirm Button");

			}

			else if (Integer.parseInt(Confirm) == 3) {

				// Click on Cancel Button//
				Utils.click(By.xpath(getObj("Propval1", "CancelTransBtn", "FawriMoneyTransfers")), "Cancel Button");
				Log.pass("Transaction Successfully cancelled");

				// Click on Yes Button to Cancel the Transaction//
				Utils.clickSafely(By.xpath(getObj("Propval1", "CancelTransBtn_Confirm", "FawriMoneyTransfers")), "Yes Button to Cancel the transaction");

				return runResult;

			}

			// Enter OTP//
			Utils.sendKeys(By.xpath(getObj("Propval1", "OTP", "FawriMoneyTransfers")), readConfigXml("OTP"), "OTP");

			// Click on Proceed Button on OTP Page//
			Utils.click(By.xpath(getObj("Propval1", "OTPProceedBtn", "FawriMoneyTransfers")), "Proceed Button on OTP Page");

			try {
				Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "SuccessMessage", "FawriMoneyTransfers")), " Success Message"));
				Log.pass(" Your request for transfer through FAWRI Money Transfer Service has been completed successfully. displayed message is" + Utils.getText(By.xpath(getObj("Propval1", "SuccessMessage", "FawriMoneyTransfers"))));
				Utils.logPassImage("Your request for transfer through FAWRI has been completed - Pass");

			} catch (AssertionError | Exception e) {

				Log.fail("Your request for transfer through FAWRI Money Transfer Service has failed. displayed message is" + Utils.getText(By.xpath(getObj("Propval1", "ErrorMsg", "FawriMoneyTransfers"))));
				Utils.logFailImage("Your request for transfer through FAWRI not completed - Fail");
				throw e;

			}
			try {

				if (AdditionalActions.equalsIgnoreCase("true")) {

					Log.pass("Successfully started other actions like send email, download pdf, excel and print search result etc.");
					sendEmailDownloadExcelnPrintFunc(ScenarioCount, Proceed);

				}

			} catch (NullPointerException e) {
				// TODO: handle exception
			}
		}

		catch (AssertionError | Exception e) {
			runResult = false;
			throw e;
		}

		return runResult;
	}

	public static boolean sendEmailDownloadExcelnPrintFunc(int ScenarioCount, String... proceedEmail) throws Exception {

		String sendEmail = "1";
		try {
			sendEmail = proceedEmail[0];
		} catch (Exception e) {
			sendEmail = "1";
		}

		try {

			Utils.wait(3);
			// Download report in pdf format.
			Utils.click(By.xpath(getObj("Propval1", "pdfDownloadIcon", "AlZCapital")), "pdf download");
			Utils.wait(3);
			Utils.enterOTPAndProceed();
			Utils.wait(3);
			Utils.moveToElement(By.id("logo"));
			// Print report.
			Utils.click(By.xpath(getObj("Propval1", "printBtnIcon", "AlZCapital")), "Print Button");
			// close all other tabs except the main one. i.e 1st page.
			Utils.closeOtherTabs();

			// Start sending email , downloading pdf and printing etc.
			Utils.wait(5);
			Log.info("Starting send email functionality");

			Utils.click(By.xpath(getObj("Propval1", "sendEmailIcon", "AlZCapital")), "Send Email Icon");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailTo", "AlZCapital")), ReadTestData(AppData.accountSet, "toEmail"), "to email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailCC", "AlZCapital")), ReadTestData(AppData.accountSet, "ccEmail"), "to CC email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "bccEmail", "AlZCapital")), ReadTestData(AppData.accountSet, "bccEmail"), "to BCC  email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "emailSubject", "AlZCapital")), ReadTestData(AppData.accountSet, "emailSubject"), "email Subject ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEMailMsgBox", "AlZCapital")), ReadTestData(AppData.accountSet, "sendEMailMsgBox"), "Mail Body ");

			Utils.click(By.xpath(getObj("Propval1", "sendBtnEle", "AlZCapital")), "Send Email Button");

			Utils.waitForInVisibilityOfEle(By.xpath("//*[@id='overlayInfo']"));
			Utils.pressEnter();
			Utils.wait(3);
			Utils.pressEscapeKey(3);
			Utils.wait(3);
			Log.pass("Successfully completed other actions like send email, download pdf, excel and print search result etc.");
		}

		catch (Exception e) {
			Log.fail("Unable to complete other actions like send email, download pdf, excel and print search result etc error..");
			Utils.logFailImage(TCName + "  Scenario count -" + ScenarioCount + " - sendEmailDownloadExcelnPrintFunc-error");
			runResult = false;
			throw e;

		}

		return runResult;
	}

}