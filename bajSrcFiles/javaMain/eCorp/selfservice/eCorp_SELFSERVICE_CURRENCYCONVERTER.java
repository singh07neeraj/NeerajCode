package javaMain.eCorp.selfservice;

import static Utilities.ReadData.ReadDataSQL;
import static Utilities.ReadData.getObj;
import static javaMain.common_Functions.AppData.AMOUNT;
import static javaMain.common_Functions.AppData.CurrencyFrom;
import static javaMain.common_Functions.AppData.CurrencyTo;
import static javaMain.common_Functions.AppData.TestType;

import org.openqa.selenium.By;
import org.testng.Assert;

import Utilities.Log;
import Utilities.ReadData;
import Utilities.TestBase;
import Utilities.Utils;
import javaMain.common_Functions.AppData;

public class eCorp_SELFSERVICE_CURRENCYCONVERTER extends TestBase{

	public static Boolean CURRENCYCONVERTER_Func(String TCName, int ScenarioCount, Object[] tCsDataset) throws Exception {
		try {

			if (isMasterClassRun) {
				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + ReadData.getJsonData(TCName, ScenarioCount, "DataSet") + "</mark>");
				CurrencyFrom = ReadDataSQL(TCName, ScenarioCount, "CurrencyFrom");
				CurrencyTo = ReadDataSQL(TCName, ScenarioCount, "CurrencyTo");
				AMOUNT = ReadDataSQL(TCName, ScenarioCount, "AMOUNT");
				TestType = ReadDataSQL(TCName, ScenarioCount, "TestType");

			} else {
				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + dataset[scenarioCount - 1] + "</mark>");
				CurrencyFrom = (String) Utils.getUiData(dataset[scenarioCount - 1]).get("CurrencyFrom");
				CurrencyTo = (String) Utils.getUiData(dataset[scenarioCount - 1]).get("CurrencyTo");
				AMOUNT = (String) Utils.getUiData(dataset[scenarioCount - 1]).get("AMOUNT");
				TestType = (String) Utils.getUiData(dataset[scenarioCount - 1]).get("TestType");

			}
			Utils.wait(2);
			Utils.click(By.xpath(getObj("Propval1", "SelfServiceLnk", "eCorp_CurrencyConverter")), "Self Service");
			Utils.wait(2);
			Utils.click(By.xpath(getObj("Propval1", "CurrencyConverter_Menu_Y", "eCorp_CurrencyConverter")), "Currency Converter");

			Utils.wait(2);
			// Enter From Currency//
			Utils.sendKeys(By.xpath(getObj("Propval1", "CurrencyFrom", "eCorp_CurrencyConverter")), CurrencyFrom, "From Currency");

			// Enter To Currency//
			Utils.sendKeys(By.xpath(getObj("Propval1", "CurrencyTo", "eCorp_CurrencyConverter")), CurrencyTo, "To Currency");

			// Enter Original Amount//
			Utils.sendKeys(By.xpath(getObj("Propval1", "OriginalAmount", "eCorp_CurrencyConverter")), AMOUNT, "Original Amount");

			// System.out.println("Error Size :"+x);

			if (TestType.equalsIgnoreCase("N")) {

				try {

					Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "CurrencyError", "eCorp_CurrencyConverter")), "eCorp_CurrencyConverter"));
					Log.pass("Selected currecny is  in valid error message appears successfully");
					Utils.logPassImage("JOL_SELFSERVICE_CURRENCYCONVERTER_Func");
					return true;

				} catch (AssertionError | Exception e) {

					Log.fail("Entering invalid currecny, however the error message is not appearing");
					Utils.logFailImage("JOL_SELFSERVICE_CURRENCYCONVERTER_Func");

					throw e;
				}

			} else {

				Log.pass("FX Rate displayed on screen is : " + Utils.getText(By.xpath(getObj("Propval1", "FXRate", "eCorp_CurrencyConverter"))));

				if (AppData.getLanguage().equalsIgnoreCase("Arabic")) {
					// Switch Currencies Arabic
					Utils.click(By.xpath(getObj("Propval1", "SwitchCurrenciesArabic", "eCorp_CurrencyConverter")), "Switch Currencies");
				} else {// Switch Currencies// English
					Utils.click(By.xpath(getObj("Propval1", "SwitchCurrencies", "eCorp_CurrencyConverter")), "Switch Currencies");
				}
				Log.pass("Successfully converted currency from : " + CurrencyFrom + " to :" + CurrencyTo + " for amount : " + AMOUNT);
				Utils.logPassImage("JOL_SELFSERVICE_CURRENCYCONVERTER_Func");

				return true;
			}

		} catch (Exception e) {
			runResult = false;
			throw e;

		}

	}
}
