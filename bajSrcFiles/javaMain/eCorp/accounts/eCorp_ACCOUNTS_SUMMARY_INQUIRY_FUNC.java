package javaMain.eCorp.accounts;

import static Utilities.ReadData.ReadDataSQL;
import static Utilities.ReadData.getObj;
import static javaMain.common_Functions.AppData.AfterTxfrAdditionalOptions;

import org.openqa.selenium.By;
import org.testng.Assert;

import Utilities.Input;
import Utilities.Log;
import Utilities.TestBase;
import Utilities.Utils;
import javaMain.common_Functions.eCorpCommonFunctions;

/**
 * Description : Functional Test Script
 * 
 * @author baj80000892
 */
public class eCorp_ACCOUNTS_SUMMARY_INQUIRY_FUNC extends TestBase {

	public static boolean eCorpAccountsSummaryEnquiryFunction(String TCName, int ScenarioCount, Object[] tCsDataset) throws Exception {

		try {

			if (isMasterClassRun) {
				AfterTxfrAdditionalOptions = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "AfterTxfrAdditionalOptions"));
			}

			else {
				AfterTxfrAdditionalOptions = (String) Utils.getUiData(dataset[scenarioCount - 1]).get("AfterTxfrAdditionalOptions");
			}

			// click on Account Top
			Utils.click(By.xpath(getObj("Propval1", "Accounts", "eCorp_ACCOUNTS_SUMMARY_INQUIRY")), "Accounts link");
			// Click on Account Summary
			Utils.click(By.xpath(getObj("Propval1", "summary", "eCorp_ACCOUNTS_SUMMARY_INQUIRY")), "Accounts Summary link");

			Utils.wait(5);
			String AccountDetails = "//*[contains(text(),'" + Input.ReadTestData(TCName, "AccountNumber") + "')]";
			
			Utils.click(By.xpath(AccountDetails), "Click on Account Number");
			try {
				Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "DetailsPage", "eCorp_ACCOUNTS_SUMMARY_INQUIRY")), "Details Page"));
				Log.pass("Account Details Page is dsiplayed");
				Utils.logPassImage(TCName);
			} catch (Exception e) {

				Log.fail("Account Details Page is not dsiplayed");
				Utils.logFailImage(TCName);

			}

			// Click on Account Summary
			Utils.click(By.xpath(getObj("Propval1", "summary", "eCorp_ACCOUNTS_SUMMARY_INQUIRY")), "Accounts Summary link");

			if (AfterTxfrAdditionalOptions.equalsIgnoreCase("true")) {
				
				Log.pass("Starting additional actions after transfer. e.g send email, print and save as favourite.");
				eCorpCommonFunctions.sendEmailDownloadExcelnPrintFunc(ScenarioCount);
				Log.pass("Additional Actions  like send email, print and download pdf/excel etc have  passed successfully.");
				Utils.logPassImage("Additional Actions");

			}
		}

		catch (Exception e) {
			runResult = false;
			throw e;
		}
		return runResult;
	}

}
