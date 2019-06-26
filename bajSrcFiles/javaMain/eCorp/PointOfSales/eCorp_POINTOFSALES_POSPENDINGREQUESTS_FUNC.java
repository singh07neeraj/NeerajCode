package javaMain.eCorp.PointOfSales;

import static Utilities.ReadData.ReadDataSQL;
import static Utilities.ReadData.getObj;
import static javaMain.common_Functions.AppData.AfterTxfrAdditionalOptions;
import static javaMain.common_Functions.AppData.EndDate;
import static javaMain.common_Functions.AppData.NewTxn;
import static javaMain.common_Functions.AppData.RequestType;
import static javaMain.common_Functions.AppData.StartDate;
import static javaMain.common_Functions.AppData.Status;
import static javaMain.common_Functions.AppData.TicketId;
import static javaMain.common_Functions.AppData.isNegative;
import static javaMain.common_Functions.AppData.other;
import static javaMain.common_Functions.AppData.otherActions;

import org.openqa.selenium.By;

import Utilities.Input;
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
public class eCorp_POINTOFSALES_POSPENDINGREQUESTS_FUNC extends TestBase {

	public static Boolean POSPendingRequests(String TCName, int ScenarioCount, Object[] tCsDataset) {
		
		try {

			if (isMasterClassRun) {

				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + ReadData.getJsonData(TCName, ScenarioCount, "DataSet") + "</mark>");

				AfterTxfrAdditionalOptions = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "AfterTxfrAdditionalOptions"));
				StartDate = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "StartDate"));
				EndDate = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "EndDate"));
				Status = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Status"));
				RequestType = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "RequestType"));
				other = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "other"));
				TicketId = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "TicketId"));
				isNegative = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "isNegative"));
				NewTxn = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "NewTxn"));

				otherActions = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "otherActions"));
			} else {

				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + dataset[scenarioCount - 1] + "</mark>");

				AfterTxfrAdditionalOptions = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("AfterTxfrAdditionalOptions"));
				StartDate = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("StartDate"));
				EndDate = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("EndDate"));
				Status = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Status"));
				RequestType = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("RequestType"));
				other = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("other"));
				TicketId = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("TicketId"));
				isNegative = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("isNegative"));
				NewTxn = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("NewTxn"));
				otherActions = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("otherActions"));

			}
			Utils.refreshScreeen();
			Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "WaitingElements", "eCorp_PointOfSales_POSPendingRequests")));

			Utils.click(By.xpath(getObj("Propval1", "PointOfSales", "eCorp_PointOfSales_POSPendingRequests")), "Goverment Service Menu");

			Utils.click(By.xpath(getObj("Propval1", "POSPendingRequests", "eCorp_PointOfSales_POSPendingRequests")), "Goverment Serivce reFund");

			String LandPage = Utils.getText(By.xpath(getObj("Propval1", "LandPage", "eCorp_PointOfSales_POSPendingRequests")));

			Log.pass("Page title is " + LandPage);

			Utils.sendKeys(By.xpath(getObj("Propval1", "StartDate", "eCorp_PointOfSales_POSPendingRequests")), StartDate, "StartDate");

			Utils.sendKeys(By.xpath(getObj("Propval1", "EndDate", "eCorp_PointOfSales_POSPendingRequests")), EndDate, "EndDate");
			Utils.sendKeys(By.xpath(getObj("Propval1", "Status", "eCorp_PointOfSales_POSPendingRequests")), Status, "Status");
			Utils.sendKeys(By.xpath(getObj("Propval1", "TicketId", "eCorp_PointOfSales_POSPendingRequests")), TicketId, "TicketId");
			Utils.sendKeys(By.xpath(getObj("Propval1", "RequestType", "eCorp_PointOfSales_POSPendingRequests")), RequestType, "RequestType");

			if (AppData.getLanguage().equalsIgnoreCase("Arabic")) {
				Utils.click(By.xpath(getObj("Propval1", "SearchArabic", "eCorp_PointOfSales_POSPendingRequests")), "Search");
			} else {
				Utils.click(By.xpath(getObj("Propval1", "Search", "eCorp_PointOfSales_POSPendingRequests")), "Search");
			}

			String searchResult2 = Utils.getText(By.xpath(getObj("Propval1", "searchResult2", "eCorp_PointOfSales_POSPendingRequests")));

			Log.pass("Result :" + searchResult2);
			Utils.logPassImage(TCName);

			if (AfterTxfrAdditionalOptions.equalsIgnoreCase("true")) {
				Log.pass("Starting additional actions after transfer. e.g send email, print and save as favourite.");
				eCorpCommonFunctions.sendEmailDownloadExcelnPrintFunc(ScenarioCount);
				Log.pass("Additional Actions  like send email, print and download pdf/excel etc have  passed successfully.");
				Utils.logPassImage("Additional Actions");
			}

		} catch (

		Exception e) {

			runResult = false;
			e.printStackTrace();
		}
		return runResult;
	}

	public static boolean addFavSendEmailDownloadPdfNprintFuncBeneficiary(String Nickname) throws Exception {

		try {
			// Start sending email , downloading pdf and printing etc.
			Utils.wait(3);
			Log.info("Starting send email functionality");

			Utils.click(By.xpath(getObj("Propval1", "sendEmailIcon", "eCorp_PointOfSales_POSPendingRequests")), "Send Email Icon");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailTo", "eCorp_PointOfSales_POSPendingRequests")), Input.ReadTestData("MarketInfo", "toEmail"), "to email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailCC", "eCorp_PointOfSales_POSPendingRequests")), Input.ReadTestData("MarketInfo", "ccEmail"), "to CC email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "bccEmail", "eCorp_PointOfSales_POSPendingRequests")), Input.ReadTestData("MarketInfo", "bccEmail"), "to BCC  email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "emailSubject", "eCorp_PointOfSales_POSPendingRequests")), Input.ReadTestData("MarketInfo", "emailSubject"), "email Subject ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEMailMsgBox", "eCorp_PointOfSales_POSPendingRequests")), Input.ReadTestData("MarketInfo", "sendEMailMsgBox"), "Mail Body ");

			Utils.click(By.xpath(getObj("Propval1", "cancelemailBtnEle", "eCorp_PointOfSales_POSPendingRequests")), "Cancel Email Button");
			Utils.wait(5);
			Utils.click(By.xpath(getObj("Propval1", "sendEmailIcon", "eCorp_PointOfSales_POSPendingRequests")), "Send Email Icon");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailTo", "eCorp_PointOfSales_POSPendingRequests")), Input.ReadTestData("MarketInfo", "toEmail"), "to email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailCC", "eCorp_PointOfSales_POSPendingRequests")), Input.ReadTestData("MarketInfo", "ccEmail"), "to CC email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "bccEmail", "eCorp_PointOfSales_POSPendingRequests")), Input.ReadTestData("MarketInfo", "bccEmail"), "to BCC  email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "emailSubject", "eCorp_PointOfSales_POSPendingRequests")), Input.ReadTestData("MarketInfo", "emailSubject"), "email Subject ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEMailMsgBox", "eCorp_PointOfSales_POSPendingRequests")), Input.ReadTestData("MarketInfo", "sendEMailMsgBox"), "Mail Body ");
			Utils.wait(5);
			Utils.click(By.xpath(getObj("Propval1", "sendBtnEle", "eCorp_PointOfSales_POSPendingRequests")), "Send Email Button");
			Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "WaitingElements", "eCorp_PointOfSales_POSPendingRequests")));
			Utils.pressEnter();
			Utils.wait(2);
			Utils.pressEscapeKey(3);

			Utils.pressEscapeKey(3);
			driver.navigate().refresh();
			// Download report in pdf format.
			Utils.click(By.xpath(getObj("Propval1", "pdfDownloadIcon", "eCorp_PointOfSales_POSPendingRequests")), "pdf download");
			Utils.wait(3);
			Utils.closeOtherTabs();
			Utils.moveToElement(By.id("logo"));
			driver.navigate().refresh();
			Utils.click(By.xpath(getObj("Propval1", "excelDownloadIcon", "eCorp_PointOfSales_POSPendingRequests")), "excel Download Icon");
			Utils.wait(3);
			// Utils.enterOTPAndProceed();
			Utils.moveToElement(By.id("logo"));
			// Print report.
			Utils.wait(6);
			driver.navigate().refresh();
			Utils.click(By.xpath(getObj("Propval1", "printBtnIcon", "eCorp_PointOfSales_POSPendingRequests")), "Print Button");
			// close all other tabs except the main one. i.e 1st page.
			Utils.closeOtherTabs();

		}

		catch (Exception e) {
			Log.error("Unable to send email semail, print and download pdf etc.");
			Utils.logFailImage("Error");
			runResult = false;
			throw e;

		}

		return runResult;
	}

}
