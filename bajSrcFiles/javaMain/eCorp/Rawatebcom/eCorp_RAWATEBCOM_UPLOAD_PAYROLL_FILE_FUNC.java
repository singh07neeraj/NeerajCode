package javaMain.eCorp.Rawatebcom;

import static Utilities.ReadData.ReadDataSQL;
import static Utilities.ReadData.getObj;
import static javaMain.common_Functions.AppData.AMOUNT;
import static javaMain.common_Functions.AppData.AfterTxfrAdditionalOptions;
import static javaMain.common_Functions.AppData.Confirm;
import static javaMain.common_Functions.AppData.Currency;
import static javaMain.common_Functions.AppData.FutureDate;
import static javaMain.common_Functions.AppData.MOLID;
import static javaMain.common_Functions.AppData.NewTxn;
import static javaMain.common_Functions.AppData.NextDate;
import static javaMain.common_Functions.AppData.Proceed;
import static javaMain.common_Functions.AppData.Record;
import static javaMain.common_Functions.AppData.details;
import static javaMain.common_Functions.AppData.isNegative;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
public class eCorp_RAWATEBCOM_UPLOAD_PAYROLL_FILE_FUNC extends TestBase {

	public static Boolean Uploadfile(String TCName, int ScenarioCount, Object[] tCsDataset) throws Exception {

		try {

			if (isMasterClassRun) {

				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + ReadData.getJsonData(TCName, ScenarioCount, "DataSet") + "</mark>");

				AfterTxfrAdditionalOptions = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "AfterTxfrAdditionalOptions"));
				isNegative = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "isNegative"));
				Proceed = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Proceed"));
				Confirm = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Confirm"));
				NewTxn = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "NewTxn"));

				MOLID =Input.ReadTestData(TCName, "MOLID");
				details =Input.ReadTestData(TCName, "details");
				Currency = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Currency"));
				NextDate =Input.ReadTestData(TCName, "NextDate");
				FutureDate = NextDate =Input.ReadTestData(TCName, "FutureDate");
				AMOUNT = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "AMOUNT"));
				NextDate =Input.ReadTestData(TCName, "NextDate");
				Record =Input.ReadTestData(TCName, "NoOfRecordInFile");
				
			} else {

				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + dataset[scenarioCount - 1] + "</mark>");
				AfterTxfrAdditionalOptions = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("AfterTxfrAdditionalOptions"));

				isNegative = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("isNegative"));
				Proceed = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Proceed"));
				Confirm = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Confirm"));
				NewTxn = (String) Utils.getUiData(dataset[scenarioCount - 1]).get("NewTxn");

				MOLID =Input.ReadTestData(TCName, "MOLID");
				details =Input.ReadTestData(TCName, "details");
				Currency = (String) Utils.getUiData(dataset[scenarioCount - 1]).get("Currency");
				NextDate =Input.ReadTestData(TCName, "NextDate");
				FutureDate = NextDate =Input.ReadTestData(TCName, "FutureDate");
				Record =Input.ReadTestData(TCName, "NoOfRecordInFile");
				AMOUNT = (String) Utils.getUiData(dataset[scenarioCount - 1]).get("AMOUNT");
				
			}
			
			
			
			Utils.refreshScreeen();
			Utils.click(By.xpath(getObj("Propval1", "Rawatebcom", "eCorp_Rawatebcom_UploadPayrollFile")), "Rawatebcom");
			Utils.wait(2);
			Utils.click(By.xpath(getObj("Propval1", "UploadFileMenu", "eCorp_Rawatebcom_UploadPayrollFile")), "Upload File");

			// Verify landing page
			String LandPage = Utils.getText(By.xpath(getObj("Propval1", "LandPage", "eCorp_Rawatebcom_UploadPayrollFile")));

			Log.pass("Landed Page is  :" + LandPage);

			Utils.ClearText(By.xpath(getObj("Propval1", "molId", "eCorp_Rawatebcom_UploadPayrollFile")));
			Utils.sendKeys(By.xpath(getObj("Propval1", "molId", "eCorp_Rawatebcom_UploadPayrollFile")), MOLID, "MOL Id");

			Utils.ClearText(By.xpath(getObj("Propval1", "PaymentDesc", "eCorp_Rawatebcom_UploadPayrollFile")));
			Utils.sendKeys(By.xpath(getObj("Propval1", "PaymentDesc", "eCorp_Rawatebcom_UploadPayrollFile")), details, "Payments Description");

			Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "Currencydropdown", "eCorp_Rawatebcom_UploadPayrollFile")), By.xpath(getObj("Propval1", "Currency", "eCorp_Rawatebcom_UploadPayrollFile")), Currency, "Currency");

			Utils.click(By.xpath(getObj("Propval1", "valueDatedropdown", "eCorp_Rawatebcom_UploadPayrollFile")), "StartDatedropdown");
			Utils.sendKeys(By.xpath(getObj("Propval1", "valueDate", "eCorp_Rawatebcom_UploadPayrollFile")), NextDate, "NextDate");

			Utils.click(By.xpath(getObj("Propval1", "DebitDatedropdown", "eCorp_Rawatebcom_UploadPayrollFile")), "StartDatedropdown");
			Utils.sendKeys(By.xpath(getObj("Propval1", "DebitDate", "eCorp_Rawatebcom_UploadPayrollFile")), FutureDate, "FutureDate");

			Utils.ClearText(By.xpath(getObj("Propval1", "TotalRecord", "eCorp_Rawatebcom_UploadPayrollFile")));
			Utils.sendKeys(By.xpath(getObj("Propval1", "TotalRecord", "eCorp_Rawatebcom_UploadPayrollFile")), Record, "TotalRecord");

			Utils.ClearText(By.xpath(getObj("Propval1", "Amount", "eCorp_Rawatebcom_UploadPayrollFile")));
			Utils.sendKeys(By.xpath(getObj("Propval1", "Amount", "eCorp_Rawatebcom_UploadPayrollFile")), AMOUNT, "AMOUNT");

			WebElement uploadElement = driver.findElement(By.xpath(getObj("Propval1", "UploadFile", "eCorp_Rawatebcom_UploadPayrollFile")));

			// Enter the file path onto the file-selection input field
			String UploadFilePath = System.getProperty("user.dir") + Input.ReadTestData(TCName, "UploadFilePath");

			uploadElement.sendKeys(UploadFilePath);
			Utils.pressEnter();

			if (Integer.parseInt(Proceed) == 1) {

				Utils.click(By.xpath(getObj("Propval1", "Proceed", "eCorp_Rawatebcom_UploadPayrollFile")), "Proceed");

			} else {

				Utils.click(By.xpath(getObj("Propval1", "Cancel", "eCorp_Rawatebcom_UploadPayrollFile")), " Cancel");

				Utils.logPassImage(TCName);
				return runResult;

			}

			if (isNegative.equalsIgnoreCase("true")) {
				try {

					Assert.assertFalse(Utils.assertDisplayed(By.xpath(getObj("Propval1", "Confirm", "eCorp_Rawatebcom_UploadPayrollFile")), "Result Details."));
					Log.pass("User is not able to proceed without enter all the mandatory fields ");
					Utils.logPassImage(TCName);
					return true;

				} catch (AssertionError | Exception e) {

					Log.fail("User is able to proceed with entering invalid details please review the page again");
					Utils.logFailImage(TCName);

				}

			}
			if (Integer.parseInt(Confirm) == 1) {

				Utils.click(By.xpath(getObj("Propval1", "Confirm", "eCorp_Rawatebcom_UploadPayrollFile")), "Confirm");

			} else if (Integer.parseInt(Confirm) == 2) {

				if (AppData.getLanguage().equalsIgnoreCase("Arabic")) {
					Utils.click(By.xpath(getObj("Propval1", "modifyarabic", "eCorp_Rawatebcom_UploadPayrollFile")), "Modify");
				} else {
					Utils.click(By.xpath(getObj("Propval1", "modify", "eCorp_Rawatebcom_UploadPayrollFile")), "Modify");
				}
				WebElement uploadElement1 = driver.findElement(By.xpath(getObj("Propval1", "UploadFile", "eCorp_Rawatebcom_UploadPayrollFile")));

				// enter the file path onto the file-selection input field
				uploadElement1.sendKeys(UploadFilePath);
				Utils.pressEnter();

				Utils.click(By.xpath(getObj("Propval1", "Proceed", "eCorp_Rawatebcom_UploadPayrollFile")), "Modify Proceed");

				Utils.click(By.xpath(getObj("Propval1", "Confirm", "eCorp_Rawatebcom_UploadPayrollFile")), "Modify Confirm");

			} else {
				Utils.click(By.xpath(getObj("Propval1", "Cancel", "eCorp_Rawatebcom_UploadPayrollFile")), "Confirm Cancel");
				Utils.wait(6);
				if (AppData.getLanguage().equalsIgnoreCase("Arabic")) {
					Utils.click(By.xpath(getObj("Propval1", "CancelYesarabic", "eCorp_Rawatebcom_UploadPayrollFile")), "Confirm Cancel yes");
				}

				else {
					Utils.click(By.xpath(getObj("Propval1", "CancelYes", "eCorp_Rawatebcom_UploadPayrollFile")), "Confirm Cancel yes");
				}
				Log.pass("Click on Confirm Return ......");
				Utils.logPassImage(TCName);
				return runResult;
			}

			try {
				Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "SuccessMessage", "eCorp_Rawatebcom_UploadPayrollFile")), "Success Message"));
				Log.pass("AddCompany CR Details successfully." + Utils.getText(By.xpath(getObj("Propval1", "SuccessMessage", "eCorp_Rawatebcom_UploadPayrollFile"))));
				Utils.logPassImage("AddCompany CR Details-Pass");

			} catch (AssertionError | Exception e) {

				Log.fail("AddCompany CR Details failed...Message:" + Utils.getText(By.xpath(getObj("Propval1", "failMessage", "eCorp_Rawatebcom_UploadPayrollFile"))));
				Utils.logFailImage("AddCompany CR Details-Fail");
				throw e;
			}

			Utils.wait(2);
			Utils.logPassImage(TCName);

			if (AfterTxfrAdditionalOptions.equalsIgnoreCase("true")) {
				Log.pass("Starting additional actions after transfer. e.g send email, print and save as favourite.");
				eCorpCommonFunctions.sendEmailDownloadExcelnPrintFunc(ScenarioCount);
				Log.pass("Additional Actions  like send email, print and download pdf/excel etc have  passed successfully.");
				Utils.logPassImage("Additional Actions");
			}

			if (NewTxn.equalsIgnoreCase("1")) {
				Utils.scrollDownVertically();
				if (AppData.getLanguage().equalsIgnoreCase("Arabic")) {
					Utils.click(By.xpath(getObj("Propval1", "NewTransactionBtnArabic", "eCorp_Rawatebcom_UploadPayrollFile")), "New Transaction");
				} else {
					Utils.click(By.xpath(getObj("Propval1", "NewTransactionBtn", "eCorp_Rawatebcom_UploadPayrollFile")), "New Transaction");
				}
				Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "proceed", "eCorp_Rawatebcom_UploadPayrollFile")), "proceed"));
				Utils.logPassImage(TCName);
			} else {
				Utils.click(By.xpath(getObj("Propval1", "Home", "eCorp_Rawatebcom_UploadPayrollFile")), "Home Button.");
				Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "noSearchResult", "STANDING_ORDERS_MANAGEMENT")), "Home"));
				Utils.logPassImage(TCName);
				Utils.logPassImage(TCName);
			}
		} catch (Exception e) {
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

			Utils.click(By.xpath(getObj("Propval1", "sendEmailIcon", "eCorp_Rawatebcom_UploadPayrollFile")), "Send Email Icon");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailTo", "eCorp_Rawatebcom_UploadPayrollFile")), Input.ReadTestData("MarketInfo", "toEmail"), "to email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailCC", "eCorp_Rawatebcom_UploadPayrollFile")), Input.ReadTestData("MarketInfo", "ccEmail"), "to CC email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "bccEmail", "eCorp_Rawatebcom_UploadPayrollFile")), Input.ReadTestData("MarketInfo", "bccEmail"), "to BCC  email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "emailSubject", "eCorp_Rawatebcom_UploadPayrollFile")), Input.ReadTestData("MarketInfo", "emailSubject"), "email Subject ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEMailMsgBox", "eCorp_Rawatebcom_UploadPayrollFile")), Input.ReadTestData("MarketInfo", "sendEMailMsgBox"), "Mail Body ");

			Utils.click(By.xpath(getObj("Propval1", "cancelemailBtnEle", "eCorp_Rawatebcom_UploadPayrollFile")), "Cancel Email Button");
			Utils.wait(5);
			Utils.click(By.xpath(getObj("Propval1", "sendEmailIcon", "eCorp_Rawatebcom_UploadPayrollFile")), "Send Email Icon");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailTo", "eCorp_Rawatebcom_UploadPayrollFile")), Input.ReadTestData("MarketInfo", "toEmail"), "to email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailCC", "eCorp_Rawatebcom_UploadPayrollFile")), Input.ReadTestData("MarketInfo", "ccEmail"), "to CC email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "bccEmail", "eCorp_Rawatebcom_UploadPayrollFile")), Input.ReadTestData("MarketInfo", "bccEmail"), "to BCC  email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "emailSubject", "eCorp_Rawatebcom_UploadPayrollFile")), Input.ReadTestData("MarketInfo", "emailSubject"), "email Subject ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEMailMsgBox", "eCorp_Rawatebcom_UploadPayrollFile")), Input.ReadTestData("MarketInfo", "sendEMailMsgBox"), "Mail Body ");
			Utils.wait(5);
			Utils.click(By.xpath(getObj("Propval1", "sendBtnEle", "eCorp_Rawatebcom_UploadPayrollFile")), "Send Email Button");
			Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "WaitingElements", "eCorp_Rawatebcom_UploadPayrollFile")));
			Utils.pressEnter();
			Utils.wait(2);
			Utils.pressEscapeKey(3);

			Utils.pressEscapeKey(3);
			driver.navigate().refresh();
			// Download report in pdf format.
			Utils.click(By.xpath(getObj("Propval1", "pdfDownloadIcon", "eCorp_Rawatebcom_UploadPayrollFile")), "pdf download");
			Utils.wait(3);
			Utils.enterOTPAndProceed();
			Utils.moveToElement(By.id("logo"));
			driver.navigate().refresh();
			// Download report in excel format.
			/*
			 * Utils.click(By.xpath(getObj("Propval1", "excelDownloadIcon",
			 * "eCorp_Rawatebcom_UploadPayrollFile")), "Excel Download");
			 */
			Utils.wait(3);
			// Utils.enterOTPAndProceed();
			Utils.moveToElement(By.id("logo"));
			// Print report.
			Utils.wait(6);
			driver.navigate().refresh();
			Utils.click(By.xpath(getObj("Propval1", "printBtnIcon", "eCorp_Rawatebcom_UploadPayrollFile")), "Print Button");
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
