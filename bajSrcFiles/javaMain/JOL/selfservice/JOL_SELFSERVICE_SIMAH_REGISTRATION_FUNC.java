package javaMain.JOL.selfservice;

import Utilities.Log;
import Utilities.ReadData;
import Utilities.TestBase;
import Utilities.Utils;
import static Utilities.ReadData.*;

import org.openqa.selenium.By;
import org.testng.Assert;

/**
 * Description : Functional Test Script
 * 
 * @author baj80000892
 */
public class JOL_SELFSERVICE_SIMAH_REGISTRATION_FUNC extends TestBase {

	public static Boolean SimahRegistration(String TCName, int ScenarioCount, Object[] tCsDataset) throws Exception {
		String TCButton, Proceed, Confirm, OTPProceed, isNegative, CheckBox, email;
		try {

			if (isMasterClassRun) {

				Log.pass("Data set for this scenario is " + System.lineSeparator() + ReadData.getJsonData(TCName, ScenarioCount, "DataSet"));
				TCButton = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "TCButton"));
				Proceed = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Proceed"));
				Confirm = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Confirm"));
				OTPProceed = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "OTPProceed"));
				isNegative = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "isNegative"));
				email = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "email"));
				CheckBox = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "CheckBox"));
			} else {

				Log.pass("Data set for this scenario is " + System.lineSeparator() + dataset[scenarioCount - 1]);
				TCButton = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("TCButton"));
				Proceed = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Proceed"));
				Confirm = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Confirm"));
				OTPProceed = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("OTPProceed"));
				isNegative = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("isNegative"));
				email = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("email"));
				CheckBox = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("CheckBox"));
			}

			Utils.click(By.xpath(getObj("Propval1", "SelfServices", "JOL_SELFSERVICE_changeUSERNAME")), "Self Services");

			Utils.click(By.xpath(getObj("Propval1", "SimahRegistration", "JOL_SELFSERVICE_changeUSERNAME")), "change email");

			// View Status Landed Page
			String ViewStatus = Utils.getText(By.xpath(getObj("Propval1", "LandPage", "JOL_SELFSERVICE_changeUSERNAME")));
			Log.info("Landed Page Title is :" + ViewStatus);

			if (TCButton.equalsIgnoreCase("True")) {
				if (CheckBox.equalsIgnoreCase("True")) {
					// Click on the terms and Conditions CheckBox Directly//
					Utils.click(By.xpath(getObj("Propval1", "CheckBoxTC", "JOL_SELFSERVICE_changeUSERNAME")), "on Terms and Conditons Button directly");
				} else if (CheckBox.equalsIgnoreCase("False")) {
					// Click on the link of Terms and Conditions//
					Utils.click(By.xpath(getObj("Propval1", "TnCpoup", "JOL_SELFSERVICE_changeUSERNAME")), "which is a link of Terms and Conditions");
					// Click on I Accept Radio of the pop up//
					Utils.click(By.xpath(getObj("Propval1", "TnCAgree", "JOL_SELFSERVICE_changeUSERNAME")), "which is I Accept RadioButton");

				}

			} else if (TCButton.equalsIgnoreCase("False")) {
				// Click on Proceed Button//
				Utils.click(By.xpath(getObj("Propval1", "Proceed", "ApplyCreditCard")), "Proceed Button");
				try {
					// System.out.println(Utils.assertDisplayed(By.xpath(getObj("Propval1",
					// "CreditcardTxt", "ApplyCreditCard")),"false"));
					// This is to validate if the user moves to the next page without selecting
					// Terms and Condition CheckBox//
					Assert.assertEquals(Utils.assertDisplayed(By.xpath(getObj("Propval1", "Confirm", "JOL_SELFSERVICE_changeUSERNAME")), ""), false);
					Log.pass("Successfully validated that user is unable to complete transaction without selecting terms and conditions.");
					Utils.logPassImage(TCName);
					return true;
				} catch (AssertionError | Exception e) {
					Log.fail("Proceeded Further without clicking on Terms and Condtions");
					runResult = false;
					throw e;
				}

			}

			if (Integer.parseInt(Proceed) == 1) {
				Utils.click(By.xpath(getObj("Propval1", "proceed", "JOL_SELFSERVICE_changeUSERNAME")), "Proceed");
			} else {
				Utils.click(By.xpath(getObj("Propval1", "cancel", "JOL_SELFSERVICE_changeUSERNAME")), "cancel");
				Log.pass("No changes in User Name");
				Utils.logPassImage(TCName);
				return true;
			}

			if (isNegative.equalsIgnoreCase("true")) {
				try {

					Assert.assertFalse(Utils.assertDisplayed(By.xpath(getObj("Propval1", "confirm", "JOL_SELFSERVICE_changeUSERNAME")), "Result Details."));
					Log.pass("Search result displayed on screen is :" + Utils.getText(By.xpath(getObj("Propval1", "confirm", "JOL_SELFSERVICE_changeUSERNAME"))));
					Utils.logPassImage(TCName);
					return true;

				} catch (AssertionError | Exception e) {

					Log.pass("No search results displayed on screen. Displayed text is : " + Utils.getText(By.xpath(getObj("Propval1", "confirm", "JOL_SELFSERVICE_changeUSERNAME"))));
					Log.info("Setting other dependent actions like 'showDetails/edit details and skip transactions' as false and exiting test case.");
					Utils.logPassImage(TCName);
					return true;
				}

			}

			int confirm1 = Utils.getSize(By.xpath(getObj("Propval1", "confirm", "JOL_SELFSERVICE_changeUSERNAME")));

			if (confirm1 == 0) {
				Log.fail("Please enter valid email");
				Utils.logPassImage(TCName);
				return false;
			}

			if (Integer.parseInt(Confirm) == 1) {
				Utils.click(By.xpath(getObj("Propval1", "confirm", "JOL_SELFSERVICE_changeUSERNAME")), "confirm");
			}

			else if (Integer.parseInt(Confirm) == 2) {

				Utils.click(By.xpath(getObj("Propval1", "modify", "JOL_SELFSERVICE_changeUSERNAME")), "modify");

				Utils.click(By.xpath(getObj("Propval1", "CheckBoxTC", "JOL_SELFSERVICE_changeUSERNAME")), "on Terms and Conditons Button directly");

				Utils.click(By.xpath(getObj("Propval1", "proceed", "JOL_SELFSERVICE_changeUSERNAME")), "Proceed");

				Utils.click(By.xpath(getObj("Propval1", "confirm", "JOL_SELFSERVICE_changeUSERNAME")), "confirm");

			}

			else {
				Utils.click(By.xpath(getObj("Propval1", "cancel", "JOL_SELFSERVICE_changeUSERNAME")), "cancel");

				Utils.click(By.xpath(getObj("Propval1", "OTPCancelConfirm", "JOL_SELFSERVICE_changeUSERNAME")), "cancel");
				Log.pass("Confirm is cancel successfully");
				Utils.logPassImage(TCName);
				return true;

			}

			if (Integer.parseInt(OTPProceed) == 1) {
				Utils.enterOTPAndProceed("0123");
			} else if (Integer.parseInt(OTPProceed) == 2) {
				Utils.click(By.xpath(getObj("Propval1", "OTPback", "JOL_SELFSERVICE_changeUSERNAME")), "OTP Back");
				Utils.click(By.xpath(getObj("Propval1", "confirm", "JOL_SELFSERVICE_changeUSERNAME")), "OTP Back");
				Utils.enterOTPAndProceed("0123");
			} else {
				Utils.click(By.xpath(getObj("Propval1", "cancel", "JOL_SELFSERVICE_changeUSERNAME")), "OTP Back");
				Utils.click(By.xpath(getObj("Propval1", "OTPCancelYes", "JOL_SELFSERVICE_changeUSERNAME")), "OTP Back");
				Log.pass("OTP is canceled successfully");
				Utils.logPassImage(TCName);
				return true;
			}

			Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "WaitingElements", "JOL_SELFSERVICE_changeUSERNAME")));

			try {
				String z = Utils.getText(By.xpath(getObj("Propval1", "SuccessMessage", "JOL_SELFSERVICE_changeUSERNAME")));
				Log.pass("Message is :" + z);
			} catch (Exception e) {

				Log.fail("Not able to do the registration please try again");
			}
			Utils.logPassImage(TCName);
		}

		catch (Exception e) {
			runResult = false;
			throw e;
		}
		return runResult;
	}

}
