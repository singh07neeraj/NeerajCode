package javaMain.JOL.SADAD;

import static Utilities.ReadData.ReadDataSQL;
import static Utilities.ReadData.getObj;

import org.openqa.selenium.By;
import org.testng.Assert;

import Utilities.Log;
import Utilities.ReadData;
import Utilities.TestBase;
import Utilities.Utils;

public class JOL_SADAD_FAQ extends TestBase {

	public static Boolean JOL_SADAD_FAQ_Func(String TCName, int ScenarioCount, Object[] tCsDataset) throws Exception {

		String General,BankOnBoarding, MerchantOnBoarding;
		try {

			// if (isMasterClassRun) {
			if (true)
			{

				Log.pass("Data set for this scenario is " + System.lineSeparator()
				+ ReadData.getJsonData(TCName, ScenarioCount, "DataSet"));

				General = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "General"));
				BankOnBoarding = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "BankOnBoarding"));
				MerchantOnBoarding = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "MerchantOnBoarding"));

			} else 
			{

				Log.pass("Data set for this scenario is " + System.lineSeparator() + dataset[scenarioCount - 1]);
				General = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("General"));
				BankOnBoarding = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("BankOnBoarding"));
				MerchantOnBoarding = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("MerchantOnBoarding"));
			}
			Utils.scrollUpVertically();

			Utils.click(By.xpath(getObj("Propval1", "SADADServicesLnk", "SADADFAQ")), "Sadad Link");

			Utils.waitForInVisibilityOfEle(By.xpath("//*[@id='overlayInfo']"));

			Utils.click(By.xpath(getObj("Propval1", "SADADAccountLnk", "SADADFAQ")), "Sadad account Link");

			Utils.click(By.xpath(getObj("Propval1", "FAQs_lnk", "SADADFAQ")), "FAQs Link");

			
			try {
				Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "FAQs_HomePage", "SADADFAQ")), "FAQ Homepage"));
				Log.pass(" FAQ home page has displayed as expected. Message displayed is : " + Utils.getText(By.xpath(getObj("Propval1", "FAQs_HomePage", "SADADFAQ"))));
				Utils.logPassImage(" FAQ home page-pass");
				//return true;

			} catch (AssertionError | Exception e) {

				Log.fail(" FAQ home page has not displayed. Should have failed.");
				Utils.logFailImage(" FAQ home page-fail");
				throw e;

			}

			if (General.equalsIgnoreCase("true")) 
			{
				
				Utils.wait(5);
				
				try {
					Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "GeneralInfo_Q1", "SADADFAQ")), "GeneralInfo Question1"));
					Log.pass(" GeneralInfo Q1 has displayed as expected. Message displayed is : " + Utils.getText(By.xpath(getObj("Propval1", "GeneralInfo_Q1", "SADADFAQ"))));
					Utils.logPassImage(" GeneralInfo Q1-pass");
					//return true;

				} catch (AssertionError | Exception e) {

					Log.fail(" GeneralInfo Q1 has not displayed. Should have failed.");
					Utils.logFailImage(" GeneralInfo Q1-fail");
					throw e;

				}

				try {
					Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "GeneralInfo_Q2", "SADADFAQ")), "GeneralInfo Question2"));
					Log.pass(" GeneralInfo Q2 has displayed as expected. Message displayed is : " + Utils.getText(By.xpath(getObj("Propval1", "GeneralInfo_Q2", "SADADFAQ"))));
					Utils.logPassImage(" GeneralInfo Q2-pass");
					//return true;

				} catch (AssertionError | Exception e) {

					Log.fail(" GeneralInfo Q2 has not displayed. Should have failed.");
					Utils.logFailImage(" GeneralInfo Q2-fail");
					throw e;

				}
				
				
				try {
					Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "GeneralInfo_Q3", "SADADFAQ")), "GeneralInfo Question3"));
					Log.pass(" GeneralInfo Q3 has displayed as expected. Message displayed is : " + Utils.getText(By.xpath(getObj("Propval1", "GeneralInfo_Q3", "SADADFAQ"))));
					Utils.logPassImage(" GeneralInfo Q3-pass");
					//return true;

				} catch (AssertionError | Exception e) {

					Log.fail(" GeneralInfo Q3 has not displayed. Should have failed.");
					Utils.logFailImage(" GeneralInfo Q3-fail");
					throw e;

				}
				
				try {
					Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "GeneralInfo_Q4", "SADADFAQ")), "GeneralInfo Question4"));
					Log.pass(" GeneralInfo Q4 has displayed as expected. Message displayed is : " + Utils.getText(By.xpath(getObj("Propval1", "GeneralInfo_Q4", "SADADFAQ"))));
					Utils.logPassImage(" GeneralInfo Q4-pass");
					//return true;

				} catch (AssertionError | Exception e) {

					Log.fail(" GeneralInfo Q4 has not displayed. Should have failed.");
					Utils.logFailImage(" GeneralInfo Q4-fail");
					throw e;

				}
				
				

			}
			if (BankOnBoarding.equalsIgnoreCase("true")) 
			{

				Utils.click(By.xpath(getObj("Propval1", "BankonBoardingPackageInfo", "SADADFAQ")), "Bank on boarding package Link");
				Utils.wait(5);
				
				try {
					Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "BankOnBoarding_Q1", "SADADFAQ")), "BankOnBoarding Question1"));
					Log.pass(" BankOnBoarding Q1 has displayed as expected. Message displayed is : " + Utils.getText(By.xpath(getObj("Propval1", "BankOnBoarding_Q1", "SADADFAQ"))));
					Utils.logPassImage(" BankOnBoarding Q1-pass");
					//return true;

				} catch (AssertionError | Exception e) {

					Log.fail(" BankOnBoarding Q1 has not displayed. Should have failed.");
					Utils.logFailImage(" BankOnBoarding Q1-fail");
					throw e;

				}
				
				try {
					Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "BankOnBoarding_Q2", "SADADFAQ")), "BankOnBoarding Question2"));
					Log.pass(" BankOnBoarding Q2 has displayed as expected. Message displayed is : " + Utils.getText(By.xpath(getObj("Propval1", "BankOnBoarding_Q2", "SADADFAQ"))));
					Utils.logPassImage(" BankOnBoarding Q2-pass");
					//return true;

				} catch (AssertionError | Exception e) {

					Log.fail(" BankOnBoarding Q2 has not displayed. Should have failed.");
					Utils.logFailImage(" BankOnBoarding Q2-fail");
					throw e;

				}
				
				try {
					Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "BankOnBoarding_Q3", "SADADFAQ")), "BankOnBoarding Question3"));
					Log.pass(" BankOnBoarding Q3 has displayed as expected. Message displayed is : " + Utils.getText(By.xpath(getObj("Propval1", "BankOnBoarding_Q3", "SADADFAQ"))));
					Utils.logPassImage(" BankOnBoarding Q3-pass");
					//return true;

				} catch (AssertionError | Exception e) {

					Log.fail(" BankOnBoarding Q3 has not displayed. Should have failed.");
					Utils.logFailImage(" BankOnBoarding Q3-fail");
					throw e;

				}

			}

			if (MerchantOnBoarding.equalsIgnoreCase("true")) 
			{
								
				Utils.click(By.xpath(getObj("Propval1", "MerchantonBoardingandManagementBtn", "SADADFAQ")), "Merchant on Boardingand Management Link");
				Utils.wait(5);
				
				try {
					Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "MerchantOnBoarding_Q1", "SADADFAQ")), "MerchantOnBoarding Question1"));
					Log.pass(" MerchantOnBoarding Q1 has displayed as expected. Message displayed is : " + Utils.getText(By.xpath(getObj("Propval1", "MerchantOnBoarding_Q1", "SADADFAQ"))));
					Utils.logPassImage(" MerchantOnBoarding Q1-pass");
					//return true;

				} catch (AssertionError | Exception e) {

					Log.fail(" MerchantOnBoarding Q1 has not displayed. Should have failed.");
					Utils.logFailImage(" MerchantOnBoarding Q1-fail");
					throw e;

				}
				

				try {
					Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "MerchantOnBoarding_Q2", "SADADFAQ")), "MerchantOnBoarding Question2"));
					Log.pass(" MerchantOnBoarding Q2 has displayed as expected. Message displayed is : " + Utils.getText(By.xpath(getObj("Propval1", "MerchantOnBoarding_Q2", "SADADFAQ"))));
					Utils.logPassImage(" MerchantOnBoarding Q2-pass");
					//return true;

				} catch (AssertionError | Exception e) {

					Log.fail(" MerchantOnBoarding Q2 has not displayed. Should have failed.");
					Utils.logFailImage(" MerchantOnBoarding Q2-fail");
					throw e;

				}
				

				try {
					Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "MerchantOnBoarding_Q3", "SADADFAQ")), "MerchantOnBoarding Question3"));
					Log.pass(" MerchantOnBoarding Q3 has displayed as expected. Message displayed is : " + Utils.getText(By.xpath(getObj("Propval1", "MerchantOnBoarding_Q3", "SADADFAQ"))));
					Utils.logPassImage(" MerchantOnBoarding Q3-pass");
					//return true;

				} catch (AssertionError | Exception e) {

					Log.fail(" MerchantOnBoarding Q3 has not displayed. Should have failed.");
					Utils.logFailImage(" MerchantOnBoarding Q3-fail");
					throw e;

				}
			}


		} catch (Exception e) {
			runResult = false;
			throw e;
		}

		return runResult;
	}

}
