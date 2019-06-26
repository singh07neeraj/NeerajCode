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

public class SMART_SelfService_CommonFunction_Func extends TestBase {

	public static boolean UpdateNationalAddress(String TCName, int ScenarioCount, Object[] tCsDataset) throws Exception {

		try {

			if (isMasterClassRun) {

				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + ReadData.getJsonData(TCName, ScenarioCount, "DataSet") + "</mark>");

			} else {

				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + ReadData.getJsonData(TCName, ScenarioCount, "DataSet") + "</mark>");

			}
			if (AppData.getLanguage().equalsIgnoreCase("EN"))
			{
			
			}
			else
			{
			Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "LoadingSpinner", "LogInLandingPage")));
			Utils.click(By.xpath(getObj("Propval1", "Arabic", "SMART_CreditCard_CashTransfer")), "Arabic");
			}
			Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "LoadingSpinner", "LogInLandingPage")));

			Utils.click(By.xpath(getObj("Propval1", "SelfService", "SMART_SelfService_CommonFunction")), "Cards Menu");

			Utils.click(By.xpath(getObj("Propval1", "UpdateNationalAddress", "SMART_SelfService_CommonFunction")), "Update National Address");

			Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "LoadingSpinner", "LogInLandingPage")));
			Log.pass("Text Value is : "+Utils.getText_Smart(By.xpath(getObj("Propval1", "Text", "SMART_SelfService_CommonFunction"))));
			
			Utils.logPassImage("Update National Address");
			
			
		
		} catch (AssertionError | Exception e) {
			runResult = false;
			throw e;
		}
		return runResult;
	}

	public static boolean FavoriteTransactions(String TCName, int ScenarioCount, Object[] tCsDataset) throws Exception {

		try {

			if (isMasterClassRun) {

				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + ReadData.getJsonData(TCName, ScenarioCount, "DataSet") + "</mark>");

			} else {

				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + ReadData.getJsonData(TCName, ScenarioCount, "DataSet") + "</mark>");

			}
			if (AppData.getLanguage().equalsIgnoreCase("EN"))
			{
			
			}
			else
			{
			Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "LoadingSpinner", "LogInLandingPage")));
			Utils.click(By.xpath(getObj("Propval1", "Arabic", "SMART_CreditCard_CashTransfer")), "Arabic");
			}
			Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "LoadingSpinner", "LogInLandingPage")));

			Utils.click(By.xpath(getObj("Propval1", "SelfService", "SMART_SelfService_CommonFunction")), "Cards Menu");

			Utils.click(By.xpath(getObj("Propval1", "FavoriteTransactions", "SMART_SelfService_CommonFunction")), "Favorite Transactions");

			Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "LoadingSpinner", "LogInLandingPage")));
			Log.pass("Text Value is : "+Utils.getText_Smart(By.xpath(getObj("Propval1", "FavoriteTransactionsText", "SMART_SelfService_CommonFunction"))));
			
			Utils.logPassImage("Favorite Transactions");
			
			
		
		} catch (AssertionError | Exception e) {
			runResult = false;
			throw e;
		}
		return runResult;
	}

}
