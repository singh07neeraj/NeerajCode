package javaMain.JOL.accounts;

import static Utilities.ReadData.ReadDataSQL;
import static Utilities.ReadData.getObj;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.openqa.selenium.By;
import org.testng.Assert;

import Utilities.Input;
import Utilities.Log;
import Utilities.ReadData;
import Utilities.TestBase;
import Utilities.Utils;
import javaMain.common_Functions.JolCommonFunctions;
import static  javaMain.common_Functions.AppData.*;
/**
 * Description : Functional Test Script
 * 
 * @author baj80000892
 */
public class JOL_ACCOUNTS_SUMMARY_INQUIRY_FUNC extends TestBase {

	public static boolean JolAccountsSummaryEnquiryFunction(String TCName, int ScenarioCount, Object[] tCsDataset) throws Exception {

		try {

			if (isMasterClassRun) {

				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + ReadData.getJsonData(TCName, ScenarioCount, "DataSet") + "</mark>");
				AccountCofig = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "AccountCofig"));
				NickNameCancelSave = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "NickNameCancelSave"));
				otherActions = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "otherActions"));

			}

			else {

				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + ReadData.getJsonData(TCName, ScenarioCount, "DataSet") + "</mark>");
				AccountCofig = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("AccountCofig"));
				NickNameCancelSave = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("NickNameCancelSave"));
				otherActions = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("otherActions"));

			}

			// click on Account Top
			Utils.click(By.xpath(getObj("Propval1", "Accounts", "JOL_ACCOUNTS_SUMMARY_INQUIRY")), "Accounts link");
			// Click on Account Summary
			Utils.click(By.xpath(getObj("Propval1", "summary", "JOL_ACCOUNTS_SUMMARY_INQUIRY")), "Accounts Summary link");

						
			String NicknameChange = "//*[contains(text(),'" + Input.ReadTestData(TCName, "AccountNumber") + "')]//parent::td[1]/following-sibling::td[1]/a";

			if (Integer.parseInt(NickNameCancelSave) == 1) {
				Utils.wait(2);
				// Cancel Save Nick Name
				Utils.click(By.xpath(NicknameChange), "Click on nick name");

				Utils.click(By.xpath(getObj("Propval1", "NickNameCancel", "JOL_ACCOUNTS_SUMMARY_INQUIRY")), "Cancel Nick Name");
				Log.pass("Nick name popup  Canceled  successfully");
				return true;

			}
			if (Integer.parseInt(NickNameCancelSave) == 2) {

				Utils.wait(2);
				// Click nickname
				Utils.click(By.xpath(NicknameChange), "Click on nick name");

				Utils.ClearText(By.xpath(getObj("Propval1", "NickName", "JOL_ACCOUNTS_SUMMARY_INQUIRY")));

				Utils.sendKeys(By.xpath(getObj("Propval1", "NickName", "JOL_ACCOUNTS_SUMMARY_INQUIRY")), Input.ReadTestData(TCName, "Nickname"), "Nickname");

				Utils.click(By.xpath(getObj("Propval1", "NickNameSave", "JOL_ACCOUNTS_SUMMARY_INQUIRY")), "Save nick Name");

				Utils.pressEnter();
			}
			if (otherActions.equalsIgnoreCase("true")) {
				
				JolCommonFunctions.sendEmailDownloadExcelnPrintFunc(ScenarioCount);
			}
			String AccountDetails = "//*[contains(text(),'" + Input.ReadTestData(TCName, "AccountNumber") + "')]";

			Utils.click(By.xpath(AccountDetails), "Click on Account Number");
			Utils.waitForInVisibilityOfEle(By.xpath("//*[@id='overlayInfo']"));
			
			try {
				Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "DetailsPage", "JOL_ACCOUNTS_SUMMARY_INQUIRY")), "Accounts details home page"));

				Log.pass(" Accounts details home page displayed successfully. message displayed is " + Utils.getText(By.xpath(getObj("Propval1", "DetailsPage", "JOL_ACCOUNTS_SUMMARY_INQUIRY"))));

				Utils.logPassImage("Accounts details home page displayed-pass");


			} catch (AssertionError | Exception e) {

				Log.fail("Accounts details home page not displayed");
				Utils.logFailImage("Accounts details home page not displayed-fail");

				throw e;

			}
			Utils.wait(2);
			// Click on Account Summary
			Utils.click(By.xpath(getObj("Propval1", "summary", "JOL_ACCOUNTS_SUMMARY_INQUIRY")), "Accounts Summary link");

			// Account Configuration page
			if (Integer.parseInt(AccountCofig) == 1) {
				Utils.click(By.xpath(getObj("Propval1", "AccountConfig", "JOL_ACCOUNTS_SUMMARY_INQUIRY")), "Accounts Configuration button");
				Utils.waitForInVisibilityOfEle(By.xpath("//*[@id='overlayInfo']"));
				
				try {
					Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "AccountConfigSaveButton", "JOL_ACCOUNTS_SUMMARY_INQUIRY")), "Accounts configuration home page"));

					Log.pass(" Accounts configuration home page displayed successfully. message displayed is " + Utils.getText(By.xpath(getObj("Propval1", "AccountConfigSaveButton", "JOL_ACCOUNTS_SUMMARY_INQUIRY"))));

					Utils.logPassImage("Accounts configuration home page displayed-pass");


				} catch (AssertionError | Exception e) {

					Log.fail("Accounts configuration home page not displayed");
					Utils.logFailImage("Accounts configuration home page not displayed-fail");

					throw e;

				}
				
			}

		}

		catch (AssertionError | Exception e) {
			runResult = false;
			e.printStackTrace();
			throw e;
		}
		return runResult;
	}


}
