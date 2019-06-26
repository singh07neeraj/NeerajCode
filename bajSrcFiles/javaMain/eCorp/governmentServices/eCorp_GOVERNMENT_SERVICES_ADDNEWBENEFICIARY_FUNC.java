package javaMain.eCorp.governmentServices;

import static Utilities.Input.ReadTestData;
import static Utilities.ReadData.ReadDataSQL;
import static Utilities.ReadData.getObj;
import static javaMain.common_Functions.AppData.AfterTxfrAdditionalOptions;
import static javaMain.common_Functions.AppData.Confirm;
import static javaMain.common_Functions.AppData.IDType;
import static javaMain.common_Functions.AppData.NewTxn;
import static javaMain.common_Functions.AppData.Nickname;
import static javaMain.common_Functions.AppData.OTPProceed;
import static javaMain.common_Functions.AppData.Proceed;
import static javaMain.common_Functions.AppData.isNegative;
import static javaMain.common_Functions.AppData.other;
import static javaMain.common_Functions.AppData.otherActions;

import org.openqa.selenium.By;
import org.testng.Assert;

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
public class eCorp_GOVERNMENT_SERVICES_ADDNEWBENEFICIARY_FUNC extends TestBase {

	public static Boolean AddNewBeneficiary(String TCName, int ScenarioCount, Object[] tCsDataset) {
		try {

			if (isMasterClassRun) {

				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + ReadData.getJsonData(TCName, ScenarioCount, "DataSet") + "</mark>");

				AfterTxfrAdditionalOptions = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "AfterTxfrAdditionalOptions"));
				Proceed = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Proceed"));
				Confirm = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Confirm"));
				OTPProceed = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "OTPProceed"));
				Nickname = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Nickname"));
				other = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "other"));
				IDType = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "IDType"));
				isNegative = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "isNegative"));
				NewTxn = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "NewTxn"));
				otherActions = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "otherActions"));
			} else {

				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + dataset[scenarioCount - 1] + "</mark>");
				AfterTxfrAdditionalOptions = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("AfterTxfrAdditionalOptions"));
				Proceed = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Procced"));
				Confirm = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Confirm"));
				OTPProceed = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("OTPProceed"));
				Nickname = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Nickname"));
				other = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("other"));
				IDType = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("IDType"));
				isNegative = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("isNegative"));
				NewTxn = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("NewTxn"));
				otherActions = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("otherActions"));

			}

			Utils.refreshScreeen();
			Utils.click(By.xpath(getObj("Propval1", "govtservice", "eCorp_governmentService_AddNewBeneficiary")), "Goverment Service Menu");

			Utils.click(By.xpath(getObj("Propval1", "AddNewBeneficiary", "eCorp_governmentService_AddNewBeneficiary")), "Goverment Serivce reFund");

			String LandPage = Utils.getText(By.xpath(getObj("Propval1", "LandPage", "eCorp_governmentService_AddNewBeneficiary")));

			Log.pass("Page title is " + LandPage);

			Utils.sendKeys(By.xpath(getObj("Propval1", "NickName", "eCorp_governmentService_AddNewBeneficiary")), ReadTestData(TCName, "Nickname"), "enter nick name");

			Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "IDtypeDropdownDropdown", "eCorp_governmentService_AddNewBeneficiary")), By.xpath(getObj("Propval1", "IDType", "eCorp_governmentService_AddNewBeneficiary")),
					ReadTestData(TCName, "IDType"), "ID Type");

			Log.pass("ID Type " + ReadTestData("GovtAddNewBeneficiary", "IDNumber"));

			if (isNegative.equalsIgnoreCase("true")) {
				Utils.sendKeys(By.xpath(getObj("Propval1", "IDNumber", "eCorp_governmentService_AddNewBeneficiary")), ReadTestData(TCName, "Negativeother"), "Enter ID Number");
			} else {
				Utils.sendKeys(By.xpath(getObj("Propval1", "IDNumber", "eCorp_governmentService_AddNewBeneficiary")), ReadTestData(TCName, "other"), "Enter ID Number");
			}
			if (otherActions.equalsIgnoreCase("Add another transaction")) {
				Utils.click(By.xpath(getObj("Propval1", "Addanothertransaction", "eCorp_governmentService_AddNewBeneficiary")), "Add another transaction");
				Utils.logPassImage("Add another transaction");
				Utils.click(By.xpath(getObj("Propval1", "AddanothertransactionDelete", "eCorp_governmentService_AddNewBeneficiary")), "Add another transaction Delete");
				Log.pass("Successfully able to click on Add another transaction and also able to Delete");
				Utils.logPassImage("Delete another transaction");
				return true;

			}
			// int Proceed = 1;// Integer.parseInt(Input.ReadTestData(TCName, ScenarioCount,
			// "Proceed"));

			if (Integer.parseInt(Proceed) == 1) {

				Utils.click(By.xpath(getObj("Propval1", "Proceed", "eCorp_governmentService_AddNewBeneficiary")), "Proceed");

			} else {

				Utils.click(By.xpath(getObj("Propval1", "Cancel", "eCorp_governmentService_AddNewBeneficiary")), "Cancel Proceed");

				Utils.logPassImage(TCName);
				return runResult;

			}

			if (isNegative.equalsIgnoreCase("true")) {
				try {
					Assert.assertFalse(Utils.assertDisplayed(By.xpath(getObj("Propval1", "Confirm", "eCorp_governmentService_AddNewBeneficiary")), "Confirm Page"));
					Log.pass("Not able to negivate to confirm page without entering all the mandatory values");
					Utils.logPassImage(TCName);
					return true;
				}

				catch (AssertionError | Exception e) {
					Log.fail("able to proceed without enter mandatory fields hence test case fail Please review the fields and make isNegative false ");
					throw e;
				}

			}

			if (Integer.parseInt(Confirm) == 1) {

				Utils.click(By.xpath(getObj("Propval1", "Confirm", "eCorp_governmentService_AddNewBeneficiary")), "Confirm");

			} else if (Integer.parseInt(Confirm) == 2) {

				Utils.click(By.xpath(getObj("Propval1", "modify", "eCorp_governmentService_AddNewBeneficiary")), "Modify ");

				Utils.click(By.xpath(getObj("Propval1", "Proceed", "eCorp_governmentService_AddNewBeneficiary")), "Confirm Proceed");

				Utils.click(By.xpath(getObj("Propval1", "Confirm", "eCorp_governmentService_AddNewBeneficiary")), "Modify Confirm");

			} else {
				Utils.click(By.xpath(getObj("Propval1", "Cancel", "eCorp_governmentService_AddNewBeneficiary")), "Confirm Cancel");

				Utils.click(By.xpath(getObj("Propval1", "CancelYes", "eCorp_governmentService_AddNewBeneficiary")), "Click on Yes");

				Utils.logPassImage(TCName);
				return runResult;
			}

			try {
				Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "SuccessMessage", "eCorp_governmentService_AddNewBeneficiary")), "Success Message"));
				Log.pass("AddNew Beneficiary completed successfully.");
				Log.pass("Success Message is :" + Utils.getText(By.xpath(getObj("Propval1", "SuccessMessage", "eCorp_governmentService_AddNewBeneficiary"))));
				Utils.logPassImage("AddNew Beneficiary-Pass");

			} catch (AssertionError | Exception e) {

				Log.fail("AddNew Beneficiary failed...Message:" + Utils.getText(By.xpath(getObj("Propval1", "failMessage", "eCorp_governmentService_AddNewBeneficiary"))));
				Utils.logFailImage("AddNew Beneficiary-Fail");
				throw e;
			}

			if (AfterTxfrAdditionalOptions.equalsIgnoreCase("true")) {
				addFavSendEmailDownloadPdfNprintFuncBeneficiary(TCName);
			}

			if (NewTxn.equalsIgnoreCase("1")) {
				Utils.scrollDownVertically();
				Utils.click(By.xpath(getObj("Propval1", "NewTransactionBtn", "eCorp_governmentService_AddNewBeneficiary")), "New Transaction");
				int y = Utils.getSize(By.xpath(getObj("Propval1", "proceed", "eCorp_governmentService_AddNewBeneficiary")));
				if (y > 0) {
					Log.pass("New Transaction is landed successfully");
				} else {
					Log.fail("New Transaction is not landed successfully");

				}

			} else {
				Utils.click(By.xpath(getObj("Propval1", "Home", "eCorp_governmentService_AddNewBeneficiary")), "Home Button.");
				int y = Utils.getSize(By.xpath(getObj("Propval1", "HomepageSuccess", "eCorp_governmentService_AddNewBeneficiary")));
				if (y > 0) {
					Log.pass("Home page is landed successfully");
				} else {
					Log.fail("Home page is not landed successfully");

				}

				Utils.logPassImage(TCName);
			}

		} catch (

		Exception e) {

			runResult = false;
			e.printStackTrace();
		}
		return runResult;
	}

	public static boolean addFavSendEmailDownloadPdfNprintFuncBeneficiary(String Nickname) throws Exception {

		try {
			// Start sending email , downloading pdf and printing etc.
			Utils.wait(3);
			Log.info("Starting send email functionality");

			Utils.click(By.xpath(getObj("Propval1", "sendEmailIcon", "eCorp_governmentService_AddNewBeneficiary")), "Send Email Icon");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailTo", "eCorp_governmentService_AddNewBeneficiary")), Input.ReadTestData("MarketInfo", "toEmail"), "to email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailCC", "eCorp_governmentService_AddNewBeneficiary")), Input.ReadTestData("MarketInfo", "ccEmail"), "to CC email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "bccEmail", "eCorp_governmentService_AddNewBeneficiary")), Input.ReadTestData("MarketInfo", "bccEmail"), "to BCC  email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "emailSubject", "eCorp_governmentService_AddNewBeneficiary")), Input.ReadTestData("MarketInfo", "emailSubject"), "email Subject ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEMailMsgBox", "eCorp_governmentService_AddNewBeneficiary")), Input.ReadTestData("MarketInfo", "sendEMailMsgBox"), "Mail Body ");

			Utils.click(By.xpath(getObj("Propval1", "cancelemailBtnEle", "eCorp_governmentService_AddNewBeneficiary")), "Cancel Email Button");
			Utils.wait(5);
			Utils.click(By.xpath(getObj("Propval1", "sendEmailIcon", "eCorp_governmentService_AddNewBeneficiary")), "Send Email Icon");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailTo", "eCorp_governmentService_AddNewBeneficiary")), Input.ReadTestData("MarketInfo", "toEmail"), "to email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEmailCC", "eCorp_governmentService_AddNewBeneficiary")), Input.ReadTestData("MarketInfo", "ccEmail"), "to CC email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "bccEmail", "eCorp_governmentService_AddNewBeneficiary")), Input.ReadTestData("MarketInfo", "bccEmail"), "to BCC  email ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "emailSubject", "eCorp_governmentService_AddNewBeneficiary")), Input.ReadTestData("MarketInfo", "emailSubject"), "email Subject ");
			Utils.sendKeys(By.xpath(getObj("Propval1", "sendEMailMsgBox", "eCorp_governmentService_AddNewBeneficiary")), Input.ReadTestData("MarketInfo", "sendEMailMsgBox"), "Mail Body ");
			Utils.wait(5);
			Utils.click(By.xpath(getObj("Propval1", "sendBtnEle", "eCorp_governmentService_AddNewBeneficiary")), "Send Email Button");
			Utils.waitForInVisibilityOfEle(By.xpath(getObj("Propval1", "WaitingElements", "eCorp_governmentService_AddNewBeneficiary")));
			Utils.pressEnter();
			Utils.wait(2);
			Utils.pressEscapeKey(3);

			Utils.pressEscapeKey(3);
			driver.navigate().refresh();
			// Download report in pdf format.
			Utils.click(By.xpath(getObj("Propval1", "pdfDownloadIcon", "eCorp_governmentService_AddNewBeneficiary")), "pdf download");
			Utils.wait(3);
			Utils.closeOtherTabs();
			Utils.moveToElement(By.id("logo"));
			driver.navigate().refresh();

			Utils.wait(3);
			// Utils.enterOTPAndProceed();
			Utils.moveToElement(By.id("logo"));
			// Print report.
			Utils.wait(6);
			driver.navigate().refresh();
			Utils.click(By.xpath(getObj("Propval1", "printBtnIcon", "eCorp_governmentService_AddNewBeneficiary")), "Print Button");
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
