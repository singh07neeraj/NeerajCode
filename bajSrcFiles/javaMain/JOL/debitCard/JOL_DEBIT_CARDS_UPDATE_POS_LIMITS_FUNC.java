package javaMain.JOL.debitCard;

import static Utilities.Input.ReadTestData;
import static Utilities.ReadData.ReadDataSQL;
import static Utilities.ReadData.getObj;
import static javaMain.common_Functions.AppData.AfterTxfrAdditionalOptions;
import static javaMain.common_Functions.AppData.C_ACCT;
import static javaMain.common_Functions.AppData.CheckBox;
import static javaMain.common_Functions.AppData.Confirm;
import static javaMain.common_Functions.AppData.DebitCard;
import static javaMain.common_Functions.AppData.Limit;
import static javaMain.common_Functions.AppData.NewTxn;
import static javaMain.common_Functions.AppData.OTPProceed;
import static javaMain.common_Functions.AppData.Proceed;
import static javaMain.common_Functions.AppData.TCButton;
import static javaMain.common_Functions.AppData.isNegative;

import org.openqa.selenium.By;
import org.testng.Assert;

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
public class JOL_DEBIT_CARDS_UPDATE_POS_LIMITS_FUNC extends TestBase {

	public static Boolean updatePOSLIMITS(String TCName, int ScenarioCount, Object[] tCsDataset) throws Exception {


		try {
			if (isMasterClassRun) {

				Log.info("Data set for this scenario is " + System.lineSeparator() + ReadData.getJsonData(TCName, ScenarioCount, "DataSet"));
				Proceed = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Proceed"));
				Confirm = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Confirm"));
				OTPProceed = ReadDataSQL(TCName, ScenarioCount, "OTPProceed");
				DebitCard = ReadDataSQL(TCName, ScenarioCount, "DebitCard");
				NewTxn = ReadDataSQL(TCName, ScenarioCount, "NewTxn");
				AfterTxfrAdditionalOptions = ReadDataSQL(TCName, ScenarioCount, "AfterTxfrAdditionalOptions");
				C_ACCT = ReadTestData(TCName, "C_ACCT"); // ReadDataSQL(TCName, ScenarioCount, "C_ACCT");
				TCButton = ReadDataSQL(TCName, ScenarioCount, "TCButton");
				CheckBox = ReadDataSQL(TCName, ScenarioCount, "CheckBox");
				Limit = ReadTestData(TCName, "Limit"); // ReadDataSQL(TCName, ScenarioCount, "Limit");
				isNegative = ReadDataSQL(TCName, ScenarioCount, "isNegative");

			} else {
				Log.info("Data set for this scenario is " + System.lineSeparator() + dataset[scenarioCount - 1]);
				Proceed = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Proceed"));
				Confirm = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Confirm"));
				OTPProceed = (String) Utils.getUiData(dataset[scenarioCount - 1]).get("OTPProceed");
				DebitCard = (String) Utils.getUiData(dataset[scenarioCount - 1]).get("DebitCard");
				NewTxn = (String) Utils.getUiData(dataset[scenarioCount - 1]).get("NewTxn");
				AfterTxfrAdditionalOptions = (String) Utils.getUiData(dataset[scenarioCount - 1]).get("AfterTxfrAdditionalOptions");
				C_ACCT = ReadTestData(TCName, "C_ACCT");// Utils.getUiData(dataset[scenarioCount - 1]).get("C_ACCT");
				TCButton = (String) Utils.getUiData(dataset[scenarioCount - 1]).get("TCButton");
				CheckBox = (String) Utils.getUiData(dataset[scenarioCount - 1]).get("CheckBox");
				Limit = ReadTestData(TCName, "Limit"); // Utils.getUiData(dataset[scenarioCount - 1]).get("Limit");
				isNegative = (String) Utils.getUiData(dataset[scenarioCount - 1]).get("isNegative");

			}

			Utils.scrollUpVertically();
			Utils.pressEnter();
			Utils.refreshScreeen();
			
			Utils.click(By.xpath(getObj("Propval1", "Cards", "Menues")), "Card Menu");
			Utils.click(By.xpath(getObj("Propval1", "DebitCard", "DebitCard_update_POS_LIMITS")), "Debit Card");
			Utils.click(By.xpath(getObj("Propval1", "updatePOS", "DebitCard_update_POS_LIMITS")), "UPdate POS Limit");

			String LandPage = Utils.getText(By.xpath(getObj("Propval1", "LandPage", "DebitCard_update_POS_LIMITS")));
			Utils.refreshScreeen();
			Log.pass("Page title is " + LandPage);

			Utils.logPassImage(TCName);

			Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "AccountNumberDropdown", "DebitCard_update_POS_LIMITS")), By.xpath(getObj("Propval1", "AccountNumber", "DebitCard_update_POS_LIMITS")), C_ACCT);
			Utils.pressKeyDown();
			Utils.pressKeyDown();
			Utils.pressEnter();
			 Utils.wait(2);
			Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "NewPOSDropdown", "DebitCard_update_POS_LIMITS")), By.xpath(getObj("Propval1", "NewPOS", "DebitCard_update_POS_LIMITS")), Limit);
			Utils.pressKeyDown();
			Utils.pressKeyDown();
			Utils.pressEnter();
			
			if (TCButton.equalsIgnoreCase("True")) {
				if (CheckBox.equalsIgnoreCase("True")) {
					// Click on the terms and Conditions CheckBox Directly//
					Utils.click(By.xpath(getObj("Propval1", "CheckBoxTC", "DebitCard_update_POS_LIMITS")), "on Terms and Conditons Button directly");
				} else if (CheckBox.equalsIgnoreCase("False")) {
					// Click on the link of Terms and Conditions//
					Utils.click(By.xpath(getObj("Propval1", "TnCpoup", "DebitCard_update_POS_LIMITS")), "which is a link of Terms and Conditions");
					// Click on I Accept Radio of the pop up//
					Utils.click(By.xpath(getObj("Propval1", "TnCAgree", "DebitCard_update_POS_LIMITS")), "which is I Accept RadioButton");

				}

			} else if (TCButton.equalsIgnoreCase("False")) {
				// Click on Proceed Button//
				Utils.click(By.xpath(getObj("Propval1", "Proceed", "DebitCard_update_POS_LIMITS")), "Proceed Button");
				try {
					// This is to validate if the user moves to the next page without selecting
					// Terms and Condition CheckBox//
					Assert.assertEquals(Utils.assertDisplayed(By.xpath(getObj("Propval1", "Confirm", "DebitCard_update_POS_LIMITS")), "Confirm"), false);
					Log.pass("Successfully validated that user is unable to complete transaction without selecting terms and conditions.");
					return true;
				} catch (AssertionError | Exception e) {
					Log.fail("Proceeded Further without clicking on Terms and Condtions");
					runResult = false;
					throw e;
				}

			}

			if (Integer.parseInt(Proceed) == 1) {

				Utils.click(By.xpath(getObj("Propval1", "Proceed", "DebitCard_update_POS_LIMITS")), "Proceed");
				Log.pass("Proceed ......");
			} else {

				Utils.click(By.xpath(getObj("Propval1", "Cancel", "DebitCard_update_POS_LIMITS")), "Cancel Proceed");
				Log.pass("Cancel Button......");
				return runResult;

			}

			if (isNegative.equalsIgnoreCase("true")) {
				try {
					// This is to validate if the user moves to the next page without selecting
					// Terms and Condition CheckBox//
					Assert.assertEquals(Utils.assertDisplayed(By.xpath(getObj("Propval1", "Confirm", "DebitCard_update_POS_LIMITS")), "false"), false);
					Log.pass("Successfully validated that user is unable to complete transaction without selecting terms and conditions.");
					Utils.logPassImage(TCName);
					return true;
				} catch (AssertionError | Exception e) {
					Log.fail("Proceeded Further without clicking on Terms and Condtions");
					runResult = false;
					throw e;
				}
			}
			if (Integer.parseInt(Confirm) == 1) {
				Log.pass("Confirm ......");
				Utils.click(By.xpath(getObj("Propval1", "Confirm", "DebitCard_update_POS_LIMITS")), "Confirm");

			} else if (Integer.parseInt(Confirm) == 2) {
				Log.pass("Confirm Modify ......");

				Utils.click(By.xpath(getObj("Propval1", "modify", "DebitCard_update_POS_LIMITS")), "Modify ");

				Utils.click(By.xpath(getObj("Propval1", "CheckBoxTC", "DebitCard_update_POS_LIMITS")), "on Terms and Conditons Button directly");
				Log.pass("modify Check Box......");

				Utils.click(By.xpath(getObj("Propval1", "Proceed", "DebitCard_update_POS_LIMITS")), "Confirm Proceed");
				Log.pass("Modify Proceed ......");

				Log.pass("Modify Confirm ......");
				Utils.click(By.xpath(getObj("Propval1", "Confirm", "DebitCard_update_POS_LIMITS")), "Modify COnfirm");

			} else {
				Utils.click(By.xpath(getObj("Propval1", "Cancel", "DebitCard_update_POS_LIMITS")), "Confirm Cancel");

				Utils.click(By.xpath(getObj("Propval1", "CancelYes", "DebitCard_update_POS_LIMITS")), "Clcik on Yes");
				Log.pass("Confirm Cancel ......");
				Utils.logPassImage(TCName);
				return runResult;
			}

			if (Integer.parseInt(OTPProceed) == 1) {
				Utils.enterOTPAndProceed("0123");
			} else {
				Utils.click(By.xpath(getObj("Propval1", "Cancel", "DebitCard_update_POS_LIMITS")), "OTP Cancel");

				Utils.click(By.xpath(getObj("Propval1", "CancelYes", "DebitCard_update_POS_LIMITS")), "OTP Cancel Yes");
				Log.pass("Confirm Cancel ......");
				Utils.logPassImage(TCName);
				return runResult;

			}

			try {
				Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "SuccessMessage", "Card")), "Success Message"));
				Log.pass("Update POS limit successfully.");
				Log.pass("Displayed message is :" + Utils.getText(By.xpath(getObj("Propval1", "SuccessMessage", "Card"))));
				Utils.logPassImage("Update POS limit-Pass");

			} catch (AssertionError | Exception e) {

				Log.fail("Update POS limit failed...Message:" + Utils.getText(By.xpath(getObj("Propval1", "failMessage", "Card"))));
				Utils.logFailImage("Update POS limit-Fail");
				throw e;
			}

			if (AfterTxfrAdditionalOptions.equalsIgnoreCase("true")) {
				// TransferModuleCommonFunctions.addFavSendEmailDownloadPdfNprintFunc(Nickname);
				Log.pass("Starting additional actions after transfer. e.g send email, print and save as favourite.");
				eCorpCommonFunctions.sendEmailDownloadExcelnPrintFunc(ScenarioCount);
				Log.pass("Additional Actions  like send email, print and download pdf/excel etc have  passed successfully.");
				Utils.logPassImage("Additional Actions");
			}

			if (Integer.parseInt(NewTxn) == 1) {
				Utils.scrollDownVertically();
				Utils.click(By.xpath(getObj("Propval1", "NewTransactionBtn", "DebitCard_update_POS_LIMITS")), "New Transaction");
				Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "proceed", "DebitCard_update_POS_LIMITS")), "New Transaction Page"));
				Log.pass("New Transaction is landed successfully");
				Utils.logPassImage(TCName);

			} else {
				Utils.click(By.xpath(getObj("Propval1", "Home", "DebitCard_update_POS_LIMITS")), "Home Button.");
				Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "HomepageSuccess", "DebitCard_update_POS_LIMITS")), "HomepageSuccess"));

				Log.pass("Home page is landed successfully");

				Utils.logPassImage(TCName);
			}

		} catch (Exception e) {

			runResult = false;
			throw e;
		}
		return runResult;
	}

}
