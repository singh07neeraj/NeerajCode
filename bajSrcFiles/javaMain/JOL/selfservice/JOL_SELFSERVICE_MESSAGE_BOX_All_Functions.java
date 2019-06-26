package javaMain.JOL.selfservice;

import static Utilities.ReadData.ReadDataSQL;
import static Utilities.ReadData.getObj;
import static javaMain.common_Functions.AppData.AfterTxfrAdditionalOptions;
import static javaMain.common_Functions.AppData.DateFrom;
import static javaMain.common_Functions.AppData.DateTo;
import static javaMain.common_Functions.AppData.FutureDate;
import static javaMain.common_Functions.AppData.StartDate;
import static javaMain.common_Functions.AppData.Status;
import static javaMain.common_Functions.AppData.TestType;
import static javaMain.common_Functions.AppData.Type;

import org.openqa.selenium.By;

import Utilities.Input;
import Utilities.Log;
import Utilities.ReadData;
import Utilities.TestBase;
import Utilities.Utils;
import javaMain.JOL.transfer.TransferModuleCommonFunctions;

/**
 * Description : Functional Test Script
 * 
 * @author baj80000892
 */
public class JOL_SELFSERVICE_MESSAGE_BOX_All_Functions extends TestBase {

	public static Boolean MessageBox(String TCName, int ScenarioCount, Object[] tCsDataset) throws Exception {

		try {

			if (isMasterClassRun) {

				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + ReadData.getJsonData(TCName, ScenarioCount, "DataSet") + "</mark>");
				AfterTxfrAdditionalOptions = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "AfterTxfrAdditionalOptions"));
				DateFrom = Input.ReadTestData(TCName, "DateFrom");
				DateTo = Input.ReadTestData(TCName, "DateTo");
				Type = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Type"));
				Status = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Status"));
				TestType = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "TestType"));

			} else {
				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + dataset[scenarioCount - 1] + "</mark>");
				AfterTxfrAdditionalOptions = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("AfterTxfrAdditionalOptions"));
				DateFrom = Input.ReadTestData(TCName, "DateFrom");
				DateTo = Input.ReadTestData(TCName, "DateTo");
				Type = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Type"));
				Status = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Status"));
				TestType = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("TestType"));
			}

			if (TestType.equalsIgnoreCase("N")) {
				DateFrom = Input.ReadTestData(TCName, "DateFromInvalid");
				DateTo = Input.ReadTestData(TCName, "DateToInvalid");
			}

			
			Utils.click(By.xpath(getObj("Propval1", "SelfServices", "JOL_SELFSERVICE_MESSAGE_BOX")), "Self Services");
			Utils.click(By.xpath(getObj("Propval1", "msgbox", "JOL_SELFSERVICE_MESSAGE_BOX")), "Message Box");

			// My Financial Position

			String landedPage = Utils.getTextNoException(By.xpath(getObj("Propval1", "LandPage", "JOL_SELFSERVICE_MESSAGE_BOX")));

			Log.info("Landed Page is  :" + landedPage);

			Utils.sendKeys(By.xpath(getObj("Propval1", "FromDate", "JOL_SELFSERVICE_MESSAGE_BOX")), DateFrom, "From Date");

			Utils.pressEnter();
			Utils.sendKeys(By.xpath(getObj("Propval1", "TODate", "JOL_SELFSERVICE_MESSAGE_BOX")), DateTo, "To Date");
			Utils.pressEnter();
			Utils.sendKeys(By.xpath(getObj("Propval1", "type", "JOL_SELFSERVICE_MESSAGE_BOX")), Type, "Type");
			Utils.pressEnter();
			Utils.sendKeys(By.xpath(getObj("Propval1", "status", "JOL_SELFSERVICE_MESSAGE_BOX")), Status, "Status");
			Utils.pressEnter();

			if (TestType.equalsIgnoreCase("N")) {
				
				Log.pass("Starting negative test scenario. Searching using invalid dates");
				Utils.sendKeys(By.xpath(getObj("Propval1", "FromDate", "JOL_SELFSERVICE_MESSAGE_BOX")), DateFrom, "From Date");
				Utils.sendKeys(By.xpath(getObj("Propval1", "TODate", "JOL_SELFSERVICE_MESSAGE_BOX")), DateTo, "To Date");
				int error = Utils.getSizeNoException(By.xpath(getObj("Propval1", "Error", "JOL_SELFSERVICE_MESSAGE_BOX")));
				if (error > 0) {
					Utils.logPassImage("Error Message for Invalid data");
					Log.pass("Error message for invalid dates is appearing as expected. TS passed.");
					return true;
				} else {
					Utils.logFailImage("JError Message for Invalid data-Failed");
					Log.fail("Error message for invalid dates is not appearing. TS failed.");
				}
			}
			else {
				// Click on Search
				Utils.click(By.xpath(getObj("Propval1", "Search", "JOL_SELFSERVICE_MESSAGE_BOX")), "Audit Search");
				Utils.pressEnter();
				Utils.logPassImage("JOL_SELFSERVICE_MESSAGE_BOX");
				Log.pass("Error message for invalid dates is appearing");
			}

		} catch (Exception e) {
			runResult = false;
			throw e;

		}
		return runResult;
	}

	public static boolean AuditLogs(String TCName, int ScenarioCount, Object[] tCsDataset) throws Exception {

		try {

			if (isMasterClassRun) {

				Log.info("Data set for this scenario is " + System.lineSeparator() + ReadData.getJsonData(TCName, ScenarioCount, "DataSet"));
				AfterTxfrAdditionalOptions = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "AfterTxfrAdditionalOptions"));
				StartDate = Input.ReadTestData(TCName, "DateFrom");
				FutureDate = Input.ReadTestData(TCName, "DateTo");

			} else {

				Log.info("Data set for this scenario is " + System.lineSeparator() + dataset[scenarioCount - 1]);
				AfterTxfrAdditionalOptions = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("AfterTxfrAdditionalOptions"));
				StartDate = Input.ReadTestData(TCName, "DateFrom");
				FutureDate = Input.ReadTestData(TCName, "DateTo");
			}

			// OpenMenues.openSelfServicesMenu("AuditLogs");

			Utils.click(By.xpath(getObj("Propval1", "SelfServices", "JOL_SELFSERVICE_MESSAGE_BOX")), "Self Services");
			Utils.click(By.xpath(getObj("Propval1", "AuditLogs", "JOL_SELFSERVICE_MESSAGE_BOX")), "Audit Logs");

			String landedPage = Utils.getTextNoException(By.xpath(getObj("Propval1", "LandPage", "JOL_SELFSERVICE_MESSAGE_BOX")));

			Log.info("Landed Page is  :" + landedPage);

			int x = Utils.getSizeNoException(By.xpath(getObj("Propval1", "AuditSearch", "JOL_SELFSERVICE_MESSAGE_BOX")));
			if (x > 0) {
				Log.info("SELFSERVICE Activity  Logs displayed successfully..................");
			} else {

				Log.error("SELFSERVICE Activity  Logs Page is not displayed..........");
				return runResult;
			}

			Utils.sendKeys(By.xpath(getObj("Propval1", "FromDate", "JOL_SELFSERVICE_MESSAGE_BOX")), StartDate, "From Date");

			Utils.sendKeys(By.xpath(getObj("Propval1", "TODate", "JOL_SELFSERVICE_MESSAGE_BOX")), FutureDate, "To Date");

			Utils.ClearText(By.xpath(getObj("Propval1", "Action", "JOL_SELFSERVICE_MESSAGE_BOX")));
			Utils.sendKeys(By.xpath(getObj("Propval1", "Action", "JOL_SELFSERVICE_MESSAGE_BOX")), Input.ReadTestData("JOL Self Service-Audit logs", "Action"), "Action");

			int CurrencyError = Utils.getSizeNoException(By.xpath(getObj("Propval1", "CurrencyError", "JOL_SELFSERVICE_MESSAGE_BOX")));

			if (CurrencyError > 0) {
				Log.pass("Selected to/ from date or Action is not valid please review and try again");

				return true;
			}

			Utils.click(By.xpath(getObj("Propval1", "AuditSearch", "JOL_SELFSERVICE_MESSAGE_BOX")), "Audit Search");

			String TotalPage = Utils.getTextNoException(By.xpath(getObj("Propval1", "TotalItems", "JOL_SELFSERVICE_MESSAGE_BOX")));

			Log.info("Total Item displayed is  :" + TotalPage);

			if (AfterTxfrAdditionalOptions.equalsIgnoreCase("true")) {
				// sendEmailDownloadExcelnPrintFuncSelfService();
				TransferModuleCommonFunctions.sendEmailDownloadExcelnPrintFunc();

			}

		} catch (Exception e) {
			runResult = false;
			throw e;

		}
		return runResult;
	}

	public static boolean FXRates(String TCName, int ScenarioCount, Object[] tCsDataset) throws Exception {

		try {

			if (isMasterClassRun) {

				Log.info("Data set for this scenario is " + System.lineSeparator() + ReadData.getJsonData(TCName, ScenarioCount, "DataSet"));
				AfterTxfrAdditionalOptions = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "AfterTxfrAdditionalOptions"));

			} else {
				Log.info("Data set for this scenario is " + System.lineSeparator() + dataset[scenarioCount - 1]);
				AfterTxfrAdditionalOptions = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("AfterTxfrAdditionalOptions"));
			}

			Utils.click(By.xpath(getObj("Propval1", "SelfServices", "JOL_SELFSERVICE_MESSAGE_BOX")), "Self Services");

			Utils.click(By.xpath(getObj("Propval1", "RatenCal", "JOL_SELFSERVICE_MESSAGE_BOX")), "Rates and Calculators");

			Utils.click(By.xpath(getObj("Propval1", "FXRate", "JOL_SELFSERVICE_MESSAGE_BOX")), "FXRate");

			// My Financial Position

			String landedPage = Utils.getTextNoException(By.xpath(getObj("Propval1", "LandPage", "JOL_SELFSERVICE_MESSAGE_BOX")));

			Log.info("Landed Page is  :" + landedPage);

			String TotalPage = Utils.getTextNoException(By.xpath(getObj("Propval1", "TotalItems", "JOL_SELFSERVICE_MESSAGE_BOX")));

			Log.info("Total Item displayed is  :" + TotalPage);

			if (AfterTxfrAdditionalOptions.equalsIgnoreCase("TRUE")) {
				
				TransferModuleCommonFunctions.sendEmailDownloadExcelnPrintFunc();
			}

		}

		catch (Exception e) {
			runResult = false;
			throw e;

		}
		return runResult;
	}

}
