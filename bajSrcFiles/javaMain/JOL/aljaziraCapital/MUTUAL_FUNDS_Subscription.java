package javaMain.JOL.aljaziraCapital;

import static Utilities.ReadData.ReadDataSQL;
import static Utilities.ReadData.getObj;
import static javaMain.common_Functions.AppData.Proceed;
import static javaMain.common_Functions.AppData.TestType;
import static javaMain.common_Functions.AppData.validateSubsAndRedemptionHistoryLink;

import org.openqa.selenium.By;

import Utilities.Log;
import Utilities.ReadData;
import Utilities.TestBase;
import Utilities.Utils;
import javaMain.common_Functions.OpenJOLMenues;

public class MUTUAL_FUNDS_Subscription extends TestBase {

	@SuppressWarnings("unused")
	public static boolean mutualFundsSubscription(String TCName, int ScenarioCount, Object[] tCsDataset) throws Exception {

		try {

			if (isMasterClassRun) {
				
				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + ReadData.getJsonData(TCName, ScenarioCount, "DataSet") + "</mark>");
				Proceed = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Proceed"));
				validateSubsAndRedemptionHistoryLink = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "validateSubsAndRedemptionHistoryLink"));
				TestType = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "TestType"));

			}

			else {
				
				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + dataset[scenarioCount - 1] + "</mark>");
				Proceed = (String) Utils.getUiData(dataset[scenarioCount - 1]).get("Proceed");
				validateSubsAndRedemptionHistoryLink = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("validateSubsAndRedemptionHistoryLink"));
				TestType = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("TestType"));

			}

			// Open mutual funds landing page
			OpenJOLMenues.openAljaziraCapitalMenu("Mutual Funds");

			if (TestType.equalsIgnoreCase("P")) {

				Log.pass("Started executing positive scenario.");

				try {
					Log.pass("Message displayed on landing screen is :" + Utils.getText(By.xpath(getObj("Propval1", "mutualFundaLandingPageMsg", "AlZCapital"))));
				} catch (Exception e) {
					// No Action
				}

				Utils.click(By.xpath(getObj("Propval1", "mutualFundSubscribe", "AlZCapital")), "Subscribe button.");
							

				Utils.click(By.xpath(getObj("Propval1", "termsCheckBox", "AlZCapital")), "terms and conditions check box");

				//Utils.click(By.xpath(getObj("Propval1", "MutualFundsProceedBtn", "AlZCapital")), "Proceed  button.");

				// further coding needs to be done when module works properly. Now works only
				// till proceed screen.

				try {
					Log.pass("Message displayed on screen is :" + Utils.getText(By.xpath(getObj("Propval1", "mutualFundaLandingPageMsg", "AlZCapital"))));
				} catch (Exception e) {
					// No Action
				}

			}

			if (TestType.equalsIgnoreCase("N")) {

				Log.pass("Started executing negative scenario- Trying to subscribe to a mutual fund without accepting terms and conditions.");

				Utils.click(By.xpath(getObj("Propval1", "mutualFundSubscribe", "AlZCapital")), "Subscribe button.");

				// Do not select 'terms and conditions';
				// Utils.click(By.xpath(getObj("Propval1", "termsCheckBox", "AlZCapital")), "terms and conditions check box");

				Utils.click(By.xpath(getObj("Propval1", "MutualFundsProceedBtn", "AlZCapital")), "Proceed  button.");

				// further coding needs to be done when module works properly. Now works only
				// till proceed screen.

				 // Negative validation to be added when screen starts working.
			

			}

			if (validateSubsAndRedemptionHistoryLink.equalsIgnoreCase("true")) {

				// Open mutual funds landing page
				OpenJOLMenues.openAljaziraCapitalMenu("MutualFunds");
				Utils.click(By.xpath(getObj("Propval1", "subsHistLinkBtn", "AlZCapital")), "Subscribe button.");
				Utils.wait(5);
				Utils.assertDisplayedWithException(By.xpath(getObj("Propval1", "subsHistPageTitle", "AlZCapital")), "Subscription History Page title ");
				
				// Open mutual funds landing page
				OpenJOLMenues.openAljaziraCapitalMenu("MutualFunds");
				Utils.click(By.xpath(getObj("Propval1", "redemptionHistLinkBtn", "AlZCapital")), "Redemption History Button.");
				Utils.wait(5);
				Utils.assertDisplayedWithException(By.xpath(getObj("Propval1", "redemptionHistPageTitle", "AlZCapital")), "Redemption History Page title ");
				
				
			}

			// Open mutual funds landing page in case some exception happens in previous steps.
			OpenJOLMenues.openAljaziraCapitalMenu("MutualFunds");

		} catch (AssertionError |Exception e) {
			runResult = false;
			throw e;
		}
		return runResult;
	}

}
