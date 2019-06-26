package javaMain.JOL.aljaziraCapital;

import static Utilities.Input.ReadTestData;
import static Utilities.ReadData.ReadDataSQL;
import static Utilities.ReadData.getObj;
import static javaMain.common_Functions.AppData.AfterTxfrAdditionalOptions;
import static javaMain.common_Functions.AppData.Proceed;
import static javaMain.common_Functions.AppData.TestType;

import org.openqa.selenium.By;

import Utilities.Log;
import Utilities.ReadData;
import Utilities.TestBase;
import Utilities.Utils;
import javaMain.JOL.transfer.TransferModuleCommonFunctions;
import javaMain.common_Functions.OpenJOLMenues;

public class MUTUAL_FUNDS_SUBSCRIPTION_HISTORY extends TestBase {

	@SuppressWarnings("unused")
	public static boolean openMutualFundsHistoryFunc(String TCName, int ScenarioCount, Object[] tCsDataset) throws Exception {

		boolean runResult = true;
		try {

			if (true) {
				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" +"Data set for this scenario is " + System.lineSeparator() + ReadData.getJsonData(TCName, ScenarioCount, "DataSet")+"</mark>");
				Proceed = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Proceed"));
				AfterTxfrAdditionalOptions = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "AfterTxfrAdditionalOptions"));
				TestType = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "TestType"));

			}

			else {
				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" +"Data set for this scenario is " + System.lineSeparator() + dataset[scenarioCount - 1]+"</mark>");
				Proceed = (String) Utils.getUiData(dataset[scenarioCount - 1]).get("Proceed");
				AfterTxfrAdditionalOptions = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("AfterTxfrAdditionalOptions"));
				TestType = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("TestType"));

			}
			
			OpenJOLMenues.openAljaziraCapitalMenu("Subscription History");

			if (TestType.equalsIgnoreCase("P")) {

				Log.pass("Started executing positive scenario.");
				
				Utils.click(By.xpath(getObj("Propval1", "dateFromSubsDropDown", "AlZCapital")), "From date drop down");
				Utils.sendKeys(By.xpath(getObj("Propval1", "fromDateSubsHist", "AlZCapital")), ReadTestData(TCName, "DateFrom"), "From Date");
				
				Utils.click(By.xpath(getObj("Propval1", "dateToSubsDropDown", "AlZCapital")), "To date drop down");
				Utils.sendKeys(By.xpath(getObj("Propval1", "toDateSubsHist", "AlZCapital")), ReadTestData(TCName, "DateTo"), "To  Date");
				
				Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "fundNameDropdown", "AlZCapital")), By.xpath(getObj("Propval1", "fundName", "AlZCapital")), ReadTestData(TCName, "fundName"),"Fund Name.");
				Utils.click(By.xpath(getObj("Propval1", "SubsSearchBtn", "AlZCapital")), "SearchButton");

				Utils.wait(3);

				String searchResultsCount = Utils.getText(By.xpath(getObj("Propval1", "searchResultsCount", "AlZCapital")));
				Log.pass("Search results are displayed successfully. Results displayed are :-" + searchResultsCount);

			}

			if (TestType.equalsIgnoreCase("N")) {

				Log.pass("Started executing negative scenario.");
				
				Utils.click(By.xpath(getObj("Propval1", "dateFromSubsDropDown", "AlZCapital")), "From date drop down");
				Utils.sendKeys(By.xpath(getObj("Propval1", "fromDateSubsHist", "AlZCapital")), "12313123", "Invalid- From Date");
				
				Utils.click(By.xpath(getObj("Propval1", "dateToSubsDropDown", "AlZCapital")), "To date drop down");
				Utils.sendKeys(By.xpath(getObj("Propval1", "toDateSubsHist", "AlZCapital")), "213412424", "Invalid- To  Date");

				
				Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "fundNameDropdown", "AlZCapital")), By.xpath(getObj("Propval1", "fundName", "AlZCapital")), "Invalid Fund Name !@#!@$!$", "Fund Name field.");
				Utils.click(By.xpath(getObj("Propval1", "SubsSearchBtn", "AlZCapital")), "SearchButton");


				Utils.wait(3);

				String searchResultsCount = Utils.getText(By.xpath(getObj("Propval1", "searchResultsCount", "AlZCapital")));
				Log.pass("Search results are displayed successfully. Result displayed is  :-" + searchResultsCount + "Negative test case has passed. No search results displayed.");

			}

			if (AfterTxfrAdditionalOptions.equalsIgnoreCase("true")) {

				Log.pass("Successfully started other actions like send email, download pdf, excel and print search result etc.");
				TransferModuleCommonFunctions.sendEmailDownloadExcelnPrintFunc();

			}

		} catch (Exception e) {
			runResult = false;
			throw e;
		}
		return runResult;
	}

}
