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

public class SMART_debitCardCard_Summary_Func extends TestBase {

	public static boolean debitCardCard(String TCName, int ScenarioCount, Object[] tCsDataset) throws Exception {

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

			Utils.click(By.xpath(getObj("Propval1", "Cards", "SMART_DebitCard_Summary")), "Cards Menu");

			Utils.click(By.xpath(getObj("Propval1", "Cardssummary", "SMART_DebitCard_Summary")), "Cards summary");

			Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "LoadingSpinner", "LogInLandingPage")));

			try {
				Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "CardsLogo", "SMART_DebitCard_Summary")), "Cards Logo"));

				Log.pass("Debit card logo is displayed on screen");

				Utils.logPassImage("Card Summary");

			} catch (AssertionError | Exception e) {

				Log.fail("Debit card is logo is not displayed.");
				Utils.logFailImage("Card Summary");

				throw e;

			}

			Log.pass("Displayed Card Number is :" + Utils.getText_Smart(By.xpath(getObj("Propval1", "CardsNumber", "SMART_DebitCard_Summary"))));
			Log.pass("Displayed Card Amount is :" + Utils.getText_Smart(By.xpath(getObj("Propval1", "Amount", "SMART_DebitCard_Summary"))));
			Utils.logPassImage("Card Summary");
			Log.pass("Click on Debit Card");
			Utils.click(By.xpath(getObj("Propval1", "DebitCardClick", "SMART_DebitCard_Summary")), "Cards summary");
			Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "LoadingSpinner", "LogInLandingPage")));
			
			for(int i=3;i<11;i++)
			{
				String Name=getObj("Propval1", "Name", "SMART_DebitCard_Summary")+"["+i+"]";
				 String Values=getObj("Propval1", "Values", "SMART_DebitCard_Summary")+"["+i+"]";
				Log.pass(Utils.getText_Smart(By.xpath(Name))+" :"+Utils.getText_Smart(By.xpath(Values)));
			}
			
		} catch (AssertionError | Exception e) {
			runResult = false;
			throw e;
		}
		return runResult;
	}

}
