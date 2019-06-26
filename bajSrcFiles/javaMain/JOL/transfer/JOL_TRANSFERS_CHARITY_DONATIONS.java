package javaMain.JOL.transfer;

import static Utilities.Input.ReadTestData;
import static Utilities.ReadData.ReadDataSQL;
import static Utilities.ReadData.getObj;
import static javaMain.common_Functions.AppData.AddAnotherTxn;
import static javaMain.common_Functions.AppData.AdditionalActions;
import static javaMain.common_Functions.AppData.AuthConfirm;
import static javaMain.common_Functions.AppData.DeleteAnotherTxn;
import static javaMain.common_Functions.AppData.ExecutionTime;
import static javaMain.common_Functions.AppData.FromAcc;
import static javaMain.common_Functions.AppData.NegativeAmount;
import static javaMain.common_Functions.AppData.NewTxn;
import static javaMain.common_Functions.AppData.TransferType;
import static javaMain.common_Functions.AppData.ZeroBalAcc;
import static javaMain.common_Functions.AppData.confirmFlag;
import static javaMain.common_Functions.AppData.proceedFlag;

import org.openqa.selenium.By;
import org.testng.Assert;

import Utilities.Input;
import Utilities.Log;
import Utilities.ReadData;
import Utilities.TestBase;
import Utilities.Utils;
import javaMain.common_Functions.AppData;
import javaMain.common_Functions.OpenJOLMenues;

/**
 * Description : Functional Test Script
 * 
 * @author baj80000892
 */
public class JOL_TRANSFERS_CHARITY_DONATIONS extends TestBase {

