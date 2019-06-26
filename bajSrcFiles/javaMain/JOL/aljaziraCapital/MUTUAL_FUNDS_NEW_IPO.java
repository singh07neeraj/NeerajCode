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
import org.testng.Assert;

import Utilities.Input;
import Utilities.Log;
import Utilities.ReadData;
import Utilities.TestBase;
import Utilities.Utils;
import javaMain.common_Functions.AppData;
import javaMain.common_Functions.OpenJOLMenues;

public class MUTUAL_FUNDS_NEW_IPO extends TestBase {
	
	public static boolean NEW_IPO(String TCName, int ScenarioCount, Object[] tCsDataset) throws Exception {
		
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
				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" +"Data set for this scenario is " + System.lineSeparator() + dataset[scenarioCount - 1]+"</mark>");
				Type = (String) Utils.getUiData(dataset[scenarioCount - 1]).get("Type");
				Proceed = (String) Utils.getUiData(dataset[scenarioCount - 1]).get("Proceed");
				Company = (String) Utils.getUiData(dataset[scenarioCount - 1]).get("Company");
				Account = (String) Utils.getUiData(dataset[scenarioCount - 1]).get("Account");
				Seq = (String) Utils.getUiData(dataset[scenarioCount - 1]).get("Seq");
				Subscribe = (String) Utils.getUiData(dataset[scenarioCount - 1]).get("Subscribe");
				Confirm = (String) Utils.getUiData(dataset[scenarioCount - 1]).get("Confirm");
				AfterTxfrAdditionalOptions = (String) Utils.getUiData(dataset[scenarioCount - 1]).get("AfterTxfrAdditionalOptions");
				NewTxn = (String) Utils.getUiData(dataset[scenarioCount - 1]).get("NewTxn");
				isNegative = (String) Utils.getUiData(dataset[scenarioCount - 1]).get("isNegative");
				TCButton = (String) Utils.getUiData(dataset[scenarioCount - 1]).get("TCButton");
				CheckBox = (String) Utils.getUiData(dataset[scenarioCount - 1]).get("CheckBox");
			}

			// Search Type- Market Info.- Starts
			
