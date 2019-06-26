package javaMain.eCorp.selfservice;

import static Utilities.ReadData.ReadDataSQL;
import static Utilities.ReadData.getObj;
import static javaMain.common_Functions.AppData.AfterTxfrAdditionalOptions;
import static javaMain.common_Functions.AppData.Confirm;
import static javaMain.common_Functions.AppData.NewPassword;
import static javaMain.common_Functions.AppData.NewTxn;
import static javaMain.common_Functions.AppData.OTPProceed;
import static javaMain.common_Functions.AppData.OldPassword;
import static javaMain.common_Functions.AppData.Proceed;
import static javaMain.common_Functions.AppData.isNegative;

import org.openqa.selenium.By;
import org.testng.Assert;

import Utilities.Log;
import Utilities.ReadData;
import Utilities.TestBase;
import Utilities.Utils;
import javaMain.common_Functions.JolCommonFunctions;


public class eCorp_SELFSERVICE_CHANGEPASSWORD_FUNC extends TestBase {

	public static Boolean changepassword(String TCName, int ScenarioCount, Object[] tCsDataset) throws Exception {
		
		try {

			if (isMasterClassRun) {

				Log.pass("Data set for this scenario is " + System.lineSeparator() + ReadData.getJsonData(TCName, ScenarioCount, "DataSet"));

				OldPassword = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "OldPassword"));
				NewPassword = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "NewPassword"));
				AfterTxfrAdditionalOptions = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "AfterTxfrAdditionalOptions"));
				Proceed = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Proceed"));
				Confirm = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Confirm"));
				OTPProceed = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "OTPProceed"));
				NewTxn = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "NewTxn"));
				isNegative = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "isNegative"));

			} else {

				Log.pass("Data set for this scenario is " + System.lineSeparator() + dataset[scenarioCount - 1]);
				AfterTxfrAdditionalOptions = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("AfterTxfrAdditionalOptions"));
				OldPassword = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("OldPassword"));
				NewPassword = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("NewPassword"));
				Proceed = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Proceed"));
				Confirm = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Confirm"));
				OTPProceed = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("OTPProceed"));
				NewTxn = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("NewTxn"));
				isNegative = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("isNegative"));

			}
			
			Utils.refreshScreeen();
			Utils.click(By.xpath(getObj("Propval1", "SelfServices", "eCorp_SELFSERVICE_changepassword")), "Self Services");
			Utils.click(By.xpath(getObj("Propval1", "changepassword", "eCorp_SELFSERVICE_changepassword")), "change password");

			// View Status Landed Page
			String ViewStatus = Utils.getText(By.xpath(getObj("Propval1", "LandPage", "eCorp_SELFSERVICE_changepassword")));
			Log.info("Landed Page Title is :" + ViewStatus);

			Utils.sendKeys(By.xpath(getObj("Propval1", "OldPassword", "eCorp_SELFSERVICE_changepassword")), OldPassword, "OldPassword text box");

			Utils.sendKeys(By.xpath(getObj("Propval1", "NewPassword", "eCorp_SELFSERVICE_changepassword")), OldPassword, "NewPassword text box");

			Utils.sendKeys(By.xpath(getObj("Propval1", "ConfirmNewPassword", "eCorp_SELFSERVICE_changepassword")), OldPassword, "ConfirmNewPassword text box");

			if (Integer.parseInt(Proceed) == 1) {
				Utils.click(By.xpath(getObj("Propval1", "proceed", "eCorp_SELFSERVICE_changepassword")), "Proceed");
			} else {
				Utils.click(By.xpath(getObj("Propval1", "cancel", "eCorp_SELFSERVICE_changepassword")), "cancel Proceed");
				Utils.logPassImage(TCName);
				return true;
			}

			if (isNegative.equalsIgnoreCase("true")) {

				try {

					Assert.assertFalse(Utils.assertDisplayed(By.xpath(getObj("Propval1", "confirm", "eCorp_SELFSERVICE_changepassword")), "Confirm page"));
					Log.pass("Not able to navigate to confirm page without enter the right password");
					Utils.logPassImage(TCName);
					return true;

				} catch (AssertionError | Exception e) {

					Log.fail("Unaccepted error occour please review the page");
					Utils.logFailImage(TCName);
					return false;

				}
			}

			if (Integer.parseInt(Confirm) == 1) {
				Utils.click(By.xpath(getObj("Propval1", "confirm", "eCorp_SELFSERVICE_changepassword")), "confirm");
			}

			else if (Integer.parseInt(Confirm) == 2) {

				Utils.click(By.xpath(getObj("Propval1", "modify", "eCorp_SELFSERVICE_changepassword")), "modify");

				Utils.sendKeys(By.xpath(getObj("Propval1", "OldPassword", "eCorp_SELFSERVICE_changepassword")), OldPassword, "OldPassword text box");

				Utils.sendKeys(By.xpath(getObj("Propval1", "NewPassword", "eCorp_SELFSERVICE_changepassword")), OldPassword, "NewPassword text box");

				Utils.sendKeys(By.xpath(getObj("Propval1", "ConfirmNewPassword", "eCorp_SELFSERVICE_changepassword")), OldPassword, "ConfirmNewPassword text box");

				Utils.click(By.xpath(getObj("Propval1", "proceed", "eCorp_SELFSERVICE_changepassword")), "modify Proceed");

				Utils.click(By.xpath(getObj("Propval1", "confirm", "eCorp_SELFSERVICE_changepassword")), "modify confirm");

			}

			else {
				Utils.click(By.xpath(getObj("Propval1", "cancel", "eCorp_SELFSERVICE_changepassword")), "confirm cancel");

				Utils.click(By.xpath(getObj("Propval1", "ConfirmCancel", "eCorp_SELFSERVICE_changepassword")), "cancel");
				Log.pass("Confirm is cancelled successfully");
				Utils.logPassImage(TCName);
				return true;

			}

			if (Integer.parseInt(OTPProceed) == 1) {
				Utils.enterOTPAndProceed("0123");
			} else if (Integer.parseInt(OTPProceed) == 2) {
				Utils.click(By.xpath(getObj("Propval1", "OTPBack", "eCorp_SELFSERVICE_changepassword")), "OTP Back button");
				Utils.click(By.xpath(getObj("Propval1", "confirm", "eCorp_SELFSERVICE_changepassword")), "OTP Back confirm button");
				Utils.enterOTPAndProceed("0123");
			} else {
				Utils.click(By.xpath(getObj("Propval1", "Cancel_OTP", "eCorp_SELFSERVICE_changepassword")), "cancel button on OTP page");

				Utils.click(By.xpath(getObj("Propval1", "OTPCancelConfirm", "eCorp_SELFSERVICE_changepassword")), "cancel confirm button on OTP page");
				Log.pass("OTP is canceled successfully");
				Utils.logPassImage(TCName);
				return true;
			}

			try {
				Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "Message", "eCorp_SELFSERVICE_changepassword")), "Success Message"));
				Log.pass("Self Service Change Password successfully." + Utils.getText(By.xpath(getObj("Propval1", "Message", "eCorp_SELFSERVICE_changepassword"))));
				Utils.logPassImage("Self Service Change Password-Pass");

			} catch (AssertionError | Exception e) {

				Log.fail("Self Service Change Password failed...error...");
				Utils.logFailImage("Self Service Change Password-Fail");
				throw e;
			}

			Utils.wait(5);
			
			if (AfterTxfrAdditionalOptions.equalsIgnoreCase("true")) {
				Log.pass("Starting additional actions after transfer. e.g send email, print and save as favourite.");
				JolCommonFunctions.sendEmailDownloadExcelnPrintFunc(ScenarioCount);
				Log.pass("Additional Actions  like send email, print and download pdf/excel etc have  passed successfully.");
				Utils.logPassImage("Additional Actions");

			}

			if (NewTxn.equalsIgnoreCase("true")) {
				Utils.scrollDownVertically();
				Utils.click(By.xpath(getObj("Propval1", "NewTransactionBtn", "eCorp_SELFSERVICE_changepassword")), "New Transaction");
				int y = Utils.getSize(By.xpath(getObj("Propval1", "proceed", "eCorp_SELFSERVICE_changepassword")));
				if (y > 0) {
					Log.pass("New Transaction is landed successfully");
				} else {
					Log.fail("New Transaction is not landed successfully");

				}

			}

		}

		catch (Exception e) {
			runResult = false;
			throw e;
		}
		return runResult;
	}
	
}
