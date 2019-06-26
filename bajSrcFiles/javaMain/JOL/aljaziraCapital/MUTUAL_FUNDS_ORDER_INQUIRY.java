package javaMain.JOL.aljaziraCapital;

import static Utilities.Input.ReadTestData;
import static Utilities.ReadData.ReadDataSQL;
import static Utilities.ReadData.getObj;
import static javaMain.common_Functions.AppData.AdditionalActions;
import static javaMain.common_Functions.AppData.BuySell;
import static javaMain.common_Functions.AppData.OrdersType;
import static javaMain.common_Functions.AppData.PortfolioNum;
import static javaMain.common_Functions.AppData.Proceed;
import static javaMain.common_Functions.AppData.SymbolType;
import static javaMain.common_Functions.AppData.TestType;
import static javaMain.common_Functions.AppData.dateFrom;
import static javaMain.common_Functions.AppData.dateTo;
import static javaMain.common_Functions.AppData.runLanguage;

import org.openqa.selenium.By;

import Utilities.Log;
import Utilities.ReadData;
import Utilities.TestBase;
import Utilities.Utils;
import javaMain.common_Functions.AppData;
import javaMain.common_Functions.OpenJOLMenues;

public class MUTUAL_FUNDS_ORDER_INQUIRY extends TestBase {

	
	@SuppressWarnings("unused")
	public static boolean openMutualFundsOrderInquiryFunc(String TCName, int ScenarioCount, Object[] tCsDataset) throws Exception {

		try {

			if (true) {
				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + ReadData.getJsonData(TCName, ScenarioCount, "DataSet") + "</mark>");
				Proceed = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Proceed"));
				AdditionalActions = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "AfterTxfrAdditionalOptions"));
				TestType = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "TestType"));
				PortfolioNum = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "PortfolioNum"));// change tomorrow
				OrdersType = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "OrdersType")); // Need to change
				SymbolType = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "SymbolType"));//
				dateFrom = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "dateFrom"));//
				dateTo = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "dateTo"));//
				BuySell = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "BuySell"));//

			}

			else {
				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + dataset[scenarioCount - 1] + "</mark>");
				Proceed = (String) Utils.getUiData(dataset[scenarioCount - 1]).get("Proceed");
				AdditionalActions = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("AfterTxfrAdditionalOptions"));
				TestType = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("TestType"));
				OrdersType = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("OrdersType"));
				PortfolioNum = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("PortfolioNum"));
				SymbolType = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("SymbolType"));
				dateFrom = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("dateFrom"));
				dateTo = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("dateTo"));
				BuySell = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("BuySell"));

			}

			// Open orders Inquiry page.
			OpenJOLMenues.openAljaziraCapitalMenu("OrdersInquiry");

			if (TestType.equalsIgnoreCase("P")) {

				Log.pass("Started executing positive scenario.");

				Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "OrdersTypeDropdown", "AlZCapital")), By.xpath(getObj("Propval1", "ordersTypeInput", "AlZCapital")), OrdersType, "Orders Type");

				Utils.click(By.xpath(getObj("Propval1", "portfolioNumDropDown", "AlZCapital")), "Portfolio Number dropdown");
				Utils.sendKeys(By.xpath(getObj("Propval1", "portfolioNumInput", "AlZCapital")), PortfolioNum, "Portfolio Number");

				if (runLanguage.equalsIgnoreCase("EN")) {
					if (!OrdersType.contains("Outstanding Orders")) {

						Log.pass("Order type is : " + OrdersType);
						// Select symbol type
						Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "symbolDropDown", "AlZCapital")), By.xpath(getObj("Propval1", "symbolValue", "AlZCapital")), SymbolType, "Symbol Type");
						// Select from date.
						Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "fromDateDropDown", "AlZCapital")), By.xpath(getObj("Propval1", "fromDateInput", "AlZCapital")), dateFrom, "From date");
						// Select TO date.
						Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "toDateDropDown", "AlZCapital")), By.xpath(getObj("Propval1", "toDateInput", "AlZCapital")), dateTo, "To date");

						Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "buySellDropdown", "AlZCapital")), By.xpath(getObj("Propval1", "buySellInput", "AlZCapital")), BuySell, "Buy/Sell field.");

					}
					
				}
				if (runLanguage.equalsIgnoreCase("Arabic")) {
					if (!OrdersType.contains("«·√Ê«„— «·ﬁ«∆„…")) {

						Log.pass("Order type is : " + OrdersType);
						// Select symbol type
						Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "symbolDropDown", "AlZCapital")), By.xpath(getObj("Propval1", "symbolValue", "AlZCapital")), SymbolType, "Symbol Type");
						// Select from date.
						Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "fromDateDropDown", "AlZCapital")), By.xpath(getObj("Propval1", "fromDateInput", "AlZCapital")), dateFrom, "From date");
						// Select TO date.
						Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "toDateDropDown", "AlZCapital")), By.xpath(getObj("Propval1", "toDateInput", "AlZCapital")), dateTo, "To date");

						Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "buySellDropdown", "AlZCapital")), By.xpath(getObj("Propval1", "buySellInput", "AlZCapital")), BuySell, "Buy/Sell field.");

					}
					
				}
				
				Utils.click(By.xpath(getObj("Propval1", "SubsSearchBtnMutual", "AlZCapital")), "SearchButton");

				Utils.wait(3);

				String searchResultsCount = Utils.getText(By.xpath(getObj("Propval1", "searchResultsCount", "AlZCapital")));
				Log.pass("Search results are displayed successfully. Results displayed are :-" + searchResultsCount);

			}

			if (TestType.equalsIgnoreCase("N")) {

				Log.pass("Started executing negative scenario.");

				Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "OrdersTypeDropdown", "AlZCapital")), By.xpath(getObj("Propval1", "ordersTypeInput", "AlZCapital")), "InvalidOrder Type !@#!@#", "Orders Type");

				Utils.click(By.xpath(getObj("Propval1", "portfolioNumDropDown", "AlZCapital")), "Portfolio Number dropdown");
				Utils.sendKeys(By.xpath(getObj("Propval1", "portfolioNumInput", "AlZCapital")), "Invalid PortfolioNum!#!@$!$!$", "Portfolio Number");

				Utils.click(By.xpath(getObj("Propval1", "SubsSearchBtnMutual", "AlZCapital")), "SearchButton");

				Utils.wait(3);

				String searchResultsCount = Utils.getText(By.xpath(getObj("Propval1", "searchResultsCount", "AlZCapital")));
				Log.pass("Search results are displayed successfully. Result displayed is  :-" + searchResultsCount + " Negative test case has passed. No search results displayed.");

			}
			
			try {
				driver.findElement(By.xpath(getObj("Propval1", "Accept_btn", "AlZCapital"))).click(); // Temporary to handle unwanted pop up. 
			} catch (Exception e) {
             //NA
			}
			Utils.wait(3);
			if (AdditionalActions.equalsIgnoreCase("true")) {

				Log.pass("Successfully started other actions like send email, download pdf, excel and print search result etc.");
				sendEmailDownloadExcelnPrintFunc(ScenarioCount, Proceed);

			}

			try {
				driver.findElement(By.xpath(getObj("Propval1", "Accept_btn", "AlZCapital"))).click(); // Temporary to handle unwanted pop up.
			} catch (Exception e) {
             //NA
			}
			
			
		} catch (Exception e) {
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

			Utils.click(By.xpath(getObj("Propval1", "sendEmailIcon", "AlZCapital")), "Send Email Icon");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailTo", "AlZCapital")), ReadTestData(AppData.accountSet, "toEmail"), "to email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailCC", "AlZCapital")), ReadTestData(AppData.accountSet, "ccEmail"), "to CC email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "bccEmail", "AlZCapital")), ReadTestData(AppData.accountSet, "bccEmail"), "to BCC  email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "emailSubject", "AlZCapital")), ReadTestData(AppData.accountSet, "emailSubject"), "email Subject ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEMailMsgBox", "AlZCapital")), ReadTestData(AppData.accountSet, "sendEMailMsgBox"), "Mail Body ");

			//*[contains(@class,'dijit dijitReset dijitInline buttonRed dijitButton')]
			
			// Send email if proceed=1 in DB
			if (Integer.parseInt(sendEmail) == 1) {
				Utils.click(By.xpath(getObj("Propval1", "sendBtnEle", "AlZCapital")), "Send Email Button");
			}
			// Hit cancel email if Proceed=2 in DB.
			else if (Integer.parseInt(sendEmail) == 2) {
				Utils.click(By.xpath(getObj("Propval1", "cancelemailBtnEle", "AlZCapital")), "Cancel Email Button");
			} else {
				Utils.click(By.xpath(getObj("Propval1", "sendBtnEle", "AlZCapital")), "Send Email Button");
			}
			
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
