package javaMain.eCorp.PointOfSales;

import static Utilities.ReadData.ReadDataSQL;
import static Utilities.ReadData.getObj;
import static javaMain.common_Functions.AppData.AfterTxfrAdditionalOptions;
import static javaMain.common_Functions.AppData.City;
import static javaMain.common_Functions.AppData.Menu;
import static javaMain.common_Functions.AppData.NewTxn;
import static javaMain.common_Functions.AppData.POSID;
import static javaMain.common_Functions.AppData.RequestType;
import static javaMain.common_Functions.AppData.TicketId;
import static javaMain.common_Functions.AppData.isNegative;
import static javaMain.common_Functions.AppData.other;
import static javaMain.common_Functions.AppData.otherActions;

import org.openqa.selenium.By;
import org.testng.Assert;

import Utilities.Log;
import Utilities.ReadData;
import Utilities.TestBase;
import Utilities.Utils;
import javaMain.common_Functions.AppData;
import javaMain.common_Functions.eCorpCommonFunctions;
/**
 * Description : Functional Test Script
 * 
 * @author baj80000892
 */
public class eCorp_POINTOFSALES_POSMANAGEMENT_FUNC extends TestBase {

	public static Boolean POSMANAGEMENT(String TCName, int ScenarioCount, Object[] tCsDataset) throws Exception {
		
		try {

			if (isMasterClassRun) {

				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + ReadData.getJsonData(TCName, ScenarioCount, "DataSet") + "</mark>");

				AfterTxfrAdditionalOptions = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "AfterTxfrAdditionalOptions"));
				POSID = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "POSID"));
				City = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "City"));
				Menu = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Menu"));
				RequestType = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "RequestType"));
				other = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "other"));
				TicketId = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "TicketId"));
				isNegative = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "isNegative"));
				NewTxn = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "NewTxn"));
				otherActions = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "otherActions"));
				
			} else {

				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + dataset[scenarioCount - 1] + "</mark>");

				AfterTxfrAdditionalOptions = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("AfterTxfrAdditionalOptions"));
				POSID = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("POSID"));
				City = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("City"));
				Menu = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Menu"));
				RequestType = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("RequestType"));
				other = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("other"));
				TicketId = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("TicketId"));
				isNegative = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("isNegative"));
				NewTxn = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("NewTxn"));
				otherActions = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("otherActions"));

			}

			Utils.refreshScreeen();
			Utils.click(By.xpath(getObj("Propval1", "PointOfSales", "eCorp_PointOfSales_POSManagement")), "Point Of Sales");

			Utils.click(By.xpath(getObj("Propval1", "POSManagement", "eCorp_PointOfSales_POSManagement")), "Goverment Serivce reFund");
			Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "WaitingElements", "eCorp_PointOfSales_POSManagement")));

			String LandPage = Utils.getText(By.xpath(getObj("Propval1", "LandPage", "eCorp_PointOfSales_POSManagement")));

			Log.pass("Page title is " + LandPage);

			Utils.sendKeys(By.xpath(getObj("Propval1", "POSID", "eCorp_PointOfSales_POSManagement")), POSID, "POS ID");

			Utils.sendKeys(By.xpath(getObj("Propval1", "city", "eCorp_PointOfSales_POSManagement")), City, "City");
			Utils.wait(2);
			if (isNegative.equalsIgnoreCase("true")) {
				try {
					Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "error", "eCorp_PointOfSales_POSManagement")), "Invalid data"));
					Log.pass("Not able to search with invalid data. Please review the page again");
					Utils.logPassImage(TCName);
					return true;
				}

				catch (AssertionError | Exception e) {
					Log.fail("Able to search with invalid data please mark isNegative true or review the page");
					Utils.logFailImage(TCName);
					throw e;
				}

			}

			if (AppData.getLanguage().equalsIgnoreCase("Arabic")) {
				Utils.click(By.xpath(getObj("Propval1", "SearchArabic", "eCorp_PointOfSales_POSManagement")), "Search");
			} else {
				Utils.click(By.xpath(getObj("Propval1", "Search", "eCorp_PointOfSales_POSManagement")), "Search");
			}
			String Result = Utils.getText(By.xpath(getObj("Propval1", "Result", "eCorp_PointOfSales_POSManagement")));

			Log.pass("Result :" + Result);
			Utils.logPassImage(TCName);

			String posidxpath = "//*[contains(text(),'" + POSID + "')]//../td[4]";

			Utils.click(By.xpath(posidxpath), "Click on POSID ");

			if (Menu.equalsIgnoreCase("ClaimRequest")) {
				if (AppData.getLanguage().equalsIgnoreCase("Arabic")) {
					Utils.click(By.xpath(getObj("Propval1", "ClaimRequestArabic", "eCorp_PointOfSales_POSManagement")), "Claim Request");
				} else {
					Utils.click(By.xpath(getObj("Propval1", "ClaimRequest", "eCorp_PointOfSales_POSManagement")), "Claim Request");
				}

				String ClaimRequest1 = Utils.getText(By.xpath(getObj("Propval1", "LandPage", "eCorp_PointOfSales_POSManagement")));

				Log.pass("Page title is " + ClaimRequest1);
				Utils.logPassImage(TCName);
			} else {
				if (AppData.getLanguage().equalsIgnoreCase("Arabic")) {
					Utils.click(By.xpath(getObj("Propval1", "MaintenanceRequestArabic", "eCorp_PointOfSales_POSManagement")), "Claim Request");
				} else {
					Utils.click(By.xpath(getObj("Propval1", "MaintenanceRequest", "eCorp_PointOfSales_POSManagement")), "Claim Request");
				}
				String ClaimRequest1 = Utils.getText(By.xpath(getObj("Propval1", "LandPage", "eCorp_PointOfSales_POSManagement")));

				Log.pass("Page title is " + ClaimRequest1);
				Utils.logPassImage(TCName);
			}
			Utils.click(By.xpath(getObj("Propval1", "POSManagement", "eCorp_PointOfSales_POSManagement")), "Goverment Serivce reFund");

			if (AfterTxfrAdditionalOptions.equalsIgnoreCase("true")) {
				Log.pass("Starting additional actions after transfer. e.g send email, print and save as favourite.");
				eCorpCommonFunctions.sendEmailDownloadExcelnPrintFunc(ScenarioCount);
				Log.pass("Additional Actions  like send email, print and download pdf/excel etc have  passed successfully.");
				Utils.logPassImage("Additional Actions");
			}

		} catch (

		Exception e) {
			runResult = false;
			throw e;

		}
		return runResult;
	}

}
