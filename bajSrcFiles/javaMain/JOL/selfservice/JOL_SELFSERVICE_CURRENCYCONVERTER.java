package javaMain.JOL.selfservice;

import static Utilities.ReadData.ReadDataSQL;
import static Utilities.ReadData.getObj;
import static Utilities.TestBase.dataset;
import static Utilities.TestBase.isMasterClassRun;
import static Utilities.TestBase.scenarioCount;
import static javaMain.common_Functions.AppData.AMOUNT;
import static javaMain.common_Functions.AppData.CurrencyFrom;
import static javaMain.common_Functions.AppData.CurrencyTo;
import static javaMain.common_Functions.AppData.TestType;

import org.openqa.selenium.By;

import Utilities.Log;
import Utilities.ReadData;
import Utilities.Utils;

public class JOL_SELFSERVICE_CURRENCYCONVERTER {

	public static Boolean JOL_SELFSERVICE_CURRENCYCONVERTER_Func(String TCName, int ScenarioCount, Object[] tCsDataset) throws Exception {

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
			Utils.wait(5);
			Utils.click(By.xpath(getObj("Propval1", "SelfServiceLnk", "CurrencyConverter")), "Self Service");
			Utils.wait(2);
			Utils.click(By.xpath(getObj("Propval1", "RatesCalculatorLnk", "CurrencyConverter")), "RatesCalculatorLnk");
			Utils.wait(2);
			Utils.click(By.xpath(getObj("Propval1", "CurrencyConverter_Menu_Y", "CurrencyConverter")), "Currency Converter");

			Utils.wait(6);
			Utils.waitTillSaudiWaitIconDisappears();
			// Enter From Currency//
			Utils.sendKeys(By.xpath(getObj("Propval1", "CurrencyFrom", "CurrencyConverter")), CurrencyFrom, "From Currency");

			// Enter To Currency//
			Utils.sendKeys(By.xpath(getObj("Propval1", "CurrencyTo", "CurrencyConverter")), CurrencyTo, "To Currency");

			// Enter Original Amount//
			Utils.sendKeys(By.xpath(getObj("Propval1", "OriginalAmount", "CurrencyConverter")), AMOUNT, "Original Amount");

			// System.out.println("Error Size :"+x);

			if (TestType.equalsIgnoreCase("N")) {

				int x = Utils.getSizeNoException(By.xpath(getObj("Propval1", "CurrencyError", "CurrencyConverter")));

				if (x > 0) {

					Log.pass("Selected currecny is  in valid error message appears successfully");
					Utils.logPassImage("JOL_SELFSERVICE_CURRENCYCONVERTER_Func");
					return true;

				}

				else {

					Log.fail("Entering invalid currecny, however the error message is not appearing");
					Utils.logFailImage("JOL_SELFSERVICE_CURRENCYCONVERTER_Func");

					return false;
				}
			} else {

				Log.pass("FX Rate displayed on screen is : " + Utils.getText(By.xpath(getObj("Propval1", "FXRate", "CurrencyConverter"))));

				// Switch Currencies//
				Utils.click(By.xpath(getObj("Propval1", "SwitchCurrencies", "CurrencyConverter")), "Switch Currencies");

				Log.pass("Successfully converted currency from : " + CurrencyFrom + " to : " + CurrencyTo + " for amount : " + AMOUNT);
				Log.pass("Currency amount after converting currency is  : "+ Utils.getText(By.xpath("//*[contains(@id,'amountTo_ns_Z7')]")));
				Utils.logPassImage("JOL_SELFSERVICE_CURRENCYCONVERTER_Func");

				return true;
			}

		} catch (Exception e) {

			throw e;

		}

	}
}
