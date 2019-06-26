package javaMain.eCorp.selfservice;

import static Utilities.ReadData.ReadDataSQL;
import static Utilities.ReadData.getObj;
import static javaMain.common_Functions.AppData.AfterTxfrAdditionalOptions;
import static javaMain.common_Functions.AppData.ComputerNumber;
import static javaMain.common_Functions.AppData.Confirm;
import static javaMain.common_Functions.AppData.NewTxn;
import static javaMain.common_Functions.AppData.Proceed;
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
public class eCorp_SELFSERVICE_ADD_COMPANY_CR_DETAILS_FUNC extends TestBase {

	public static Boolean ADD_COMPANY_CR_DETAILS(String TCName, int ScenarioCount, Object[] tCsDataset) throws Exception {

		try {

			if (isMasterClassRun) {

				Log.pass("Data set for this scenario is " + System.lineSeparator() + ReadData.getJsonData(TCName, ScenarioCount, "DataSet"));

				ComputerNumber = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "ComputerNumber"));
				AfterTxfrAdditionalOptions = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "AfterTxfrAdditionalOptions"));

				isNegative = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "isNegative"));
				Proceed = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Proceed"));
				Confirm = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Confirm"));
				NewTxn = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "NewTxn"));
			} else {

				Log.pass("Data set for this scenario is " + System.lineSeparator() + dataset[scenarioCount - 1]);
				AfterTxfrAdditionalOptions = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("AfterTxfrAdditionalOptions"));
				ComputerNumber = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("ComputerNumber"));

				isNegative = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("isNegative"));
				Proceed = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Proceed"));
				Confirm = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Confirm"));
				NewTxn = (String) Utils.getUiData(dataset[scenarioCount - 1]).get("NewTxn");
			}

			Utils.click(By.xpath(getObj("Propval1", "SelfServiceLnk", "eCorp_AddCompanyCRDetails")), "Self Services");

			Utils.click(By.xpath(getObj("Propval1", "AddCompanyCRDetails", "eCorp_AddCompanyCRDetails")), "NAQAA Deposit Rates");

			// Verify landing page
			String Balance = Utils.getText(By.xpath(getObj("Propval1", "LandPage", "eCorp_AddCompanyCRDetails")));

			Log.pass("Landed Page is  :" + Balance);

			// Enter Company name
			Utils.Sendkeys_DD_substringbased(By.xpath(getObj("Propval1", "ComputerNumber", "eCorp_AddCompanyCRDetails")), ComputerNumber, "Company");

			if (Integer.parseInt(Proceed) == 1) {

				Utils.click(By.xpath(getObj("Propval1", "Proceed", "eCorp_AddCompanyCRDetails")), "Proceed");

			} else {

				Utils.click(By.xpath(getObj("Propval1", "Cancel", "eCorp_AddCompanyCRDetails")), "Proceed Cancel");

				Utils.logPassImage(TCName);
				return runResult;

			}

			if (isNegative.equalsIgnoreCase("true")) {
				try {

					Assert.assertFalse(Utils.assertDisplayed(By.xpath(getObj("Propval1", "Confirm", "eCorp_AddCompanyCRDetails")), "Result Details."));
					Log.pass("User is not able to proceed without enter the currect Computer Number");
					Utils.logPassImage(TCName);
					return true;

				} catch (AssertionError | Exception e) {

					Log.fail("User is able to proceed with enter invalid computer name hecne test case fail. ");
					Utils.logFailImage(TCName);

				}

			}
			if (Integer.parseInt(Confirm) == 1) {

				Utils.click(By.xpath(getObj("Propval1", "Confirm", "eCorp_AddCompanyCRDetails")), "Confirm");

			} else if (Integer.parseInt(Confirm) == 2) {

				Utils.click(By.xpath(getObj("Propval1", "modify", "eCorp_AddCompanyCRDetails")), "Modify");

				// Enter Company name
				Utils.Sendkeys_DD_substringbased(By.xpath(getObj("Propval1", "LandPage", "eCorp_AddCompanyCRDetails")), "12365478965", "Company");

				Utils.click(By.xpath(getObj("Propval1", "Proceed", "eCorp_AddCompanyCRDetails")), "Modify Proceed");

				Utils.click(By.xpath(getObj("Propval1", "Confirm", "eCorp_AddCompanyCRDetails")), "Modify Confirm");

			} else {
				Utils.click(By.xpath(getObj("Propval1", "Cancel", "eCorp_AddCompanyCRDetails")), "Confirm Cancel");
				Utils.wait(6);
				Utils.click(By.xpath(getObj("Propval1", "CancelYes", "eCorp_AddCompanyCRDetails")), "Confirm Cancel yes");
				Log.pass("Click on Confirm Return ......");
				Utils.logPassImage(TCName);
				return runResult;
			}

			try {
				Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "SuccessMessage", "eCorp_AddCompanyCRDetails")), "Success Message"));
				Log.pass("AddCompany CR Details successfully." + Utils.getText(By.xpath(getObj("Propval1", "SuccessMessage", "eCorp_AddCompanyCRDetails"))));
				Utils.logPassImage("AddCompany CR Details-Pass");

			} catch (AssertionError | Exception e) {

				Log.fail("AddCompany CR Details failed...Message:" + Utils.getText(By.xpath(getObj("Propval1", "failMessage", "eCorp_AddCompanyCRDetails"))));
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

			if (Integer.parseInt(NewTxn) == 1) {
				Utils.scrollDownVertically();
				Utils.click(By.xpath(getObj("Propval1", "NewTransactionBtn", "eCorp_AddCompanyCRDetails")), "New Transaction");
				int y = Utils.getSize(By.xpath(getObj("Propval1", "proceed", "eCorp_AddCompanyCRDetails")));
				if (y > 0) {
					Log.pass("New Transaction is landed successfully");
				} else {
					Log.fail("New Transaction is not landed successfully");

				}

			} else {
				Utils.click(By.xpath(getObj("Propval1", "Home", "eCorp_AddCompanyCRDetails")), "Home Button.");
				int y = Utils.getSize(By.xpath(getObj("Propval1", "HomepageSuccess", "eCorp_AddCompanyCRDetails")));
				if (y > 0) {
					Log.pass("Home page is landed successfully");
				} else {
					Log.fail("Home page is not landed successfully");

				}

				Utils.logPassImage(TCName);

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

			Utils.click(By.xpath(getObj("Propval1", "sendEmailIcon", "eCorp_AddCompanyCRDetails")), "Send Email Icon");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailTo", "eCorp_AddCompanyCRDetails")), Input.ReadTestData("MarketInfo", "toEmail"), "to email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailCC", "eCorp_AddCompanyCRDetails")), Input.ReadTestData("MarketInfo", "ccEmail"), "to CC email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "bccEmail", "eCorp_AddCompanyCRDetails")), Input.ReadTestData("MarketInfo", "bccEmail"), "to BCC  email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "emailSubject", "eCorp_AddCompanyCRDetails")), Input.ReadTestData("MarketInfo", "emailSubject"), "email Subject ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEMailMsgBox", "eCorp_AddCompanyCRDetails")), Input.ReadTestData("MarketInfo", "sendEMailMsgBox"), "Mail Body ");

			Utils.click(By.xpath(getObj("Propval1", "cancelemailBtnEle", "eCorp_AddCompanyCRDetails")), "Cancel Email Button");
			Utils.wait(5);
			Utils.click(By.xpath(getObj("Propval1", "sendEmailIcon", "eCorp_AddCompanyCRDetails")), "Send Email Icon");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailTo", "eCorp_AddCompanyCRDetails")), Input.ReadTestData("MarketInfo", "toEmail"), "to email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailCC", "eCorp_AddCompanyCRDetails")), Input.ReadTestData("MarketInfo", "ccEmail"), "to CC email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "bccEmail", "eCorp_AddCompanyCRDetails")), Input.ReadTestData("MarketInfo", "bccEmail"), "to BCC  email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "emailSubject", "eCorp_AddCompanyCRDetails")), Input.ReadTestData("MarketInfo", "emailSubject"), "email Subject ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEMailMsgBox", "eCorp_AddCompanyCRDetails")), Input.ReadTestData("MarketInfo", "sendEMailMsgBox"), "Mail Body ");
			Utils.wait(5);
			Utils.click(By.xpath(getObj("Propval1", "sendBtnEle", "eCorp_AddCompanyCRDetails")), "Send Email Button");
			Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "WaitingElements", "eCorp_AddCompanyCRDetails")));
			Utils.pressEnter();
			Utils.wait(2);
			Utils.pressEscapeKey(3);

			Utils.pressEscapeKey(3);
			driver.navigate().refresh();
			// Download report in pdf format.
			Utils.click(By.xpath(getObj("Propval1", "pdfDownloadIcon", "eCorp_AddCompanyCRDetails")), "pdf download");
			Utils.wait(3);
			Utils.enterOTPAndProceed();
			Utils.moveToElement(By.id("logo"));
			driver.navigate().refresh();
			// Download report in excel format.
			// Utils.click(By.xpath(getObj("Propval1", "excelDownloadIcon",
			// "eCorp_AddCompanyCRDetails")), "Excel Download");
			Utils.wait(3);
			// Utils.enterOTPAndProceed();
			Utils.moveToElement(By.id("logo"));
			// Print report.
			Utils.wait(6);
			driver.navigate().refresh();
			Utils.click(By.xpath(getObj("Propval1", "printBtnIcon", "eCorp_AddCompanyCRDetails")), "Print Button");
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
