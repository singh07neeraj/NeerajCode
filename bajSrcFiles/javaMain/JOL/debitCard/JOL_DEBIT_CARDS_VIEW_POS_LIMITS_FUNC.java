package javaMain.JOL.debitCard;

import static Utilities.Input.ReadTestData;
import static Utilities.ReadData.ReadDataSQL;
import static Utilities.ReadData.getObj;
import static javaMain.common_Functions.AppData.AdvanceSearch;
import static javaMain.common_Functions.AppData.AfterTxfrAdditionalOptions;
import static javaMain.common_Functions.AppData.C_ACCT;
import static javaMain.common_Functions.AppData.DebitCard;
import static javaMain.common_Functions.AppData.Frequency;

import org.openqa.selenium.By;

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
public class JOL_DEBIT_CARDS_VIEW_POS_LIMITS_FUNC extends TestBase {

	public static Boolean VIEWPOSLIMITS(String TCName, int ScenarioCount, Object[] tCsDataset) throws Exception {


		try {
			if (isMasterClassRun) {

				Log.info("Data set for this scenario is " + System.lineSeparator() + ReadData.getJsonData(TCName, ScenarioCount, "DataSet"));
				AdvanceSearch = ReadDataSQL(TCName, ScenarioCount, "AdvanceSearch");
				DebitCard = ReadDataSQL(TCName, ScenarioCount, "DebitCard");
				Frequency = ReadDataSQL(TCName, ScenarioCount, "Frequency");
				AfterTxfrAdditionalOptions = ReadDataSQL(TCName, ScenarioCount, "AfterTxfrAdditionalOptions");
				C_ACCT = ReadTestData(TCName, "AccountNumber");// ReadDataSQL(TCName, ScenarioCount, "C_ACCT");

			} else {
				Log.info("Data set for this scenario is " + System.lineSeparator() + dataset[scenarioCount - 1]);

				AdvanceSearch = (String) Utils.getUiData(dataset[scenarioCount - 1]).get("AdvanceSearch");
				DebitCard = (String) Utils.getUiData(dataset[scenarioCount - 1]).get("DebitCard");
				Frequency = (String) Utils.getUiData(dataset[scenarioCount - 1]).get("Frequency");
				AfterTxfrAdditionalOptions = (String) Utils.getUiData(dataset[scenarioCount - 1]).get("AfterTxfrAdditionalOptions");
				C_ACCT = ReadTestData(TCName, "AccountNumber");// Utils.getUiData(dataset[scenarioCount - 1]).get("C_ACCT");

			}

			Utils.scrollUpVertically();
			Utils.pressEnter();
			Utils.refreshScreeen();
			Utils.click(By.xpath(getObj("Propval1", "Cards", "Menues")), "Card Menu");
			Utils.wait(6);

			Utils.click(By.xpath(getObj("Propval1", "DebitCard", "DebitCard_VIEW_POS_LIMITS")), "Debit Card");
			Utils.wait(6);
			Utils.click(By.xpath(getObj("Propval1", "POSLimit", "DebitCard_VIEW_POS_LIMITS")), "POSLimit ");

			String LandPage = Utils.getText(By.xpath(getObj("Propval1", "LandPage", "DebitCard_VIEW_POS_LIMITS")));

			Log.pass("Page title is " + LandPage);

			Utils.logPassImage(TCName);

			if (AfterTxfrAdditionalOptions.equalsIgnoreCase("true")) {
				Log.pass("Starting additional actions after transfer. e.g send email, print and save as favourite.");
				eCorpCommonFunctions.sendEmailDownloadExcelnPrintFunc(ScenarioCount);
				Log.pass("Additional Actions  like send email, print and download pdf/excel etc have  passed successfully.");
				Utils.logPassImage("Additional Actions");

			}

			String expath = "(//*[contains(text(),'" + C_ACCT + "')])[2]//../td[4]/a/img";
			System.out.println("Xpath :" + expath);
			Utils.wait(2);
			Utils.click(By.xpath(expath), "Update POS Limit");
			String UpdatePOS = Utils.getText(By.xpath(getObj("Propval1", "LandPage", "DebitCard_VIEW_POS_LIMITS")));

			Log.pass("Page title is" + UpdatePOS);
			Utils.logPassImage(TCName);

		} catch (Exception e) {

			runResult = false;
			throw e;
		}
		return runResult;
	}

}
