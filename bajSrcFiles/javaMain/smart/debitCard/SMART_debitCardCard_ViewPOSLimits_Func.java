package javaMain.smart.debitCard;

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

public class SMART_debitCardCard_ViewPOSLimits_Func extends TestBase {

	public static boolean ViewPOSLimits(String TCName, int ScenarioCount, Object[] tCsDataset) throws Exception {

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
			Utils.click(By.xpath(getObj("Propval1", "Arabic",	 "SMART_CreditCard_CashTransfer")), "Arabic");
			}
			Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "LoadingSpinner", "LogInLandingPage")));

			Utils.click(By.xpath(getObj("Propval1", "Cards", "SMART_DebitCard_ViewPOSLimits")), "Cards Menu");

			Utils.scrollIntoView(By.xpath(getObj("Propval1", "CardReplaceMent", "SMART_DebitCard_ViewPOSLimits")));

			Utils.click(By.xpath(getObj("Propval1", "ViewPOSLimits", "SMART_DebitCard_ViewPOSLimits")), "ViewPOSLimits");

			Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "LoadingSpinner", "LogInLandingPage")));

			try {
				Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "CardsLogo", "SMART_DebitCard_ViewPOSLimits")), "Cards Logo"));

				Log.pass("ViewPOSLimits is displayed on screen");

				Utils.logPassImage("Card Summary");

			} catch (AssertionError | Exception e) {

				Log.fail("ViewPOSLimits is logo is not displayed.");
				Utils.logFailImage("Card Summary");

				throw e;

			}

			for (int i = 1; i < 6; i++) {
				String Name = getObj("Propval1", "CardsNumber", "SMART_DebitCard_ViewPOSLimits") + "[" + i + "]";
				String Values = getObj("Propval1", "CardsNumber", "SMART_DebitCard_ViewPOSLimits") + "[" + (i + 1) + "]";
				Log.pass(Utils.getText_Smart(By.xpath(Name)) + ":" + Utils.getText_Smart(By.xpath(Values)));
			}

			Utils.click(By.xpath(getObj("Propval1", "ClickonCard", "SMART_DebitCard_ViewPOSLimits")), "Click on Card");
			Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "LoadingSpinner", "LogInLandingPage")));
			try {
				Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "cancelButton", "SMART_DebitCard_ViewPOSLimits")), "cancel Button"));

				Log.pass("Update POS Limit is displayed on screen");

				Utils.logPassImage("Update POS Limit");

			} catch (AssertionError | Exception e) {

				Log.fail("Update POS Limit  is logo is not displayed.");
				Utils.logFailImage("Update POS Limit");

				throw e;

			}

		} catch (AssertionError | Exception e) {
			runResult = false;
			throw e;
		}
		return runResult;
	}

}
