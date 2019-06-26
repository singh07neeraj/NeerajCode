package javaMain.JOL.aljaziraCapital;

import static Utilities.ReadData.ReadDataSQL;
import static Utilities.ReadData.getObj;
import static javaMain.common_Functions.AppData.Account;
import static javaMain.common_Functions.AppData.AfterTxfrAdditionalOptions;
import static javaMain.common_Functions.AppData.CheckBox;
import static javaMain.common_Functions.AppData.Company;
import static javaMain.common_Functions.AppData.Confirm;
import static javaMain.common_Functions.AppData.NewTxn;
import static javaMain.common_Functions.AppData.Proceed;
import static javaMain.common_Functions.AppData.Seq;
import static javaMain.common_Functions.AppData.Subscribe;
import static javaMain.common_Functions.AppData.TCButton;
import static javaMain.common_Functions.AppData.Type;
import static javaMain.common_Functions.AppData.isNegative;

import org.openqa.selenium.By;

import Utilities.Input;
import Utilities.Log;
import Utilities.ReadData;
import Utilities.TestBase;
import Utilities.Utils;
import javaMain.common_Functions.OpenJOLMenues;

public class MUTUAL_FUNDS_IPORI_INQUIRY extends TestBase {
	 
	public static boolean IPORIInquiry(String TCName, int ScenarioCount, Object[] tCsDataset) throws Exception {
		boolean b = true;
		
		try {

			if (isMasterClassRun) {
				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + ReadData.getJsonData(TCName, ScenarioCount, "DataSet") + "</mark>");

				Type = ReadDataSQL(TCName, ScenarioCount, "Type");
				Proceed = ReadDataSQL(TCName, ScenarioCount, "Proceed");
				Company = ReadDataSQL(TCName, ScenarioCount, "Company");
				Account = ReadDataSQL(TCName, ScenarioCount, "Account");
				Seq = ReadDataSQL(TCName, ScenarioCount, "Seq");
				Subscribe = ReadDataSQL(TCName, ScenarioCount, "Subscribe");
				Confirm = ReadDataSQL(TCName, ScenarioCount, "Confirm");
				AfterTxfrAdditionalOptions = ReadDataSQL(TCName, ScenarioCount, "AfterTxfrAdditionalOptions");
				NewTxn = ReadDataSQL(TCName, ScenarioCount, "NewTxn");
				isNegative = ReadDataSQL(TCName, ScenarioCount, "isNegative");
				TCButton = ReadDataSQL(TCName, ScenarioCount, "TCButton");
				CheckBox = ReadDataSQL(TCName, ScenarioCount, "CheckBox");
			}

			else {
				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + ReadData.getJsonData(TCName, ScenarioCount, "DataSet") + "</mark>");

				Type = (String) Utils.getUiData(dataset[scenarioCount - 1]).get("Type");
				Proceed = (String) Utils.getUiData(dataset[scenarioCount - 1]).get("Proceed");
				Company = (String) Utils.getUiData(dataset[scenarioCount - 1]).get("Company");
				Account = (String) Utils.getUiData(dataset[scenarioCount - 1]).get("Account");
				Seq = (String) Utils.getUiData(dataset[scenarioCount - 1]).get("Seq");
				Subscribe = (String) Utils.getUiData(dataset[scenarioCount - 1]).get("Subscribe");
				Confirm = (String) Utils.getUiData(dataset[scenarioCount - 1]).get("Confirm");
				AfterTxfrAdditionalOptions = (String) Utils.getUiData(dataset[scenarioCount - 1])
						.get("AfterTxfrAdditionalOptions");
				NewTxn = (String) Utils.getUiData(dataset[scenarioCount - 1]).get("NewTxn");
				isNegative = (String) Utils.getUiData(dataset[scenarioCount - 1]).get("isNegative");
				TCButton = (String) Utils.getUiData(dataset[scenarioCount - 1]).get("TCButton");
				CheckBox = (String) Utils.getUiData(dataset[scenarioCount - 1]).get("CheckBox");
			}

			// Search Type- Market Info.- Starts

			
			OpenJOLMenues.openAljaziraCapitalMenu("IPORI_Inquiry");
			Utils.waitForInVisibilityOfEle(By.xpath("//*[@id='overlayInfo']"));
			String message=Utils.getText(By.xpath(getObj("Propval1","Result","MUTUAL_FUNDS_IPORIInquiry")));
			Log.pass("Display result is :"+message);
			Utils.logPassImage(TCName);
			
