package javaMain.smart.accounts;

import static Utilities.Input.ReadTestData;
import static Utilities.ReadData.ReadDataSQL;
import static Utilities.ReadData.getObj;

import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Utilities.Input;
import Utilities.Log;
import Utilities.ReadData;
import Utilities.TestBase;
import Utilities.Utils;
import javaMain.common_Functions.AppData;
import javaMain.common_Functions.OpenMenuesSmart;
import static javaMain.common_Functions.AppData.*;


public class SMART_ACCOUNT_REQUEST_STEMENT_BYMAIL_FUNC extends TestBase {
	static String AccountDetails;
	public static Boolean smartaccountemail(String TCName, int ScenarioCount, Object[] tCsDataset) throws Exception {

		String AccountNumber,StartDate_Date_Previous,StartDate_Month_Previous,StartDate_Year_Previous,StartDate_Date_Future,StartDate_Month_Future,StartDate_Year_Future,Proceed;
		try {

			if (isMasterClassRun) {

				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + ReadData.getJsonData(TCName, ScenarioCount, "DataSet") + "</mark>");
				AccountNumber = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "AccountNumber"));
				StartDate_Date_Previous = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "StartDate_Date_Previous"));
				StartDate_Month_Previous = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "StartDate_Month_Previous"));
				StartDate_Year_Previous = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "StartDate_Year_Previous"));
				StartDate_Date_Future = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "StartDate_Date_Future"));
				StartDate_Month_Future = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "StartDate_Month_Future"));
				StartDate_Year_Future = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "StartDate_Year_Future"));
				Proceed = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Proceed"));
				//runLanguage= Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "runLanguage"));

			}

			else {

				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + dataset[scenarioCount - 1] + "</mark>");
				AccountNumber = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("AccountNumber"));
				StartDate_Date_Previous = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("StartDate_Date_Previous"));
				StartDate_Month_Previous = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("StartDate_Month_Previous"));
				StartDate_Year_Previous= Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("StartDate_Year_Previous"));
				StartDate_Date_Future = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("StartDate_Date_Future"));
				StartDate_Month_Future = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("StartDate_Month_Future"));
				StartDate_Year_Future= Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("StartDate_Year_Future"));
				Proceed = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Proceed"));
				//runLanguage = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("runLanguage"));

			}

			Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "LoadingSpinner", "LogInLandingPage")));
			Utils.clickSafely(By.xpath("//*[contains(@class,'closeLabel')]"), "close alert");	
			
			OpenMenuesSmart.openAccountMenu("RequestStatementByMail");
			Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "LoadingSpinner", "LogInLandingPage")));


			try {
				Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "RequestStmtByMail_title", "SMART_ACCOUNT_REQUEST_STEMENT_BYMAIL")), "Request stmt by mail home page"));

				Log.pass(" Request Statement by mail home page appearing successfully. message displayed is " + Utils.getText(By.xpath(getObj("Propval1", "RequestStmtByMail_title", "SMART_ACCOUNT_REQUEST_STEMENT_BYMAIL"))));

				Utils.logPassImage("Request Statement by mail home page-pass");


			} catch (AssertionError | Exception e) {

				Log.fail("Request Statement by mail home page not appearing");
				Utils.logFailImage("Request Statement by mail home page-fail");

				throw e;

			}


			AccountDetails="//p[contains(text(),'"+AccountNumber+"')]";

			Utils.click_Smart(By.xpath(AccountDetails), "Click on Account Number");
			Utils.wait(2);
			if (AppData.getLanguage().equalsIgnoreCase("Arabic")) 
			{
				//Utils.click_Smart(By.xpath(getObj("Propval1", "StartDate_lnk", "SMART_ACCOUNT_REQUEST_STEMENT_BYMAIL")), "Start date link");	
				Changedate_Smart(StartDate_Date_Previous, "DateDecreasing_clk_AB", "SMART_ACCOUNT_REQUEST_STEMENT_BYMAIL", " '-' button to select previous date");
				Changedate_Smart(StartDate_Month_Previous, "MonthDecreasing_clk_AB", "SMART_ACCOUNT_REQUEST_STEMENT_BYMAIL", " '-' button to select previous Month");
				Changedate_Smart(StartDate_Year_Previous, "YearDecreasing_clk_AB", "SMART_ACCOUNT_REQUEST_STEMENT_BYMAIL", " '-' button to select previous Year");
				Changedate_Smart(StartDate_Date_Future, "DateIncreasing_clk_AB", "SMART_ACCOUNT_REQUEST_STEMENT_BYMAIL", " '+' button to select future date");
				Changedate_Smart(StartDate_Month_Future, "MonthIncreasing_clk_AB", "SMART_ACCOUNT_REQUEST_STEMENT_BYMAIL", " '+' button to select future month");
				Changedate_Smart(StartDate_Year_Future, "YearIncreasing_clk_AB", "SMART_ACCOUNT_REQUEST_STEMENT_BYMAIL", " '+' button to select future Year");
			} else
			{
				//Utils.click_Smart(By.xpath(getObj("Propval1", "StartDate_lnk", "SMART_ACCOUNT_REQUEST_STEMENT_BYMAIL")), "Start date link");	
				Changedate_Smart(StartDate_Date_Previous, "DateDecreasing_clk", "SMART_ACCOUNT_REQUEST_STEMENT_BYMAIL", " '-' button to select previous date");
				Changedate_Smart(StartDate_Month_Previous, "MonthDecreasing_clk", "SMART_ACCOUNT_REQUEST_STEMENT_BYMAIL", " '-' button to select previous Month");
				Changedate_Smart(StartDate_Year_Previous, "YearDecreasing_clk", "SMART_ACCOUNT_REQUEST_STEMENT_BYMAIL", " '-' button to select previous Year");
				Changedate_Smart(StartDate_Date_Future, "DateIncreasing_clk", "SMART_ACCOUNT_REQUEST_STEMENT_BYMAIL", " '+' button to select future date");
				Changedate_Smart(StartDate_Month_Future, "MonthIncreasing_clk", "SMART_ACCOUNT_REQUEST_STEMENT_BYMAIL", " '+' button to select future month");
				Changedate_Smart(StartDate_Year_Future, "YearIncreasing_clk", "SMART_ACCOUNT_REQUEST_STEMENT_BYMAIL", " '+' button to select future Year");
			}
			


			if (Proceed.equalsIgnoreCase("true")) {

				Utils.click(By.xpath(getObj("Propval1", "ProceedBtn", "SMART_ACCOUNT_REQUEST_STEMENT_BYMAIL")), "Proceed button");	

			}
			else
			{
				Utils.click(By.xpath(getObj("Propval1", "cancel", "SMART_ACCOUNT_REQUEST_STEMENT_BYMAIL")), "cancel button");	

				try {
					Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "Homepage_OnCancel", "SMART_ACCOUNT_REQUEST_STEMENT_BYMAIL")), "Home page"));
					Log.pass("Successfully cancelled the Request statement by mail and navigated to home page.");
					Utils.logPassImage("Cancelled Request statement by mail Transaction");
					return true;

				} catch (AssertionError | Exception e) {

					Log.fail("Unable to cancel transaction..error..");
					Utils.logFailImage("Unable to cancel transaction..error.");
					throw e;

				}
				

			}
			Utils.wait(5);
			Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "LoadingSpinner", "LogInLandingPage")));
			Utils.wait(5);
			try {
				Assert.assertFalse(Utils.assertDisplayed(By.xpath(getObj("Propval1", "WrongDate_Alert", "SMART_ACCOUNT_REQUEST_STEMENT_BYMAIL")), "Date on Execution Page"));
				Log.pass("Date entered which is valid. Able to proceed to next page");
				Utils.logPassImage("Date entered which is valid-pass");


			} catch (AssertionError | Exception e) {

				Log.fail(" Invalid date enetered, please enter the valid date. Not able to proceed to next page");
				Utils.logFailImage("Invalid date enetered-fail");

				throw e;

			}
			
			try {
				Assert.assertFalse(Utils.assertDisplayed(By.xpath(getObj("Propval1", "NoTransactionsFound_ErrorMsg", "SMART_ACCOUNT_REQUEST_STEMENT_BYMAIL")), "Error message on Execution Page"));
				Log.pass("Confirmation page appearing as expected");
				Utils.logPassImage("Confirmation page appearing as expected-pass");


			} catch (AssertionError | Exception e) {

				Log.fail(" No transactions founds on execution page . Message displayed is : " + Utils.getText(By.xpath(getObj("Propval1", "NoTransactionsFound_ErrorMsg", "SMART_ACCOUNT_REQUEST_STEMENT_BYMAIL"))));
				Utils.logFailImage("No transactions founds on execution page-fail");

				throw e;

			}

			Utils.click(By.xpath(getObj("Propval1", "Confirm", "SMART_ACCOUNT_REQUEST_STEMENT_BYMAIL")), "Confirm button");
			Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "LoadingSpinner", "LogInLandingPage")));


			try {
				Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "ReqStmtByMail_SuccessMsg", "SMART_ACCOUNT_REQUEST_STEMENT_BYMAIL")), "Rquest Stmt by mail results page"));
				Log.pass(" Your Statement By Mail request has been completed successfully. Message displayed is : " + Utils.getText(By.xpath(getObj("Propval1", "ReqStmtByMail_SuccessMsg", "SMART_ACCOUNT_REQUEST_STEMENT_BYMAIL"))));
				Utils.logPassImage("  Your Statement By Mail request Successful-pass");
				//return true;

			} catch (AssertionError | Exception e) {

				Log.fail("Your Statement By Mail request not Successful. Should have failed.");
				Utils.logFailImage(" Your Statement By Mail request not Successful-fail");
				throw e;

			}


		}

		catch (AssertionError | Exception e)  {
			runResult = false;
			e.printStackTrace();
			throw e;
		}

		return runResult;
	}
	public static boolean Changedate_Smart(String Datetype, String ElementName, String PageName, String Description) throws Exception {

		try {
			Utils.wait(2);
			for (int i = 0; i < Integer.parseInt(Datetype); i++) {
				Utils.click_Smart(By.xpath(getObj("Propval1", ElementName, PageName)), Description);	

			}
		}

		catch (Exception e) {
			Log.error("Unable to change date" + ExceptionUtils.getStackTrace(e));
			Utils.logFailImage("Error");
			runResult = false;
			throw e;

		}

		return runResult;
	}
	
	
}
