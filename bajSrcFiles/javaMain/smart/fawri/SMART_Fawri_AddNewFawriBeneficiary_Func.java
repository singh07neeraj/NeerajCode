package javaMain.smart.fawri;

import static Utilities.ReadData.ReadDataSQL;
import static Utilities.ReadData.getObj;
import static Utilities.ReadData.readConfigXml;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import Utilities.Input;
import Utilities.Log;
import Utilities.ReadData;
import Utilities.TestBase;
import Utilities.Utils;
import javaMain.common_Functions.OpenMenuesSmart;

public class SMART_Fawri_AddNewFawriBeneficiary_Func extends TestBase{
	
	public static String TransferVia,BeneficiaryCountry,DeliveryOption,BeneficiaryBankAgent,Nickname,FirstName,MiddleName,LastName,Address1,
							Address2,City,State,Mobile,Phone,NationalityCode,BeneficiaryIDNumber,BeneficiaryRelationship,AgentCity,AgentLocation,
							BeneficiaryRemarks,Currency,ZIpCode,TransferViaBank,AccountType,BranchCode,AccountNumber,BeneficiaryBank,Proceed, Confirm, OTPProceed, CancelYes, BeneficiaryActivationMode,TestType;
	public static boolean SMART_Fawri_AddNewFawriBeneficiary(String TCName, int ScenarioCount, Object[] tCsDataset)
			throws Exception {

				
		try {

			if (true)
			{

				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + ReadData.getJsonData(TCName, ScenarioCount, "DataSet") + "</mark>");
				
				TransferVia = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "TransferVia"));
				BeneficiaryCountry = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "BeneficiaryCountry"));
				DeliveryOption = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "DeliveryOption"));
				BeneficiaryBankAgent = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "BeneficiaryBankAgent"));
				Nickname = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Nickname"));
				FirstName = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "FirstName"));
				MiddleName = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "MiddleName"));
				LastName = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "LastName"));
				Address1 = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Address1"));
				Address2 = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Address2"));
				City = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "City"));
				State = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "State"));
				Mobile = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Mobile"));
				Phone = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Phone"));
				NationalityCode= Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "NationalityCode"));
				BeneficiaryIDNumber = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "BeneficiaryIDNumber"));
				BeneficiaryRelationship = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "BeneficiaryRelationship"));
				AgentCity = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "AgentCity"));
				AgentLocation = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "AgentLocation"));
				BeneficiaryRemarks = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "BeneficiaryRemarks"));
				Currency = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Currency"));
				ZIpCode = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "ZIpCode"));
				TransferViaBank = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "TransferViaBank"));
				AccountType = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "AccountType"));
				BranchCode = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "BranchCode"));
				AccountNumber = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "AccountNumber"));
				BeneficiaryBank = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "BeneficiaryBank"));
				Proceed = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Proceed"));
				Confirm = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Confirm"));
				OTPProceed = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "OTPProceed"));
				CancelYes = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "CancelYes"));
				BeneficiaryActivationMode = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "BeneficiaryActivationMode"));
				TestType = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "TestType"));

			} else {

				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + ReadData.getJsonData(TCName, ScenarioCount, "DataSet") + "</mark>");
				
				TransferVia = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("TransferVia"));
				BeneficiaryCountry = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("BeneficiaryCountry"));
				DeliveryOption = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("DeliveryOption"));
				BeneficiaryBankAgent = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("BeneficiaryBankAgent"));
				Nickname = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Nickname"));
				FirstName = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("FirstName"));
				MiddleName = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("MiddleName"));
				LastName = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("LastName"));
				Address1 = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Address1"));
				Address2 = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Address2"));
				City = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("City"));
				State = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("State"));
				Mobile = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Mobile"));
				Phone = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Phone"));
				NationalityCode = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("NationalityCode"));
				BeneficiaryIDNumber = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("BeneficiaryIDNumber"));
				BeneficiaryRelationship = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("BeneficiaryRelationship"));
				AgentCity = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("AgentCity"));
				AgentLocation = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("AgentLocation"));
				BeneficiaryRemarks = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("BeneficiaryRemarks"));
				Currency = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Currency"));
				ZIpCode = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("ZIpCode"));
				TransferViaBank = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("TransferViaBank"));
				AccountType = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("AccountType"));
				BranchCode = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("BranchCode"));
				AccountNumber = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("AccountNumber"));
				BeneficiaryBank = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("BeneficiaryBank"));
				Proceed = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Proceed"));
				Confirm = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Confirm"));
				OTPProceed = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("OTPProceed"));
				CancelYes = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("CancelYes"));
				BeneficiaryActivationMode = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("BeneficiaryActivationMode"));
				TestType= Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("TestType"));
			}
			Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "LoadingSpinner", "LogInLandingPage")));
			OpenMenuesSmart.openFawriMenu("AddNewFawriBeneficiary");
			Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "LoadingSpinner", "LogInLandingPage")));

			try {
				Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "AddNewFawriBeneficiary_title", "SMART_FAWRI_ADD_NEW_BENEFICIARY")), "Add New Fawri Beneficiary home page"));

				Log.pass(" Add New Fawri Beneficiary home page appearing successfully. message displayed is " + Utils.getText(By.xpath(getObj("Propval1", "AddNewFawriBeneficiary_title", "SMART_FAWRI_ADD_NEW_BENEFICIARY"))));

				Utils.logPassImage("Add New Fawri Beneficiary home page-pass");


			} catch (AssertionError | Exception e) {

				Log.fail("Add New Fawri Beneficiary home page not appearing");
				Utils.logFailImage("Add New Fawri Beneficiary home page-fail");

				throw e;

			}
			
			try {

				FillBeneficiaryDetails(TCName, ScenarioCount);
			} catch (Exception e) {
				
				Log.fail("Beneficiary details not filled properly");
				Utils.logFailImage("Beneficiary details not filled properly-fail");
			}
			

			if (Proceed.equalsIgnoreCase("true")) {
				
				// Click on Proceed Button//
				Utils.click(By.xpath(getObj("Propval1", "ProceedBtn", "SMART_FAWRI_ADD_NEW_BENEFICIARY")), "Proceed Button");
				Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "LoadingSpinner", "LogInLandingPage")));
				if (TestType.equalsIgnoreCase("N")) {
				
				try {
					Assert.assertTrue(Utils.assertDisplayed_Smart(By.xpath(getObj("Propval1", "Data_Alert", "SMART_FAWRI_ADD_NEW_BENEFICIARY")), "Alert checking on Execution Page"));
					Utils.scrollIntoView(By.xpath(getObj("Propval1", "TransferVia_DD", "SMART_FAWRI_ADD_NEW_BENEFICIARY")));
					Log.pass("User is unable to proceed with invalid data as expected");
					Utils.logPassImage("User is unable to proceed with invalid data-pass");
					return runResult;

				} catch (AssertionError | Exception e) {

					Log.fail("User is able to proceed with invalid data");
					Utils.logFailImage("User is unable to proceed with invalid data-fail");

					throw e;

				}
				
				}

			} else
			{
				// Click on Cancel Button//
				Utils.click(By.xpath(getObj("Propval1", "CancelBtn", "SMART_FAWRI_ADD_NEW_BENEFICIARY")),
						"Cancel Button on Proceed Page");
				Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "LoadingSpinner", "LogInLandingPage")));
				try {
					Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "Homepage_OnCancel", "SMART_ACCOUNT_REQUEST_STEMENT_BYMAIL")), "Home page"));
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
				Utils.click(By.xpath(getObj("Propval1", "ConfirmBtn", "SMART_FAWRI_ADD_NEW_BENEFICIARY")), "Confirm Button");
				Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "LoadingSpinner", "LogInLandingPage")));
			}

			else
			{
				// Click on Cancel Button//
				Utils.click(By.xpath(getObj("Propval1", "CancelBtn", "SMART_FAWRI_ADD_NEW_BENEFICIARY")),
						"Cancel Button on ConfirmationPage");

				if (CancelYes.equalsIgnoreCase("true")) {

					// Click on Yes Button to Cancel the Transaction//
					Utils.click(By.xpath(getObj("Propval1", "Cancel_Yes_Btn", "SMART_FAWRI_ADD_NEW_BENEFICIARY")),
							"Yes Button to cancel Transaction");

					return runResult;

				}
				else
				{

					// Click on No Button //
					Utils.click(By.xpath(getObj("Propval1", "Cancel_No_Btn", "SMART_FAWRI_ADD_NEW_BENEFICIARY")),
							"No Button to Continue");

					// Click on Confirm Button//
					Utils.click(By.xpath(getObj("Propval1", "ConfirmBtn", "SMART_FAWRI_ADD_NEW_BENEFICIARY")), "Confirm Button");
					Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "LoadingSpinner", "LogInLandingPage")));
					
				}

			}

			// Enter OTP//
			Utils.sendKeys_Smart(By.xpath(getObj("Propval1", "OTP", "SMART_FAWRI_ADD_NEW_BENEFICIARY")), readConfigXml("OTP"),
					"OTP Entered");

			if (OTPProceed.equalsIgnoreCase("true")) {

				// Click on OTP Proceed//
				Utils.click(By.xpath(getObj("Propval1", "OTPProceedBtn", "SMART_FAWRI_ADD_NEW_BENEFICIARY")),
						"Proceed Button after entering OTP");
				Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "LoadingSpinner", "LogInLandingPage")));
			}

			 else
			 {

				// Click on Cancel on OTP Page//
				Utils.click(By.xpath(getObj("Propval1", "CancelBtn", "SMART_FAWRI_ADD_NEW_BENEFICIARY")),
						"Cancel Button to cancel the transaction");
				return runResult;

			}
			Utils.wait(10);
			try {
				Assert.assertTrue(Utils.assertDisplayed_Smart(By.xpath(getObj("Propval1", "Beneficiary_SuccessMessage", "SMART_FAWRI_ADD_NEW_BENEFICIARY")), "Beneficiary success message on results page"));
				Utils.scrollIntoView(By.xpath(getObj("Propval1", "Results_Page", "SMART_FAWRI_ADD_NEW_BENEFICIARY")));
				Log.pass(" Fawri beneficiary has been added successfully. Message displayed is : " + Utils.getText_Smart(By.xpath(getObj("Propval1", "Beneficiary_SuccessMessage", "SMART_FAWRI_ADD_NEW_BENEFICIARY"))));
				Utils.logPassImage("  Fawri beneficiary has been added successfully-pass");
				//return true;

			} catch (AssertionError | Exception e) {

				Log.fail("Fawri beneficiary has not been added. Should have failed.");
				Utils.logFailImage(" Fawri beneficiary has not been added-fail");
				throw e;

			}
			

		} catch (AssertionError | Exception e) {
			runResult = false;
			throw e;
		}
		return runResult;
	}

	public static void FillBeneficiaryDetails(String TCName, int scenarioCount) throws Exception {
		
		try
		{
		if (TransferVia.equalsIgnoreCase("RIA")) {
			
			Utils.sendValDropdown_Smart(By.xpath(getObj("Propval1", "TransferVia_DD", "SMART_FAWRI_ADD_NEW_BENEFICIARY")), TransferVia, "TransferVia DropDown");
			//	Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "LoadingSpinner2", "LogInLandingPage")));
			Utils.sendValDropdown_Smart(By.xpath(getObj("Propval1", "BeneficiaryCountry_DD", "SMART_FAWRI_ADD_NEW_BENEFICIARY")), BeneficiaryCountry, "BeneficiaryCountry DropDOwn");
			
			Utils.sendValDropdown_Smart(By.xpath(getObj("Propval1", "DeliveryOption_DD", "SMART_FAWRI_ADD_NEW_BENEFICIARY")), DeliveryOption, "DeliveryOption DropDOwn");
			Utils.sendValDropdown_Smart(By.xpath(getObj("Propval1", "BenBankAgent_DD", "SMART_FAWRI_ADD_NEW_BENEFICIARY")), BeneficiaryBankAgent, "BeneficiaryBankAgent DropDOwn");
			Utils.wait(5);
			String Nickname_updated= RandomStringUtils.randomAlphanumeric(5).toUpperCase();
			Utils.sendKeys_Smart(By.xpath(getObj("Propval1", "NickName_txt", "SMART_FAWRI_ADD_NEW_BENEFICIARY")),Nickname+Nickname_updated,"NICKNAME text box");
			//Enter FirstName//
			Utils.sendKeys_Smart(By.xpath(getObj("Propval1", "FirstName_txt", "SMART_FAWRI_ADD_NEW_BENEFICIARY")),FirstName,"FIRSTNAME text box");
			//Enter Middlename//
			Utils.sendKeys_Smart(By.xpath(getObj("Propval1", "MiddleName_txt", "SMART_FAWRI_ADD_NEW_BENEFICIARY")),MiddleName,"MIDDLENAME text box");
			//Enter Lastname//
			Utils.scrollIntoView(By.xpath(getObj("Propval1", "FirstName_txt", "SMART_FAWRI_ADD_NEW_BENEFICIARY")));
			Utils.sendKeys_Smart(By.xpath(getObj("Propval1", "LastName_txt", "SMART_FAWRI_ADD_NEW_BENEFICIARY")),LastName,"LASTNAME text box");
			//Enter Address1//
			Utils.sendKeys_Smart(By.xpath(getObj("Propval1", "Address1_txt", "SMART_FAWRI_ADD_NEW_BENEFICIARY")),Address1,"Address1 text box");
			
			//Enter Address2//
			Utils.sendKeys_Smart(By.xpath(getObj("Propval1", "Address2_txt", "SMART_FAWRI_ADD_NEW_BENEFICIARY")),Address2,"Address2 text box");
			//Enter City//
			Utils.sendKeys_Smart(By.xpath(getObj("Propval1", "City_txt", "SMART_FAWRI_ADD_NEW_BENEFICIARY")),City,"City text box");
			//Enter State//
			Utils.sendKeys_Smart(By.xpath(getObj("Propval1", "State_txt", "SMART_FAWRI_ADD_NEW_BENEFICIARY")),State,"State text box");
			//Enter Mobile//
			Utils.sendKeys_Smart(By.xpath(getObj("Propval1", "Mobile_txt", "SMART_FAWRI_ADD_NEW_BENEFICIARY")),Mobile,"Mobile text box");
			//Enter Phone//
			Utils.sendKeys_Smart(By.xpath(getObj("Propval1", "Phone_txt", "SMART_FAWRI_ADD_NEW_BENEFICIARY")),Phone,"Phone text box");
			//Select Nationality code
			Utils.sendValDropdown_Smart(By.xpath(getObj("Propval1", "NationalityCode_DD", "SMART_FAWRI_ADD_NEW_BENEFICIARY")), NationalityCode, "NationalityCode DropDOwn");
			//Enter beneficiary ID number
			Utils.sendKeys_Smart(By.xpath(getObj("Propval1", "BeneficiaryIDNO_txt", "SMART_FAWRI_ADD_NEW_BENEFICIARY")),BeneficiaryIDNumber,"BeneficiaryIDNO text box");
			//Select Beneficiary Relationship
			Utils.sendValDropdown_Smart(By.xpath(getObj("Propval1", "BeneficiaryRelationship_DD", "SMART_FAWRI_ADD_NEW_BENEFICIARY")), BeneficiaryRelationship, "BeneficiaryRelationship DropDOwn");
			//Select Agent city
			Utils.sendValDropdown_Smart(By.xpath(getObj("Propval1", "AgentCity_DD", "SMART_FAWRI_ADD_NEW_BENEFICIARY")), AgentCity, "AgentCity DropDOwn");
			//Select Agent location
			Utils.sendValDropdown_Smart(By.xpath(getObj("Propval1", "AgentLocation_DD", "SMART_FAWRI_ADD_NEW_BENEFICIARY")), AgentLocation, "AgentLocation DropDOwn");
			//Enter beneficiary remarks
			Utils.sendKeys_Smart(By.xpath(getObj("Propval1", "BenRemarks_txt", "SMART_FAWRI_ADD_NEW_BENEFICIARY")),BeneficiaryRemarks,"BenRemarks text box");
			
		}
		if (TransferVia.equalsIgnoreCase("MoneyGram")) {

			
			Utils.sendValDropdown_Smart(By.xpath(getObj("Propval1", "TransferVia_DD", "SMART_FAWRI_ADD_NEW_BENEFICIARY")), TransferVia, "TransferVia DropDown");
			//	Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "LoadingSpinner2", "LogInLandingPage")));
			Utils.sendValDropdown_Smart(By.xpath(getObj("Propval1", "BeneficiaryCountry_DD", "SMART_FAWRI_ADD_NEW_BENEFICIARY")), BeneficiaryCountry, "BeneficiaryCountry DropDOwn");
			Utils.sendValDropdown_Smart(By.xpath(getObj("Propval1", "Currency_DD", "SMART_FAWRI_ADD_NEW_BENEFICIARY")), Currency, "Currency DropDOwn");
			Utils.sendValDropdown_Smart(By.xpath(getObj("Propval1", "DeliveryOption_DD", "SMART_FAWRI_ADD_NEW_BENEFICIARY")), DeliveryOption, "DeliveryOption DropDOwn");
			Utils.wait(10);
			String Nickname_updated= RandomStringUtils.randomAlphanumeric(5).toUpperCase();
			Utils.sendKeys_Smart(By.xpath(getObj("Propval1", "NickName_txt", "SMART_FAWRI_ADD_NEW_BENEFICIARY")),Nickname+Nickname_updated,"NICKNAME text box");
			//Enter FirstName//
			Utils.sendKeys_Smart(By.xpath(getObj("Propval1", "FirstName_txt", "SMART_FAWRI_ADD_NEW_BENEFICIARY")),FirstName,"FIRSTNAME text box");
			//Enter Middlename//
			Utils.sendKeys_Smart(By.xpath(getObj("Propval1", "MiddleName_txt", "SMART_FAWRI_ADD_NEW_BENEFICIARY")),MiddleName,"MIDDLENAME text box");
			//Enter Lastname//
			Utils.scrollIntoView(By.xpath(getObj("Propval1", "FirstName_txt", "SMART_FAWRI_ADD_NEW_BENEFICIARY")));
			Utils.sendKeys_Smart(By.xpath(getObj("Propval1", "LastName_txt", "SMART_FAWRI_ADD_NEW_BENEFICIARY")),LastName,"LASTNAME text box");
			//Enter Address1//
			Utils.sendKeys_Smart(By.xpath(getObj("Propval1", "Address1_txt", "SMART_FAWRI_ADD_NEW_BENEFICIARY")),Address1,"Address1 text box");
			
			//Enter Address2//
			Utils.sendKeys_Smart(By.xpath(getObj("Propval1", "Address2_txt", "SMART_FAWRI_ADD_NEW_BENEFICIARY")),Address2,"Address2 text box");
			//Enter City//
			Utils.sendKeys_Smart(By.xpath(getObj("Propval1", "City_txt", "SMART_FAWRI_ADD_NEW_BENEFICIARY")),City,"City text box");
			//Enter State//
			//Utils.sendKeys_Smart(By.xpath(getObj("Propval1", "State_txt", "SMART_FAWRI_ADD_NEW_BENEFICIARY")),State,"State text box");
			//Enter Mobile//
			Utils.sendKeys_Smart(By.xpath(getObj("Propval1", "Mobile_txt", "SMART_FAWRI_ADD_NEW_BENEFICIARY")),Mobile,"Mobile text box");
			//Enter Phone//
			Utils.sendKeys_Smart(By.xpath(getObj("Propval1", "Phone_txt", "SMART_FAWRI_ADD_NEW_BENEFICIARY")),Phone,"Phone text box");
			//Select Nationality code
			Utils.sendValDropdown_Smart(By.xpath(getObj("Propval1", "NationalityCode_DD", "SMART_FAWRI_ADD_NEW_BENEFICIARY")), NationalityCode, "NationalityCode DropDOwn");
			//Enter Zip COde
			Utils.sendKeys_Smart(By.xpath(getObj("Propval1", "ZipCode_txt", "SMART_FAWRI_ADD_NEW_BENEFICIARY")),ZIpCode,"ZIpCode text box");
			
		
		}
		if (TransferVia.equalsIgnoreCase("Direct Bank Deposit")) {

			
			Utils.sendValDropdown_Smart(By.xpath(getObj("Propval1", "TransferVia_DD", "SMART_FAWRI_ADD_NEW_BENEFICIARY")), TransferVia, "TransferVia DropDown");
			//	Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "LoadingSpinner2", "LogInLandingPage")));
			Utils.sendValDropdown_Smart(By.xpath(getObj("Propval1", "BeneficiaryCountry_DD", "SMART_FAWRI_ADD_NEW_BENEFICIARY")), BeneficiaryCountry, "BeneficiaryCountry DropDOwn");
			Utils.sendValDropdown_Smart(By.xpath(getObj("Propval1", "TransferViaBank_DD", "SMART_FAWRI_ADD_NEW_BENEFICIARY")), TransferViaBank, "TransferViaBank DropDOwn");
			Utils.sendValDropdown_Smart(By.xpath(getObj("Propval1", "Currency_DD", "SMART_FAWRI_ADD_NEW_BENEFICIARY")), Currency, "Currency DropDOwn");
			
			
			Utils.sendValDropdown_Smart(By.xpath(getObj("Propval1", "DeliveryOption_DD", "SMART_FAWRI_ADD_NEW_BENEFICIARY")), DeliveryOption, "DeliveryOption DropDOwn");
			Utils.sendValDropdown_Smart(By.xpath(getObj("Propval1", "BenBankDirectBank_DD", "SMART_FAWRI_ADD_NEW_BENEFICIARY")), BeneficiaryBank, "BeneficiaryBank DropDOwn");
			Utils.wait(5);
			String Nickname_updated= RandomStringUtils.randomAlphanumeric(5).toUpperCase();
			Utils.sendKeys_Smart(By.xpath(getObj("Propval1", "NickName_txt", "SMART_FAWRI_ADD_NEW_BENEFICIARY")),Nickname+Nickname_updated,"NICKNAME text box");
			//Enter FirstName//
			Utils.sendKeys_Smart(By.xpath(getObj("Propval1", "FirstName_txt", "SMART_FAWRI_ADD_NEW_BENEFICIARY")),FirstName,"FIRSTNAME text box");
			//Enter Middlename//
			Utils.sendKeys_Smart(By.xpath(getObj("Propval1", "MiddleName_txt", "SMART_FAWRI_ADD_NEW_BENEFICIARY")),MiddleName,"MIDDLENAME text box");
			//Enter Lastname//
			Utils.scrollIntoView(By.xpath(getObj("Propval1", "FirstName_txt", "SMART_FAWRI_ADD_NEW_BENEFICIARY")));
			Utils.sendKeys_Smart(By.xpath(getObj("Propval1", "LastName_txt", "SMART_FAWRI_ADD_NEW_BENEFICIARY")),LastName,"LASTNAME text box");
			//Enter Address1//
			Utils.sendKeys_Smart(By.xpath(getObj("Propval1", "Address1_txt", "SMART_FAWRI_ADD_NEW_BENEFICIARY")),Address1,"Address1 text box");
			
			//Enter Address2//
			Utils.sendKeys_Smart(By.xpath(getObj("Propval1", "Address2_txt", "SMART_FAWRI_ADD_NEW_BENEFICIARY")),Address2,"Address2 text box");
			//Select Nationality code
			Utils.sendValDropdown_Smart(By.xpath(getObj("Propval1", "NationalityCode_DD", "SMART_FAWRI_ADD_NEW_BENEFICIARY")), NationalityCode, "NationalityCode DropDOwn");
			//Select AccountType
			Utils.sendValDropdown_Smart(By.xpath(getObj("Propval1", "AccountType_DD", "SMART_FAWRI_ADD_NEW_BENEFICIARY")), AccountType, "AccountType DropDOwn");
			//Select Bracnch Code
			Utils.sendValDropdown_Smart(By.xpath(getObj("Propval1", "BranchCode_DD", "SMART_FAWRI_ADD_NEW_BENEFICIARY")), BranchCode, "BranchCode DropDOwn");
			//Enter Account number
			Utils.sendKeys_Smart(By.xpath(getObj("Propval1", "BenAcctNo_txt", "SMART_FAWRI_ADD_NEW_BENEFICIARY")),AccountNumber,"BenAcctNo text box");
				
				
		}
		
	} catch (Exception e) {
		Log.fail("Beneficiary details not filled properly");
		Utils.logFailImage("Beneficiary details not filled properly-fail");
		runResult = false;
		throw e;
	}
	
		
	}

}
