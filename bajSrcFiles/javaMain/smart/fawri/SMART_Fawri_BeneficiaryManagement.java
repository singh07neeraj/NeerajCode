package javaMain.smart.fawri;

import static Utilities.ReadData.ReadDataSQL;
import static Utilities.ReadData.getObj;
import static Utilities.ReadData.readConfigXml;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.openqa.selenium.By;
import org.testng.Assert;

import static Utilities.ReadData.*;
import Utilities.Log;
import Utilities.ReadData;
import Utilities.TestBase;
import Utilities.Utils;
import javaMain.common_Functions.OpenMenuesSmart;

public class SMART_Fawri_BeneficiaryManagement extends TestBase{


	public static String editBeneficiary,deleteBeneficiary,OTPProceed,editBeneficiary_Proceed_btn,deleteBeneficiary_Proceed_btn,Nickname;

	public static boolean fawribeneficiarymanagement (String TCName, int ScenarioCount, Object[] tCsDataset)
			throws Exception {
		boolean editBeneficiaryFlag=false;	
		try {

			if (true)
			{

				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + ReadData.getJsonData(TCName, ScenarioCount, "DataSet") + "</mark>");

				editBeneficiary = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "editBeneficiary"));
				deleteBeneficiary = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "deleteBeneficiary"));
				OTPProceed = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "OTPProceed"));
				editBeneficiary_Proceed_btn = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "editBeneficiary_Proceed_btn"));
				deleteBeneficiary_Proceed_btn = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "deleteBeneficiary_Proceed_btn"));
				Nickname = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Nickname"));
				
			} else {

				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + ReadData.getJsonData(TCName, ScenarioCount, "DataSet") + "</mark>");
				editBeneficiary = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("editBeneficiary"));
				deleteBeneficiary = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("deleteBeneficiary"));
				OTPProceed = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("OTPProceed"));
				editBeneficiary_Proceed_btn = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("editBeneficiary_Proceed_btn"));
				deleteBeneficiary_Proceed_btn = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("deleteBeneficiary_Proceed_btn"));
				Nickname = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Nickname"));
			}
			Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "LoadingSpinner", "LogInLandingPage")));
			OpenMenuesSmart.openFawriMenu("FawriBeneficiaryMgmt");
			Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "LoadingSpinner", "LogInLandingPage")));

			try {
				Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "fawriBeneficiaryMgmt_title", "SMART_FAWRI_BENEFICIARY_MANAGEMENT")), "Fawri Beneficiary Management home page"));

				Log.pass(" Fawri Beneficiary Management home page displayed successfully. message displayed is " + Utils.getText(By.xpath(getObj("Propval1", "fawriBeneficiaryMgmt_title", "SMART_FAWRI_BENEFICIARY_MANAGEMENT"))));

				Utils.logPassImage("Fawri Beneficiary Management home page displayed-pass");


			} catch (AssertionError | Exception e) {

				Log.fail("Fawri Beneficiary Management home page not displayed");
				Utils.logFailImage("Fawri Beneficiary Management home page not displayed-fail");

				throw e;

			}
			Utils.click_Smart(By.xpath(getObj("Propval1", "Beneficiary_lnk", "SMART_FAWRI_BENEFICIARY_MANAGEMENT")), "Beneficiary link");
			Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "LoadingSpinner", "LogInLandingPage")));
			Utils.wait(2);
			if (editBeneficiary.equalsIgnoreCase("true"))
			{
				editBeneficiaryFlag=true;
				Utils.click_Smart(By.xpath(getObj("Propval1", "Edit_lnk", "SMART_FAWRI_BENEFICIARY_MANAGEMENT")), "Edit link");
				Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "LoadingSpinner", "LogInLandingPage")));
				String Nickname_updated= RandomStringUtils.randomAlphanumeric(6).toUpperCase();
				Utils.sendKeys_Smart(By.xpath(getObj("Propval1", "NickName_txt", "SMART_FAWRI_BENEFICIARY_MANAGEMENT")),Nickname+Nickname_updated,"Nickname text box");
				if (editBeneficiary_Proceed_btn.equalsIgnoreCase("true")) {
					Utils.click_Smart(By.xpath(getObj("Propval1", "ProceedBtn", "SMART_FAWRI_BENEFICIARY_MANAGEMENT")), "Proceed button");
					Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "LoadingSpinner", "LogInLandingPage")));
					Utils.click_Smart(By.xpath(getObj("Propval1", "ConfirmBtn", "SMART_FAWRI_BENEFICIARY_MANAGEMENT")), "Confirm button");
					Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "LoadingSpinner", "LogInLandingPage")));

					try {
						Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "EditBeneficiary_SuccessMsg", "SMART_FAWRI_BENEFICIARY_MANAGEMENT")), "Success Message on Edit Beneficiary page"));
						Log.pass(" Your Edit Beneficiary request has been completed successfully. Message displayed is : " + Utils.getText(By.xpath(getObj("Propval1", "EditBeneficiary_SuccessMsg", "SMART_FAWRI_BENEFICIARY_MANAGEMENT"))));
						Utils.logPassImage("Edit beneficiary request completed-pass");

					} catch (AssertionError | Exception e) {

						Log.fail("Your Edit Beneficiary request has not completed");
						Utils.logFailImage("Edit beneficiary request not completed-fail");
						throw e;

					}
				}
				else
				{
					Utils.click_Smart(By.xpath(getObj("Propval1", "CancelBtn", "SMART_FAWRI_BENEFICIARY_MANAGEMENT")), "cancel button");
					Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "LoadingSpinner", "LogInLandingPage")));
					try {
						Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "fawriBeneficiaryMgmt_title", "SMART_FAWRI_BENEFICIARY_MANAGEMENT")), "Fawri Beneficiary Management home page"));

						Log.pass("Successfully cancelled the edit beneficiary transaction and Fawri Beneficiary Management home page appearing successfully. message displayed is " + Utils.getText(By.xpath(getObj("Propval1", "fawriBeneficiaryMgmt_title", "SMART_FAWRI_BENEFICIARY_MANAGEMENT"))));

						Utils.logPassImage("Successfully cancelled the edit beneficiary transaction-pass");


					} catch (AssertionError | Exception e) {

						Log.fail("unable to cancel the edit beneficiary transaction");
						Utils.logFailImage("unable to cancel the edit beneficiary transaction-fail");

						throw e;

					}
				}
				

			}
			if (deleteBeneficiary.equalsIgnoreCase("true"))
			{
				if (editBeneficiaryFlag) 
				{
					OpenMenuesSmart.openFawriMenu("FawriBeneficiaryMgmt");
					Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "LoadingSpinner", "LogInLandingPage")));
					Utils.click_Smart(By.xpath(getObj("Propval1", "Beneficiary_lnk", "SMART_FAWRI_BENEFICIARY_MANAGEMENT")), "Beneficiary link");
					Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "LoadingSpinner", "LogInLandingPage")));
					Utils.wait(2);
				}
				Utils.scrollIntoView(By.xpath(getObj("Propval1", "Delete_lnk", "SMART_FAWRI_BENEFICIARY_MANAGEMENT")));
				Utils.click_Smart(By.xpath(getObj("Propval1", "Delete_lnk", "SMART_FAWRI_BENEFICIARY_MANAGEMENT")), "Delete link");
				Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "LoadingSpinner", "LogInLandingPage")));
				if (deleteBeneficiary_Proceed_btn.equalsIgnoreCase("true")) {

					Utils.click_Smart(By.xpath(getObj("Propval1", "ConfirmBtn", "SMART_FAWRI_BENEFICIARY_MANAGEMENT")), "Confirm button");
					Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "LoadingSpinner", "LogInLandingPage")));

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

					try {

						Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "DeleteBeneficiary_SuccessMsg", "SMART_FAWRI_BENEFICIARY_MANAGEMENT")), "Delete Beneficiary Success Message on Delete Beneficiary page"));
						Log.pass(" Your Delete Beneficiary request has been completed successfully. Message displayed is : " + Utils.getText(By.xpath(getObj("Propval1", "DeleteBeneficiary_SuccessMsg", "SMART_FAWRI_BENEFICIARY_MANAGEMENT"))));
						Utils.logPassImage("Delete beneficiary request completed-pass");

					} catch (AssertionError | Exception e) {

						Log.fail("Your Delete Beneficiary request has not completed");
						Utils.logFailImage("Delete beneficiary request not completed-fail");
						throw e;

					}
					
				}
				else
				{
					Utils.click_Smart(By.xpath(getObj("Propval1", "CancelBtn", "SMART_FAWRI_BENEFICIARY_MANAGEMENT")), "cancel button");
					Utils.click_Smart(By.xpath(getObj("Propval1", "Cancel_Yes_Btn", "SMART_FAWRI_BENEFICIARY_MANAGEMENT")), "cancel Yes button");
					Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "LoadingSpinner", "LogInLandingPage")));
					try {
						Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "fawriBeneficiaryMgmt_title", "SMART_FAWRI_BENEFICIARY_MANAGEMENT")), "Fawri Beneficiary Management home page"));

						Log.pass("Successfully cancelled the delete beneficiary transaction and Fawri Beneficiary Management home page appearing successfully. message displayed is " + Utils.getText(By.xpath(getObj("Propval1", "fawriBeneficiaryMgmt_title", "SMART_FAWRI_BENEFICIARY_MANAGEMENT"))));

						Utils.logPassImage("Successfully cancelled the delete beneficiary transaction-pass");


					} catch (AssertionError | Exception e) {

						Log.fail("unable to cancel the delete beneficiary transaction");
						Utils.logFailImage("unable to cancel the delete beneficiary transaction-fail");

						throw e;

					}
				}
			}
			
			
		} catch (AssertionError | Exception e) {
			runResult = false;
			throw e;
		}
		return runResult;
	}
	

}
