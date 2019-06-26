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

public class SMART_SelfService_ContactUs_Func extends TestBase {

	public static boolean ContactUs(String TCName, int ScenarioCount, Object[] tCsDataset) throws Exception {

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

			Utils.click(By.xpath(getObj("Propval1", "SelfService", "SMART_SelfService_ContactUs")), "Cards Menu");

			Utils.click(By.xpath(getObj("Propval1", "ContactUs", "SMART_SelfService_ContactUs")), "Cards summary");

			Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "LoadingSpinner", "LogInLandingPage")));

			try {
				Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "callus", "SMART_SelfService_ContactUs")), "call us"));

				Log.pass("SelfService Contact Us is displayed on screen");

				Utils.logPassImage("OrdersStatus");

			} catch (AssertionError | Exception e) {

				Log.fail("SelfService Contact Us is logo is not displayed.");
				Utils.logFailImage("OrdersStatus");

				throw e;

			}

			Utils.click(By.xpath(getObj("Propval1", "callus", "SMART_SelfService_ContactUs")), "call us");

			Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "LoadingSpinner", "LogInLandingPage")));

			Utils.logPassImage("Call US");
			
			Utils.click(By.xpath(getObj("Propval1", "SelfService", "SMART_SelfService_ContactUs")), "Cards Menu");

			Utils.click(By.xpath(getObj("Propval1", "ContactUs", "SMART_SelfService_ContactUs")), "Cards summary");

			Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "LoadingSpinner", "LogInLandingPage")));
			
			Utils.click(By.xpath(getObj("Propval1", "emailUS", "SMART_SelfService_ContactUs")), "email US");

			Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "LoadingSpinner", "LogInLandingPage")));
			Utils.logPassImage("email US");
		
		} catch (AssertionError | Exception e) {
			runResult = false;
			throw e;
		}
		return runResult;
	}

}
