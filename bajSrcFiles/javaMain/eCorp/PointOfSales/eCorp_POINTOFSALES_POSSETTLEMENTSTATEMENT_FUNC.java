package javaMain.eCorp.PointOfSales;

import static Utilities.Input.ReadTestData;
import static Utilities.ReadData.ReadDataSQL;
import static Utilities.ReadData.getObj;
import static javaMain.common_Functions.AppData.AccountNumber;
import static javaMain.common_Functions.AppData.AfterTxfrAdditionalOptions;
import static javaMain.common_Functions.AppData.City;
import static javaMain.common_Functions.AppData.EndDate;
import static javaMain.common_Functions.AppData.MerchantReferenceNumber;
import static javaMain.common_Functions.AppData.NewTxn;
import static javaMain.common_Functions.AppData.POSID;
import static javaMain.common_Functions.AppData.Scheme;
import static javaMain.common_Functions.AppData.StartDate;
import static javaMain.common_Functions.AppData.isNegative;
import static javaMain.common_Functions.AppData.other;
import static javaMain.common_Functions.AppData.otherActions;

import org.openqa.selenium.By;
import org.testng.Assert;

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
public class eCorp_POINTOFSALES_POSSETTLEMENTSTATEMENT_FUNC extends TestBase {

	public static Boolean POSSETTLEMENTSTATEMENT(String TCName, int ScenarioCount, Object[] tCsDataset) throws Exception {
		
		try {

			if (isMasterClassRun) {

				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + ReadData.getJsonData(TCName, ScenarioCount, "DataSet") + "</mark>");

				AfterTxfrAdditionalOptions = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "AfterTxfrAdditionalOptions"));
				POSID = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "POSID"));
				City = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "City"));
				AccountNumber = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "AccountNumber"));
				MerchantReferenceNumber = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "MerchantReferenceNumber"));
				other = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "other"));
				Scheme = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Scheme"));
				isNegative = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "isNegative"));
				NewTxn = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "NewTxn"));
				StartDate = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "StartDate"));
				EndDate = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "EndDate"));

				otherActions = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "otherActions"));
			} else {

				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + dataset[scenarioCount - 1] + "</mark>");

				AfterTxfrAdditionalOptions = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("AfterTxfrAdditionalOptions"));
				POSID = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("POSID"));
				City = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("City"));
				AccountNumber = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("AccountNumber"));
				MerchantReferenceNumber = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("MerchantReferenceNumber"));
				other = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("other"));
				Scheme = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Scheme"));
				isNegative = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("isNegative"));
				NewTxn = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("NewTxn"));
				otherActions = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("otherActions"));
				StartDate = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("StartDate"));
				EndDate = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("EndDate"));

			}
			
			Utils.refreshScreeen();
			Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "WaitingElements", "eCorp_PointOfSales_POSSettlementStatement")));
			Utils.click(By.xpath(getObj("Propval1", "PointOfSales", "eCorp_PointOfSales_POSSettlementStatement")), "Point Of Sales");
			Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "WaitingElements", "eCorp_PointOfSales_POSSettlementStatement")));
			Utils.click(By.xpath(getObj("Propval1", "Report", "eCorp_PointOfSales_POSSettlementStatement")), "Report");
			Utils.click(By.xpath(getObj("Propval1", "POSSettlementStatement", "eCorp_PointOfSales_POSSettlementStatement")), "POS Settlement Statement");
			Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "WaitingElements", "eCorp_PointOfSales_POSSettlementStatement")));

			String LandPage = Utils.getText(By.xpath(getObj("Propval1", "LandPage", "eCorp_PointOfSales_POSSettlementStatement")));

			Log.pass("Page title is " + LandPage);

			Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "AccountNumberDropDwon", "eCorp_PointOfSales_POSSettlementStatement")), By.xpath(getObj("Propval1", "AccountNumber", "eCorp_PointOfSales_POSSettlementStatement")),
					ReadTestData(TCName, "AccountNumber"), "AccountNumber");

			Utils.sendKeys(By.xpath(getObj("Propval1", "MerchantId", "eCorp_PointOfSales_POSSettlementStatement")), ReadTestData(TCName, "MerchantReferenceNumber"), "MerchantId");

			Utils.sendKeys(By.xpath(getObj("Propval1", "city", "eCorp_PointOfSales_POSSettlementStatement")), ReadTestData(TCName, "City"), "City");
			if (AppData.getLanguage().equalsIgnoreCase("Arabic")) {
				Utils.click(By.xpath(getObj("Propval1", "POSIDDropDown", "eCorp_PointOfSales_POSSettlementStatementDetails")), "POSID DropDown");
			}
			Utils.sendKeys(By.xpath(getObj("Propval1", "POSID", "eCorp_PointOfSales_POSSettlementStatement")), ReadTestData(TCName, "POSID"), "POSID");

			Utils.sendKeys(By.xpath(getObj("Propval1", "StartDate", "eCorp_PointOfSales_POSSettlementStatement")), ReadTestData(TCName, "StartDate"), "StartDate");
			Utils.sendKeys(By.xpath(getObj("Propval1", "EndDate", "eCorp_PointOfSales_POSSettlementStatement")), ReadTestData(TCName, "EndDate"), "EndDate");
			Utils.sendKeys(By.xpath(getObj("Propval1", "schemaId", "eCorp_PointOfSales_POSSettlementStatement")), ReadTestData(TCName, "Scheme"), "schemaId");

			Utils.wait(2);
			if (isNegative.equalsIgnoreCase("true")) {
				try {

					Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "AccountNumberDropDwon", "eCorp_PointOfSales_POSSettlementStatement")), By.xpath(getObj("Propval1", "AccountNumber", "eCorp_PointOfSales_POSSettlementStatement")),
							ReadTestData(TCName, "InvalidAccountNumber"), "AccountNumber");

					Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "error", "eCorp_PointOfSales_POSSettlementStatement")), "Invalid data"));
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

			Utils.click(By.xpath(getObj("Propval1", "Search", "eCorp_PointOfSales_POSSettlementStatement")), "Search");

			String Result = Utils.getText(By.xpath(getObj("Propval1", "Result", "eCorp_PointOfSales_POSSettlementStatement")));

			Log.pass("Result :" + Result);
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
			throw e;

		}
		return runResult;
	}

	public static boolean addFavSendEmailDownloadPdfNprintFuncBeneficiary(String Nickname) throws Exception {

		try {
			// Start sending email , downloading pdf and printing etc.
			Utils.wait(3);
			Log.info("Starting send email functionality");

			Utils.click(By.xpath(getObj("Propval1", "sendEmailIcon", "eCorp_PointOfSales_POSSettlementStatement")), "Send Email Icon");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailTo", "eCorp_PointOfSales_POSSettlementStatement")), Input.ReadTestData("MarketInfo", "toEmail"), "to email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailCC", "eCorp_PointOfSales_POSSettlementStatement")), Input.ReadTestData("MarketInfo", "ccEmail"), "to CC email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "bccEmail", "eCorp_PointOfSales_POSSettlementStatement")), Input.ReadTestData("MarketInfo", "bccEmail"), "to BCC  email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "emailSubject", "eCorp_PointOfSales_POSSettlementStatement")), Input.ReadTestData("MarketInfo", "emailSubject"), "email Subject ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEMailMsgBox", "eCorp_PointOfSales_POSSettlementStatement")), Input.ReadTestData("MarketInfo", "sendEMailMsgBox"), "Mail Body ");

			Utils.clickSafely(By.xpath(getObj("Propval1", "cancelemailBtnEle", "eCorp_PointOfSales_POSSettlementStatement")), "Cancel Email Button");

			Utils.wait(5);
			Utils.click(By.xpath(getObj("Propval1", "sendEmailIcon", "eCorp_PointOfSales_POSSettlementStatement")), "Send Email Icon");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailTo", "eCorp_PointOfSales_POSSettlementStatement")), Input.ReadTestData("MarketInfo", "toEmail"), "to email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailCC", "eCorp_PointOfSales_POSSettlementStatement")), Input.ReadTestData("MarketInfo", "ccEmail"), "to CC email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "bccEmail", "eCorp_PointOfSales_POSSettlementStatement")), Input.ReadTestData("MarketInfo", "bccEmail"), "to BCC  email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "emailSubject", "eCorp_PointOfSales_POSSettlementStatement")), Input.ReadTestData("MarketInfo", "emailSubject"), "email Subject ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEMailMsgBox", "eCorp_PointOfSales_POSSettlementStatement")), Input.ReadTestData("MarketInfo", "sendEMailMsgBox"), "Mail Body ");
			Utils.wait(5);
			Utils.click(By.xpath(getObj("Propval1", "sendBtnEle", "eCorp_PointOfSales_POSSettlementStatement")), "Send Email Button");
			Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "WaitingElements", "eCorp_PointOfSales_POSSettlementStatement")));
			Utils.pressEnter();
			Utils.wait(2);
			Utils.pressEscapeKey(3);

			Utils.pressEscapeKey(3);
			driver.navigate().refresh();
			// Download report in pdf format.
			Utils.click(By.xpath(getObj("Propval1", "pdfDownloadIcon", "eCorp_PointOfSales_POSSettlementStatement")), "pdf download");
			Utils.wait(3);
			Utils.closeOtherTabs();
			Utils.moveToElement(By.id("logo"));
			driver.navigate().refresh();
			Utils.click(By.xpath(getObj("Propval1", "excelDownloadIcon", "eCorp_PointOfSales_POSSettlementStatement")), "excel Download Icon");
			Utils.wait(3);
			// Utils.enterOTPAndProceed();
			Utils.moveToElement(By.id("logo"));
			// Print report.
			Utils.wait(6);
			driver.navigate().refresh();
			Utils.click(By.xpath(getObj("Propval1", "printBtnIcon", "eCorp_PointOfSales_POSSettlementStatement")), "Print Button");
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
