package javaMain.eCorp.transfer;

import static Utilities.ReadData.ReadDataSQL;
import static Utilities.ReadData.getObj;
import static javaMain.common_Functions.AppData.Account;
import static javaMain.common_Functions.AppData.AddAnotherTxn;
import static javaMain.common_Functions.AppData.AdditionalActions;
import static javaMain.common_Functions.AppData.Amount;
import static javaMain.common_Functions.AppData.CancelYes;
import static javaMain.common_Functions.AppData.Category;
import static javaMain.common_Functions.AppData.Confirm;
import static javaMain.common_Functions.AppData.DeleteAnotherTxn;
import static javaMain.common_Functions.AppData.EXEC;
import static javaMain.common_Functions.AppData.ExecutionTime;
import static javaMain.common_Functions.AppData.Frequency;
import static javaMain.common_Functions.AppData.FromAcc;
import static javaMain.common_Functions.AppData.FutureDate;
import static javaMain.common_Functions.AppData.NegativeAmount;
import static javaMain.common_Functions.AppData.NewTxn;
import static javaMain.common_Functions.AppData.NextDate;
import static javaMain.common_Functions.AppData.NickName;
import static javaMain.common_Functions.AppData.PaymentDetails;
import static javaMain.common_Functions.AppData.Proceed;
import static javaMain.common_Functions.AppData.Purpose;
import static javaMain.common_Functions.AppData.ToAcc;
import static javaMain.common_Functions.AppData.TransferType;
import static javaMain.common_Functions.AppData.TxfrAmountType;
import static javaMain.common_Functions.AppData.ZeroBalAcc;
import static javaMain.common_Functions.AppData.isTermsNconditionsChecked;
import static javaMain.common_Functions.AppData.remarks;
import static javaMain.common_Functions.AppData.saveAsFav;
import static javaMain.common_Functions.AppData.tagName;
import static javaMain.common_Functions.AppData.validateAddBeneficiaryPage;

import org.openqa.selenium.By;
import org.testng.Assert;

import Utilities.Input;
import Utilities.Log;
import Utilities.ReadData;
import Utilities.TestBase;
import Utilities.Utils;
import javaMain.common_Functions.AppData;
import javaMain.common_Functions.OpenEcorpMenues;
import javaMain.common_Functions.eCorpCommonFunctions;

/**
 * Description : Functional Test Script
 * 
 * @author baj80000892
 */
public class eCorp_Transfers_Between_My_Accounts extends TestBase {

