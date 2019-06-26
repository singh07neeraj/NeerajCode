package javaMain.JOL.aljaziraCapital;

import static Utilities.ReadData.ReadDataSQL;
import static Utilities.ReadData.getObj;
import static javaMain.common_Functions.AppData.AfterTxfrAdditionalOptions;
import static javaMain.common_Functions.AppData.Proceed;
import static javaMain.common_Functions.AppData.TestType;
import static javaMain.common_Functions.AppData.verifySubscribeBtn;

import org.openqa.selenium.By;

import Utilities.Log;
import Utilities.ReadData;
import Utilities.TestBase;
import Utilities.Utils;
import javaMain.JOL.transfer.TransferModuleCommonFunctions;
import javaMain.common_Functions.OpenJOLMenues;

public class MUTUAL_FUNDS_RATE extends TestBase {

	@SuppressWarnings("unused")
	public static boolean mutualFundsRate(String TCName, int ScenarioCount, Object[] tCsDataset) throws Exception{

		boolean runResult = true;
		try {

			if (true) {
				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" +"Data set for this scenario is " + System.lineSeparator() + ReadData.getJsonData(TCName, ScenarioCount, "DataSet")+"</mark>");
				Proceed = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Proceed"));
				AfterTxfrAdditionalOptions = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "AfterTxfrAdditionalOptions"));
				TestType = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "TestType"));
				verifySubscribeBtn = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "verifySubscribeBtn"));
				
			}

			else {
				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" +"Data set for this scenario is " + System.lineSeparator() + dataset[scenarioCount - 1]+"</mark>");
				Proceed = (String) Utils.getUiData(dataset[scenarioCount - 1]).get("Proceed");
				AfterTxfrAdditionalOptions = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("AfterTxfrAdditionalOptions"));
				TestType = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("TestType"));
				verifySubscribeBtn = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("verifySubscribeBtn"));

			}
			
			OpenJOLMenues.openAljaziraCapitalMenu("MutualFundRate");
			
			String searchResultsCount = Utils.getText(By.xpath(getObj("Propval1", "searchResultsCount", "AlZCapital")));
			Log.pass("Search results are displayed successfully. Results displayed are :-" + searchResultsCount);
			// Select mutual fund name.
			Utils.click(By.xpath(getObj("Propval1", "selectMutualFundRadioBtn", "AlZCapital")), "Select mutual fund radio button");
			Utils.mouseHover(By.xpath(getObj("Propval1", "detailsToolTipIcon", "AlZCapital")));
			Utils.logPassImage("Mutual fund details");
			Utils.wait(3);
			Utils.click(By.xpath(getObj("Propval1", "selectMutualFundRadioBtn", "AlZCapital")), "Select mutual fund radio button");
			Utils.wait(3);
			if (AfterTxfrAdditionalOptions.equalsIgnoreCase("true")) {

				Log.pass("Successfully started other actions like send email, download pdf, excel and print search result etc.");
				TransferModuleCommonFunctions.sendEmailDownloadExcelnPrintFunc();

			}
			
			if (verifySubscribeBtn.equalsIgnoreCase("true")) {

				Log.pass("Successfully started other actions like send email, download pdf, excel and print search result etc.");
				
				Utils.click(By.xpath(getObj("Propval1", "subscribeBtnMutual", "AlZCapital")), "Select subscribe button");
				
			}
			

		} catch (Exception e) {
			runResult = false;
			gException = e;
			throw e;
		}
		return runResult;
	}


}
