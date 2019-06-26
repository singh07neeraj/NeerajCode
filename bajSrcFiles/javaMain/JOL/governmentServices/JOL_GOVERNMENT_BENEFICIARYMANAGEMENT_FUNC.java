package javaMain.JOL.governmentServices;

import static Utilities.Input.ReadTestData;
import static Utilities.ReadData.ReadDataSQL;
import static Utilities.ReadData.getObj;

import org.openqa.selenium.By;
import org.testng.Assert;

import Utilities.Input;
import Utilities.Log;
import Utilities.ReadData;
import Utilities.TestBase;
import Utilities.Utils;
import javaMain.common_Functions.OpenJOLMenues;
import javaMain.common_Functions.eCorpCommonFunctions;

/**
 * Description : Functional Test Script
 * 
 * @author baj80000892
 */
public class JOL_GOVERNMENT_BENEFICIARYMANAGEMENT_FUNC extends TestBase {

	public static Boolean BeneficiaryManagement(String TCName, int ScenarioCount, Object[] tCsDataset) throws Exception {

		try {
			driver.navigate().refresh();

			if (ReadDataSQL(TCName, ScenarioCount, "Menu").equalsIgnoreCase("Y")) {

				OpenJOLMenues.GovernmentServiceMenu("Refund");

				Log.pass("Successful Launch Refund Page by Menu........");

			} else {

				Utils.click(By.xpath(getObj("Propval1", "govtservice", "BeneficiaryManagement")), "Goverment Service Menu");

				Utils.click(By.xpath(getObj("Propval1", "BeneficiaryManagement", "BeneficiaryManagement")), "Goverment Serivce Beneficiary Management");

			}

			String LandPage = Utils.getText(By.xpath(getObj("Propval1", "LandPage", "BeneficiaryManagement")));

			Log.pass("Page title is " + LandPage);

			String Result = Utils.getText(By.xpath(getObj("Propval1", "searchResult", "BeneficiaryManagement")));

			Log.pass("Search Result : " + Result);
			Utils.logPassImage(TCName);

			Log.pass("Starting additional actions after transfer. e.g send email, print and save as favourite.");
			eCorpCommonFunctions.sendEmailDownloadExcelnPrintFunc(ScenarioCount);
			Log.pass("Additional Actions  like send email, print and download pdf/excel etc have  passed successfully.");
			Utils.logPassImage("Additional Actions");

			Utils.click(By.xpath(getObj("Propval1", "AddNewBeneficiary", "BeneficiaryManagement")), "Add New Beneficiary");

			String BeneficiaryManagement = Utils.getText(By.xpath(getObj("Propval1", "LandPage", "BeneficiaryManagement")));

			Log.pass("Page title is " + BeneficiaryManagement);

		} catch (Exception e) {

			runResult = false;
			e.printStackTrace();
			throw e;
		}
		return runResult;
	}

	public static boolean BeneficiaryManagementemailpdf(String Nickname) throws Exception {

		try {
			// Start sending email , downloading pdf and printing etc.
			Utils.wait(3);
			Log.info("Starting send email functionality");

			Utils.click(By.xpath(getObj("Propval1", "sendEmailIcon", "CreditCard_BeneficiaryManagement")), "Send Email Icon");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailTo", "CreditCard_BeneficiaryManagement")), Input.ReadTestData("MarketInfo", "toEmail"), "to email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailCC", "CreditCard_BeneficiaryManagement")), Input.ReadTestData("MarketInfo", "ccEmail"), "to CC email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "bccEmail", "CreditCard_BeneficiaryManagement")), Input.ReadTestData("MarketInfo", "bccEmail"), "to BCC  email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "emailSubject", "CreditCard_BeneficiaryManagement")), Input.ReadTestData("MarketInfo", "emailSubject"), "email Subject ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEMailMsgBox", "CreditCard_BeneficiaryManagement")), Input.ReadTestData("MarketInfo", "sendEMailMsgBox"), "Mail Body ");

