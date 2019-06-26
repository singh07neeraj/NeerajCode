package javaMain.JOL.fawri;

import static Utilities.Input.ReadTestData;
import static Utilities.ReadData.ReadDataSQL;
import static Utilities.ReadData.getObj;
import static javaMain.common_Functions.AppData.AdditionalActions;
import static javaMain.common_Functions.AppData.Menu;
import static javaMain.common_Functions.AppData.Proceed;
import static javaMain.common_Functions.AppData.TransferVia;

import org.openqa.selenium.By;
import org.testng.Assert;

import Utilities.Input;
import Utilities.Log;
import Utilities.ReadData;
import Utilities.TestBase;
import Utilities.Utils;
import javaMain.common_Functions.AppData;

public class JOL_FAWRI_BENEFICIARY_MANAGEMENT extends TestBase {

	public static Boolean JOL_FAWRI_BENEFICIARY_MANAGEMENT_Func(String TCName, int ScenarioCount, Object[] tCsDataset) throws Exception {


		//String Menu, TransferVia;

	    try
		{

			if (isMasterClassRun)
			{

				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + ReadData.getJsonData(TCName, ScenarioCount, "DataSet") + "</mark>");
				Menu = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Menu"));
				TransferVia = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "TransferVia"));
				AdditionalActions = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "AdditionalActions"));

			} else {

				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + ReadData.getJsonData(TCName, ScenarioCount, "DataSet") + "</mark>");
				Menu = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Menu"));
				TransferVia = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("TransferVia"));
				AdditionalActions = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("AdditionalActions"));
			}

			Utils.scrollUpVertically();	

			if (Menu.equalsIgnoreCase("Y")) {
				// Click on Fawri Tab//
				Utils.click(By.xpath(getObj("Propval1", "FawriLnk", "FawriBeneficiaryManagement")),"Fawri Tab");
				// Click Fawri Management Link on the left Panel//
				Utils.click(By.xpath(getObj("Propval1", "FawriManagementLnk", "FawriBeneficiaryManagement")),"Fawri Management Link");
				// Click Fawri Beneficiary Manangement on the left Panel//
				Utils.click(By.xpath(getObj("Propval1", "FawriBeneficiaryManagement_Y", "FawriBeneficiaryManagement")),"FawriBeneficiaryManagement");

			} 
			else if (Menu.equalsIgnoreCase("N")) {

				Utils.mouseHover(By.xpath(getObj("Propval1", "FawriLnk", "FawriBeneficiaryManagement")));
				Utils.click(By.xpath(getObj("Propval1", "FawriBeneficiaryManagement_N", "FawriBeneficiaryManagement")),"FawriBeneficiaryManagement");
			}

			Utils.getSizeNoException(By.xpath(getObj("Propval1", "BeneficiaryManagementHeading", "FawriBeneficiaryManagement")));





			if (Integer.parseInt(TransferVia)== 1)
			{
				//Select All from dropDown from dropdown//
				Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "TransferVia_DD_Clk", "FawriBeneficiaryManagement")), By.xpath(getObj("Propval1", "TransferVia_DD", "FawriBeneficiaryManagement")), Input.ReadTestData("JOL Fawri  - Add New Beneficiary","TransferVia_AllType"), "All Beneficiaries");

			}
			if (Integer.parseInt(TransferVia)== 2)
			{
				//Select RIA  dropDown from dropdown//
				Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "TransferVia_DD_Clk", "FawriBeneficiaryManagement")), By.xpath(getObj("Propval1", "TransferVia_DD", "FawriBeneficiaryManagement")), Input.ReadTestData("JOL Fawri  - Add New Beneficiary","TransferVia_Ria"), "RIA");

			}
			if (Integer.parseInt(TransferVia)== 3)
			{
				//Select MoneyGram from dropDown from dropdown//
				Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "TransferVia_DD_Clk", "FawriBeneficiaryManagement")), By.xpath(getObj("Propval1", "TransferVia_DD", "FawriBeneficiaryManagement")), Input.ReadTestData("JOL Fawri  - Add New Beneficiary","TransferVia_MoneyGram"), "MoneyGram");

			}
			if (Integer.parseInt(TransferVia)== 4)
			{
				//Select Direct Bank Deposit from dropDown from dropdown//
				Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "TransferVia_DD_Clk", "FawriBeneficiaryManagement")), By.xpath(getObj("Propval1", "TransferVia_DD", "FawriBeneficiaryManagement")), Input.ReadTestData("JOL Fawri  - Add New Beneficiary","TransferVia_DirectBankDeposit"), "Direct Bank Deposit");

			}

			Utils.click(By.xpath(getObj("Propval1", "SearchBtn", "FawriBeneficiaryManagement")), "SearchButton");
			Utils.wait(5);
			try {
				Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "ItemsDisplayed", "FawriBeneficiaryManagement")), "Search results"));
				Log.pass("Search results are displayed successfully. Results displayed are :-" + Utils.getSizeNoException(By.xpath(getObj("Propval1", "ItemsDisplayed", "FawriBeneficiaryManagement"))));
				Utils.logPassImage("Search results are displayed successfully - Pass");

			} catch (AssertionError | Exception e) {

				Log.pass("Search results are not displayed");
				Utils.logPassImage("Search results are not displayed - Pass");
				throw e;

			}
			if (AdditionalActions.equalsIgnoreCase("true")) {

				Log.pass("Successfully started other actions like send email, download pdf, excel and print search result etc.");
				sendEmailDownloadExcelnPrintFunc(ScenarioCount, Proceed);

			}



		} catch (AssertionError | Exception e)  {
			runResult = false;
			throw e;
		}
		return runResult;
	}
	public static boolean sendEmailDownloadExcelnPrintFunc(int ScenarioCount, String... proceedEmail) throws Exception {

		String sendEmail = "1";
		try {
			sendEmail = proceedEmail[0];
		} catch (Exception e) {
			sendEmail = "1";
		}

		try {

			// Download report in pdf format.
			Utils.click(By.xpath(getObj("Propval1", "pdfDownloadIcon", "AlZCapital")), "pdf download");
			Utils.wait(3);
			Utils.enterOTPAndProceed();
			Utils.wait(3);
			Utils.moveToElement(By.id("logo"));
			// Download report in excel format.
			Utils.click(By.xpath(getObj("Propval1", "excelDownloadIcon", "AlZCapital")), "Excel Download");
			Utils.wait(3);
			Utils.enterOTPAndProceed();
			Utils.wait(3);
			Utils.moveToElement(By.id("logo"));
			// Print report.
			Utils.click(By.xpath(getObj("Propval1", "printBtnIcon", "AlZCapital")), "Print Button");
			// close all other tabs except the main one. i.e 1st page.
			Utils.closeOtherTabs();

			// Start sending email , downloading pdf and printing etc.
			Utils.wait(3);
			Log.info("Starting send email functionality");

			Utils.click(By.xpath(getObj("Propval1", "sendEmailIcon", "FawriBeneficiaryManagement")), "Send Email Icon");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailTo", "AlZCapital")), ReadTestData(AppData.accountSet, "toEmail"), "to email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailCC", "AlZCapital")), ReadTestData(AppData.accountSet, "ccEmail"), "to CC email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "bccEmail", "AlZCapital")), ReadTestData(AppData.accountSet, "bccEmail"), "to BCC  email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "emailSubject", "AlZCapital")), ReadTestData(AppData.accountSet, "emailSubject"), "email Subject ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEMailMsgBox", "AlZCapital")), ReadTestData(AppData.accountSet, "sendEMailMsgBox"), "Mail Body ");

			//*[contains(@class,'dijit dijitReset dijitInline buttonRed dijitButton')]
			Utils.click(By.xpath(getObj("Propval1", "sendBtnEle", "AlZCapital")), "Send Email Button");

			Utils.waitForInVisibilityOfEle(By.xpath("//*[@id='overlayInfo']"));
			Utils.pressEnter();
			Utils.wait(3);
			Utils.pressEscapeKey(3);
			Log.pass("Successfully completed other actions like send email, download pdf, excel and print search result etc.");
		}

		catch (Exception e) {
			Log.fail("Unable to complete other actions like send email, download pdf, excel and print search result etc error..");
			Utils.logFailImage(TCName + "  Scenario count -" + ScenarioCount + " - sendEmailDownloadExcelnPrintFunc-error");
			runResult = false;
			throw e;

		}

		return runResult;
	}

}
