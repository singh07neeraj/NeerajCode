package javaMain.JOL.accounts;

import static Utilities.ReadData.ReadDataSQL;
import static Utilities.ReadData.getObj;
import static javaMain.common_Functions.AppData.AdditionalActions;
import static javaMain.common_Functions.AppData.Confirm;
import static javaMain.common_Functions.AppData.OTPProceed;
import static javaMain.common_Functions.AppData.Proceed;
import static javaMain.common_Functions.AppData.isTermsNconditionsChecked;
import static javaMain.common_Functions.AppData.selectTnCfrompopup;
import static javaMain.common_Functions.AppData.termConditions;

import org.openqa.selenium.By;
import org.testng.Assert;

import Utilities.Input;
import Utilities.Log;
import Utilities.ReadData;
import Utilities.TestBase;
import Utilities.Utils;
import javaMain.common_Functions.JolCommonFunctions;

/**
 * Description : Functional Test Script
 * 
 * @author baj80000892
 */
public class JOL_ACCOUNT_OPEN_ADDITIONAL_ACCOUNT_FUNC extends TestBase {

	public static boolean OpenAccount(String TCName, int ScenarioCount, Object[] tCsDataset) throws Exception {

		try {

			if (isMasterClassRun) {
				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + ReadData.getJsonData(TCName, ScenarioCount, "DataSet") + "</mark>");
				Proceed = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Proceed"));
				Confirm = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Confirm"));
				termConditions = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "termConditions"));
				selectTnCfrompopup = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "selectTnCfrompopup"));
				OTPProceed = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "OTPProceed"));
				isTermsNconditionsChecked = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "isTermsNconditionsChecked"));

			}

			else {
				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + dataset[scenarioCount - 1] + "</mark>");
				Proceed = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Proceed"));
				Confirm = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Confirm"));
				termConditions = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("termConditions"));
				selectTnCfrompopup = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("selectTnCfrompopup"));
				OTPProceed = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("OTPProceed"));
				isTermsNconditionsChecked = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("isTermsNconditionsChecked"));
			}

			Utils.click(By.xpath(getObj("Propval1", "Accounts", "JOL_ACCOUNT_OPEN_ADDITIONAL_ACCOUNT")), "Accounts link");
			// Click on Open Additional Account
			Utils.click(By.xpath(getObj("Propval1", "openAccount", "JOL_ACCOUNT_OPEN_ADDITIONAL_ACCOUNT")), "Open Additional Account link");
			Utils.waitForInVisibilityOfEle(By.xpath("//*[@id='overlayInfo']"));
			
						
			// Clear Currecny
			Utils.ClearText(By.xpath(getObj("Propval1", "Currency", "JOL_ACCOUNT_OPEN_ADDITIONAL_ACCOUNT")));
			// Select Currency
			Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "CurrencyDropdown", "JOL_ACCOUNT_OPEN_ADDITIONAL_ACCOUNT")), By.xpath(getObj("Propval1", "Currency", "JOL_ACCOUNT_OPEN_ADDITIONAL_ACCOUNT")),
					Input.ReadTestData(TCName, "Currency"),"Currency Dropdown");

			// Clear Accounts
			Utils.ClearText(By.xpath(getObj("Propval1", "Account", "JOL_ACCOUNT_OPEN_ADDITIONAL_ACCOUNT")));
			// Select Account
			Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "AccountDropdown", "JOL_ACCOUNT_OPEN_ADDITIONAL_ACCOUNT")), By.xpath(getObj("Propval1", "Account", "JOL_ACCOUNT_OPEN_ADDITIONAL_ACCOUNT")),
					Input.ReadTestData(TCName, "AccountNumber"),"Account Dropdown");

			// User trying to complete transaction without checking terms and conditions.

			if (isTermsNconditionsChecked.equalsIgnoreCase("false")) {

				Utils.click(By.xpath(getObj("Propval1", "Proceed", "JOL_ACCOUNT_OPEN_ADDITIONAL_ACCOUNT")), "Proceed button");
				Utils.scrollDownVertically();
				Utils.wait(3);

				try {
					Assert.assertFalse(Utils.assertDisplayed(By.xpath(getObj("Propval1", "Confirm", "JOL_ACCOUNT_OPEN_ADDITIONAL_ACCOUNT")), "Confirm"));
					Log.pass(" User is unable to complete'Open Additional Account' without accepting terms and conditions as expected.Terminating transaction.");
					Utils.logPassImage("Open Additional Account- TermsnConditions -unchecked-pass");
					Utils.click(By.xpath(getObj("Propval1", "Cancel", "JOL_ACCOUNT_OPEN_ADDITIONAL_ACCOUNT")), "Cancel button");
					Log.pass("Open Additional Account cancelled successfully");
					return true;

				} catch (AssertionError | Exception e) {

					Log.fail("User was able toOpen Additional Account even without accepting terms and conditions.. Test case failed.");
					Utils.logFailImage("Open Additional Account- TermsnConditions -unchecked- fail");
					throw e;

				}

			}

			if (Integer.parseInt(Proceed) == 1) {
				// Click on Proceed Button
				Utils.click(By.xpath(getObj("Propval1", "Proceed", "JOL_ACCOUNT_OPEN_ADDITIONAL_ACCOUNT")), "Proceed button");

			} else {

				Utils.click(By.xpath(getObj("Propval1", "Cancel", "JOL_ACCOUNT_OPEN_ADDITIONAL_ACCOUNT")), "Cancel button");
				Log.pass("Successfully cancelled the transaction as required.");

				return true;
			}

			if (Integer.parseInt(Confirm) == 1) {

				if (termConditions.equalsIgnoreCase("true")) {

					if (selectTnCfrompopup.equalsIgnoreCase("false")) {
						// Click on Confirm Button
						Utils.click(By.xpath(getObj("Propval1", "checkbox", "JOL_ACCOUNT_OPEN_ADDITIONAL_ACCOUNT")), "Terms and Conditions checkbox");
						Utils.wait(3);
						// Click on Confirm Button
						Utils.click(By.xpath(getObj("Propval1", "Confirm", "JOL_ACCOUNT_OPEN_ADDITIONAL_ACCOUNT")), "Confirm button");
				

					} else {
						// Click on Confirm Button
						Utils.click(By.xpath(getObj("Propval1", "TnCpoup", "JOL_ACCOUNT_OPEN_ADDITIONAL_ACCOUNT")), "Terms and Conditions checkbox Pop UP");
						Utils.wait(3);
						Utils.click(By.xpath(getObj("Propval1", "TnCAgree", "JOL_ACCOUNT_OPEN_ADDITIONAL_ACCOUNT")), "Terms and Conditions checkbox Pop Up Agree");

						Log.pass("Successfully clicked on agree with T&C popup");
						Utils.wait(3);
						// Click on Confirm Button
						Utils.click(By.xpath(getObj("Propval1", "Confirm", "JOL_ACCOUNT_OPEN_ADDITIONAL_ACCOUNT")), "Confirm button");
					}
				}

			} else if (Integer.parseInt(Confirm) == 2) {
				// Click on Modify
				Utils.click(By.xpath(getObj("Propval1", "Modfy", "JOL_ACCOUNT_OPEN_ADDITIONAL_ACCOUNT")), "Modify button");
				// Modify Currency
				Utils.ClearText(By.xpath(getObj("Propval1", "Currency", "JOL_ACCOUNT_OPEN_ADDITIONAL_ACCOUNT")));
				// Select Currency
				Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "CurrencyDropdown", "JOL_ACCOUNT_OPEN_ADDITIONAL_ACCOUNT")), By.xpath(getObj("Propval1", "Currency", "JOL_ACCOUNT_OPEN_ADDITIONAL_ACCOUNT")),
						Input.ReadTestData(TCName, "ModifyCurrency"));

				// Clear Accounts
				Utils.ClearText(By.xpath(getObj("Propval1", "Account", "JOL_ACCOUNT_OPEN_ADDITIONAL_ACCOUNT")));
				// Select Account
				Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "AccountDropdown", "JOL_ACCOUNT_OPEN_ADDITIONAL_ACCOUNT")), By.xpath(getObj("Propval1", "Account", "JOL_ACCOUNT_OPEN_ADDITIONAL_ACCOUNT")),
						Input.ReadTestData(TCName, "ModifyAccountNumber"));

				// Click on Proceed
				Utils.click(By.xpath(getObj("Propval1", "Proceed", "JOL_ACCOUNT_OPEN_ADDITIONAL_ACCOUNT")), "proceed button");

				// ..........

				Utils.click(By.xpath(getObj("Propval1", "checkbox", "JOL_ACCOUNT_OPEN_ADDITIONAL_ACCOUNT")), "Terms and Conditions checkbox");

				// Click on Confirm Button
				Utils.click(By.xpath(getObj("Propval1", "Confirm", "JOL_ACCOUNT_OPEN_ADDITIONAL_ACCOUNT")), "Confirm button");

			} else {
				Utils.click(By.xpath(getObj("Propval1", "Cancel", "JOL_ACCOUNT_OPEN_ADDITIONAL_ACCOUNT")), "Cancel button");
				Utils.click(By.xpath(getObj("Propval1", "Cancelyes", "JOL_ACCOUNT_OPEN_ADDITIONAL_ACCOUNT")), "CancelYes button");
				Log.pass("Successfully cancelled transaction");
				return true;

			}

			// Enter OTP
			if (Integer.parseInt(OTPProceed) == 1) {
				
				Utils.enterOTPAndProceed();
				
			} else if (Integer.parseInt(OTPProceed) == 2) {
				
				Utils.click(By.xpath(getObj("Propval1", "OTPBack", "JOL_ACCOUNT_OPEN_ADDITIONAL_ACCOUNT")), "OTP Back");
				Utils.click(By.xpath(getObj("Propval1", "checkbox", "JOL_ACCOUNT_OPEN_ADDITIONAL_ACCOUNT")), "Terms and Conditions checkbox");
				Utils.click(By.xpath(getObj("Propval1", "Confirm", "JOL_ACCOUNT_OPEN_ADDITIONAL_ACCOUNT")), "Confirm button");
				Utils.enterOTPAndProceed();

			} else {

				Utils.click(By.xpath(getObj("Propval1", "OTPCancel", "JOL_ACCOUNT_OPEN_ADDITIONAL_ACCOUNT")), "OTP Cancel");
				Utils.wait(2);
				Utils.click(By.xpath(getObj("Propval1", "OTPCancelConfirm", "JOL_ACCOUNT_OPEN_ADDITIONAL_ACCOUNT")), "OTP Cancel- Confirm Button");
				Log.pass("Successfully cancelled the transaction. Exiting test case flow.");
				return true;
			}

			try {
				Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "SuccessMsg", "JOL_ACCOUNT_OPEN_ADDITIONAL_ACCOUNT")), " Success Message"));
				Log.pass(" Your Open Additional Account request has been completed successfully." + Utils.getText(By.xpath(getObj("Propval1", "SuccessMsg", "JOL_ACCOUNT_OPEN_ADDITIONAL_ACCOUNT"))));
				Utils.logPassImage("Open Additional Account request- Pass");

			} catch (AssertionError | Exception e) {

				Log.fail(" Unable to Open Account... error message displayed on the screen is : " + Utils.getText(By.xpath(getObj("Propval1", "ErrorMsg", "JOL_ACCOUNT_OPEN_ADDITIONAL_ACCOUNT"))));
				Utils.logFailImage("Open Additional Account -Fail");
				throw e;

			}

			if (AdditionalActions.contentEquals("true")) {
				JolCommonFunctions.addFavSendEmailDownloadPdfNprintFunc(Input.ReadTestData(TCName, "NickName"));
			}

		} catch (AssertionError | Exception e) {
			runResult = false;
			e.printStackTrace();
			throw e;
		}

		return runResult;
	}

}
