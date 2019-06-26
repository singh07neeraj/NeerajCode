package javaMain.JOL.debitCard;

import static Utilities.Input.ReadTestData;
import static Utilities.ReadData.ReadDataSQL;
import static Utilities.ReadData.getObj;

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
public class JOL_DEBIT_CARDS_ReplaceADebitCard_FUNC extends TestBase {

	public static Boolean ReplaceADebitCard(String TCName, int ScenarioCount, Object[] tCsDataset) throws Exception {

		String OTPProceed, Proceed, Confirm, DebitCard, City, State, Street, Reason, TCButton, CheckBox, NewTxn, AfterTxfrAdditionalOptions;

		try {
			if (isMasterClassRun) {

				Log.info("Data set for this scenario is " + System.lineSeparator() + ReadData.getJsonData(TCName, ScenarioCount, "DataSet"));

				OTPProceed = ReadDataSQL(TCName, ScenarioCount, "OTPProceed");

				Proceed = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Proceed"));
				Confirm = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Confirm"));
				DebitCard = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "DebitCard"));
				City = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "City"));
				State = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "State"));
				Street = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Street"));
				Reason = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Reason"));
				TCButton = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "TCButton"));
				CheckBox = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "CheckBox"));
				NewTxn = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "NewTxn"));
				AfterTxfrAdditionalOptions = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "AfterTxfrAdditionalOptions"));

			} else {
				Log.info("Data set for this scenario is " + System.lineSeparator() + dataset[scenarioCount - 1]);

				OTPProceed = (String) Utils.getUiData(dataset[scenarioCount - 1]).get("OTPProceed");

				Proceed = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Proceed"));
				Confirm = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Confirm"));
				DebitCard = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("DebitCard"));
				City = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("City"));
				State = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("State"));
				Street = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Street"));
				Reason = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Reason"));
				TCButton = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("TCButton"));
				CheckBox = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("CheckBox"));
				NewTxn = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("NewTxn"));
				AfterTxfrAdditionalOptions = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("AfterTxfrAdditionalOptions"));

			}

			Utils.refreshScreeen();
			Utils.pressEnter();
			Utils.scrollUpVertically();

			Utils.click(By.xpath(getObj("Propval1", "Cards", "Menues")), "Card Menu");
			Utils.wait(6);

			Utils.click(By.xpath(getObj("Propval1", "DebitCard", "DebitCard_ReplaceADebitCard")), "Debit Card");
			Utils.wait(6);
			Utils.click(By.xpath(getObj("Propval1", "ReplaceCard", "DebitCard_ReplaceADebitCard")), "Replace Card ");
			Utils.pressEnter();
			Log.pass("Successful ReplaceADebitCard ");

			String LandPage = Utils.getText(By.xpath(getObj("Propval1", "LandPage", "DebitCard_ReplaceADebitCard")));

			Log.pass("Page title is " + "'" + LandPage + "'");

			Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "DebitCardDropdown", "DebitCard_ReplaceADebitCard")), By.xpath(getObj("Propval1", "DebitCardType", "DebitCard_ReplaceADebitCard")), ReadTestData(TCName, "DebitCard"));

			Log.pass("Debit Card Number is : " + "'" + ReadTestData(TCName, "DebitCard") + "'");

			Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "replacementDropdown", "DebitCard_ReplaceADebitCard")), By.xpath(getObj("Propval1", "Replacement", "DebitCard_ReplaceADebitCard")), ReadTestData(TCName, "Reason"));

			Log.pass("Selected Frequency is : " + "'" + ReadDataSQL(TCName, ScenarioCount, "Frequency") + "'");

			Utils.sendKeys_DD(By.xpath(getObj("Propval1", "City", "DebitCard_ReplaceADebitCard")), ReadTestData(TCName, "City"));
			Log.pass("Enter City ");

			Utils.sendKeys(By.xpath(getObj("Propval1", "Area", "DebitCard_ReplaceADebitCard")), ReadTestData(TCName, "State"));
			Log.pass("Enter Area ");

			Utils.sendKeys(By.xpath(getObj("Propval1", "street", "DebitCard_ReplaceADebitCard")), ReadTestData(TCName, "Street"));
			Log.pass("Enter street ");

			System.out.println("ChecBox Value " + getObj("Propval1", "Conditioncheck", "RequestASupplementaryCard"));

			if (TCButton.equalsIgnoreCase("True")) {
				if (CheckBox.equalsIgnoreCase("True")) {
					// Click on the terms and Conditions CheckBox Directly//
					Utils.click(By.xpath(getObj("Propval1", "CheckBoxTC", "ApplyCreditCard")), "on Terms and Conditons Button directly");
				} else if (CheckBox.equalsIgnoreCase("False")) {
					// Click on the link of Terms and Conditions//
					Utils.click(By.xpath(getObj("Propval1", "TnCpoup", "ApplyCreditCard")), "which is a link of Terms and Conditions");
					// Click on I Accept Radio of the pop up//
					Utils.click(By.xpath(getObj("Propval1", "TnCAgree", "ApplyCreditCard")), "which is I Accept RadioButton");

				}
				Utils.pressEnter();
			} else if (TCButton.equalsIgnoreCase("False")) {
				// Click on Proceed Button//
				Utils.click(By.xpath(getObj("Propval1", "Proceed", "ApplyCreditCard")), "Proceed Button");
				try {
					// System.out.println(Utils.assertDisplayed(By.xpath(getObj("Propval1",
					// "CreditcardTxt", "ApplyCreditCard")),"false"));
					// This is to validate if the user moves to the next page without selecting
					// Terms and Condition CheckBox//
					Assert.assertEquals(Utils.assertDisplayed(By.xpath(getObj("Propval1", "Confirm", "ApplyCreditCard")), "Confirm"), false);
					Log.pass("Successfully validated that user is unable to complete transaction without selecting terms and conditions.");
					return true;
				} catch (AssertionError | Exception e) {
					Log.fail("Proceeded Further without clicking on Terms and Condtions");
					runResult = false;
					throw e;
				}

			}

			try {
				Utils.click(By.xpath(getObj("Propval1", "Accept", "DebitCard_ReplaceADebitCard")), "Accept");

			} catch (Exception e) {

			}

			if (Integer.parseInt(Proceed) == 1) {

				Utils.click(By.xpath(getObj("Propval1", "Proceed", "DebitCard_ReplaceADebitCard")), "Proceed");
				Log.pass("Proceed ......");
			} else {

				Utils.click(By.xpath(getObj("Propval1", "Cancel", "DebitCard_ReplaceADebitCard")), "Cancel Proceed");
				Log.pass("Cancel Button......");
				return runResult;

			}

			if (Integer.parseInt(Confirm) == 1) {
				Log.pass("Confirm ......");
				Utils.click(By.xpath(getObj("Propval1", "Confirm", "DebitCard_ReplaceADebitCard")), "Confirm");

			} else if (Integer.parseInt(Confirm) == 2) {
				Log.pass("Confirm Modify ......");

				Utils.click(By.xpath(getObj("Propval1", "modify", "DebitCard_ReplaceADebitCard")), "Modify ");

				Utils.click(By.xpath(getObj("Propval1", "Conditioncheck", "DebitCard_ReplaceADebitCard")), "Confirm Condtion Check");
				Log.pass("modify Check Box......");

				Utils.wait(2);
				try {
					Utils.click(By.xpath(getObj("Propval1", "Accept", "DebitCard_ReplaceADebitCard")), "Accept");

				} catch (Exception e) {
				}
				Utils.wait(2);

				Utils.click(By.xpath(getObj("Propval1", "Proceed", "DebitCard_ReplaceADebitCard")), "Confirm Proceed");
				Log.pass("Modify Proceed ......");

				Log.pass("Modify Confirm ......");
				Utils.click(By.xpath(getObj("Propval1", "Confirm", "DebitCard_ReplaceADebitCard")), "Modify COnfirm");

			} else {
				Utils.click(By.xpath(getObj("Propval1", "Cancel", "DebitCard_ReplaceADebitCard")), "Confirm Cancel");

				Utils.click(By.xpath(getObj("Propval1", "CancelYes", "DebitCard_ReplaceADebitCard")), "Clcik on Yes");
				Log.pass("Confirm Cancel ......");
				Utils.logPassImage(TCName);
				return runResult;
			}
			Utils.wait(6);

			if (Integer.parseInt(OTPProceed) == 1) {
				Utils.enterOTPAndProceed("0123");
			} else {
				Utils.click(By.xpath(getObj("Propval1", "Cancel", "DebitCard_ReplaceADebitCard")), "OTP Cancel");

				Utils.click(By.xpath(getObj("Propval1", "CancelYes", "DebitCard_ReplaceADebitCard")), "OTP Cancel Yes");
				Log.pass("Confirm Cancel ......");
				Utils.logPassImage(TCName);
				return runResult;

			}

			try {
				Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "SuccessMessage", "Card")), "Success Message"));
				Log.pass("Replace debit card successfully.");
				Log.pass("Display message is :" + Utils.getText(By.xpath(getObj("Propval1", "SuccessMessage", "Card"))));
				Utils.logPassImage("Replace debit card-Pass");

			} catch (AssertionError | Exception e) {

				Log.fail("Replace debit card...Message:" + Utils.getText(By.xpath(getObj("Propval1", "failMessage", "Card"))));
				Utils.logFailImage("Replace debit card-Fail");
				throw e;
			}

			if (AfterTxfrAdditionalOptions.equalsIgnoreCase("true")) {
				Log.pass("Starting additional actions after transfer. e.g send email, print and save as favourite.");
				eCorpCommonFunctions.sendEmailDownloadExcelnPrintFunc(ScenarioCount);
				Log.pass("Additional Actions  like send email, print and download pdf/excel etc have  passed successfully.");
				Utils.logPassImage("Additional Actions");
			}
			if (NewTxn.equalsIgnoreCase("NewTransactionBtn")) {
				Utils.scrollDownVertically();
				Utils.click(By.xpath(getObj("Propval1", "NewTransactionBtn", "RequestASupplementaryCard")), "New Transaction");
				Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "proceed", "RequestASupplementaryCard")), "proceed"));
				Log.pass("New Transaction is landed successfully");
				Utils.logPassImage(TCName);
				Log.pass("New Transaction is landed successfully");

			} else {
				Utils.click(By.xpath(getObj("Propval1", "Home", "RequestASupplementaryCard")), "Home Button");
				Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "HomepageSuccess", "RequestASupplementaryCard")), "HomepageSuccess"));

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
