package javaMain.eCorp.selfservice;

import static Utilities.ReadData.ReadDataSQL;
import static Utilities.ReadData.getObj;
import static javaMain.common_Functions.AppData.AfterTxfrAdditionalOptions;
import static javaMain.common_Functions.AppData.FutureDate;
import static javaMain.common_Functions.AppData.StartDate;
import static javaMain.common_Functions.AppData.TestType;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.openqa.selenium.By;
import org.testng.Assert;

import Utilities.Input;
import Utilities.Log;
import Utilities.ReadData;
import Utilities.TestBase;
import Utilities.Utils;
import javaMain.common_Functions.AppData;
/**
 * Description : Functional Test Script
 * 
 * @author baj80000892
 */
public class eCorp_SELFSERVICE_ORDERSTATUS_FUNC extends TestBase {

	public static Boolean OrderStatus(String TCName, int ScenarioCount, Object[] tCsDataset) throws Exception {

		try {

			if (isMasterClassRun) {

				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + ReadData.getJsonData(TCName, ScenarioCount, "DataSet") + "</mark>");
				ReadData.getJsonData(TCName, ScenarioCount, "DataSet");

				TestType = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "TestType"));
				AfterTxfrAdditionalOptions = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "AfterTxfrAdditionalOptions"));

				if (TestType.equalsIgnoreCase("P")) {

					StartDate = Utils.DateValue(Integer.parseInt(ReadDataSQL(TCName, ScenarioCount, "StartDate")));
					FutureDate = Utils.DateValue(Integer.parseInt(ReadDataSQL(TCName, ScenarioCount, "FutureDate")));
				} else {
					StartDate = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "StartDate"));
					FutureDate = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "FutureDate"));
				}

			} else {

				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + dataset[scenarioCount - 1] + "</mark>");
				AfterTxfrAdditionalOptions = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("AfterTxfrAdditionalOptions"));
				TestType = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("TestType"));

				if (TestType.equalsIgnoreCase("P")) {
					StartDate = Utils.DateValue(Integer.parseInt(ReadDataSQL(TCName, ScenarioCount, "StartDate")));
					FutureDate = Utils.DateValue(Integer.parseInt(ReadDataSQL(TCName, ScenarioCount, "FutureDate")));
				} else {
					StartDate = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("StartDate"));
					FutureDate = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("FutureDate"));
				}

			}

			Utils.click(By.xpath(getObj("Propval1", "SelfServices", "eCorp_SELFSERVICE_ORDERSTATUS")), "Self Services");

			Utils.click(By.xpath(getObj("Propval1", "OrderStatus", "eCorp_SELFSERVICE_ORDERSTATUS")), "Order Status");

			Utils.wait(6);

			// My Financial Position

			String StatusPage = Utils.getText(By.xpath(getObj("Propval1", "landedPage", "eCorp_SELFSERVICE_ORDERSTATUS")));

			Log.pass("Order Status Page is Landed With Text Value:" + StatusPage);

			Utils.sendKeys(By.xpath(getObj("Propval1", "FromDate", "eCorp_SELFSERVICE_ORDERSTATUS")), StartDate, "From Date");
			Utils.sendKeys(By.xpath(getObj("Propval1", "TODate", "eCorp_SELFSERVICE_ORDERSTATUS")), FutureDate, "To Date");
			if (AfterTxfrAdditionalOptions.equalsIgnoreCase("TRUE")) {
				sendEmailDownloadExcelnPrintFuncOrderStatus();
			}

			if (TestType.equalsIgnoreCase("N")) {

				try {

					Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "error", "eCorp_SELFSERVICE_ORDERSTATUS")), "error"));
					Log.pass("Error Message Appeared Successfully");
					Utils.logPassImage(TCName);

				} catch (AssertionError | Exception e) {

					Log.fail("Error Message is not showing");
					Utils.logFailImage(TCName);
					throw e;
				}
			}

			if (AppData.getLanguage().equalsIgnoreCase("Arabic")) {
				Utils.pressEnter();
				Utils.click(By.xpath(getObj("Propval1", "SearchArabic", "eCorp_SELFSERVICE_ORDERSTATUS")), "Search");
			} else {
				Utils.pressEnter();
				Utils.click(By.xpath(getObj("Propval1", "Search", "eCorp_SELFSERVICE_ORDERSTATUS")), "Search");

			}

			String Balance1 = Utils.getText(By.xpath(getObj("Propval1", "ItemDisplay", "eCorp_SELFSERVICE_ORDERSTATUS")));
			Log.pass("Total Search :" + Balance1 + " Displayed on Page.....");
			Utils.logPassImage("JOL_SELFSERVICE_MESSAGE_BOX");

		} catch (Exception e) {
			runResult = false;
			throw e;

		}
		return runResult;
	}

	public static boolean sendEmailDownloadExcelnPrintFuncOrderStatus() throws Exception {

		try {
			// Start sending email , downloading pdf and printing etc.
			Utils.wait(3);
			Log.info("Starting send email functionality");

			Utils.click(By.xpath(getObj("Propval1", "sendEmailIcon", "eCorp_SELFSERVICE_ORDERSTATUS")), "Send Email Icon");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailTo", "eCorp_SELFSERVICE_ORDERSTATUS")), Input.ReadTestData("MarketInfo", "toEmail"), "to email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailCC", "eCorp_SELFSERVICE_ORDERSTATUS")), Input.ReadTestData("MarketInfo", "ccEmail"), "to CC email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "bccEmail", "eCorp_SELFSERVICE_ORDERSTATUS")), Input.ReadTestData("MarketInfo", "bccEmail"), "to BCC  email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "emailSubject", "eCorp_SELFSERVICE_ORDERSTATUS")), Input.ReadTestData("MarketInfo", "emailSubject"), "email Subject ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEMailMsgBox", "eCorp_SELFSERVICE_ORDERSTATUS")), Input.ReadTestData("MarketInfo", "sendEMailMsgBox"), "Mail Body ");

			Utils.click(By.xpath(getObj("Propval1", "cancelemailBtnEle", "eCorp_SELFSERVICE_ORDERSTATUS")), "Cancel Email Button");
			Utils.wait(5);
			Utils.click(By.xpath(getObj("Propval1", "sendEmailIcon", "eCorp_SELFSERVICE_ORDERSTATUS")), "Send Email Icon");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailTo", "eCorp_SELFSERVICE_ORDERSTATUS")), Input.ReadTestData("MarketInfo", "toEmail"), "to email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailCC", "eCorp_SELFSERVICE_ORDERSTATUS")), Input.ReadTestData("MarketInfo", "ccEmail"), "to CC email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "bccEmail", "eCorp_SELFSERVICE_ORDERSTATUS")), Input.ReadTestData("MarketInfo", "bccEmail"), "to BCC  email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "emailSubject", "eCorp_SELFSERVICE_ORDERSTATUS")), Input.ReadTestData("MarketInfo", "emailSubject"), "email Subject ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEMailMsgBox", "eCorp_SELFSERVICE_ORDERSTATUS")), Input.ReadTestData("MarketInfo", "sendEMailMsgBox"), "Mail Body ");
			Utils.wait(5);
			Utils.click(By.xpath(getObj("Propval1", "sendBtnEle", "eCorp_SELFSERVICE_ORDERSTATUS")), "Send Email Button");
			Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "WaitingElements", "JOL_SELFSERVICE_VIEWLIMIT")));
			Utils.pressEnter();
			Utils.wait(2);
			Utils.pressEscapeKey(3);
			// Download report in pdf format.
			Utils.click(By.xpath(getObj("Propval1", "pdfDownloadIcon", "eCorp_SELFSERVICE_ORDERSTATUS")), "pdf download");
			Utils.wait(3);
			// Utils.enterOTPAndProceed();
			Utils.moveToElement(By.id("logo"));
			// Download report in excel format.
			Utils.click(By.xpath(getObj("Propval1", "excelDownloadIcon", "eCorp_SELFSERVICE_ORDERSTATUS")), "Excel Download");
			Utils.wait(3);
			// Utils.enterOTPAndProceed();
			Utils.moveToElement(By.id("logo"));
			// Print report.
			Utils.click(By.xpath(getObj("Propval1", "printBtnIcon", "eCorp_SELFSERVICE_ORDERSTATUS")), "Print Button");
			// close all other tabs except the main one. i.e 1st page.
			Utils.closeOtherTabs();
		}

		catch (Exception e) {
			Log.error("Unable to send email semail, print and download pdf etc." + ExceptionUtils.getStackTrace(e));
			Utils.logFailImage("Error");
			runResult = false;
			throw e;

		}

		return runResult;
	}
}