	public static Boolean JOL_TRANSFERS_CHARITY_DONATIONS_functions(String TCName, int ScenarioCount, Object[] tCsDataset) throws Exception {

		try {

			if (isMasterClassRun) {
				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + ReadData.getJsonData(TCName, ScenarioCount, "DataSet") + "</mark>");
				ExecutionTime = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "EXEC"));
				proceedFlag = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Proceed"));
				confirmFlag = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Confirm"));
				TransferType = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "TransferType"));
				AuthConfirm = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "AuthConfirm"));
				AdditionalActions = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "AfterTxfrAdditionalOptions"));
				NewTxn = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "NewTxn"));
				AddAnotherTxn = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "AddAnotherTxn"));
				DeleteAnotherTxn = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "DeleteAnotherTxn"));
				NegativeAmount = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "NegativeAmount"));
				ZeroBalAcc = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "ZeroBalAcc"));
				
			}

			else {
				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + dataset[scenarioCount - 1] + "</mark>");
				ExecutionTime = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("EXEC"));
				proceedFlag = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Proceed"));
				confirmFlag = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Confirm"));
				TransferType = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("TransferType"));
				AuthConfirm = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("AuthConfirm"));
				AdditionalActions = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("AfterTxfrAdditionalOptions"));
				NewTxn = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("NewTxn"));
				AddAnotherTxn = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("AddAnotherTxn"));
				DeleteAnotherTxn = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("DeleteAnotherTxn"));
				NegativeAmount = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("NegativeAmount"));
				ZeroBalAcc = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("ZeroBalAcc"));
			}

			if (TransferType.equalsIgnoreCase("SarToBeneficiary")) {

				FromAcc = AppData.getFromAccountSAR();
			}

			if (TransferType.equalsIgnoreCase("ForeignToBeneficiary")) {

				FromAcc = AppData.getFromAccountForeign();
			}

			// Open Charity donations screen.
			OpenJOLMenues.openTransfersMenu("CharityDonations");

			if (ZeroBalAcc.equalsIgnoreCase("true")) {

				Log.info("Selecting zero balance account number... " + Input.ReadTestData(AppData.accountSet, "ZeroBalAccNumber"));
				Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "FromAccountDropdownDropdown", "JOL_charity")), By.xpath(getObj("Propval1", "AccountNumber", "JOL_charity")), Input.ReadTestData(AppData.accountSet, "ZeroBalAccNumber"),"From Account");
			} else {
				Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "FromAccountDropdownDropdown", "JOL_charity")), By.xpath(getObj("Propval1", "AccountNumber", "JOL_charity")), FromAcc,"From Account");
			}

			Log.pass("Selected Account Number is :" + FromAcc);

			Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "BeneficiaryDropdownDropdown", "JOL_charity")), By.xpath(getObj("Propval1", "BeneficiaryInput", "JOL_charity")), ReadTestData(TCName, "Beneficiary"), "Beneficiary");

			Log.pass("Selected Beneficiary name is :" + ReadTestData(TCName, "Beneficiary"));

			// Select Amount
			Utils.sendKeys(By.xpath(getObj("Propval1", "AmountTxt", "JOL_INTLTransfer")), ReadTestData(TCName, "DonationAmount"), "Donation Amount");

			// Enter Payment details
			Utils.sendKeys(By.xpath(getObj("Propval1", "paymentDetails", "JOL_charity")), Input.ReadTestData(TCName, "PaymentDetails"), "Payment Details");

			// Execute Time
			if (Integer.parseInt(ExecutionTime) == 1) {
				TransferModuleCommonFunctions.selectExecuteNow();
			}
			else if (Integer.parseInt(ExecutionTime) == 2) {
				TransferModuleCommonFunctions.selectScheduled();
			} else {
				TransferModuleCommonFunctions.selectStandingOrder();
			}

			// User trying to complete transaction with negative transfer amount..
			if (NegativeAmount.equalsIgnoreCase("true")) {

				Utils.sendKeys(By.xpath(getObj("Propval1", "AmountTxt", "JOL_INTLTransfer")), AppData.getAmountNegative(), " Negative Transfer Amount"); // Enter negative amoutn from account set.
				Utils.scrollDownVertically();
				Utils.click(By.xpath(getObj("Propval1", "ProceedBtn", "JOL_INTLTransfer")), "Proceed ");
				Utils.wait(3);

				try {
					Assert.assertFalse(Utils.assertDisplayed(By.xpath(getObj("Propval1", "Confirm", "JOL_INTLTransfer")), "Confirm"));
					Log.pass("User is unable to complete charity donation using negative amount as expected.");
					Utils.click(By.xpath(getObj("Propval1", "cancelButton", "JOL_INTLTransfer")), "Cancel");
					Log.pass("International transfer cancelled successfully");
					Utils.logPassImage("Transfer Result-Pass");
					return true;

				} catch (AssertionError | Exception e) {

					Log.fail("User was able to proceed with transfer even with negative amount... Test case failed.");
					Utils.logFailImage("Transfer Result-Fail");
					throw e;

				}

			}

			// User trying to complete transaction with zero balance account.
			else if (ZeroBalAcc.equalsIgnoreCase("true")) {

				Utils.sendKeys(By.xpath(getObj("Propval1", "AmountTxt", "JOL_INTLTransfer")), AppData.getAmount_International(), " Transfer Amount");
				Utils.scrollDownVertically();
				Utils.click(By.xpath(getObj("Propval1", "ProceedBtn", "JOL_INTLTransfer")), "Proceed ");
				Utils.wait(3);

				try {
					Assert.assertFalse(Utils.assertDisplayed(By.xpath(getObj("Propval1", "Confirm", "JOL_INTLTransfer")), "Confirm"));
					Log.pass("User is unable to complete charity donation from zero balance account as expected.");
					Utils.logPassImage("Transfer Result-Pass");
					return true;
				} catch (AssertionError | Exception e) {
					Log.fail("User was able to proceed with transfer even with zero balance account... Test case failed.");
					Utils.logFailImage("Transfer Result-Fail");
					throw e;
				}

			}

			if (Integer.parseInt(proceedFlag) == 1) {
				Utils.click(By.xpath(getObj("Propval1", "ProceedBtn", "JOL_charity")), "Proceed");
			}
			// Add new transaction if proceed=2 in json.
			else if (Integer.parseInt(proceedFlag) == 2) {
				// Add/delete more transactions. You can delet eonly after adding another
				// transaction. Single txn can only be cancelled.
				if (Integer.parseInt(AddAnotherTxn) > 0) {
					// Add another transaction based on the count of key AddAnotherTxn in json
					TransferModuleCommonFunctions.addAnotherCharityTxn(Integer.parseInt(AddAnotherTxn), FromAcc);
				}
				if (Integer.parseInt(DeleteAnotherTxn) > 0) {

					// Delete one of the recently added another transactions.
					TransferModuleCommonFunctions.deleteCharityTxn(Integer.parseInt(DeleteAnotherTxn));
				}
				// Click proceed after adding /deleting transaction. This proceed btn has diff x
				// path.
				Utils.click(By.xpath(getObj("Propval1", "ProceedBtnAfterAddingMultipleTxn", "JOL_charity")), "Proceed");

			}

			else if (Integer.parseInt(proceedFlag) == 3) {
				Utils.click(By.xpath(getObj("Propval1", "cancelButton", "JOL_INTLTransfer")), "Cancel");
				Log.pass("Sucessfully cancelled transactions as instructed.");
				return true;
			}

			try {

				int x = Utils.getSize(By.xpath(getObj("Propval1", "Confirm", "JOL_INTLTransfer")));
				if (x > 0) {
					Log.pass("Confirmation screen is displayed successfully");
				}
			} catch (Exception e) {

				Log.fail("Unable to confirm Charity donation. error..");
				runResult = false;
				throw e;
			}

			if (Integer.parseInt(confirmFlag) == 1) {

				Utils.click(By.xpath(getObj("Propval1", "Confirm", "JOL_INTLTransfer")), "Confirm");

			} else if (Integer.parseInt(confirmFlag) == 2) {

				Utils.click(By.xpath(getObj("Propval1", "modify", "JOL_INTLTransfer")), " Modify");
				Utils.sendKeys(By.xpath(getObj("Propval1", "AmountTxt", "JOL_INTLTransfer")), ReadTestData(TCName, "DonationAmountModify"), " Modify");
				Utils.click(By.xpath(getObj("Propval1", "ProceedBtn", "JOL_charity")), "Proceed");
				Utils.click(By.xpath(getObj("Propval1", "Confirm", "JOL_INTLTransfer")), "Confirm");
				Log.pass("Successfully confirmed the charity donation transfer");

			} else if (Integer.parseInt(confirmFlag) == 3) {

				Utils.click(By.xpath(getObj("Propval1", "cancelButton", "JOL_INTLTransfer")), "Cancel Button");
				Utils.click(By.xpath(getObj("Propval1", "yes", "JOL_INTLTransfer")), " 'Yes' on confirm cancel transaction pop up.");
				Log.pass("Successfully cancelled the charidty donation");
				Utils.logPassImage("Cancel transaction");
				runResult = false;
				return runResult;
			}

			// Auth confirm
			if (Integer.parseInt(AuthConfirm) == 1) {
				Utils.enterOTPAndProceed();
				Utils.enterOTPAndProceed();
			} else if (Integer.parseInt(AuthConfirm) == 2) {

				Utils.click(By.xpath(getObj("Propval1", "authConfirmBack", "JOL_charity")), " Back Button.");
				Utils.click(By.xpath(getObj("Propval1", "Confirm", "JOL_INTLTransfer")), "Confirm");
				Utils.enterOTPAndProceed();
				Utils.enterOTPAndProceed();
				Log.pass("Successfully confirmed the charity donation transfer");

			} else if (Integer.parseInt(AuthConfirm) == 3) {

				Utils.click(By.xpath(getObj("Propval1", "authCancel", "JOL_charity")), "Cancel Button");

				Utils.click(By.xpath(getObj("Propval1", "authCancelCancel", "JOL_charity")), " 'Cancel' on confirm cancel transaction pop up.");
				Log.pass("User is able to successfully terminate the cancelling of charity donation transaction");

				Utils.click(By.xpath(getObj("Propval1", "authCancel", "JOL_charity")), "Cancel Button");
				Utils.click(By.xpath(getObj("Propval1", "authCancelConfirm", "JOL_charity")), " 'Yes' on confirm cancel transaction pop up.");
				Log.pass("Successfully cancelled the charity donation");
				Utils.logPassImage("Cancel transaction");
				runResult = false;
				return runResult;
			}
			

			try {
				Utils.waitTillSaudiWaitIconDisappears();
				int x = Utils.getSize(By.xpath(getObj("Propval1", "SuccessMessage", "JOL_charity")));
				if (x > 0) {
					Log.pass(" Charity donation has passed .Message: " + Utils.getText(By.xpath(getObj("Propval1", "SuccessMessage", "JOL_charity"))));
				}
			} catch (Exception e) {
				Log.fail(" Charity donation has failed. Error message: " + Utils.getText(By.xpath(getObj("Propval1", "failMessage", "JOL_charity"))));
				Utils.logFailImage("Charity Donation");
				runResult = false;
				throw e;
			}


			if (AdditionalActions.equalsIgnoreCase("true")) {
				
				Log.pass("Started saving trasaction by selecting tag and entering remarks");
				// Enter tag
				Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "tagDropDown", "JOL_charity")), By.xpath(getObj("Propval1", "tagInput", "JOL_charity")), Input.ReadTestData(TCName, "TagValue"), "Tag Name");
				// Enter remarks
				Utils.sendKeys(By.xpath(getObj("Propval1", "remarksInput", "JOL_charity")), Input.ReadTestData(TCName, "Remarks"), "Remarks");

				Utils.click(By.xpath("//*[contains(@id,'dijit_form_Button_')]"), "Save transaction", 10); // will improve when get stable x path.
				Utils.wait(3);
				Utils.pressEscapeKey(4);
				
				Log.info("Starting additional actions after transfer. e.g send email, print and save as favourite.");
				TransferModuleCommonFunctions.addFavSendEmailDownloadPdfNprint();
				Log.pass("Completed additional actions");
				Utils.wait(5);
				Utils.pressEscapeKey(3);
			}

			if (NewTxn.equalsIgnoreCase("true")) {

				Utils.scrollDownVertically();
				Utils.click(By.xpath("//*[contains(@widgetid,'command')]/div[2]"), "Add new Transaction");
				Utils.wait(11);
				Utils.assertDisplayed(By.xpath(getObj("Propval1", "addanotherTransaction", "JOL_INTLTransfer")), "Add another transaction");
				Log.pass(" New transaction screen is displayed successfully");
				Utils.logPassImage("New Transaction Screen");

			}

		} catch (AssertionError | Exception e) {
			Utils.pressEscapeKey(3);
			runResult = false;
			throw e;

		}
		return runResult;
	}
}
