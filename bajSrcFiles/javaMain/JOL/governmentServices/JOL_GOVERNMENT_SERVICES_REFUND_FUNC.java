package javaMain.JOL.governmentServices;

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
import static javaMain.common_Functions.AppData.*;

/**
 * Description : Functional Test Script
 * 
 * @author baj80000892
 */
public class JOL_GOVERNMENT_SERVICES_REFUND_FUNC extends TestBase {

	public static Boolean reFund(String TCName, int ScenarioCount, Object[] tCsDataset) throws Exception {

		try {
			if (isMasterClassRun) {
				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + ReadData.getJsonData(TCName, ScenarioCount, "DataSet") + "</mark>");
				AfterTxfrAdditionalOptions = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "AfterTxfrAdditionalOptions"));
				isNegative = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "isNegative"));

			} else {

				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + dataset[scenarioCount - 1] + "</mark>");
				AfterTxfrAdditionalOptions = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("AfterTxfrAdditionalOptions"));
				isNegative = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("isNegative"));

			}

			Provider = ReadTestData(TCName, "Provider");
			Service = ReadTestData(TCName, "Service");
			AccountNumber = ReadTestData(TCName, "AccountNumber");

			Utils.refreshScreeen();
			Utils.click(By.xpath(getObj("Propval1", "govtservice", "govtservicesReFund")), "Goverment Service Menu");
			Utils.click(By.xpath(getObj("Propval1", "reFund", "govtservicesReFund")), "Goverment Serivce reFund");

			Log.pass("Page title is :  " + Utils.getText(By.xpath(getObj("Propval1", "LandPage", "govtservicesReFund"))));

			if (isNegative.equalsIgnoreCase("true")) {
				Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "ProviderDropdownDropdown", "govtservicesReFund")), By.xpath(getObj("Propval1", "Provider", "govtservicesReFund")), ReadTestData(TCName, "InvalidProvider"), "Provider");
			} else {
				Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "ProviderDropdownDropdown", "govtservicesReFund")), By.xpath(getObj("Propval1", "Provider", "govtservicesReFund")), Provider, "Provider");
			}
			if (isNegative.equalsIgnoreCase("true")) {
				try {
					Log.pass("Started negative test scenario. Searching using Invalid Provider value.");
					Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "ErrorMsg", "govtservicesReFund")), "invalid Provider"));
					Log.pass("User is unable to search with invalid provider as expected. TS passed.");
					Utils.logPassImage("Transfer Result");
					return true;
				} catch (AssertionError | Exception e) {
					Log.fail("No error message displayed while searching using invalid provider- TS failed.");
					Utils.logFailImage("Transfer Result");
					throw e;
				}

			}

			Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "ServiceDropdownDropdown", "govtservicesReFund")), By.xpath(getObj("Propval1", "Service", "govtservicesReFund")), Service, "Service");

			Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "AccountNoDropdownDropdown", "govtservicesReFund")), By.xpath(getObj("Propval1", "AccNo", "govtservicesReFund")), AccountNumber, "Account Number");

			Utils.pressTab();
			Utils.click(By.xpath(getObj("Propval1", "Search", "govtservicesReFund")), "Search");
			Utils.wait(6);
			Utils.click(By.xpath(getObj("Propval1", "Accpet", "govtservicesReFund")), "Accpet PopUp");
			Utils.pressEnter();
			Utils.refreshScreeen();

			Log.pass("Search Result : " + Utils.getText(By.xpath(getObj("Propval1", "searchResult", "govtservicesReFund"))));
			Utils.logPassImage(TCName);

			if (AfterTxfrAdditionalOptions.equalsIgnoreCase("true")) {
				Log.pass("Starting additional actions after transfer. e.g send email, print and save as favourite.");
				eCorpCommonFunctions.sendEmailDownloadExcelnPrintFunc(ScenarioCount);
				Log.pass("Additional Actions  like send email, print and download pdf/excel etc have  passed successfully.");
				Utils.logPassImage("Additional Actions");

			}
			Utils.logPassImage(TCName);
		} catch (Exception e) {
			runResult = false;
			throw e;
		}
		return runResult;
	}


	public static Boolean ABSHER_ACTIVATION(String TCName, int ScenarioCount, Object[] tCsDataset) throws Exception {

		try {

			if (isMasterClassRun) {

				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + ReadData.getJsonData(TCName, ScenarioCount, "DataSet") + "</mark>");

				Proceed = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Proceed"));
				Confirm = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Confirm"));
				OTPProceed = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "OTPProceed"));
				Mobile = ReadTestData(TCName, "MobileNumber");
				other = ReadTestData(TCName, "other");
				isNegative = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "isNegative"));
				TCButton = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "TCButton"));
				CheckBox = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "CheckBox"));

			} else {

				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + dataset[scenarioCount - 1] + "</mark>");

				Proceed = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Procced"));
				Confirm = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Confirm"));
				OTPProceed = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("OTPProceed"));
				Mobile = ReadTestData(TCName, "MobileNumber"); 
				other = ReadTestData(TCName, "other");
				isNegative = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("isNegative"));
				TCButton = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("TCButton"));
				CheckBox = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("CheckBox"));

			}

			Utils.refreshScreeen();
			Utils.click(By.xpath(getObj("Propval1", "govtservice", "AbsherActivation")), "Goverment Service Menu");
			Utils.click(By.xpath(getObj("Propval1", "AbsherActivation", "AbsherActivation")), "Absher Activation");

			Log.pass("Page title is : " +  Utils.getText(By.xpath(getObj("Propval1", "LandPage", "AbsherActivation"))));
			Utils.sendKeys(By.xpath(getObj("Propval1", "Mobile", "AbsherActivation")), Mobile, "Mobile Number is Enter");
			Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "LangugageDropdownDropdown", "AbsherActivation")), By.xpath(getObj("Propval1", "Langugage", "AbsherActivation")), other);


			if (Integer.parseInt(Proceed) == 1) {

				Utils.click(By.xpath(getObj("Propval1", "Proceed", "AbsherActivation")), "Proceed");

			} else {

				Utils.click(By.xpath(getObj("Propval1", "Cancel", "AbsherActivation")), "Cancel Proceed");

				Utils.logPassImage(TCName);
				return runResult;

			}

			if (TCButton.equalsIgnoreCase("True")) {
				if (CheckBox.equalsIgnoreCase("True")) {
					// Click on the terms and Conditions CheckBox Directly//
					Utils.click(By.xpath(getObj("Propval1", "CheckBoxTC", "AbsherActivation")), "on Terms and Conditons Button directly");
				} else if (CheckBox.equalsIgnoreCase("False")) {
					// Click on the link of Terms and Conditions//
					Utils.click(By.xpath(getObj("Propval1", "TnCpoup", "AbsherActivation")), "which is a link of Terms and Conditions");
					// Click on I Accept Radio of the pop up//
					Utils.click(By.xpath(getObj("Propval1", "TnCAgree", "AbsherActivation")), "which is I Accept RadioButton");

				}

			}

			if (Integer.parseInt(Confirm) == 1) {

				Utils.click(By.xpath(getObj("Propval1", "Confirm", "AbsherActivation")), "Confirm");

			} else if (Integer.parseInt(Confirm) == 2) {

				Utils.click(By.xpath(getObj("Propval1", "modify", "AbsherActivation")), "Modify");

				Utils.click(By.xpath(getObj("Propval1", "Proceed", "AbsherActivation")), "Confirm Proceed");

				Utils.click(By.xpath(getObj("Propval1", "CheckBoxTC", "AbsherActivation")), "Confirm Condtion Check");

				Log.pass("Modify Confirm ......");
				Utils.click(By.xpath(getObj("Propval1", "Confirm", "AbsherActivation")), "Modify COnfirm");

			} else {
				Utils.click(By.xpath(getObj("Propval1", "Cancel", "AbsherActivation")), "Confirm Cancel");

				Utils.click(By.xpath(getObj("Propval1", "CancelYes", "AbsherActivation")), "Cancel Yes");
				Log.pass("Confirm Cancel ......");
				Utils.logPassImage(TCName);
				return runResult;
			}

			if (isNegative.equalsIgnoreCase("true")) {
				try {
					Assert.assertFalse(Utils.assertDisplayed(By.xpath(getObj("Propval1", "OTPPage", "AbsherActivation")), "OTP Page"));
					Log.pass("Not able to negivate to OTP page without click on check box hence test case pass");
					Utils.logPassImage(TCName);
					return true;
				}

				catch (AssertionError | Exception e) {
					Log.fail("able to proceed without enter mandatory fields hence test case failed");
					throw e;
				}

			}

			if (Integer.parseInt(OTPProceed) == 1) {
				
				Utils.enterOTPAndProceed();
				
			} else {
				
				Utils.click(By.xpath(getObj("Propval1", "Cancel", "AbsherActivation")), "OTP Cancel");
				Utils.click(By.xpath(getObj("Propval1", "CancelYes", "AbsherActivation")), "OTP Cancel Yes");
				Log.pass("Confirm Cancel ......");
				Utils.logPassImage(TCName + " OTP Cancel");
				return runResult;

			}

			try {
				Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "SuccessMessage", "Card")), "Success Message"));
				Log.pass("Absher Activation completed successfully.");
				Log.pass("Displayed Message is :" + Utils.getText(By.xpath(getObj("Propval1", "SuccessMessage", "Card"))));
				Utils.logPassImage("Absher Activation-Pass");

			} catch (AssertionError | Exception e) {

				Log.fail("Absher Activation failed...Message:" + Utils.getText(By.xpath(getObj("Propval1", "failMessage", "Card"))));
				Utils.logFailImage("Absher Activation-Fail");
				throw e;
			}

		} catch (AssertionError | Exception e) {

			Utils.pressEscapeKey(3);
			runResult = false;
			throw e;
		}
		return runResult;
	}

	public static Boolean AddNewBeneficiary(String TCName, int ScenarioCount, Object[] tCsDataset) throws Exception {
		
		try {

			if (isMasterClassRun) {

				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + ReadData.getJsonData(TCName, ScenarioCount, "DataSet") + "</mark>");

				ReadData.getJsonData("JOL Transfers - Add New Benificiary", 4, "DataSet");

				Proceed = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Proceed"));
				Confirm = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Confirm"));
				OTPProceed = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "OTPProceed"));
				Nickname = ReadTestData(TCName, "Nickname");
				other = ReadTestData(TCName, "other");
				IDType = ReadTestData(TCName, "IDType");
				isNegative = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "isNegative"));

			} else {

				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + dataset[scenarioCount - 1] + "</mark>");

				Proceed = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Procced"));
				Confirm = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Confirm"));
				OTPProceed = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("OTPProceed"));
				Nickname = ReadTestData(TCName, "Nickname"); 
				other = ReadTestData(TCName, "other"); 
				IDType = ReadTestData(TCName, "IDType");
				isNegative = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("isNegative"));

			}

			Utils.refreshScreeen();
			Utils.click(By.xpath(getObj("Propval1", "govtservice", "AddNewBeneficiary")), "Goverment Service Menu");
			Utils.click(By.xpath(getObj("Propval1", "AddNewBeneficiary", "AddNewBeneficiary")), "Goverment Serivce reFund");

			Log.pass("Page title is :  " + Utils.getText(By.xpath(getObj("Propval1", "LandPage", "AddNewBeneficiary"))));

			Utils.sendKeys(By.xpath(getObj("Propval1", "NickName", "AddNewBeneficiary")), Nickname, "enter nick name");

			Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "IDtypeDropdownDropdown", "AddNewBeneficiary")), By.xpath(getObj("Propval1", "IDType", "AddNewBeneficiary")), IDType);

			Log.pass("TD Type is  : " + ReadTestData("GovtAddNewBeneficiary", "IDNumber"));

			if (isNegative.equalsIgnoreCase("true")) {
				Utils.sendKeys(By.xpath(getObj("Propval1", "IDNumber", "AddNewBeneficiary")), ReadTestData(TCName, "WorngValues"), "Enter ID Number");
			} else {
				Utils.sendKeys(By.xpath(getObj("Propval1", "IDNumber", "AddNewBeneficiary")), other, "Enter ID Number");
			}

			if (Integer.parseInt(Proceed) == 1) {
				Utils.click(By.xpath(getObj("Propval1", "Proceed", "AddNewBeneficiary")), "Proceed");
			} else {

				Utils.click(By.xpath(getObj("Propval1", "Cancel", "AddNewBeneficiary")), "Cancel Proceed");
				Utils.logPassImage(TCName);
				return runResult;

			}

			if (isNegative.equalsIgnoreCase("true")) {
				try {
					Assert.assertFalse(Utils.assertDisplayed(By.xpath(getObj("Propval1", "Confirm", "AddNewBeneficiary")), "Confirm Page"));
					Log.pass("Not able to negivate to confirm page without entering all the valid mandatory values");
					Utils.logPassImage(TCName);
					return true;
				}

				catch (AssertionError | Exception e) {
					Log.fail("able to proceed without enter mandatory fields hence test case fail");
					throw e;
				}

			}

			if (Integer.parseInt(Confirm) == 1) {

				Utils.click(By.xpath(getObj("Propval1", "Confirm", "AddNewBeneficiary")), "Confirm");

			} else if (Integer.parseInt(Confirm) == 2) {

				Utils.click(By.xpath(getObj("Propval1", "modify", "AddNewBeneficiary")), "Modify ");

				Utils.click(By.xpath(getObj("Propval1", "Proceed", "AddNewBeneficiary")), "Confirm Proceed");

				Utils.click(By.xpath(getObj("Propval1", "Confirm", "AddNewBeneficiary")), "Modify COnfirm");

			} else {
				Utils.click(By.xpath(getObj("Propval1", "Cancel", "AddNewBeneficiary")), "Confirm Cancel");

				Utils.click(By.xpath(getObj("Propval1", "CancelYes", "AddNewBeneficiary")), "Clcik on Yes");

				Utils.logPassImage(TCName);
				return runResult;
			}

			if (Integer.parseInt(OTPProceed) == 1) {
				Utils.enterOTPAndProceed("0123");
			} else {
				Utils.click(By.xpath(getObj("Propval1", "Cancel", "AddNewBeneficiary")), "OTP Cancel");

				Utils.click(By.xpath(getObj("Propval1", "CancelYes", "AddNewBeneficiary")), "OTP Cancel Yes");

				Utils.logPassImage(TCName);
				return runResult;

			}
			Utils.logPassImage(TCName);

			try {
				Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propv(al1", "SuccessMessage", "Card")), "Success Message"));
				Log.pass("AddNew Beneficiary completed successfully.");
				Log.pass("Displayed Message is :" + Utils.getText(By.xpath(getObj("Propv(al1", "SuccessMessage", "Card"))));
				Utils.logPassImage("AddNew Beneficiary-Pass");

			} catch (AssertionError | Exception e) {

				Log.fail("AddNew Beneficiary failed...Message:" + Utils.getText(By.xpath(getObj("Propval1", "failMessage", "Card"))));
				Utils.logFailImage("AddNew Beneficiary-Fail");
				throw e;
			}

		} catch (Exception e) {

			runResult = false;
			throw e;
		}
		return runResult;
	}
}
