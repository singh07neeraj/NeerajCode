package javaMain.smart.selfservice;

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
import javaMain.common_Functions.AppData;
import javaMain.common_Functions.OpenMenuesSmart;

public class SMART_SelfService_OrdersStatus_Func extends TestBase {
	public static String  StartDate_Date_Future, StartDate_Month_Future, StartDate_Year_Future;
	public static boolean OrdersStatus(String TCName, int ScenarioCount, Object[] tCsDataset) throws Exception {

		try {

			if (isMasterClassRun) {

				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + ReadData.getJsonData(TCName, ScenarioCount, "DataSet") + "</mark>");
				StartDate_Date_Future = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "StartDate_Date_Future"));
				StartDate_Month_Future = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "StartDate_Month_Future"));
				StartDate_Year_Future = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "StartDate_Year_Future"));
			} else {

				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + ReadData.getJsonData(TCName, ScenarioCount, "DataSet") + "</mark>");
				StartDate_Date_Future = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("StartDate_Date_Future"));
				StartDate_Month_Future = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("StartDate_Month_Future"));
				StartDate_Year_Future = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("StartDate_Year_Future"));
			}
			if (AppData.getLanguage().equalsIgnoreCase("EN"))
			{
			
			}else
			{
			Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "LoadingSpinner", "LogInLandingPage")));
			Utils.click(By.xpath(getObj("Propval1", "Arabic", "SMART_CreditCard_CashTransfer")), "Arabic");
			}
			Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "LoadingSpinner", "LogInLandingPage")));

			Utils.click(By.xpath(getObj("Propval1", "SelfService", "SMART_SelfService_OrdersStatus")), "Cards Menu");

			Utils.click(By.xpath(getObj("Propval1", "OrdersStatus", "SMART_SelfService_OrdersStatus")), "Cards summary");

			Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "LoadingSpinner", "LogInLandingPage")));

			try {
				Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "Search", "SMART_SelfService_OrdersStatus")), "Cards Logo"));

				Log.pass("SelfService OrdersStatus is displayed on screen");

				Utils.logPassImage("OrdersStatus");

			} catch (AssertionError | Exception e) {

				Log.fail("SelfService OrdersStatus is logo is not displayed.");
				Utils.logFailImage("OrdersStatus");

				throw e;

			}
			Utils.click(By.xpath(getObj("Propval1", "FromDate", "SMART_SelfService_OrdersStatus")), "From Date");
			

			Log.pass("Langugage "+AppData.getLanguage());
			if (AppData.getLanguage().equalsIgnoreCase("EN")) {
				Log.pass("English date");
				Utils.Changedate_Smart(StartDate_Date_Future, "DateDecreasing_clk", "SMART_SelfService_OrdersStatus", " '-' button to select future date");
				Utils.Changedate_Smart(StartDate_Month_Future, "MonthDecreasing_clk", "SMART_SelfService_OrdersStatus", " '-' button to select future month");
				Utils.Changedate_Smart(StartDate_Year_Future, "YearDecreasing_clk", "SMART_SelfService_OrdersStatus", " '-' button to select future Year");
			} else {
				Log.pass("Arabic date");
				Utils.Changedate_Smart(StartDate_Date_Future, "DateIncreasing_clk_Arb", "SMART_SelfService_OrdersStatus", " '-' button to select future date");
				Utils.Changedate_Smart(StartDate_Month_Future, "MonthIncreasing_clk_Arb", "SMART_SelfService_OrdersStatus", " '-' button to select future month");
				Utils.Changedate_Smart(StartDate_Year_Future, "YearIncreasing_clk_Arb", "SMART_SelfService_OrdersStatus", " '-' button to select future Year");
			}
			
		
			Utils.click(By.xpath(getObj("Propval1", "Search", "SMART_SelfService_OrdersStatus")), "Search");
			Utils.logPassImage("Search");
			Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "LoadingSpinner", "LogInLandingPage")));
			
			Utils.click(By.xpath(getObj("Propval1", "Account", "SMART_SelfService_OrdersStatus")), "Account");
			Utils.logPassImage("Search");
			
			
		} catch (AssertionError | Exception e) {
			runResult = false;
			throw e;
		}
		return runResult;
	}

}
