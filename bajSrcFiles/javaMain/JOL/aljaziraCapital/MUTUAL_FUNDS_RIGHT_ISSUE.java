package javaMain.JOL.aljaziraCapital;

import static Utilities.ReadData.ReadDataSQL;
import static Utilities.ReadData.getObj;
import static javaMain.common_Functions.AppData.AfterTxfrAdditionalOptions;
import static javaMain.common_Functions.AppData.CheckBox;
import static javaMain.common_Functions.AppData.Company;
import static javaMain.common_Functions.AppData.Confirm;
import static javaMain.common_Functions.AppData.NewTxn;
import static javaMain.common_Functions.AppData.Proceed;
import static javaMain.common_Functions.AppData.TCButton;

import org.openqa.selenium.By;
import org.testng.Assert;

import Utilities.Input;
import Utilities.Log;
import Utilities.ReadData;
import Utilities.TestBase;
import Utilities.Utils;

public class MUTUAL_FUNDS_RIGHT_ISSUE extends TestBase {

	public static boolean RightIssue(String TCName, int ScenarioCount, Object[] tCsDataset) throws Exception {

		boolean b = true;
		try {

			if (isMasterClassRun) {
				Log.pass("Data set for this scenario is " + System.lineSeparator() + ReadData.getJsonData(TCName, ScenarioCount, "DataSet"));
				
				Proceed = ReadDataSQL(TCName, ScenarioCount, "Proceed");
				Company = ReadDataSQL(TCName, ScenarioCount, "Company");
				Confirm = ReadDataSQL(TCName, ScenarioCount, "Confirm");
				AfterTxfrAdditionalOptions = ReadDataSQL(TCName, ScenarioCount, "AfterTxfrAdditionalOptions");
				NewTxn = ReadDataSQL(TCName, ScenarioCount, "NewTxn");
				TCButton = ReadDataSQL(TCName, ScenarioCount, "TCButton");
				CheckBox = ReadDataSQL(TCName, ScenarioCount, "CheckBox");
			}

			else {
				Log.pass("Data set for this scenario is " + System.lineSeparator() + dataset[scenarioCount - 1]);
				
				Proceed = (String) Utils.getUiData(dataset[scenarioCount - 1]).get("Proceed");
				Company = (String) Utils.getUiData(dataset[scenarioCount - 1]).get("Company");
				Confirm = (String) Utils.getUiData(dataset[scenarioCount - 1]).get("Confirm");
				AfterTxfrAdditionalOptions = (String) Utils.getUiData(dataset[scenarioCount - 1])
						.get("AfterTxfrAdditionalOptions");
				NewTxn = (String) Utils.getUiData(dataset[scenarioCount - 1]).get("NewTxn");
				TCButton = (String) Utils.getUiData(dataset[scenarioCount - 1]).get("TCButton");
				CheckBox = (String) Utils.getUiData(dataset[scenarioCount - 1]).get("CheckBox");
			}

			// Search Type- Market Info.- Starts

			Utils.click(By.xpath(getObj("Propval1", "AlJaziraCapital", "MUTUAL_FUNDS_RIGHT_ISSUE")), "AlJazira Capital");

			Utils.click(By.xpath(getObj("Propval1", "iposervices", "MUTUAL_FUNDS_RIGHT_ISSUE")), "IPO Services ");

			Utils.click(By.xpath(getObj("Propval1", "RightIssue", "MUTUAL_FUNDS_RIGHT_ISSUE")), "RightIssue");

			Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "Companydropdown", "MUTUAL_FUNDS_RIGHT_ISSUE")),
					By.xpath(getObj("Propval1", "Company", "MUTUAL_FUNDS_RIGHT_ISSUE")), Company);

			Utils.wait(5);
		

			if (TCButton.equalsIgnoreCase("True")) {
                if (CheckBox.equalsIgnoreCase("True")) {
                      // Click on the terms and Conditions CheckBox Directly//
                      Utils.click(By.xpath(getObj("Propval1", "CheckBoxTC", "MUTUAL_FUNDS_RIGHT_ISSUE")),
                                  "on Terms and Conditons Button directly");
                } else if (CheckBox.equalsIgnoreCase("False")) {
                      // Click on the link of Terms and Conditions//
                      Utils.click(By.xpath(getObj("Propval1", "TnCpoup", "MUTUAL_FUNDS_RIGHT_ISSUE")),
                                  "which is a link of Terms and Conditions");
                      // Click on I Accept Radio of the pop up//
                      Utils.click(By.xpath(getObj("Propval1", "TnCAgree", "MUTUAL_FUNDS_RIGHT_ISSUE")),
                                  "which is I Accept RadioButton");

                }

          } else if (TCButton.equalsIgnoreCase("False")) {
                // Click on Proceed Button//
                Utils.click(By.xpath(getObj("Propval1", "Proceed", "MUTUAL_FUNDS_RIGHT_ISSUE")), "Proceed Button");
                try {
                	//System.out.println(Utils.assertDisplayed(By.xpath(getObj("Propval1", "CreditcardTxt", "ApplyCreditCard")),"false"));
                      // This is to validate if the user moves to the next page without selecting Terms and Condition CheckBox//
                      Assert.assertEquals(Utils.assertDisplayed(By.xpath(getObj("Propval1", "Confirm", "MUTUAL_FUNDS_RIGHT_ISSUE")), "Confirm"),false);
                      Log.pass("Successfully validated that user is unable to complete transaction without selecting terms and conditions.");
                      Utils.logPassImage(TCName);
                      return true;
                } catch (AssertionError | Exception e) {
                      Log.fail("Proceeded Further without clicking on Terms and Condtions");
                      runResult = false;
                      throw e;
                }

          }

			// Send email if proceed=1 in DB
			if (Integer.parseInt(Proceed) == 1) {
				Utils.click(By.xpath(getObj("Propval1", "proceed", "MUTUAL_FUNDS_RIGHT_ISSUE")), "Proceed");
			}
			// Hit cancel email if Proceed=2 in DB.
			else {
				Utils.click(By.xpath(getObj("Propval1", "cancel", "MUTUAL_FUNDS_RIGHT_ISSUE")), "Cancel Button");
				Utils.logPassImage(TCName);
				return true;
			}

			
			if (Integer.parseInt(Confirm) == 1) {
				Utils.click(By.xpath(getObj("Propval1", "confirm", "MUTUAL_FUNDS_RIGHT_ISSUE")), "confirm");
			}

			else if (Integer.parseInt(Confirm) == 2) {

				Utils.click(By.xpath(getObj("Propval1", "modify", "MUTUAL_FUNDS_RIGHT_ISSUE")), "modify");

				Utils.click(By.xpath(getObj("Propval1", "CheckBoxTC", "MUTUAL_FUNDS_RIGHT_ISSUE")),
						"on Terms and Conditons Button directly");

				Utils.click(By.xpath(getObj("Propval1", "proceed", "MUTUAL_FUNDS_RIGHT_ISSUE")), "Proceed");

				Utils.click(By.xpath(getObj("Propval1", "confirm", "MUTUAL_FUNDS_RIGHT_ISSUE")), "confirm");

			}

			else {
				Utils.click(By.xpath(getObj("Propval1", "cancel", "MUTUAL_FUNDS_RIGHT_ISSUE")), "cancel");

				Utils.click(By.xpath(getObj("Propval1", "OTPCancelConfirm", "MUTUAL_FUNDS_RIGHT_ISSUE")), "cancel");
				Log.pass("Confirm is cancel successfully");
				Utils.logPassImage(TCName);
				return true;

			}
			String message = Utils.getText(By.xpath(getObj("Propval1", "Message", "MUTUAL_FUNDS_RIGHT_ISSUE")));
			Log.pass("Status message is :" + message);

			if (AfterTxfrAdditionalOptions.equalsIgnoreCase("true")) {
				addFavSendEmailDownloadPdfNprintFuncBeneficiary(TCName);
			}

			if (Integer.parseInt(NewTxn) == 1) {
				Utils.scrollDownVertically();
				Utils.click(By.xpath(getObj("Propval1", "NewTransactionBtn", "MUTUAL_FUNDS_RIGHT_ISSUE")), "New Transaction");
				int y = Utils.getSize(By.xpath(getObj("Propval1", "proceed", "MUTUAL_FUNDS_RIGHT_ISSUE")));
				if (y > 0) {
					Log.pass("New Transaction is landed successfully");
				} else {
					Log.fail("New Transaction is not landed successfully");

				}

			} else {
				Utils.click(By.xpath(getObj("Propval1", "Home", "MUTUAL_FUNDS_RIGHT_ISSUE")), "Home Button.");
				int y = Utils.getSize(By.xpath(getObj("Propval1", "HomepageSuccess", "MUTUAL_FUNDS_RIGHT_ISSUE")));
				if (y > 0) {
					Log.pass("Home page is landed successfully");
				} else {
					Log.fail("Home page is not landed successfully");

				}

				Utils.logPassImage(TCName);
			}

		}catch (AssertionError | Exception e)  {
			runResult = false;
			throw e;
		}
		return b;
	}

	public static boolean addFavSendEmailDownloadPdfNprintFuncBeneficiary(String Nickname) throws Exception {

		try {
			// Start sending email , downloading pdf and printing etc.
			Utils.wait(3);
			Log.info("Starting send email functionality");

			Utils.click(By.xpath(getObj("Propval1", "sendEmailIcon", "MUTUAL_FUNDS_RIGHT_ISSUE")), "Send Email Icon");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailTo", "MUTUAL_FUNDS_RIGHT_ISSUE")),
					Input.ReadTestData("MarketInfo", "toEmail"), "to email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailCC", "MUTUAL_FUNDS_RIGHT_ISSUE")),
					Input.ReadTestData("MarketInfo", "ccEmail"), "to CC email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "bccEmail", "MUTUAL_FUNDS_RIGHT_ISSUE")),
					Input.ReadTestData("MarketInfo", "bccEmail"), "to BCC  email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "emailSubject", "MUTUAL_FUNDS_RIGHT_ISSUE")),
					Input.ReadTestData("MarketInfo", "emailSubject"), "email Subject ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEMailMsgBox", "MUTUAL_FUNDS_RIGHT_ISSUE")),
					Input.ReadTestData("MarketInfo", "sendEMailMsgBox"), "Mail Body ");

			Utils.click(By.xpath(getObj("Propval1", "cancelemailBtnEle", "MUTUAL_FUNDS_RIGHT_ISSUE")), "Cancel Email Button");
			Utils.wait(5);
			Utils.click(By.xpath(getObj("Propval1", "sendEmailIcon", "MUTUAL_FUNDS_RIGHT_ISSUE")), "Send Email Icon");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailTo", "MUTUAL_FUNDS_RIGHT_ISSUE")),
					Input.ReadTestData("MarketInfo", "toEmail"), "to email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailCC", "MUTUAL_FUNDS_RIGHT_ISSUE")),
					Input.ReadTestData("MarketInfo", "ccEmail"), "to CC email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "bccEmail", "MUTUAL_FUNDS_RIGHT_ISSUE")),
					Input.ReadTestData("MarketInfo", "bccEmail"), "to BCC  email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "emailSubject", "MUTUAL_FUNDS_RIGHT_ISSUE")),
					Input.ReadTestData("MarketInfo", "emailSubject"), "email Subject ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEMailMsgBox", "MUTUAL_FUNDS_RIGHT_ISSUE")),
					Input.ReadTestData("MarketInfo", "sendEMailMsgBox"), "Mail Body ");
			Utils.wait(5);
			Utils.click(By.xpath(getObj("Propval1", "sendBtnEle", "MUTUAL_FUNDS_RIGHT_ISSUE")), "Send Email Button");
			Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "WaitingElements", "MUTUAL_FUNDS_RIGHT_ISSUE")));
			Utils.pressEnter();
			Utils.wait(2);
			Utils.pressEscapeKey(3);

			Utils.pressEscapeKey(3);
			driver.navigate().refresh();
			// Download report in pdf format.
			Utils.click(By.xpath(getObj("Propval1", "pdfDownloadIcon", "MUTUAL_FUNDS_RIGHT_ISSUE")), "pdf download");
			Utils.wait(3);
			Utils.enterOTPAndProceed();
			Utils.moveToElement(By.id("logo"));
			/*
			 * driver.navigate().refresh(); // Download report in excel format.
			 * Utils.click(By.xpath(getObj("Propval1", "excelDownloadIcon",
			 * "MUTUAL_FUNDS_RIGHT_ISSUE")), "Excel Download");
			 */
			Utils.wait(3);
			// Utils.enterOTPAndProceed();
			Utils.moveToElement(By.id("logo"));
			// Print report.
			Utils.wait(6);
			driver.navigate().refresh();
			Utils.click(By.xpath(getObj("Propval1", "printBtnIcon", "MUTUAL_FUNDS_RIGHT_ISSUE")), "Print Button");
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
