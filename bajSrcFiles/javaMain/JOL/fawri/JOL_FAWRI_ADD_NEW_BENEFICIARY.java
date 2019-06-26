package javaMain.JOL.fawri;

import static Utilities.Input.ReadTestData;
import static Utilities.ReadData.ReadDataSQL;
import static Utilities.ReadData.getObj;
import static Utilities.ReadData.readConfigXml;
import static javaMain.common_Functions.AppData.AdditionalActions;
import static javaMain.common_Functions.AppData.BeneficiaryActivationMode;
import static javaMain.common_Functions.AppData.CancelYes;
import static javaMain.common_Functions.AppData.ConfirmType;
import static javaMain.common_Functions.AppData.OTPProceed;
import static javaMain.common_Functions.AppData.Proceed;
import static javaMain.common_Functions.AppData.ProceedType;
import static javaMain.common_Functions.AppData.TransferVia;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.testng.Assert;

import Utilities.Input;
import Utilities.Log;
import Utilities.ReadData;
import Utilities.TestBase;
import Utilities.Utils;
import javaMain.common_Functions.AppData;

public class JOL_FAWRI_ADD_NEW_BENEFICIARY extends TestBase {

	public static boolean JOL_FAWRI_ADD_NEW_BENEFICIARY_Func(String TCName, int ScenarioCount, Object[] tCsDataset) throws Exception {

		//String TransferVia, ProceedType, ConfirmType, OTPProceed, CancelYes, BeneficiaryActivationMode;

		try {

			if (isMasterClassRun) {

				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + ReadData.getJsonData(TCName, ScenarioCount, "DataSet") + "</mark>");

				TransferVia = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "TransferVia"));
				ProceedType = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Procced"));
				ConfirmType = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Confirm"));
				OTPProceed = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "OTPProceed"));
				CancelYes = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "CancelYes"));
				BeneficiaryActivationMode = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "BeneficiaryActivationMode"));
				AdditionalActions = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "AdditionalActions"));

			} else {

				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + ReadData.getJsonData(TCName, ScenarioCount, "DataSet") + "</mark>");

				TransferVia = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("TransferVia"));
				ProceedType = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("ProceedType"));
				ConfirmType = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("ConfirmType"));
				OTPProceed = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("OTPProceed"));
				CancelYes = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("CancelYes"));
				BeneficiaryActivationMode = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("BeneficiaryActivationMode"));
				AdditionalActions = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("AdditionalActions"));

			}

			Utils.scrollUpVertically();
			// Utils.mouseHover(By.xpath(getObj("Propval1", "FawriLnk",
			// "AddNewFawriBeneficiary")));
			Utils.click(By.xpath(getObj("Propval1", "FawriLnk", "AddNewFawriBeneficiary")), "Fawri Link");
			Utils.click(By.xpath(getObj("Propval1", "FawriManagementLnk", "AddNewFawriBeneficiary")), "Fawri Management Link on the side Panel");
			Utils.click(By.xpath(getObj("Propval1", "AddNewFawriBeneficiary_Menu_Y", "AddNewFawriBeneficiary")), "Add New Beneficiary Link of Fawri");

			if (Integer.parseInt(TransferVia) == 1)

			{

				// Select RIA//
				Utils.Sendkeys_DD_substringbased(By.xpath(getObj("Propval1", "TransferVia", "AddNewFawriBeneficiary")), Input.ReadTestData(TCName, "TransferVia_Ria"), "RIA");
				// Select BeneficiaryCountry//
				Utils.Sendkeys_DD_substringbased(By.xpath(getObj("Propval1", "BeneficiaryCountry", "AddNewFawriBeneficiary")), Input.ReadTestData(TCName, "BeneficiaryCountry_RIA"), Input.ReadTestData(TCName, "BeneficiaryCountry_RIA"));

				// Select Delivery Option//
				Utils.Sendkeys_DD_substringbased(By.xpath(getObj("Propval1", "DeliveryOption", "AddNewFawriBeneficiary")), Input.ReadTestData(TCName, "DeliveryOption_RIA"), Input.ReadTestData(TCName, "DeliveryOption_RIA"));

				// Select Beneficiary bank Agent//
				Utils.Sendkeys_DD_substringbased(By.xpath(getObj("Propval1", "BeneficiaryBankAgent", "AddNewFawriBeneficiary")), Input.ReadTestData(TCName, "BeneficiaryBankAgent_RIA"), Input.ReadTestData(TCName, "BeneficiaryBankAgent_RIA"));

				try {

					FillBeneficiaryDetails(TCName, ScenarioCount);
				} catch (Exception e) {

				}

			} else if (Integer.parseInt(TransferVia) == 2) {
				// Select MoneyGram//
				Utils.Sendkeys_DD_substringbased(By.xpath(getObj("Propval1", "TransferVia", "AddNewFawriBeneficiary")), Input.ReadTestData(TCName, "TransferVia_MoneyGram"), "MoneyGram");

				// Select BeneficiaryCountry//
				Utils.Sendkeys_DD_substringbased(By.xpath(getObj("Propval1", "BeneficiaryCountry", "AddNewFawriBeneficiary")), Input.ReadTestData(TCName, "BeneficiaryCountry_MoneyGram"), Input.ReadTestData(TCName, "BeneficiaryCountry_MoneyGram"));

				// Select Currency//
				Utils.Sendkeys_DD_substringbased(By.xpath(getObj("Propval1", "BeneficiaryCurrency", "AddNewFawriBeneficiary")), Input.ReadTestData(TCName, "Currency_MoneyGram"), Input.ReadTestData(TCName, "Currency_MoneyGram"));

				// Select Delivery Option//
				Utils.Sendkeys_DD_substringbased(By.xpath(getObj("Propval1", "DeliveryOption", "AddNewFawriBeneficiary")), Input.ReadTestData(TCName, "DeliveryOption_MoneyGram"), Input.ReadTestData(TCName, "DeliveryOption_MoneyGram"));

				try {

					FillBeneficiaryDetails(TCName, ScenarioCount);
				} catch (Exception e) {

				}

			}

			else if (Integer.parseInt(TransferVia) == 3) {
				// Select Direct Bank Deposit//
				Utils.Sendkeys_DD_substringbased(By.xpath(getObj("Propval1", "TransferVia", "AddNewFawriBeneficiary")), Input.ReadTestData(TCName, "TransferVia_DirectBankDeposit"), "Direct Bank Deposit");

				// Select BeneficiaryCountry//
				Utils.Sendkeys_DD_substringbased(By.xpath(getObj("Propval1", "BeneficiaryCountry", "AddNewFawriBeneficiary")), Input.ReadTestData(TCName, "BeneficiaryCountry_DirectBankDeposit"),
						Input.ReadTestData(TCName, "BeneficiaryCountry_DirectBankDeposit"));

				// Select Transfer Via Bank//
				Utils.Sendkeys_DD_substringbased(By.xpath(getObj("Propval1", "TransferViaBank", "AddNewFawriBeneficiary")), Input.ReadTestData(TCName, "TransferViaBank_DirectBankDeposit"),
						Input.ReadTestData(TCName, "TransferViaBank_DirectBankDeposit"));

				// Select Currency//
				Utils.Sendkeys_DD_substringbased(By.xpath(getObj("Propval1", "BeneficiaryCurrency", "AddNewFawriBeneficiary")), Input.ReadTestData(TCName, "Currency_DirectBankDeposit"), Input.ReadTestData(TCName, "Currency_DirectBankDeposit"));

				// Select Delivery Option//
				if (Input.ReadTestData(TCName, "DeliveryOption_DirectBankDeposit").equalsIgnoreCase("BANK DEPOSIT")) {
					Utils.Sendkeys_DD_substringbased(By.xpath(getObj("Propval1", "DeliveryOption", "AddNewFawriBeneficiary")), Input.ReadTestData(TCName, "DeliveryOption_DirectBankDeposit"),
							Input.ReadTestData(TCName, "DeliveryOption_DirectBankDeposit"));

					Utils.pressKeyDown();
					Utils.pressKeyDown();
					Utils.pressKeyDown();
					Utils.pressEnter();

				} else {
					Utils.Sendkeys_DD_substringbased(By.xpath(getObj("Propval1", "DeliveryOption", "AddNewFawriBeneficiary")), Input.ReadTestData(TCName, "DeliveryOption_DirectBankDeposit"),
							Input.ReadTestData(TCName, "DeliveryOption_DirectBankDeposit"));
				}

				// Select Beneficiary Bank//
				Utils.Sendkeys_DD_substringbased(By.xpath(getObj("Propval1", "BeneficiaryBank", "AddNewFawriBeneficiary")), Input.ReadTestData(TCName, "BeneficiaryBank_DirectBankDeposit"),
						Input.ReadTestData(TCName, "BeneficiaryBank_DirectBankDeposit"));

				try {
					FillBeneficiaryDetails(TCName, ScenarioCount);
				} catch (Exception e) {
				}
			}

			if (Integer.parseInt(ProceedType) == 1) {
				// Click on Proceed Button//
				Utils.click(By.xpath(getObj("Propval1", "ProceedBtn", "AddNewFawriBeneficiary")), "Proceed Button");

			} else if (Integer.parseInt(ProceedType) == 2) {
				// Click on Cancel Button//
				Utils.click(By.xpath(getObj("Propval1", "CancelTransBtn", "AddNewFawriBeneficiary")), "Cancel Button on Proceed Page");
				return runResult;
			}

			if (Integer.parseInt(ConfirmType) == 1) {
				// Click on Confirm Button//
				Utils.click(By.xpath(getObj("Propval1", "ConfirmBtn", "AddNewFawriBeneficiary")), "Confirm Button");

			}

			else if (Integer.parseInt(ConfirmType) == 2) {
				// Click on Cancel Button//
				Utils.click(By.xpath(getObj("Propval1", "CancelTransBtn", "AddNewFawriBeneficiary")), "Cancel Button on ConfirmationPage");

				if (Integer.parseInt(CancelYes) == 1) {

					// Click on Yes Button to Cancel the Transaction//
					Utils.click(By.xpath(getObj("Propval1", "CancelTransBtn_Confirm", "AddNewFawriBeneficiary")), "Yes Button to cancel Transaction");
					Utils.logPassImage("Cancelled Successfully");
					return runResult;

				} else if (Integer.parseInt(CancelYes) == 2) {
					Utils.wait(3);
					// Click on No Button //
					Utils.click(By.xpath(getObj("Propval1", "CancelTransBtn_Cancel", "AddNewFawriBeneficiary")), "No Button to Continue");

					// Click on Confirm Button//
					Utils.click(By.xpath(getObj("Propval1", "ConfirmBtn", "AddNewFawriBeneficiary")), "Confirm Button");

				}

			}

			// Enter OTP//
			Utils.sendKeys(By.xpath(getObj("Propval1", "OTP", "AddNewFawriBeneficiary")), readConfigXml("OTP"), "OTP Entered");

			if (Integer.parseInt(OTPProceed) == 1) {
				// Click on OTP Proceed//
				Utils.click(By.xpath(getObj("Propval1", "OTPProceedBtn", "AddNewFawriBeneficiary")), "Proceed Button after entering OTP");
				Utils.logPassImage("Completed Successfully");

			}

			else if (Integer.parseInt(OTPProceed) == 2) {

				// Click on BackButton on OTP Page//
				Utils.click(By.xpath(getObj("Propval1", "BackBtn", "AddNewFawriBeneficiary")), "Back Button to go back to the previous page");

				// Click on Confirm Button//
				Utils.click(By.xpath(getObj("Propval1", "ConfirmBtn", "AddNewFawriBeneficiary")), "Confirm Button");

				// Enter OTP//
				Utils.sendKeys(By.xpath(getObj("Propval1", "OTP", "AddNewFawriBeneficiary")), readConfigXml("OTP"), "OTP Entered");

				// Click on OTP Proceed//
				Utils.click(By.xpath(getObj("Propval1", "OTPProceedBtn", "AddNewFawriBeneficiary")), "Proceed Button after entering OTP");
				Utils.logPassImage("Completed Successfully");

			} else if (Integer.parseInt(OTPProceed) == 3) {

				// Click on Cancel on OTP Page//
				Utils.click(By.xpath(getObj("Propval1", "CancelBtnOTP", "AddNewFawriBeneficiary")), "Cancel Button to cancel the transaction");
				Utils.logPassImage("Cancelled Successfully");

				return runResult;

			}

			try {
				Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "SuccessMsg", "AddNewFawriBeneficiary")), " Success Message"));
				Log.pass(" Your Fawri beneficiary has been added successfully. displayed mesage is" + Utils.getText(By.xpath(getObj("Propval1", "SuccessMsg", "AddNewFawriBeneficiary"))));
				Utils.logPassImage("Your Fawri beneficiary has been added successfully- Pass");

			} catch (AssertionError | Exception e) {

				Log.fail("Unable to add Fawri beneficiary");
				Utils.logFailImage("Unable to add Fawri beneficiary -Fail");
				throw e;

			}

			if (AdditionalActions.equalsIgnoreCase("true")) {

				Log.pass("Successfully started other actions like send email, download pdf, excel and print search result etc.");
				sendEmailDownloadExcelnPrintFunc(ScenarioCount, Proceed);

			}

		} catch (AssertionError | Exception e) {
			runResult = false;
			throw e;
		}
		return runResult;
	}

	public static void FillBeneficiaryDetails(String TCName, int scenarioCount) throws Exception {

		String TransferVia;
		TransferVia = ReadDataSQL(TCName, scenarioCount, "TransferVia");
		Utils.wait(3);
		if (Integer.parseInt(TransferVia) == 1) {
			// Select Nickname RIA//

			String Nickname_updated = RandomStringUtils.randomAlphanumeric(5).toUpperCase();
			Utils.sendKeys(By.xpath(getObj("Propval1", "Nickname", "AddNewFawriBeneficiary")), Input.ReadTestData(TCName, "Nickname_RIA") + Nickname_updated, "NICKNAME for RIA");
		} else if (Integer.parseInt(TransferVia) == 2) {
			String Nickname_updated = RandomStringUtils.randomAlphanumeric(5).toUpperCase();

			// Select Nickname MoneyGram//
			Utils.sendKeys(By.xpath(getObj("Propval1", "Nickname", "AddNewFawriBeneficiary")), Input.ReadTestData(TCName, "Nickname_MoneyGram") + Nickname_updated, "NICKNAME for MoneyGram");
		} else if (Integer.parseInt(TransferVia) == 3) {
			String Nickname_updated = RandomStringUtils.randomAlphanumeric(5).toUpperCase();

			// Select Nickname Direct Bank Deposit//
			Utils.sendKeys(By.xpath(getObj("Propval1", "Nickname", "AddNewFawriBeneficiary")), Input.ReadTestData(TCName, "Nickname_DirectBankDeposit") + Nickname_updated, "NICKNAME for Direct Bank Deposit");
		}
		// Select FirstName//
		Utils.sendKeysIfPresent(By.xpath(getObj("Propval1", "Firstname", "AddNewFawriBeneficiary")), Input.ReadTestData(TCName, "FirstName"), "FIRSTNAME");

		// Select Middlename//
		Utils.sendKeysIfPresent(By.xpath(getObj("Propval1", "Middlename", "AddNewFawriBeneficiary")), Input.ReadTestData(TCName, "Middlename"), "MIDDLENAME");

		// Select Lastname//
		Utils.sendKeysIfPresent(By.xpath(getObj("Propval1", "Lastname", "AddNewFawriBeneficiary")), Input.ReadTestData(TCName, "Lastname"), "LASTNAME");

		if (Integer.parseInt(TransferVia) == 2) {

			// Select Thirdname// RIA not using this
			Utils.sendKeysIfPresent(By.xpath(getObj("Propval1", "Thirdname", "AddNewFawriBeneficiary")), Input.ReadTestData(TCName, "Thirdname"), "THIRDNAME");
		}

		// Select Address1//
		Utils.sendKeysIfPresent(By.xpath(getObj("Propval1", "Address1", "AddNewFawriBeneficiary")), Input.ReadTestData(TCName, "Address1"), "ADDRESS1");

		// Select Address2//
		Utils.sendKeysIfPresent(By.xpath(getObj("Propval1", "Address2", "AddNewFawriBeneficiary")), Input.ReadTestData(TCName, "Address2"), "ADDRESS2");

		if (Integer.parseInt(TransferVia) == 2) {
			// Select ZipCode// RIA not using this
			Utils.sendKeysIfPresent(By.xpath(getObj("Propval1", "ZipCode", "AddNewFawriBeneficiary")), Input.ReadTestData(TCName, "ZipCode"), "ZIPCODE");
		}
		// Select City//
		if (Integer.parseInt(TransferVia) == 2 || Integer.parseInt(TransferVia) == 1) {
			Utils.sendKeysIfPresent(By.xpath(getObj("Propval1", "City", "AddNewFawriBeneficiary")), Input.ReadTestData(TCName, "City"), "CITY");
		}
		if (Integer.parseInt(TransferVia) == 1) {
			// Select State//
			Utils.sendKeysIfPresent(By.xpath(getObj("Propval1", "State", "AddNewFawriBeneficiary")), Input.ReadTestData(TCName, "State"), "STATE");
		}
		// Select Mobile//

		if (Integer.parseInt(TransferVia) == 2 || Integer.parseInt(TransferVia) == 1) {
			Utils.sendKeysIfPresent(By.xpath(getObj("Propval1", "Mobile", "AddNewFawriBeneficiary")), Input.ReadTestData(TCName, "Mobile"), "MOBILE");

			// Select Phone//
			Utils.sendKeysIfPresent(By.xpath(getObj("Propval1", "Phone", "AddNewFawriBeneficiary")), Input.ReadTestData(TCName, "Phone"), "PHONE");
		}
		// Select Email// RIA not using this
		// Utils.sendKeysIfPresent(By.xpath(getObj("Propval1", "Email",
		// "AddNewFawriBeneficiary")), Input.ReadTestData(TCName, "Email"),"EMAIL");

		if (Integer.parseInt(TransferVia) == 1) {
			// Select NationalityCodec for RIA//
			Utils.Sendkeys_DD_substringbased(By.xpath(getObj("Propval1", "NationalityCode", "AddNewFawriBeneficiary")), Input.ReadTestData(TCName, "NationalityCode_RIA"), "NATIONALITY CODE");
		} else if (Integer.parseInt(TransferVia) == 2) {
			// Select Nationality Code for MoneyGram//
			Utils.Sendkeys_DD_substringbased(By.xpath(getObj("Propval1", "NationalityCode", "AddNewFawriBeneficiary")), Input.ReadTestData(TCName, "NationalityCode_MoneyGram"), "NATIONALITY CODE");
		} else if (Integer.parseInt(TransferVia) == 3) {
			// Select NationalityCode for Direct Bank Deposit//
			Utils.Sendkeys_DD_substringbased(By.xpath(getObj("Propval1", "NationalityCode", "AddNewFawriBeneficiary")), Input.ReadTestData(TCName, "NationalityCode_DirectBankDeposit"), "NATIONALITY CODE");

			// Select Account Type// RIA not using this
			Utils.Sendkeys_DD_substringbased(By.xpath(getObj("Propval1", "AccountType", "AddNewFawriBeneficiary")), Input.ReadTestData(TCName, "AccountType"), "ACCOUNT TYPE");
		}

		if (Integer.parseInt(TransferVia) == 1) {
			// Select BeneficiaryIDNumber//
			Utils.Sendkeys_DD_substringbased(By.xpath(getObj("Propval1", "BeneficiaryIDNumber", "AddNewFawriBeneficiary")), Input.ReadTestData(TCName, "BeneficiaryIDNumber"), "BENEFICIARY ID NUMBER");

			// Select BeneficiaryRelationship//
			Utils.Sendkeys_DD_substringbased(By.xpath(getObj("Propval1", "BeneficiaryRelationship", "AddNewFawriBeneficiary")), Input.ReadTestData(TCName, "BeneficiaryRelationship"), "BENEFICIARY RELATIONSHIP");

			// Select AgentCity//
			Utils.Sendkeys_DD_substringbased(By.xpath(getObj("Propval1", "AgentCity", "AddNewFawriBeneficiary")), Input.ReadTestData(TCName, "AgentCity"), "AGENT CITY");

			// Select AgentLocation//
			Utils.Sendkeys_DD_substringbased(By.xpath(getObj("Propval1", "AgentLocation", "AddNewFawriBeneficiary")), Input.ReadTestData(TCName, "AgentLocation"), "AGENT LOCATION");

			// Select BeneficiaryRemarks//
			Utils.sendKeysIfPresent(By.xpath(getObj("Propval1", "BeneficiaryRemarks", "AddNewFawriBeneficiary")), Input.ReadTestData(TCName, "BeneficiaryRemarks"), "BENEFICIARY REMARKS");

		}

		if (Integer.parseInt(TransferVia) == 3) {
			// Select BranchCode// RIA not using this
			Utils.Sendkeys_DD_substringbased(By.xpath(getObj("Propval1", "BranchCode", "AddNewFawriBeneficiary")), Input.ReadTestData(TCName, "BranchCode_DirectBankDeposit"), "BRANCH CODE");

			// Select BranchState//RIA not using this
			// Utils.sendKeysIfPresent(By.xpath(getObj("Propval1", "BranchState",
			// "AddNewFawriBeneficiary")),Input.ReadTestData(TCName, "BranchState") ,"BRANCH
			// STATE");

			// Select AccountNo//RIA not using this
			Utils.sendKeysIfPresent(By.xpath(getObj("Propval1", "AccountNo", "AddNewFawriBeneficiary")), Input.ReadTestData(TCName, "AccountNo"), "ACCOUNTNO");

		}

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
