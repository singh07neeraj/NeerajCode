package javaMain.eCorp.PointOfSales;

import static Utilities.Input.ReadTestData;
import static Utilities.ReadData.ReadDataSQL;
import static Utilities.ReadData.getObj;
import static javaMain.common_Functions.AppData.AfterTxfrAdditionalOptions;
import static javaMain.common_Functions.AppData.isNegative;

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
public class eCorp_POINTOFSALES_POSSETTLEMENTSTATEMENT_DETAILS_FUNC extends TestBase {

	public static Boolean POSSettlementStatementDetails(String TCName, int ScenarioCount, Object[] tCsDataset) throws Exception {
		try {

			if (isMasterClassRun) {

				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + ReadData.getJsonData(TCName, ScenarioCount, "DataSet") + "</mark>");
				AfterTxfrAdditionalOptions = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "AfterTxfrAdditionalOptions"));
				isNegative = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "isNegative"));

			} else {

				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + dataset[scenarioCount - 1] + "</mark>");
				AfterTxfrAdditionalOptions = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("AfterTxfrAdditionalOptions"));
				isNegative = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("isNegative"));

			}

			Utils.refreshScreeen();
			Utils.click(By.xpath(getObj("Propval1", "PointOfSales", "eCorp_PointOfSales_POSSettlementStatementDetails")), "Point Of Sales");
			Utils.click(By.xpath(getObj("Propval1", "Report", "eCorp_PointOfSales_POSSettlementStatementDetails")), "Report");

			Utils.click(By.xpath(getObj("Propval1", "POSSettlementStatementDetails", "eCorp_PointOfSales_POSSettlementStatementDetails")), "POS Settlement Statement Details");

			String LandPage = Utils.getText(By.xpath(getObj("Propval1", "LandPage", "eCorp_PointOfSales_POSSettlementStatementDetails")));

			Log.pass("Page title is " + LandPage);

			Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "AccountNumberDropDwon", "eCorp_PointOfSales_POSSettlementStatementDetails")), By.xpath(getObj("Propval1", "AccountNumber", "eCorp_PointOfSales_POSSettlementStatementDetails")),
					ReadTestData(TCName, "AccountNumber"), "AccountNumber");

			Utils.sendKeys(By.xpath(getObj("Propval1", "MerchantId", "eCorp_PointOfSales_POSSettlementStatementDetails")), ReadTestData(TCName, "MerchantReferenceNumber"), "MerchantId");

			Utils.sendKeys(By.xpath(getObj("Propval1", "city", "eCorp_PointOfSales_POSSettlementStatementDetails")), ReadTestData(TCName, "City"), "City");
			if (AppData.getLanguage().equalsIgnoreCase("Arabic")) {
				Utils.click(By.xpath(getObj("Propval1", "POSIDDropDown", "eCorp_PointOfSales_POSSettlementStatementDetails")), "POSID DropDown");
			}
			Utils.sendKeys(By.xpath(getObj("Propval1", "POSID", "eCorp_PointOfSales_POSSettlementStatementDetails")), ReadTestData(TCName, "POSID"), "POSID");

			Utils.sendKeys(By.xpath(getObj("Propval1", "StartDate", "eCorp_PointOfSales_POSSettlementStatementDetails")), ReadTestData(TCName, "StartDate"), "StartDate");
			Utils.sendKeys(By.xpath(getObj("Propval1", "EndDate", "eCorp_PointOfSales_POSSettlementStatementDetails")), ReadTestData(TCName, "EndDate"), "EndDate");
			Utils.sendKeys(By.xpath(getObj("Propval1", "schemaId", "eCorp_PointOfSales_POSSettlementStatementDetails")), ReadTestData(TCName, "Scheme"), "schemaId");

			Utils.wait(2);
			if (isNegative.equalsIgnoreCase("true")) {
				try {

					Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "AccountNumberDropDwon", "eCorp_PointOfSales_POSSettlementStatementDetails")),
							By.xpath(getObj("Propval1", "AccountNumber", "eCorp_PointOfSales_POSSettlementStatementDetails")), ReadTestData(TCName, "InvalidAccountNumber"), "AccountNumber");

					Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "error", "eCorp_PointOfSales_POSSettlementStatementDetails")), "Invalid data"));
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

			Utils.click(By.xpath(getObj("Propval1", "Search", "eCorp_PointOfSales_POSSettlementStatementDetails")), "Search");

			String Result = Utils.getText(By.xpath(getObj("Propval1", "Result", "eCorp_PointOfSales_POSSettlementStatementDetails")));

			Log.pass("Result :" + Result);
			Utils.logPassImage(TCName);

			if (AfterTxfrAdditionalOptions.equalsIgnoreCase("true")) {
				Log.pass("Starting additional actions after transfer. e.g send email, print and save as favourite.");
				eCorpCommonFunctions.sendEmailDownloadExcelnPrintFunc(ScenarioCount);
				Log.pass("Additional Actions  like send email, print and download pdf/excel etc have  passed successfully.");
				Utils.logPassImage("Additional Actions");
			}

		} catch (Exception e) {
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

			Utils.click(By.xpath(getObj("Propval1", "sendEmailIcon", "eCorp_PointOfSales_POSSettlementStatementDetails")), "Send Email Icon");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailTo", "eCorp_PointOfSales_POSSettlementStatementDetails")), Input.ReadTestData("MarketInfo", "toEmail"), "to email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailCC", "eCorp_PointOfSales_POSSettlementStatementDetails")), Input.ReadTestData("MarketInfo", "ccEmail"), "to CC email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "bccEmail", "eCorp_PointOfSales_POSSettlementStatementDetails")), Input.ReadTestData("MarketInfo", "bccEmail"), "to BCC  email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "emailSubject", "eCorp_PointOfSales_POSSettlementStatementDetails")), Input.ReadTestData("MarketInfo", "emailSubject"), "email Subject ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEMailMsgBox", "eCorp_PointOfSales_POSSettlementStatementDetails")), Input.ReadTestData("MarketInfo", "sendEMailMsgBox"), "Mail Body ");

			Utils.clickSafely(By.xpath(getObj("Propval1", "cancelemailBtnEle", "eCorp_PointOfSales_POSSettlementStatementDetails")), "Cancel Email Button");

			Utils.wait(5);
			Utils.click(By.xpath(getObj("Propval1", "sendEmailIcon", "eCorp_PointOfSales_POSSettlementStatementDetails")), "Send Email Icon");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailTo", "eCorp_PointOfSales_POSSettlementStatementDetails")), Input.ReadTestData("MarketInfo", "toEmail"), "to email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailCC", "eCorp_PointOfSales_POSSettlementStatementDetails")), Input.ReadTestData("MarketInfo", "ccEmail"), "to CC email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "bccEmail", "eCorp_PointOfSales_POSSettlementStatementDetails")), Input.ReadTestData("MarketInfo", "bccEmail"), "to BCC  email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "emailSubject", "eCorp_PointOfSales_POSSettlementStatementDetails")), Input.ReadTestData("MarketInfo", "emailSubject"), "email Subject ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEMailMsgBox", "eCorp_PointOfSales_POSSettlementStatementDetails")), Input.ReadTestData("MarketInfo", "sendEMailMsgBox"), "Mail Body ");
			Utils.wait(5);
			Utils.click(By.xpath(getObj("Propval1", "sendBtnEle", "eCorp_PointOfSales_POSSettlementStatementDetails")), "Send Email Button");
			Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "WaitingElements", "eCorp_PointOfSales_POSSettlementStatementDetails")));
			Utils.pressEnter();
			Utils.wait(2);
			Utils.pressEscapeKey(3);

			Utils.pressEscapeKey(3);
			driver.navigate().refresh();
			// Download report in pdf format.
			Utils.click(By.xpath(getObj("Propval1", "pdfDownloadIcon", "eCorp_PointOfSales_POSSettlementStatementDetails")), "pdf download");
			Utils.wait(3);
			Utils.closeOtherTabs();
			Utils.moveToElement(By.id("logo"));
			driver.navigate().refresh();
			Utils.click(By.xpath(getObj("Propval1", "excelDownloadIcon", "eCorp_PointOfSales_POSSettlementStatementDetails")), "excel Download Icon");
			Utils.wait(3);
			// Utils.enterOTPAndProceed();
			Utils.moveToElement(By.id("logo"));
			// Print report.
			Utils.wait(6);
			driver.navigate().refresh();
			Utils.click(By.xpath(getObj("Propval1", "printBtnIcon", "eCorp_PointOfSales_POSSettlementStatementDetails")), "Print Button");
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
