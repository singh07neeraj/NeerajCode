package javaMain.smart.fawri;

import static Utilities.ReadData.ReadDataSQL;
import static Utilities.ReadData.getObj;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.testng.Assert;

import Utilities.Input;
import Utilities.Log;
import Utilities.ReadData;
import Utilities.TestBase;
import Utilities.Utils;
import javaMain.common_Functions.OpenMenuesSmart;

public class SMART_Fawri_MoneyTransfer extends TestBase {

	public static String AccountNumber, TransferVia, BeneficiaryType, AMOUNT, Category, Purpose, Purpose_Modify, PaymentDetails, Proceed, Confirm, OTPProceed, CancelYes, BeneficiaryActivationMode, TestType;

	public static boolean fawriMoneyTransfer(String TCName, int ScenarioCount, Object[] tCsDataset) throws Exception {

		try {

			if (true) {

				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + ReadData.getJsonData(TCName, ScenarioCount, "DataSet") + "</mark>");
				AccountNumber = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "AccountNumber"));
				TransferVia = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "TransferVia"));
				BeneficiaryType = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "BeneficiaryType"));
				AMOUNT = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "AMOUNT"));

				Category = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Category"));
				Purpose = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Purpose"));
				Purpose_Modify = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Purpose_Modify"));
				PaymentDetails = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "PaymentDetails"));
				Proceed = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Proceed"));

				Confirm = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Confirm"));
				OTPProceed = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "OTPProceed"));
				CancelYes = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "CancelYes"));
				TestType = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "TestType"));

			} else {

				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + ReadData.getJsonData(TCName, ScenarioCount, "DataSet") + "</mark>");
				AccountNumber = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("AccountNumber"));
				TransferVia = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("TransferVia"));
				BeneficiaryType = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("BeneficiaryType"));
				AMOUNT = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("AMOUNT"));
				Category = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Category"));
				Purpose = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Purpose"));
				Purpose_Modify = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Purpose_Modify"));
				PaymentDetails = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("PaymentDetails"));
				Proceed = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Proceed"));

				Confirm = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Confirm"));
				OTPProceed = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("OTPProceed"));
				CancelYes = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("CancelYes"));
				TestType = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("TestType"));

			}
			Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "LoadingSpinner", "LogInLandingPage")));
			OpenMenuesSmart.openFawriMenu("MoneyTransfer");
			Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "LoadingSpinner", "LogInLandingPage")));

			try {
				Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "MoneyTransfer_title", "SMART_FAWRI_MONEY_TRANSFER")), "Money Transfer home page"));

				Log.pass(" Money Transfer home page appearing successfully. message displayed is " + Utils.getText(By.xpath(getObj("Propval1", "MoneyTransfer_title", "SMART_FAWRI_MONEY_TRANSFER"))));

				Utils.logPassImage("Money Transfer home page appearing-pass");

			} catch (AssertionError | Exception e) {

				Log.fail("Money Transfer home page not appearing");
				Utils.logFailImage("Money Transfer home page-fail");

				throw e;

			}
			Utils.click(By.xpath(getObj("Propval1", "FromAcct_lnk", "SMART_FAWRI_MONEY_TRANSFER")), "From Account link");
			AccountNumber = "//p[contains(text(),'" + AccountNumber + "')]";

			Utils.click_Smart(By.xpath(AccountNumber), "Click on Account Number");

			TransferVia = "//p[contains(text(),'" + TransferVia + "')]";

			Utils.click_Smart(By.xpath(TransferVia), "Click on TransferVia type");
			Utils.wait(5);
			BeneficiaryType = "(//p[contains(text(),'" + BeneficiaryType + "')])[1]";

			Utils.click_Smart(By.xpath(BeneficiaryType), "Click on Beneficiary Type");
			Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "LoadingSpinner", "LogInLandingPage")));
			Utils.wait(10);
			// Enter Amount//
			// Utils.sendKeys_Smart(By.xpath(getObj("Propval1", "Amount_txt",
			// "SMART_FAWRI_MONEY_TRANSFER")),AMOUNT,"AMOUNT text box");
			driver.findElement(By.xpath("//*[contains(@id,'amountListener_amount_ns')]")).sendKeys(AMOUNT);
			// Click on Currency Radio Button//
			Utils.click_Smart(By.xpath(getObj("Propval1", "CurrencySAR_rdb", "SMART_FAWRI_MONEY_TRANSFER")), "Currency Radio Button");
			Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "LoadingSpinner", "LogInLandingPage")));
			Utils.wait(10);
			Utils.scrollIntoView(By.xpath(getObj("Propval1", "PaymentDetails_txt", "SMART_FAWRI_MONEY_TRANSFER")));

			// Select Category
			Utils.sendValDropdown_Smart(By.xpath(getObj("Propval1", "Category_DD", "SMART_FAWRI_MONEY_TRANSFER")), Category, "Category DropDOwn");

			// Select purpose
			Utils.sendValDropdown_Smart(By.xpath(getObj("Propval1", "Purpose_DD", "SMART_FAWRI_MONEY_TRANSFER")), Purpose, "Purpose DropDOwn");
			String Payment_updated = RandomStringUtils.randomAlphanumeric(5).toUpperCase();
			// Payment details//
			Utils.sendKeys_Smart(By.xpath(getObj("Propval1", "PaymentDetails_txt", "SMART_FAWRI_MONEY_TRANSFER")), PaymentDetails + Payment_updated, "PaymentDetails text box");
			Utils.click(By.xpath(getObj("Propval1", "AccepTerms_btn", "SMART_FAWRI_MONEY_TRANSFER")), "Accept terms btn");

			if (TestType.equalsIgnoreCase("N")) {

				try {

					// Select Category
					Log.pass("Entering invalid category name  : '!@#!$!$!$' ");
					Utils.sendValDropdown_Smart(By.xpath(getObj("Propval1", "Category_DD", "SMART_FAWRI_MONEY_TRANSFER")), "!@#!$!$!$", "Category DropDOwn");
					// Click on Proceed Button//
					Utils.click(By.xpath(getObj("Propval1", "ProceedBtn", "SMART_FAWRI_MONEY_TRANSFER")), "Proceed Button");
					Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "LoadingSpinner", "LogInLandingPage")));

					Assert.assertTrue(Utils.assertDisplayed_Smart(By.xpath(getObj("Propval1", "Data_Alert", "SMART_FAWRI_MONEY_TRANSFER")), "Alert checking on Execution Page"));
					Utils.scrollIntoView(By.xpath(getObj("Propval1", "FromAcct_lnk", "SMART_FAWRI_MONEY_TRANSFER")));
					Log.pass("User is unable to proceed with invalid data as expected");
					Utils.logPassImage("User is unable to proceed with invalid data-pass");
					return runResult;

				} catch (AssertionError | Exception e) {

					Log.fail("User is able to proceed with invalid data");
					Utils.logFailImage("User is unable to proceed with invalid data-fail");

					throw e;

				}

			}

			if (Proceed.equalsIgnoreCase("true")) {

				// Click on Proceed Button//
				Utils.click(By.xpath(getObj("Propval1", "ProceedBtn", "SMART_FAWRI_MONEY_TRANSFER")), "Proceed Button");
				Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "LoadingSpinner", "LogInLandingPage")));
				
			
				try {
					Assert.assertTrue(Utils.assertDisplayed_Smart(By.xpath(getObj("Propval1", "Alert_AfterProceed", "SMART_FAWRI_MONEY_TRANSFER")), "Alert AfterProceed on Execution Page"));
					Utils.logPassImage("Alert After proceed button");
					Utils.clickSafely(By.xpath(getObj("Propval1", "Accept_Alert_btn", "SMART_FAWRI_MONEY_TRANSFER")), "Alert button on Proceed Page");
					Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "LoadingSpinner", "LogInLandingPage")));
					Utils.click_Smart(By.xpath(getObj("Propval1", "Details_lnk", "SMART_FAWRI_MONEY_TRANSFER")), "Details link");
					Utils.scrollIntoView(By.xpath(getObj("Propval1", "PaymentDetails_txt", "SMART_FAWRI_MONEY_TRANSFER")));
					// Select purpose
					Utils.sendValDropdown_Smart(By.xpath(getObj("Propval1", "Purpose_DD", "SMART_FAWRI_MONEY_TRANSFER")), Purpose_Modify, "Purpose DropDOwn");
					Utils.click(By.xpath(getObj("Propval1", "AccepTerms_btn", "SMART_FAWRI_MONEY_TRANSFER")), "Accept terms btn");
					// Click on Proceed Button//
					Utils.click(By.xpath(getObj("Propval1", "ProceedBtn", "SMART_FAWRI_MONEY_TRANSFER")), "Proceed Button");
					Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "LoadingSpinner", "LogInLandingPage")));
					
					

				} catch (AssertionError | Exception e) {

					Log.pass("Alert message not displayed...continue to next page");
									

				}
				


			} else {
				// Click on Cancel Button//
				Utils.click(By.xpath(getObj("Propval1", "CancelBtn", "SMART_FAWRI_MONEY_TRANSFER")), "Cancel Button on Proceed Page");
				Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "LoadingSpinner", "LogInLandingPage")));
				try {
					Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "Homepage_OnCancel", "SMART_FAWRI_MONEY_TRANSFER")), "Home page"));
					Log.pass("Successfully cancelled the Add new fawri beneficiary transaction and navigated to home page.");
					Utils.logPassImage("Successfully Cancelled Add new fawri beneficiary trasaction");
					return true;

				} catch (AssertionError | Exception e) {

					Log.fail("Unable to cancel transaction..error..");
					Utils.logFailImage("Unable to cancel transaction..error.");
					throw e;

				}

			}

			if (Confirm.equalsIgnoreCase("true")) {
				// Click on Confirm Button//
				Utils.click(By.xpath(getObj("Propval1", "ConfirmBtn", "SMART_FAWRI_MONEY_TRANSFER")), "Confirm Button");
				Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "LoadingSpinner", "LogInLandingPage")));
			}

			else {
				// Click on Cancel Button//
				Utils.click(By.xpath(getObj("Propval1", "CancelBtn", "SMART_FAWRI_MONEY_TRANSFER")), "Cancel Button on ConfirmationPage");

				if (CancelYes.equalsIgnoreCase("true")) {

					// Click on Yes Button to Cancel the Transaction//
					Utils.click(By.xpath(getObj("Propval1", "Cancel_Yes_Btn", "SMART_FAWRI_MONEY_TRANSFER")), "Yes Button to cancel Transaction");

					return runResult;

				} else {

					// Click on No Button //
					Utils.click(By.xpath(getObj("Propval1", "Cancel_No_Btn", "SMART_FAWRI_MONEY_TRANSFER")), "No Button to Continue");

					// Click on Confirm Button//
					Utils.click(By.xpath(getObj("Propval1", "ConfirmBtn", "SMART_FAWRI_MONEY_TRANSFER")), "Confirm Button");
					Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "LoadingSpinner", "LogInLandingPage")));

				}

			}

			// Enter OTP//
			Utils.sendKeys_Smart(By.xpath(getObj("Propval1", "OTP", "SMART_FAWRI_MONEY_TRANSFER")), ReadData.readConfigXml("OTP"), "OTP Entered");

			if (OTPProceed.equalsIgnoreCase("true")) {

				// Click on OTP Proceed//
				Utils.click(By.xpath(getObj("Propval1", "OTPProceedBtn", "SMART_FAWRI_MONEY_TRANSFER")), "Proceed Button after entering OTP");
				Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "LoadingSpinner", "LogInLandingPage")));
			}

			else {

				// Click on Cancel on OTP Page//
				Utils.click(By.xpath(getObj("Propval1", "CancelBtn", "SMART_FAWRI_MONEY_TRANSFER")), "Cancel Button to cancel the transaction");
				return runResult;

			}
			Utils.wait(10);
			try {
				Assert.assertTrue(Utils.assertDisplayed_Smart(By.xpath(getObj("Propval1", "MoneyTransfer_SuccessMsg", "SMART_FAWRI_MONEY_TRANSFER")), "Money transfer success message on results page"));
				Utils.scrollIntoView(By.xpath(getObj("Propval1", "Results_Page", "SMART_FAWRI_MONEY_TRANSFER")));
				Log.pass(" FAWRI Money Transfer Service has been completed successfully. Message displayed is : " + Utils.getText_Smart(By.xpath(getObj("Propval1", "MoneyTransfer_SuccessMsg", "SMART_FAWRI_MONEY_TRANSFER"))));
				Utils.logPassImage("  FAWRI Money Transfer Service has been completed successfully-pass");
				// return true;

			} catch (AssertionError | Exception e) {

				Log.fail("FAWRI Money Transfer Service has not been completed successfully. Should have failed.");
				Utils.logFailImage(" FAWRI Money Transfer Service has not been completed-fail");
				throw e;

			}

		} catch (AssertionError | Exception e) {
			runResult = false;
			throw e;
		}
		return runResult;
	}

}