			Utils.click(By.xpath(getObj("Propval1", "cancelemailBtnEle", "CreditCard_BeneficiaryManagement")), "Cancel Email Button");
			Utils.wait(5);
			Utils.click(By.xpath(getObj("Propval1", "sendEmailIcon", "CreditCard_BeneficiaryManagement")), "Send Email Icon");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailTo", "CreditCard_BeneficiaryManagement")), Input.ReadTestData("MarketInfo", "toEmail"), "to email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailCC", "CreditCard_BeneficiaryManagement")), Input.ReadTestData("MarketInfo", "ccEmail"), "to CC email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "bccEmail", "CreditCard_BeneficiaryManagement")), Input.ReadTestData("MarketInfo", "bccEmail"), "to BCC  email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "emailSubject", "CreditCard_BeneficiaryManagement")), Input.ReadTestData("MarketInfo", "emailSubject"), "email Subject ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEMailMsgBox", "CreditCard_BeneficiaryManagement")), Input.ReadTestData("MarketInfo", "sendEMailMsgBox"), "Mail Body ");
			Utils.wait(5);
			Utils.click(By.xpath(getObj("Propval1", "sendBtnEle", "CreditCard_BeneficiaryManagement")), "Send Email Button");
			Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "WaitingElements", "CreditCard_BeneficiaryManagement")));
			Utils.pressEnter();
			Utils.wait(2);
			Utils.pressEscapeKey(3);

			Utils.pressEscapeKey(3);
			driver.navigate().refresh();
			// Download report in pdf format.
			Utils.click(By.xpath(getObj("Propval1", "pdfDownloadIcon", "CreditCard_BeneficiaryManagement")), "pdf download");
			Utils.wait(3);
			Utils.enterOTPAndProceed();
			Utils.moveToElement(By.id("logo"));
			driver.navigate().refresh();
			// Download report in excel format.
			Utils.click(By.xpath(getObj("Propval1", "excelDownloadIcon", "CreditCard_BeneficiaryManagement")), "Excel Download");
			Utils.wait(3);
			// Utils.enterOTPAndProceed();
			Utils.moveToElement(By.id("logo"));
			// Print report.
			Utils.wait(6);
			driver.navigate().refresh();
			Utils.click(By.xpath(getObj("Propval1", "printBtnIcon", "CreditCard_BeneficiaryManagement")), "Print Button");
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

	public static Boolean PaymentsRefundsHistory(String TCName, int ScenarioCount, Object[] tCsDataset) throws Exception {

		Utils.refreshScreeen();
		String Provider, Service, AccountNumber, AfterTxfrAdditionalOptions, isNegative;
		boolean b = true;
		try {

			if (isMasterClassRun) {

				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + ReadData.getJsonData(TCName, ScenarioCount, "DataSet") + "</mark>");

				ReadData.getJsonData("JOL Transfers - Add New Benificiary", 4, "DataSet");

				Provider = ReadTestData(TCName, "Provider");// Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Provider"));
				Service = ReadTestData(TCName, "Service");// Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Service"));
				AccountNumber = ReadTestData(TCName, "AccountNumber");// Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "AccountNumber"));
				AfterTxfrAdditionalOptions = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "AfterTxfrAdditionalOptions"));
				isNegative = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "isNegative"));

			} else {

				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + dataset[scenarioCount - 1] + "</mark>");

				Provider = ReadTestData(TCName, "Provider");// Utils.setValue((String) Utils.getUiData(dataset[scenarioCount -
															// 1]).get("Provider"));
				Service = ReadTestData(TCName, "Service");// Utils.setValue((String) Utils.getUiData(dataset[scenarioCount -
															// 1]).get("Service"));
				AccountNumber = ReadTestData(TCName, "AccountNumber"); // Utils.setValue((String) Utils.getUiData(dataset[scenarioCount -
																		// 1]).get("AccountNumber"));
				AfterTxfrAdditionalOptions = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("AfterTxfrAdditionalOptions"));
				isNegative = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("isNegative"));

			}

			Utils.click(By.xpath(getObj("Propval1", "govtservice", "PaymentsRefundsHistory")), "Goverment Service Menu");

			Utils.click(By.xpath(getObj("Propval1", "History", "PaymentsRefundsHistory")), "Histroy ");

			Utils.click(By.xpath(getObj("Propval1", "PaymentsRefundsHistory", "PaymentsRefundsHistory")), "Goverment Serivce Payments Refunds History");

			String LandPage = Utils.getText(By.xpath(getObj("Propval1", "LandPage", "PaymentsRefundsHistory")));

			Log.pass("Page title is " + LandPage);
			if (isNegative.equalsIgnoreCase("true")) {

				Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "ProviderDropdownDropdown", "PaymentsRefundsHistory")), By.xpath(getObj("Propval1", "Provider", "PaymentsRefundsHistory")), ReadTestData(TCName, "InvalidProvider"),
						"Provider");

			} else {
				Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "ProviderDropdownDropdown", "PaymentsRefundsHistory")), By.xpath(getObj("Propval1", "Provider", "PaymentsRefundsHistory")), Provider, "Provider");
			}
			if (isNegative.equalsIgnoreCase("true")) {
				try {
					Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "worngvalues", "PaymentsRefundsHistory")), "Invalid provider"));
					Log.pass("User is unable to search with invalid provider ");
					Utils.logPassImage(TCName+ " Invalid provider");
					return true;
				} catch (AssertionError | Exception e) {
					Log.fail("User isable to search with invalid provider ");
					Utils.logFailImage("Transfer Result");
					throw e;
				}

			}

			Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "ServiceDropdownDropdown", "PaymentsRefundsHistory")), By.xpath(getObj("Propval1", "Service", "PaymentsRefundsHistory")), Service, "Service");

			Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "AccountNumberDropdownDropdown", "PaymentsRefundsHistory")), By.xpath(getObj("Propval1", "AccountNumber", "PaymentsRefundsHistory")), AccountNumber, "Account Number");

			Utils.click(By.xpath(getObj("Propval1", "Search", "PaymentsRefundsHistory")), "Search");
			Utils.wait(3);
			Utils.pressEnter();
			Utils.refreshScreeen();
			String PaymentHistory = Utils.getText(By.xpath(getObj("Propval1", "searchResult1", "PaymentsRefundsHistory")));

			Log.pass("Payment History  Result :" + PaymentHistory);

			String RefundHistory = Utils.getText(By.xpath(getObj("Propval1", "searchResult2", "PaymentsRefundsHistory")));

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
			throw e;
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
