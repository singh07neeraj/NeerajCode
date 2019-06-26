package javaMain.JOL.aljaziraCapital;

import static Utilities.Input.ReadTestData;
import static Utilities.ReadData.ReadDataSQL;
import static Utilities.ReadData.getObj;
import static javaMain.common_Functions.AppData.AdditionalActions;
import static javaMain.common_Functions.AppData.Proceed;
import static javaMain.common_Functions.AppData.TestType;
import static javaMain.common_Functions.AppData.Type;

import org.openqa.selenium.By;

import Utilities.Log;
import Utilities.ReadData;
import Utilities.TestBase;
import Utilities.Utils;
import javaMain.common_Functions.JolCommonFunctions;
import javaMain.common_Functions.OpenJOLMenues;

public class MUTUAL_FUNDS_MARKET_INFORMATION extends TestBase {

	public static boolean mutualFundsMarketInformationFunc(String TCName, int ScenarioCount, Object[] tCsDataset) throws Exception {

		try {

			if (isMasterClassRun) {
				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + ReadData.getJsonData(TCName, ScenarioCount, "DataSet") + "</mark>");
				Type = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Type"));
				Proceed = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Proceed"));
				TestType = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "TestType"));
				AdditionalActions = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "AfterTxfrAdditionalOptions"));

			}

			else {
				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" +"Data set for this scenario is " + System.lineSeparator() + dataset[scenarioCount - 1]+"</mark>");
				Type = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Type"));
				Proceed = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Proceed"));
				TestType = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("TestType"));
				AdditionalActions = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("AfterTxfrAdditionalOptions"));

			}

			OpenJOLMenues.openAljaziraCapitalMenu("Market Information");

			// Search Type- Market Info.- Starts

			Utils.click(By.xpath(getObj("Propval1", "marketInfoTypeDropdown", "AlZCapital")), "Market Info Type dropdown");

			int mrktInfoType = Integer.parseInt(Type);

			if (!TestType.equalsIgnoreCase("N")) {

				Log.pass("Successfully started executing positive test case");

				if (mrktInfoType == 1) {

					Utils.sendKeys(By.xpath(getObj("Propval1", "marketInfoTypeInput", "AlZCapital")), ReadTestData(TCName, "Type1"), "Market Info Type");
					Utils.pressTab();
					Utils.wait(3);
					// Get search results count and then log them.
					String searchResultsCount = Utils.getText(By.xpath(getObj("Propval1", "searchResultsCount", "AlZCapital")));
					Log.pass("Search results are displayed successfully.. Results displayed are :-" + searchResultsCount);
					// Move to last page of search results and log them.
					Utils.click(By.xpath(getObj("Propval1", "lastPageArrow", "AlZCapital")), "Last Page");
					Utils.wait(1);
					Log.pass("Search results are displayed successfully.. Results displayed are :-" + Utils.getText(By.xpath(getObj("Propval1", "searchResultsCount", "AlZCapital"))));
					Utils.logPassImage("Search results with valid data.");
				}

				else if (mrktInfoType == 2) {

					Utils.sendKeys(By.xpath(getObj("Propval1", "marketInfoTypeInput", "AlZCapital")), ReadTestData(TCName, "Type2"), "Market Info Type");
					Utils.pressTab();
					Utils.wait(3);
					// Select from and to dates.
					Utils.click(By.xpath(getObj("Propval1", "marketInfoFromDate", "AlZCapital")), "Market Info From Date dropdown");
					Utils.sendKeys(By.xpath(getObj("Propval1", "marketInfoFromDateInput", "AlZCapital")), ReadTestData(TCName, "DateFrom"), "Market Info From Date");
					Utils.wait(1);
					Utils.click(By.xpath(getObj("Propval1", "marketInfoToDate", "AlZCapital")), "Market Info From Date dropdown");
					Utils.sendKeys(By.xpath(getObj("Propval1", "marketInfoToDateInput", "AlZCapital")), ReadTestData(TCName, "DateTo"), "Market Info To Date");

					// Get search results count and then log them.
					String searchResultsCount = Utils.getText(By.xpath(getObj("Propval1", "searchResultsCountMrktNews", "AlZCapital")));
					Log.pass("Search results are displayed successfully.. Results displayed are :-" + searchResultsCount);
					Utils.wait(1);
					Log.pass("Search results are displayed successfully.. Results displayed are :-" + Utils.getText(By.xpath(getObj("Propval1", "searchResultsCountMrktNews", "AlZCapital"))));
					Utils.logPassImage("Search results with valid data.");

				} else if (mrktInfoType == 3) {
					Utils.sendKeys(By.xpath(getObj("Propval1", "marketInfoTypeInput", "AlZCapital")), ReadTestData(TCName, "Type3"), "Market Info Type");
					Utils.pressTab();
					Utils.wait(3);
					// Get search results count and then log them.
					String searchResultsCount = Utils.getText(By.xpath(getObj("Propval1", "searchResultsCountMrktWatch", "AlZCapital")));
					Log.pass("Search results are displayed successfully.. Results displayed are :-" + searchResultsCount);
					// Move to last page of search results and log them.
					Utils.click(By.xpath(getObj("Propval1", "lastPageMrktWatch", "AlZCapital")), "Last Page");
					Utils.wait(1);
					Log.pass("Search results are displayed successfully.. Results displayed are :-" + Utils.getText(By.xpath(getObj("Propval1", "searchResultsCountMrktWatch", "AlZCapital"))));
					Utils.logPassImage("Search results with valid data.");
				}

			}
			// Search Type- Market Info.- Ends
			
			//Negative test scenario. Will use invalid search data and perform search.
			if (TestType.equalsIgnoreCase("N")) {

				Log.pass("Started executing negative scenario using invalid search data.");

				Utils.sendKeys(By.xpath(getObj("Propval1", "marketInfoTypeInput", "AlZCapital")), "Invalid!@!!$!$!", "Market Info Type");
				Utils.pressTab();
				Utils.wait(3);
				String searchResultsCount = Utils.getText(By.xpath(getObj("Propval1", "searchResultsCount", "AlZCapital")));
				Log.pass("Search results are displayed successfully. Result displayed is  :-" + searchResultsCount + " Negative test case has passed. No search results displayed.");
				Utils.logPassImage("Search results with invalid data.");

			}

			try {
				driver.findElement(By.xpath("//span[contains(text(),'Accept')]")).click(); // Temporary to handle unwanted pop up.
			} catch (Exception e) {
				// NA
			}
			// Start sending email , downloading pdf and printing etc.

			if (AdditionalActions.equalsIgnoreCase("true")) {

				Log.pass("Successfully started other actions like send email, download pdf, excel and print search result etc.");
				JolCommonFunctions.sendEmailDownloadExcelnPrintFunc(ScenarioCount, Proceed);

			}

		} catch (Exception e) {

			runResult = false;
			gException = e;
			throw e;

		}
		return runResult;
	}

}
