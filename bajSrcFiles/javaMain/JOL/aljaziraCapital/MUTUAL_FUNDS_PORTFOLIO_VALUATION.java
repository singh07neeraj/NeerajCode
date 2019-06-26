package javaMain.JOL.aljaziraCapital;

import static Utilities.Input.ReadTestData;
import static Utilities.ReadData.ReadDataSQL;
import static Utilities.ReadData.getObj;
import static javaMain.common_Functions.AppData.AdditionalActions;
import static javaMain.common_Functions.AppData.PortfolioNum;
import static javaMain.common_Functions.AppData.PortfolioType;
import static javaMain.common_Functions.AppData.Proceed;
import static javaMain.common_Functions.AppData.TestType;

import org.openqa.selenium.By;

import Utilities.Log;
import Utilities.ReadData;
import Utilities.TestBase;
import Utilities.Utils;
import javaMain.common_Functions.AppData;
import javaMain.common_Functions.OpenJOLMenues;

public class MUTUAL_FUNDS_PORTFOLIO_VALUATION extends TestBase {

	public static boolean openMutualFundsPortfolioValuationFunc(String TCName, int ScenarioCount, Object[] tCsDataset) throws Exception{
		
		try {

			if (isMasterClassRun) {
				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" +"Data set for this scenario is " + System.lineSeparator() + ReadData.getJsonData(TCName, ScenarioCount, "DataSet")+"</mark>");
				Proceed = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Proceed"));
				AdditionalActions = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "AfterTxfrAdditionalOptions"));
				TestType = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "TestType"));
				PortfolioType = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "PortfolioType"));
				PortfolioNum = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "PortfolioNum"));
				
				
			}

			else {
				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" +"Data set for this scenario is " + System.lineSeparator() + dataset[scenarioCount - 1]+"</mark>");
				Proceed = (String) Utils.getUiData(dataset[scenarioCount - 1]).get("Proceed");
				AdditionalActions = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("AfterTxfrAdditionalOptions"));
				TestType = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("TestType"));
				PortfolioType = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("PortfolioType"));
				PortfolioNum = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("PortfolioNum"));
			}
			
			//Open orders Inquiry page.
			OpenJOLMenues.openAljaziraCapitalMenu("PortfolioValuation");
			
			if (TestType.equalsIgnoreCase("P")) {

				Log.pass("Started executing positive scenario.");
				
				Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "portfolioValPortfolioTypeDropdown", "AlZCapital")), By.xpath(getObj("Propval1", "portfolioValPortfolioTypeINput", "AlZCapital")), PortfolioType, "Portfolio Type");
				
				Utils.click(By.xpath(getObj("Propval1", "portfolioValPortfolioNumDropdown", "AlZCapital")), "Portfolio Number dropdown");
				Utils.sendKeys(By.xpath(getObj("Propval1", "portfolioValPortfolioNumInput", "AlZCapital")),PortfolioNum, "Portfolio Number");

				Utils.click(By.xpath(getObj("Propval1", "SubsSearchBtnMutual", "AlZCapital")), "SearchButton");
				Utils.wait(3);

				String searchResultsCount = Utils.getText(By.xpath(getObj("Propval1", "searchResultsCount", "AlZCapital")));
				Log.pass("Search results are displayed successfully. Results displayed are :-" + searchResultsCount);
				
			}

			if (TestType.equalsIgnoreCase("N")) {

				Log.pass("Started executing negative scenario using negative data.");

				Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "portfolioValPortfolioTypeDropdown", "AlZCapital")), By.xpath(getObj("Propval1", "portfolioValPortfolioTypeINput", "AlZCapital")), "InvalidPortfolio Type !@#!@#", "Portfolio Type");
				
				Utils.click(By.xpath(getObj("Propval1", "portfolioValPortfolioNumDropdown", "AlZCapital")), "Portfolio Number dropdown");
				Utils.sendKeys(By.xpath(getObj("Propval1", "portfolioValPortfolioNumInput", "AlZCapital")), "Invalid PortfolioNum!#!@$!$!$", "Portfolio Number");
				
				Utils.click(By.xpath(getObj("Propval1", "SubsSearchBtnMutual", "AlZCapital")), "SearchButton");

				Utils.wait(3);

				String searchResultsCount = Utils.getText(By.xpath(getObj("Propval1", "searchResultsCount", "AlZCapital")));
				Log.pass("Search results are displayed successfully. Result displayed is  :-" + searchResultsCount + "Negative test case has passed. No search results displayed.");

			}

			if (AdditionalActions.equalsIgnoreCase("true")) {

				Log.pass("Successfully started other actions like send email, download pdf, excel and print search result etc.");
				sendEmailDownloadExcelnPrintFunc(ScenarioCount,Proceed);

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
				Utils.click(By.xpath(getObj("Propval1", "cancelemailBtnPortfolioEle", "AlZCapital")), "Cancel Email Button");
			} else {
				Utils.click(By.xpath(getObj("Propval1", "sendBtnEle", "AlZCapital")), "Send Email Button");
			}
			
			Utils.waitForInVisibilityOfEle(By.xpath("//*[@id='overlayInfo']"));
			Utils.pressEnter();
			Utils.wait(3);
			Utils.pressEscapeKey(3);
			Utils.wait(3);
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
