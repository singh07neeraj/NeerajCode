package javaMain.JOL.selfservice;

import Utilities.Input;
import Utilities.Log;
import Utilities.ReadData;
import Utilities.TestBase;
import Utilities.Utils;
import javaMain.common_Functions.AppData;

import static Utilities.ReadData.*;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.openqa.selenium.By;

/**
 * Description : Functional Test Script
 * 
 * @author baj80000892
 */
public class JOL_SELFSERVICE_CHANGE_USERNAME_FUNC extends TestBase {

	public static Boolean changeusername(String TCName, int ScenarioCount, Object[] tCsDataset) throws Exception {
		String Username, Proceed, Confirm, OTPProceed, Password, modifyemail, email;
		try {

			if (true) {

				Log.pass("Data set for this scenario is " + System.lineSeparator()
						+ ReadData.getJsonData(TCName, ScenarioCount, "DataSet"));
				Username = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Username"));
				Proceed = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Proceed"));
				Confirm = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Confirm"));
				OTPProceed = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "OTPProceed"));
				Password = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Password"));
				email = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "email"));
				modifyemail = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "modifyemail"));
			} else {

				Log.pass("Data set for this scenario is " + System.lineSeparator() + dataset[scenarioCount - 1]);
				Username = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Username"));
				Proceed = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Proceed"));
				Confirm = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Confirm"));
				OTPProceed = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("OTPProceed"));
				Password = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Password"));
				email = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("email"));
				modifyemail = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("modifyemail"));
			}

			Utils.click(By.xpath(getObj("Propval1", "SelfServices", "JOL_SELFSERVICE_changeUSERNAME")),
					"Self Services");

			Utils.click(By.xpath(getObj("Propval1", "changusername", "JOL_SELFSERVICE_changeUSERNAME")),
					"change email");

			// View Status Landed Page
			String ViewStatus = Utils
					.getText(By.xpath(getObj("Propval1", "LandPage", "JOL_SELFSERVICE_changeUSERNAME")));
			Log.info("Landed Page Title is :" + ViewStatus);

			// Enter User Name
			Utils.sendKeys(By.xpath(getObj("Propval1", "Newusername", "JOL_SELFSERVICE_changeUSERNAME")), AppData.getUsername(), "User Name");

			// Enter User Name
			Utils.sendKeys(By.xpath(getObj("Propval1", "CurrentPassword", "JOL_SELFSERVICE_changeUSERNAME")), AppData.getPassword(), "Password");

			if (Integer.parseInt(Proceed) == 1) {
				Utils.click(By.xpath(getObj("Propval1", "proceed", "JOL_SELFSERVICE_changeUSERNAME")), "Proceed");
			} else {
				Utils.click(By.xpath(getObj("Propval1", "cancel", "JOL_SELFSERVICE_changeUSERNAME")), "cancel");
				Log.pass("No changes in User Name");
				Utils.logPassImage(TCName);
				return true;
			}

			int confirm1 = Utils.getSize(By.xpath(getObj("Propval1", "confirm", "JOL_SELFSERVICE_changeUSERNAME")));

			if (confirm1 == 0) {
				Log.fail("Please enter valid email");
				return false;
			}

			if (Integer.parseInt(Confirm) == 1) {
				Utils.click(By.xpath(getObj("Propval1", "confirm", "JOL_SELFSERVICE_changeUSERNAME")), "confirm");
			}

			else if (Integer.parseInt(Confirm) == 2) {

				Utils.click(By.xpath(getObj("Propval1", "modify", "JOL_SELFSERVICE_changeUSERNAME")), "modify");

				
				Utils.click(By.xpath(getObj("Propval1", "proceed", "JOL_SELFSERVICE_changeUSERNAME")), "Proceed");

				Utils.click(By.xpath(getObj("Propval1", "confirm", "JOL_SELFSERVICE_changeUSERNAME")), "confirm");

			}

			else {
				Utils.click(By.xpath(getObj("Propval1", "cancel", "JOL_SELFSERVICE_changeUSERNAME")), "cancel");

				Utils.click(By.xpath(getObj("Propval1", "OTPCancelConfirm", "JOL_SELFSERVICE_changeUSERNAME")),
						"cancel");
				Log.pass("Confirm is cancel successfully");
				return true;

			}

			if (Integer.parseInt(OTPProceed) == 1) {
				Utils.enterOTPAndProceed("0123");
			} else if (Integer.parseInt(OTPProceed) == 2) {
				Utils.click(By.xpath(getObj("Propval1", "OTPback", "JOL_SELFSERVICE_changeUSERNAME")), "OTP Back");
				Utils.click(By.xpath(getObj("Propval1", "confirm", "JOL_SELFSERVICE_changeUSERNAME")), "OTP Back");
				Utils.enterOTPAndProceed("0123");
			} else {
				Utils.click(By.xpath(getObj("Propval1", "cancel", "JOL_SELFSERVICE_changeUSERNAME")), 		"OTP Back");
				Utils.click(By.xpath(getObj("Propval1", "OTPCancelYes", "JOL_SELFSERVICE_changeUSERNAME")),	"OTP Back");
				Log.pass("OTP is canceled successfully");
				return true;
			}

			Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "WaitingElements", "JOL_SELFSERVICE_changeUSERNAME")));
			
			String z = Utils.getText(By.xpath(getObj("Propval1", "SuccessMessage", "JOL_SELFSERVICE_changeUSERNAME")));
			Log.pass("Message is :"+z);
			
			Utils.logPassImage(TCName);
		}

		catch (Exception e) {
			runResult = false;
			throw e;
		}
		return runResult;
	}

	
}
