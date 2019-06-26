package javaMain.JOL.selfservice;

import static Utilities.ReadData.ReadDataSQL;
import static Utilities.ReadData.getObj;
import static javaMain.common_Functions.AppData.AfterTxfrAdditionalOptions;
import static javaMain.common_Functions.AppData.Fullname;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.openqa.selenium.By;

import Utilities.Input;
import Utilities.Log;
import Utilities.ReadData;
import Utilities.TestBase;
import Utilities.Utils;

/**
 * Description : Functional Test Script
 * 
 * @author baj80000892
 */
public class JOL_SELFSERVICE_ExpenseCategorization_FUNC extends TestBase {

	public static Boolean ExpenseCategorization_Test(String TCName, int ScenarioCount, Object[] tCsDataset) throws Exception {
		
		try {

			if (isMasterClassRun) {

				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + ReadData.getJsonData(TCName, ScenarioCount, "DataSet") + "</mark>");
				AfterTxfrAdditionalOptions = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "AfterTxfrAdditionalOptions"));
				Fullname = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Fullname"));

			} else {

				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + dataset[scenarioCount - 1] + "</mark>");
				AfterTxfrAdditionalOptions = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("AfterTxfrAdditionalOptions"));
				Fullname = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Fullname"));

			}

			Utils.click(By.xpath(getObj("Propval1", "SelfServices", "JOL_SELFSERVICE_ExpenseCategorization")), "Self Services");

			Utils.click(By.xpath(getObj("Propval1", "ExpenseCategorization", "JOL_SELFSERVICE_ExpenseCategorization")), "Expense Categorization");

			Utils.click(By.xpath(getObj("Propval1", "NewCategory", "JOL_SELFSERVICE_ExpenseCategorization")), "Expense Categorization");

			Utils.sendKeys(By.xpath(getObj("Propval1", "Categorytextbox", "JOL_SELFSERVICE_ExpenseCategorization")), Fullname, "Category");

			// New CateGory Cancel
			Utils.click(By.xpath(getObj("Propval1", "Categorycancel", "JOL_SELFSERVICE_ExpenseCategorization")), "Category cancel");

			Utils.logPassImage("Cancel Category");
			Utils.click(By.xpath(getObj("Propval1", "NewCategory", "JOL_SELFSERVICE_ExpenseCategorization")), "Expense Categorization");

			Utils.sendKeys(By.xpath(getObj("Propval1", "Categorytextbox", "JOL_SELFSERVICE_ExpenseCategorization")), Fullname, "Category");

			Utils.click(By.xpath(getObj("Propval1", "disablestatus", "JOL_SELFSERVICE_ExpenseCategorization")), "disable status");

			Utils.click(By.xpath(getObj("Propval1", "save", "JOL_SELFSERVICE_ExpenseCategorization")), "Expense Categorization");

			Utils.logPassImage("Save Category");

			Utils.click(By.xpath(getObj("Propval1", "delete", "JOL_SELFSERVICE_ExpenseCategorization")), "Delete");
			Utils.click(By.xpath(getObj("Propval1", "deleteConfirm", "JOL_SELFSERVICE_ExpenseCategorization")), "Delete Confirm");
			
		
			Utils.logPassImage("Delete Category");

			if (AfterTxfrAdditionalOptions.equalsIgnoreCase("false")) {
				sendEmailDownloadExcelnPrintFuncOrderStatus();

			}

		}

		catch (Exception e) {
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

			Utils.click(By.xpath(getObj("Propval1", "sendEmailIcon", "JOL_SELFSERVICE_ExpenseCategorization")), "Send Email Icon");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailTo", "JOL_SELFSERVICE_ExpenseCategorization")), Input.ReadTestData("MarketInfo", "toEmail"), "to email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailCC", "JOL_SELFSERVICE_ExpenseCategorization")), Input.ReadTestData("MarketInfo", "ccEmail"), "to CC email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "bccEmail", "JOL_SELFSERVICE_ExpenseCategorization")), Input.ReadTestData("MarketInfo", "bccEmail"), "to BCC  email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "emailSubject", "JOL_SELFSERVICE_ExpenseCategorization")), Input.ReadTestData("MarketInfo", "emailSubject"), "email Subject ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEMailMsgBox", "JOL_SELFSERVICE_ExpenseCategorization")), Input.ReadTestData("MarketInfo", "sendEMailMsgBox"), "Mail Body ");

			Utils.click(By.xpath(getObj("Propval1", "cancelemailBtnEle", "JOL_SELFSERVICE_ExpenseCategorization")), "Cancel Email Button");
			Utils.wait(5);
			Utils.click(By.xpath(getObj("Propval1", "sendEmailIcon", "JOL_SELFSERVICE_ExpenseCategorization")), "Send Email Icon");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailTo", "JOL_SELFSERVICE_ExpenseCategorization")), Input.ReadTestData("MarketInfo", "toEmail"), "to email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailCC", "JOL_SELFSERVICE_ExpenseCategorization")), Input.ReadTestData("MarketInfo", "ccEmail"), "to CC email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "bccEmail", "JOL_SELFSERVICE_ExpenseCategorization")), Input.ReadTestData("MarketInfo", "bccEmail"), "to BCC  email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "emailSubject", "JOL_SELFSERVICE_ExpenseCategorization")), Input.ReadTestData("MarketInfo", "emailSubject"), "email Subject ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEMailMsgBox", "JOL_SELFSERVICE_ExpenseCategorization")), Input.ReadTestData("MarketInfo", "sendEMailMsgBox"), "Mail Body ");
			Utils.wait(5);
			Utils.click(By.xpath(getObj("Propval1", "sendBtnEle", "JOL_SELFSERVICE_ExpenseCategorization")), "Send Email Button");
			Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "WaitingElements", "JOL_SELFSERVICE_ExpenseCategorization")));
			Utils.pressEnter();
			Utils.wait(2);
			Utils.pressEscapeKey(3);
			// Download report in pdf format.
			Utils.click(By.xpath(getObj("Propval1", "pdfDownloadIcon", "JOL_SELFSERVICE_ExpenseCategorization")), "pdf download");
			Utils.wait(3);
			Utils.enterOTPAndProceed();
			Utils.moveToElement(By.id("logo"));
			// Download report in excel format.
			Utils.click(By.xpath(getObj("Propval1", "excelDownloadIcon", "JOL_SELFSERVICE_ExpenseCategorization")), "Excel Download");
			Utils.wait(3);
			Utils.enterOTPAndProceed();
			Utils.moveToElement(By.id("logo"));
			// Print report.
			Utils.click(By.xpath(getObj("Propval1", "printBtnIcon", "JOL_SELFSERVICE_ExpenseCategorization")), "Print Button");
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
