package javaMain.eCorp.MerchantSADADAccount;

import static Utilities.Input.ReadTestData;
import static Utilities.ReadData.ReadDataSQL;
import static Utilities.ReadData.getObj;
import static javaMain.common_Functions.AppData.AfterTxfrAdditionalOptions;
import static javaMain.common_Functions.AppData.BankReferenceNumber;
import static javaMain.common_Functions.AppData.EndDate;
import static javaMain.common_Functions.AppData.MerchantReferenceNumber;
import static javaMain.common_Functions.AppData.StartDate;
import static javaMain.common_Functions.AppData.Status;
import static javaMain.common_Functions.AppData.TransactionID;
import static javaMain.common_Functions.AppData.TransactionType;
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
public class eCorp_MERCHANT_SADAD_ACCOUNT_TRANSACTION_SEARCH_VIEW_FUNC extends TestBase {

	public static Boolean TransactionSearchView(String TCName, int ScenarioCount, Object[] tCsDataset) throws Exception {

		try {

			if (isMasterClassRun) {

				Log.pass("Data set for this scenario is " + System.lineSeparator() + ReadData.getJsonData(TCName, ScenarioCount, "DataSet"));
				AfterTxfrAdditionalOptions = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "AfterTxfrAdditionalOptions"));
				TransactionID = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "TransactionID"));
				MerchantReferenceNumber = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "MerchantReferenceNumber"));
				Status = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Status"));
				isNegative = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "isNegative"));
				TransactionType = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "TransactionType"));
				BankReferenceNumber = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "BankReferenceNumber"));
				StartDate = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "StartDate"));
				EndDate = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "EndDate"));

			} else {

				Log.pass("Data set for this scenario is " + System.lineSeparator() + dataset[scenarioCount - 1]);
				AfterTxfrAdditionalOptions = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("AfterTxfrAdditionalOptions"));
				TransactionID = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("TransactionID"));
				MerchantReferenceNumber = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("MerchantReferenceNumber"));
				Status = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Status"));
				isNegative = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("isNegative"));
				TransactionType = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("TransactionType"));
				BankReferenceNumber = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("BankReferenceNumber"));
				StartDate = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("StartDate"));
				EndDate = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("EndDate"));

			}

			Utils.refreshScreeen();
			Utils.click(By.xpath(getObj("Propval1", "MerchantSADADAccount", "eCorp_MerchantSADADAccount_TransactionSearchView")), "Merchant SADAD Account");
			Utils.click(By.xpath(getObj("Propval1", "OnlinePayments", "eCorp_MerchantSADADAccount_TransactionSearchView")), "Online Payments");

			Utils.click(By.xpath(getObj("Propval1", "TransactionSearchView", "eCorp_MerchantSADADAccount_TransactionSearchView")), "Transaction Search View");

			// Verify landing page
			String LandPage = Utils.getText(By.xpath(getObj("Propval1", "LandPage", "eCorp_MerchantSADADAccount_TransactionSearchView")));

			Log.pass("Landed Page is  :" + LandPage);

			Utils.sendKeys(By.xpath(getObj("Propval1", "transactionId", "eCorp_MerchantSADADAccount_TransactionSearchView")), ReadTestData(TCName, "TransactionID"), "transactionId");

			Utils.sendKeys(By.xpath(getObj("Propval1", "merchantReference", "eCorp_MerchantSADADAccount_TransactionSearchView")), ReadTestData(TCName, "MerchantReferenceNumber"), "merchant Reference");

			Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "transactionDropDown", "eCorp_MerchantSADADAccount_TransactionSearchView")), By.xpath(getObj("Propval1", "transactionType", "eCorp_MerchantSADADAccount_TransactionSearchView")),
					ReadTestData(TCName, "TransactionType"), "transaction Type");

			Utils.sendKeys(By.xpath(getObj("Propval1", "bankReference", "eCorp_MerchantSADADAccount_TransactionSearchView")), ReadTestData(TCName, "BankReferenceNumber"), "bank Reference");

			Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "DateFromDropDown", "eCorp_MerchantSADADAccount_TransactionSearchView")), By.xpath(getObj("Propval1", "DateFrom", "eCorp_MerchantSADADAccount_TransactionSearchView")),
					ReadTestData(TCName, "StartDate"), "Start Date");

			Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "DateToDropDown", "eCorp_MerchantSADADAccount_TransactionSearchView")), By.xpath(getObj("Propval1", "DateTo", "eCorp_MerchantSADADAccount_TransactionSearchView")),
					ReadTestData(TCName, "EndDate"), "End Date");

			Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "transactionStatusDropDown", "eCorp_MerchantSADADAccount_TransactionSearchView")),
					By.xpath(getObj("Propval1", "transactionStatus", "eCorp_MerchantSADADAccount_TransactionSearchView")), ReadTestData(TCName, "Status"), "transaction Status");

			if (isNegative.equalsIgnoreCase("true")) {

				try {

					Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "transactionDropDown", "eCorp_MerchantSADADAccount_TransactionSearchView")),
							By.xpath(getObj("Propval1", "transactionType", "eCorp_MerchantSADADAccount_TransactionSearchView")), ReadTestData(TCName, "InvalidTransactionType"), "transaction Type");

					Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "error", "eCorp_MerchantSADADAccount_TransactionSearchView")), "Error Message"));
					Log.pass("No search result are displayed with invalid data. Hence User is not able to search with invalid data");
					Utils.logPassImage(TCName);
					return true;

				} catch (AssertionError | Exception e) {

					Log.fail("Please add is Negative is False or enter invalid fields in displayed option in view transaction");
					Utils.logFailImage(TCName);
					return false;

				}

			}
			Utils.click(By.xpath(getObj("Propval1", "Search", "eCorp_MerchantSADADAccount_TransactionSearchView")), "Search");
			Utils.wait(3);

			Utils.logPassImage(TCName);
			if (AfterTxfrAdditionalOptions.equalsIgnoreCase("true")) {

				Log.pass("Starting additional actions after transfer. e.g send email, print and save as favourite.");
				eCorpCommonFunctions.sendEmailDownloadExcelnPrintFunc(ScenarioCount);
				Log.pass("Additional Actions  like send email, print and download pdf/excel etc have  passed successfully.");
				Utils.logPassImage("Additional Actions");
			}

		}

		catch (Exception e) {
			runResult = false;
			e.printStackTrace();

			return runResult;
		}
		return runResult;
	}

	public static boolean addFavSendEmailDownloadPdfNprintFuncBeneficiary(String Nickname) throws Exception {

		try {
			// Start sending email , downloading pdf and printing etc.
			Utils.wait(3);
			Log.info("Starting send email functionality");

			Utils.click(By.xpath(getObj("Propval1", "sendEmailIcon", "eCorp_MerchantSADADAccount_TransactionSearchView")), "Send Email Icon");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailTo", "eCorp_MerchantSADADAccount_TransactionSearchView")), Input.ReadTestData("MarketInfo", "toEmail"), "to email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailCC", "eCorp_MerchantSADADAccount_TransactionSearchView")), Input.ReadTestData("MarketInfo", "ccEmail"), "to CC email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "bccEmail", "eCorp_MerchantSADADAccount_TransactionSearchView")), Input.ReadTestData("MarketInfo", "bccEmail"), "to BCC  email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "emailSubject", "eCorp_MerchantSADADAccount_TransactionSearchView")), Input.ReadTestData("MarketInfo", "emailSubject"), "email Subject ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEMailMsgBox", "eCorp_MerchantSADADAccount_TransactionSearchView")), Input.ReadTestData("MarketInfo", "sendEMailMsgBox"), "Mail Body ");

			Utils.click(By.xpath(getObj("Propval1", "cancelemailBtnEle", "eCorp_MerchantSADADAccount_TransactionSearchView")), "Cancel Email Button");
			Utils.wait(5);
			Utils.click(By.xpath(getObj("Propval1", "sendEmailIcon", "eCorp_MerchantSADADAccount_TransactionSearchView")), "Send Email Icon");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailTo", "eCorp_MerchantSADADAccount_TransactionSearchView")), Input.ReadTestData("MarketInfo", "toEmail"), "to email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailCC", "eCorp_MerchantSADADAccount_TransactionSearchView")), Input.ReadTestData("MarketInfo", "ccEmail"), "to CC email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "bccEmail", "eCorp_MerchantSADADAccount_TransactionSearchView")), Input.ReadTestData("MarketInfo", "bccEmail"), "to BCC  email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "emailSubject", "eCorp_MerchantSADADAccount_TransactionSearchView")), Input.ReadTestData("MarketInfo", "emailSubject"), "email Subject ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEMailMsgBox", "eCorp_MerchantSADADAccount_TransactionSearchView")), Input.ReadTestData("MarketInfo", "sendEMailMsgBox"), "Mail Body ");
			Utils.wait(5);
			Utils.click(By.xpath(getObj("Propval1", "sendBtnEle", "eCorp_MerchantSADADAccount_TransactionSearchView")), "Send Email Button");
			Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "WaitingElements", "eCorp_MerchantSADADAccount_TransactionSearchView")));
			Utils.pressEnter();
			Utils.wait(2);
			Utils.pressEscapeKey(3);

			Utils.pressEscapeKey(3);
			driver.navigate().refresh();
			// Download report in pdf format.
			Utils.click(By.xpath(getObj("Propval1", "pdfDownloadIcon", "eCorp_MerchantSADADAccount_TransactionSearchView")), "pdf download");
			Utils.wait(3);

			Utils.moveToElement(By.id("logo"));
			driver.navigate().refresh();
			// Download report in excel format.
			Utils.click(By.xpath(getObj("Propval1", "excelDownloadIcon", "eCorp_MerchantSADADAccount_TransactionSearchView")), "Excel Download");
			Utils.closeOtherTabs();
			// Download report in Text format.
			Utils.click(By.xpath(getObj("Propval1", "textDownloadIcon", "eCorp_MerchantSADADAccount_TransactionSearchView")), "text Download");
			Utils.closeOtherTabs();
			// Download report in CSV format.
			Utils.click(By.xpath(getObj("Propval1", "csvDownloadIcon", "eCorp_MerchantSADADAccount_TransactionSearchView")), "CSV Download");
			Utils.closeOtherTabs();

			Utils.wait(3);
			// Utils.enterOTPAndProceed();
			Utils.moveToElement(By.id("logo"));
			// Print report.
			Utils.wait(6);
			driver.navigate().refresh();
			Utils.click(By.xpath(getObj("Propval1", "printBtnIcon", "eCorp_MerchantSADADAccount_TransactionSearchView")), "Print Button");
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
