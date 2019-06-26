package javaMain.JOL.debitCard;

import static Utilities.Input.ReadTestData;
import static Utilities.ReadData.ReadDataSQL;
import static Utilities.ReadData.getObj;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Utilities.Log;
import Utilities.ReadData;
import Utilities.TestBase;
import Utilities.Utils;
import javaMain.common_Functions.eCorpCommonFunctions;

/**
 * Description : Functional Test Script
 * 
 * @author baj80000892
 */
public class JOL_DEBIT_CARDS_DETAIL_INQUIRY_FUNC extends TestBase {

	public static Boolean DebitCardDetails(String TCName, int ScenarioCount, Object[] tCsDataset) throws Exception {

		try {

			if (isMasterClassRun) {

				Log.info("Data set for this scenario is " + System.lineSeparator() + ReadData.getJsonData(TCName, ScenarioCount, "DataSet"));

			} else {
				Log.info("Data set for this scenario is " + System.lineSeparator() + dataset[scenarioCount - 1]);

			}
			Utils.refreshScreeen();
			Utils.wait(2);
			Utils.pressEnter();
			Utils.scrollUpVertically();
			Utils.click(By.xpath(getObj("Propval1", "Cards", "Menues")), "Card Menu");
			Utils.wait(6);

			Utils.click(By.xpath(getObj("Propval1", "DebitCard", "DebitCard_Details")), "Debit Card");
			Utils.wait(6);
			Utils.click(By.xpath(getObj("Propval1", "Details", "DebitCard_Details")), "Debit Card Details ");

			Log.pass("Successful Debit Card");

			String LandPage = Utils.getText(By.xpath(getObj("Propval1", "LandPage", "DebitCard_Details")));

			Log.pass("Page title is " + LandPage);

			Utils.click(By.xpath(getObj("Propval1", "Table", "DebitCard_Details")), "Table");
			Log.pass("Successful Debit Card Table ");

			Utils.wait(6);

		} catch (Exception e) {
			runResult = false;
			throw e;
		}
		return runResult;
	}

	public static Boolean Transactions(String TCName, int ScenarioCount, Object[] tCsDataset) throws Exception {

		String AdvanceSearch, DebitCard, Frequency, AfterTxfrAdditionalOptions;

		try {
			if (isMasterClassRun) {

				Log.info("Data set for this scenario is " + System.lineSeparator() + ReadData.getJsonData(TCName, ScenarioCount, "DataSet"));

				AdvanceSearch = ReadDataSQL(TCName, ScenarioCount, "AdvanceSearch");
				DebitCard =ReadTestData(TCName, "DebitCard")  ;//ReadDataSQL(TCName, ScenarioCount, "DebitCard");
				Frequency = ReadTestData(TCName, "Frequency"); //ReadDataSQL(TCName, ScenarioCount, "Frequency");
				AfterTxfrAdditionalOptions = ReadDataSQL(TCName, ScenarioCount, "AfterTxfrAdditionalOptions");

			} else {
				Log.info("Data set for this scenario is " + System.lineSeparator() + dataset[scenarioCount - 1]);

				AdvanceSearch = (String) Utils.getUiData(dataset[scenarioCount - 1]).get("AdvanceSearch");
				DebitCard = ReadTestData(TCName, "DebitCard")  ;//Utils.getUiData(dataset[scenarioCount - 1]).get("DebitCard");
				Frequency = ReadTestData(TCName, "Frequency"); // Utils.getUiData(dataset[scenarioCount - 1]).get("Frequency");
				AfterTxfrAdditionalOptions = (String) Utils.getUiData(dataset[scenarioCount - 1]).get("AfterTxfrAdditionalOptions");

			}

			Utils.scrollUpVertically();
			Utils.pressEnter();
			Utils.refreshScreeen();
			Utils.click(By.xpath(getObj("Propval1", "Cards", "Menues")), "Card Menu");

			Utils.click(By.xpath(getObj("Propval1", "DebitCard", "DebitCard_Transaction")), "Debit Card");

			Utils.click(By.xpath(getObj("Propval1", "Transaction", "DebitCard_Transaction")), "Transaction ");

			String LandPage = Utils.getText(By.xpath(getObj("Propval1", "LandPage", "DebitCard_Transaction")));

			Log.pass("Page title is " + LandPage);

			Utils.ClearText(By.xpath(getObj("Propval1", "DebitCardType", "DebitCard_Transaction")));

			Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "DebitCardDropdown", "DebitCard_Transaction")), By.xpath(getObj("Propval1", "DebitCardType", "DebitCard_Transaction")), DebitCard);

			Log.pass("Debit Card Number is : " + DebitCard);

			Utils.ClearText(By.xpath(getObj("Propval1", "Period", "DebitCard_Transaction")));
			Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "PeriodDropdown", "DebitCard_Transaction")), By.xpath(getObj("Propval1", "Period", "DebitCard_Transaction")), Frequency);

			if (Integer.parseInt(AdvanceSearch) == 1) {
				Utils.click(By.xpath(getObj("Propval1", "AdvanceSearch", "DebitCard_Transaction")), "Advance Search");
				
				WebElement StartDate = driver.findElement(By.xpath(getObj("Propval1", "StartDate", "DebitCard_Transaction")));
				//StartDate.sendKeys(Utils.DateValue((Integer.parseInt(ReadDataSQL(TCName, ScenarioCount, "NextDate")))));
				StartDate.sendKeys(ReadTestData(TCName, "NextDate"));
				
				WebElement endtDate = driver.findElement(By.xpath(getObj("Propval1", "EndDate", "DebitCard_Transaction")));
				//endtDate.sendKeys(Utils.DateValue((Integer.parseInt(ReadDataSQL(TCName, ScenarioCount, "FutureDate")))));
				endtDate.sendKeys(ReadTestData(TCName, "FutureDate"));

				Utils.click(By.xpath(getObj("Propval1", "Search2", "DebitCard_Transaction")), "Advance Search ");
			}

			else {
				Utils.click(By.xpath(getObj("Propval1", "Search", "DebitCard_Transaction")), "Search ");
			}

		
			String msg = Utils.getText(By.xpath(getObj("Propval1", "msg", "DebitCard_Transaction")));
				Log.pass("total  result displayed is " + msg);
				Utils.logPassImage("total  result displayed is " + msg);

			if (AfterTxfrAdditionalOptions.equalsIgnoreCase("true")) {
				Log.pass("Starting additional actions after transfer. e.g send email, print and save as favourite.");
				eCorpCommonFunctions.sendEmailDownloadExcelnPrintFunc(ScenarioCount);
				Log.pass("Additional Actions  like send email, print and download pdf/excel etc have  passed successfully.");
				Utils.logPassImage("Additional Actions");
			}
		} catch (Exception e) {

			runResult = false;
			e.printStackTrace();
		}
		return runResult;
	}

}
