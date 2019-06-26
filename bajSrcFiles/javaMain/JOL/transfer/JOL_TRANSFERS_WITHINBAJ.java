package javaMain.JOL.transfer;

import static Utilities.ReadData.ReadDataSQL;
import static Utilities.ReadData.getObj;
import static javaMain.common_Functions.AppData.AddAnotherTxn;
import static javaMain.common_Functions.AppData.AdditionalActions;
import static javaMain.common_Functions.AppData.CancelYes;
import static javaMain.common_Functions.AppData.Confirm;
import static javaMain.common_Functions.AppData.DeleteAnotherTxn;
import static javaMain.common_Functions.AppData.ExecutionTime;
import static javaMain.common_Functions.AppData.FromAcc;
import static javaMain.common_Functions.AppData.FutureDate;
import static javaMain.common_Functions.AppData.NegativeAmount;
import static javaMain.common_Functions.AppData.NewTxn;
import static javaMain.common_Functions.AppData.NextDate;
import static javaMain.common_Functions.AppData.Proceed;
import static javaMain.common_Functions.AppData.TransferType;
import static javaMain.common_Functions.AppData.TxfrAmountType;
import static javaMain.common_Functions.AppData.ZeroBalAcc;
import static javaMain.common_Functions.AppData.isTermsNconditionsChecked;
import static javaMain.common_Functions.AppData.validateAddBeneficiaryPage;

import org.openqa.selenium.By;
import org.testng.Assert;

import Utilities.Input;
import Utilities.Log;
import Utilities.ReadData;
import Utilities.TestBase;
import Utilities.Utils;
import javaMain.common_Functions.AppData;
import javaMain.common_Functions.OpenJOLMenues;

public class JOL_TRANSFERS_WITHINBAJ extends TestBase {