	@SuppressWarnings("unused")
	public static Boolean eCorp_Transfers_Between_My_Accounts_Functions(String TCName, int ScenarioCount, Object[] tCsDataset) throws Exception {

		try {

			if (isMasterClassRun) {

				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + ReadData.getJsonData(TCName, ScenarioCount, "DataSet") + "</mark>");
				TransferType = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "TransferType"));
				EXEC = ReadDataSQL(TCName, ScenarioCount, "EXEC");
				AddAnotherTxn = ReadDataSQL(TCName, ScenarioCount, "AddAnotherTxn");
				DeleteAnotherTxn = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "DeleteAnotherTxn"));
				Proceed = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Proceed"));
				Confirm = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Confirm"));
				Account = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Account"));
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
				AdditionalActions = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "AdditionalActions"));
				NewTxn = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "NewTxn"));
				validateAddBeneficiaryPage = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "validateAddBeneficiaryPage"));
				saveAsFav = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "saveAsFav"));
				tagName = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "tagName"));
				remarks = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "remarks"));
				Category = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Category"));
				Purpose = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Purpose"));
				PaymentDetails = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "PaymentDetails"));
				Frequency = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Frequency"));
				NickName = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "NickName"));
				Amount = Utils.setValue(ReadDataSQL(TCName, ScenarioCount, "Amount"));

			} else {
				Log.info("<mark style='background-color: white; color: blue;font-weight:bold'>" + "Data set for this scenario is " + System.lineSeparator() + dataset[scenarioCount - 1] + "</mark>");
				TransferType = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("TransferType"));
				EXEC = (String) Utils.getUiData(dataset[scenarioCount - 1]).get("EXEC");
				AddAnotherTxn = (String) Utils.getUiData(dataset[scenarioCount - 1]).get("AddAnotherTxn");
				DeleteAnotherTxn = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("DeleteAnotherTxn"));
				Proceed = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Proceed"));
				Confirm = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Confirm"));
				Account = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Account"));
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

				AdditionalActions = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("AdditionalActions"));
				NewTxn = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("NewTxn"));
				validateAddBeneficiaryPage = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("validateAddBeneficiaryPage"));

				saveAsFav = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("saveAsFav"));
				tagName = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("tagName"));
				remarks = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("remarks"));
				Category = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Category"));
				Purpose = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Purpose"));
				PaymentDetails = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("PaymentDetails"));
				Frequency = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Frequency"));
				NickName = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("NickName"));
				Amount = Utils.setValue((String) Utils.getUiData(dataset[scenarioCount - 1]).get("Amount"));
			}

			if (TransferType.equalsIgnoreCase("SarToSar")) {

				FromAcc = AppData.getFromAccountSAR();
				ToAcc = AppData.getToAccountSAR();
			}

			else if (TransferType.equalsIgnoreCase("SarToForeign")) {

				FromAcc = AppData.getFromAccountSAR();
				ToAcc = AppData.getToAccountForeign();
			}

			else if (TransferType.equalsIgnoreCase("ForeignToSar")) {

				FromAcc = AppData.getFromAccountForeign();
				ToAcc = AppData.getToAccountSAR();

			} else if (TransferType.equalsIgnoreCase("ForeignToForeign")) {

				FromAcc = AppData.getFromAccountForeign();
				ToAcc = AppData.getToAccountForeign();
			}

			else {

				FromAcc = AppData.getFromAccountSAR();
				ToAcc = AppData.getToAccountSAR();

			}
			if (Category.equalsIgnoreCase("0")) {

				Category = Input.ReadTestData(TCName, "Category");
			}
			if (Purpose.equalsIgnoreCase("0")) {

				Purpose = Input.ReadTestData(TCName, "Purpose");
			}

			if (tagName.equalsIgnoreCase("0")) {

				tagName = Input.ReadTestData(TCName, "tagName");
			}
			if (remarks.equalsIgnoreCase("0")) {

				remarks = Input.ReadTestData(TCName, "remarks");
			}
			if (PaymentDetails.equalsIgnoreCase("0")) {

				PaymentDetails = Input.ReadTestData(TCName, "PaymentDetails");
			}
			if (Frequency.equalsIgnoreCase("0")) {

				Frequency = Input.ReadTestData(TCName, "Frequency");
			}

			if (NickName.equalsIgnoreCase("0")) {

				NickName = Input.ReadTestData(TCName, "NickName");
			}

			if (Amount.equalsIgnoreCase("0")) {

				Amount = AppData.getAmount_WithinBaj();
			}

			// Open "Between My accounts landing page to initiate transfer";
			Utils.wait(5);
			OpenEcorpMenues.openTransfersMenu("BetweenMyAccounts");
			// Select zero bal acc number if true
			if (ZeroBalAcc.equalsIgnoreCase("true")) {

				Log.pass("Selecting zero balance account number... " + Input.ReadTestData(AppData.accountSet, "ZeroBalAccNumber"));
				Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "AccountNumberDropdownDropdown", "WithinBaj_Transfers")), By.xpath(getObj("Propval1", "AccountNumber", "WithinBaj_Transfers")),
						Input.ReadTestData(AppData.accountSet, "ZeroBalAccNumber"), "from account number");
			}

			else {
				// Select from Account Number//
				Utils.wait(2);
				Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "AccountNumberDropdownDropdown", "WithinBaj_Transfers")), By.xpath(getObj("Propval1", "AccountNumber", "WithinBaj_Transfers")), FromAcc, "From account");
				Log.pass("Selected 'From'  account number is : " + FromAcc);
			}

			// Select To Account
			// *[@id='widget_dijit_form_FilteringSelect_1']//div
			// Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1",
			// "toAcctComboDropdown", "JOL_Transfers_BetweenMyAccts")),
			// By.xpath(getObj("Propval1", "ToAccInput", "JOL_Transfers_BetweenMyAccts")),
			// ToAcc, "To account");

			driver.findElement(By.xpath(getObj("Propval1", "ToAccInput", "JOL_Transfers_BetweenMyAccts"))).clear();
			driver.findElement(By.xpath(getObj("Propval1", "ToAccInput", "JOL_Transfers_BetweenMyAccts"))).sendKeys(ToAcc);
			Utils.pressKeyDown();
			Utils.pressEnter();
			Log.pass("Selected 'To' account number is : " + ToAcc);
			// Enter Amount //
			Utils.sendKeys(By.xpath(getObj("Propval1", "AmountTxt", "WithinBaj_Transfers")), Amount, "Amount ");

			if (NegativeAmount.equalsIgnoreCase("true")) {

				Log.pass("Starting negative test case. Trying to transfer negative amount- " + AppData.getAmountNegative());
				Utils.sendKeys(By.xpath(getObj("Propval1", "AmountTxt", "WithinBaj_Transfers")), AppData.getAmountNegative(), " Transfer Amount"); // Enter negative amoutn from account set.
				Utils.logPassImage("Invalid Amount");

				try {
					Assert.assertFalse(Utils.assertDisplayed(By.xpath(getObj("Propval1", "Confirm", "WithinBaj_Transfers")), "Confirm"));
					Log.pass(" User is unable to complete Between own acc  transfer with negative amount as expected.Terminating transaction.");
					Utils.logPassImage("Transfer Result-Pass");
					Utils.click(By.xpath(getObj("Propval1", "cancelButton", "WithinBaj_Transfers")), "Cancel");
					Log.pass("Between own acc  transfer cancelled successfully");

					return true;
				} catch (AssertionError | Exception e) {
					Log.fail("User was able to proceed with 'Between own acc  transfer' even with negative amount... Test case failed.");
					Utils.logFailImage("Transfer Result");
					throw e;
				}

			}

			// User trying to complete transaction with zero balance account.
			else if (ZeroBalAcc.equalsIgnoreCase("true")) {

				Utils.sendKeys(By.xpath(getObj("Propval1", "AmountTxt", "WithinBaj_Transfers")), Amount, " Transfer Amount");
				// Utils.click(By.xpath(getObj("Propval1", "CheckBox", "WithinBaj_Transfers")),
				// "terms and conditions ");
				Utils.scrollDownVertically();
				Utils.click(By.xpath(getObj("Propval1", "ProceedBtn", "WithinBaj_Transfers")), "Proceed ");
				Utils.logPassImage("Zero Balance Account");
				Utils.wait(3);

				try {
					Assert.assertFalse(Utils.assertDisplayed(By.xpath(getObj("Propval1", "Confirm", "WithinBaj_Transfers")), "Confirm"));
					Log.pass(" User is unable to complete Between own acc transfer  with zero balanac account as expected.TS passed.Terminating transaction.");
					Utils.logPassImage("Transfer Result-Pass");
					Utils.click(By.xpath(getObj("Propval1", "cancelButton", "WithinBaj_Transfers")), "Cancel");
					Log.pass("Between own acc  transfer from zero balance account cancelled successfully");
					return true;
				} catch (AssertionError | Exception e) {
					Log.fail("User was able to proceed with transfer even with zero balance account... Test case failed. Cancelling transaction.");
					Utils.logFailImage("Transfer Result-Fail");
					Utils.click(By.xpath(getObj("Propval1", "cancelButton", "WithinBaj_Transfers")), "Cancel");
					// Utils.click(By.xpath("//span[contains(text(),'Yes')]"), "Yes Button on cancel
					// transaction pop up", 10);
					throw e;
				}

			}

			// User trying to complete transaction without checking terms and conditions.

			if (!TxfrAmountType.equalsIgnoreCase("SAR")) {
				try {

					driver.findElement(By.xpath(getObj("Propval1", "TxfrAmountType", "JOL_INTLTransfer"))).click();
					Log.pass("Successfully selected  clicked  amount type radio box.Selected amount type is : " + TxfrAmountType);
				} catch (Exception e) {
					// No action. Do not throw the exception.
				}

			}

			if (Integer.parseInt(ExecutionTime) == 1) {
				eCorpCommonFunctions.selectExecuteNow();
			} else if (Integer.parseInt(ExecutionTime) == 2) {
				eCorpCommonFunctions.selectScheduled();
			} else if (Integer.parseInt(ExecutionTime) == 3) {
				eCorpCommonFunctions.selectStandingOrder();
			}

			// Add more transactions

			if (Integer.parseInt(AddAnotherTxn) > 0) {

				// Add another transaction based on the count of key AddAnotherTxn in child
				// table.
				eCorpCommonFunctions.addAnotherTxnBetweenOwnAcc(Integer.parseInt(AddAnotherTxn), Amount);

			}
			if (Integer.parseInt(DeleteAnotherTxn) > 0) {

				// Delete one of the recently added another transactions.
				eCorpCommonFunctions.deleteAnotherTxn(Integer.parseInt(DeleteAnotherTxn));
			}

			if (Integer.parseInt(Proceed) == 1) {

				if (Integer.parseInt(AddAnotherTxn) > Integer.parseInt(DeleteAnotherTxn)) {
					// Click proceed after adding /deleting transaction. This proceed btn has diff
					// xpath.
					try {
						Utils.click(By.xpath(getObj("Propval1", "ProceedBtnAfterAddingMultipleTxn", "JOL_charity")), "Proceed");
					} catch (Exception e) {

						Utils.click(By.xpath(getObj("Propval1", "ProceedBtn", "WithinBaj_Transfers")), "Proceed ");
					}
				} else {
					// Click on Proceed Button//
					Utils.wait(3);
					Utils.click(By.xpath(getObj("Propval1", "ProceedBtn", "WithinBaj_Transfers")), "Proceed ");
				}

			}

			else if (Integer.parseInt(Proceed) == 2) {
				// Click on Cancel Button//
				Utils.click(By.xpath(getObj("Propval1", "CancelTransBtn", "WithinBaj_Transfers")), "Cancel Transaction ");
				Log.pass("Successfully cancelled the transaction as required.");
				return true;
			}

			try {

				Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "ConfirmBtn", "WithinBaj_Transfers")), "Confirm"));
				Log.pass("Confirm transaction screen is displayed as expected.");
				Utils.logPassImage("Confirm screen-Pass");

			} catch (AssertionError | Exception e) {
				Log.fail("Unable to complete Between own acc  transfer.Please Verfiy Account, Beneficary, transfer date or Amount");
				Utils.logFailImage("Confirm screen-Fail");
				throw e;
			}

			if (Integer.parseInt(Confirm) == 1) {

				// Click on Confirm Button//
				Utils.click(By.xpath(getObj("Propval1", "ConfirmBtn", "WithinBaj_Transfers")), "Confirm");

			} else if (Integer.parseInt(Confirm) == 2) {

				// Click on Modify Button//
				Utils.click(By.xpath(getObj("Propval1", "ModifyBtn", "WithinBaj_Transfers")), " Modify");
				Utils.wait(2);

				// Enter Modified Amount //
				Utils.sendKeys(By.xpath(getObj("Propval1", "AmountTxt", "WithinBaj_Transfers")), AppData.getAmount_ModifyOwnAcc(), " Amount ");

				// Click on Proceed Button//
				Utils.click(By.xpath(getObj("Propval1", "ProceedBtn", "WithinBaj_Transfers")), "Proceed");

				// Click on Confirm Button//
				Utils.click(By.xpath(getObj("Propval1", "ConfirmBtn", "WithinBaj_Transfers")), "Confirm ");

			}

			else if (Integer.parseInt(Confirm) == 3) {

				// Click on Cancel Button//
				Utils.click(By.xpath(getObj("Propval1", "CancelTransBtn", "WithinBaj_Transfers")), "Cancel ");

				Integer.parseInt(CancelYes);
				if (Integer.parseInt(CancelYes) == 1) {
					// Click on Yes Button to Cancel the Transaction//

					Utils.click(By.xpath(getObj("Propval1", "CancelTransBtn_Yes", "WithinBaj_Transfers")), " Cancel Yes");

					return runResult;
				}
				// Below locators risky. TC may fail due to dynamic loctors in thi spop up.
				else if (Integer.parseInt(CancelYes) == 2) {
					// Click on NO Button //
					Utils.click(By.xpath(getObj("Propval1", "CancelTransBtn_No ", "WithinBaj_Transfers")), " Cancel- NO ");

					// Click on Confirm Button//
					Utils.click(By.xpath(getObj("Propval1", "ConfirmBtn", "WithinBaj_Transfers")), "Confirm ");

				}

			}

			try {
				Assert.assertTrue(Utils.assertDisplayed(By.xpath(getObj("Propval1", "SuccessMessage", "JOL_Transfers_BetweenMyAccts")), "Success Message"));
				Log.pass("Between own acc  transfer completed successfully.");
				Utils.logPassImage("Transfer Result-Pass");

			} catch (AssertionError | Exception e) {

				Log.fail(" Between own acc transfer  failed...Message:" + Utils.getText(By.xpath(getObj("Propval1", "failMessage", "JOL_Transfers_BetweenMyAccts"))));
				Utils.logFailImage("Transfer Result-Fail");
				throw e;
			}

			if (saveAsFav.equalsIgnoreCase("true")) {
				// Enter tag

				Log.pass("Successfully started saving the transaction");

				Utils.clickDropdownAndSendValue(By.xpath(getObj("Propval1", "tagDropDown", "JOL_charity")), By.xpath(getObj("Propval1", "tagInput", "JOL_charity")), tagName, "Tag Name");
				// Enter remarks
				Utils.sendKeys(By.xpath(getObj("Propval1", "remarksInput", "JOL_charity")), remarks, "Remarks");
				Utils.click(By.xpath("//*[@id='dijit_form_Button_8_label']"), "Save transaction", 10); // will improve when get stable x path.
				Utils.wait(3);
				Utils.pressEscapeKey(2);

			}

			// AFter transfer actions like send email, print pdf, save as favourite etc.
			if (AdditionalActions.equalsIgnoreCase("true")) {

				Log.pass("Starting additional actions after transfer. e.g send email, print and save as favourite.");
				eCorpCommonFunctions.SendEmailDownloadPdfNprintFunc();

			}

			if (Integer.parseInt(NewTxn) == 1) {
				Utils.scrollDownVertically();
				Utils.click(By.xpath("//*[contains(@widgetid,'command')]/div[2]"), "Add new Transaction");
				Utils.wait(11);
				Utils.assertDisplayed(By.xpath(getObj("Propval1", "addanotherTransaction", "WithinBaj_Transfers")), "Add another transaction");
				Log.pass(" New transaction screen is displayed successfully");
				Utils.logPassImage("New Transaction");
			}
		} catch (AssertionError | Exception e) {
			runResult = false;
			throw e;

		}

		return runResult;

	}

}