			OpenJOLMenues.openAljaziraCapitalMenu("NewIPO");
			Utils.waitForInVisibilityOfEle(By.xpath("//*[@id='overlayInfo']"));
			Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "Companydropdown", "JOL_Mutual_NEW_IPO")), By.xpath(getObj("Propval1", "Company", "JOL_Mutual_NEW_IPO")), Company,"Company dropdown");

			Utils.wait(5);
			if (isNegative.equalsIgnoreCase("true")) {
				try {

					Assert.assertFalse(Utils.assertDisplayed(By.xpath(getObj("Propval1", "AccountNumber", "JOL_Mutual_NEW_IPO")), "Account Number"));
					Log.pass("No Account field is displayed please enter valid company name");

					Utils.logPassImage(TCName);
					return true;
				} catch (AssertionError | Exception e) {

				}
			}

			Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "AccountNumberDropdown", "JOL_Mutual_NEW_IPO")), By.xpath(getObj("Propval1", "AccountNumber", "WithinBaj_Transfers")), Account);

			Utils.sendKeys(By.xpath(getObj("Propval1", "numberOfShares", "JOL_Mutual_NEW_IPO")), Seq, "No fo Share");

			Utils.ClearText(By.xpath(getObj("Propval1", "subscribers", "JOL_Mutual_NEW_IPO")));

			Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "subscribersDropdown", "JOL_Mutual_NEW_IPO")), By.xpath(getObj("Propval1", "subscribers", "JOL_Mutual_NEW_IPO")), Subscribe);

			if (TCButton.equalsIgnoreCase("True")) {
				if (CheckBox.equalsIgnoreCase("True")) {
					// Click on the terms and Conditions CheckBox Directly//
					Utils.click(By.xpath(getObj("Propval1", "CheckBoxTC", "JOL_Mutual_NEW_IPO")), "on Terms and Conditons Button directly");
				} else if (CheckBox.equalsIgnoreCase("False")) {
					// Click on the link of Terms and Conditions//
					Utils.click(By.xpath(getObj("Propval1", "TnCpoup", "JOL_Mutual_NEW_IPO")), "which is a link of Terms and Conditions");
					// Click on I Accept Radio of the pop up//
					Utils.click(By.xpath(getObj("Propval1", "TnCAgree", "JOL_Mutual_NEW_IPO")), "which is I Accept RadioButton");

				}

			} else if (TCButton.equalsIgnoreCase("False")) {
				// Click on Proceed Button//
				Utils.click(By.xpath(getObj("Propval1", "Proceed", "JOL_Mutual_NEW_IPO")), "Proceed Button");

				try {

					// This is to validate if the user moves to the next page without selecting
					// Terms and Condition CheckBox//
					Assert.assertEquals(Utils.assertDisplayed(By.xpath(getObj("Propval1", "Confirm", "JOL_Mutual_NEW_IPO")), "Confirm"), false);
					Log.pass("Successfully validated that user is unable to complete transaction without selecting terms and conditions.");
					Utils.logPassImage(TCName);
					return true;
				} catch (AssertionError | Exception e) {
					Log.fail("Proceeded Further without clicking on Terms and Condtions");
					Utils.logFailImage(TCName + "  " + scenarioCount);
					runResult = false;
					throw e;
				}

			}

			// Send email if proceed=1 in DB
			if (Integer.parseInt(Proceed) == 1) {
				Utils.click(By.xpath(getObj("Propval1", "proceed", "JOL_Mutual_NEW_IPO")), "Proceed");
			}
			// Hit cancel email if Proceed=2 in DB.
			else {
				Utils.click(By.xpath(getObj("Propval1", "cancel", "JOL_Mutual_NEW_IPO")), "Cancel Email Button");
				Utils.logPassImage(TCName);
				return true;
			}

			if (Integer.parseInt(Confirm) == 1) {
				Utils.click(By.xpath(getObj("Propval1", "confirm", "JOL_Mutual_NEW_IPO")), "confirm");
			}

			else if (Integer.parseInt(Confirm) == 2) {

				Utils.click(By.xpath(getObj("Propval1", "modify", "JOL_Mutual_NEW_IPO")), "modify");

				Utils.click(By.xpath(getObj("Propval1", "CheckBoxTC", "JOL_Mutual_NEW_IPO")), "on Terms and Conditons Button directly");

				Utils.click(By.xpath(getObj("Propval1", "proceed", "JOL_Mutual_NEW_IPO")), "Proceed");

				Utils.click(By.xpath(getObj("Propval1", "confirm", "JOL_Mutual_NEW_IPO")), "confirm");

			}

			else {
				Utils.click(By.xpath(getObj("Propval1", "cancel", "JOL_Mutual_NEW_IPO")), "cancel");

				Utils.click(By.xpath(getObj("Propval1", "Cancel_yes_btn", "JOL_Mutual_NEW_IPO")), "cancel");
				Utils.waitForInVisibilityOfEle(By.xpath("//*[@id='overlayInfo']"));
				Log.pass("Confirm is cancel successfully");
				Utils.logPassImage(TCName);
				return true;

			}
			String message = Utils.getText(By.xpath(getObj("Propval1", "Message", "JOL_Mutual_NEW_IPO")));
			Log.pass("Status message is :" + message);

			if (AfterTxfrAdditionalOptions.equalsIgnoreCase("true")) {
				addFavSendEmailDownloadPdfNprintFuncIPO(TCName);
			}

			if (Integer.parseInt(NewTxn) == 1) {
				Utils.scrollDownVertically();
				Utils.click(By.xpath(getObj("Propval1", "NewTransactionBtn", "JOL_Mutual_NEW_IPO")), "New Transaction");

				int y = Utils.getSizeNoException(By.xpath(getObj("Propval1", "proceed", "JOL_Mutual_NEW_IPO")));
				if (y > 0) {
					Log.pass("New Transaction is landed successfully");
					Utils.logPassImage(TCName + " " + scenarioCount);
				} else {
					Log.fail("Unable to open  'New Transaction ' page");
					Utils.logFailImage(TCName + " " + scenarioCount);
				}

			} else {
				Utils.click(By.xpath(getObj("Propval1", "Home", "JOL_Mutual_NEW_IPO")), "Home Button.");
				int y = Utils.getSizeNoException(By.xpath(getObj("Propval1", "HomepageSuccess", "JOL_Mutual_NEW_IPO")));
				if (y > 0) {
					Log.pass("Home page is landed successfully");
					Utils.logPassImage(TCName + " " + scenarioCount);
				} else {
					Log.fail("Home page is not landed successfully");
					Utils.logFailImage(TCName + " " + scenarioCount);

				}

				Utils.logPassImage(TCName);
			}

		} catch (Exception e) {
			b = false;
			gException = e;
			throw e;
		}
		return b;
	}

	public static boolean addFavSendEmailDownloadPdfNprintFuncIPO(String Nickname) throws Exception {

		try {
			// Start sending email , downloading pdf and printing etc.
			Utils.wait(3);
			Log.info("Starting send email functionality");

			Utils.click(By.xpath(getObj("Propval1", "sendEmailIcon", "JOL_Mutual_NEW_IPO")), "Send Email Icon");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailTo", "JOL_Mutual_NEW_IPO")), Input.ReadTestData(AppData.accountSet, "toEmail"), "to email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailCC", "JOL_Mutual_NEW_IPO")), Input.ReadTestData(AppData.accountSet, "ccEmail"), "to CC email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "bccEmail", "JOL_Mutual_NEW_IPO")), Input.ReadTestData(AppData.accountSet, "bccEmail"), "to BCC  email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "emailSubject", "JOL_Mutual_NEW_IPO")), Input.ReadTestData(AppData.accountSet, "emailSubject"), "email Subject ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEMailMsgBox", "JOL_Mutual_NEW_IPO")), Input.ReadTestData(AppData.accountSet, "sendEMailMsgBox"), "Mail Body ");

			Utils.click(By.xpath(getObj("Propval1", "cancelemailBtnEle", "JOL_Mutual_NEW_IPO")), "Cancel Email Button");
			Utils.wait(5);
			Utils.click(By.xpath(getObj("Propval1", "sendEmailIcon", "JOL_Mutual_NEW_IPO")), "Send Email Icon");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailTo", "JOL_Mutual_NEW_IPO")), Input.ReadTestData(AppData.accountSet, "toEmail"), "to email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailCC", "JOL_Mutual_NEW_IPO")), Input.ReadTestData(AppData.accountSet, "ccEmail"), "to CC email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "bccEmail", "JOL_Mutual_NEW_IPO")), Input.ReadTestData(AppData.accountSet, "bccEmail"), "to BCC  email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "emailSubject", "JOL_Mutual_NEW_IPO")), Input.ReadTestData(AppData.accountSet, "emailSubject"), "email Subject ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEMailMsgBox", "JOL_Mutual_NEW_IPO")), Input.ReadTestData(AppData.accountSet, "sendEMailMsgBox"), "Mail Body ");
			Utils.wait(5);
			Utils.click(By.xpath(getObj("Propval1", "sendBtnEle", "JOL_Mutual_NEW_IPO")), "Send Email Button");
			Utils.waitForInVisibilityOfEle(By.xpath("//*[@id='overlayInfo']"));
			Utils.pressEnter();
			Utils.wait(2);
			Utils.pressEscapeKey(3);

			Utils.pressEscapeKey(3);
			driver.navigate().refresh();
			// Download report in pdf format.
			Utils.click(By.xpath(getObj("Propval1", "pdfDownloadIcon", "JOL_Mutual_NEW_IPO")), "pdf download");
			Utils.wait(3);
			Utils.enterOTPAndProceed();
			Utils.moveToElement(By.id("logo"));
			
			Utils.wait(3);
			// Utils.enterOTPAndProceed();
			Utils.moveToElement(By.id("logo"));
			// Print report.
			Utils.wait(6);
			driver.navigate().refresh();
			Utils.click(By.xpath(getObj("Propval1", "printBtnIcon", "JOL_Mutual_NEW_IPO")), "Print Button");
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
