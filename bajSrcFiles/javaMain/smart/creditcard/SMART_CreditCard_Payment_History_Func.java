package javaMain.smart.creditcard;

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

public class SMART_CreditCard_Payment_History_Func extends TestBase {

	public static boolean PaymentHistory(String TCName, int ScenarioCount, Object[] tCsDataset) throws Exception {

		try {

			if (isMasterClassRun) {

				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + ReadData.getJsonData(TCName, ScenarioCount, "DataSet") + "</mark>");

			} else {

				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + ReadData.getJsonData(TCName, ScenarioCount, "DataSet") + "</mark>");

			}
		
			
			Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "LoadingSpinner", "LogInLandingPage")));
			Utils.click_Smart(By.xpath(getObj("Propval1", "Cards", "SMART_CreditCard_PaymentHistory")), "Cards Menu");
			Utils.wait(3);
			Utils.click_Smart(By.xpath(getObj("Propval1", "PaymentHistory", "SMART_CreditCard_PaymentHistory")), "Payment History");

			Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "LoadingSpinner", "LogInLandingPage")));

			try {
				Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "CardPaymentHistory", "SMART_CreditCard_PaymentHistory")), "CardPaymentHistory"));

				Log.pass("Card Payment History is displayed on screen");

				Utils.logPassImage("Card Summary");

			} catch (AssertionError | Exception e) {

				Log.fail("Card Payment History is logo is not displayed.");
				Utils.logFailImage("Card Summary");

				throw e;

			}

			try {
				Log.pass("Displayed Card Number is :" + Utils.getText_Smart(By.xpath(getObj("Propval1", "CardsNumber", "SMART_CreditCard_PaymentHistory"))));
				Log.pass("Displayed Account Number is :" + Utils.getText_Smart(By.xpath(getObj("Propval1", "subtit", "SMART_CreditCard_PaymentHistory"))));
				Utils.logPassImage("Card Summary");
			} catch (Exception e) {
				Log.pass("No transaction summary is displayed");
				Utils.logPassImage(TCName);

			}
		} catch (AssertionError | Exception e) {
			runResult = false;
			throw e;
		}
		return runResult;
	}

}