			if(AfterTxfrAdditionalOptions.equalsIgnoreCase("true"))
			{
				addFavSendEmailDownloadPdfNprintFuncBeneficiary(TCName);
			}
			
			Utils.logPassImage(TCName);
		} catch (Exception e) {
			b = false;
			gException = e;
			throw e;
		}
		return b;
	}

	public static boolean addFavSendEmailDownloadPdfNprintFuncBeneficiary(String Nickname) throws Exception {

		try {
			// Start sending email , downloading pdf and printing etc.
			Utils.wait(3);
			Log.info("Starting send email functionality");

			Utils.click(By.xpath(getObj("Propval1", "sendEmailIcon", "MUTUAL_FUNDS_IPORIInquiry")), "Send Email Icon");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailTo", "MUTUAL_FUNDS_IPORIInquiry")),
					Input.ReadTestData("MarketInfo", "toEmail"), "to email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailCC", "MUTUAL_FUNDS_IPORIInquiry")),
					Input.ReadTestData("MarketInfo", "ccEmail"), "to CC email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "bccEmail", "MUTUAL_FUNDS_IPORIInquiry")),
					Input.ReadTestData("MarketInfo", "bccEmail"), "to BCC  email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "emailSubject", "MUTUAL_FUNDS_IPORIInquiry")),
					Input.ReadTestData("MarketInfo", "emailSubject"), "email Subject ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEMailMsgBox", "MUTUAL_FUNDS_IPORIInquiry")),
					Input.ReadTestData("MarketInfo", "sendEMailMsgBox"), "Mail Body ");

			Utils.click(By.xpath(getObj("Propval1", "cancelemailBtnEle", "MUTUAL_FUNDS_IPORIInquiry")), "Cancel Email Button");
			Utils.wait(5);
			Utils.click(By.xpath(getObj("Propval1", "sendEmailIcon", "MUTUAL_FUNDS_IPORIInquiry")), "Send Email Icon");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailTo", "MUTUAL_FUNDS_IPORIInquiry")),
					Input.ReadTestData("MarketInfo", "toEmail"), "to email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailCC", "MUTUAL_FUNDS_IPORIInquiry")),
					Input.ReadTestData("MarketInfo", "ccEmail"), "to CC email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "bccEmail", "MUTUAL_FUNDS_IPORIInquiry")),
					Input.ReadTestData("MarketInfo", "bccEmail"), "to BCC  email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "emailSubject", "MUTUAL_FUNDS_IPORIInquiry")),
					Input.ReadTestData("MarketInfo", "emailSubject"), "email Subject ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEMailMsgBox", "MUTUAL_FUNDS_IPORIInquiry")),
					Input.ReadTestData("MarketInfo", "sendEMailMsgBox"), "Mail Body ");
			Utils.wait(5);
			Utils.click(By.xpath(getObj("Propval1", "sendBtnEle", "MUTUAL_FUNDS_IPORIInquiry")), "Send Email Button");
			Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "WaitingElements", "MUTUAL_FUNDS_IPORIInquiry")));
			Utils.pressEnter();
			Utils.wait(2);
			Utils.pressEscapeKey(3);

			Utils.pressEscapeKey(3);
			driver.navigate().refresh();
			// Download report in pdf format.
			Utils.click(By.xpath(getObj("Propval1", "pdfDownloadIcon", "MUTUAL_FUNDS_IPORIInquiry")), "pdf download");
			Utils.wait(3);
			Utils.enterOTPAndProceed();
			Utils.moveToElement(By.id("logo"));
			
			  driver.navigate().refresh(); // Download report in excel format.
			  Utils.click(By.xpath(getObj("Propval1", "excelDownloadIcon",
			  "MUTUAL_FUNDS_IPORIInquiry")), "Excel Download");
			 
			Utils.wait(3);
			// Utils.enterOTPAndProceed();
			Utils.moveToElement(By.id("logo"));
			// Print report.
			Utils.wait(6);
			driver.navigate().refresh();
			Utils.click(By.xpath(getObj("Propval1", "printBtnIcon", "MUTUAL_FUNDS_IPORIInquiry")), "Print Button");
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
