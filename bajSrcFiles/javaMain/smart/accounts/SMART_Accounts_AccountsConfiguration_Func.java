package javaMain.smart.accounts;

import static Utilities.ReadData.ReadDataSQL;
import static Utilities.ReadData.getObj;

import org.openqa.selenium.By;
import org.testng.Assert;

import Utilities.Log;
import Utilities.ReadData;
import Utilities.TestBase;
import Utilities.Utils;
import javaMain.common_Functions.OpenMenuesSmart;
import static javaMain.common_Functions.AppData.*;

public class SMART_Accounts_AccountsConfiguration_Func extends TestBase {
	static String AccountDetails;

	public static boolean SmartAccounts_AccountsConfiguration(String TCName, int ScenarioCount, Object[] tCsDataset) throws Exception {

		try {

			if (isMasterClassRun) {

				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + ReadData.getJsonData(TCName, ScenarioCount, "DataSet") + "</mark>");
				AccountNumber = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "AccountNumber"));
				AccountInfoUpdate = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "AccountInfoUpdate"));

			}

			else {

				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + dataset[scenarioCount - 1] + "</mark>");

				AccountNumber = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("AccountNumber"));
				AccountInfoUpdate = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("AccountInfoUpdate"));
			}

			Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "LoadingSpinner", "LogInLandingPage")));

			Utils.wait(5);
			OpenMenuesSmart.openAccountMenu("AccountsConfiguration");

			Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "LoadingSpinner", "LogInLandingPage")));

			try {
				Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "AccountsConfiguration_title", "SMART_ACCOUNTS_CONFIGURATION")), "Accounts Configuration home page"));

				Log.pass(" Accounts Configuration home page appearing successfully. message displayed is " + Utils.getText(By.xpath(getObj("Propval1", "AccountsConfiguration_title", "SMART_ACCOUNTS_CONFIGURATION"))));

				Utils.logPassImage("Accounts Configuration home page-pass");

			} catch (AssertionError | Exception e) {

				Log.fail("Accounts Configuration home page not appearing");
				Utils.logFailImage("Accounts Configuration home page-fail");

				throw e;

			}

			Utils.click(By.xpath(getObj("Propval1", "CurrentAcct_lnk", "SMART_ACCOUNTS_CONFIGURATION")), "Current Acct link");

			AccountDetails = "//p[contains(text(),'" + AccountNumber + "')]";

			Utils.click(By.xpath(AccountDetails), "Click on Account Number");

			Utils.click(By.xpath(getObj("Propval1", "ShowInquiries_clk", "SMART_ACCOUNTS_CONFIGURATION")), "Show Inquiries");

			Utils.click(By.xpath(getObj("Propval1", "ShowInquiries_clk", "SMART_ACCOUNTS_CONFIGURATION")), "Show Inquiries");
			if (AccountInfoUpdate.equalsIgnoreCase("true")) {
				Utils.click(By.xpath(getObj("Propval1", "Save_btn", "SMART_ACCOUNTS_CONFIGURATION")), "Save btn");
				Log.pass("Accounts details has been updated successfully");
				Utils.logPassImage("Accounts details has been updated successfully-pass");

			} else {
				Utils.click(By.xpath(getObj("Propval1", "Cancel_btn", "SMART_ACCOUNTS_CONFIGURATION")), "Cancel btn");
				return runResult;
			}

		}

		catch (Exception e) {
			runResult = false;
			e.printStackTrace();
			throw e;
		}
		return runResult;
	}

}