	public static boolean JOL_TRANSFERS_WITHINBAJ_Func(String TCName, int ScenarioCount, Object[] tCsDataset) throws Exception {

		try {

			if (isMasterClassRun) {

				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + ReadData.getJsonData(TCName, ScenarioCount, "DataSet") + "</mark>");
				TransferType = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "TransferType"));
				ExecutionTime = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "EXEC"));
				NextDate = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "NextDate"));
				FutureDate = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "FutureDate"));
				Proceed = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Proceed"));
				Confirm = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Confirm"));
				CancelYes = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "CancelYes"));
				AddAnotherTxn = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "AddAnotherTxn"));
				DeleteAnotherTxn = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "DeleteAnotherTxn"));
				TxfrAmountType = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "TxfrAmountType"));
				ZeroBalAcc = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "ZeroBalAcc"));
				NegativeAmount = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "NegativeAmount"));
				isTermsNconditionsChecked = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "isTermsNconditionsChecked"));
				AdditionalActions = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "AfterTxfrAdditionalOptions"));
				NewTxn = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "NewTxn"));
				validateAddBeneficiaryPage = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "validateAddBeneficiaryPage"));

			} else {
				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + dataset[scenarioCount - 1] + "</mark>");
				TransferType = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("TransferType"));
				ExecutionTime = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("EXEC"));
				NextDate = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("NextDate"));
				FutureDate = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("FutureDate"));
				Proceed = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Proceed"));
				Confirm = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Confirm"));
				CancelYes = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("CancelYes"));
				AddAnotherTxn = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("AddAnotherTxn"));
				DeleteAnotherTxn = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("DeleteAnotherTxn"));
				TxfrAmountType = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("TxfrAmountType"));
				ZeroBalAcc = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("ZeroBalAcc"));
				NegativeAmount = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("NegativeAmount"));
				isTermsNconditionsChecked = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("isTermsNconditionsChecked"));
				AdditionalActions = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "AfterTxfrAdditionalOptions"));
				NewTxn = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "NewTxn"));
				validateAddBeneficiaryPage = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "validateAddBeneficiaryPage"));
			}

			if (TransferType.equalsIgnoreCase("SarToBeneficiary")) {

				FromAcc = AppData.getFromAccountSAR();
			}

			if (TransferType.equalsIgnoreCase("ForeignToBeneficiary")) {

				FromAcc = AppData.getFromAccountForeign();
			}

			OpenJOLMenues.openTransfersMenu("WithinBaj_Transfers");

			// Select zero bal acc number if true
			if (ZeroBalAcc.equalsIgnoreCase("true")) {

				Log.pass("Selecting zero balance account number... " + Input.ReadTestData(AppData.accountSet, "ZeroBalAccNumber"));
				Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "AccountNumberDropdownDropdown", "WithinBaj_Transfers")), By.xpath(getObj("Propval1", "AccountNumber", "WithinBaj_Transfers")),
						Input.ReadTestData(AppData.accountSet, "ZeroBalAccNumber"), "From account");
			}

			else {
				// Select Account Number//
				Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "AccountNumberDropdownDropdown", "WithinBaj_Transfers")), By.xpath(getObj("Propval1", "AccountNumber", "WithinBaj_Transfers")), FromAcc, "From Account");
			}

			// ..............................
			// click add beneficiary and then add beneficiary.
			if (validateAddBeneficiaryPage.equalsIgnoreCase("true")) {

				try {
					Utils.click(By.xpath("//*[@class='i i-add']"), "Add new Beneficiary");
					Utils.assertTrue(Utils.assertDisplayed(By.xpath("//*[contains(@id,'aljazira_TransactionStepsBar_0')]"), "Add new Beneficiary"), true);
					Log.pass("Add new Beneficiary screen is opened successfully. Exiting the test case flow.");
					return true;
				}

				catch (AssertionError | Exception e) {
					Log.fail("Unable to open  Add new Beneficiary screen...error..");
					throw e;
				}
			}

			// Select Beneficiary
			Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "BeneficiaryDropdownDropdown", "LocalTransfers")), By.xpath(getObj("Propval1", "Beneficiary", "LocalTransfers")), AppData.getBeneficiary_WithinBaj(), "Beneficiary");
			Log.pass("Enter Beneficiary name is :" + AppData.getBeneficiary_WithinBaj());
			// Enter Amount //
			Utils.sendKeys(By.xpath(getObj("Propval1", "AmountTxt", "WithinBaj_Transfers")), AppData.getAmount_WithinBaj(), "Amount_WithinBaj");

			// Enter Category type
			Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "category", "WithinBaj_Transfers")), By.xpath(getObj("Propval1", "categoryInput", "WithinBaj_Transfers")), Input.ReadTestData(TCName, "Category"), "Category");
			// Enter Purpose
			Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "purposeDropdown", "WithinBaj_Transfers")), By.xpath(getObj("Propval1", "purposeInput", "WithinBaj_Transfers")), Input.ReadTestData(TCName, "Purpose"), "Purpose");
			// Enter Payment details
			Utils.sendKeys(By.xpath(getObj("Propval1", "paymentDetails", "WithinBaj_Transfers")), Input.ReadTestData(TCName, "PaymentDetails"), "Payment Details");

			if (NegativeAmount.equalsIgnoreCase("true")) {

				Utils.sendKeys(By.xpath(getObj("Propval1", "AmountTxt", "WithinBaj_Transfers")), AppData.getAmountNegative(), " Transfer Amount"); // Enter negative amoutn from account set.
				Utils.logPassImage("Invalid Amount");
				Utils.click(By.xpath(getObj("Propval1", "CheckBox", "WithinBaj_Transfers")), "terms and conditions ");

				try {
					Assert.assertFalse(Utils.assertDisplayed(By.xpath(getObj("Propval1", "Confirm", "WithinBaj_Transfers")), "Confirm"));
					Log.pass(" User is unable to complete within BAJ  transfer with negative amount as expected.Terminating transaction.");
					Utils.logPassImage("Transfer Result-Pass");
					Utils.click(By.xpath(getObj("Propval1", "cancelButton", "WithinBaj_Transfers")), "Cancel");
					Log.pass("Within Baj transfer cancelled successfully");

					return true;
				} catch (AssertionError | Exception e) {
					Log.fail("User was able to proceed with transfer even with negative amount... Test case failed.");
					Utils.logFailImage("Transfer Result");
					throw e;
				}

			}

			// User trying to complete transaction with zero balance account.
			else if (ZeroBalAcc.equalsIgnoreCase("true")) {

				Utils.sendKeys(By.xpath(getObj("Propval1", "AmountTxt", "WithinBaj_Transfers")), AppData.getAmount_WithinBaj(), " Transfer Amount");
				Utils.click(By.xpath(getObj("Propval1", "CheckBox", "WithinBaj_Transfers")), "terms and conditions ");
				Utils.scrollDownVertically();
				Utils.click(By.xpath(getObj("Propval1", "ProceedBtn", "WithinBaj_Transfers")), "Proceed ");
				Utils.logPassImage("Zero Balance Account");
				Utils.wait(3);

				try {
					Assert.assertFalse(Utils.assertDisplayed(By.xpath(getObj("Propval1", "Confirm", "WithinBaj_Transfers")), "Confirm"));
					Log.pass(" User is unable to complete international transfer with zero balanac account as expected.Terminating transaction.");
					Utils.logPassImage("Transfer Result-Pass");
					Utils.click(By.xpath(getObj("Propval1", "cancelButton", "WithinBaj_Transfers")), "Cancel");
					Log.pass("International transfer from zero balance account cancelled successfully");
					return true;
				} catch (AssertionError | Exception e) {
					Log.fail("User was able to proceed with transfer even with zero balance account... Test case failed.");
					Utils.logFailImage("Transfer Result-Fail");
					// Click on Confirm Button//
					Utils.click(By.xpath(getObj("Propval1", "ConfirmBtn", "WithinBaj_Transfers")), " Confirm");
					throw e;
				}

			}

			// User trying to complete transaction without checking terms and conditions.
			else if (isTermsNconditionsChecked.equalsIgnoreCase("false")) {

				Utils.sendKeys(By.xpath(getObj("Propval1", "AmountTxt", "WithinBaj_Transfers")), AppData.getAmount_WithinBaj(), " Transfer Amount");
				Utils.click(By.xpath(getObj("Propval1", "ProceedBtn", "WithinBaj_Transfers")), "Proceed ");
				Utils.scrollDownVertically();
				Utils.wait(3);

				try {
					Assert.assertFalse(Utils.assertDisplayed(By.xpath(getObj("Propval1", "Confirm", "WithinBaj_Transfers")), "Confirm"));
					Log.pass(" User is unable to complete international transfer without accepting terms and conditions as expected.Terminating transaction.");
					Utils.logPassImage("Transfer Screen");
					Utils.click(By.xpath(getObj("Propval1", "cancelButton", "WithinBaj_Transfers")), "Cancel");
					Log.pass("WithinBaj_Transfers  cancelled successfully");
					return true;
				} catch (AssertionError | Exception e) {
					Log.fail("User was able to proceed with transfer even with zero balance account... Test case failed.");
					Utils.logFailImage("Transfer Result-Fail");
					// Click on Confirm Button//
					Utils.click(By.xpath(getObj("Propval1", "ConfirmBtn", "WithinBaj_Transfers")), " Confirm");
					throw e;
				}

			}

			if (!TxfrAmountType.equalsIgnoreCase("SAR")) {
				Utils.clickSafely(By.xpath(getObj("Propval1", "TxfrAmountType", "JOL_INTLTransfer")), "transfer amount type radio box.");

			}

			// Execute Time
			if (Integer.parseInt(ExecutionTime) == 1) {
				TransferModuleCommonFunctions.selectExecuteNow();
			} else if (Integer.parseInt(ExecutionTime) == 2) {
				TransferModuleCommonFunctions.selectScheduled();
			} else {
				TransferModuleCommonFunctions.selectStandingOrder();
			}

			// Click on Terms and Conditions CheckBox //
			Utils.click(By.xpath(getObj("Propval1", "CheckBoxTC", "WithinBaj_Transfers")), "Terms and conditions Check Box");

			// Add more transactions

			if (Integer.parseInt(AddAnotherTxn) > 0) {

				// Add another transaction based on the count of key AddAnotherTxn in child
				// table.
				TransferModuleCommonFunctions.addAnotherTxnWithinBaj(Integer.parseInt(AddAnotherTxn));

			}
			if (Integer.parseInt(DeleteAnotherTxn) > 0) {

				// Delete one of the recently added another transactions.
				TransferModuleCommonFunctions.deleteAnotherTxn(Integer.parseInt(DeleteAnotherTxn));
			}

			if (Integer.parseInt(Proceed) == 1) {

				if (Integer.parseInt(AddAnotherTxn) > 0) {
					// Click proceed after adding /deleting transaction. This proceed btn has diff x
					// path.
					Utils.click(By.xpath(getObj("Propval1", "ProceedBtnAfterAddingMultipleTxn", "JOL_charity")), "Proceed");
				}

				else {

					// Click on Proceed Button//
					Utils.click(By.xpath(getObj("Propval1", "ProceedBtn", "WithinBaj_Transfers")), "Proceed ");
				}

			}

			else if (Integer.parseInt(Proceed) == 2) {

				// Click on Cancel Button//
				Utils.click(By.xpath(getObj("Propval1", "CancelTransBtn", "WithinBaj_Transfers")), "Cancel Transaction ");
				Log.pass("Successfully cancelled the transaction as required.");
				return runResult;

			}

			else {
				// Click on Proceed Button//
				Utils.click(By.xpath(getObj("Propval1", "ProceedBtn", "WithinBaj_Transfers")), "Proceed ");
			}

			try {
				Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "ConfirmBtn", "WithinBaj_Transfers")), "Confirm"));
				Log.pass("Confirm transaction screen is displayed as expected.");
				Utils.logPassImage("Transfer Result-Pass");

			} catch (AssertionError | Exception e) {
				Log.fail("Unable to complete transfer.Please Verfiy Account Beneficary or Amount");
				Utils.logFailImage("Transfer Result-Fail");
				throw e;
			}

			if (Integer.parseInt(Confirm) == 1) {

				// Click on Confirm Button//
				Utils.click(By.xpath(getObj("Propval1", "ConfirmBtn", "WithinBaj_Transfers")), "Click on Confirm");

			} else if (Integer.parseInt(Confirm) == 2) {

				// Click on Modify Button//
				Utils.click(By.xpath(getObj("Propval1", "ModifyBtn", "WithinBaj_Transfers")), "Click on Modify");
				Utils.wait(5);

				// Enter Modified Amount //
				Utils.sendKeys(By.xpath(getObj("Propval1", "AmountTxt", "WithinBaj_Transfers")), AppData.getAmount_WithinBajModify(), "Amount_WithinBajModify");

				// Click on Terms and Conditions CheckBox //
				Utils.click(By.xpath(getObj("Propval1", "CheckBoxTC", "WithinBaj_Transfers")), "Click on Check BOx");

				// Click on Proceed Button//
				Utils.click(By.xpath(getObj("Propval1", "ProceedBtn", "WithinBaj_Transfers")), "Click on Proceed");

				// Click on Confirm Button//
				Utils.click(By.xpath(getObj("Propval1", "ConfirmBtn", "WithinBaj_Transfers")), "Click on Confirm ");

			}

			else if (Integer.parseInt(Confirm) == 3) {

				// Click on Cancel Button//
				Utils.click(By.xpath(getObj("Propval1", "CancelTransBtn", "WithinBaj_Transfers")), "Click on Cancel ");

				Integer.parseInt(CancelYes);
				if (Integer.parseInt(CancelYes) == 1) {
					// Click on Yes Button to Cancel the Transaction//

					Utils.click(By.xpath(getObj("Propval1", "CancelTransBtn_Yes", "WithinBaj_Transfers")), "Click on Cancel Yes");

					return runResult;
				}

				else if (Integer.parseInt(CancelYes) == 2) {
					// Click on NO Button //
					Utils.click(By.xpath(getObj("Propval1", "CancelTransBtn_No ", "WithinBaj_Transfers")), "Click on Cancel NO ");

					// Click on Confirm Button//
					Utils.click(By.xpath(getObj("Propval1", "ConfirmBtn", "WithinBaj_Transfers")), "Click on Confirm ");

				}

			}

			Utils.enterOTPAndProceed();

			try {
				Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "SuccessMessage", "Card")), "Success Message"));
				Log.pass("Within BAJ transfer completed successfully.");
				Utils.logPassImage("Transfer Result-Pass");

			} catch (AssertionError | Exception e) {

				Log.fail(" Within BAJ transfer failed...Message:" + Utils.getText(By.xpath(getObj("Propval1", "failMessage", "Card"))));
				Utils.logFailImage("Transfer Result-Fail");
				throw e;
			}

			if (AdditionalActions.equalsIgnoreCase("true")) {
				Log.pass("Started saving trasaction by selecting tag and entering remarks");
				// Enter tag
				Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "tagDropDown", "JOL_charity")), By.xpath(getObj("Propval1", "tagInput", "JOL_charity")), Input.ReadTestData(TCName, "TagValue"), "Tag Name");
				// Enter remarks
				Utils.sendKeys(By.xpath(getObj("Propval1", "remarksInput", "JOL_charity")), Input.ReadTestData(TCName, "Remarks"), "Remarks");
				Utils.clickSafely(By.xpath("//*[contains(@id,'dijit_form_Button_')]"), "Save transaction"); // will improve when get stable x path.
				Utils.pressEscapeKey(3);
				Log.pass("Starting additional actions after transfer. e.g send email, print and save as favourite.");
				TransferModuleCommonFunctions.addFavSendEmailDownloadPdfNprintFunc(Input.ReadTestData(TCName, "NickName"));
			}

			if (Integer.parseInt(NewTxn) == 1) {
				Utils.wait(5);
				Utils.scrollDownVertically();
				Utils.pressEscapeKey(2);
				Utils.wait(3);
				Utils.clickSafely(By.xpath("//*[contains(@widgetid,'command')]/div[2]"), "Add new Transaction");
				Utils.clickSafely(By.xpath("//*[contains(@widgetid,'command')]/div[2]"), "Add new Transaction");
				Utils.wait(7);
				Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "addanotherTransaction", "WithinBaj_Transfers")), "Add another transaction"));
				Utils.logPassImage("New Transaction");
			}

		} catch (AssertionError | Exception e) {
			runResult = false;
			throw e;

		}

		return runResult;

	}

}
