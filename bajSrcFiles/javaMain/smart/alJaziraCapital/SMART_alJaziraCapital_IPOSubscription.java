package javaMain.smart.alJaziraCapital;

import static Utilities.ReadData.ReadDataSQL;
import static Utilities.ReadData.getObj;
import static Utilities.ReadData.readConfigXml;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.testng.Assert;

import Utilities.Log;
import Utilities.ReadData;
import Utilities.TestBase;
import Utilities.Utils;
import javaMain.common_Functions.OpenMenuesSmart;

public class SMART_alJaziraCapital_IPOSubscription extends TestBase{

	public static String IPOType, NoOfShares, SubscribersType, 
	AccountNumber, TransferVia, BeneficiaryType, AMOUNT, Category, Purpose, Purpose_Modify, PaymentDetails, Proceed, Confirm, OTPProceed, CancelYes, BeneficiaryActivationMode, TestType;

	public static boolean alJaziraCapitalIPOSubscription(String TCName, int ScenarioCount, Object[] tCsDataset) throws Exception {

		try {

			if (true) {

				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + ReadData.getJsonData(TCName, ScenarioCount, "DataSet") + "</mark>");
				
				IPOType = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "IPOType"));
				AccountNumber = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "AccountNumber"));
				NoOfShares = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "NoOfShares"));
				SubscribersType = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "SubscribersType"));
				
				
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
				
				IPOType = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("IPOType"));
				AccountNumber = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("AccountNumber"));
				NoOfShares = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("NoOfShares"));
				SubscribersType = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("SubscribersType"));
				
				
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
			OpenMenuesSmart.openAljaziraCapitalMenuSmart("IPOSubscription");
			Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "LoadingSpinner", "LogInLandingPage")));

			try {
				Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "NewIPO_title", "SMART_ALJAZIRACAPITAL_IPO_SUBSCRIPTION")), "New IPO home page"));

				Log.pass(" New IPO home page appearing successfully. message displayed is " + Utils.getText(By.xpath(getObj("Propval1", "NewIPO_title", "SMART_ALJAZIRACAPITAL_IPO_SUBSCRIPTION"))));

				Utils.logPassImage("New IPO home page appearing-pass");

			} catch (AssertionError | Exception e) {

				Log.fail("New IPO home page not appearing");
				Utils.logFailImage("New IPO home page not appearing-fail");

				throw e;

			}
			
			IPOType = "//p[contains(text(),'" + IPOType + "')]";
			Utils.click_Smart(By.xpath(IPOType), "Click on IPO Type");
			
			AccountNumber = "//p[contains(text(),'" + AccountNumber + "')]";
			Utils.click_Smart(By.xpath(AccountNumber), "Click on Account Number");

			
			Utils.click_Smart(By.xpath(getObj("Propval1", "NumberOfShares_lnk", "SMART_ALJAZIRACAPITAL_IPO_SUBSCRIPTION")), "Number of shares link");
			Utils.click_Smart(By.xpath(getObj("Propval1", "NumberOfShares_lnk", "SMART_ALJAZIRACAPITAL_IPO_SUBSCRIPTION")), "Number of shares link");
			
			Utils.sendKeys_Smart(By.xpath(getObj("Propval1", "NumberOfShares_txt", "SMART_ALJAZIRACAPITAL_IPO_SUBSCRIPTION")), NoOfShares, "Number Of Shares text box");
			
			Utils.click_Smart(By.xpath(getObj("Propval1", "Subscribers_lnk", "SMART_ALJAZIRACAPITAL_IPO_SUBSCRIPTION")), "Subscribers link");
			//Utils.click_Smart(By.xpath(getObj("Propval1", "Subscribers_lnk", "SMART_ALJAZIRACAPITAL_IPO_SUBSCRIPTION")), "Subscribers link");
			
			SubscribersType = "//p[text()='" + SubscribersType + "']";
			Utils.click_Smart(By.xpath(SubscribersType), "Click on Subscribers Type");
			
			Utils.click(By.xpath(getObj("Propval1", "AccepTerms_btn", "SMART_ALJAZIRACAPITAL_IPO_SUBSCRIPTION")), "Accept terms btn");

		

			if (Proceed.equalsIgnoreCase("true")) {

				// Click on Proceed Button//
				Utils.click(By.xpath(getObj("Propval1", "ProceedBtn", "SMART_ALJAZIRACAPITAL_IPO_SUBSCRIPTION")), "Proceed Button");
				Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "LoadingSpinner", "LogInLandingPage")));
				
			
			} else {
				// Click on Cancel Button//
				Utils.click(By.xpath(getObj("Propval1", "CancelBtn", "SMART_ALJAZIRACAPITAL_IPO_SUBSCRIPTION")), "Cancel Button on Proceed Page");
				Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "LoadingSpinner", "LogInLandingPage")));
				try {
					Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "Homepage_OnCancel", "SMART_ALJAZIRACAPITAL_IPO_SUBSCRIPTION")), "Home page"));
					Log.pass("Successfully cancelled the new IPO subscription transaction and navigated to home page.");
					Utils.logPassImage("Successfully cancelled the new IPO subscription trasaction");
					return true;

				} catch (AssertionError | Exception e) {

					Log.fail("Unable to cancel transaction..error..");
					Utils.logFailImage("Unable to cancel transaction..error.");
					throw e;

				}

			}

			if (Confirm.equalsIgnoreCase("true")) {
				// Click on Confirm Button//
				Utils.click(By.xpath(getObj("Propval1", "ConfirmBtn", "SMART_ALJAZIRACAPITAL_IPO_SUBSCRIPTION")), "Confirm Button");
				Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "LoadingSpinner", "LogInLandingPage")));
			}

			else {
				// Click on Cancel Button//
				Utils.click(By.xpath(getObj("Propval1", "CancelBtn", "SMART_ALJAZIRACAPITAL_IPO_SUBSCRIPTION")), "Cancel Button on ConfirmationPage");

				if (CancelYes.equalsIgnoreCase("true")) {

					// Click on Yes Button to Cancel the Transaction//
					Utils.click(By.xpath(getObj("Propval1", "Cancel_Yes_Btn", "SMART_ALJAZIRACAPITAL_IPO_SUBSCRIPTION")), "Yes Button to cancel Transaction");
					Log.pass("Successfully cancelled the new IPO subscription transaction");
					return runResult;

				} else {

					// Click on No Button //
					Utils.click(By.xpath(getObj("Propval1", "Cancel_No_Btn", "SMART_ALJAZIRACAPITAL_IPO_SUBSCRIPTION")), "No Button to Continue");

					// Click on Confirm Button//
					Utils.click(By.xpath(getObj("Propval1", "ConfirmBtn", "SMART_ALJAZIRACAPITAL_IPO_SUBSCRIPTION")), "Confirm Button");
					Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "LoadingSpinner", "LogInLandingPage")));

				}

			}

			/*
			 * // Enter OTP// Utils.sendKeys_Smart(By.xpath(getObj("Propval1", "OTP",
			 * "SMART_ALJAZIRACAPITAL_IPO_SUBSCRIPTION")), readConfigXml("OTP"),
			 * "OTP Entered");
			 * 
			 * if (OTPProceed.equalsIgnoreCase("true")) {
			 * 
			 * // Click on OTP Proceed// Utils.click(By.xpath(getObj("Propval1",
			 * "OTPProceedBtn", "SMART_ALJAZIRACAPITAL_IPO_SUBSCRIPTION")),
			 * "Proceed Button after entering OTP");
			 * Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "LoadingSpinner",
			 * "LogInLandingPage"))); }
			 * 
			 * else {
			 * 
			 * // Click on Cancel on OTP Page// Utils.click(By.xpath(getObj("Propval1",
			 * "CancelBtn", "SMART_ALJAZIRACAPITAL_IPO_SUBSCRIPTION")),
			 * "Cancel Button to cancel the transaction"); return runResult;
			 * 
			 * }
			 */
			
			Utils.wait(10);
			try {
				Assert.assertTrue(Utils.assertDisplayed_Smart(By.xpath(getObj("Propval1", "IPORequest_SuccessMsg", "SMART_ALJAZIRACAPITAL_IPO_SUBSCRIPTION")), "IPO Request success message on results page"));
				Utils.scrollIntoView(By.xpath(getObj("Propval1", "Results_Page", "SMART_ALJAZIRACAPITAL_IPO_SUBSCRIPTION")));
				Log.pass(" Your New IPO request has been completed successfully. Message displayed is : " + Utils.getText_Smart(By.xpath(getObj("Propval1", "IPORequest_SuccessMsg", "SMART_ALJAZIRACAPITAL_IPO_SUBSCRIPTION"))));
				Utils.logPassImage("  Your New IPO request has been completed successfully-pass");
				// return true;

			} catch (AssertionError | Exception e) {

				Log.fail("Your New IPO request has failed!...Test case should be failed");
				Utils.logFailImage(" Your New IPO request has failed-fail");
				throw e;

			}

		} catch (AssertionError | Exception e) {
			runResult = false;
			throw e;
		}
		return runResult;
	}

}
