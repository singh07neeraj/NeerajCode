package javaMain.eCorp.selfservice;

import static Utilities.ReadData.ReadDataSQL;
import static Utilities.ReadData.getObj;
import static javaMain.common_Functions.AppData.AfterTxfrAdditionalOptions;
import static javaMain.common_Functions.AppData.FutureDate;
import static javaMain.common_Functions.AppData.StartDate;
import static javaMain.common_Functions.AppData.Status;
import static javaMain.common_Functions.AppData.TestType;
import static javaMain.common_Functions.AppData.Type;
import static javaMain.common_Functions.AppData.isNegative;
import static javaMain.common_Functions.AppData.otherActions;

import org.openqa.selenium.By;
import org.testng.Assert;

import Utilities.Log;
import Utilities.ReadData;
import Utilities.TestBase;
import Utilities.Utils;
import javaMain.common_Functions.AppData;
import javaMain.common_Functions.JolCommonFunctions;
import javaMain.common_Functions.eCorpCommonFunctions;

/**
 * Description : Functional Test Script
 * 
 * @author baj80000892
 */
public class eCorp_SELFSERVICE_MESSAGE_BOX_All_Functions extends TestBase {

	public static Boolean MessageBox(String TCName, int ScenarioCount, Object[] tCsDataset) throws Exception {

		try {

			if (isMasterClassRun) {

				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + ReadData.getJsonData(TCName, ScenarioCount, "DataSet") + "</mark>");
				AfterTxfrAdditionalOptions = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "AfterTxfrAdditionalOptions"));
				StartDate = Utils.DateValue(Integer.parseInt(ReadDataSQL(TCName, ScenarioCount, "StartDate")));
				FutureDate = Utils.DateValue(Integer.parseInt(ReadDataSQL(TCName, ScenarioCount, "FutureDate")));
				Type = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Type"));
				Status = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Status"));
				TestType = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "TestType"));

			} else {
				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + dataset[scenarioCount - 1] + "</mark>");
				AfterTxfrAdditionalOptions = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("AfterTxfrAdditionalOptions"));
				StartDate = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("StartDate"));
				FutureDate = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("FutureDate"));
				Type = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Type"));
				Status = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Status"));
				TestType = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("TestType"));
			}

			Utils.click(By.xpath(getObj("Propval1", "SelfServices", "eCorp_SELFSERVICE_MESSAGE_BOX")), "Self Services");
			Utils.click(By.xpath(getObj("Propval1", "msgbox", "eCorp_SELFSERVICE_MESSAGE_BOX")), "Message Box");

			// My Financial Position

			String landedPage = Utils.getText(By.xpath(getObj("Propval1", "LandPage", "eCorp_SELFSERVICE_MESSAGE_BOX")));
			Log.info("Landed Page is  :" + landedPage);
			Utils.sendKeys(By.xpath(getObj("Propval1", "FromDate", "eCorp_SELFSERVICE_MESSAGE_BOX")), StartDate, "From Date");
			Utils.pressEnter();
			Utils.sendKeys(By.xpath(getObj("Propval1", "TODate", "eCorp_SELFSERVICE_MESSAGE_BOX")), FutureDate, "To Date");
			Utils.pressEnter();
			Utils.sendKeys(By.xpath(getObj("Propval1", "type", "eCorp_SELFSERVICE_MESSAGE_BOX")), Type, "Type");
			Utils.pressEnter();
			Utils.sendKeys(By.xpath(getObj("Propval1", "status", "eCorp_SELFSERVICE_MESSAGE_BOX")), Status, "Status");
			Utils.pressEnter();

			if (TestType.equalsIgnoreCase("N")) {

				try {
					Log.pass("Starting negative test case. Searching using invalid data.");
					Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "Error", "eCorp_SELFSERVICE_MESSAGE_BOX")), "Result Details."));
					Log.pass("Enter Data fields  is not valid please enter the valid date ");
					Utils.logPassImage(TCName);
					return true;

				} catch (AssertionError | Exception e) {
					Log.fail("unaccepted error occur please review the home page");
					Utils.logFailImage(TCName);
					throw e;

				}

			}

			if (AppData.getLanguage().equalsIgnoreCase("Arabic")) {
				Utils.click(By.xpath(getObj("Propval1", "SearchArabic", "eCorp_SELFSERVICE_MESSAGE_BOX")), "Audit Search");
				Utils.pressEnter();
			} else {
				Utils.click(By.xpath(getObj("Propval1", "Search", "eCorp_SELFSERVICE_MESSAGE_BOX")), "Audit Search");
				Utils.pressEnter();
			}

			if (AfterTxfrAdditionalOptions.equalsIgnoreCase("TRUE")) {
				Log.pass("Starting additional actions after transfer. e.g send email, print and save as favourite.");
				JolCommonFunctions.sendEmailDownloadExcelnPrintFunc(ScenarioCount);
				Log.pass("Additional Actions  like send email, print and download pdf/excel etc have  passed successfully.");
				Utils.logPassImage("Additional Actions");

			}

			Utils.logPassImage(TCName);
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
				StartDate = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "StartDate"));
				FutureDate = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "FutureDate"));
				otherActions = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "otherActions"));
				Status = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Status"));
				isNegative = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "isNegative"));

			} else {
				Log.info("Data set for this scenario is " + System.lineSeparator() + dataset[scenarioCount - 1]);
				AfterTxfrAdditionalOptions = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("AfterTxfrAdditionalOptions"));
				StartDate = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("StartDate"));
				FutureDate = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("FutureDate"));
				otherActions = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("otherActions"));
				Status = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Status"));
				isNegative = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("isNegative"));
			}

			// OpenMenues.openSelfServicesMenu("AuditLogs");

			Utils.click(By.xpath(getObj("Propval1", "SelfServices", "eCorp_SELFSERVICE_MESSAGE_BOX")), "Self Services");
			Utils.click(By.xpath(getObj("Propval1", "AuditLogs", "eCorp_SELFSERVICE_MESSAGE_BOX")), "Audit Logs");

			String landedPage = Utils.getText(By.xpath(getObj("Propval1", "LandPage", "eCorp_SELFSERVICE_MESSAGE_BOX")));

			Log.info("Landed Page is  :" + landedPage);

			Utils.sendKeys(By.xpath(getObj("Propval1", "ActivityFromDate", "eCorp_SELFSERVICE_MESSAGE_BOX")), StartDate, "From Date");

			Utils.sendKeys(By.xpath(getObj("Propval1", "ActivityTODate", "eCorp_SELFSERVICE_MESSAGE_BOX")), FutureDate, "To Date");

			Utils.ClearText(By.xpath(getObj("Propval1", "Action", "eCorp_SELFSERVICE_MESSAGE_BOX")));
			Utils.sendKeys(By.xpath(getObj("Propval1", "Action", "eCorp_SELFSERVICE_MESSAGE_BOX")), otherActions, "Action");

			Utils.ClearText(By.xpath(getObj("Propval1", "Activitystatus", "eCorp_SELFSERVICE_MESSAGE_BOX")));
			Utils.sendKeys(By.xpath(getObj("Propval1", "Activitystatus", "eCorp_SELFSERVICE_MESSAGE_BOX")), Status, "Status");

			if (isNegative.equalsIgnoreCase("true")) {

				try {

					Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "Error", "eCorp_SELFSERVICE_MESSAGE_BOX")), "Error"));
					Log.pass("Search result is not displayed on screen with invalid values hence test case pass");
					Utils.logPassImage(TCName);
				} catch (AssertionError | Exception e) {

					Log.fail("No error message occour with invalid values hence test case fail");
					Utils.logFailImage(TCName);
					throw e;
				}
			}
			Utils.click(By.xpath(getObj("Propval1", "AuditSearch", "eCorp_SELFSERVICE_MESSAGE_BOX")), "Audit Search");

			String TotalPage = Utils.getText(By.xpath(getObj("Propval1", "TotalItems", "eCorp_SELFSERVICE_MESSAGE_BOX")));

			Log.info("Total Items displayed on screen are  :" + TotalPage);

			if (AfterTxfrAdditionalOptions.equalsIgnoreCase("TRUE")) {
				Log.pass("Starting additional actions after transfer. e.g send email, print and save as favourite.");
				JolCommonFunctions.sendEmailDownloadExcelnPrintFunc(ScenarioCount);
				Log.pass("Additional Actions  like send email, print and download pdf/excel etc have  passed successfully.");
				Utils.logPassImage("Additional Actions");
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
				AfterTxfrAdditionalOptions = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "AfterTxfrAdditionalOptions"));//

			} else {
				Log.info("Data set for this scenario is " + System.lineSeparator() + dataset[scenarioCount - 1]);
				AfterTxfrAdditionalOptions = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("AfterTxfrAdditionalOptions"));
			}

			Utils.click(By.xpath(getObj("Propval1", "SelfServices", "eCorp_SELFSERVICE_MESSAGE_BOX")), "Self Services");
			Utils.click(By.xpath(getObj("Propval1", "FXRate", "eCorp_SELFSERVICE_MESSAGE_BOX")), "Rates and Calculators");

			// My Financial Position
			String landedPage = Utils.getText(By.xpath(getObj("Propval1", "LandPage", "eCorp_SELFSERVICE_MESSAGE_BOX")));
			Log.info("Landed Page is  :" + landedPage);
			String TotalPage = Utils.getText(By.xpath(getObj("Propval1", "TotalItems", "eCorp_SELFSERVICE_MESSAGE_BOX")));
			Log.info("Total Item displayed is  :" + TotalPage);

			if (AfterTxfrAdditionalOptions.equalsIgnoreCase("true")) {
				eCorpCommonFunctions.sendEmailDownloadExcelnPrintFunc(ScenarioCount);
			}
		}

		catch (Exception e) {
			runResult = false;
			throw e;

		}
		return runResult;
	}

	

	
}
