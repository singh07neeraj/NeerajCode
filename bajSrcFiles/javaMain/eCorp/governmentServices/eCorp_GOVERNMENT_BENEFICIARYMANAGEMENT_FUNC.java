package javaMain.eCorp.governmentServices;

import static Utilities.Input.ReadTestData;
import static Utilities.ReadData.ReadDataSQL;
import static Utilities.ReadData.getObj;
import static javaMain.common_Functions.AppData.AccountNumber;
import static javaMain.common_Functions.AppData.AddNewBeneficiary;
import static javaMain.common_Functions.AppData.AfterTxfrAdditionalOptions;
import static javaMain.common_Functions.AppData.Provider;
import static javaMain.common_Functions.AppData.Service;
import static javaMain.common_Functions.AppData.isNegative;

import org.openqa.selenium.By;
import org.testng.Assert;

import Utilities.Input;
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
public class eCorp_GOVERNMENT_BENEFICIARYMANAGEMENT_FUNC extends TestBase {

	public static Boolean BeneficiaryManagement(String TCName, int ScenarioCount, Object[] tCsDataset) throws Exception {

		try {

			if (isMasterClassRun) {

				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + ReadData.getJsonData(TCName, ScenarioCount, "DataSet") + "</mark>");
				AddNewBeneficiary = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "AddNewBeneficiary"));
				Service = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Service"));
				AccountNumber = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "AccountNumber"));
				AfterTxfrAdditionalOptions = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "AfterTxfrAdditionalOptions"));
				isNegative = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "isNegative"));

			} else {

				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + dataset[scenarioCount - 1] + "</mark>");
				AddNewBeneficiary = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("AddNewBeneficiary"));
				Service = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Service"));
				AccountNumber = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("AccountNumber"));
				AfterTxfrAdditionalOptions = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("AfterTxfrAdditionalOptions"));
				isNegative = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("isNegative"));

			}

			Utils.refreshScreeen();
			Utils.click(By.xpath(getObj("Propval1", "govtservice", "eCorp_governmentService_BeneficiaryManagement")), "Goverment Service Menu");
			Utils.click(By.xpath(getObj("Propval1", "BeneficiaryManagement", "eCorp_governmentService_BeneficiaryManagement")), "Beneficiary Management");

			String LandPage = Utils.getText(By.xpath(getObj("Propval1", "LandPage", "eCorp_governmentService_BeneficiaryManagement")));
			Log.pass("Page title is " + LandPage);

			Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "InitiatorDropDown", "eCorp_governmentService_BeneficiaryManagement")), By.xpath(getObj("Propval1", "Initiator", "eCorp_governmentService_BeneficiaryManagement")),
					AddNewBeneficiary, "Add New Beneficiary Name");

			Utils.click(By.xpath(getObj("Propval1", "Search", "eCorp_governmentService_BeneficiaryManagement")), "Search");

			Utils.logPassImage(TCName);

			if (AfterTxfrAdditionalOptions.equalsIgnoreCase("true")) {
				Log.pass("Starting additional actions after transfer. e.g send email, print and save as favourite.");
				eCorpCommonFunctions.sendEmailDownloadExcelnPrintFunc(ScenarioCount);
				Log.pass("Additional Actions  like send email, print and download pdf/excel etc have  passed successfully.");
				Utils.logPassImage("Additional Actions");

			}

			Utils.click(By.xpath(getObj("Propval1", "AddNewBeneficiary", "eCorp_governmentService_BeneficiaryManagement")), "Add New Beneficiary");

			String BeneficiaryManagement = Utils.getText(By.xpath(getObj("Propval1", "LandPage", "eCorp_governmentService_BeneficiaryManagement")));

			Log.pass("Page title is " + BeneficiaryManagement);

		} catch (Exception e) {

			runResult = false;
			throw e;
		}
		return runResult;
	}

	public static boolean BeneficiaryManagementemailpdf(String Nickname) throws Exception {

		try {
			// Start sending email , downloading pdf and printing etc.
			Utils.wait(3);
			Log.info("Starting send email functionality");

			Utils.click(By.xpath(getObj("Propval1", "sendEmailIcon", "eCorp_governmentService_BeneficiaryManagement")), "Send Email Icon");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailTo", "eCorp_governmentService_BeneficiaryManagement")), Input.ReadTestData("MarketInfo", "toEmail"), "to email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailCC", "eCorp_governmentService_BeneficiaryManagement")), Input.ReadTestData("MarketInfo", "ccEmail"), "to CC email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "bccEmail", "eCorp_governmentService_BeneficiaryManagement")), Input.ReadTestData("MarketInfo", "bccEmail"), "to BCC  email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "emailSubject", "eCorp_governmentService_BeneficiaryManagement")), Input.ReadTestData("MarketInfo", "emailSubject"), "email Subject ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEMailMsgBox", "eCorp_governmentService_BeneficiaryManagement")), Input.ReadTestData("MarketInfo", "sendEMailMsgBox"), "Mail Body ");

			Utils.click(By.xpath(getObj("Propval1", "cancelemailBtnEle", "eCorp_governmentService_BeneficiaryManagement")), "Cancel Email Button");

			Utils.refreshScreeen();
			Utils.click(By.xpath(getObj("Propval1", "sendEmailIcon", "eCorp_governmentService_BeneficiaryManagement")), "Send Email Icon");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailTo", "eCorp_governmentService_BeneficiaryManagement")), Input.ReadTestData("MarketInfo", "toEmail"), "to email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailCC", "eCorp_governmentService_BeneficiaryManagement")), Input.ReadTestData("MarketInfo", "ccEmail"), "to CC email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "bccEmail", "eCorp_governmentService_BeneficiaryManagement")), Input.ReadTestData("MarketInfo", "bccEmail"), "to BCC  email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "emailSubject", "eCorp_governmentService_BeneficiaryManagement")), Input.ReadTestData("MarketInfo", "emailSubject"), "email Subject ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEMailMsgBox", "eCorp_governmentService_BeneficiaryManagement")), Input.ReadTestData("MarketInfo", "sendEMailMsgBox"), "Mail Body ");

			Utils.click(By.xpath(getObj("Propval1", "sendBtnEle", "eCorp_governmentService_BeneficiaryManagement")), "Send Email Button");
			Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "WaitingElements", "eCorp_governmentService_BeneficiaryManagement")));
			Utils.pressEnter();

			Utils.pressEscapeKey(3);
			Utils.refreshScreeen();

			driver.navigate().refresh();
			// Download report in pdf format.
			Utils.click(By.xpath(getObj("Propval1", "pdfDownloadIcon", "eCorp_governmentService_BeneficiaryManagement")), "pdf download");

			Utils.moveToElement(By.id("logo"));
			driver.navigate().refresh();
			// Download report in excel format.
			Utils.click(By.xpath(getObj("Propval1", "excelDownloadIcon", "eCorp_governmentService_BeneficiaryManagement")), "Excel Download");

			// Utils.enterOTPAndProceed();
			Utils.moveToElement(By.id("logo"));
			// Print report.

			driver.navigate().refresh();
			Utils.click(By.xpath(getObj("Propval1", "printBtnIcon", "eCorp_governmentService_BeneficiaryManagement")), "Print Button");
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

	public static Boolean PaymentsRefundsHistory(String TCName, int ScenarioCount, Object[] tCsDataset) {

		try {

			if (isMasterClassRun) {

				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + ReadData.getJsonData(TCName, ScenarioCount, "DataSet") + "</mark>");

				ReadData.getJsonData(TCName, ScenarioCount, "DataSet");

				Provider = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Provider"));
				Service = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Service"));
				AccountNumber = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "AccountNumber"));
				AfterTxfrAdditionalOptions = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "AfterTxfrAdditionalOptions"));
				isNegative = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "isNegative"));

			} else {

				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + dataset[scenarioCount - 1] + "</mark>");

				Provider = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Provider"));
				Service = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Service"));
				AccountNumber = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("AccountNumber"));
				AfterTxfrAdditionalOptions = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("AfterTxfrAdditionalOptions"));
				isNegative = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("isNegative"));

			}

			Utils.click(By.xpath(getObj("Propval1", "govtservice", "eCorp_governmentService_PaymentsRefundsHistory")), "Goverment Service Menu");

			Utils.click(By.xpath(getObj("Propval1", "History", "eCorp_governmentService_PaymentsRefundsHistory")), "Histroy ");

			Utils.click(By.xpath(getObj("Propval1", "PaymentsRefundsHistory", "eCorp_governmentService_PaymentsRefundsHistory")), "Goverment Serivce Payments Refunds History");

			String LandPage = Utils.getText(By.xpath(getObj("Propval1", "LandPage", "eCorp_governmentService_PaymentsRefundsHistory")));

			Log.pass("Page title is " + LandPage);

			Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "ProviderDropdownDropdown", "eCorp_governmentService_PaymentsRefundsHistory")), By.xpath(getObj("Propval1", "Provider", "eCorp_governmentService_PaymentsRefundsHistory")),
					ReadTestData(TCName, "Provider"), "Provider");

			if (isNegative.equalsIgnoreCase("true")) {
				try {
					Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "ProviderDropdownDropdown", "eCorp_governmentService_PaymentsRefundsHistory")),
							By.xpath(getObj("Propval1", "Provider", "eCorp_governmentService_PaymentsRefundsHistory")), ReadTestData(TCName, "InvalidProvider"), "Provider");

					Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "worngvalues", "eCorp_governmentService_PaymentsRefundsHistory")), "invalid provider"));
					Log.pass("User is unable to search with invalid provider ");
					Utils.logPassImage(TCName);
					return true;
				} catch (AssertionError | Exception e) {
					Log.fail("User was able to search with invalid provider ");
					Utils.logFailImage("Transfer Result");
					throw e;
				}

			}

			Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "ServiceDropdownDropdown", "eCorp_governmentService_PaymentsRefundsHistory")), By.xpath(getObj("Propval1", "Service", "eCorp_governmentService_PaymentsRefundsHistory")),
					ReadTestData(TCName, "Service"), "Service");

			Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "AccountNumberDropdownDropdown", "eCorp_governmentService_PaymentsRefundsHistory")),
					By.xpath(getObj("Propval1", "AccountNumber", "eCorp_governmentService_PaymentsRefundsHistory")), ReadTestData(TCName, "AccountNumber"), "Account Number");

			Utils.click(By.xpath(getObj("Propval1", "Search", "eCorp_governmentService_PaymentsRefundsHistory")), "Search");
			Utils.wait(3);
			Utils.pressEnter();

			String PaymentHistory = Utils.getText(By.xpath(getObj("Propval1", "searchResult1", "eCorp_governmentService_PaymentsRefundsHistory")));

			Log.pass("Payment History  Result :" + PaymentHistory);

			String RefundHistory = Utils.getText(By.xpath(getObj("Propval1", "searchResult2", "eCorp_governmentService_PaymentsRefundsHistory")));

			Log.pass("Refund History Result is  " + RefundHistory);
			Utils.logPassImage(TCName);
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

	public static boolean PaymentsRefundsHistoryExtra(String Nickname) throws Exception {

		try {
			// Start sending email , downloading pdf and printing etc.
			Utils.wait(3);
			Log.info("Starting send email functionality");

			Utils.click(By.xpath(getObj("Propval1", "sendEmailIcon", "PaymentsRefundsHistory")), "Send Email Icon");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailTo", "PaymentsRefundsHistory")), Input.ReadTestData("MarketInfo", "toEmail"), "to email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailCC", "PaymentsRefundsHistory")), Input.ReadTestData("MarketInfo", "ccEmail"), "to CC email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "bccEmail", "PaymentsRefundsHistory")), Input.ReadTestData("MarketInfo", "bccEmail"), "to BCC  email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "emailSubject", "PaymentsRefundsHistory")), Input.ReadTestData("MarketInfo", "emailSubject"), "email Subject ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEMailMsgBox", "PaymentsRefundsHistory")), Input.ReadTestData("MarketInfo", "sendEMailMsgBox"), "Mail Body ");

			Utils.click(By.xpath(getObj("Propval1", "cancelemailBtnEle", "PaymentsRefundsHistory")), "Cancel Email Button");
			Utils.wait(5);
			Utils.click(By.xpath(getObj("Propval1", "sendEmailIcon", "PaymentsRefundsHistory")), "Send Email Icon");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailTo", "PaymentsRefundsHistory")), Input.ReadTestData("MarketInfo", "toEmail"), "to email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailCC", "PaymentsRefundsHistory")), Input.ReadTestData("MarketInfo", "ccEmail"), "to CC email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "bccEmail", "PaymentsRefundsHistory")), Input.ReadTestData("MarketInfo", "bccEmail"), "to BCC  email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "emailSubject", "PaymentsRefundsHistory")), Input.ReadTestData("MarketInfo", "emailSubject"), "email Subject ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEMailMsgBox", "PaymentsRefundsHistory")), Input.ReadTestData("MarketInfo", "sendEMailMsgBox"), "Mail Body ");
			Utils.wait(5);
			Utils.click(By.xpath(getObj("Propval1", "sendBtnEle", "PaymentsRefundsHistory")), "Send Email Button");
			Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "WaitingElements", "PaymentsRefundsHistory")));
			Utils.pressEnter();
			Utils.wait(2);
			Utils.pressEscapeKey(3);

			Utils.pressEscapeKey(3);
			driver.navigate().refresh();
			// Download report in pdf format.
			Utils.click(By.xpath(getObj("Propval1", "pdfDownloadIcon", "PaymentsRefundsHistory")), "pdf download");
			Utils.wait(3);
			Utils.enterOTPAndProceed();
			Utils.moveToElement(By.id("logo"));
			driver.navigate().refresh();
			// Download report in excel format.
			Utils.click(By.xpath(getObj("Propval1", "excelDownloadIcon", "PaymentsRefundsHistory")), "Excel Download");
			Utils.wait(3);
			// Utils.enterOTPAndProceed();
			Utils.moveToElement(By.id("logo"));
			// Print report.
			Utils.wait(6);
			driver.navigate().refresh();
			Utils.click(By.xpath(getObj("Propval1", "printBtnIcon", "PaymentsRefundsHistory")), "Print Button");
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
